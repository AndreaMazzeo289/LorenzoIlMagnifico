package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;


/**
 * Sottoclasse di risorsa definisce l'oggetto punti fede.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */


public class PuntiFede extends Risorsa  {

	public PuntiFede(int quantità) {
		super(quantità);
		this.tipoRisorsa = TipoRisorsa.PUNTIFEDE;
	}
	
	@Override
	public String toString() {
		return "Punti Fede";
	}

}
