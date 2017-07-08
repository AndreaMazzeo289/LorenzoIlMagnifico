package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;
import java.util.Scanner;

import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;


public class FissaValoreFamiliareAScelta extends FissaValoreFamiliare{

	public FissaValoreFamiliareAScelta(int valore)  {
		super(null, valore);
	}
	
	/**
	 * Metodo che permette l'attivazione dell'effetto.
	 * 
	 * @param player u cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player) {
		
		fissaValore(player);
		
	}
	
	public String toString() {
		return ("Fissa il valore di un familiare a tua scelta a " + valore) ;

	}	
	


}
