package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

public class RisorsePerCarte extends Moltiplicazione implements Serializable {
	
	private TipoCarta TipoCarta;

	public RisorsePerCarte(SetRisorse setRisorse, int quantità, TipoCarta TipoCarta) {
		super(setRisorse, quantità);
		this.TipoCarta = TipoCarta;
	}

	@Override
	public void attiva(Player player) {
		for (int i=0; i<player.getCarte(TipoCarta).size()/quantità; i++)
			player.getSetRisorse().aggiungi(setRisorse);
		}
}
