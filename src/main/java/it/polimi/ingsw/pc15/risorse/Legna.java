package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;


/**
 * Sottoclasse di risorsa definisce l'oggetto legna.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */



public class Legna extends Risorsa{ 

	public Legna(int quantità) {
		super(quantità);
		this.tipoRisorsa = TipoRisorsa.LEGNA;
		
	}
	

	@Override
	public String toString() {
		return "Legna";
	}

}
