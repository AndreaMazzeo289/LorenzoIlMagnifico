package it.polimi.ingsw.pc15.effetti;

import it.polimi.ingsw.pc15.carte.ColoreCarta;
import it.polimi.ingsw.pc15.player.Player;

public class BonusDadoCarte extends Bonus{
	
	private ColoreCarta coloreCarta;
	
	public BonusDadoCarte (ColoreCarta coloreCarta, int valore){
		
		super(valore);
		this.coloreCarta = coloreCarta;
		
	}
	
	@Override
	public void attiva(Player player){
		
		player.getEffettiAttivi().incrementaBonusDadoCarte(coloreCarta, valore);
	}
	
}
