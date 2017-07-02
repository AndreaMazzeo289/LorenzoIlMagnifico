package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;
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

public abstract class Moltiplicazione extends Effetto implements Incrementabile {

	protected SetRisorse setRisorse;
	protected int quantità;
	
	public Moltiplicazione(SetRisorse setRisorse, int quantità) {
		this.setRisorse = setRisorse;
		this.quantità = quantità;
	}
	
	@Override
	public void attivaDaSpazio(Player player) {
		
		for (Risorsa risorsa : this.setRisorse.getRisorse().values()) {
			risorsa.aggiungi(risorsa.getQuantità()*player.getEffettiAttivi().getMoltiplicatoreRisorseSpazi()-1);
			risorsa.aggiungi(player.getEffettiAttivi().getRisorsaBonusSpazi(risorsa.getTipoRisorsa()));
		}
		
		attiva(player);
		
		for (Risorsa risorsa : this.setRisorse.getRisorse().values()) {
			risorsa.aggiungi(-player.getEffettiAttivi().getRisorsaBonusSpazi(risorsa.getTipoRisorsa()));
			if(player.getEffettiAttivi().getMoltiplicatoreRisorseSpazi()!=1)
				risorsa.aggiungi(-risorsa.getQuantità()/(player.getEffettiAttivi().getMoltiplicatoreRisorseSpazi()*(player.getEffettiAttivi().getMoltiplicatoreRisorseSpazi()-1)));
		
		}

	}

	@Override
	public void attivaDaCarta(Player player) {
		
		for (Risorsa risorsa : this.setRisorse.getRisorse().values()) {
			risorsa.aggiungi(risorsa.getQuantità()*player.getEffettiAttivi().getMoltiplicatoreRisorseCarte()-1);
			risorsa.aggiungi(player.getEffettiAttivi().getRisorsaBonusCarte(risorsa.getTipoRisorsa()));
		}
		
		attiva(player);
		
		for (Risorsa risorsa : this.setRisorse.getRisorse().values()) {
			risorsa.aggiungi(-player.getEffettiAttivi().getRisorsaBonusCarte(risorsa.getTipoRisorsa()));
			if(player.getEffettiAttivi().getMoltiplicatoreRisorseCarte()!=1)
				risorsa.aggiungi(-risorsa.getQuantità()/(player.getEffettiAttivi().getMoltiplicatoreRisorseCarte()*(player.getEffettiAttivi().getMoltiplicatoreRisorseCarte()-1)));
		
		}
		
	}
	
	

}
