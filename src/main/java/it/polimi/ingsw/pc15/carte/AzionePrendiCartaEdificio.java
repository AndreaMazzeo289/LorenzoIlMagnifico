package it.polimi.ingsw.pc15.carte;

import it.polimi.ingsw.pc15.ParseXML;
import it.polimi.ingsw.pc15.player.Player;

public class AzionePrendiCartaEdificio extends AzionePrendiCarta {

	public AzionePrendiCartaEdificio(Player player, Carta carta) {
		super(player, carta);
	}

	@Override
	public void daiCarta() {
		carta.setSpazio(null);
		carta.setPlayer(player);	
		player.getEdifici().add((Edificio) carta);
	}

	@Override
	public boolean requisitiSoddisfatti() {
		
		if (player.getEdifici().size() == ParseXML.leggiValore("numeroMaxCarte")) {
			System.out.println("Hai raggiunto il limite massimo di carte Edificio!");
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
			
			System.out.println("Il giocatore ha preso la carta GIALLA: "  + carta.getNome());
			return true;
		}
		
		else return false;
	}

}
