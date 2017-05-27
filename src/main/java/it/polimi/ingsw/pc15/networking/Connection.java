package it.polimi.ingsw.pc15.networking;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Observable;
import java.util.Scanner;

public class Connection extends Observable implements Runnable {

	private Socket socket;
	private Server server;
	private PrintStream out;
	private Scanner in;
	
	public Connection(Socket socket, Server server){
		
		this.socket = socket;
		this.server = server;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {	
			out = new PrintStream(this.socket.getOutputStream());
			in = new Scanner(this.socket.getInputStream());
			out.println("Scrivi il tuo nome");
			
			
			
			String read = in.next();
	
			
			
			System.out.println("Connesso con il player : " + read);
			
			
			
			server.Connetti(this, read);
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private synchronized void closeConnection(){
		
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
