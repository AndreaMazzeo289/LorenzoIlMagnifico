package it.polimi.ingsw.pc15.plancia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Queue;

import it.polimi.ingsw.pc15.player.Familiare;

public abstract class Spazio implements Serializable {
	
	private int valoreMin;
	protected ArrayList<Familiare> familiari;
	
	public Spazio(int valoreMin) {
		this.valoreMin=1;
		this.familiari = new ArrayList<Familiare>();
	}

	public int getValoreMin (){
		return this.valoreMin;
	}
	
	public void aggiungiFamiliare(Familiare familiare) {
		familiari.add(familiare);
	}
	
	public void rimuoviFamiliari() {
		this.familiari.clear();
	}
	
	public ArrayList<Familiare> getFamiliari() {
		return this.familiari;
	}
	
	public boolean vuoto() {
		return familiari.isEmpty();
	}

}
