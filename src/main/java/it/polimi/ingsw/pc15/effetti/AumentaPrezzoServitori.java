package it.polimi.ingsw.pc15.effetti;

import it.polimi.ingsw.pc15.player.Player;
/**
 * Sottoclasse di effetto che aumenta il numero di sevitori necessari 
 * per aumentare di uno il valore del familiare.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */
public class AumentaPrezzoServitori extends Effetto {


	/**
	 * Metodo che aumenta a due il numero di servitori da spendere 
	 * per aumentare il valore di un familiare
	 * 
	 * @param player su cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player) {
		player.getEffettiAttivi().setSovrapprezzoServitori();
	}
	
	public String toString() {
		return "Aumenta a due il numero di servitori da spendere per aumentare il valore di un familiare";
	}

}
