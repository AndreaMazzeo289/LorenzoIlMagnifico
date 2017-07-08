package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;

/**
 * Classe PuntiMilitari sottoclasse di Risorsa.
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
