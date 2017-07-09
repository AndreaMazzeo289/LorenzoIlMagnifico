package it.polimi.ingsw.pc15.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.model.StatoPartita;
import it.polimi.ingsw.pc15.plancia.SpazioTorre;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class SocketHandler extends NetworkHandler implements Serializable{
	
	private transient Scanner in;
	private transient PrintStream out;
	private transient ObjectInputStream inObj;
	private transient ObjectOutputStream outObj;

	public SocketHandler (Socket socket, ClientModel clientModel, String name) throws IOException  {
		
		super(name, clientModel);
		
		this.in = new Scanner(socket.getInputStream());
		this.out = new PrintStream(socket.getOutputStream());	
		this.inObj = new ObjectInputStream(socket.getInputStream());
		this.outObj = new ObjectOutputStream(socket.getOutputStream());
	}	
	
	@Override
	public void connetti() {
		
		out.println(name);  //manda il nome alla Connection
		System.out.println("Connessione al server riuscita! In attesa di altri giocatori\n");
		
		if(in.nextLine().equals("OK")) { //attende finchè riceve l'OK dal server
			setChanged();
			notifyObservers();
		}
		
	}
		
		
	public void run() {
			
		while (true) {
				
			try {
				StatoPartita statoPartita = (StatoPartita) inObj.readObject();
				clientModel.aggiorna(statoPartita);
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();} // NOSONAR
			}
	}
	
	@Override
	public void update(Observable o, Object input) {
			
		try {
			send(input);
		} catch (IOException e) {
			e.printStackTrace(); // NOSONAR
		}
		
	}
	
	public void send(Object message) throws IOException{
		//System.out.println("\nSono il SocketHandler e sto inviando " + (ArrayList<String>) message);
		outObj.writeObject(message);
		outObj.reset();
	}
}
