package it.polimi.ingsw.pc15.effetti;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

public class AzionePrendiCartaAggiuntivaConSconto extends AzionePrendiCartaAggiuntiva {
	
	private SetRisorse sconto;

	public AzionePrendiCartaAggiuntivaConSconto(TipoCarta tipoCarta, int valore, SetRisorse sconto) {
		super(tipoCarta, valore);
		this.sconto = sconto;
	}
	
	public String toString() {
		return "Puoi effettuare un'azione aggiuntiva di valore " + valore + " per prendere una carta " + tipoCarta.name() + " con sconto " + sconto.toString();
	}

}
