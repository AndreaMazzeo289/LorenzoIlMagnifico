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
	
	public String toString() {
		return ("Aggiungi " + setRisorse.toString());
	}

}
