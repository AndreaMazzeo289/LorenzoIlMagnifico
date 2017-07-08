package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;
import java.util.Map;
import java.util.Scanner;

import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.Risorsa;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class Scambio extends Effetto implements Incrementabile {
	
	private SetRisorse pagamento1;
	private SetRisorse guadagno1;
	private SetRisorse pagamento2;
	private SetRisorse guadagno2;
	
	public Scambio(SetRisorse pagamento1, SetRisorse guadagno1, SetRisorse pagamento2, SetRisorse guadagno2){
		
		this.pagamento1 = pagamento1;
		this.guadagno1 = guadagno1;
		this.pagamento2 = pagamento2;
		this.guadagno2 = guadagno2;
	}

	/**
	 * Metodo che permette l'attivazione dell'effetto.
	 * 
	 * @param player u cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player) {
		
	}
	
	
	@Override
	public void attivaDaSpazio(Player player) {
		
		if (guadagno1 != null) {
			for (Risorsa risorsa : this.guadagno1.getRisorse().values()) {
				risorsa.aggiungi(risorsa.getQuantità()*player.getEffettiAttivi().getMoltiplicatoreRisorseSpazi()-1);
				risorsa.aggiungi(player.getEffettiAttivi().getRisorsaBonusSpazi(risorsa.getTipoRisorsa()));
			}
		}
		
		if (guadagno2 != null) {
			for (Risorsa risorsa : this.guadagno2.getRisorse().values()) {
				risorsa.aggiungi(risorsa.getQuantità()*player.getEffettiAttivi().getMoltiplicatoreRisorseSpazi()-1);
				risorsa.aggiungi(player.getEffettiAttivi().getRisorsaBonusSpazi(risorsa.getTipoRisorsa()));
			}
		}
		
		attiva(player);
		
		if (guadagno1 != null) {
			for (Risorsa risorsa : this.guadagno1.getRisorse().values()) {
				risorsa.aggiungi(-player.getEffettiAttivi().getRisorsaBonusSpazi(risorsa.getTipoRisorsa()));
				if(player.getEffettiAttivi().getMoltiplicatoreRisorseSpazi()!=1)
					risorsa.aggiungi(-risorsa.getQuantità()/(player.getEffettiAttivi().getMoltiplicatoreRisorseSpazi()*(player.getEffettiAttivi().getMoltiplicatoreRisorseSpazi()-1)));
			}
		}
		
		if (guadagno2 != null) {
			for (Risorsa risorsa : this.guadagno2.getRisorse().values()) {
				risorsa.aggiungi(-player.getEffettiAttivi().getRisorsaBonusSpazi(risorsa.getTipoRisorsa()));
				if(player.getEffettiAttivi().getMoltiplicatoreRisorseSpazi()!=1)
					risorsa.aggiungi(-risorsa.getQuantità()/(player.getEffettiAttivi().getMoltiplicatoreRisorseSpazi()*(player.getEffettiAttivi().getMoltiplicatoreRisorseSpazi()-1)));
			}
		}
		
	}

	@Override
	public void attivaDaCarta(Player player) {
		
		if (guadagno1 != null) {
			for (Risorsa risorsa : this.guadagno1.getRisorse().values()) {
				risorsa.aggiungi(risorsa.getQuantità()*player.getEffettiAttivi().getMoltiplicatoreRisorseCarte()-1);
				risorsa.aggiungi(player.getEffettiAttivi().getRisorsaBonusCarte(risorsa.getTipoRisorsa()));
			}
		}
		
		if (guadagno2 != null) {
			for (Risorsa risorsa : this.guadagno2.getRisorse().values()) {
				risorsa.aggiungi(risorsa.getQuantità()*player.getEffettiAttivi().getMoltiplicatoreRisorseCarte()-1);
				risorsa.aggiungi(player.getEffettiAttivi().getRisorsaBonusCarte(risorsa.getTipoRisorsa()));
			}
		}
		
		attiva(player);
		
		if (guadagno1 != null) {
			for (Risorsa risorsa : this.guadagno1.getRisorse().values()) {
				risorsa.aggiungi(-player.getEffettiAttivi().getRisorsaBonusCarte(risorsa.getTipoRisorsa()));
				if(player.getEffettiAttivi().getMoltiplicatoreRisorseCarte()!=1)
					risorsa.aggiungi(-risorsa.getQuantità()/(player.getEffettiAttivi().getMoltiplicatoreRisorseCarte()*(player.getEffettiAttivi().getMoltiplicatoreRisorseCarte()-1)));
			}
		}
		
		if (guadagno2 != null) {
			for (Risorsa risorsa : this.guadagno2.getRisorse().values()) {
				risorsa.aggiungi(-player.getEffettiAttivi().getRisorsaBonusCarte(risorsa.getTipoRisorsa()));
				if(player.getEffettiAttivi().getMoltiplicatoreRisorseCarte()!=1)
					risorsa.aggiungi(-risorsa.getQuantità()/(player.getEffettiAttivi().getMoltiplicatoreRisorseCarte()*(player.getEffettiAttivi().getMoltiplicatoreRisorseCarte()-1)));
			}
		}
		
	}
}
