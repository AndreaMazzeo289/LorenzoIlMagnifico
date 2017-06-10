package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.player.Player;

public class AnnullaGuadagno extends Effetto implements Serializable {
	
	private TipoCarta TipoCarta;
	
	public AnnullaGuadagno(TipoCarta TipoCarta){
		
		this.TipoCarta = TipoCarta;	
	}

	@Override
	public void attiva(Player player) {
		player.getEffettiAttivi().annullaBonusPuntiVittoriaFinale(TipoCarta);
		
	}

	
}
