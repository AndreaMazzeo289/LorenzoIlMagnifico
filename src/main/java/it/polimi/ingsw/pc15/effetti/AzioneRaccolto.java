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
		
		for (Carta territorio : player.getCarte(ColoreCarta.VERDE)) {
			if (valoreDado >= ((Territorio) territorio).getRequisitoRaccolta() ) {
				System.out.println("Attivo raccolto in " + territorio.getNome());
				((Territorio) territorio).getEffettoRaccolta().attiva(player);
			}
			
			else System.out.println("Il valore del familiare non è sufficiente per attivare la raccolta in " + territorio.getNome());
		}
	}
}
