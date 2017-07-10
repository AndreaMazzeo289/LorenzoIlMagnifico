package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.effetti.AggiuntaPrivilegio;
import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.plancia.SpazioConsiglio;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class AzioneOccupaSpazioConsiglio extends AzioneOccupaSpazio {
	
	private int sceltaRisorse;

	public AzioneOccupaSpazioConsiglio(Player player, Familiare familiare, SpazioConsiglio spazio, int servitoriAggiuntivi, int sceltaRisorse) {
		super(player, familiare, spazio, servitoriAggiuntivi);
		this.valoreAzione = familiare.getValore() + servitoriAggiuntivi;
		this.sceltaRisorse = sceltaRisorse;
	}

	@Override
	public void attiva() {
		
		pagaServitori();
		
		spazio.aggiungiFamiliare(familiare);
		familiare.setDisponibilità(false);
		
		((SpazioConsiglio) spazio).getEffetto().attiva(player);
		new AggiuntaPrivilegio(sceltaRisorse).attiva(player);
	}

	@Override
	public RisultatoAzione èValida() {
		
		if (servitoriAggiuntivi>player.getSetRisorse().getRisorsa(TipoRisorsa.SERVITORI).getQuantità())
			return new RisultatoAzione(false, player.getNome() + " vuole pagare " + servitoriAggiuntivi + " servitori, ma non ne ha abbastanza");
		
		if (familiare.disponibile() == false)
			return new RisultatoAzione(false, player.getNome() + " vuole posizionare il suo familiare " + familiare.getColore().name() + " ma lo ha già posizionato!");
		
		if(this.valoreAzione < spazio.getValoreMin())		
			return new RisultatoAzione(false, player.getNome() + " cerca di posizionare il suo familiare " + familiare.getColore().name() + " nello spazio del Consiglio, ma il valore del familiare è troppo basso!");
		
		return new RisultatoAzione(true, player.getNome() + " occupa lo spazio del Consiglio!");
	}

}
