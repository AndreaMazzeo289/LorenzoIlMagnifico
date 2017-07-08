package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;


import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.player.Player;

/**
 * Classe effetto che annulla i guadagni in bonus punti vittoria finale del player.
 */

public class AnnullaGuadagno extends Effetto {
	
	private TipoCarta tipoCarta;
	
	public AnnullaGuadagno(TipoCarta tipoCarta){
		
		this.tipoCarta = tipoCarta;	
	}

	/**
	 * Metodo che permette l'attivazione dell'effetto.
	 * 
	 * @param player u cui deve essere attivato l'effetto.
	 */
	
	@Override
	public void attiva(Player player) {
		player.getEffettiAttivi().annullaBonusPuntiVittoriaFinale(tipoCarta);
		
	}
	
	public String toString() {
		return ("Non guadagni punti Vittoria dalle carte " + tipoCarta.name() + " a fine partita");
	}

	
}
