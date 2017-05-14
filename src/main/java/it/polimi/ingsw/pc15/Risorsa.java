package it.polimi.ingsw.pc15;

public abstract class Risorsa {
	
	private int quantità;
	
	
	public Risorsa (int quantità) { //costruttore
		this.quantità = quantità;
	}
	
	public int getQuantità() {
		return this.quantità;
	}
	
	public void aggiungi (int quantità) {
		
		this.quantità += quantità;
	}
	
	public boolean paragona (int quantità) {
		if (this.quantità < quantità)
			return false;
		
		return true;
	}

}
