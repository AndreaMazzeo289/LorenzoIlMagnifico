package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.player.Player;

public class BonusDadoCarte extends Bonus {
	
	private TipoCarta tipoCarta;
	
	public BonusDadoCarte (TipoCarta tipoCarta, int valore){
		
		super(valore);
		this.tipoCarta = tipoCarta;
		
	}
	
	@Override
	public void attiva(Player player){
		
		player.getEffettiAttivi().incrementaBonusDadoCarte(tipoCarta, valore);
	}
	
	public String toString() {
		return "Fornisce un bonus al dado di " + valore + " quando prendi delle carte " + tipoCarta.name();
	}
	
}
