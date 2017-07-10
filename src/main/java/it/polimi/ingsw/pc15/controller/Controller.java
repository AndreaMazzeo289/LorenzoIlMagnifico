package it.polimi.ingsw.pc15.controller;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import it.polimi.ingsw.pc15.ParserXML;
import it.polimi.ingsw.pc15.azioni.Azione;
import it.polimi.ingsw.pc15.azioni.AzioneAttivaEffettoLeader;
import it.polimi.ingsw.pc15.azioni.AzioneGiocaLeader;
import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazio;
import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioConsiglio;
import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioMercato;
import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioProduzione;
import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioRaccolta;
import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioTorre;
import it.polimi.ingsw.pc15.azioni.AzioneScartaLeader;
import it.polimi.ingsw.pc15.azioni.RisultatoAzione;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.model.Model;
import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.plancia.SpazioConsiglio;
import it.polimi.ingsw.pc15.plancia.SpazioMercato;
import it.polimi.ingsw.pc15.plancia.SpazioProduzione;
import it.polimi.ingsw.pc15.plancia.SpazioRaccolta;
import it.polimi.ingsw.pc15.plancia.SpazioTorre;
import it.polimi.ingsw.pc15.plancia.Torre;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.server.ServerView;;

public class Controller extends Observable implements Observer {
	
	private final Model model;
	
	public Controller (Model model) {
		this.model = model;
		
	}
	
	@Override
	public synchronized void update(Observable o, Object input) {
		
		parseInput(((ServerView) o).getName(), (ArrayList<String>) input);
	}
	
	public void parseInput(String nomeGiocatore, ArrayList<String> input) {
		
		Azione azioneGiocatore;
		Player giocatore = model.getPlayer(nomeGiocatore);	
		boolean connessioneChiusa = false;
		
		
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
			switch (input.get(3)) {
			case "mercato":
				spazioAzione = model.getPlancia().getSpaziMercato().get(Integer.valueOf(input.get(4)));
				azioneGiocatore = new AzioneOccupaSpazioMercato(giocatore, familiareAzione, (SpazioMercato) spazioAzione, Integer.valueOf(input.get(2)));
				break;
			case "consiglio": 
				spazioAzione = model.getPlancia().getSpazioConsiglio();
				azioneGiocatore = new AzioneOccupaSpazioConsiglio(giocatore, familiareAzione, (SpazioConsiglio) spazioAzione, Integer.valueOf(input.get(2)), Integer.valueOf(input.get(4)));
				break;
			case "raccolta": 
				spazioAzione = model.getPlancia().getSpazioRaccolta();
				azioneGiocatore = new AzioneOccupaSpazioRaccolta(giocatore, familiareAzione, (SpazioRaccolta) spazioAzione, Integer.valueOf(input.get(2)));
				break;
			case "produzione": 
				spazioAzione = model.getPlancia().getSpazioProduzione();
				azioneGiocatore = new AzioneOccupaSpazioProduzione(giocatore, familiareAzione, (SpazioProduzione) spazioAzione, Integer.valueOf(input.get(2)));
				break;
			case "torre": Torre torreAzione;
				switch(input.get(4)) {
				case "verde": torreAzione = model.getPlancia().getTorre(TipoCarta.TERRITORIO);
					input.add("0");
					break;
				case "blu": torreAzione = model.getPlancia().getTorre(TipoCarta.PERSONAGGIO);
					input.add("0");
					break;
				case "gialla": torreAzione = model.getPlancia().getTorre(TipoCarta.EDIFICIO);
					input.add("0");
					break;
				case "viola": torreAzione = model.getPlancia().getTorre(TipoCarta.IMPRESA);
					break;
				default: System.out.println("Errore nella lettura torre");
					torreAzione = null;
					break;
				}
				
				spazioAzione = torreAzione.getSpazio(Integer.valueOf(input.get(5))); //NOSONAR
				azioneGiocatore = new AzioneOccupaSpazioTorre(giocatore, familiareAzione, (SpazioTorre) spazioAzione, Integer.valueOf(input.get(2)), Integer.valueOf(input.get(6)));
				break;
				
			default: System.out.println("Errore lettura scelta spazio");
				azioneGiocatore = null;
				break;	
			}		
			
		break;
		
		case "gioca Leader": azioneGiocatore = new AzioneGiocaLeader (giocatore, giocatore.getCarteLeader().get(Integer.valueOf(input.get(1))));
		break;
			
		case "scarta Leader": azioneGiocatore = new AzioneScartaLeader (giocatore, giocatore.getCarteLeader().get(Integer.valueOf(input.get(1))), Integer.valueOf(input.get(2)));
		break;
			
		case "attiva effetto Leader": azioneGiocatore = new AzioneAttivaEffettoLeader (giocatore, giocatore.getCarteLeader().get(Integer.valueOf(input.get(1))));;
		break;
		
		case "CONNESSIONE CHIUSA": connessioneChiusa = true;
			System.out.println("ERRORE");
			azioneGiocatore = null;
		break;
			
		default: System.out.println("ERRORE");
			azioneGiocatore = null;
		break;
		}
		
		if (!connessioneChiusa) {
			RisultatoAzione risultatoAzione = azioneGiocatore.èValida(); //NOSONAR
			if (risultatoAzione.getRisultato()==true) {
				azioneGiocatore.attiva();
				int turno = model.getTurno();
				if (turno==ParserXML.leggiValore("numeroTurniPerPeriodo") && model.getAzione()== ParserXML.leggiValore("numeroAzioniPerTurno"))
					model.getRapportoInVaticano().registraSceltaGiocatore(model.getPlayer(nomeGiocatore), Integer.valueOf(input.get(input.size()-1)));
				if (azioneGiocatore instanceof AzioneOccupaSpazio)
					model.giocatoreSuccessivo();
				String message = "\n"+risultatoAzione.getCommento();
				model.notificaStatoPartita(message);
	
			}
			
			else {
				String message = "\n"+risultatoAzione.getCommento();
				model.notificaStatoPartita(message);
			}
		} else {
			model.rimuoviGiocatore(nomeGiocatore);
			if (model.getGiocatoreCorrente().equals(nomeGiocatore)) {
					model.giocatoreSuccessivo();
					model.notificaStatoPartita("");
			}
		}
	}
}
