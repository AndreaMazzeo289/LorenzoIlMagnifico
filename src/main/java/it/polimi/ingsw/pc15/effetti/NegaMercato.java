package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;
/**
 * Sottoclasse di effetto che nega al player la possibilità
 * di accedere al mercato.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */
public class NegaMercato extends Effetto {

	/**
	 * Metodo che nega al player l'accesso al mercato.
	 * 
	 * @param player su cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player) {
		player.getEffettiAttivi().annullaDisponibilitàMercato();
		
	}
	
	public String toString() {
		return ("Annulla la possibilità di posizionare familiari negli spazi del Mercato") ;
	}
	
	

}
