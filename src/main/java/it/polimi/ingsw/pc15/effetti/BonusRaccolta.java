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
public class BonusRaccolta extends Bonus {
	
	public BonusRaccolta(int valore){
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
		
		player.getEffettiAttivi().incrementaBonusRaccolta(this.valore);
	}
	
	public String toString() {
		return "Fornisce un bonus permanente al valore delle azioni Produzione di " + valore;
	}
	
}
