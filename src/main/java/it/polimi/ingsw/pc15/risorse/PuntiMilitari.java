package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;

/**
 * Sottoclasse di risorsa definisce l'oggetto punti militari.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class PuntiMilitari extends Risorsa  {

	public PuntiMilitari(int quantità) {
		super(quantità);
		this.tipoRisorsa = TipoRisorsa.PUNTIMILITARI;
	}
	
	@Override
	public String toString() {
		return "Punti Militari";
	}
}
