package it.polimi.ingsw.pc15;

import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.carte.Impresa;
import it.polimi.ingsw.pc15.carte.Personaggio;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.controller.Controller;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.effetti.NegaMercato;
import it.polimi.ingsw.pc15.model.Model;
import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.plancia.TesseraScomunica;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Leader;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.Risorsa;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class Main {

	public static void main(String[] args) throws IOException {

		//Player[] players = new Player[numeroGiocatori];
		//Thread[] threads = new Thread[numeroGiocatori];

		Model gioco = new Model(null, true);
		
		gioco.iniziaPartita();
		Player player = gioco.getPlayers().get(0);
		Spazio spazio = gioco.getPlancia().getSpazioTorre(TipoCarta.EDIFICIO, 0);
		Spazio spazio2 = gioco.getPlancia().getSpazioProduzione();
		Familiare familiareNero = player.getFamiliare(ColoreFamiliare.NERO);
		Familiare familiareBianco = player.getFamiliare(ColoreFamiliare.BIANCO);

		Scanner in = new Scanner(System.in);
		int scelta;
		
		
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
		 *  - attenzione all'effetto della badessa (carta blu) oltre ad aggiunta risorse ha azione su qualsiasi carta
		 *  - effetti scomuniche risorse (1 periodo)
		 *  - effetti Leader Santa Rita e Pico della mirandola
		 */
		
		
		for (Leader leader : player.getCarteLeader())
			System.out.println("Provo a giocare " + leader.getNome());
	
		
		gioco.rapportoInVaticano(2);
		
		System.out.println("\nAl momento possiedi le seguenti risorse:");
		System.out.println("Oro: "+player.getSetRisorse().getRisorsa(TipoRisorsa.ORO).getQuantità());
		System.out.println("Legna: "+player.getSetRisorse().getRisorsa(TipoRisorsa.LEGNA).getQuantità());
		System.out.println("Pietra: "+player.getSetRisorse().getRisorsa(TipoRisorsa.PIETRA).getQuantità());
		System.out.println("Servitori: "+player.getSetRisorse().getRisorsa(TipoRisorsa.SERVITORI).getQuantità());
		System.out.println("PuntiVittoria: "+player.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIVITTORIA).getQuantità());
		System.out.println("PuntiFede: "+player.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIFEDE).getQuantità());
		System.out.println("PuntiMilitari: "+player.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIMILITARI).getQuantità()+"\n");
		
		
		
		System.out.println("\nRisorse aggiornate:");
		System.out.println("Oro: "+player.getSetRisorse().getRisorsa(TipoRisorsa.ORO).getQuantità());
		System.out.println("Legna: "+player.getSetRisorse().getRisorsa(TipoRisorsa.LEGNA).getQuantità());
		System.out.println("Pietra: "+player.getSetRisorse().getRisorsa(TipoRisorsa.PIETRA).getQuantità());
		System.out.println("Servitori: "+player.getSetRisorse().getRisorsa(TipoRisorsa.SERVITORI).getQuantità());
		System.out.println("PuntiVittoria: "+player.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIVITTORIA).getQuantità());
		System.out.println("PuntiFede: "+player.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIFEDE).getQuantità());
		System.out.println("PuntiMilitari: "+player.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIMILITARI).getQuantità());
		
		
		/*gioco.rapportoInVaticano(1);
		gioco.rapportoInVaticano(2);
		gioco.rapportoInVaticano(3);*/
		
		
	}
}