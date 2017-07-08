package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;

public class BonusProduzione extends Bonus {
	
	public BonusProduzione(int valore){
		super(valore);
	}
	
	/**
	 * Metodo che permette l'attivazione dell'effetto.
	 * 
	 * @param player u cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player){
		
		player.getEffettiAttivi().incrementaBonusProduzione(this.valore);
	}
	
	public String toString() {
		return ("Fornisce un bonus permanente al valore delle azioni Produzione di " + valore);
	}
	
}
