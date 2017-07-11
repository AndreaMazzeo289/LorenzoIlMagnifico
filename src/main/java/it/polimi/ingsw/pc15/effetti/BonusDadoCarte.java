package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.player.Player;

/**
 * descr
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class BonusDadoCarte extends Bonus {
	
	private TipoCarta tipoCarta;
	
	public BonusDadoCarte (TipoCarta tipoCarta, int valore){
		super(valore);
		this.tipoCarta = tipoCarta;
	}
	
	/**
	 * Metodo che aggiunge il bonus al valore del familiare per prendere determitate carte.
	 * 
	 * @param player su cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player){
		
		player.getEffettiAttivi().incrementaBonusDadoCarte(tipoCarta, valore);
	}
	
	public String toString() {
		return "Fornisce un bonus al dado di " + valore + " quando prendi delle carte " + tipoCarta.name();
	}
	
}
