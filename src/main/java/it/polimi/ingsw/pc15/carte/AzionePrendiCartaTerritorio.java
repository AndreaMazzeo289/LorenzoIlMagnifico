package it.polimi.ingsw.pc15.carte;

import it.polimi.ingsw.pc15.ParseXML;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class AzionePrendiCartaTerritorio extends AzionePrendiCarta {

	public AzionePrendiCartaTerritorio(Player player, Carta carta) {
		super(player, carta);
	}

	@Override
	public void daiCarta() {	
		carta.setSpazio(null);
		carta.setPlayer(player);	
		player.getTerritori().add((Territorio) carta);
	}
	
	
	@Override
	public boolean requisitiSoddisfatti() {
		
		int numeroMaxCarte = ParseXML.leggiValore("numeroMaxCarte");
		
		if (player.getTerritori().size() == numeroMaxCarte) {
			System.out.println("Hai raggiunto il limite massimo di carte Territorio!");
			return false;
		}
		
		if (player.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIMILITARI).paragona(ParseXML.leggiValore("RequisitoMilitareTerritorio" + Integer.toString(player.getTerritori().size()+1)))) {
			System.out.println("Non hai abbastanza punti militari per ottenere questo Territorio");
			return false;
		}
		
		return true;
	}


	@Override
	public boolean attiva() {

		if (requisitiSoddisfatti() && risorseSufficienti(carta.getCosto()) ) {
			paga(carta.getCosto());
			daiCarta();
			carta.attivaEffettoIstantaneo();
			
			return true;
		}
		
		else return false;
	}

}