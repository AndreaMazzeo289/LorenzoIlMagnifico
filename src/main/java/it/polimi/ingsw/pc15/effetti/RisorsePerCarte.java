package it.polimi.ingsw.pc15.effetti;

import it.polimi.ingsw.pc15.carte.ColoreCarta;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

public class RisorsePerCarte extends Moltiplicazione {
	
	private ColoreCarta coloreCarta;

	public RisorsePerCarte(SetRisorse setRisorse, int quantità, ColoreCarta coloreCarta) {
		super(setRisorse, quantità);
		this.coloreCarta = coloreCarta;
	}

	@Override
	public void attiva(Player player) {
		for (int i=0; i<player.getCarte(coloreCarta).size()/quantità; i++)
			player.getSetRisorse().aggiungi(setRisorse);
		}
}
