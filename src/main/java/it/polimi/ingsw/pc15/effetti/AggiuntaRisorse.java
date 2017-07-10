package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;
import java.util.Map;

import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.Risorsa;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

/**
 * Classe effetto che consente di aggiunger risorse al player.
 */

public class AggiuntaRisorse extends Effetto implements Incrementabile  {

	private SetRisorse setRisorse;
	
	public AggiuntaRisorse (SetRisorse setRisorse) {
		
		this.setRisorse = setRisorse;
	}
	
	/**
	 * Effetto che preso il set di risorse con cui l'oggetto è stato 
	 * istanziato lo assegna al player
	 * 
	 * @param player su cui deve essere attivato l'effetto.
	 */
	
	@Override
	public void attiva(Player player){
		
		player.getSetRisorse().aggiungi(setRisorse);
	}


	/**
	 * Classe attiva da spazio per i gli effetti cha hanno necessità di
	 * differenziare l'origine dell'attivazione.
	 * 
	 * @param player per cui deve essere attivato l'effetto.
	 */
	
	@Override
	public void attivaDaSpazio(Player player) {
		
		for (Risorsa risorsa : this.setRisorse.getRisorse().values()) {
			risorsa.aggiungi(risorsa.getQuantità()*(player.getEffettiAttivi().getMoltiplicatoreRisorseSpazi()-1));
			risorsa.aggiungi(player.getEffettiAttivi().getRisorsaBonusSpazi(risorsa.getTipoRisorsa()));
		}
		
		attiva(player);
		
		for (Risorsa risorsa : this.setRisorse.getRisorse().values()) {
			risorsa.aggiungi(-player.getEffettiAttivi().getRisorsaBonusSpazi(risorsa.getTipoRisorsa()));
			if(player.getEffettiAttivi().getMoltiplicatoreRisorseSpazi()!=1)
				risorsa.aggiungi(-risorsa.getQuantità()/(player.getEffettiAttivi().getMoltiplicatoreRisorseSpazi()*(player.getEffettiAttivi().getMoltiplicatoreRisorseSpazi()-1)));
		}

	}
	
	/**
	 * Classe attiva da carta per i gli effetti cha hanno necessità di
	 * differenziare l'origine dell'attivazione.
	 * 
	 * @param player per cui deve essere attivato l'effetto.
	 */

	@Override
	public void attivaDaCarta(Player player) {
		
		for (Risorsa risorsa : this.setRisorse.getRisorse().values()) {
			risorsa.aggiungi(risorsa.getQuantità()*(player.getEffettiAttivi().getMoltiplicatoreRisorseCarte()-1));
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
