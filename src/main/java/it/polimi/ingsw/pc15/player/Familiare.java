package it.polimi.ingsw.pc15.player;

import java.io.Serializable;

import it.polimi.ingsw.pc15.risorse.TipoRisorsa;


/**
 * Classe che definisce il familiare.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class Familiare implements Serializable{
	
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
	
	/**
	 * Definisce se questo familiare è utilizzabile o meno dal player.
	 * 
	 * @param disponibilità parametro legato alla possibilità di utilizzo del familiare.
	 */
	
	public void setDisponibilità(boolean disponibilità) {
		this.disponibilità = disponibilità;
	}
	
	/**
	 * Blocca eventuali modifiche al valore del familiare
	 *  per via di determinati effetti.
	 */
	
	public void setValoreFissato() {
		this.valoreFissato = true;
	}
	
	/**
	 * Setta il valore del familiare.
	 * 
	 * @param valore in ingresso a cui settare quello del familiare.
	 */
	
	public void setValore (int valore) {
		if (this.valoreFissato == false)
			this.valore = valore;
	}
	
	/**
	 * Incrementa il punteggio del familiare fornendogli un bonus.
	 * 
	 * @param valoreBonus è il valore di cui va incrementato quello del familiare.
	 */
	
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
	
	public boolean getValoreFissato(){
		
		return this.valoreFissato;
	}
	
	/**
	 * Aggiunge al valore del familiare quello relativo al 
	 * sacrificio di servitori da parte del player.
	 */
	
	public void aggiungiServitori() {
		
		int servitoriAggiuntivi = 0;
		//chiedi al player
		this.getPlayer().getSetRisorse().getRisorsa(TipoRisorsa.SERVITORI).aggiungi(-servitoriAggiuntivi);
		
	}

}
