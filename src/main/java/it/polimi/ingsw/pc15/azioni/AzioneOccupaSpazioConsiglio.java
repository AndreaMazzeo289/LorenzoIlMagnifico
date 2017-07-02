package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.plancia.SpazioConsiglio;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class AzioneOccupaSpazioConsiglio extends AzioneOccupaSpazio {

	public AzioneOccupaSpazioConsiglio(Player player, Familiare familiare, SpazioConsiglio spazio, int servitoriAggiuntivi) {
		super(player, familiare, spazio, servitoriAggiuntivi);
		this.valoreAzione = familiare.getValore() + servitoriAggiuntivi;
	}

	@Override
	public void attiva() {
		
		pagaServitori();
		
		spazio.aggiungiFamiliare(familiare);
		familiare.setDisponibilità(false);
		
		((SpazioConsiglio) spazio).getEffetto().attiva(player);
	}

	@Override
	public RisultatoAzione èValida() {
		
		if (familiare.disponibile() == false)
			return new RisultatoAzione(false, "FRASE");
		
		if(this.valoreAzione < spazio.getValoreMin())		
			return new RisultatoAzione(false, "FRASE");
		
		return new RisultatoAzione(true, player.getNome() + " occupa lo spazio del Consiglio!");
	}

}
