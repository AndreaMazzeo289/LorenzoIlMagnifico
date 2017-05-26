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
		switch(coloreCarta) {
		
			case VERDE: for (int i=0; i<player.getTerritori().size()/quantità; i++)
							player.getSetRisorse().aggiungi(setRisorse);
						break;
						
			case BLU:	for (int i=0; i<player.getPersonaggi().size()/quantità; i++)
							player.getSetRisorse().aggiungi(setRisorse);
						break;
						
			case GIALLO:for (int i=0; i<player.getEdifici().size()/quantità; i++)
							player.getSetRisorse().aggiungi(setRisorse);
						break;
						
			case VIOLA: for (int i=0; i<player.getImprese().size()/quantità; i++)
							player.getSetRisorse().aggiungi(setRisorse);
						break;
						
		}
		
	}

}
