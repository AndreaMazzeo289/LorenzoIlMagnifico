package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.Leader;
import it.polimi.ingsw.pc15.player.Player;

public class AzioneAttivaEffettoLeader extends AzioneLeader {

	public AzioneAttivaEffettoLeader(Player player, Leader leader) {
		super(player, leader);
	}

	@Override
	public void attiva() {
		
		System.out.println("Attivi l'effetto di " + leader.getNome());
		
		for (Effetto effetto : leader.getEffettoPerTurno() )
			effetto.attiva(player);
		leader.setEffettoAttivato(true);	
	}

	@Override
	public boolean èValida() {
		
		if (leader.giocato() == false) {
			System.out.println("Non hai ancora giocato questo Leader!");
			return false;
		}
		
		if (leader.effettoGiàAttivato()) {
			System.out.println("Hai già attivato l'effetto di questo Leader in questo turno!");
			return false;
		}
		
		return true;
	}

}
