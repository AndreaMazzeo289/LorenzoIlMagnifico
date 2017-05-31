package azioni;

import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.plancia.SpazioTorre;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;

public class AzioneOccupaSpazioTorre extends AzioneOccupaSpazio {

	public AzioneOccupaSpazioTorre(Player player, Familiare familiare, SpazioTorre spazio) {
		super(player, familiare, spazio);
	}

	@Override
	public void attiva() {
		
		spazio.aggiungiFamiliare(familiare);
		
		if (player.getEffettiAttivi().disponibilitàBonusSpazioTorri())
			((SpazioTorre) spazio).getBonusRisorse().attiva(player);
		
		((SpazioTorre) spazio).getTorre().setOccupata(true);
			
		
	}

	@Override
	public boolean èValida() {
		
		if (familiare.disponibile() == false) {
			System.out.println("Hai già posizionato questo familiare!");
			return false;
		}
		
		if (spazio.vuoto() == false) {
			System.out.println("Lo spazio è già occupato!");
			return false;		
		}
		
		if (controlloFamiliariTorre() == false) {
			System.out.println("Non puoi posizionare altri familiari in questa torre!");
			return false;
		}
					
		if ( familiare.getValore() < spazio.getValoreMin() ) {
			System.out.println("Il valore del tuo familiare è troppo basso!");
			return false;
		}
		
		return true;
	}
	
	public boolean controlloFamiliariTorre() {
		
		for (SpazioTorre spazioTorre : ((SpazioTorre) spazio).getTorre().getSpaziTorre())
			if (spazioTorre.getFamiliare().getPlayer().equals(player) && !(this.familiare.getColore().equals(ColoreFamiliare.NEUTRO) || spazioTorre.getFamiliare().getColore().equals(ColoreFamiliare.NEUTRO)))
				return false;
		
		return true;
		
	}

}
