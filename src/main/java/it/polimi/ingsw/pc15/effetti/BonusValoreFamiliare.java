package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Player;

public class BonusValoreFamiliare extends Bonus {

	protected ColoreFamiliare colore;
		
	public BonusValoreFamiliare (ColoreFamiliare colore, int valore){
			
		super(valore);
		this.colore = colore;	
	}
		
	/**
	 * Metodo che modifica il valore del familiare tramite bonus.
	 * 
	 * @param player su cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player) {
		player.getFamiliare(colore).incrementaValoreBonus(valore);
			
	}
		
	public String toString() {
		return ("Modifica il valore del familiare " + colore.name() + " di " + valore) ;
		}
		
		
}		
