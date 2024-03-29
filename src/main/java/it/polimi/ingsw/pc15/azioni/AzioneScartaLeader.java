package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.effetti.AggiuntaPrivilegio;
import it.polimi.ingsw.pc15.player.Leader;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

/** 
 * Sotto classe di azione leader che permette di scartare un
 * leader guadagnando un privilegio.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class AzioneScartaLeader extends AzioneLeader {
	
	private int sceltaRisorsa;

	public AzioneScartaLeader(Player player, Leader leader, int sceltaRisorsa) {
		super(player, leader);
		this.sceltaRisorsa = sceltaRisorsa;
	}

	
	/**
	 * 
	 * Permette al player di scartare una delle sue carte leader
	 * guadagnando un privilegio da riscattare.
	 */
	
	@Override
	public void attiva() {	
		new AggiuntaPrivilegio(sceltaRisorsa).attiva(player);
		player.getCarteLeader().remove(leader);
	}

	@Override
	public RisultatoAzione èValida() {
		
		if (leader.giocato())
			return new RisultatoAzione(false, " vuole scartare " + leader.getNome() + " ma tale carta è già in gioco!");
		
		return new RisultatoAzione(true, player.getNome() + " scarta la carta Leader " + leader.getNome() + "!");
	}

}
