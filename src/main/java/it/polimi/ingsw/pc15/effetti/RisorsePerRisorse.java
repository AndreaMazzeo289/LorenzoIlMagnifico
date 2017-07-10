package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class RisorsePerRisorse extends Moltiplicazione {
	
	private TipoRisorsa tipoRisorsa;

	public RisorsePerRisorse(SetRisorse setRisorse, int quantità, TipoRisorsa tipoRisorsa) {
		super(setRisorse, quantità);
		this.tipoRisorsa = tipoRisorsa;
	}

	/**
	 * Metodo che aggiunge risorse in base alla quantità di un
	 * tipo di risorsa posseduta.
	 * 
	 * @param player u cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player) {
		
		for (int i=0; i<player.getSetRisorse().getRisorsa(tipoRisorsa).getQuantità() / quantità; i++)
			player.getSetRisorse().aggiungi(setRisorse);

	}
	
	public String toString() {
		return ("Ottieni " + setRisorse.toString() + " per ogni " + quantità + " di " + tipoRisorsa.toString()) ;
	}

}
