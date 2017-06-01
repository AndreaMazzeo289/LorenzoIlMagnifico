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
	ServerSocket serverSocket;
	private Map<String, Connection> connections;
	private boolean rmi;
	
	public Server() throws IOException {
		this.serverSocket = new ServerSocket(PORT);
		this.connections = new HashMap<String, Connection>();
		this.rmi = false;
	};


	public void run() throws InterruptedException {
		
		
		if (rmi) {
			try {
				LocateRegistry.createRegistry(1099);//Creo un registy sulla porta 1099 (quella di default).
			} catch (RemoteException e) {
				System.out.println("Registry già  presente!");			
			}	
			
			//oggettoImplementation 
			//Naming.rebind (oggettoImplementation / nome)
			
			
		}
		
		while (true) {
		try {
				System.out.println("Stabilisco connessione...");
				Socket newSocket = serverSocket.accept();
				Connection connection = new Connection(newSocket, this);		
			} 
			
			catch (IOException e) {
				System.out.println("Errore di connessione!");
			}
		}	
			
	}
			
	public synchronized int register(String name, Connection connection){
		
		connections.put(name,connection);
		return connections.size();
		
	}
	
	
	
	public synchronized void connetti(Connection c, String name){
		
		int numeroGiocatori = register(name, c);
		System.out.println("connesso con il player:" + name);
		if(numeroGiocatori==4){	
			
			ArrayList<String> connessi = new ArrayList<String>();

			for(Map.Entry<String, Connection> scorriPlayersList : connections.entrySet())
				connessi.add(scorriPlayersList.getKey());
		
		//View player1 = new View(new Player(connessi.get(0)), playingConnection.get(connessi.get(0)));
		//View player2 = new View(new Player(connessi.get(1)), playingConnection.get(connessi.get(1)));
		//View player3 = new View(new Player(connessi.get(2)), playingConnection.get(connessi.get(2)));
		//View player4 = new View(new Player(connessi.get(3)), playingConnection.get(connessi.get(3)));
		
		Model model = new Model(connessi, false);
		
		Controller controller = new Controller(model);

		for(Map.Entry<String, Connection> scorriPlayersList : connections.entrySet()) {
				scorriPlayersList.getValue().addObserver(controller);
		}
			
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
