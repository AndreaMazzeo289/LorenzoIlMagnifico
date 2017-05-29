package it.polimi.ingsw.pc15.networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Server {
	

	
	private final static int PORT = 12879;
	ServerSocket serverSocket;
	ArrayList<Connection> connectionList = new ArrayList<Connection>();
	
	private Map<String, Connection> playingConnection = new HashMap<>();
;
	private ArrayList<String> connessi = new ArrayList<String>();
	private final int numeroGiocatori = 4;
	
	public Server() throws IOException {
		serverSocket = new ServerSocket(PORT);
	};
	
	
	
	

	public void run() throws InterruptedException {
		// TODO Auto-generated method stub
		while (true) {
		try {
				System.out.println("Stabilisco connessione...");
				Socket newSocket = serverSocket.accept();
				Connection connection = new Connection(newSocket, this);
				register(connection);
				synchronized (connection) {
						new Thread(connection).start();
						connection.wait();
				}
				
				if(connectionList.size()==4){
					
					synchronized(connectionList.get(0)){
						new Thread(connectionList.get(0)).start();
					}
					synchronized(connectionList.get(1)){
						new Thread(connectionList.get(1)).start();
					}
					synchronized(connectionList.get(2)){
						new Thread(connectionList.get(2)).start();
					}
					synchronized(connectionList.get(3)){
						new Thread(connectionList.get(3)).start();
					}
					
				}
				
			} 
			
			catch (IOException e) {
				System.out.println("Errore di connessione!");
			}
		}
			
	}
			
	public void register(Connection connection){
		
		connectionList.add(connection);
	}
	
	public synchronized int Connetti(Connection c, String name){
		
		playingConnection.put(name, c);
		System.out.println("Player connessi = " + playingConnection.size());
		if(playingConnection.size()==numeroGiocatori){
			for(Map.Entry<String, Connection> scorriPlayersList : playingConnection.entrySet()) {
				connessi.add(scorriPlayersList.getKey());
				
			}
	
//		View player1 = new View(new Player(connessi.get(0)), playingConnection.get(connessi.get(0)));

		//View player2 = new View(new Player(connessi.get(1)), playingConnection.get(connessi.get(1)));
		//View player3 = new View(new Player(connessi.get(2)), playingConnection.get(connessi.get(2)));
		//View player4 = new View(new Player(connessi.get(3)), playingConnection.get(connessi.get(3)));
			
		//Model model = new Model(numeroGiocatori);
	//	Controller controller = new Controller(model);
	//	model.addObserver(player1);
	//	model.addObserver(player2);
		//model.addObserver(player3);
		//model.addObserver(player4);
		//player1.addObserver(controller);
	//	player2.addObserver(controller);	
		//player3.addObserver(controller);	
		//player4.addObserver(controller);

		return playingConnection.size();
		}else	return playingConnection.size();
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
