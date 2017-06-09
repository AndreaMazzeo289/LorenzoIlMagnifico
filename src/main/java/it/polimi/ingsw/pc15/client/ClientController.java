package it.polimi.ingsw.pc15.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import org.hamcrest.core.IsInstanceOf;

public class ClientController extends Observable implements Observer  {

	private Client client;
	public ClientController(Client client){
		
		this.client = client;
	}	
	
	@Override
	public void update(Observable o, Object input) {
		
		System.out.println("\nSono il Client controller e ho ricevuto " + (ArrayList<String>) input);
		
		try {
			client.send(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
