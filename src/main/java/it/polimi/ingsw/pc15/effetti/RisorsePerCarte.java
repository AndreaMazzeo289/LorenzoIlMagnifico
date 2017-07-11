package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
/**
  * Sottoclasse di effetto che aggiunge un tipo di risorsa in base alla quantità
 * di un tipo di carta posseduta.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */
public class RisorsePerCarte extends Moltiplicazione {
	
	private TipoCarta tipoCarta;

	public RisorsePerCarte(SetRisorse setRisorse, int quantità, TipoCarta tipoCarta) {
		super(setRisorse, quantità);
		this.tipoCarta = tipoCarta;
	}

	/**
	 * Metodo che aggiunge risorse in base alla quantità di un
	 * tipo di carta posseduta.
	 * 
	 * @param player u cui deve essere attivato l'effetto.
	 */
	
	@Override
	public void attiva(Player player) {
		for (int i=0; i<player.getCarte(tipoCarta).size()/quantità; i++)
			player.getSetRisorse().aggiungi(setRisorse);
		}
	
	public String toString() {
		return ("Ottieni " + setRisorse.toString() + " per ogni " + quantità + " carte " + tipoCarta.toString()) ;
	}
}
