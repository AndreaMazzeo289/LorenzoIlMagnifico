package it.polimi.ingsw.pc15.client;

import java.net.Socket;

public abstract class Client {
	
	protected NetworkHandler networkHandler;
	protected ClientModel clientModel;
	protected ClientView view;
	
	public abstract void connetti();
	
}
