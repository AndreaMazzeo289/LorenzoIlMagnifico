package it.polimi.ingsw.pc15.plancia;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioConsiglio;
import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioMercato;
import it.polimi.ingsw.pc15.effetti.AggiuntaRisorse;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

/**
 * Classe spazio del consiglio sottoclasse di spazio che riceve in ingresso
 * il valore minimo di posizionamento e il set risorse con cui istanziare
 * il relativo effetto.
 */

public class SpazioConsiglio extends Spazio {
	
	private Effetto effetto;
	
	public SpazioConsiglio(int valoreMin, SetRisorse setRisorse) {
		
		super(valoreMin);
		this.effetto = new AggiuntaRisorse (setRisorse);
	}
	
	/** 
	 * @return ritorna l'effetto legato allo spazio del consiglio(in questo caso aggiunta risorse).
	 */
	
	public Effetto getEffetto() {
		return this.effetto;
	}
	
}
