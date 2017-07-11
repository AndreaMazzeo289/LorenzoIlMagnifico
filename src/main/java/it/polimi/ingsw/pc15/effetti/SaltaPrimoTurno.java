package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;

/**
 * Sottoclasse di effetto costringe il player a saltare il proprio turno.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class SaltaPrimoTurno extends Effetto {

	/**
	 * Metodo che costringe il giocatore a saltare il proprio turno
	 * 
	 * @param player su cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player) {
		
	}
	
	public String toString() {
		return ("Costringe il giocatore a saltare il proprio primo turno") ;
	}
}
