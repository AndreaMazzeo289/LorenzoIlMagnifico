package it.polimi.ingsw.pc15.risorse;

public abstract class Risorsa {
	
	private int quantità;
	//protected int moltiplicatore;
	//protected int quantitàBonus;
	protected TipoRisorsa tipoRisorsa;
		
	public Risorsa (int quantità) { 
		this.quantità = quantità;
		//this.moltiplicatore = 1;
		//this.quantitàBonus = 0;
	}
	
	public int getQuantità() {
		return this.quantità;
	}
	
	public void aggiungi (int quantità) {
		//this.quantità += quantità*moltiplicatore + quantitàBonus;
		this.quantità += quantità;
	}
	
	public boolean paragona (int quantità) {
		if (this.quantità < quantità)
			return false;
		
		return true;
	}
	
	public TipoRisorsa getTipoRisorsa(){
		return this.tipoRisorsa;
	}

}
