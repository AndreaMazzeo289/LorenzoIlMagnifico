package it.polimi.ingsw.pc15.effetti;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.player.Player;

public class AzioneCarta extends Azione{
	
	private TipoCarta tipoCarta;
	
	public AzioneCarta(int valoreDado, TipoCarta tipoCarta){
		super(valoreDado);
		this.tipoCarta = tipoCarta;
	}
	
	@Override
	public void attiva(Player player){  
	}

}