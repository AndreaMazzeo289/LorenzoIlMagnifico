package it.polimi.ingsw.pc15.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import it.polimi.ingsw.pc15.plancia.Plancia;
import it.polimi.ingsw.pc15.player.Player;

public class StatoPartita implements Serializable {
	
	private Plancia statoPlancia;
	private int periodo;
	private int turno;
	private int azione;
	private ArrayList<Player> statoGiocatori;
	private Player statoGiocatore;
	private String giocatoreCorrente;
	private String messaggio;
	
	public StatoPartita (Plancia statoPlancia, int periodo, int turno, int azione, ArrayList<Player> statoGiocatori, String giocatoreCorrente, String messaggio) {
		this.statoPlancia = statoPlancia;
		this.periodo = periodo;
		this.turno = turno;
		this.azione = azione;
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
	
	public int getAzione() {
		return this.azione;
	}
	
	public ArrayList<Player> getStatoGiocatori() {
		return this.statoGiocatori;
	}
	
	public String getGiocatoreCorrente() {
		return this.giocatoreCorrente;
	}
	
	public Player getStatoGiocatore() {
		return this.statoGiocatore;
	}
	
	public String getMessaggio() {
		return this.messaggio;
	}
	
	public void setGiocatoreCorrente(String name) {
		this.giocatoreCorrente = name;
	}
	
	public void setStatoGiocatore(String nome) {
		
		for (Player giocatore : statoGiocatori)
			if (giocatore.getNome().equals(nome))
				this.statoGiocatore = giocatore;
		
	}
	
	public StatoPartita clone() {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(this);
			
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			return (StatoPartita) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			return null;
		}
		
	}
	

}
