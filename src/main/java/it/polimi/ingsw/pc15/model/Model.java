 package it.polimi.ingsw.pc15.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
import it.polimi.ingsw.pc15.player.ColorePlayer;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Leader;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.player.TesseraBonus;
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
	
	private RapportoInVaticano rapportoInVaticano;
	private String messaggio;
	
	private int periodo;
	private int turno;
	private int azione;
	
	
	public Model(ArrayList<String> nomiGiocatori){
		
		Collections.shuffle(nomiGiocatori);

		this.numeroGiocatori = nomiGiocatori.size();
		this.plancia = new Plancia(numeroGiocatori);
		
		giocatori = new ArrayList<Player>();
		for (int i=0; i<numeroGiocatori; i++) 
			giocatori.add(new Player(nomiGiocatori.get(i), ColorePlayer.values()[i]));
		
		this.ordine = nomiGiocatori;
		
		this.messaggio = "";
		
		this.periodo = 1;
		this.turno = 1;
		this.azione = 1;

	}

	public void iniziaPartita() {
		
		generaCarteSviluppo();
		
		distribuisciCarteLeader();

		distribuisciTessereBonus();
		
		distribuisciRisorse();
		
		iniziaNuovoTurno();
		
		notificaStatoPartita("\n  --- PARTITA INIZIATA! ---");
		
	}
	
	private void distribuisciTessereBonus() {
		
		ArrayList<TesseraBonus> tessereBonus = ParserXML.leggiTessereBonus();
		Collections.shuffle(tessereBonus);
		
		for (int i=0; i<numeroGiocatori; i++)
			giocatori.get(i).setTesseraBonus(tessereBonus.get(i));
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
			setRisorseGiocatore.aggiungi(new Oro(i));
			giocatori.get(i).getSetRisorse().aggiungi(setRisorseGiocatore);
		}
		
	}
	
	public void distribuisciCarteLeader() {
		
		carteLeader = ParserXML.leggiCartaLeader();
		Collections.shuffle(carteLeader);	
		int numeroCarteLeader = ParserXML.leggiValore("numeroCarteLeader");
		for (Player giocatore : this.giocatori) {
			for (int i=0; i<numeroCarteLeader; i++) {
				giocatore.getCarteLeader().add(carteLeader.get(0));
				carteLeader.get(0).setPlayer(giocatore);
				carteLeader.remove(0);
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
		
		this.messaggio += "\n  - E' iniziato un nuovo turno! (Periodo: " + this.periodo + "  Turno: " + this.turno + ")";
		
		impostaOrdineGiocatori();
		
		System.out.println("Ordine giocatori: " + ordine);
		
		plancia.libera();
		
		plancia.setCarte(periodo, carteTerritorio, cartePersonaggio, carteEdificio, carteImpresa);
		
		tiraIDadi();
	}
	
	private void finisciTurno() {
		
		if (turno==1 && periodo==1)
			this.rapportoInVaticano = new RapportoInVaticano(this.plancia.getTesseraScomunica(periodo));
				
		if (turno==ParserXML.leggiValore("numeroTurniPerPeriodo")) {
			rapportoInVaticano.avvia();
			this.messaggio += rapportoInVaticano.getRisultato() + "\n";
		}
		
		turno++;
		
		if (turno>ParserXML.leggiValore("numeroTurniPerPeriodo")) {
			periodo++;
			turno=1;
			this.rapportoInVaticano = new RapportoInVaticano(this.plancia.getTesseraScomunica(periodo));
		}
		
		if (periodo>ParserXML.leggiValore("numeroPeriodi"))
			calcolaPunteggio();
		
		else 
			iniziaNuovoTurno();
	}
	

	public void giocatoreSuccessivo() {
		
		if (ordine.lastIndexOf(giocatoreCorrente)==ordine.size()-1) {
			azione++;
			if (azione==2)  {
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
				giocatore.getSetRisorse().aggiungi(new PuntiVittoria(ParserXML.leggiValore("PuntiVittoria" + giocatore.getCarte(TipoCarta.TERRITORIO).size() + "CarteTerritorio")));
			
			if (giocatore.getEffettiAttivi().bonusPuntiVittoriaFinale(TipoCarta.PERSONAGGIO))
				giocatore.getSetRisorse().aggiungi(new PuntiVittoria(ParserXML.leggiValore("PuntiVittoria" + giocatore.getCarte(TipoCarta.TERRITORIO).size() + "CartePersonaggio")));
			
			if (giocatore.getEffettiAttivi().bonusPuntiVittoriaFinale(TipoCarta.IMPRESA))
				for (Carta impresa : giocatore.getCarte(TipoCarta.IMPRESA))
					for (Effetto effetto : impresa.getEffettoPermanente())
						effetto.attiva(giocatore);
			
			int sommaRisorse =  giocatore.getSetRisorse().getRisorsa(TipoRisorsa.PIETRA).getQuantità() + 
								giocatore.getSetRisorse().getRisorsa(TipoRisorsa.LEGNA).getQuantità() +
								giocatore.getSetRisorse().getRisorsa(TipoRisorsa.ORO).getQuantità() +
								giocatore.getSetRisorse().getRisorsa(TipoRisorsa.SERVITORI).getQuantità();
			giocatore.getSetRisorse().aggiungi(new PuntiVittoria(sommaRisorse/5));
			
			classificaPM.put(giocatore.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIMILITARI).getQuantità(), giocatore);
		}
		
		classificaPM.descendingMap().get(classificaPM.firstKey()).getSetRisorse().aggiungi(new PuntiVittoria(5));
		
		for (Player giocatore : giocatori)
			classificaPV.put(giocatore.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIVITTORIA).getQuantità(), giocatore);
		
		messaggio += ("\n  --- FINE PARTITA! ---\n  Classifica dei giocatori:\n");
		
		int i=1;
		for(Entry<Integer, Player> giocatore : classificaPV.descendingMap().entrySet()) {
				messaggio += ("\n  " + i + ". " + giocatore.getValue().getNome()) + "(Punti Vittoria: " + giocatore.getKey() + ")";
			i++;
		}
		
	}
	
	public void rimuoviGiocatore(String name) {
		this.giocatori.remove(getPlayer(name));
		this.ordine.remove(name);
		messaggio += "\n(" + name + " ha abbandonato la partita!)";
	}
	
	public void impostaOrdineGiocatori() {
		
		if (periodo==1 && turno==1)	
			this.giocatoreCorrente = ordine.get(0);
		
		else {
			
			ArrayList<String> nuovoOrdine = new ArrayList<String>();
			for (Familiare familiare : this.plancia.getSpazioConsiglio().getFamiliari())
				if (!nuovoOrdine.contains(familiare.getPlayer().getNome()))
					nuovoOrdine.add(familiare.getPlayer().getNome());
			
			for (String nome : this.ordine)
				if (!nuovoOrdine.contains(nome))
					nuovoOrdine.add(nome);
			
			this.ordine = nuovoOrdine;
			try {
			this.giocatoreCorrente = nuovoOrdine.get(0);
			} catch (IndexOutOfBoundsException e) {}
		}	
	}
	
	public void notificaStatoPartita (String messaggio) {
		
		StatoPartita statoPartita = new StatoPartita(plancia, periodo, turno, azione, giocatori, giocatoreCorrente, messaggio + "\n" + this.messaggio);
		this.messaggio = "";
		setChanged();
		notifyObservers(statoPartita);	
	}
	
	
	public void tiraIDadi() {
		
		Random random = new Random();	
		
		int valoreDadoNero = random.nextInt(6) + 1;
		int valoreDadoBianco = random.nextInt(6) + 1;
		int valoreDadoArancione = random.nextInt(6) + 1;
		
		for(Player player : giocatori) {
			
			player.getFamiliare(ColoreFamiliare.NEUTRO).setValore(0);
			player.getFamiliare(ColoreFamiliare.NERO).setValore(valoreDadoNero);
			player.getFamiliare(ColoreFamiliare.BIANCO).setValore(valoreDadoBianco);
			player.getFamiliare(ColoreFamiliare.ARANCIONE).setValore(valoreDadoArancione);
		}
		
		for (Player player : giocatori)
			for (ColoreFamiliare coloreFamiliare : ColoreFamiliare.values())
				player.getFamiliare(coloreFamiliare).setDisponibilità(true);
					
	}
	
	//-----------------------------------------------------------------------------------------------------------//
	//                    METODI GET                                                                             //
	//-----------------------------------------------------------------------------------------------------------//
	
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
	
	public RapportoInVaticano getRapportoInVaticano() {
		return this.rapportoInVaticano;
	}
	
	public int getTurno() {
		return this.turno;
	}
	
	public int getPeriodo() {
		return this.periodo;
	}
	
	public int getAzione() {
		return this.azione;
	}
	
	public String getGiocatoreCorrente() {
		return this.giocatoreCorrente;
	}

}