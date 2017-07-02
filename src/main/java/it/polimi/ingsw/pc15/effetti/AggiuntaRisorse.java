package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;
import java.util.Map;

import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.Risorsa;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class AggiuntaRisorse extends Effetto implements Incrementabile  {

	private SetRisorse setRisorse;
	
	public AggiuntaRisorse (SetRisorse setRisorse) {
		
		this.setRisorse = setRisorse;
	}
	
	@Override
	public void attiva(Player player){
		
		player.getSetRisorse().aggiungi(setRisorse);
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
	
	public String toString() {
		return ("Aggiungi " + setRisorse.toString());
	}

}
