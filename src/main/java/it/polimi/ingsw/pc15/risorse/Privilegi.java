package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;

/**
 * Classe <em>Privilegi</em> sottoclasse di <strong>Risorsa</strong>
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
