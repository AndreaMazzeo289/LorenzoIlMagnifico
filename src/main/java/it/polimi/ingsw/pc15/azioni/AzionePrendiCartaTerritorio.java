package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.ParserXML;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class AzionePrendiCartaTerritorio extends AzionePrendiCarta {

	public AzionePrendiCartaTerritorio(Player player, Carta carta) {
		super(player, carta);
	}
	
	@Override
	public RisultatoAzione èValida() {
		
		int numeroMaxCarte = ParserXML.leggiValore("numeroMaxCarte");
		
		if (player.getCarte(TipoCarta.TERRITORIO).size() == numeroMaxCarte)
			return new RisultatoAzione(false, "FRASE");
		
		if (player.getEffettiAttivi().requisitoTerritoriAttivo())
			if (!player.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIMILITARI).paragona(ParserXML.leggiValore("RequisitoMilitareTerritorio" + Integer.toString(player.getCarte(TipoCarta.TERRITORIO).size()+1))))
				return new RisultatoAzione(false, "FRASE");
		
		if (!risorseSufficienti())
			return new RisultatoAzione(false, "FRASE");
		
		return new RisultatoAzione(true, player.getNome() + " prende la carta Territorio " + carta.getNome());
	}

}