package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;
/**
 * Sottoclasse di effetto permette di guadagnare punti vittoria 
 * rinunciando ai propri punti fede.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */
public class BonusPVChiesa extends Bonus {

	public BonusPVChiesa(int valore) {
		super(valore);
	}

	/**
	 * Metodo che permette di guadagnare punti vittoria in base ai punti fede.
	 * 
	 * @param player su cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player) {
		
		
	}
	
	public String toString() {
		return "Fornisce un bonus di Punti Vittoria durante il rapporto in Vaticano di " + valore;
	}

}
