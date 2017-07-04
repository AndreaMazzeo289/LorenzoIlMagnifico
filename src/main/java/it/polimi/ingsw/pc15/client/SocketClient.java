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

import it.polimi.ingsw.pc15.GUI.GUI;

public class SocketClient extends Client {
	
	private static String hostName;
	
	public SocketClient(String nome) throws IOException {
		
		this.clientModel = new ClientModel();
		this.networkHandler = new SocketHandler(new Socket(hostName, 12879), clientModel, nome);
		//this.view = new CLI(networkHandler, clientModel);
		this.view = new GUI(networkHandler, clientModel);
	}
	
	@Override
	public void connetti() {
		if (networkHandler.connetti()) {
			new Thread(view).start();
			((SocketHandler) networkHandler).run();
		}

	}
}