package it.polimi.ingsw.pc15.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Observable;
import java.util.Random;
import java.util.Set;

import it.polimi.ingsw.pc15.ParseXML;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.ColoreCarta;
import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.carte.Impresa;
import it.polimi.ingsw.pc15.carte.Personaggio;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.plancia.Plancia;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.Legna;
import it.polimi.ingsw.pc15.risorse.Oro;
import it.polimi.ingsw.pc15.risorse.Pietra;
import it.polimi.ingsw.pc15.risorse.Privilegi;
import it.polimi.ingsw.pc15.risorse.PuntiFede;
import it.polimi.ingsw.pc15.risorse.PuntiMilitari;
import it.polimi.ingsw.pc15.risorse.PuntiVittoria;
import it.polimi.ingsw.pc15.risorse.Risorsa;
import it.polimi.ingsw.pc15.risorse.Servitori;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class Model extends Observable {
	
	private int numeroGiocatori;
	private ArrayList<Player> giocatori;
	private Plancia plancia;
	private int turno;
	private int periodo;
	private ArrayList<Carta> carteTerritorio;
	private ArrayList<Carta> cartePersonaggio;
	private ArrayList<Carta> carteEdificio;
	private ArrayList<Carta> carteImpresa;
	
	
	public Model(int numeroGiocatori){

		this.numeroGiocatori = numeroGiocatori;
		this.plancia = new Plancia(numeroGiocatori);
		this.turno = 0;
		this.periodo = 1;
			
		Player player1 = new Player("Maffe", null);
		Player player2 = new Player("Mazze", null);
		Player player3 = new Player("Fra", null);
		Player player4 = new Player("AleMagni", null);
		
		giocatori = new ArrayList<Player>();
		giocatori.add(player1);
		giocatori.add(player2);
		giocatori.add(player3);
		giocatori.add(player4);
		
	}

	public void iniziaPartita() {
		
		carteTerritorio= ParseXML.getCartaXML(ColoreCarta.VERDE);
		carteEdificio= ParseXML.getCartaXML(ColoreCarta.GIALLO);
		cartePersonaggio= ParseXML.getCartaXML(ColoreCarta.BLU);
		carteImpresa= ParseXML.getCartaXML(ColoreCarta.VIOLA);
		
		Collections.shuffle(carteTerritorio);
		Collections.shuffle(cartePersonaggio);
		Collections.shuffle(carteEdificio);
		Collections.shuffle(carteImpresa);
		
		iniziaNuovoTurno();
		
	}
	
	public void iniziaNuovoTurno() {
		
		turno++;
		if(turno==3) {
			periodo++;
			turno=1;
		}
		
		this.plancia.setTurno(periodo, carteTerritorio, cartePersonaggio, carteEdificio, carteImpresa);

		Random random = new Random();
		
		int valoreDadoNero = random.nextInt(6) + 1;
		int valoreDadoBianco = random.nextInt(6) + 1;
		int valoreDadoArancione = random.nextInt(6) + 1;
		
		for(Player player : giocatori) {
			player.getFamiliare(ColoreFamiliare.NEUTRO).setValore(0);	
			player.getFamiliare(ColoreFamiliare.NERO).setValore(valoreDadoNero);
			player.getFamiliare(ColoreFamiliare.BIANCO).setValore(valoreDadoBianco);
			player.getFamiliare(ColoreFamiliare.ARANCIONE).setValore(valoreDadoArancione);
					
		}

	}
	
	public void rapportoInVaticano(int periodo) {
		
		int puntiFedeMinimi = ParseXML.leggiValore("puntiFedePeriodo" + Integer.toString(periodo));
		for (Player player :giocatori) {
			if (player.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIFEDE).getQuantità() < puntiFedeMinimi)
				this.plancia.getTesseraScomunica(periodo).infliggiScomunica(player);
		}
	}
	
	
	
	public ArrayList<Player> getPlayers() {
		return this.giocatori;
	}
	
	public Plancia getPlancia() {
		return this.plancia;
	}
	
	

}
