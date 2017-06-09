package it.polimi.ingsw.pc15.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

public class Client extends Observable implements Serializable{
	
	private ObjectInputStream inObj;
	private ObjectOutputStream outObj;
	private Scanner in;
	private PrintStream out;
	private static String hostName;
	private String name;
	private ClientController clientController;
	private View view;
	
	public Client(Socket clientSocket) throws IOException{ //Costruttore Socket Client
		
		this.in = new Scanner(clientSocket.getInputStream());
		this.out = new PrintStream(clientSocket.getOutputStream());		
		this.inObj = new ObjectInputStream(clientSocket.getInputStream());
		this.outObj = new ObjectOutputStream(clientSocket.getOutputStream());

		this.clientController = new ClientController(this);
		this.view = new CLI(clientController);
	}
	
	public Client() {}

	
	public void run() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Scrivi il tuo nome :");
		name = input.nextLine();
		out.println(name);  //manda il nome alla Connection
		
		if(in.nextLine().equals("OK")) {  //attende finchè riceve l'OK dal server
			System.out.println(name +", la partita ha inizio!");
			view.run();
		}

	}
	
	public void send(Object message) throws IOException{
		
		System.out.println("\nSono il client e sto inviando " + (ArrayList<String>) message);
		outObj.writeObject(message);
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		Client client = new Client(new Socket(hostName, 12879));
		client.run();
	}
}