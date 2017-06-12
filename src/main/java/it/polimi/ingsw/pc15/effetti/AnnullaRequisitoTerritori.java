package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;

public class AnnullaRequisitoTerritori extends Effetto {

	@Override
	public void attiva(Player player) {
		player.getEffettiAttivi().annullaRequisitoTerritori();
		
	}
	
	public String toString() {
		return "Annulla il requisito di Punti Militari per ottenere nuove carte Territorio";
	}

}
