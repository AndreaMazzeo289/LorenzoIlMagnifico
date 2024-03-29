package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;

/**
 * Sottoclasse di effetto che permette al player di non 
 * pagare il sovrapprezzo di 3 oro per posizionare il familiare in una torre già occupata.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class AnnullaSovrapprezzoTorri extends Effetto {

	/**
	 * Metodo che nnulla il sovrapprezzo di 3 monete d'oro 
	 * per acquistare carte in torri occupate
	 * 
	 * @param player su cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player) {
		player.getEffettiAttivi().annullaSovrapprezzoTorri();
	}
	
	public String toString() {
		return "Annulla il sovrapprezzo di 3 monete d'oro per acquistare carte in torri occupate";
	}

}
