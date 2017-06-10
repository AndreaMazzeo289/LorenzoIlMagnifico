package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;

public class AnnullaRequisitoTerritori extends Effetto implements Serializable {

	@Override
	public void attiva(Player player) {
		player.getEffettiAttivi().annullaRequisitoTerritori();
		
	}

}
