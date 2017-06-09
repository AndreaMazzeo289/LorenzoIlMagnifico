package it.polimi.ingsw.pc15.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class ClientController extends Observable implements Observer  {

	private Scanner in;
	private PrintStream out;
	private ObjectInputStream inObj;
	private ObjectOutputStream outObj;


	public ClientController (Socket socket) throws IOException  {
		
		this.in = new Scanner(socket.getInputStream());
		this.out = new PrintStream(socket.getOutputStream());	
		this.inObj = new ObjectInputStream(socket.getInputStream());
		this.outObj = new ObjectOutputStream(socket.getOutputStream());
	}	
	
	public void run() {
		
		String name;
		Scanner input = new Scanner(System.in);
		System.out.println("Scrivi il tuo nome :");
		name = input.nextLine();
		out.println(name);  //manda il nome alla Connection
		
		if(in.nextLine().equals("OK")) {  //attende finchè riceve l'OK dal server
			System.out.println(name +", la partita ha inizio!");
		}

	}
	
	@Override
	public void update(Observable o, Object input) {
		
		System.out.println("\nSono il Client controller e ho ricevuto " + (ArrayList<String>) input);
		
		try {
			send(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void send(Object message) throws IOException{
		
		System.out.println("\nSono il clientController e sto inviando " + (ArrayList<String>) message);
		outObj.writeObject(message);
	}
}
