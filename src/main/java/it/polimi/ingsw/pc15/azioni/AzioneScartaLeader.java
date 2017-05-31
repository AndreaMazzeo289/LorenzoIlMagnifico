package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.player.Leader;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class AzioneScartaLeader extends AzioneLeader {

	public AzioneScartaLeader(Player player, Leader leader) {
		super(player, leader);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attiva() {	
		
		player.getCarteLeader().remove(leader);
		player.getSetRisorse().getRisorsa(TipoRisorsa.PRIVILEGI).aggiungi(1);		
	}

	@Override
	public boolean èValida() {
		
		if (leader.giocato()) {
			System.out.println("Non puoi scartare un Leader in gioco!");
			return false;
		}
		
		return true;
	}

}
