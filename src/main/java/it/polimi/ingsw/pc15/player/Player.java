package it.polimi.ingsw.pc15.player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import it.polimi.ingsw.pc15.ParseXML;
import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.carte.Impresa;
import it.polimi.ingsw.pc15.carte.Personaggio;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

public class Player {
	
	private final String name;
	private SetRisorse setRisorse;
	private Set<Familiare> familiari;
	private ArrayList<Territorio> territori;
	private ArrayList<Personaggio> personaggi;
	private ArrayList<Edificio> edifici;
	private ArrayList<Impresa> imprese;
	private EffettiAttivi effettiAttivi;
	

	public Player (String name, SetRisorse setRisorse) {
		this.name = name;
		this.setRisorse = setRisorse;
		this.familiari = new HashSet<Familiare>();
		
		Familiare familiareNero = new Familiare (ColoreFamiliare.NERO, this);
		Familiare familiareBianco = new Familiare (ColoreFamiliare.BIANCO, this);
		Familiare familiareArancione = new Familiare (ColoreFamiliare.ARANCIONE, this);
		Familiare familiareNeutro = new Familiare (ColoreFamiliare.NEUTRO, this);
		
		this.familiari.add(familiareBianco);
		this.familiari.add(familiareNero);
		this.familiari.add(familiareArancione);
		this.familiari.add(familiareNeutro);
		
		int numeroMaxCarte = ParseXML.leggiValore("numeroMaxCarte");
		
		this.territori = new ArrayList<Territorio>(numeroMaxCarte);
		this.personaggi = new ArrayList<Personaggio>(numeroMaxCarte);
		this.edifici = new ArrayList<Edificio>(numeroMaxCarte);
		this.imprese = new ArrayList<Impresa>(numeroMaxCarte);
		
		this.effettiAttivi = new EffettiAttivi();	
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public SetRisorse getSetRisorse() {
		return this.setRisorse;
	}
	
	public ArrayList<Territorio> getTerritori() {
		return this.territori;
	}
	
	public ArrayList<Personaggio> getPersonaggi() {
		return this.personaggi;
	}
	
	public ArrayList<Edificio> getEdifici() {
		return this.edifici;
	}
	
	public ArrayList<Impresa> getImprese() {
		return this.imprese;
	}
	
	public Familiare getFamiliare(ColoreFamiliare coloreFamiliare){
		
		Familiare familiareReturn = null;
		
		for(Familiare familiare : familiari) {
			if(familiare.getColore().equals(coloreFamiliare))
				familiareReturn = familiare;
		}
		
		return familiareReturn;
	}
	
	public void occupaSpazio (Spazio spazio, Familiare familiare) {
		
		if (familiare.disponibile()) {
		
			familiare.aggiungiServitori();
		
			if (spazio.occupabile(familiare) ) {
				
				familiare.setDisponibilità(false);
				spazio.occupa(familiare);
			}
		}
		
	}
	
	public EffettiAttivi getEffettiAttivi(){
		return effettiAttivi;
	}
	
	
	
	
	
	

}
