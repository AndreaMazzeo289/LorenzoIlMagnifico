package it.polimi.ingsw.pc15.effetti;

import java.util.Iterator;

import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.ColoreCarta;
import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.player.Player;

public class AzioneProduzione extends Azione{
	
	public AzioneProduzione(int valoreDado){
		super(valoreDado);
	}
	
	@Override
	public void attiva(Player player){
		
		Iterator<Carta> edificio= player.getCarte(ColoreCarta.GIALLO).iterator();
		
		while(edificio.hasNext()){
			if (valoreDado >= ((Edificio) edificio.next()).getRequisitoProduzione())
				((Edificio) edificio.next()).getEffettoProduzione().attiva(player);
		}
	}
}
