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
		
	}
	
	public SetRisorse getRisorse() {
		return this.setRisorse;
	}
	
	String getName() {
		return this.name;
	}
	
	SetRisorse getSetRisorse() {
		return this.setRisorse;
	}
	
	Set<Territorio> getTerritori() {
		return this.territori;
	}
	
	void occupaSpazio (Spazio spazio, Familiare familiare) {
		
		if (familiare.disponibile()) {
		
			int servitoriAggiuntivi = 0;
		
			//chiedi quanti servitori vuoi
		
			if (spazio.occupabile(familiare, servitoriAggiuntivi) ) {
				
				this.setRisorse.getServitori().aggiungi(-servitoriAggiuntivi);
				spazio.occupa(familiare);
			}
		}
		
	}
	
	
	

}
