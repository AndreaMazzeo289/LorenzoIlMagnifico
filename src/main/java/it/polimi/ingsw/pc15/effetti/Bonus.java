package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;

public abstract class Bonus extends Effetto {
	
	protected int valore;
	
	public Bonus (int valore) {
		this.valore = valore;
	}
	
	/**
	 * Metodo che permette l'attivazione dell'effetto.
	 * 
	 * @param player u cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public abstract void attiva(Player player);
}
