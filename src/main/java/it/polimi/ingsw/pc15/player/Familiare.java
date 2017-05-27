package it.polimi.ingsw.pc15.player;

import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class Familiare {
	
	private Player player;
	private final ColoreFamiliare coloreFamiliare;
	private int valore;
	private int valoreBonus;
	private boolean disponibilità;
	private boolean valoreFissato;
	
	public Familiare (ColoreFamiliare colore, Player player) {
		this.coloreFamiliare = colore;
		this.player = player;
		this.valore = 0;
		this.valoreBonus = 0;
		this.disponibilità = true;
		this.valoreFissato = false;
	}
	
	
	public void setDisponibilità(boolean disponibilità) {
		this.disponibilità = disponibilità;
	}
	
	public void setValoreFissato() {
		this.valoreFissato = true;
	}
	
	public void setValore (int valore) {
		if (this.valoreFissato == false)
			this.valore = valore;
	}
	
	public void incrementaValoreBonus (int valoreBonus) {
		this.valoreBonus += valoreBonus;
	}
	
	public ColoreFamiliare getColore() {
		return this.coloreFamiliare;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public int getValoreBonus() {
		return this.valoreBonus;
	}
	
	public int getValore() {
		return (this.valore + this.valoreBonus);
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
