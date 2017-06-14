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

import it.polimi.ingsw.pc15.model.StatoPartita;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class SocketHandler extends Observable implements Observer, Serializable {
	
	private Scanner in;
	private PrintStream out;
	private ObjectInputStream inObj;
	private ObjectOutputStream outObj;
	private ClientModel clientModel;


	public SocketHandler (Socket socket, ClientModel clientModel) throws IOException  {
		
		this.in = new Scanner(socket.getInputStream());
		this.out = new PrintStream(socket.getOutputStream());	
		this.inObj = new ObjectInputStream(socket.getInputStream());
		this.outObj = new ObjectOutputStream(socket.getOutputStream());
		this.clientModel = clientModel;
	}	
	
	public boolean connetti() {
		
		String name;
		Scanner input = new Scanner(System.in);
		System.out.println("Tentativo di connessione!\nScrivi il tuo nome :");
		name = input.nextLine();
		out.println(name);  //manda il nome alla Connection
		System.out.println("Connessione al server riuscita! In attesa di altri giocatori\n");
		
		if(in.nextLine().equals("OK")) { //attende finchè riceve l'OK dal server
			System.out.println("  --- PARTITA INIZIATA! ---");
			return true;
		}
		
		return false;
		
	}
		
		public void run() {
			
			while (true) {
				
				try {
					StatoPartita statoPartita = (StatoPartita) inObj.readObject();
					System.out.println(statoPartita.getMessaggio());
					clientModel.aggiorna(statoPartita);
					
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();}
			}

	}
	
	@Override
	public void update(Observable o, Object input) {
		
		//System.out.println("\nSono il Client controller e ho ricevuto " + (ArrayList<String>) input);
		
		try {
			send(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void send(Object message) throws IOException{
		
		//System.out.println("\nSono il clientController e sto inviando " + (ArrayList<String>) message);
		outObj.writeObject(message);
	}
}
