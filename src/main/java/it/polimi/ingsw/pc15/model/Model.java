package it.polimi.ingsw.pc15.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Observable;
import java.util.Random;
import java.util.Set;

import it.polimi.ingsw.pc15.ParseXML;
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
	private HashSet<Risorsa> risorse;
	private SetRisorse setRisorse;
	private int valoreDado;
	private Player player;
	private Plancia plancia;
	private int turno;
	private int periodo;
	private ParseXML parseXML;
	private Set<Territorio> setCarteTerritorio;
	private Set<Personaggio> setCartePersonaggio;
	private Set<Edificio> setCarteEdificio;
	private Set<Impresa> setCarteImpresa;
	
	
	
	
	public Model(int numGiocatori){
		
		this.numGiocatori = numGiocatori;
		this.plancia = new Plancia(numGiocatori);
		this.parseXML = new ParseXML();
		this.turno = 0;
		this.periodo = 0;
		
	}

	public void iniziaPartita(){
		
		// Istanziazione carte territorio :
		//----------------------------------	

		for(int i = 0; i<ParseXML.leggiValore("numeroCarteVerdi"); i++){

			setCarteTerritorio.add((Territorio) parseXML.getCartaXML(ColoreCarta.VERDE));	
		}
		
		// Istanziazione carte personaggio :
		//----------------------------------

		for(int i = 0; i<ParseXML.leggiValore("numeroCarteBlu"); i++){
			setCartePersonaggio.add((Personaggio) parseXML.getCartaXML(ColoreCarta.BLU));
		}
		
		// Istanziazione carte edicio :
		//----------------------------------
		
		for(int i = 0; i<ParseXML.leggiValore("numeroCarteGialle"); i++){

			setCarteEdificio.add((Edificio) parseXML.getCartaXML(ColoreCarta.GIALLO));
		}
		
		// Istanziazione carte impresa :
		//----------------------------------

		for (int i = 0; i<ParseXML.leggiValore("numeroCarteViola"); i++){
			setCarteImpresa.add((Impresa) parseXML.getCartaXML(ColoreCarta.VIOLA));
		}
		
		
		//Istanziazione differenti players e i corrispondenti se
		for(int i = 0; i<numGiocatori; i++){
			
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
			
			giocatori.add(this.player = new Player("noName", setRisorse));
			
		}
		
		
		//imposta randomicamente l'ordine dei giocatori;
		Collections.shuffle(giocatori);
		
	}
	
	public void iniziaTurno(){
		
		this.plancia.setTurno(periodo, setCarteTerritorio, setCartePersonaggio, setCarteEdificio, setCarteImpresa);
		
		//prende il primo giocatore e tira i dadi e li passa al familiare;
		
		Random random = new Random();
		
		//Imposto i familiari neri del player ad un valore random
		valoreDado = random.nextInt(5) + 1;
		Iterator<Player> itrGiocatoriNero = giocatori.iterator();
		while(itrGiocatoriNero.hasNext()){
			
			itrGiocatoriNero.next().getFamiliare(ColoreFamiliare.NERO).setValore(valoreDado);
			
		}
		
		//Imposto i familiari bianchi del player ad un valore random
		valoreDado = random.nextInt(5) + 1;
		Iterator<Player> itrGiocatoriBianco = giocatori.iterator();
		while(itrGiocatoriBianco.hasNext()){
			
			itrGiocatoriBianco.next().getFamiliare(ColoreFamiliare.BIANCO).setValore(valoreDado);
			
		}
		
		//Imposto i familiari arancioni del player ad un valore random
		valoreDado = random.nextInt(5) + 1;
		Iterator<Player> itrGiocatoriArancione = giocatori.iterator();
		while(itrGiocatoriArancione.hasNext()){
			
			itrGiocatoriArancione.next().getFamiliare(ColoreFamiliare.ARANCIONE).setValore(valoreDado);
			
		}
		
		//Imposto il familiare neutro
		Iterator<Player> itrGiocatoriNeutro = giocatori.iterator();
		while(itrGiocatoriNeutro.hasNext()){
			
			itrGiocatoriNeutro.next().getFamiliare(ColoreFamiliare.NEUTRO).setValore(0);
			
		}

	}
	
	
	

}
