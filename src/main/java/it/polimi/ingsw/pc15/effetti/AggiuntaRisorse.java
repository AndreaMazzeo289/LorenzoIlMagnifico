package it.polimi.ingsw.pc15.effetti;

import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

public class AggiuntaRisorse extends Effetto {

	private SetRisorse setRisorse;
	
	public AggiuntaRisorse (SetRisorse setRisorse) {
		
		this.setRisorse = setRisorse;
	}
	
	@Override
	public void attiva(Player player){
		
		player.getSetRisorse().aggiungi(setRisorse);
	}
	
	public SetRisorse getSetRisorse() {
		return this.setRisorse;
	}
}
