package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;

public class BonusProduzione extends Bonus implements Serializable {
	
	public BonusProduzione(int valore){
		super(valore);
	}
	
	@Override
	public void attiva(Player player){
		
		player.getEffettiAttivi().incrementaBonusProduzione(this.valore);
	}
	
}
