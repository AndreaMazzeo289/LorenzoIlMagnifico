package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;

public class Legna extends Risorsa implements Serializable {

	public Legna(int quantità) {
		super(quantità);
		this.tipoRisorsa = TipoRisorsa.LEGNA;
		
	}
	
	@Override
	public String toString() {
		return "Legna";
	}

}
