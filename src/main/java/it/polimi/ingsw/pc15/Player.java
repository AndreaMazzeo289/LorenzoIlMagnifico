package it.polimi.ingsw.pc15;

import java.util.HashSet;
import java.util.Set;

public class Player {
	
	private final String name;
	private SetRisorse setRisorse;
	private Set<Familiare> familiari;
	private Set<Territorio> territori;
	private Set<Personaggio> personaggi;
	private Set<Edificio> edifici;
	private Set<Impresa> imprese;
	private EffettiAttivi effettiAttivi;
	
	
	
	public Player (String name, SetRisorse setRisorse) {
		this.name = name;
		this.setRisorse = setRisorse;
		this.familiari = new HashSet<Familiare>();
		Familiare familiareNero = new Familiare (ColoreFamiliare.NERO, this);
		Familiare familiareBianco = new Familiare (ColoreFamiliare.BIANCO, this);
		Familiare familiareArancione = new Familiare (ColoreFamiliare.ARANCIONE, this);
		Familiare familiareNeutro = new Familiare (ColoreFamiliare.NEUTRO, this);
		familiari.add(familiareBianco);
		familiari.add(familiareNero);
		familiari.add(familiareArancione);
		familiari.add(familiareNeutro);
		effettiAttivi = new EffettiAttivi();
	}
	
	public String getName() {
		return this.name;
	}
	
	public SetRisorse getSetRisorse() {
		return this.setRisorse;
	}
	
	public Set<Territorio> getTerritori() {
		return this.territori;
	}
	
	public Set<Personaggio> getPersonaggi() {
		return this.personaggi;
	}
	
	public Set<Edificio> getEdifici() {
		return this.edifici;
	}
	
	public Set<Impresa> getImprese() {
		return this.imprese;
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
