package it.polimi.ingsw.pc15.effetti;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
/**
 * descr
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */
public class AzionePrendiCartaAggiuntivaConSconto extends AzionePrendiCartaAggiuntiva {
	
	private SetRisorse sconto;

	
	/**
	 * Metodo che permette di prendere un'altra carta sul tabellone 
	 * rispetto ad un valore specificato aggiungendo anche uno sconto al prezzo
	 * della carta.
	 * 
	 * @param player su cui deve essere attivato l'effetto.
	 */
	
	
	public AzionePrendiCartaAggiuntivaConSconto(TipoCarta tipoCarta, int valore, SetRisorse sconto) {
		super(tipoCarta, valore);
		this.sconto = sconto;
	}
	
	public String toString() {
		return "Puoi effettuare un'azione aggiuntiva di valore " + valore + " per prendere una carta " + tipoCarta.name() + " con sconto " + sconto.toString();
	}

}
