package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import it.polimi.ingsw.pc15.player.Leader;
import it.polimi.ingsw.pc15.player.Player;

public class CopiaEffettoLeader extends Effetto {

	@Override
	public void attiva(Player player) {
		
		ArrayList<Leader> leaderCopiabili = new ArrayList<Leader>();
		for (Player avversario : player.getAvversari())
			for (Leader leaderAvversario : avversario.getCarteLeader())
				if (leaderAvversario.giocato())
					leaderCopiabili.add(leaderAvversario);
		
		System.out.println("Di quale leader vuoi copiare l'effetto?");
		
		for (int i=0; i<leaderCopiabili.size(); i++)
			System.out.println("("+i+")  " + leaderCopiabili.get(i).getNome());
		
		Scanner in = new Scanner(System.in);
		int scelta = in.nextInt();
		
		for (Effetto effetto : leaderCopiabili.get(scelta).getEffettoPermanente())
			effetto.attiva(player);

	}

	
	public String toString() {
		return "Copia l'effetto di un altro Leader in gioco" ;
	}
}
