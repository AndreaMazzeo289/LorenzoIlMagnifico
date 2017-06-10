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

public class Client {
	
	private static String hostName;
	private ClientController clientController;
	private View view;
	private ClientModel clientModel;
	
	public Client() throws IOException {
		
		this.clientModel = new ClientModel();
		this.clientController = new ClientController(new Socket(hostName, 12879), clientModel);
		this.view = new CLI(clientController, clientModel);
	}
	
	public void connetti() {
		if (clientController.connetti()) {
			new Thread(view).start();
			clientController.run();
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		Client client = new Client();
		client.connetti();
	}
}