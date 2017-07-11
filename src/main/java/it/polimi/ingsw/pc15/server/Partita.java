package it.polimi.ingsw.pc15.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import it.polimi.ingsw.pc15.controller.Controller;
import it.polimi.ingsw.pc15.model.Model;


/**
 * Classe usata dal server per tenere traccia di ogni singola partita. Contiene un model, un controller
 * e le view dei relativi giocatori
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class Partita {
	
	private HashMap<String, ServerView> giocatori;
	private Model model;
	private Controller controller;
	
	public Partita(HashMap<String, ServerView> giocatori) {
		this.giocatori = giocatori;
	}
	
	public void avvia() {
		
		ArrayList<String> nomiGiocatori = new ArrayList<String>();
		
		for(Map.Entry<String, ServerView> giocatoriConnessi : giocatori.entrySet())
			nomiGiocatori.add(giocatoriConnessi.getKey());
		
		this.model = new Model(nomiGiocatori);
		
		for(Map.Entry<String, ServerView> view : giocatori.entrySet()) 
			model.addObserver(view.getValue());
			
		this.controller = new Controller(model);
		
		for(Map.Entry<String, ServerView> giocatoreConnesso : giocatori.entrySet()) {
			giocatoreConnesso.getValue().addObserver(controller);  //il Controller viene reso Observer di ogni View
			if (giocatoreConnesso.getValue() instanceof SocketView)
				((SocketView) giocatoreConnesso.getValue()).sendLine("OK"); //notifica ai giocatori l'inizio partita
			else if (giocatoreConnesso.getValue() instanceof RMIView)
				((RMIView) giocatoreConnesso.getValue()).sendOK();
		}
		
		model.iniziaPartita();
		System.out.println("Nuova partita avviata! Giocatori: " + nomiGiocatori);
				
	}
}
