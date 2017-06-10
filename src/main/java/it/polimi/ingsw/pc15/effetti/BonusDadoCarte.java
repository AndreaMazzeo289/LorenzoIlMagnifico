package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.player.Player;

public class BonusDadoCarte extends Bonus implements Serializable {
	
	private TipoCarta TipoCarta;
	
	public BonusDadoCarte (TipoCarta TipoCarta, int valore){
		
		super(valore);
		this.TipoCarta = TipoCarta;
		
	}
	
	@Override
	public void attiva(Player player){
		
		player.getEffettiAttivi().incrementaBonusDadoCarte(TipoCarta, valore);
	}
	
}
