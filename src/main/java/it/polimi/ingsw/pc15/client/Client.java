package it.polimi.ingsw.pc15.client;

import java.net.Socket;
import java.util.Observer;

import it.polimi.ingsw.pc15.GUI.GUI;

public abstract class Client implements Observer {
	
	public Client () {
		this.clientModel = new ClientModel();
	}
	
	protected NetworkHandler networkHandler;
	protected ClientModel clientModel;
	protected ClientView view;
	
	public void connetti() {
		this.networkHandler.connetti();
	}
	
}
