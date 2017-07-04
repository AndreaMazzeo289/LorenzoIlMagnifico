package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.player.Leader;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class AzioneScartaLeader extends AzioneLeader {

	public AzioneScartaLeader(Player player, Leader leader) {
		super(player, leader);
	}

	@Override
	public void attiva() {	
		
		player.getCarteLeader().remove(leader);
	}

	@Override
	public RisultatoAzione èValida() {
		
		if (leader.giocato())
			return new RisultatoAzione(false, " vuole scartare " + leader.getNome() + " ma tale carta è già in gioco!");
		
		return new RisultatoAzione(true, player.getNome() + " scarta la carta Leader " + leader.getNome() + "!");
	}

}
