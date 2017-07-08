package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;

public class NegaBonusSpazioTorri extends Effetto {

	/**
	 * Metodo che permette l'attivazione dell'effetto.
	 * 
	 * @param player u cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player) {
		player.getEffettiAttivi().annullaBonusSpazioTorre();		
	}
	
	public String toString() {
		return ("Non ricevi bonus dagli spazi azione delle Torri") ;
	}

}
