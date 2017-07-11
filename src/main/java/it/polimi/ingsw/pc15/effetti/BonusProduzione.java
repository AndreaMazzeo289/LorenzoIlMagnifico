package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;
/**
 * Sottoclasse di effetto che aggiunge un valore bonus 
 * al familiare per effettuare azione produzione.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */
public class BonusProduzione extends Bonus {
	
	public BonusProduzione(int valore){
		super(valore);
	}
	
	/**
	 * Metodo che aggiunge il bonus al valore del familiare per effettuare
	 * una azione di produzione.
	 * 
	 * @param player su cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player){
		
		player.getEffettiAttivi().incrementaBonusProduzione(this.valore);
	}
	
	public String toString() {
		return ("Fornisce un bonus permanente al valore delle azioni Produzione di " + valore);
	}
	
}
