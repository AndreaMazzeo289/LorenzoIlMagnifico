package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;
import java.util.Scanner;

import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;
/**
 *Sottoclasse di effetto che fissa permanentemente il valore di un familiare
 *a scelta del player.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class FissaValoreFamiliareAScelta extends FissaValoreFamiliare{

	public FissaValoreFamiliareAScelta(int valore)  {
		super(null, valore);
	}
	
	/**
	 * Metodo che assegna un valore al familiare a scelta in modo permanente 
	 * non permettendo ulteriori modifica legate a valore dei dadi e bonus aggiuntivi.
	 * 
	 * @param player su cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player) {
		
		fissaValore(player);
		
	}
	
	public String toString() {
		return ("Fissa il valore di un familiare a tua scelta a " + valore) ;

	}	
	


}
