package it.polimi.ingsw.pc15.controller;

import java.util.Observable;
import java.util.Observer;

import it.polimi.ingsw.pc15.model.Model;
import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Player;



public class Controller implements Observer {
	
	private final Model model;
	
	public Controller (Model model) {
		this.model = model;
		
	}

	@Override
	public synchronized void update(Observable o, Object message) {
		if(!(message instanceof String)){
			throw new IllegalArgumentException();
		}
		System.out.println("checkcontroller");
		
		model.prova((String)message);
		
	}

}
