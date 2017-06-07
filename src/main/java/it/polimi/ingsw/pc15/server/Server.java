package it.polimi.ingsw.pc15.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observer;

import it.polimi.ingsw.pc15.controller.Controller;
import it.polimi.ingsw.pc15.model.Model;
import it.polimi.ingsw.pc15.player.Player;



public class Server {

	private final static int PORT = 12879;
	private ServerSocket serverSocket;
	private HashMap<String, Connection> connections;
	private int numeroGiocatori;
	
	public Server() throws IOException {
		this.serverSocket = new ServerSocket(PORT);
		this.connections = new HashMap<String, Connection>();
		this.numeroGiocatori = 0;
	}


	public void run() throws InterruptedException {
		
		System.out.println("Stabilisco connessione...");

		while (true) {
		try {
				Socket newSocket = serverSocket.accept();
				Connection connection = new Connection(newSocket, this);	
				new Thread(connection).start();
			} 
			
			catch (IOException e) {
				System.out.println("Errore di connessione!");
			}
		}	
			
	}
	
	public synchronized void connetti(Connection connection, String name){
		
		connections.put(name, connection);
		System.out.println("connesso con il player:" + name);
		numeroGiocatori++;
		if (numeroGiocatori==2) {
			avviaPartita();
			numeroGiocatori=0;
		}
	}
	
	
	public void avviaPartita() {
		
		ArrayList<String> nomiGiocatoriConnessi = new ArrayList<String>();
		
		for(Map.Entry<String, Connection> giocatoriConnessi : connections.entrySet())
			nomiGiocatoriConnessi.add(giocatoriConnessi.getKey());
		
		Model model = new Model(nomiGiocatoriConnessi, false);
		Controller controller = new Controller(model, this.connections);
		
		model.iniziaPartita();
		
		for(Map.Entry<String, Connection> giocatoriConnessi : connections.entrySet()) {
			giocatoriConnessi.getValue().addObserver(controller);  //il Controller viene reso Observer di ogni connessione
			giocatoriConnessi.getValue().sendLine("OK"); //notifica ai giocatori l'inizio partita
	}
		
	}

	
	public static void main(String[] args) throws InterruptedException {
		
		Server server;
		
		try {
			server = new Server();
			server.run();
		} catch (IOException e) {
			System.err.println("Impossibile inizializzare il server: " + e.getMessage() + "!");
		}	
		
		
		
	}
}