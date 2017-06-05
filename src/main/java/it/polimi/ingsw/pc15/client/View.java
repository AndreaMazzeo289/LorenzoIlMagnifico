package it.polimi.ingsw.pc15.client;

import java.util.Observable;


public abstract class View extends Observable{
	
	public View(ClientController clientController)
	{
		
		this.addObserver(clientController);
		
	}
	
	public abstract void run();

}
