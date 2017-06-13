package it.polimi.ingsw.pc15.effetti;

import it.polimi.ingsw.pc15.player.Player;

public class MoltiplicaRisorseCarte extends Effetto {
	
	private int moltiplicatore;

	@Override
	public void attiva(Player player) {
		player.getEffettiAttivi().setMoltiplicatoreRisorseCarte(moltiplicatore);
		
	}
	
	

}
