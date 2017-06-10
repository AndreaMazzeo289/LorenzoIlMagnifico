package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;

public class PuntiVittoria extends Risorsa implements Serializable {

	public PuntiVittoria(int quantità) {
		super(quantità);
		this.tipoRisorsa = TipoRisorsa.PUNTIVITTORIA;
	}

}
