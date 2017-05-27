package it.polimi.ingsw.pc15;

import java.io.IOException;
import java.util.Map;
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
import it.polimi.ingsw.pc15.risorse.Risorsa;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;
import it.polimi.ingsw.pc15.view.View;

/*public class Main {

	public static void main(String[] args) throws IOException {

		//Player[] players = new Player[numeroGiocatori];
		//Thread[] threads = new Thread[numeroGiocatori];

		Model gioco = new Model(4);
		View view = new View (gioco);
		Controller controller = new Controller (gioco, view);
		gioco.iniziaPartita();

		Scanner in = new Scanner(System.in);
		int scelta;
		Player player = gioco.getPlayers().get(0);
		
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
		 
		
		while (true) {
			
			System.out.print("\nCosa vuoi fare?  \n-  Visualizza Risorse (1)  \n-  Visualizza Carte in tuo possesso (2)  \n-  Visualizza i familiari disponibili  (3)  \n-  Visualizza Plancia (4)  \n-  Posiziona un familiare (5)  \n");
			
			scelta = in.nextInt();
			
			view.input(scelta);
			
		}
	}
}     

*/
 