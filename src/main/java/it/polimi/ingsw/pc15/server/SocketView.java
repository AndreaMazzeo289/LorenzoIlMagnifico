package it.polimi.ingsw.pc15.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Serializable;
import java.net.Socket;
import java.nio.channels.NotYetBoundException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import it.polimi.ingsw.pc15.model.StatoPartita;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

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
	
	@Override
	public void run() {

		name = in.nextLine();		
		server.connetti(this, name);
		
		while(true) {
			
			try {
				ArrayList<String> message;
				message = (ArrayList<String>) inObj.readObject();
				setChanged();
				notifyObservers(message);
				
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		
		StatoPartita statoPartita = (StatoPartita)arg;
		System.out.println("\nSono la SocketView di " + name + " e ho ricevuto " + (statoPartita.getMessaggio()));
		statoPartita.setStatoGiocatore(name);
		sendObj(statoPartita);
		
	}
	
	
	@Override
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
			e.printStackTrace();
		}
		
	}
}