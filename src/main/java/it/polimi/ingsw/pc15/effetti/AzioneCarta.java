package it.polimi.ingsw.pc15.effetti;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.player.Player;

public class AzioneCarta extends Azione{
	
	private TipoCarta TipoCarta;
	
	public AzioneCarta(int valoreDado, TipoCarta TipoCarta){
		super(valoreDado);
		this.TipoCarta = TipoCarta;
	}
	
	@Override
	public void attiva(Player player){  
	}

}