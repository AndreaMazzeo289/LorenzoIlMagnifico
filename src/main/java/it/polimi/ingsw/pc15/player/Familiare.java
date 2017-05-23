package it.polimi.ingsw.pc15.player;

import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class Familiare {
	
	private final ColoreFamiliare coloreFamiliare;
	private int valore;
	private Player player;
	private boolean disponibilità;
	
	public Familiare (ColoreFamiliare colore, Player player) {
		this.coloreFamiliare = colore;
		this.player = player;
		this.valore = 0;
		this.disponibilità = true;
	}
	
	
	public void setDisponibilità(boolean disponibilità) {
		this.disponibilità = disponibilità;
	}
	
	public void setValore (int valore) {
		this.valore = valore;
	}
	
	public ColoreFamiliare getColore() {
		return this.coloreFamiliare;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public int getValore() {
		return this.valore;
	}
	
	public boolean disponibile() {
		return this.disponibilità;
	}
	
	public void aggiungiServitori() {
		
		int servitoriAggiuntivi = 0;
		//chiedi al player
		this.getPlayer().getSetRisorse().getRisorsa(TipoRisorsa.SERVITORI).aggiungi(-servitoriAggiuntivi);
		
	}

}
