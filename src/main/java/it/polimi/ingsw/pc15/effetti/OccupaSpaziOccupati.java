package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;
/**
 * Sottoclasse che permette al player di posizionare il familiare in spazi
 * azione già occupati.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */
public class OccupaSpaziOccupati extends Effetto {


	/**
	 * Metodo che permette di posizionare il familiare in spazi azione già occupati.
	 * 
	 * @param player su cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player) {
		player.getEffettiAttivi().concediPermessoSpaziOccupati();
		
	}
	
	public String toString() {
		return ("Consente di posizionare familiari in spazi azione occupati") ;
	}

}
