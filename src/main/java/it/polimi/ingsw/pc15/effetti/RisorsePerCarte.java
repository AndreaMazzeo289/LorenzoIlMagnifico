package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

public class RisorsePerCarte extends Moltiplicazione {
	
	private TipoCarta tipoCarta;

	public RisorsePerCarte(SetRisorse setRisorse, int quantità, TipoCarta tipoCarta) {
		super(setRisorse, quantità);
		this.tipoCarta = tipoCarta;
	}

	@Override
	public void attiva(Player player) {
		for (int i=0; i<player.getCarte(tipoCarta).size()/quantità; i++)
			player.getSetRisorse().aggiungi(setRisorse);
		}
	
	public String toString() {
		return ("Ottieni " + setRisorse.toString() + " per ogni " + quantità + " carte " + tipoCarta.toString()) ;
	}
}
