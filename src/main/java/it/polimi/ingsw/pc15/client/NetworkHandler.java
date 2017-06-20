package it.polimi.ingsw.pc15.client;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

public abstract class NetworkHandler extends Observable implements Observer, Serializable {
	
	protected String name;
	protected ClientModel clientModel;
	
	public NetworkHandler(String name, ClientModel clientModel) {
		this.clientModel = clientModel;
		this.name = name;
	}

	@Override
	public abstract void update(Observable arg0, Object arg1);
	
	public abstract boolean connetti();

}
