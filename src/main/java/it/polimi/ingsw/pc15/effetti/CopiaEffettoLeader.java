package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import it.polimi.ingsw.pc15.player.Leader;
import it.polimi.ingsw.pc15.player.Player;

<<<<<<< HEAD
public class CopiaEffettoLeader extends Effetto {
=======
public class CopiaEffettoLeader extends Effetto /*implements EffettoAScelta*/ {
>>>>>>> 3100d7d4b54f28841f2211074778e3b2bed2fc8b

	@Override
	public void attiva(Player player) {

	}

	
	public String toString() {
		return "Copia l'effetto di un altro Leader in gioco" ;
	}

<<<<<<< HEAD
=======


	/*@Override
	public String getScelta() {
		
		String domanda = new String();
		
		domanda += "Di quale leader vuoi copiare l'effetto?";
		
		ArrayList<Leader> leaderCopiabili = new ArrayList<Leader>();
		for (Player avversario : player.getAvversari())
			for (Leader leaderAvversario : avversario.getCarteLeader())
				if (leaderAvversario.giocato())
					leaderCopiabili.add(leaderAvversario);
		
		for (int i=0; i<leaderCopiabili.size(); i++)
			domanda += "  ("+i+")  " + leaderCopiabili.get(i).getNome() + ": " + leaderCopiabili.get(i).getEffettoPermanente().toString();
		
		
		return domanda;

	}*/

>>>>>>> 3100d7d4b54f28841f2211074778e3b2bed2fc8b
}
