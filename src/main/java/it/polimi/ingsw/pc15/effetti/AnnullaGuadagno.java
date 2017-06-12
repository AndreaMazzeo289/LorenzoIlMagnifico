package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.player.Player;

public class AnnullaGuadagno extends Effetto {
	
	private TipoCarta tipoCarta;
	
	public AnnullaGuadagno(TipoCarta tipoCarta){
		
		this.tipoCarta = tipoCarta;	
	}

	@Override
	public void attiva(Player player) {
		player.getEffettiAttivi().annullaBonusPuntiVittoriaFinale(tipoCarta);
		
	}
	
	public String toString() {
		return ("Non guadagni punti Vittoria dalle carte " + tipoCarta.name() + " a fine partita");
	}

	
}
