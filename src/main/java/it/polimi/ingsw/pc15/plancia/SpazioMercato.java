package it.polimi.ingsw.pc15.plancia;

import java.util.Queue;

import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioMercato;
import it.polimi.ingsw.pc15.effetti.AggiuntaRisorse;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

public class SpazioMercato extends Spazio {

	private Effetto effetto;
	
	public SpazioMercato(int valoreMin, SetRisorse setRisorse) {
		super(valoreMin);
		this.effetto = new AggiuntaRisorse (setRisorse);
	}
	
	public Effetto getEffetto() {
		return this.effetto;
	}
}
