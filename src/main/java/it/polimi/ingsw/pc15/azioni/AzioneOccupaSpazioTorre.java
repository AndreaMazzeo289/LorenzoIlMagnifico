package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.plancia.SpazioTorre;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

/** 
 * Sotto classe di azione occupa spazio che permette di 
 * occupare lo spazio di una torre.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class AzioneOccupaSpazioTorre extends AzioneOccupaSpazio {
	
	AzionePrendiCarta azionePrendiCarta;
	int scelta;

	public AzioneOccupaSpazioTorre(Player player, Familiare familiare, SpazioTorre spazio, int servitoriAggiuntivi, int scelta) {
		super(player, familiare, spazio, servitoriAggiuntivi);
		this.scelta = scelta;
		
		this.valoreAzione = familiare.getValore() + servitoriAggiuntivi + player.getEffettiAttivi().getBonusDadoCarte(spazio.getCarta().getTipo()) + player.getEffettiAttivi().getBonusDadoCarte(TipoCarta.ALL);
		
		switch (((SpazioTorre) this.spazio).getCarta().getTipo() ) {
		case EDIFICIO: azionePrendiCarta = new AzionePrendiCartaEdificio (this.player, ((SpazioTorre) this.spazio).getCarta()); break;
		case IMPRESA:azionePrendiCarta = new AzionePrendiCartaImpresa (this.player, ((SpazioTorre) this.spazio).getCarta(), scelta); 	break;
		case PERSONAGGIO: azionePrendiCarta = new AzionePrendiCartaPersonaggio (this.player, ((SpazioTorre) this.spazio).getCarta()); break;
		case TERRITORIO: azionePrendiCarta = new AzionePrendiCartaTerritorio (this.player, ((SpazioTorre) this.spazio).getCarta()); break;
		}
	}

	
	/**
	 * 
	 * Metodo che permette al player di posizionare il familiare in uno spazio di una determinata torre.
	 */
	
	@Override
	public void attiva() {
		
		pagaServitori();
		
		spazio.aggiungiFamiliare(familiare);
		familiare.setDisponibilità(false);
		
		if (player.getEffettiAttivi().disponibilitàBonusSpazioTorri())
			((SpazioTorre) spazio).getBonusRisorse().attiva(player);
		
		azionePrendiCarta.attiva();	
		
		((SpazioTorre) spazio).getTorre().setOccupata(true);
	}

	/**
	 * 
	 * Metodo che verifica le condizioni di contorno all'azione occupa spazio torre 
	 * per verificarne la sua validità.
	 * 
	 * @return Il risultato della validità dell'azione con Risultato azione.
	 */
	
	@Override
	public RisultatoAzione èValida() {
		
		if (servitoriAggiuntivi>player.getSetRisorse().getRisorsa(TipoRisorsa.SERVITORI).getQuantità())
			return new RisultatoAzione(false, player.getNome() + " vuole pagare " + servitoriAggiuntivi + " servitori, ma non ne ha abbastanza");
		
		if (familiare.disponibile() == false)
			return new RisultatoAzione(false, player.getNome() + "cerca di posizionare il suo familiare " + familiare.getColore().name() + " ma lo ha già posizionato!");
		
		if (spazio.vuoto() == false)
			return new RisultatoAzione(false, player.getNome() + " cerca di posizionare un familiare ma lo spazio scelto è occupato");
		
		if (controlloFamiliariTorre() == false)
			return new RisultatoAzione(false, player.getNome() + " cerca di posizionare un familiare in una torre ma ne ha già posizionato un altro");
		
		if ( familiare.getValore() + servitoriAggiuntivi + player.getEffettiAttivi().getBonusDadoCarte(((SpazioTorre) spazio).getCarta().getTipo()) < spazio.getValoreMin() )
			return new RisultatoAzione(false, player.getNome() + " cerca di prendere la carta " + ((SpazioTorre) spazio).getCarta().getTipo().name() + " " + ((SpazioTorre) spazio).getCarta().getNome() + ", ma il valore del suo familiare è troppo basso!");
		
		return this.azionePrendiCarta.èValida();
	}
	
	
	/**
	 * Metodo atto a controllare se negli spazi della torre in cui si sta posizionando
	 * vi sono altri familiari.
	 * 
	 * @return un booleano true o false dipendentemente dalla presenza di familiari nella torre.
	 */
	public boolean controlloFamiliariTorre() {
		
		for (SpazioTorre spazioTorre : ((SpazioTorre) spazio).getTorre().getSpaziTorre())
			if (spazioTorre.vuoto()==false)
				if (spazioTorre.getFamiliare().getPlayer().equals(player) && !(this.familiare.getColore().equals(ColoreFamiliare.NEUTRO) || spazioTorre.getFamiliare().getColore().equals(ColoreFamiliare.NEUTRO)))
					return false;
		
		return true;
		
	}

}
