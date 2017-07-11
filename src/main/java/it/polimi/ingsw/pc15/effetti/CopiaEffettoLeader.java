package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import it.polimi.ingsw.pc15.player.Leader;
import it.polimi.ingsw.pc15.player.Player;

/**
 * Sottoclasse di effetto che permette di copiare l'effetto di un leader
 * in gioco.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */
public class CopiaEffettoLeader extends Effetto /*implements EffettoAScelta*/ {

	/**
	 * Metodo che permette di copiare l'effetto di un altro leader.
	 * 
	 * @param player su cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player) {

	}

	
	public String toString() {
		return "Copia l'effetto di un altro Leader in gioco" ;
	}


}
