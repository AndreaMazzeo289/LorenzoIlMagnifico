package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;

public class NegaMercato extends Effetto {

	/**
	 * Metodo che permette l'attivazione dell'effetto.
	 * 
	 * @param player u cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player) {
		player.getEffettiAttivi().annullaDisponibilitàMercato();
		
	}
	
	public String toString() {
		return ("Annulla la possibilità di posizionare familiari negli spazi del Mercato") ;
	}
	
	

}
