package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;

public class Oro extends Risorsa {

	public Oro(int quantità) {
		super(quantità);
		this.tipoRisorsa = TipoRisorsa.ORO;
		
	}
	
	@Override
	public String toString() {
		return "Oro";
	}
}
