package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.effetti.Raccolto;
import it.polimi.ingsw.pc15.effetti.AggiuntaRisorse;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.plancia.SpazioRaccolta;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

/** 
 * Sotto classe di azione occupa spazio che permette di 
 * occupare lo spazio raccolta.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class AzioneOccupaSpazioRaccolta extends AzioneOccupaSpazio {

	public AzioneOccupaSpazioRaccolta(Player player, Familiare familiare, SpazioRaccolta spazio, int servitoriAggiuntivi) {
		super(player, familiare, spazio, servitoriAggiuntivi);
		this.valoreAzione = familiare.getValore() + servitoriAggiuntivi + player.getEffettiAttivi().getBonusRaccolta();
	}

	/**
	 * 
	 * Metodo che permette al player di occupare lo spazio raccolta
	 * ed iniziare l'attività in base al valore del familiare posizionato.
	 */
	
	@Override
	public void attiva() {
		
		pagaServitori();
		
		spazio.aggiungiFamiliare(familiare);
		familiare.setDisponibilità(false);
		
		Effetto effetto = new Raccolto (valoreAzione);
		effetto.attiva(familiare.getPlayer());
	}

	/**
	 * 
	 * Metodo che verifica la validità dell'azione occupa spazio raccolta.
	 * 	 
	 * @return Il risultato della validità dell'azione con Risultato azione.
	 */
	
	@Override
	public RisultatoAzione èValida() {
		
		if (servitoriAggiuntivi>player.getSetRisorse().getRisorsa(TipoRisorsa.SERVITORI).getQuantità())
			return new RisultatoAzione(false, player.getNome() + " vuole pagare " + servitoriAggiuntivi + " servitori, ma non ne ha abbastanza");
		
		if (familiare.disponibile() == false)
			return new RisultatoAzione(false, player.getNome() + " vuole posizionare il suo familiare " + familiare.getColore().name() + " ma lo ha già posizionato!");
		
		for (Familiare familiare : spazio.getFamiliari())
			if (familiare.getPlayer().equals(player) && !(familiare.getColore().equals(ColoreFamiliare.NEUTRO) || this.familiare.getColore().equals(ColoreFamiliare.NEUTRO)))
				return new RisultatoAzione(false, player.getNome() + " vuole posizionare un familiare nello spazio Raccolta, ma non ne può aggiungere altri");
		
		if (spazio.vuoto()==false && player.getEffettiAttivi().controllaPermessoSpaziOccupati()==false)
			valoreAzione -= 3;
		
		if(valoreAzione >= spazio.getValoreMin())
			return new RisultatoAzione(true, player.getNome() + " occupa lo spazio raccolta!");
		else
			return new RisultatoAzione(false, player.getNome() + " cerca di posizionare il suo familiare " + familiare.getColore().name() + " nello spazio raccolta, ma il suo valore è troppo basso!");
	}

}
