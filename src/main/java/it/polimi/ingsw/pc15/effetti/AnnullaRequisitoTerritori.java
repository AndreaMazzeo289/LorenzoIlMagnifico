package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;
/**
 * descr
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */
public class AnnullaRequisitoTerritori extends Effetto {

	/**
	 * Metodo che annulla il guadagno del player in punti vittoria
	 * dovuto alle carte territotrio.
	 * 
	 * @param player su cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player) {
		player.getEffettiAttivi().annullaRequisitoTerritori();
		
	}
	
	public String toString() {
		return "Annulla il requisito di Punti Militari per ottenere nuove carte Territorio";
	}

}
