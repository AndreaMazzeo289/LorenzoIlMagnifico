package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

public class AzionePrendiCartaAggiuntiva extends Effetto {
	
	protected TipoCarta tipoCarta;
	protected int valore;
	
	public AzionePrendiCartaAggiuntiva (TipoCarta tipoCarta, int valore) {
		this.tipoCarta = tipoCarta;
		this.valore = valore;

	}

	/**
	 * Metodo che permette l'attivazione dell'effetto.
	 * 
	 * @param player u cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player) {
		
		
	}
	
	public String toString() {
		return "Puoi effettuare un'azione aggiuntiva di valore " + valore + " per prendere una carta " + tipoCarta.name();
	}
	

}
