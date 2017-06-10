package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;

public class PuntiMilitari extends Risorsa  {

	public PuntiMilitari(int quantità) {
		super(quantità);
		this.tipoRisorsa = TipoRisorsa.PUNTIMILITARI;
	}
}
