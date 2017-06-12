package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;
import java.util.Scanner;

import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;

public class FissaValoreFamiliareAScelta extends FissaValoreFamiliare {

	public FissaValoreFamiliareAScelta(int valore) {
		super(null, valore);
	}
	
	@Override
	public void attiva(Player player) {
		System.out.println("Scegli un familiare del quale vuoi fissare il valore a " + Integer.toString(valore) + ":");
		System.out.println("(1): FAMILIARE NERO; valore corrente = " + player.getFamiliare(ColoreFamiliare.NERO).getValore());
		System.out.println("(2): FAMILIARE BIANCO; valore corrente = " + player.getFamiliare(ColoreFamiliare.BIANCO).getValore());
		System.out.println("(3): FAMILIARE ARANCIONE; valore corrente = " + player.getFamiliare(ColoreFamiliare.ARANCIONE).getValore());
		System.out.println("(4): FAMILIARE NEUTRO; valore corrente = " + player.getFamiliare(ColoreFamiliare.NEUTRO).getValore());
		
		Scanner in = new Scanner(System.in);
		int scelta = in.nextInt();	
		Familiare familiareScelto;
		
		switch (scelta) {
			case 1: colore = ColoreFamiliare.NERO; break;
			case 2: colore = ColoreFamiliare.BIANCO; break;
			case 3: colore = ColoreFamiliare.ARANCIONE; break;
			case 4: colore = ColoreFamiliare.NEUTRO; break;
			default: colore = null; break;
		}
		
		fissaValore(player);
		
	}
	
	public String toString() {
		return ("Fissa il valore di un familiare a tua scelta a " + valore) ;
	}

}
