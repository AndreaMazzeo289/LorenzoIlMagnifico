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

public class Model extends Observable {
	
	
	private int numGiocatori;
	private ArrayList<Player> giocatori;
	private int valoreDado;
	private Player player1;
	private Player player2;
	private Plancia plancia;
	private int turno;
	private int periodo;
	private ParseXML parseXML;
	private Set<Carta> setCarteTerritorio;
	private Set<Carta> setCartePersonaggio;
	private Set<Carta> setCarteEdificio;
	private Set<Carta> setCarteImpresa;
	
	
	public Model(int numGiocatori){

		this.numGiocatori = numGiocatori;
		this.plancia = new Plancia(numGiocatori);
		this.parseXML = new ParseXML();
		this.turno = 0;
		this.periodo = 1;

		HashSet<Risorsa> risorse = new HashSet<Risorsa>();
		
		Legna legna = new Legna (0);
		Pietra pietra = new Pietra (0);
		Oro oro = new Oro (0);
		Servitori servitori = new Servitori (0);
		PuntiFede puntiFede = new PuntiFede (0);
		PuntiMilitari puntiMilitari = new PuntiMilitari (0);
		PuntiVittoria puntiVittoria = new PuntiVittoria (0);
		Privilegi privilegi = new Privilegi (0);
			
		risorse.add(legna);
		risorse.add(pietra);
		risorse.add(oro);
		risorse.add(servitori);
		risorse.add(puntiFede);
		risorse.add(puntiMilitari);
		risorse.add(puntiVittoria);
		risorse.add(privilegi);
		
		SetRisorse setRisorse = new SetRisorse(risorse); 
			
		player1 = new Player("noName", setRisorse);
		player2 = new Player("noName", setRisorse);
		giocatori = new ArrayList();
		giocatori.add(player1);
		giocatori.add(player2);
		
		/*for(int i = 0; i<numGiocatori; i++){
			giocatori.add(this.player = new Player("noName", setRisorse));*/
		
		
		
		//imposta randomicamente l'ordine dei giocatori;
		/*Collections.shuffle(giocatori);*/
		
	}

	public void iniziaPartita() {
		
		setCarteTerritorio= parseXML.getCartaXML(ColoreCarta.VERDE);
		setCarteEdificio= parseXML.getCartaXML(ColoreCarta.GIALLO);
		setCartePersonaggio= parseXML.getCartaXML(ColoreCarta.BLU);
		setCarteImpresa= parseXML.getCartaXML(ColoreCarta.VIOLA);
		
		iniziaNuovoTurno();
		
	}
	
	public void iniziaNuovoTurno() {
		
		turno++;
		if(turno==3) {
			periodo++;
			turno=1;
		}
		
		this.plancia.setTurno(periodo, setCarteTerritorio, setCartePersonaggio, setCarteEdificio, setCarteImpresa);
		
		//prende il primo giocatore e tira i dadi e li passa al familiare;
		
		Random random = new Random();
		
		int valoreDadoNero = random.nextInt(5) + 1;
		int valoreDadoBianco = random.nextInt(5) + 1;
		int valoreDadoArancione = random.nextInt(5) + 1;
		
		for(Player player : giocatori) {
			player.getFamiliare(ColoreFamiliare.NEUTRO).setValore(0);	
			player.getFamiliare(ColoreFamiliare.NERO).setValore(valoreDadoNero);
			player.getFamiliare(ColoreFamiliare.BIANCO).setValore(valoreDadoBianco);
			player.getFamiliare(ColoreFamiliare.ARANCIONE).setValore(valoreDadoArancione);
					
		}

	}
	
	public ArrayList getPlayers() {
		return this.giocatori;
	}
	
	public Plancia getPlancia() {
		return this.plancia;
	}
	
	

}
