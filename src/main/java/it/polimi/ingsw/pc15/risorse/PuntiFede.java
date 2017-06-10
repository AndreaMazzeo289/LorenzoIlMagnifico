package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;

public class PuntiFede extends Risorsa implements Serializable {

	public PuntiFede(int quantità) {
		super(quantità);
		this.tipoRisorsa = TipoRisorsa.PUNTIFEDE;
	}

}
