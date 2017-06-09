package it.polimi.ingsw.pc15;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import it.polimi.ingsw.pc15.azioni.Azione;
import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioMercato;
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
import it.polimi.ingsw.pc15.plancia.SpazioMercato;
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

		ArrayList<String> nomi = new ArrayList<String>();
		nomi.add("Maffe");
		nomi.add("Fra");
		nomi.add("Mazze");
		
		Model gioco = new Model(nomi, true);
		
		gioco.iniziaPartita();
		
		Player player = gioco.getPlayers().get(0);
		for (Leader leader : player.getCarteLeader())
			System.out.println(leader.getNome());

		
		
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
		
	}
}