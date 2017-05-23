package it.polimi.ingsw.pc15;

import java.io.IOException;
import java.util.Scanner;

import it.polimi.ingsw.pc15.controller.Controller;
import it.polimi.ingsw.pc15.model.Model;
import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.view.View;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//Player[] players = new Player[numeroGiocatori];
		//Thread[] threads = new Thread[numeroGiocatori];

		
		Player player = new Player ("Maffe", null );
		
		Model gioco = new Model(4);
		View view = new View (gioco);
		Controller controller = new Controller (gioco, view);
		
		Scanner in = new Scanner(System.in);
		
		((Player) gioco.getPlayers().get(0)).occupaSpazio ((Spazio) gioco.getPlancia().getSpaziMercato().get(0), ((Player) gioco.getPlayers().get(0)).getFamiliare(ColoreFamiliare.ARANCIONE));
		
		
		

	
	}
}
 