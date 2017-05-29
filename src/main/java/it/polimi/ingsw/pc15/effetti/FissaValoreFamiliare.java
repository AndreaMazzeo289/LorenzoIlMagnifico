package it.polimi.ingsw.pc15.effetti;

import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;

public class FissaValoreFamiliare extends Effetto{
	
	protected ColoreFamiliare colore;
	protected int valore;

	public FissaValoreFamiliare(ColoreFamiliare colore, int valore) {
		this.colore = colore;
		this.valore = valore;
	}

	@Override
	public void attiva(Player player) {
		fissaValore(player);
	}
	
	public void fissaValore(Player player) {
		player.getFamiliare(colore).setValore(valore);
		player.getFamiliare(colore).setValoreFissato();
		
	}

}