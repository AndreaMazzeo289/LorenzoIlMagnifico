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
	private int numeroGiocatori;
	
	
	public Connection(Socket socket, Server server){
		
		this.socket = socket;
		this.server = server;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {	
			
			synchronized (this) {
				out = new PrintStream(this.socket.getOutputStream());
				in = new Scanner(this.socket.getInputStream());
				out.println("Scrivi il tuo nome");
				out.flush();
			
			
				String read = in.nextLine();
				send("Scrivi il tuo cognome");
				String read2 = in.nextLine();
				System.out.println("Connesso con il player : " + read + " " + read2);
			
				
	
				numeroGiocatori = server.Connetti(this, read);
				
				if (numeroGiocatori<4) {
					send("In attesa di altri giocatori...");
				}else send("La partita sta per cominciare");
				notify();
			}
			
			
			
		
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public synchronized void send(String messaggio){
		
		out.println(messaggio);
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
