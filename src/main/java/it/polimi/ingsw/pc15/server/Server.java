package it.polimi.ingsw.pc15.server;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observer;
import java.util.concurrent.ArrayBlockingQueue;

import it.polimi.ingsw.pc15.ParserXML;
import it.polimi.ingsw.pc15.client.RMIHandler;
import it.polimi.ingsw.pc15.client.RMIHandlerInterface;
import it.polimi.ingsw.pc15.client.SocketHandler;
import it.polimi.ingsw.pc15.controller.Controller;
import it.polimi.ingsw.pc15.model.Model;
import it.polimi.ingsw.pc15.model.StatoPartita;
import it.polimi.ingsw.pc15.player.Player;

public class Server extends UnicastRemoteObject implements ServerInterface {

	private final static int PORT = 12879;
	private transient ServerSocket serverSocket;
	private ArrayList<RMIView> rmiViews;
	private HashMap<String, ServerView> views;
	private int numeroGiocatori;
	private ArrayList<Partita> partite;
	private transient Thread timerThread;
	
	public Server() throws IOException {
		this.serverSocket = new ServerSocket(PORT);
		this.rmiViews = new ArrayList<RMIView>();
		this.views = new HashMap<String, ServerView>();
		this.numeroGiocatori = 0;
		this.partite = new ArrayList<Partita>();
	}


	public void run() throws InterruptedException {
		
		////////////////////RMI///////////////////////////////////////
		
		try {
			LocateRegistry.createRegistry(1099);
		} catch (RemoteException e) {
			System.out.println("Registry giÃ  presente!");			
		}	
		
		try {
			Naming.rebind("Server", this);																  
		} catch (MalformedURLException e) {
			System.err.println("Impossibile registrare l'oggetto indicato!");
		} catch (RemoteException e) {
			System.err.println("Errore di connessione: " + e.getMessage() + "!");
		}	
		
		System.out.println("Server avviato!\nIn attesa di giocatori...");
		
		//////////////////////////////////////////////////////////////////
		
		///////////////////////SOCKET/////////////////////////////////////

		while (true) {     //NOSONAR
		try {
				Socket newSocket = serverSocket.accept();
				SocketView view = new SocketView(newSocket, this);	
				new Thread(view).start();
			} 
			
			catch (IOException e) {
				System.out.println("Errore di connessione!");
			}
		}	
		
		//////////////////////////////////////////////////////////////////
			
	}
	
	public synchronized void connetti(ServerView view, String name){
		
		views.put(name, view);
		System.out.println("Giocatore connnesso: " + name);
		numeroGiocatori++;
		if (numeroGiocatori==ParserXML.leggiValore("numeroMinGiocatori")) {
			ServerTimer timer = new ServerTimer(this);
			timerThread = new Thread(timer);
			timerThread.start();
		}
		if (numeroGiocatori==ParserXML.leggiValore("numeroMaxGiocatori")) {
			timerThread.interrupt();
			avviaPartita();
			
		}
	}

	
	public static void main(String[] args) throws InterruptedException {
		
		Server server;
		
		try {
			server = new Server();
			server.run();
		} catch (Exception e) {
			System.err.println("Impossibile inizializzare il server: " + e.getMessage() + "!");
		}	

	}
	
	/**
	 * avvia una nuova RMIView, registrandola nell'array del server e passandole
	 * l'RMIHandler come parametro
	 * Ritorna l'indice della view nell'array
	 */

	@Override
	public int remoteConnetti(RMIHandlerInterface rmiHandler) throws RemoteException {
		RMIView rmiView = new RMIView(rmiHandler);
		new Thread(rmiView).start();
		this.rmiViews.add(rmiView);
		connetti(rmiView, rmiHandler.remoteGetNome());
		return rmiViews.lastIndexOf(rmiView);
	}

	
	/**
	 * Invoca il metodo notifyObservers della RMIVIew di indice i
	 * 
	 * @param o oggetto da notificare tramite il notifyObservers()
	 * @param i indice della RMIView nell'array del server
	 */

	@Override
	public void remoteNotify(Object o, int i) throws RemoteException {
		ArrayList<String> message = (ArrayList<String>)o;
		this.rmiViews.get(i).notificaOsservatori(message);
		
	}
	
	/**
	 * Crea un nuovo oggetto di tipo Partita, lo aggiunge
	 * all'array di partite del server e ne chiama il metodo avvia()
	 */
	
	public void avviaPartita() {
		Partita partita = new Partita(this.views);
		this.partite.add(partita);
		partita.avvia();
		this.views = new HashMap<String, ServerView>();
		numeroGiocatori=0;
	}
}