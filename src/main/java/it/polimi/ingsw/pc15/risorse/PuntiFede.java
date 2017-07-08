package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;


/**
 * Classe PuntiFede sottoclasse di Risorsa.
 */


public class PuntiFede extends Risorsa  {

	public PuntiFede(int quantità) {
		super(quantità);
		this.tipoRisorsa = TipoRisorsa.PUNTIFEDE;
	}
	
	@Override
	public String toString() {
		return "Punti Fede";
	}

}
