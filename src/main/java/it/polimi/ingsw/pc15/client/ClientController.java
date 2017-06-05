package it.polimi.ingsw.pc15.client;

import java.util.Observable;
import java.util.Observer;

import org.hamcrest.core.IsInstanceOf;

public class ClientController extends Observable implements Observer  {

	private Client client;
	public ClientController(Client client){
		
		this.client = client;
		
	}
	
	public void notify(String string){
		
		setChanged();
		notifyObservers(string);
	}

	@Override
	public void update(Observable o, Object arg1) {
		if(!(o instanceof CLI) || !(arg1 instanceof String)){
			throw new IllegalArgumentException();
		}

		
	}
}
