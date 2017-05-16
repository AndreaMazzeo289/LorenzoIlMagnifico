package it.polimi.ingsw.pc15;

import java.util.Queue;

public abstract class Spazio {
	
	private int valoreMin;
	
	public Spazio(int valoreMin) {
		this.valoreMin=valoreMin;
	}

	public int getValoreMin (){
		return this.valoreMin;
	}
	
	public abstract void rimuoviFamiliari();	
	
	public abstract boolean isEmpty();
	
	public abstract void occupa (Familiare familiare);
	
	public abstract boolean occupabile (Familiare familiare);
}
