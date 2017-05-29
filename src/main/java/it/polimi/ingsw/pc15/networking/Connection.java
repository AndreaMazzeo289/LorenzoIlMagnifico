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
	private int numeroGiocatori = 0;
	private boolean flag = true;
	
	
	public Connection(Socket socket, Server server){
		
		this.socket = socket;
		this.server = server;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {	
			
				if(flag){
				out = new PrintStream(this.socket.getOutputStream());
				in = new Scanner(this.socket.getInputStream());
				out.println("Scrivi il tuo nome");
				out.flush();
			
			
				String read = in.nextLine();
				
				System.out.println("Connesso con il player : " + read);
			
				
	
				numeroGiocatori = server.Connetti(this, read);
				}
			synchronized (this) {
				notify();
			
			if(flag){
				
			
				send("In attesa di altri giocatori...");
				flag = false;
				wait();
				send("La partita sta per cominciare");
			}
			}
			
			
			
		
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
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
