package it.polimi.ingsw.pc15.effetti;

import java.util.Iterator;
import java.util.Map;

import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.carte.Impresa;
import it.polimi.ingsw.pc15.carte.Personaggio;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.Risorsa;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public abstract class Moltiplicazione extends Effetto implements Incrementabile{

	protected SetRisorse setRisorse;
	protected int quantità;
	
	public Moltiplicazione(SetRisorse setRisorse, int quantità) {
		this.setRisorse = setRisorse;
		this.quantità = quantità;
	}
	
	@Override
	public void attivaDaSpazio(Player player) {
		
		for(Map.Entry<TipoRisorsa, Risorsa> risorsa : this.setRisorse.getRisorse().entrySet())
			risorsa.getValue().aggiungi(risorsa.getValue().getQuantità()*player.getEffettiAttivi().getMoltiplicatoreRisorseSpazi()-1);
		this.setRisorse.aggiungi (player.getEffettiAttivi().getRisorseBonusSpazi());
		
		attiva(player);
		
		this.setRisorse.sottrai (player.getEffettiAttivi().getRisorseBonusSpazi());
		for(Map.Entry<TipoRisorsa, Risorsa> risorsa : this.setRisorse.getRisorse().entrySet())
			risorsa.getValue().aggiungi(-risorsa.getValue().getQuantità()/player.getEffettiAttivi().getMoltiplicatoreRisorseSpazi()*(player.getEffettiAttivi().getMoltiplicatoreRisorseSpazi()-1));
		
		
	}

	@Override
	public void attivaDaCarta(Player player) {
		
		for(Map.Entry<TipoRisorsa, Risorsa> risorsa : this.setRisorse.getRisorse().entrySet())
			risorsa.getValue().aggiungi(risorsa.getValue().getQuantità()*player.getEffettiAttivi().getMoltiplicatoreRisorseCarte()-1);
		this.setRisorse.aggiungi (player.getEffettiAttivi().getRisorseBonusCarte());
		
		attiva(player);
		
		this.setRisorse.sottrai (player.getEffettiAttivi().getRisorseBonusCarte());
		for(Map.Entry<TipoRisorsa, Risorsa> risorsa : this.setRisorse.getRisorse().entrySet())
			risorsa.getValue().aggiungi(-risorsa.getValue().getQuantità()/player.getEffettiAttivi().getMoltiplicatoreRisorseCarte()*(player.getEffettiAttivi().getMoltiplicatoreRisorseCarte()-1));
		
	}

}
