package it.polimi.ingsw.pc15.azioni;

import java.io.IOException;
import java.util.Scanner;

import it.polimi.ingsw.pc15.ParseXML;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.carte.Impresa;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class AzionePrendiCartaImpresa extends AzionePrendiCarta {

	public AzionePrendiCartaImpresa(Player player, Carta carta) {
		super(player, carta);
	}

	@Override
	public boolean èValida() {
		
		if (player.getCarte(TipoCarta.EDIFICIO).size() == ParseXML.leggiValore("numeroMaxCarte")) {  
			System.out.println("Hai raggiunto il limite massimo di carte Impresa!");
			return false;
		}
		
		return true;
	}

	@Override
	public void attiva() {
		
		int scelta = 0;
		
		if (carta.getCosto()!=null && ((Impresa)carta).getRequisitoPuntiMilitari() != 0) {
		System.out.println("Vuoi pagare il costo normale (1) o il costo in Punti Militari (2) ?");
		Scanner in = new Scanner(System.in);
		scelta = in.nextInt();
		}
		
		if (scelta == 1  || ((Impresa)carta).getRequisitoPuntiMilitari() == 0) {

			if ( èValida() && risorseSufficienti() ) {
				pagaCosto();
				daiCarta();
				carta.attivaEffettoIstantaneo();
			
				System.out.println("Il giocatore ha preso la carta VIOLA: "  + carta.getNome());
			}
		}
		
		if (scelta == 2  || carta.getCosto()== null) {
			
			if( puntiMilitariSufficienti() ) {
				pagaPuntiMilitari();
				daiCarta();
				carta.attivaEffettoIstantaneo();
				
				System.out.println("Il giocatore ha preso la carta VIOLA: "  + carta.getNome());
			}
		}	
	}
	
	public boolean puntiMilitariSufficienti() {
		
		if ( ((Impresa)carta).getRequisitoPuntiMilitari() > player.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIMILITARI).getQuantità() ) {
			System.out.println("Non hai abbastanza Punti Militari per acquistare questa carta!");
			return false;
		}
		
		if (carta.getSpazio().getTorre().occupata() && player.getSetRisorse().getRisorsa(TipoRisorsa.ORO).getQuantità()<3 ) {
			System.out.println("Non hai risorse sufficienti per acquistare questa carta!");
			return false;
		}
		
		if (((Impresa) carta).getCostoPuntiMilitari() > player.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIMILITARI).getQuantità() ) {
			System.out.println("Non hai abbastanza Punti Militari per acquistare questa carta!");
			return false;
		}
		
		return true;
	}
	
	public void pagaPuntiMilitari() {
		player.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIMILITARI).aggiungi(-((Impresa) carta).getCostoPuntiMilitari());}
}


