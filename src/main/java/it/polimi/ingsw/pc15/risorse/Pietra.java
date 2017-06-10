package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;

public class Pietra extends Risorsa implements Serializable {

	public Pietra(int quantità)  {
		super(quantità);
		this.tipoRisorsa = TipoRisorsa.PIETRA;
		
	}

}
