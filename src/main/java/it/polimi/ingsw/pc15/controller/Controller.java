package it.polimi.ingsw.pc15.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import it.polimi.ingsw.pc15.model.Model;
import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.server.Connection;



public class Controller extends Observable implements Observer {
	
	private final Model model;
	private int i = 0;
	HashMap<String, Connection> connections;
	
	public Controller (Model model, HashMap<String, Connection> connections) {
		this.model = model;
		this.connections = connections;
		
	}

	private void parseString(String input){
		
		if(input.equals("IniziaPartita")){
			model.iniziaPartita();
		
			
			for(Map.Entry<String, Connection> scorriPlayersList : connections.entrySet()) {
				if(scorriPlayersList.getKey().equals(model.getProssimoGiocatore()))
					System.out.println(model.getProssimoGiocatore());
					scorriPlayersList.getValue().sendLine(model.getProssimoGiocatore());
				
			}
		}
	}
	
	@Override
	public synchronized void update(Observable o, Object input) {
		if( !(o instanceof Connection) ||(!(input instanceof String) || !(input instanceof ArrayList<?>))){
			throw new IllegalArgumentException();
		}
		
		if(input instanceof String){
			parseString((String) input);
		}
		if(input.equals("Inizio Partita")){
			
			
		}
		
		if(input instanceof ArrayList<?>){
		System.out.println("input = " + ((ArrayList<String>) input).get(i));
		i++;
		}
		
	
		
	}

}
