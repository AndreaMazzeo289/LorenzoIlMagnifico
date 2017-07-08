package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;


/**
 * Classe <em>Legna</em> sottoclasse di <strong>Risorsa</strong>
 */


public class Legna extends Risorsa implements Cloneable {

	public Legna(int quantità) {
		super(quantità);
		this.tipoRisorsa = TipoRisorsa.LEGNA;
		
	}
	

	@Override
	public String toString() {
		return "Legna";
	}

}
