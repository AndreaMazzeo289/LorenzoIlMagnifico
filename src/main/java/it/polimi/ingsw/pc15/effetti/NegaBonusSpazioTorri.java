package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;

public class NegaBonusSpazioTorri extends Effetto {

	/**
	 * Metodo che nega l'accesso ai guadagno bonus dati dagli spazi torre.
	 * 
	 * @param player su cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player) {
		player.getEffettiAttivi().annullaBonusSpazioTorre();		
	}
	
	public String toString() {
		return ("Non ricevi bonus dagli spazi azione delle Torri") ;
	}

}
