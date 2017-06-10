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
		
		System.out.println("Occupi spazio mercato!");
		
		spazio.aggiungiFamiliare(familiare);
		familiare.setDisponibilità(false);
		
		(((SpazioMercato) spazio).getEffetto()).attiva(player);
		
	}

	@Override
	public RisultatoAzione èValida() {
		
		if (familiare.disponibile() == false)
			return new RisultatoAzione(false, "FRASE");
		
		if (player.getEffettiAttivi().disponibilitàMercato() == false)
			return new RisultatoAzione(false, "FRASE");
		
		if(familiare.getValore() < this.spazio.getValoreMin() ) 
			return new RisultatoAzione(false, "FRASE");
		
		if (player.getEffettiAttivi().controllaPermessoSpaziOccupati() == false)
			if (spazio.vuoto() == false)
				return new RisultatoAzione(false, "FRASE");
		
		return new RisultatoAzione(true, player.getNome() + " occupa lo spazio del Mercato!");
	}

}
