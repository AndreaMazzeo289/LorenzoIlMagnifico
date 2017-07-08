package it.polimi.ingsw.pc15.client;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

import it.polimi.ingsw.pc15.model.StatoPartita;
import it.polimi.ingsw.pc15.plancia.Plancia;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class ClientModel extends Observable {
	
	private Plancia statoPlancia;
	private int periodo;
	private int turno;
	private ArrayList<Player> statoAvversari;
	private Player statoGiocatore;
	private String giocatoreCorrente;
	

	public void aggiorna(StatoPartita stato) {
				
		this.statoPlancia = stato.getStatoPlancia();
		this.periodo = stato.getPeriodo();
		this.turno = stato.getTurno();
		this.statoAvversari = stato.getStatoGiocatori();
		this.giocatoreCorrente = stato.getGiocatoreCorrente();	
		this.statoGiocatore = stato.getStatoGiocatore();
		
		setChanged();
		notifyObservers(new ArrayList(Arrays.asList(stato.getMessaggio(), stato.getFasePartita())));
		
	}
	
	public synchronized Plancia getStatoPlancia() {
		return this.statoPlancia;
	}
	
	public synchronized int getPeriodo() {
		return this.periodo;
	}
	
	public synchronized int getTurno() {
		return this.turno;
	}
	
	public synchronized Player getStatoGiocatore() {
		return this.statoGiocatore;
	}
	
	public synchronized ArrayList<Player> getStatoAvversari() {
		return this.statoAvversari;
	}
	
	public synchronized String getGiocatoreCorrente() {
		return this.giocatoreCorrente;
	}	

}


