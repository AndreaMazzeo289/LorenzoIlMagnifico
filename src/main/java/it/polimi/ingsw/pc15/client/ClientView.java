package it.polimi.ingsw.pc15.client;

import java.util.Observable;
import java.util.Observer;

public abstract class ClientView extends Observable implements Observer, Runnable {
	
	protected ClientModel clientModel;
	
	public ClientView(NetworkHandler networkHandler, ClientModel clientModel)
	{
		this.clientModel = clientModel;
		clientModel.addObserver(this);
		this.addObserver(networkHandler);
	
	}
	
	public abstract void run();
	
	public boolean tuoTurno() {
    	if (this.clientModel.getGiocatoreCorrente().equals(this.clientModel.getStatoGiocatore().getNome()))
    		return true;
    	else return false;
		
	}

}

