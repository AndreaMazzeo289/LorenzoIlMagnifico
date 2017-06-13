package it.polimi.ingsw.pc15.effetti;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

public class ScontoCostoCarte extends Effetto {
	
	private SetRisorse sconto;
	private TipoCarta tipoCarta;

	@Override
	public void attiva(Player player) {
		player.getEffettiAttivi().aggiungiScontoCostoCarte(tipoCarta, sconto);
	}
	
	

}
