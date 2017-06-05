package it.polimi.ingsw.pc15.controller;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import it.polimi.ingsw.pc15.model.Model;
import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.server.Connection;



public class Controller extends Observable implements Observer {
	
	private final Model model;
	
	public Controller (Model model) {
		this.model = model;
		
	}

	@Override
	public synchronized void update(Observable o, Object input) {
		if( !(o instanceof Connection) || !(input instanceof ArrayList<?>)){
			throw new IllegalArgumentException();
		}
		
		System.out.println("input = " + ((ArrayList<String>) input).get(0));
		
	
		
	}

}
