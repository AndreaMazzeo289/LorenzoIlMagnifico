 package it.polimi.ingsw.pc15.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import com.sun.javafx.collections.MappingChange.Map;

import it.polimi.ingsw.pc15.ParserXML;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.carte.Impresa;
import it.polimi.ingsw.pc15.carte.Personaggio;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.plancia.Plancia;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Leader;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.Legna;
import it.polimi.ingsw.pc15.risorse.Oro;
import it.polimi.ingsw.pc15.risorse.Pietra;
import it.polimi.ingsw.pc15.risorse.Privilegi;
import it.polimi.ingsw.pc15.risorse.PuntiFede;
import it.polimi.ingsw.pc15.risorse.PuntiMilitari;
import it.polimi.ingsw.pc15.risorse.PuntiVittoria;
import it.polimi.ingsw.pc15.risorse.Risorsa;
import it.polimi.ingsw.pc15.risorse.Servitori;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class Model extends Observable {
	
	private int numeroGiocatori;
	private ArrayList<Player> giocatori;
	private Plancia plancia;
	
	private ArrayList<String> ordine;
	private String giocatoreCorrente;
	
	private ArrayList<Carta> carteTerritorio;
	private ArrayList<Carta> cartePersonaggio;
	private ArrayList<Carta> carteEdificio;
	private ArrayList<Carta> carteImpresa;
	private ArrayList<Leader> carteLeader;
	
	private int periodo;
	private int turno;
	private int azione;
	
	
	public Model(ArrayList<String> nomiGiocatori){

		this.numeroGiocatori = nomiGiocatori.size();
		this.plancia = new Plancia(numeroGiocatori);
		
		giocatori = new ArrayList<Player>();
		for (int i=0; i<numeroGiocatori; i++)
			giocatori.add(new Player(nomiGiocatori.get(i)));
		
		this.ordine = nomiGiocatori;
		Collections.shuffle(nomiGiocatori);
		this.giocatoreCorrente = nomiGiocatori.get(0);
		
		this.periodo = 1;
		this.turno = 1;
		this.azione = 1;

	}

	public void iniziaPartita() {
		
		generaCarteSviluppo();
		
		distribuisciCarteLeader();
		
		distribuisciRisorse();
		
		iniziaNuovoTurno();
		
	}
	
	public void distribuisciRisorse() {
		
		HashSet<Risorsa> risorseGiocatore = new HashSet<Risorsa>();
		risorseGiocatore.add(new Oro(5));
		risorseGiocatore.add(new Legna(2));
		risorseGiocatore.add(new Pietra(2));
		risorseGiocatore.add(new Servitori(3));
		risorseGiocatore.add(new PuntiMilitari(0));
		risorseGiocatore.add(new PuntiVittoria(0));
		risorseGiocatore.add(new PuntiFede(0));
		risorseGiocatore.add(new Privilegi(0));
		SetRisorse setRisorseGiocatore = new SetRisorse(risorseGiocatore);
		
		for(int i=0; i<numeroGiocatori; i++) {
			setRisorseGiocatore.getRisorsa(TipoRisorsa.ORO).aggiungi(i);
			giocatori.get(i).getSetRisorse().aggiungi(setRisorseGiocatore);
		}
		
	}
	
	public void distribuisciCarteLeader() {
		
		carteLeader = ParserXML.leggiCartaLeader();
		Collections.shuffle(carteLeader);	
		int numeroCarteLeader = ParserXML.leggiValore("numeroCarteLeader");
		int i=0, j=0;
		while (j<numeroGiocatori) {
			giocatori.get(j).getCarteLeader().add(carteLeader.get(i));
			carteLeader.get(i).setPlayer(giocatori.get(j));
			i++;
			if (i==numeroCarteLeader) {
				i=0;
				j++;
			}
		}
	}	
	
	public void generaCarteSviluppo() {

		carteTerritorio= ParserXML.getCarteXML(TipoCarta.TERRITORIO);
		cartePersonaggio= ParserXML.getCarteXML(TipoCarta.PERSONAGGIO);
		carteEdificio= ParserXML.getCarteXML(TipoCarta.EDIFICIO);
		carteImpresa= ParserXML.getCarteXML(TipoCarta.IMPRESA);
		
		Collections.shuffle(carteTerritorio);
		Collections.shuffle(cartePersonaggio);
		Collections.shuffle(carteEdificio);
		Collections.shuffle(carteImpresa);
		
	}

	public void iniziaNuovoTurno() {
		
		if (!(periodo==1 && turno==1)) {
			
			boolean nuovoGiocatore;
			ArrayList<String> nuovoOrdine = new ArrayList<String>();
			for (Familiare familiare : this.plancia.getSpazioConsiglio().getFamiliari()) {   //per ogni familiare in spazio consiglio
				nuovoGiocatore=true;
				for (String nomeGiocatore : nuovoOrdine)									// controlla i giocatori già aggiunti.
					if (familiare.getPlayer().getNome().equals(nomeGiocatore))			//se hai già aggiunto il proprietario di quel 
						nuovoGiocatore = false;											//familiare, metti false
				if (nuovoGiocatore)
					nuovoOrdine.add(familiare.getPlayer().getNome());                   //altrimenti aggiungilo
			}
			
			for (String nomeGiocatore1 : this.ordine) {                   //per ogni nomeGiocatore nel vecchio ordine
				nuovoGiocatore = true;
				for (String nomeGiocatore2 : nuovoOrdine)                //controlla i giocatori già aggiunti
					if (nomeGiocatore1.equals(nomeGiocatore2))           //se hai giò aggiunto quel nome metti false
						nuovoGiocatore=false;
				if (nuovoGiocatore)
					nuovoOrdine.add(nomeGiocatore1);                     //altrimenti aggiungilo
			}	
			
			this.ordine = nuovoOrdine;
		}
		
		plancia.setCarte(periodo, carteTerritorio, cartePersonaggio, carteEdificio, carteImpresa);
		plancia.libera();
		
		Random random = new Random();	
		int valoreDadoNero = random.nextInt(6) + 1;
		int valoreDadoBianco = random.nextInt(6) + 1;
		int valoreDadoArancione = random.nextInt(6) + 1;
		
		for(Player player : giocatori) {
			
			player.getFamiliare(ColoreFamiliare.NEUTRO).setValore(0);
			player.getFamiliare(ColoreFamiliare.NERO).setValore(valoreDadoNero);
			player.getFamiliare(ColoreFamiliare.BIANCO).setValore(valoreDadoBianco);
			player.getFamiliare(ColoreFamiliare.ARANCIONE).setValore(valoreDadoArancione);
			
			player.getFamiliare(ColoreFamiliare.NEUTRO).setDisponibilità(true);
			player.getFamiliare(ColoreFamiliare.NERO).setDisponibilità(true);
			player.getFamiliare(ColoreFamiliare.BIANCO).setDisponibilità(true);
			player.getFamiliare(ColoreFamiliare.ARANCIONE).setDisponibilità(true);
					
		}
		

		notificaStatoPartita("\nÈ iniziato un nuovo turno! (Periodo: " + periodo + ", Turno: " + turno + ")");

	}
	
	private void finisciTurno() {
		
		notificaStatoPartita("Fine del turno!");
		
		if (turno==2)
			rapportoInVaticano(periodo);
		
		turno++;
		
		if (turno==3) {
			periodo++;
			turno=1;
		}
		
		if (periodo==4)
			calcolaPunteggio();
		
		else 
			iniziaNuovoTurno();
	}

	public void rapportoInVaticano(int periodo) {
		
		int puntiFedeMinimi = ParserXML.leggiValore("puntiFedePeriodo" + Integer.toString(periodo));
		for (Player player :giocatori) {
			if (player.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIFEDE).getQuantità() < puntiFedeMinimi) {
				notificaStatoPartita(player.getNome() + " è stato scomunicato!");
				this.plancia.getTesseraScomunica(periodo).infliggiScomunica(player);
			}
		}
	}
	
	public Player getPlayer(String nome) {
		
		for (Player player : this.giocatori) {
			if (player.getNome().equals(nome))
				return player;
		}
		
		System.out.println("ERRORE: il giocatore cercato non esiste!");
		return null;
	}

	public ArrayList<Player> getPlayers() {
	return this.giocatori;
}

	public Plancia getPlancia() {
		return this.plancia;
	}

	public void giocatoreSuccessivo() {
		
		if (ordine.lastIndexOf(giocatoreCorrente)==ordine.size()-1) {
			azione++;
			if (azione==3)  {
				azione=1;
				finisciTurno();	
			}
			else giocatoreCorrente = ordine.get(0);		
		}
		else giocatoreCorrente = ordine.get(ordine.lastIndexOf(giocatoreCorrente)+1);
	}
	
	public void calcolaPunteggio() {
		
		TreeMap<Integer, Player> classificaPM = new TreeMap<Integer, Player>();
		TreeMap<Integer, Player> classificaPV = new TreeMap<Integer, Player>();
		
		for (Player giocatore : giocatori) {
			
			if (giocatore.getEffettiAttivi().bonusPuntiVittoriaFinale(TipoCarta.TERRITORIO))
				switch (giocatore.getCarte(TipoCarta.TERRITORIO).size()) {
				case 3: giocatore.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIVITTORIA).aggiungi(1); break;
				case 4: giocatore.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIVITTORIA).aggiungi(4); break;
				case 5: giocatore.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIVITTORIA).aggiungi(10); break;
				case 6: giocatore.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIVITTORIA).aggiungi(20); break;
				default: break;
				}
			
			if (giocatore.getEffettiAttivi().bonusPuntiVittoriaFinale(TipoCarta.PERSONAGGIO))
				switch (giocatore.getCarte(TipoCarta.PERSONAGGIO).size()) {
				case 1: giocatore.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIVITTORIA).aggiungi(1); break;
				case 2: giocatore.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIVITTORIA).aggiungi(3); break;
				case 3: giocatore.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIVITTORIA).aggiungi(6); break;
				case 4: giocatore.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIVITTORIA).aggiungi(10); break;
				case 5: giocatore.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIVITTORIA).aggiungi(15); break;
				case 6: giocatore.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIVITTORIA).aggiungi(21); break;
				default: break;
				}
			
			if (giocatore.getEffettiAttivi().bonusPuntiVittoriaFinale(TipoCarta.IMPRESA))
				for (Carta impresa : giocatore.getCarte(TipoCarta.IMPRESA))
					for (Effetto effetto : impresa.getEffettoPermanente())
						effetto.attiva(giocatore);
			
			int sommaRisorse =  giocatore.getSetRisorse().getRisorsa(TipoRisorsa.PIETRA).getQuantità() + 
								giocatore.getSetRisorse().getRisorsa(TipoRisorsa.LEGNA).getQuantità() +
								giocatore.getSetRisorse().getRisorsa(TipoRisorsa.ORO).getQuantità() +
								giocatore.getSetRisorse().getRisorsa(TipoRisorsa.SERVITORI).getQuantità();
			giocatore.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIVITTORIA).aggiungi(sommaRisorse/5);
			
			classificaPM.put(giocatore.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIMILITARI).getQuantità(), giocatore);
		}
		
		classificaPM.get(classificaPM.firstKey()).getSetRisorse().getRisorsa(TipoRisorsa.PUNTIVITTORIA).aggiungi(5);
		classificaPM.remove(classificaPM.firstKey());
		classificaPM.get(classificaPM.firstKey()).getSetRisorse().getRisorsa(TipoRisorsa.PUNTIVITTORIA).aggiungi(2);
		
		for (Player giocatore : giocatori)
			classificaPV.put(giocatore.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIVITTORIA).getQuantità(), giocatore);
		
		notificaStatoPartita("\n  --- FINE PARTITA! ---\nClassifica dei giocatori:");
		int i=1;
		for(Entry<Integer, Player> giocatore : classificaPV.entrySet())
			System.out.println("  " + i + ". " + giocatore.getValue().getNome());
		
		
	}
	

	public void notificaStatoPartita (String messaggio) {
		
		StatoPartita statoPartita = new StatoPartita(plancia, periodo, turno, giocatori, giocatoreCorrente, messaggio);
		setChanged();
		notifyObservers(statoPartita);
		
	}

}