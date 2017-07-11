package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.player.Leader;
import it.polimi.ingsw.pc15.player.Player;

/** 
 * Superclasse delle azioni definite per i leader.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public abstract class AzioneLeader extends Azione {
	
	protected Leader leader;
	
	public AzioneLeader(Player player, Leader leader) {
		super(player);
		this.leader = leader;
	}


	
	

}
