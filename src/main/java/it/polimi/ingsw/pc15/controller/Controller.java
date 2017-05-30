package it.polimi.ingsw.pc15.controller;

import java.util.Observable;
import java.util.Observer;

import it.polimi.ingsw.pc15.model.Model;
import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.view.View;


public class Controller implements Observer {
	
	private final Model gioco;
	
	public Controller (Model gioco) {
		this.gioco = gioco;
		
	}

	@Override
	public synchronized void update(Observable o, Object message) {
		if(!(o instanceof View)|| !(message instanceof View )){
			throw new IllegalArgumentException();
		}
		
		gioco.prova((String)message);
		
	}

}
