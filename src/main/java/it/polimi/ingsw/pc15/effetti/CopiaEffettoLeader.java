package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import it.polimi.ingsw.pc15.player.Leader;
import it.polimi.ingsw.pc15.player.Player;


public class CopiaEffettoLeader extends Effetto /*implements EffettoAScelta*/ {

	@Override
	public void attiva(Player player) {

	}

	
	public String toString() {
		return "Copia l'effetto di un altro Leader in gioco" ;
	}


}
