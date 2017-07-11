package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;


import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.player.Player;

/**
 * descr
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */
public class AnnullaGuadagno extends Effetto {
	
	private TipoCarta tipoCarta;
	
	public AnnullaGuadagno(TipoCarta tipoCarta){
		
		this.tipoCarta = tipoCarta;	
	}

	/**
	 * Metodo che annulla i guadagni in punti vittoria del player a fine partita
	 * legati ad un determinato tipo di carta.
	 * 
	 * @param player su cui deve essere attivato l'effetto.
	 */
	
	@Override
	public void attiva(Player player) {
		player.getEffettiAttivi().annullaBonusPuntiVittoriaFinale(tipoCarta);
		
	}
	
	public String toString() {
		return ("Non guadagni punti Vittoria dalle carte " + tipoCarta.name() + " a fine partita");
	}

	
}
