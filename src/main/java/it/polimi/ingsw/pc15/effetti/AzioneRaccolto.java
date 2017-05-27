package it.polimi.ingsw.pc15.effetti;

import java.util.Iterator;

import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.ColoreCarta;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.player.Player;

public class AzioneRaccolto extends Azione{
	
	public AzioneRaccolto(int valoreDado){
		super(valoreDado);
	}
	
	@Override
	public void attiva(Player player){
		
		Iterator<Carta> territorio = player.getCarte(ColoreCarta.VERDE).iterator();
		
		while(territorio.hasNext()){
			if (valoreDado >= ((Territorio) territorio.next()).getRequisitoRaccolta())
				((Territorio) territorio.next()).getEffettoRaccolta().attiva(player);
		}
	}
}
