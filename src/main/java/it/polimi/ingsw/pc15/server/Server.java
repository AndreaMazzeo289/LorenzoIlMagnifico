package it.polimi.ingsw.pc15.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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
	private ArrayList<String> connessi;
	private int numeroGiocatori;
	
	
	/*
	 *  TEMPORANEO FINAL INT PER TESTARE
	 */
	

	public Server() throws IOException {
		this.serverSocket = new ServerSocket(PORT);
		this.connections = new HashMap<String, Connection>();
		this.connessi = new ArrayList<String>();
	};
	
	
	

	public void run() throws InterruptedException {
		// TODO Auto-generated method stub
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
		
		numeroGiocatori = register(name, c);
		System.out.println("connesso con il player:" + name);
		if(numeroGiocatori==4){
			
			for(Map.Entry<String, Connection> scorriPlayersList : connections.entrySet()) {
				connessi.add(scorriPlayersList.getKey());
				
			}
	
			
			Model model = new Model(null, false);
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
		} 
		
		catch (IOException e) {
			System.err.println("Impossibile inizializzare il server: " + e.getMessage() + "!");
		}		
	}
}
