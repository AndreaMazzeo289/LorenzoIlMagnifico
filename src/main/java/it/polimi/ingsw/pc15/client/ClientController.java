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
		if(!(o instanceof CLI) || !(input instanceof ArrayList<?>)){
			throw new IllegalArgumentException();
		}
		
		try {
			
			client.send((ArrayList<String>)input);
			System.out.println("check");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
