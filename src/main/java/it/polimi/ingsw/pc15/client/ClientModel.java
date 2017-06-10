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
	private ArrayList<Player> statoGiocatori;
	private String giocatoreCorrente;

	
	public void aggiorna(StatoPartita stato) {
		
		this.statoPlancia = stato.getStatoPlancia();
		this.periodo = stato.getPeriodo();
		this.turno = stato.getTurno();
		this.statoGiocatori = stato.getStatoGiocatori();
		this.giocatoreCorrente = stato.getGiocatoreCorrente();	
		
		System.out.println("\nSono il clientModel e sono stato aggiornato! <3");
		
	}
	

}


