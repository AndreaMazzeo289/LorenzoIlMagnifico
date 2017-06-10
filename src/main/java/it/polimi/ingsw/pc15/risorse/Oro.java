package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;

public class Oro extends Risorsa implements Serializable{

	public Oro(int quantità) {
		super(quantità);
		this.tipoRisorsa = TipoRisorsa.ORO;
		
	}
}
