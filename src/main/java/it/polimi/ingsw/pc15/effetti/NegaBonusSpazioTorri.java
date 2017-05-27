package it.polimi.ingsw.pc15.effetti;

import it.polimi.ingsw.pc15.player.Player;

public class NegaBonusSpazioTorri extends Effetto{

	@Override
	public void attiva(Player player) {
		player.getEffettiAttivi().annullaBonusSpazioTorre();		
	}
	
	

}
