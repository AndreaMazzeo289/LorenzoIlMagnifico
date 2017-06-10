package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;

public abstract class Bonus extends Effetto implements Serializable {
	
	protected int valore;
	
	public Bonus (int valore) {
		this.valore = valore;
	}

	@Override
	public abstract void attiva(Player player);
}
