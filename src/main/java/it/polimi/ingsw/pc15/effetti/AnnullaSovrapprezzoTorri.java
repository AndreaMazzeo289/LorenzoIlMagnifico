package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;

public class AnnullaSovrapprezzoTorri extends Effetto {

	@Override
	public void attiva(Player player) {
		player.getEffettiAttivi().annullaSovrapprezzoTorri();
	}
	
	public String toString() {
		return "Annulla il sovrapprezzo di 3 monete d'oro per acquistare carte in torri occupate";
	}

}
