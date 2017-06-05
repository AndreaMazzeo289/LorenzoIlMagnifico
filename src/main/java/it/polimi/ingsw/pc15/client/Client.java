package it.polimi.ingsw.pc15.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.Observable;
import java.util.Scanner;

public class Client extends Observable implements Serializable{
	
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private static String hostName;
	
	private ClientController clientController;
	private View view;
	
	
	public Client(Socket clientSocket) throws IOException{ //Costruttore Socket Client
		
		this.out = new PrintStream(clientSocket.getOutputStream());
		this.in = new Scanner(clientSocket.getInputStream());
		
		this.clientController = new ClientController(this);
		this.view = new CLI(clientController);
		
		System.out.println("");
	}
	
	public Client() throws IOException{ //Costruttore RMI Client
		
	}
	
	
	
	public void run() throws InterruptedException {
		String string;
			while(true){
				string = in.nextLine();
				clientController.notify(string);
				
			}
	}
	
	public void send(String message){
		
		out.println(message);
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
