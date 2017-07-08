package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;

/**
 * Superclasse generale di ogni risorsa del giocatore.
 */

public abstract class Risorsa implements Serializable, Cloneable {
	
	private int quantità;
	protected TipoRisorsa tipoRisorsa;
		
	public Risorsa (int quantità) { 
		this.quantità = quantità;
	}
	
	/**
	 * Aumenta la quantità della risorsa di un numero scelto.
	 * 
	 * @param quantità da aggiungere
	 */
	
	public void aggiungi (int quantità) {
		this.quantità += quantità;
	}
	
	/**
	 * Controlla se la risorsa ha quantità maggiore o uguale a un numero dato.
	 * 
	 * @param numero da paragonare
	 * @return true in caso affermativo, false in caso negativo
	 */
	
	public boolean paragona (int quantità) {
		if (this.quantità < quantità)
			return false;
		
		return true;
	}
	
	/**
	 * Restituisce la tipologia della risorsa (Oro, Legno, Pietra, ecc.).
	 * 
	 * @return tipo della risorsa
	 */
	
	public TipoRisorsa getTipoRisorsa(){
		return this.tipoRisorsa;
	}
	
	/**
	 * Restituisce l'attuale quantità della Risorsa.
	 * 
	 * @return quantità attuale
	 */
	
	public int getQuantità() {
		return this.quantità;
	}
	
	public Risorsa copia() throws CloneNotSupportedException {
		return (Risorsa) this.clone();
	}
}
	

