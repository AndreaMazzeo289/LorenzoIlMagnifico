package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;


/**
 * Classe <em>PuntiFede</em> sottoclasse di <strong>Risorsa</strong>
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
