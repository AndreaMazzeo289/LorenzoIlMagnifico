package it.polimi.ingsw.pc15.client;

import java.util.ArrayList;
import java.util.Observable;

import it.polimi.ingsw.pc15.model.StatoPartita;
import it.polimi.ingsw.pc15.plancia.Plancia;
import it.polimi.ingsw.pc15.player.Player;

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
	}
	
	public Plancia getStatoPlancia() {
		return this.statoPlancia;
	}
	
	public int getPeriodo() {
		return this.periodo;
	}
	
	public int getTurno() {
		return this.turno;
	}
	
	public Player getStatoGiocatore() {
		return this.statoGiocatore;
	}
	
	public ArrayList<Player> getStatoAvversari() {
		return this.statoAvversari;
	}
	
	public String getGiocatoreCorrente() {
		return this.giocatoreCorrente;
	}
	

}


