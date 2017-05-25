package it.polimi.ingsw.pc15;

import java.io.IOException;
import java.util.Scanner;

import it.polimi.ingsw.pc15.carte.ColoreCarta;
import it.polimi.ingsw.pc15.carte.Impresa;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.controller.Controller;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.model.Model;
import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;
import it.polimi.ingsw.pc15.view.View;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Model gioco = new Model(4);
		View view = new View (gioco);
		Controller controller = new Controller (gioco, view);
		gioco.iniziaPartita();
		
		//((Player) gioco.getPlayers().get(0)).occupaSpazio ((Spazio) gioco.getPlancia().getSpaziMercato().get(0), ((Player) gioco.getPlayers().get(0)).getFamiliare(ColoreFamiliare.ARANCIONE));
		
		((Player) gioco.getPlayers().get(0)).occupaSpazio((Spazio) gioco.getPlancia().getSpazioTorre(ColoreCarta.VIOLA, 0), ((Player) gioco.getPlayers().get(0)).getFamiliare(ColoreFamiliare.NERO));
		//((Player) gioco.getPlayers().get(0)).occupaSpazio((Spazio) gioco.getPlancia().getSpazioTorre(ColoreCarta.VERDE, 1), ((Player) gioco.getPlayers().get(0)).getFamiliare(ColoreFamiliare.NERO));
		
		//for(Territorio carta : ((Player) gioco.getPlayers().get(0)).getTerritori())
		//	System.out.println(carta.getNome());
		
		for(Impresa carta : ((Player) gioco.getPlayers().get(0)).getImprese())
			System.out.println(carta.getNome());
		
		System.out.println(((Player)gioco.getPlayers().get(0)).getFamiliare(ColoreFamiliare.NERO).getValore());
		
		System.out.println("oro: "+Integer.toString(((Player) gioco.getPlayers().get(0)).getSetRisorse().getRisorsa(TipoRisorsa.ORO).getQuantità()));
		System.out.println("punti fede: "+Integer.toString(((Player) gioco.getPlayers().get(0)).getSetRisorse().getRisorsa(TipoRisorsa.PUNTIFEDE).getQuantità()));
		System.out.println("punti militari: "+Integer.toString(((Player) gioco.getPlayers().get(0)).getSetRisorse().getRisorsa(TipoRisorsa.PUNTIMILITARI).getQuantità()));		
		System.out.println("punti vittoria: "+Integer.toString(((Player) gioco.getPlayers().get(0)).getSetRisorse().getRisorsa(TipoRisorsa.PUNTIVITTORIA).getQuantità()));
		System.out.println("pietra: "+Integer.toString(((Player) gioco.getPlayers().get(0)).getSetRisorse().getRisorsa(TipoRisorsa.PIETRA).getQuantità()));
		System.out.println("servitori: "+Integer.toString(((Player) gioco.getPlayers().get(0)).getSetRisorse().getRisorsa(TipoRisorsa.SERVITORI).getQuantità()));
		System.out.println("privilegi: "+Integer.toString(((Player) gioco.getPlayers().get(0)).getSetRisorse().getRisorsa(TipoRisorsa.PRIVILEGI).getQuantità()));
		System.out.println("legna: "+Integer.toString(((Player) gioco.getPlayers().get(0)).getSetRisorse().getRisorsa(TipoRisorsa.LEGNA).getQuantità()));
		
		
		System.out.println(gioco.getPlancia().getSpazioTorre(ColoreCarta.VIOLA, 0).getValoreMin());

	}
}
 