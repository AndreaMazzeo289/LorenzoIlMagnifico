package it.polimi.ingsw.pc15;

import java.util.Observable;
import java.util.Observer;

public class View extends Observable implements Observer {
	
	public View (Model gioco) {
		gioco.registerObserver(this);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	

}
