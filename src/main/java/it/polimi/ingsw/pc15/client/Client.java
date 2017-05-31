package it.polimi.ingsw.pc15.client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Observable;
import java.util.Scanner;

public class Client extends Observable{
	private  PrintStream out;
	private  Scanner in;
	private  String hostName;
	
	private ClientController clientController;
	private ClientView clientView;
	
	
	public Client() throws IOException{
		
		Socket clientSocket = new Socket(hostName, 12879);
		this.out = new PrintStream(clientSocket.getOutputStream());
		this.in = new Scanner(clientSocket.getInputStream());
		this.clientController = new ClientController(this);
		this.clientView = new ClientView();
		this.clientView.run();
		clientView.addObserver(clientController);
		clientController.addObserver(clientView);
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
			Client client;
			client = new Client();
			
			client.run();
			
	}


}
