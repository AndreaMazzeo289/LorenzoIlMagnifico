package it.polimi.ingsw.pc15;

import java.io.IOException;
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
		 * 	- QUANDO VADO AD AGGIUNGERE I BONUS DEGLI SPAZI DELLE TORRI PASSA UN NULL COME SET RISORSE E LA AGGIUNGI GENERA UN'ECCEZIONE
		 */
		
		System.out.println("Il giocatore vuole prendere questa carta BLU con il familiare nero: "+ gioco.getPlancia().getSpazioTorre(ColoreCarta.BLU,0).getCarta().getNome());
		System.out.println("Il giocatore vuole prendere questa carta BLU con il familiare bianco: "+ gioco.getPlancia().getSpazioTorre(ColoreCarta.BLU,1).getCarta().getNome());
		//System.out.println("Il giocatore vuole prendere questa carta GIALLA con il familiare arancione: "+ gioco.getPlancia().getSpazioTorre(ColoreCarta.GIALLO,2).getCarta().getNome());
		//System.out.println("Il giocatore vuole prendere questa carta VIOLA con il familiare neutro: "+ gioco.getPlancia().getSpazioTorre(ColoreCarta.VIOLA,2).getCarta().getNome());
		
		System.out.println("il dado del familiare nero è: "+familiareNero.getValore());
		System.out.println("il dado del familiare arancione è: "+familiareArancione.getValore());
		//System.out.println("il dado del familiare giallo è: "+familiareBianco.getValore());
		//System.out.println("il dado del familiare neutro è: "+familiareNeutro.getValore());
		
		player.occupaSpazio(spazio1, familiareNero);
		player.occupaSpazio(spazio2, familiareBianco);
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
 