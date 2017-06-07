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
	private HashMap<String, Connection> connections;
	
	public Controller (Model model, HashMap<String, Connection> connections) {
		this.model = model;
		this.connections = connections;
		
	}
	
	@Override
	public synchronized void update(Observable o, Object input) {	
		
		System.out.println(((Connection) o).getName() + ((ArrayList<String>) input));
	}

}
