package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.ParseXML;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.player.Player;

public class AzionePrendiCartaPersonaggio extends AzionePrendiCarta {

	public AzionePrendiCartaPersonaggio(Player player, Carta carta) {
		super(player, carta);
	}

	@Override
	public boolean èValida() {
		
		if (player.getCarte(TipoCarta.PERSONAGGIO).size() == ParseXML.leggiValore("numeroMaxCarte")) {  
			System.out.println("Hai raggiunto il limite massimo di carte Personaggio!");
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

		if (èValida()) {
			pagaCosto();
			daiCarta();
			carta.attivaEffettoIstantaneo();
			
			System.out.println("Il giocatore ha preso la carta BLU: "  + carta.getNome());
		}
	}

}
