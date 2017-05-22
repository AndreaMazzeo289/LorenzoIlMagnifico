package it.polimi.ingsw.pc15.carte;

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
		
		switch (player.getTerritori().size()) {
		case 2: if (player.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIMILITARI).getQuantità()<3) {
					System.out.println("Hai bisogno di 3 Punti Militari per aggiungere un altra carta Territorio!");
					return false;
				}

		case 3: if (player.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIMILITARI).getQuantità()<7) {
					System.out.println("Hai bisogno di 7 Punti Militari per aggiungere un altra carta Territorio!");
					return false;
				}
			
		case 4: if (player.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIMILITARI).getQuantità()<12) {
					System.out.println("Hai bisogno di 12 Punti Militari per aggiungere un altra carta Territorio!");
					return false;
				}
			
		case 5: if (player.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIMILITARI).getQuantità()<18) {
					System.out.println("Hai bisogno di 18 Punti Militari per aggiungere un altra carta Territorio!");
					return false;
				}
			
		case 6: System.out.println("Hai raggiunto il limite massimo di carte Territori!");
				return false;
	
		default: break;
		
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