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
	
	private ClientController clientController;
	private View view;
	
	
	public Client(Socket clientSocket) throws IOException{ //Costruttore Socket Client
		
		this.outObj = new ObjectOutputStream(clientSocket.getOutputStream());
		this.inObj = new ObjectInputStream(clientSocket.getInputStream());
		this.in = new Scanner(clientSocket.getInputStream());
		this.out = new PrintStream(clientSocket.getOutputStream());
		
		this.clientController = new ClientController(this);
		this.view = new CLI(clientController);
		
		
	}
	
	public Client(){ //Costruttore RMI Client
	}
	
	
	
	public void run() {
		Scanner name = new Scanner(System.in);
		System.out.println("Scrivi il tuo nome :");
		name.nextLine();
		out.println(name);
		view.run();
	}
	
	public void send(ArrayList<String> message) throws IOException{
		outObj.writeObject(message);
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		Scanner systemIn = new Scanner (System.in);
		System.out.println("Vuoi connetterti tramite socket (1) o RMI (2)?"); 
		int scelta = systemIn.nextInt();
		
		Client client;
		
		if (scelta==1) {
			client = new Client(new Socket(hostName, 12879));
			client.run();
			
		}
		else if (scelta==2) {
			client = new Client();
			client.run();
		}
	
	}
}
