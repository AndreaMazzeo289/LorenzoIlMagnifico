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
	
	private boolean connessioneAttiva;
	
	
	
	public Connection(Socket socket, Server server) throws IOException{
		
		this.socket = socket;
		this.server = server;
		outObj = new ObjectOutputStream(this.socket.getOutputStream());
		inObj = new ObjectInputStream(this.socket.getInputStream());
		this.in = new Scanner(this.socket.getInputStream());
		this.out = new PrintStream(this.socket.getOutputStream());
		this.connessioneAttiva = false;
	}
	
	@Override
	public void run() {
		
		
		name = in.nextLine();		
		server.connetti(this, name);
		
		while(true){
			
			if(connessioneAttiva){
				
				setChanged();
				notifyObservers("IniziaPartita");
				
				try {
					input = (ArrayList<String>)inObj.readObject();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				setChanged();
				notifyObservers(input);
				try {
					Thread.currentThread().sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
	
	}
	
	public synchronized void sendLine(String messaggio){
		
		out.println(messaggio);
	}
	//public synchronized void sendObj()
	
	public synchronized void attivaConnessione(){
		
		connessioneAttiva = true;
	}
	
	
	
	private synchronized void closeConnection(){
		
		try {
			connessioneAttiva = false;
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}