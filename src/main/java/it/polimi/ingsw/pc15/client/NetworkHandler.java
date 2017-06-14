package it.polimi.ingsw.pc15.client;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

public abstract class NetworkHandler extends Observable implements Observer, Serializable {

	@Override
	public abstract void update(Observable arg0, Object arg1);
	
	public abstract boolean connetti();

}
