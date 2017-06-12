package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;

public class BonusPVChiesa extends Bonus {

	public BonusPVChiesa(int valore) {
		super(valore);
	}

	@Override
	public void attiva(Player player) {
		
		
	}
	
	public String toString() {
		return "Fornisce un bonus di Punti Vittoria durante il rapporto in Vaticano di " + valore;
	}

}
