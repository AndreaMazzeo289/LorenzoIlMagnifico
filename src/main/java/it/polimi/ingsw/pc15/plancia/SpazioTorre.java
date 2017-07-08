package it.polimi.ingsw.pc15.plancia;

import it.polimi.ingsw.pc15.azioni.AzionePrendiCarta;

import java.io.Serializable;

import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioMercato;
import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioTorre;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.effetti.AggiuntaRisorse;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

/**
 * Sottoclasse di spazio che definisce i singoli spazi torre presente in planci.
 */

public class SpazioTorre extends Spazio {

	private Carta carta;
	private Torre torre;
	private Effetto bonusRisorse;
	

	public SpazioTorre(int valoreMin, SetRisorse setRisorse, Torre torre) {
		super(valoreMin);
		this.carta = null;
		this.bonusRisorse = new AggiuntaRisorse(setRisorse);
		this.torre = torre;
	}
	
	/**
	 * Funzione che associa la carta al relativo spazio.
	 * 
	 * @param carta da posizionare.
	 */
	
	public void setCarta(Carta carta) {
		this.carta = carta;
		carta.setSpazio(this);
	}
	
	/**
	 * Rimuove la carta dallo spazio.
	 */
	
	public void rimuoviCarta() {
		this.carta = null;
	}
	
	/**
	 * @return l'istanza della carta presente nello spazio.
	 */
	
	public Carta getCarta() {
		return this.carta;
	}
	
	/**
	 * @return una delle quattro torri di cui lo spazio fa parte.
	 */
	
	public Torre getTorre() {
		return this.torre;
	}
	
	/**
	 * Funzione che ritorna il familiare posizionato nello spazio torre.
	 * 
	 * @return il familiare posizionato nello spazio.
	 */
	
	public Familiare getFamiliare() {
		return this.familiari.get(0);
	}
	
	/**
	 * @return il bonus risorse associato allo spazio.
	 */
	
	public Effetto getBonusRisorse() {
		return this.bonusRisorse;
	}
	
}
