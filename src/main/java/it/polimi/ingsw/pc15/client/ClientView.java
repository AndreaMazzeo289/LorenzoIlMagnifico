package it.polimi.ingsw.pc15.client;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public abstract class ClientView extends Observable implements Observer, Runnable {
	
	protected ClientModel clientModel;
	protected BlockingQueue<FasePartita> fasi;
	protected ArrayList<String> message;
	
	public ClientView(NetworkHandler networkHandler, ClientModel clientModel)
	{
		this.clientModel = clientModel;
		clientModel.addObserver(this);
		this.addObserver(networkHandler);
		this.fasi = new ArrayBlockingQueue<FasePartita>(10);
		this.message = new ArrayList<String>();
	
	}
	
	public abstract void run();
	
	public boolean tuoTurno() {
    	if (this.clientModel.getGiocatoreCorrente().equals(this.clientModel.getStatoGiocatore().getNome()))
    		return true;
    	else return false;
		
	}

}

