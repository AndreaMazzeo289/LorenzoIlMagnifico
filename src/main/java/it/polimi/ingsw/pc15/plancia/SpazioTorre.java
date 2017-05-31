package it.polimi.ingsw.pc15.plancia;

import azioni.AzionePrendiCarta;
import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioMercato;
import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioTorre;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.effetti.AggiuntaRisorse;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

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
	
	public void setCarta(Carta carta) {
		this.carta = carta;
		carta.setSpazio(this);
	}
	
	public void rimuoviCarta() {
		this.carta = null;
	}
	
	public Carta getCarta() {
		return this.carta;
	}
	
	public Familiare getFamiliare() {
		return this.familiari.get(0);
	}
	
	public Torre getTorre() {
		return this.torre;
	}
	
	public Effetto getBonusRisorse() {
		return this.bonusRisorse;
	}
	
}
