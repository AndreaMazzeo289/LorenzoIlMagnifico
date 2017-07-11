package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;

/**
 * Sottoclasse di risorsa definisce l'oggetto punti vittoria.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class PuntiVittoria extends Risorsa  {

	public PuntiVittoria(int quantità) {
		super(quantità);
		this.tipoRisorsa = TipoRisorsa.PUNTIVITTORIA;
	}
	
	@Override
	public String toString() {
		return "Punti Vittoria";
	}
}
