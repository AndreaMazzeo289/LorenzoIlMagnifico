package it.polimi.ingsw.pc15.server;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Observable;
import java.util.Scanner;

public class Connection extends Observable implements Runnable {

	private Socket socket;
	private Server server;
	private PrintStream out ;
	private Scanner in;
	private String name;
	
	/*
	 * FLAG TEMPORANEE
	 */
	private boolean flag; 
	private boolean connessioneAttiva;
	
	
	
	public Connection(Socket socket, Server server) throws IOException{
		
		this.socket = socket;
		this.server = server;
		out = new PrintStream(this.socket.getOutputStream());
		in = new Scanner(this.socket.getInputStream());
		this.flag = true;
		this.connessioneAttiva = true;
		this.name = null;
	}
	
	
	/*
	 * OVERRIDE DEL METODO RUN DELL'INTERFACCIA RUNNABLE
	 * LA CONNECTION CORRISPONDE ALLA SOCKET CREATA DAL SERVER PER COMUNICARE CON LO SPECIFICO CLIENT
	 * OGNI CLIENT HA LA PROPRIA CONNECTION
	 */
	
	
	@Override
	public void run() {
		
		out.println("Scrivi il tuo nome");
		out.flush();
		name = in.nextLine();
		server.connetti(this, name);
	
	
	}
	
	public synchronized void send(String messaggio){
		
		out.println(messaggio);
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
