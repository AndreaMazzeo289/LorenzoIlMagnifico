package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;

public class Privilegi extends Risorsa implements Serializable {

	public Privilegi(int quantità) {
		super(quantità);
		this.tipoRisorsa = TipoRisorsa.PRIVILEGI;
	}
}
