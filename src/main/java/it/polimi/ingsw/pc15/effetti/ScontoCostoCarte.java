package it.polimi.ingsw.pc15.effetti;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

/**
 * Sottoclasse di effetto applica uno sconto all'acquisto della carta.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class ScontoCostoCarte extends Effetto {
	
	private SetRisorse sconto;
	private TipoCarta tipoCarta;
	
	public ScontoCostoCarte(SetRisorse sconto, TipoCarta tipoCarta) {
		this.sconto=sconto;
		this.tipoCarta=tipoCarta;
	}

	/**
	 * Metodo che fornisce uno sconto all'acquisto della carta
	 * 
	 * @param player su cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player) {
		player.getEffettiAttivi().aggiungiScontoCostoCarte(tipoCarta, sconto);
	}
	
	public String toString() {
		return ("Fornisce uno sconto di " + sconto.toString() + " quando acquisti una carta " + tipoCarta.name());
	}
	
	

}
