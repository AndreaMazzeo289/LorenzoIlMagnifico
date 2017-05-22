package it.polimi.ingsw.pc15.carte;

import it.polimi.ingsw.pc15.effetti.Azione;
import it.polimi.ingsw.pc15.player.Player;

public class AzioneCarta extends Azione{
	
	private ColoreCarta coloreCarta;
	
	public AzioneCarta(int valoreDado, ColoreCarta coloreCarta){
		super(valoreDado);
		this.coloreCarta = coloreCarta;
	}
	
	@Override
	public void attiva(Player player){  
	}

}