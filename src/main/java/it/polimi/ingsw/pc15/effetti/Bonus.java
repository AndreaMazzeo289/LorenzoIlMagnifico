package it.polimi.ingsw.pc15.effetti;

import it.polimi.ingsw.pc15.player.Player;

public abstract class Bonus extends Effetto{
	
	private int valore;
	
	public Bonus (int valore) {
		this.valore = valore;
	}

	@Override
	public void attiva(Player player) {
		
		
	}
	
	public int getValore(){
		return this.valore;
	}
}
