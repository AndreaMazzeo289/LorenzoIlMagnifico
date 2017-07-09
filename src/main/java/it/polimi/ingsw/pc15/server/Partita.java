package it.polimi.ingsw.pc15.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import it.polimi.ingsw.pc15.controller.Controller;
import it.polimi.ingsw.pc15.model.Model;

public class Partita {
	
	private HashMap<String, ServerView> giocatori;
	private Model partita;
	private Controller controller;
	
	public Partita(HashMap<String, ServerView> giocatori) {
		this.giocatori = giocatori;
	}
	
	public void avvia() {
		
		ArrayList<String> nomiGiocatori = new ArrayList<String>();
		
		for(Map.Entry<String, ServerView> giocatoriConnessi : giocatori.entrySet())
			nomiGiocatori.add(giocatoriConnessi.getKey());
		
		Model model = new Model(nomiGiocatori);
		
		for(Map.Entry<String, ServerView> view : giocatori.entrySet()) 
			model.addObserver(view.getValue());
			
		Controller controller = new Controller(model);
		
		for(Map.Entry<String, ServerView> giocatoreConnesso : giocatori.entrySet()) {
			giocatoreConnesso.getValue().addObserver(controller);  //il Controller viene reso Observer di ogni View
			if (giocatoreConnesso.getValue() instanceof SocketView)
				((SocketView) giocatoreConnesso.getValue()).sendLine("OK"); //notifica ai giocatori l'inizio partita
			else if (giocatoreConnesso.getValue() instanceof RMIView)
				((RMIView) giocatoreConnesso.getValue()).sendOK();
		}
		
		try {
			model.iniziaPartita();
			System.out.println("Nuova partita avviata! Giocatori: " + nomiGiocatori);
		} catch (IndexOutOfBoundsException e) {};
		
		
		
	}

}
