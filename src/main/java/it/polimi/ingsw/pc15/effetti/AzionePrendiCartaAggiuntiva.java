package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.player.Player;

public class AzionePrendiCartaAggiuntiva extends Effetto {
	
	private TipoCarta tipoCarta;
	private int valore;
	
	public AzionePrendiCartaAggiuntiva (TipoCarta tipoCarta, int valore) {
		this.tipoCarta = tipoCarta;
		this.valore = valore;
	}

	@Override
	public void attiva(Player player) {
		
		
	}
	
	public String toString() {
		return "Puoi effettuare un'azione aggiuntiva di valore " + valore + " per prendere una carta " + tipoCarta.name();
	}
	

}
