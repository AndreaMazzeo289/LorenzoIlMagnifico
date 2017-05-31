package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.player.Player;

public abstract class Azione {
	
	protected Player player;
	
	public Azione (Player player) {
		
		this.player = player;
	}
	
	public abstract void attiva();
	public abstract boolean èValida();

}
