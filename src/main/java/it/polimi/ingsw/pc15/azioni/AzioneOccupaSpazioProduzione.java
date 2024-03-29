package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.effetti.Produzione;
import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.plancia.SpazioProduzione;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

/** 
 * Sotto classe di azione occupa spazio che permette di 
 * occupare lo spazio produzione.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class AzioneOccupaSpazioProduzione extends AzioneOccupaSpazio {

	public AzioneOccupaSpazioProduzione(Player player, Familiare familiare, SpazioProduzione spazio, int servitoriAggiuntivi) {
		super(player, familiare, spazio, servitoriAggiuntivi);
		this.valoreAzione = familiare.getValore() + servitoriAggiuntivi + player.getEffettiAttivi().getBonusProduzione();
	}

	/**
	 * 
	 * Metodo che permette al player di occupare lo spazio produzione
	 * ed iniziare l'attività  in base al valore del familiare posizionato.
	 */
	
	@Override
	public void attiva() {
		
		pagaServitori();
		
		spazio.aggiungiFamiliare(familiare);
		familiare.setDisponibilità(false);
		
		Effetto effetto = new Produzione(valoreAzione);
		effetto.attiva(familiare.getPlayer());
	}

	/**
	 * 
	 * Metodo che verifica la validità dell'azione occupa spazio produzione.
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
				return new RisultatoAzione(false, player.getNome() + " vuole posizionare un familiare nello spazio Produzione, ma non ne può aggiungere altri");
		
		if (spazio.vuoto()==false && player.getEffettiAttivi().controllaPermessoSpaziOccupati()==false)
			valoreAzione -= 3;
		
		if(valoreAzione >= spazio.getValoreMin())
			return new RisultatoAzione(true, player.getNome() + " occupa lo spazio produzione!");
		else 
			return new RisultatoAzione(false, player.getNome() + " cerca di posizionare il suo familiare " + familiare.getColore().name() + " nello spazio produzione, ma il valore del familiare è troppo basso!");
	}

}
