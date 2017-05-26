package it.polimi.ingsw.pc15.effetti;

import it.polimi.ingsw.pc15.player.Player;

public class BonusRaccolta extends Bonus {
	
	public BonusRaccolta(int valore){
		super(valore);
	}
	
	@Override
	public void attiva(Player player){
		
		player.getEffettiAttivi().incrementaBonusRaccolta(this.valore);
	}
	
}
