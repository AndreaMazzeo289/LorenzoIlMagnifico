package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;

/**
 * Classe Servitori sottoclasse di Risorsa.
 */

public class Servitori extends Risorsa  {

	public Servitori(int quantità) {
		super(quantità);
		this.tipoRisorsa = TipoRisorsa.SERVITORI;
	}
	
	@Override
	public String toString() {
		return "Servitori";
	}

}
