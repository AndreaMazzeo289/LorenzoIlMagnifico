package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.plancia.SpazioMercato;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class AzioneOccupaSpazioMercato extends AzioneOccupaSpazio {

	public AzioneOccupaSpazioMercato(Player player, Familiare familiare, SpazioMercato spazio, int servitoriAggiuntivi) {
		super(player, familiare, spazio, servitoriAggiuntivi);
	}

	@Override
	public void attiva() {
		
		player.getSetRisorse().getRisorsa(TipoRisorsa.SERVITORI).aggiungi(-servitoriAggiuntivi);
		
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
		
		if(familiare.getValore() + servitoriAggiuntivi < this.spazio.getValoreMin() ) 
			return new RisultatoAzione(false, "FRASE");
		
		if (player.getEffettiAttivi().controllaPermessoSpaziOccupati() == false)
			if (spazio.vuoto() == false)
				return new RisultatoAzione(false, "FRASE");
		
		return new RisultatoAzione(true, player.getNome() + " occupa lo spazio del Mercato!");
	}

}
