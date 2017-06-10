package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;

public class BonusRaccolta extends Bonus implements Serializable {
	
	public BonusRaccolta(int valore){
		super(valore);
	}
	
	@Override
	public void attiva(Player player){
		
		player.getEffettiAttivi().incrementaBonusRaccolta(this.valore);
	}
	
}
