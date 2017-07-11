package it.polimi.ingsw.pc15.azioni;

/** 
 * Classe adibita a contenere i risultati legati ai controlli di validità 
 * delle differenti azioni.
 * I metodi èValida infatti retituiscono questo oggetto.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class RisultatoAzione {
	
	private final boolean risultato;
	private final String commento;
	
	public RisultatoAzione(boolean risultato, String commento) {
		this.risultato = risultato;
		this.commento = commento;
	}
	
	/**
	 * @return il risultato true o false feedback del tentativo di convalida di una azione.
	 */
	
	public boolean getRisultato() {
		return this.risultato;
	}
	
	/**
	 * @return il commento feedback del tentativo di convalida di una azione.
	 */
	
	
	public String getCommento() {
		return this.commento;	
	}

}
