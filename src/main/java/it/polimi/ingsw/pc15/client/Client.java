package it.polimi.ingsw.pc15.client;

import java.net.Socket;

import it.polimi.ingsw.pc15.GUI.GUI;

public abstract class Client {
	
	public Client () {
		this.clientModel = new ClientModel();
	}
	
	protected NetworkHandler networkHandler;
	protected ClientModel clientModel;
	protected ClientView view;
	
	public abstract void connetti();
	
}
