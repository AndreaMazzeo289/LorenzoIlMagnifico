package it.polimi.ingsw.pc15.view;

import java.util.Observable;
import java.util.Observer;

import it.polimi.ingsw.pc15.model.Model;

public class View extends Observable implements Observer {
	
	public View (Model gioco) {
		gioco.addObserver(this);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	

}
