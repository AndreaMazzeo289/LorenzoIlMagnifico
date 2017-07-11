package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;

/**
 * Sottoclasse di risorsa definisce l'oggetto privilegio.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class Privilegi extends Risorsa  {

	public Privilegi(int quantità) {
		super(quantità);
		this.tipoRisorsa = TipoRisorsa.PRIVILEGI;
	}
	
	@Override
	public String toString() {
		return "Privilegi del Consiglio";
	}
}
