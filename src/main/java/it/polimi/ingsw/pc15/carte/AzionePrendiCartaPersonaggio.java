package it.polimi.ingsw.pc15.carte;

import it.polimi.ingsw.pc15.ParseXML;
import it.polimi.ingsw.pc15.player.Player;

public class AzionePrendiCartaPersonaggio extends AzionePrendiCarta {

	public AzionePrendiCartaPersonaggio(Player player, Carta carta) {
		super(player, carta);
	}

	@Override
	public void daiCarta() {
		carta.setSpazio(null);
		carta.setPlayer(player);
		player.getPersonaggi().add((Personaggio) carta);	
	}

	@Override
	public boolean requisitiSoddisfatti() {
		if (player.getPersonaggi().size() == ParseXML.leggiValore("numeroMaxCarte")) {  //limite carte Personaggio
			System.out.println("Hai raggiunto il limite massimo di carte Personaggio!");
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
			
			System.out.println("Il giocatore ha preso la carta BLU: "  + carta.getNome());
			return true;
		}
		
		else return false;
	}

}
