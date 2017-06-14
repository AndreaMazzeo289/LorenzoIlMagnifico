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

public class SocketClient {
	
	private static String hostName;
	private SocketHandler socketHandler;
	private View view;
	private ClientModel clientModel;
	
	public SocketClient() throws IOException {
		
		this.clientModel = new ClientModel();
		this.socketHandler = new SocketHandler(new Socket(hostName, 12879), clientModel);
		this.view = new CLI(socketHandler, clientModel);
	}
	
	public void connetti() {
		if (socketHandler.connetti()) {
			new Thread(view).start();
			socketHandler.run();
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		
		
		SocketClient socketClient = new SocketClient();
		socketClient.connetti();
		
		
	}
}