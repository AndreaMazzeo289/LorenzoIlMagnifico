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
import it.polimi.ingsw.pc15.player.Leader;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.server.Connection;

public class Controller extends Observable implements Observer {
	
	private final Model model;
	
	public Controller (Model model) {
		this.model = model;
		
	}
	
	@Override
	public synchronized void update(Observable o, Object input) {
		
		System.out.println("\nSono il controller e ho ricevuto " + ((ArrayList<String>) input) + " da " + ((Connection) o).getName() );
		System.out.println("Dimensione array: " + ((ArrayList<String>) input).size());
		
		int num = Integer.valueOf(((ArrayList<String>) input).get(1));
		System.out.println("Il numero è " + num);
		
		
		parseInput(((Connection) o).getName(), (ArrayList<String>) input);
	}
	
	public void parseInput(String nomeGiocatore, ArrayList<String> input) {
		
		Azione azioneGiocatore = null;
		Player giocatore = model.getPlayer(nomeGiocatore);	
		
		if (giocatore.getCarteLeader().isEmpty())
			System.out.println("Non ci sono carte leader");
		
		switch(input.get(0)) {
		
		case "occupa spazio":
			
			Familiare familiareAzione;
			switch (input.get(1)) {
			case "familiare nero": familiareAzione = giocatore.getFamiliare(ColoreFamiliare.NERO); 
				break;
			case "familiare bianco": familiareAzione = giocatore.getFamiliare(ColoreFamiliare.BIANCO); 
				break;
			case "familiare arancione": familiareAzione = giocatore.getFamiliare(ColoreFamiliare.ARANCIONE); 
				break;
			case "familiare neutro": familiareAzione = giocatore.getFamiliare(ColoreFamiliare.NEUTRO); 
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
		
		case "gioca Leader": azioneGiocatore = new AzioneGiocaLeader (giocatore, giocatore.getCarteLeader().get(Integer.valueOf(input.get(1))));
			break;
		case "scarta Leader": azioneGiocatore = new AzioneScartaLeader (giocatore, giocatore.getCarteLeader().get(Integer.valueOf(input.get(1))));
			break;
		case "attiva effetto Leader": azioneGiocatore = new AzioneAttivaEffettoLeader (giocatore, giocatore.getCarteLeader().get(Integer.valueOf(input.get(1))));;
			break;
		default: 
			System.out.println("ERRORE");
			azioneGiocatore = null;
			break;
		}
		
		if (azioneGiocatore.èValida()) {
			azioneGiocatore.attiva();
		}
	}

}
