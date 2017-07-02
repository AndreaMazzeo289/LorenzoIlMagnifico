package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public abstract class AzioneOccupaSpazio extends Azione {
	
	protected Spazio spazio;
	protected Familiare familiare;
	protected int servitoriAggiuntivi;
	protected int valoreAzione;

	public AzioneOccupaSpazio(Player player, Familiare familiare, Spazio spazio, int servitoriAggiuntivi) {
		super (player);
		this.spazio = spazio;
		this.familiare = familiare;
		this.servitoriAggiuntivi = servitoriAggiuntivi;
	}
	
	public void pagaServitori() {
		if (player.getEffettiAttivi().sovrapprezzoServitori())
			player.getSetRisorse().getRisorsa(TipoRisorsa.SERVITORI).aggiungi(-2*servitoriAggiuntivi);
		else player.getSetRisorse().getRisorsa(TipoRisorsa.SERVITORI).aggiungi(-servitoriAggiuntivi);
	}
}
