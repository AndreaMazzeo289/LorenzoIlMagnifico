package it.polimi.ingsw.pc15.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.pc15.model.StatoPartita;


public class SocketView extends ServerView implements Serializable {

	private transient Socket socket;
	private Server server;
	private transient ObjectInputStream inObj;
	private transient ObjectOutputStream outObj;
	private transient Scanner in;
	private transient  PrintStream out;
	
	public SocketView(Socket socket, Server server) throws IOException{
		
		this.socket = socket;
		this.server = server;
		outObj = new ObjectOutputStream(this.socket.getOutputStream());
		inObj = new ObjectInputStream(this.socket.getInputStream());
		this.in = new Scanner(this.socket.getInputStream());
		this.out = new PrintStream(this.socket.getOutputStream());
	}
	
	
	public void run() {

		name = in.nextLine();		
		server.connetti(this, name);
		
		 try {
			 
			 while(true) {
				ArrayList<String> message;
				message = (ArrayList<String>) inObj.readObject();
				setChanged();
				notifyObservers(message);
			} 
			 
		} catch (ClassNotFoundException | IOException e) {
				try {
					this.socket.close();
					setChanged();
					notifyObservers(new ArrayList<String>(Arrays.asList("CONNESSIONE CHIUSA")));
				} catch (IOException e1) {
					e1.printStackTrace();  //NOSONAR
				}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		
		StatoPartita statoPartita = (StatoPartita)arg;
		statoPartita.setStatoGiocatore(name);

		sendObj(statoPartita);
		
	}
	
	public synchronized void sendLine(String messaggio) {	
		out.println(messaggio);
	}
	
	public String getName() {
		return this.name;
	}
	
	public synchronized void sendObj(Object obj) {	
		
		try {
			outObj.writeObject(obj);
			outObj.reset();
		} catch (IOException e) {
		}

		
	}
}