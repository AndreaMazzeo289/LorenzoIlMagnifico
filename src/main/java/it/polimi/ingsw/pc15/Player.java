package it.polimi.ingsw.pc15;

import java.util.Set;

public class Player {
	
	private final String name;
	private SetRisorse setRisorse;
	private Familiare familiari[];
	private Set<Territorio> territori;
	private Set<Personaggio> personaggi;
	private Set<Edificio> edifici;
	private Set<Impresa> imprese;
	
	
	
	public Player (String name, SetRisorse setRisorse) {
		this.name = name;
		this.setRisorse = setRisorse;
		this.familiari = new Familiare[4];
		this.familiari[1] = new Familiare (ColoreFamiliare.NERO);
		this.familiari[2] = new Familiare (ColoreFamiliare.BIANCO);
		this.familiari[3] = new Familiare (ColoreFamiliare.ARANCIONE);
		this.familiari[4] = new Familiare (ColoreFamiliare.NEUTRO);
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
	
	void occupaSpazio (Spazio spazio, Familiare familiare) {
		
		if (familiare.disponibile()) {
		
			int servitoriAggiuntivi = 0;
		
			//chiedi quanti servitori vuoi
		
			if (spazio.occupabile(familiare, servitoriAggiuntivi) )
				spazio.occupa(familiare);
		}
		
	}
	
	
	

}
