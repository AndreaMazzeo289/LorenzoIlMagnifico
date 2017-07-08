package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;

/**
 * Classe <em>Pietra</em> sottoclasse di <strong>Risorsa</strong>
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
