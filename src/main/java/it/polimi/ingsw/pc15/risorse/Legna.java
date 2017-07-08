package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;


/**
 * Classe Legna sottoclasse di Risorsa.
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
