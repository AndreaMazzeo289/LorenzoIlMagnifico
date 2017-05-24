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
		
		System.out.println("Il giocatore vuole prendere questa carta: "+ gioco.getPlancia().getSpazioTorre(ColoreCarta.BLU,0).getCarta().getNome());
		SetRisorse setRisorse = gioco.getPlancia().getSpazioTorre(ColoreCarta.BLU,0).getCarta().getCosto();
		
		System.out.println("richiede queste risorse:");
		System.out.println("oro: "+Integer.toString(setRisorse.getRisorsa(TipoRisorsa.ORO).getQuantità()));
		System.out.println("punti fede: "+Integer.toString(setRisorse.getRisorsa(TipoRisorsa.PUNTIFEDE).getQuantità()));
		System.out.println("punti militari: "+Integer.toString(setRisorse.getRisorsa(TipoRisorsa.PUNTIMILITARI).getQuantità()));		
		System.out.println("punti vittoria: "+Integer.toString(setRisorse.getRisorsa(TipoRisorsa.PUNTIVITTORIA).getQuantità()));
		System.out.println("pietra: "+Integer.toString(setRisorse.getRisorsa(TipoRisorsa.PIETRA).getQuantità()));
		System.out.println("servitori: "+Integer.toString(setRisorse.getRisorsa(TipoRisorsa.SERVITORI).getQuantità()));
		System.out.println("privilegi: "+Integer.toString(setRisorse.getRisorsa(TipoRisorsa.PRIVILEGI).getQuantità()));
		System.out.println("legna: "+Integer.toString(setRisorse.getRisorsa(TipoRisorsa.LEGNA).getQuantità()));
		
		System.out.println("il dado è: "+((Player)gioco.getPlayers().get(0)).getFamiliare(ColoreFamiliare.NERO).getValore());
		
		player.occupaSpazio((Spazio) gioco.getPlancia().getSpazioTorre(ColoreCarta.BLU, 0), ((Player) gioco.getPlayers().get(0)).getFamiliare(ColoreFamiliare.NERO));

		
		
		/*System.out.println("il giocatore ha preso queste carte:");
		for(Impresa carta : ((Player) gioco.getPlayers().get(0)).getImprese())
			System.out.println(carta.getNome());*/
		
		System.out.println("il giocatore ha preso queste carte:");
		for(Personaggio carta : ((Player) gioco.getPlayers().get(0)).getPersonaggi())
			System.out.println(carta.getNome());
		
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
 