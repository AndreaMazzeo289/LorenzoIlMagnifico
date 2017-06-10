package it.polimi.ingsw.pc15.model;

import java.io.Serializable;
import java.util.ArrayList;

import it.polimi.ingsw.pc15.plancia.Plancia;
import it.polimi.ingsw.pc15.player.Player;

public class StatoPartita implements Serializable {
	
	private Plancia statoPlancia;
	private int periodo;
	private int turno;
	private ArrayList<Player> statoGiocatori;
	private String giocatoreCorrente;
	private String messaggio;
	
	public StatoPartita (Plancia statoPlancia, int periodo, int turno, ArrayList<Player> statoGiocatori, String giocatoreCorrente, String messaggio) {
		this.statoPlancia = statoPlancia;
		this.periodo = periodo;
		this.turno = turno;
		this.statoGiocatori = statoGiocatori;
		this.giocatoreCorrente = giocatoreCorrente;
		this.messaggio = messaggio;
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
	
	public ArrayList<Player> getStatoGiocatori() {
		return this.statoGiocatori;
	}
	
	public String getGiocatoreCorrente() {
		return this.giocatoreCorrente;
	}
	
	public String getMessaggio() {
		return this.messaggio;
	}

}
