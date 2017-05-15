package it.polimi.ingsw.pc15;

import java.util.Observable;
import java.util.Observer;


public class Controller implements Observer {
	
	private final Model gioco;
	
	public Controller (Model gioco, View view) {
		this.gioco = gioco;
		view.addObserver(this);
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
