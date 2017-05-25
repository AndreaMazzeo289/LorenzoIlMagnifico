package it.polimi.ingsw.pc15.carte;

import java.io.IOException;
import java.util.Scanner;

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
		
		if (player.getImprese().size() == ParseXML.leggiValore("numeroMaxCarte")) {  
			System.out.println("Hai raggiunto il limite massimo di carte Impresa!");
			return false;
		}
		
		System.out.println("Vuoi pagare il costo normale (1) o il costo in Punti Militari (2) ?");
		int scelta = 0;
		try {
			scelta = System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (scelta==1)
			if (!risorseSufficienti()) {
				System.out.println("Non hai risorse sufficienti per acquistare questa carta!");
				return false;
				}
		
		if (scelta==2)
			if(true);  //<----- CONTINUA QUI
		
		return true;
	}
	
	

	@Override
	public boolean attiva() {

		if (requisitiSoddisfatti()) {
			pagaCosto();
			daiCarta();
			carta.attivaEffettoIstantaneo();
			
			System.out.println("Il giocatore ha preso la carta VIOLA: "  + carta.getNome());
			return true;
		}
		
		else return false;
	}

}


