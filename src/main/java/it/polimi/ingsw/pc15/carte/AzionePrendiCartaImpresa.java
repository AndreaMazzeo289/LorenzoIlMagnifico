package it.polimi.ingsw.pc15.carte;

import it.polimi.ingsw.pc15.ParseXML;
import it.polimi.ingsw.pc15.player.Player;

public class AzionePrendiCartaImpresa extends AzionePrendiCarta {

	public AzionePrendiCartaImpresa(Player player, Carta carta) {
		super(player, carta);
	}

	@Override
	public void daiCarta() {
		carta.setSpazio(null);
		carta.setPlayer(player);	
		player.getImprese().add((Impresa) carta);
	}

	@Override
	public boolean requisitiSoddisfatti() {
		if (player.getImprese().size() == ParseXML.leggiValore("numeroMaxCarte")) {  //limite carte Impresa
			System.out.println("Hai raggiunto il limite massimo di carte Impresa!");
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


