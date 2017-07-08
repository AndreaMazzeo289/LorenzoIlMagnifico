package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;

/**
 * Classe Pietra sottoclasse di Risorsa.
 */

public class Pietra extends Risorsa  {

	public Pietra(int quantità)  {
		super(quantità);
		this.tipoRisorsa = TipoRisorsa.PIETRA;
		
	}
	
	@Override
	public String toString() {
		return "Pietra";
	}

}
