package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.ParserXML;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class AzionePrendiCartaTerritorio extends AzionePrendiCarta {

	public AzionePrendiCartaTerritorio(Player player, Carta carta) {
		super(player, carta);
	}
	
	@Override
	public boolean èValida() {
		
		int numeroMaxCarte = ParserXML.leggiValore("numeroMaxCarte");
		
		if (player.getCarte(TipoCarta.TERRITORIO).size() == numeroMaxCarte) {
			System.out.println("Hai raggiunto il limite massimo di carte Territorio!");
			return false;
		}
		
		if (player.getEffettiAttivi().requisitoTerritoriAttivo())
			if (!player.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIMILITARI).paragona(ParserXML.leggiValore("RequisitoMilitareTerritorio" + Integer.toString(player.getCarte(TipoCarta.TERRITORIO).size()+1)))) {
				System.out.println("Non hai abbastanza punti militari per ottenere questo Territorio");
				return false;
		}
		
		if (!risorseSufficienti()) {
			System.out.println("Non hai risorse sufficienti per acquistare questa carta!");
			return false;
		}
		
		return true;
	}


	@Override
	public void attiva() {

		pagaCosto();
		daiCarta();
		attivaEffettoIstantaneo();
			
		System.out.println("Il giocatore ha preso la carta TERRITORIO: "  + carta.getNome());
	}

}