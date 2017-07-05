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
			return new RisultatoAzione(false, player.getNome() + "vuole posizionare il suo familiare " + familiare.getColore().name() + " ma lo ha già posizionato!");
		
		if (player.getEffettiAttivi().disponibilitàMercato() == false)
			return new RisultatoAzione(false, player.getNome() + "vuole posizionare un familiare in uno spazio del mercato ma una scomunica glielo impedisce!");
		
		if(this.valoreAzione < this.spazio.getValoreMin() ) 
			return new RisultatoAzione(false, player.getNome() + "cerca di posizionare il suo familiare " + familiare.getColore().name() + " in uno spazio del mercato, ma il suo valore è troppo basso!");
		
		if (spazio.vuoto() == false  &&  player.getEffettiAttivi().controllaPermessoSpaziOccupati()==false)
			return new RisultatoAzione(false, player.getNome() + "vuole posizionare un familiare in uno spazio del mercato, ma lo spazio è già occupato da " + spazio.getFamiliari().get(0).getPlayer().getNome());
		
		return new RisultatoAzione(true, player.getNome() + " occupa lo spazio del Mercato!");
	}

}
