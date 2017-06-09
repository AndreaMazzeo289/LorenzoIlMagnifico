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
import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioTorre;
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
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;
import it.polimi.ingsw.pc15.server.Connection;

public class Controller extends Observable implements Observer {
	
	private final Model model;
	
	public Controller (Model model) {
		this.model = model;
		
	}
	
	@Override
	public synchronized void update(Observable o, Object input) {
		
		System.out.println("\nSono il controller e ho ricevuto " + ((ArrayList<String>) input) + " da " + ((Connection) o).getName() + "\n");	
		
		parseInput(((Connection) o).getName(), (ArrayList<String>) input);
	}
	
	
	
	public void parseInput(String nomeGiocatore, ArrayList<String> input) {
		
		Azione azioneGiocatore;
		Player giocatore = model.getPlayer(nomeGiocatore);	
		
		System.out.println("Nome giocatore: " + giocatore.getNome());
		System.out.println("Oro giocatore: " + giocatore.getSetRisorse().getRisorsa(TipoRisorsa.ORO).getQuantità());
		System.out.println("Legna giocatore: " + giocatore.getSetRisorse().getRisorsa(TipoRisorsa.LEGNA).getQuantità());
		System.out.println("Pietra giocatore: " + giocatore.getSetRisorse().getRisorsa(TipoRisorsa.PIETRA).getQuantità());
		System.out.println("Servitori giocatore: " + giocatore.getSetRisorse().getRisorsa(TipoRisorsa.SERVITORI).getQuantità());

		
		switch(input.get(0)) {
		
		case "posiziona familiare":
			
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
			default: System.out.println("Errore lettura scelta familiare!");
				familiareAzione = new Familiare(null, null);
				break;
			}
			
			Spazio spazioAzione;
			switch (input.get(2)) {
			case "mercato":
				spazioAzione = model.getPlancia().getSpaziMercato().get(Integer.valueOf(input.get(3)));
				azioneGiocatore = new AzioneOccupaSpazioMercato(giocatore, familiareAzione, (SpazioMercato) spazioAzione);
				break;
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
			case "torre": azioneGiocatore = new AzioneOccupaSpazioTorre(giocatore, familiareAzione, null); //<---- DA FINIRE!!!
				break;
			default: System.out.println("Errore lettura scelta spazio");
				azioneGiocatore = null;
				break;	
			}		
			
			break;
		
		case "gioca Leader": azioneGiocatore = new AzioneGiocaLeader (giocatore, giocatore.getCarteLeader().get(Integer.valueOf(input.get(1))));
			break;
			
		case "scarta Leader": azioneGiocatore = new AzioneScartaLeader (giocatore, giocatore.getCarteLeader().get(Integer.valueOf(input.get(1))));
			break;
			
		case "attiva effetto Leader": azioneGiocatore = new AzioneAttivaEffettoLeader (giocatore, giocatore.getCarteLeader().get(Integer.valueOf(input.get(1))));;
			break;
			
		default: System.out.println("ERRORE");
			azioneGiocatore = null;
			break;
		}
		
		if (azioneGiocatore.èValida()) {
			System.out.println("\nAttivo l'azione!\n");
			azioneGiocatore.attiva();
		}		

		System.out.println("Risorse aggiornate " + giocatore.getNome() + ":");
		System.out.println("Oro giocatore: " + giocatore.getSetRisorse().getRisorsa(TipoRisorsa.ORO).getQuantità());
		System.out.println("Legna giocatore: " + giocatore.getSetRisorse().getRisorsa(TipoRisorsa.LEGNA).getQuantità());
		System.out.println("Pietra giocatore: " + giocatore.getSetRisorse().getRisorsa(TipoRisorsa.PIETRA).getQuantità());
		System.out.println("Servitori giocatore: " + giocatore.getSetRisorse().getRisorsa(TipoRisorsa.SERVITORI).getQuantità());
		
	}
}
