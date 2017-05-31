package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.plancia.SpazioMercato;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;

public class AzioneOccupaSpazioMercato extends AzioneOccupaSpazio {

	public AzioneOccupaSpazioMercato(Player player, Familiare familiare, SpazioMercato spazio) {
		super(player, familiare, spazio);
	}

	@Override
	public void attiva() {
		
		spazio.aggiungiFamiliare(familiare);
		((SpazioMercato) spazio).getEffetto().attiva(player);
		
	}

	@Override
	public boolean èValida() {
		
		if (familiare.disponibile() == false) {
			System.out.println("Hai già posizionato questo familiare!");
			return false;
		}
		
		if (player.getEffettiAttivi().disponibilitàMercato() == false) {
			System.out.println("Non ti è permesso posizionare un familiare negli spazi del mercato!");
			return false;
		}
		
		if(familiare.getValore() < this.spazio.getValoreMin() )  {
			System.out.println("Il valore del tuo familiare è troppo basso!");
			return false;
		}
		
		if (player.getEffettiAttivi().controllaPermessoSpaziOccupati() == false)
			if (spazio.vuoto() == false) {
				System.out.println("Lo spazio è già occupato!");
				return false;
		}
		
		return true;
	}

}
