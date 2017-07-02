package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.plancia.SpazioMercato;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class AzioneOccupaSpazioMercato extends AzioneOccupaSpazio {

	public AzioneOccupaSpazioMercato(Player player, Familiare familiare, SpazioMercato spazio, int servitoriAggiuntivi) {
		super(player, familiare, spazio, servitoriAggiuntivi);
		this.valoreAzione = familiare.getValore() + servitoriAggiuntivi;
	}

	@Override
	public void attiva() {
		
		pagaServitori();
		
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
		
		if(this.valoreAzione < this.spazio.getValoreMin() ) 
			return new RisultatoAzione(false, "FRASE");
		
		if (spazio.vuoto() == false  &&  player.getEffettiAttivi().controllaPermessoSpaziOccupati()==false)
				return new RisultatoAzione(false, "FRASE");
		
		return new RisultatoAzione(true, player.getNome() + " occupa lo spazio del Mercato!");
	}

}
