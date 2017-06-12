package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.ColoreFamiliare;

public class AumentaValoreFamiliare extends BonusValoreFamiliare {

	public AumentaValoreFamiliare(ColoreFamiliare colore, int valore) {
		super(colore, valore);
	}
	
	public String toString() {
		return ("Modifica il valore del familiare " + colore.name() + " di " + valore) ;
	}
	
	

}
