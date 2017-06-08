package it.polimi.ingsw.pc15.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import it.polimi.ingsw.pc15.azioni.Azione;
import it.polimi.ingsw.pc15.azioni.AzioneAttivaEffettoLeader;
import it.polimi.ingsw.pc15.azioni.AzioneGiocaLeader;
import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazio;
import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioConsiglio;
import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioMercato;
import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioProduzione;
import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioRaccolta;
import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioRaccolta;
import it.polimi.ingsw.pc15.azioni.AzioneScartaLeader;
import it.polimi.ingsw.pc15.model.Model;
import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.plancia.SpazioConsiglio;
import it.polimi.ingsw.pc15.plancia.SpazioMercato;
import it.polimi.ingsw.pc15.plancia.SpazioProduzione;
import it.polimi.ingsw.pc15.plancia.SpazioRaccolta;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Familiare;
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
		parseInput(((Connection) o).getName(), (ArrayList<String>) input);
	}
	
	public void parseInput(String nomeGiocatore, ArrayList<String> input) {
		
		Azione azioneGiocatore = null;
		Player giocatore = model.getPlayer(nomeGiocatore);
		
		
		switch(input.get(0)) {
		
		case "occupa spazio":
			
			Familiare familiareAzione;
			switch(input.get(1)) {
			case "nero": familiareAzione = giocatore.getFamiliare(ColoreFamiliare.NERO); 
				break;
			case "bianco": familiareAzione = giocatore.getFamiliare(ColoreFamiliare.BIANCO); 
				break;
			case "arancione": familiareAzione = giocatore.getFamiliare(ColoreFamiliare.ARANCIONE); 
				break;
			case "neutro": familiareAzione = giocatore.getFamiliare(ColoreFamiliare.NEUTRO); 
				break;
			default: familiareAzione = new Familiare(null, null);
				break;
			}
			
			Spazio spazioAzione;
			switch (input.get(2)) {
			case "mercato":
				spazioAzione = model.getPlancia().getSpaziMercato().get(Integer.valueOf(input.get(3)));
				azioneGiocatore = new AzioneOccupaSpazioMercato(giocatore, familiareAzione, (SpazioMercato) spazioAzione);
			case "consiglio": 
				spazioAzione = model.getPlancia().getSpazioConsiglio();
				azioneGiocatore = new AzioneOccupaSpazioConsiglio(giocatore, familiareAzione, (SpazioConsiglio) spazioAzione);
				break;
			case "raccolta": 
				spazioAzione = model.getPlancia().getSpazioRaccolta();
				azioneGiocatore = new AzioneOccupaSpazioRaccolta(giocatore, familiareAzione, (SpazioRaccolta) spazioAzione);
				break;
			case "produzione": 
				spazioAzione = model.getPlancia().getSpazioProduzione();
				azioneGiocatore = new AzioneOccupaSpazioProduzione(giocatore, familiareAzione, (SpazioProduzione) spazioAzione);
				break;
			case "torre":
				break; //DA FINIRE;
		
			}
			
			break;
		
		case "gioca Leader": azioneGiocatore = new AzioneGiocaLeader(giocatore, null);
			break;
		case "scarta Leader": azioneGiocatore = new AzioneScartaLeader(giocatore, null);
			break;
		case "attiva effetto Leader": azioneGiocatore = new AzioneAttivaEffettoLeader(giocatore, null);
			break;
		default: azioneGiocatore = null;
			break;
		}
		
		if (azioneGiocatore.èValida()) {
			azioneGiocatore.attiva();
		}
	}

}
