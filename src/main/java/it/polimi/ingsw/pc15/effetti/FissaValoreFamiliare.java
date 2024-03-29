package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;
/**
 *Sottoclasse di effetto che fissa permanentemente il valore di un familiare
 *del player.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */
public class FissaValoreFamiliare extends Effetto { 
	
	protected ColoreFamiliare colore;
	protected int valore;

	public FissaValoreFamiliare(ColoreFamiliare colore, int valore) {
		this.colore = colore;
		this.valore = valore;
	}

	/**
	 * Metodo che assegna un valore al familiare in modo permanente 
	 * non permettendo ulteriori modifica legate a valore dei dadi e bonus aggiuntivi.
	 * 
	 * @param player su cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player) {
		fissaValore(player);
	}
	
	public void fissaValore(Player player) {
		player.getFamiliare(colore).setValore(valore);
		player.getFamiliare(colore).setValoreFissato();
		
	}
	
	public String toString() {
		return ("Fissa il valore del familiare " + colore.name() + " a " + valore) ;
	}
	
	

}
