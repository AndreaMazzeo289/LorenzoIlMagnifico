package it.polimi.ingsw.pc15;

public class BonusRaccolta extends Bonus {
	
	public BonusRaccolta(int valore){
		super(valore);
	}
	
	@Override
	public void attiva(Player player){
		
		player.getEffettiAttivi().incrementaBonusRaccolta(getValore());
	}
	
}
