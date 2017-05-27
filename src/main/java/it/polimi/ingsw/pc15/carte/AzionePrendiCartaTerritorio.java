package it.polimi.ingsw.pc15.carte;

import it.polimi.ingsw.pc15.ParseXML;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class AzionePrendiCartaTerritorio extends AzionePrendiCarta {

	public AzionePrendiCartaTerritorio(Player player, Carta carta) {
		super(player, carta);
	}
	
	@Override
	public boolean requisitiSoddisfatti() {
		
		int numeroMaxCarte = ParseXML.leggiValore("numeroMaxCarte");
		
		if (player.getCarte(ColoreCarta.VERDE).size() == numeroMaxCarte) {
			System.out.println("Hai raggiunto il limite massimo di carte Territorio!");
			return false;
		}
		
		if (player.getEffettiAttivi().requisitoTerritoriAttivo())
			if (!player.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIMILITARI).paragona(ParseXML.leggiValore("RequisitoMilitareTerritorio" + Integer.toString(player.getCarte(ColoreCarta.VERDE).size()+1)))) {
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
	public boolean attiva() {

		if (requisitiSoddisfatti()) {
			pagaCosto();
			daiCarta();
			carta.attivaEffettoIstantaneo();
			
			System.out.println("Il giocatore ha preso la carta VERDE: "  + carta.getNome());
			return true;
		}
		
		else return false;
	}

}