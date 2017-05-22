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
		
		switch(this.coloreCarta){
		
		case VERDE : player.getEffettiAttivi().incrementaBonusDadoCarte(0,getValore()); break;
		case BLU : player.getEffettiAttivi().incrementaBonusDadoCarte(1,getValore()); break;
		case GIALLO : player.getEffettiAttivi().incrementaBonusDadoCarte(2,getValore()); break;
		case VIOLA : player.getEffettiAttivi().incrementaBonusDadoCarte(3,getValore()); break;
		case ALL : player.getEffettiAttivi().incrementaBonusDadoCarte(4,getValore()); break;
		
		}
		
	}
	
}
