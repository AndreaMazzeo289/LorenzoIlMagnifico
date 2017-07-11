package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.ParserXML;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;


/** 
 * Sotto classe di azione prendi carta che permette di 
 * prendere una carta territorio se rispettate le condizioni di acquisto.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class AzionePrendiCartaTerritorio extends AzionePrendiCarta {

	public AzionePrendiCartaTerritorio(Player player, Carta carta) {
		super(player, carta);
	}
	
	/**
	 * Verifica la validità dell' azione prendi carta territorio.
	 * 
	 * @return il risultato dell'azione.
	 */
	
	
	@Override
	public RisultatoAzione èValida() {
		
		int numeroMaxCarte = ParserXML.leggiValore("numeroMaxCarte");
		
		if (player.getCarte(TipoCarta.TERRITORIO).size() == numeroMaxCarte)
			return new RisultatoAzione(false, player.getNome() + " cerca di prendere " + carta.getNome() + " ma ha raggiunto il limite di carte TERRITORIO!");
		
		if (player.getEffettiAttivi().requisitoTerritoriAttivo())
			if (!player.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIMILITARI).paragona(ParserXML.leggiValore("RequisitoMilitareTerritorio" + Integer.toString(player.getCarte(TipoCarta.TERRITORIO).size()+1))))
				return new RisultatoAzione(false, player.getNome() + " cerca di prendere " + carta.getNome() + " ma non ha abbastanza Punti Militari!");
		
		if (!risorseSufficienti())
			return new RisultatoAzione(false, player.getNome() + " cerca di prendere " + carta.getNome() + " ma non ha abbastanza risorse!");
		
		return new RisultatoAzione(true, player.getNome() + " prende la carta Territorio " + carta.getNome());
	}

}