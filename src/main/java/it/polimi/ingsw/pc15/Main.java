package it.polimi.ingsw.pc15;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import it.polimi.ingsw.pc15.carte.ColoreCarta;
import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.carte.Impresa;
import it.polimi.ingsw.pc15.carte.Personaggio;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.controller.Controller;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.model.Model;
import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;
import it.polimi.ingsw.pc15.view.View;

public class Main {

	public static void main(String[] args) throws IOException {

		//Player[] players = new Player[numeroGiocatori];
		//Thread[] threads = new Thread[numeroGiocatori];

		Model gioco = new Model(4);
		View view = new View (gioco);
		Controller controller = new Controller (gioco, view);
		gioco.iniziaPartita();

		Scanner in = new Scanner(System.in);
		Player player = (Player)gioco.getPlayers().get(0);	
		Spazio spazio1 = (Spazio)gioco.getPlancia().getSpazioTorre(ColoreCarta.BLU, 0);
		Spazio spazio2 = (Spazio)gioco.getPlancia().getSpazioTorre(ColoreCarta.BLU, 1);
		Spazio spazio3 = (Spazio)gioco.getPlancia().getSpazioTorre(ColoreCarta.GIALLO, 2);
		Spazio spazio4 = (Spazio)gioco.getPlancia().getSpazioTorre(ColoreCarta.VIOLA, 2);
		Familiare familiareNero = ((Player) gioco.getPlayers().get(0)).getFamiliare(ColoreFamiliare.NERO);
		Familiare familiareArancione = ((Player) gioco.getPlayers().get(0)).getFamiliare(ColoreFamiliare.ARANCIONE);
		Familiare familiareBianco = ((Player) gioco.getPlayers().get(0)).getFamiliare(ColoreFamiliare.BIANCO);
		Familiare familiareNeutro = ((Player) gioco.getPlayers().get(0)).getFamiliare(ColoreFamiliare.NEUTRO);

		/**
		 * TESTATE E FUNZIONANTI:
		 * 	- carte verdi
		 *  - carte gialle
		 *  - carte viola (tranne quelle con requisito militare)
		 *  - mercato
		 *  - spazio già occupato (quando un altro player vuole prendere uno spazio appena preso da un altro)
		 *  - carte blu
		 */
		
		/**
		 * PROBLEMI: 
		 * 	- requisito militare nelle carte viola
		 *  - attenzione all'effetto della badessa (carta blu) oltre ad aggiunta risorse ha azione su qualsiasi carta
		 */
		
		Random random = new Random();
		//***********************************************************************************************//
		int colore1 = random.nextInt(3)+1;
		int colore2 = random.nextInt(3)+1;
		int colore3 = random.nextInt(3)+1;
		int colore4 = random.nextInt(3)+1;
		
		System.out.println("colore1: "+colore1);
		System.out.println("colore2: "+colore2);
		System.out.println("colore3: "+colore3);
		System.out.println("colore4: "+colore4);
		
		ColoreCarta coloreCarta1=null;
		ColoreCarta coloreCarta2=null;
		ColoreCarta coloreCarta3=null;
		ColoreCarta coloreCarta4=null;
		
		switch(colore1){
		case 1: coloreCarta1 = ColoreCarta.VERDE;
			break;
		case 2: coloreCarta1 = ColoreCarta.BLU;
			break;
		case 3: coloreCarta1 = ColoreCarta.GIALLO;
			break;
		case 4: coloreCarta1 = ColoreCarta.VIOLA;
			break;
		}
		
		switch(colore2){
		case 1: coloreCarta2 = ColoreCarta.VERDE;
			break;
		case 2: coloreCarta2 = ColoreCarta.BLU;
			break;
		case 3: coloreCarta2 = ColoreCarta.GIALLO;
			break;
		case 4: coloreCarta2 = ColoreCarta.VIOLA;
			break;
		}
		
		switch(colore3){
		case 1: coloreCarta3 = ColoreCarta.VERDE;
			break;
		case 2: coloreCarta3 = ColoreCarta.BLU;
			break;
		case 3: coloreCarta3 = ColoreCarta.GIALLO;
			break;
		case 4: coloreCarta3 = ColoreCarta.VIOLA;
			break;
		}
		
		switch(colore4){
		case 1: coloreCarta4 = ColoreCarta.VERDE;
			break;
		case 2: coloreCarta4 = ColoreCarta.BLU;
			break;
		case 3: coloreCarta4 = ColoreCarta.GIALLO;
			break;
		case 4: coloreCarta4 = ColoreCarta.VIOLA;
			break;
		}
		
		int numeroSpazio1 = random.nextInt(3);
		int numeroSpazio2 = random.nextInt(3);
		int numeroSpazio3 = random.nextInt(3);
		int numeroSpazio4 = random.nextInt(3);
		
		System.out.println("la carta numero 1 sta nello spazio numero "+ numeroSpazio1 +" della torre di colore "+coloreCarta1);
		System.out.println("la carta numero 2 sta nello spazio numero "+ numeroSpazio2 +" della torre di colore "+coloreCarta2);
		System.out.println("la carta numero 3 sta nello spazio numero "+ numeroSpazio3 +" della torre di colore "+coloreCarta3);
		System.out.println("la carta numero 4 sta nello spazio numero "+ numeroSpazio4 +" della torre di colore "+coloreCarta4);
		
		Spazio spazioNum1 = (Spazio)gioco.getPlancia().getSpazioTorre(coloreCarta1, numeroSpazio1);
		Spazio spazioNum2 = (Spazio)gioco.getPlancia().getSpazioTorre(coloreCarta2, numeroSpazio2);
		Spazio spazioNum3 = (Spazio)gioco.getPlancia().getSpazioTorre(coloreCarta3, numeroSpazio3);
		Spazio spazioNum4 = (Spazio)gioco.getPlancia().getSpazioTorre(coloreCarta4, numeroSpazio4);
		
		System.out.println("Il giocatore vuole prendere questa carta con il familiare nero: "+ gioco.getPlancia().getSpazioTorre(coloreCarta1,numeroSpazio1).getCarta().getNome());
		System.out.println("il dado del familiare nero è: "+familiareNero.getValore());
		player.occupaSpazio(spazioNum1, familiareNero);
		
		System.out.println("Il giocatore vuole prendere questa carta con il familiare bianco: "+ gioco.getPlancia().getSpazioTorre(coloreCarta2,numeroSpazio2).getCarta().getNome());
		System.out.println("il dado del familiare giallo è: "+familiareBianco.getValore());
		player.occupaSpazio(spazioNum2, familiareBianco);
		
		System.out.println("Il giocatore vuole prendere questa carta con il familiare arancione: "+ gioco.getPlancia().getSpazioTorre(coloreCarta3,numeroSpazio3).getCarta().getNome());
		System.out.println("il dado del familiare arancione è: "+familiareArancione.getValore());
		player.occupaSpazio(spazioNum3, familiareArancione);
		
		System.out.println("Il giocatore vuole prendere questa carta con il familiare neutro: "+ gioco.getPlancia().getSpazioTorre(coloreCarta4,numeroSpazio4).getCarta().getNome());
		System.out.println("il dado del familiare neutro è: "+familiareNeutro.getValore());
		player.occupaSpazio(spazioNum4, familiareNeutro);
		
		//***********************************************************************************************//
		
		/*System.out.println("Il giocatore vuole prendere questa carta BLU con il familiare nero: "+ gioco.getPlancia().getSpazioTorre(ColoreCarta.BLU,0).getCarta().getNome());
		System.out.println("il dado del familiare nero è: "+familiareNero.getValore());
		player.occupaSpazio(spazio1, familiareNero);
		
		System.out.println("Il giocatore vuole prendere questa carta BLU con il familiare bianco: "+ gioco.getPlancia().getSpazioTorre(ColoreCarta.BLU,1).getCarta().getNome());
		System.out.println("il dado del familiare giallo è: "+familiareBianco.getValore());
		player.occupaSpazio(spazio2, familiareBianco);*/
		
		
		
		//System.out.println("Il giocatore vuole prendere questa carta GIALLA con il familiare arancione: "+ gioco.getPlancia().getSpazioTorre(ColoreCarta.GIALLO,2).getCarta().getNome());
		//System.out.println("Il giocatore vuole prendere questa carta VIOLA con il familiare neutro: "+ gioco.getPlancia().getSpazioTorre(ColoreCarta.VIOLA,2).getCarta().getNome());
		
		
		//System.out.println("il dado del familiare arancione è: "+familiareArancione.getValore());
		//System.out.println("il dado del familiare neutro è: "+familiareNeutro.getValore());
		

		//player.occupaSpazio(spazio3, familiareArancione);
		//player.occupaSpazio(spazio4, familiareNeutro);

		
		
		
		System.out.println("ora il giocatore ha queste risorse: ");
		System.out.println("oro: "+Integer.toString(((Player) gioco.getPlayers().get(0)).getSetRisorse().getRisorsa(TipoRisorsa.ORO).getQuantità()));
		System.out.println("punti fede: "+Integer.toString(((Player) gioco.getPlayers().get(0)).getSetRisorse().getRisorsa(TipoRisorsa.PUNTIFEDE).getQuantità()));
		System.out.println("punti militari: "+Integer.toString(((Player) gioco.getPlayers().get(0)).getSetRisorse().getRisorsa(TipoRisorsa.PUNTIMILITARI).getQuantità()));		
		System.out.println("punti vittoria: "+Integer.toString(((Player) gioco.getPlayers().get(0)).getSetRisorse().getRisorsa(TipoRisorsa.PUNTIVITTORIA).getQuantità()));
		System.out.println("pietra: "+Integer.toString(((Player) gioco.getPlayers().get(0)).getSetRisorse().getRisorsa(TipoRisorsa.PIETRA).getQuantità()));
		System.out.println("servitori: "+Integer.toString(((Player) gioco.getPlayers().get(0)).getSetRisorse().getRisorsa(TipoRisorsa.SERVITORI).getQuantità()));
		System.out.println("privilegi: "+Integer.toString(((Player) gioco.getPlayers().get(0)).getSetRisorse().getRisorsa(TipoRisorsa.PRIVILEGI).getQuantità()));
		System.out.println("legna: "+Integer.toString(((Player) gioco.getPlayers().get(0)).getSetRisorse().getRisorsa(TipoRisorsa.LEGNA).getQuantità()));
		
	}
}
 