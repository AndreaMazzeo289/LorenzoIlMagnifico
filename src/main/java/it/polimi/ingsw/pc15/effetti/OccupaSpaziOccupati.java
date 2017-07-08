package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;

public class OccupaSpaziOccupati extends Effetto {


	/**
	 * Metodo che permette l'attivazione dell'effetto.
	 * 
	 * @param player u cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player) {
		player.getEffettiAttivi().concediPermessoSpaziOccupati();
		
	}
	
	public String toString() {
		return ("Consente di posizionare familiari in spazi azione occupati") ;
	}

}
