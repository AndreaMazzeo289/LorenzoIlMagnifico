package it.polimi.ingsw.pc15.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.channels.NotYetBoundException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

public class Connection extends Observable implements Runnable {

	private Socket socket;
	private Server server;
	private ObjectInputStream inObj;
	private ObjectOutputStream outObj;
	private Scanner in;
	private PrintStream out;
	private String name;
	private ArrayList<String> input;
	
	public Connection(Socket socket, Server server) throws IOException{
		
		this.socket = socket;
		this.server = server;
		outObj = new ObjectOutputStream(this.socket.getOutputStream());
		inObj = new ObjectInputStream(this.socket.getInputStream());
		this.in = new Scanner(this.socket.getInputStream());
		this.out = new PrintStream(this.socket.getOutputStream());
	}
	
	@Override
	public void run() {

		name = in.nextLine();		
		server.connetti(this, name);
		
		while(true) {
			
			ArrayList<String> message = new ArrayList<String>();
			try {
				message = (ArrayList<String>) inObj.readObject();
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("\nSono la connection e ho ricevuto " + message);
			setChanged();
			notifyObservers(message);
		}
	
	}
	
	public synchronized void sendLine(String messaggio) {
		
		out.println(messaggio);
	}
	
	public String getName() {
		return this.name;
	}

}