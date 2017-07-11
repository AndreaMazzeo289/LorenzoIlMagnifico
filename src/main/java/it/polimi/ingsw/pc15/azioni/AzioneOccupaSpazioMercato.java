package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.effetti.Incrementabile;
import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.plancia.SpazioMercato;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

/** 
 * Sotto classe di azione occupa spazio che permette di 
 * occupare lo spazio mercato.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class AzioneOccupaSpazioMercato extends AzioneOccupaSpazio {

	public AzioneOccupaSpazioMercato(Player player, Familiare familiare, SpazioMercato spazio, int servitoriAggiuntivi) {
		super(player, familiare, spazio, servitoriAggiuntivi);
		this.valoreAzione = familiare.getValore() + servitoriAggiuntivi;
	}

	/**
	 * 
	 * Metodo che permette al player di occupare lo spazio mercato ì per
	 * usufruire dei conseguenti benefici in risorse.
	 */
	
	@Override
	public void attiva() {
		
		pagaServitori();
		
		spazio.aggiungiFamiliare(familiare);
		familiare.setDisponibilità(false);
		
		Effetto effetto = (((SpazioMercato) spazio).getEffetto());
		if (effetto instanceof Incrementabile)
			((Incrementabile) effetto).attivaDaSpazio(player);
		else effetto.attiva(player);
		
	}

	/**
	 * 
	 * Metodo che verifica la validità dell'azione occupa spazio mercato.
	 * 
	 * @return Il risultato della validità dell'azione con Risultato azione.
	 */
	
	@Override
	public RisultatoAzione èValida() {
		
		if (servitoriAggiuntivi>player.getSetRisorse().getRisorsa(TipoRisorsa.SERVITORI).getQuantità())
			return new RisultatoAzione(false, player.getNome() + " vuole pagare " + servitoriAggiuntivi + " servitori, ma non ne ha abbastanza");
		
		if (familiare.disponibile() == false)
			return new RisultatoAzione(false, player.getNome() + " vuole posizionare il suo familiare " + familiare.getColore().name() + " ma lo ha già posizionato!");
		
		if (player.getEffettiAttivi().disponibilitàMercato() == false)
			return new RisultatoAzione(false, player.getNome() + " vuole posizionare un familiare in uno spazio del mercato ma una scomunica glielo impedisce!");
		
		if(this.valoreAzione < this.spazio.getValoreMin() ) 
			return new RisultatoAzione(false, player.getNome() + " cerca di posizionare il suo familiare " + familiare.getColore().name() + " in uno spazio del mercato, ma il valore del familiare è troppo basso!");
		
		if (spazio.vuoto() == false  &&  player.getEffettiAttivi().controllaPermessoSpaziOccupati()==false)
			return new RisultatoAzione(false, player.getNome() + " vuole posizionare un familiare in uno spazio del mercato, ma lo spazio è già occupato da " + spazio.getFamiliari().get(0).getPlayer().getNome());
		
		return new RisultatoAzione(true, player.getNome() + " occupa lo spazio del Mercato!");
	}

}
