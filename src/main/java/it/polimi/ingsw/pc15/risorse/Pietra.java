package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;

/**
 * Sottoclasse di risorsa definisce l'oggetto pietra.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class Pietra extends Risorsa  {

	public Pietra(int quantità)  {
		super(quantità);
		this.tipoRisorsa = TipoRisorsa.PIETRA;
		
	}
	
	@Override
	public String toString() {
		return "Pietra";
	}

}
