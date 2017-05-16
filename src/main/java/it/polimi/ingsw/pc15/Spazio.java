package it.polimi.ingsw.pc15;

import java.util.Queue;

public abstract class Spazio {
	
	private int valoreMin;
	private boolean disponibilità;
	
	public Spazio(int valoreMin) {
		this.valoreMin=valoreMin;
	}

	public int getValoreMin (){
		return this.valoreMin;
	}
	
	public void setDisponibilità (boolean disponibilità) {
		this.disponibilità = disponibilità;
	}
	
	public abstract void rimuoviFamiliari();	
	
	public boolean disponibile() {
		return this.disponibilità;
	}
	
	public abstract boolean isEmpty();
	
	public abstract void occupa (Familiare familiare);
	
	public abstract boolean occupabile (Familiare familiare);
}
