package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;

/**
 * Sottoclasse di risorsa definisce l'oggetto oro.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class Oro extends Risorsa {

	public Oro(int quantità) {
		super(quantità);
		this.tipoRisorsa = TipoRisorsa.ORO;
		
	}
	
	@Override
	public String toString() {
		return "Oro";
	}

}
