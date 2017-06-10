package it.polimi.ingsw.pc15.client;

import java.util.Observable;
import java.util.Observer;


public abstract class View extends Observable implements Observer, Runnable {
	
	private ClientModel clientModel;
	
	public View(ClientController clientController, ClientModel clientModel)
	{
		this.clientModel = clientModel;
		this.addObserver(clientController);
	
	}
	
	public abstract void run();

}
