package it.polimi.ingsw.pc15.plancia;


import it.polimi.ingsw.pc15.effetti.AggiuntaRisorse;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

/**
 * Definisce gli spazi mercato sottoclasse di spazio.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */


public class SpazioMercato extends Spazio  {
	
	

	private Effetto effetto;
	
	public SpazioMercato(int valoreMin, SetRisorse setRisorse) {
		super(valoreMin);
		this.effetto = new AggiuntaRisorse (setRisorse);
	}
	
	/**
	 * @return l'effetto di aggiunta risorse dipendentemente
	 * dal tipo di spazio mercato.
	 */
	
	public Effetto getEffetto() {
		return this.effetto;
	}
}
