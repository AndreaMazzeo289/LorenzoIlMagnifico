package it.polimi.ingsw.pc15.plancia;


import it.polimi.ingsw.pc15.effetti.AggiuntaRisorse;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

/**
 * Classe spazio mercato sottoclasse di spazio che riceve in ingresso
 * il valore minimo di posizionamento e il set risorse con cui istanziare
 * il relativo effetto.
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
