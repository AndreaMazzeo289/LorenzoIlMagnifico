package it.polimi.ingsw.pc15.azioni;

public class RisultatoAzione {
	
	private final boolean risultato;
	private final String commento;
	
	public RisultatoAzione(boolean risultato, String commento) {
		this.risultato = risultato;
		this.commento = commento;
	}
	
	public boolean getRisultato() {
		return this.risultato;
	}
	
	public String getCommento() {
		return this.commento;	
	}

}
