package it.polimi.ingsw.pc15.plancia;

import java.util.Queue;

import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioMercato;
import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioRaccolta;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.Familiare;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Sottoclasse di spazio che definisce lo spazio raccolta instanzione l'oggetto
 * con il relativo valore minimo di posizionamento.
 */


public class SpazioRaccolta extends Spazio {
	
	public SpazioRaccolta(int valoreMin) {
		super(valoreMin);
	}
	
}
