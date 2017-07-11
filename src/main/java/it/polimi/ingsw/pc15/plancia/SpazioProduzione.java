package it.polimi.ingsw.pc15.plancia;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioMercato;
import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioProduzione;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.Familiare;

/**
 * Definisce lo spazio produzione sottoclasse di spazio.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */


public class SpazioProduzione extends Spazio {
	
	public SpazioProduzione(int valoreMin) {
		super(valoreMin);
	}
	
}
