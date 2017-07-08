package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;

/**
 * Classe <em>PuntiVittoria</em> sottoclasse di <strong>Risorsa</strong>
 */

public class PuntiVittoria extends Risorsa  {

	public PuntiVittoria(int quantità) {
		super(quantità);
		this.tipoRisorsa = TipoRisorsa.PUNTIVITTORIA;
	}
	
	@Override
	public String toString() {
		return "Punti Vittoria";
	}
}
