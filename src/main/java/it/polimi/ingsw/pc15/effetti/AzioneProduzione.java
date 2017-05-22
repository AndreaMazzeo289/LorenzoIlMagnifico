package it.polimi.ingsw.pc15.effetti;

import java.util.Iterator;

import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.player.Player;

public class AzioneProduzione extends Azione{
	
	public AzioneProduzione(int valoreDado){
		super(valoreDado);
	}
	
	@Override
	public void attiva(Player player){
		
		Iterator<Edificio> edificio= player.getEdifici().iterator();
		
		while(edificio.hasNext()){
			if (valoreDado >= edificio.next().getRequisitoProduzione())
				edificio.next().getEffettoProduzione().attiva(player);
		}
	}
}
