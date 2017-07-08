package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;

public class SaltaPrimoTurno extends Effetto {

	/**
	 * Metodo che permette l'attivazione dell'effetto.
	 * 
	 * @param player u cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player) {
		
	}
	
	public String toString() {
		return ("Costringe il giocatore a saltare il proprio primo turno") ;
	}
}
