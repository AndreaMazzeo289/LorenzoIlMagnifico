package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.plancia.SpazioConsiglio;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;

public class AzioneOccupaSpazioConsiglio extends AzioneOccupaSpazio {

	public AzioneOccupaSpazioConsiglio(Player player, Familiare familiare, SpazioConsiglio spazio) {
		super(player, familiare, spazio);
	}

	@Override
	public void attiva() {
		
		spazio.aggiungiFamiliare(familiare);
		((SpazioConsiglio) spazio).getEffetto().attiva(player);
	}

	@Override
	public boolean èValida() {
		
		if (familiare.disponibile() == false) {
			System.out.println("Hai già posizionato questo familiare!");
			return false;
		}
		
		if(familiare.getValore() < spazio.getValoreMin()) {
			System.out.println("Il valore del tuo familiare è troppo basso!");
			return false;
		}
		return false;
	}

}
