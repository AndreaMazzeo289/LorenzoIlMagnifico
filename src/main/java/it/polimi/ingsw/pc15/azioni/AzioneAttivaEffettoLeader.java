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
				
		for (Effetto effetto : leader.getEffettoPerTurno() )
			effetto.attiva(player);
		leader.setEffettoAttivato(true);	
	}

	@Override
	public RisultatoAzione èValida() {
		
		if (leader.giocato() == false) {
			return new RisultatoAzione(false, player.getNome() + " vuole attivare l'effetto di " + leader.getNome() + " ma deve prima giocare tale carta!");
		}
		
		if (leader.effettoGiàAttivato()) {
			return new RisultatoAzione(false, player.getNome() + " vuole attivare l'effetto di " + leader.getNome() + " ma lo ha già attivato questo turno!");		}
		
		return new RisultatoAzione(true, player.getNome() + " attiva l'effetto di " + leader.getNome() + "!");
	}

}
