package it.polimi.ingsw.pc15.plancia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Queue;

import it.polimi.ingsw.pc15.player.Familiare;

/**
 * Spazio astratto superclasse degli spazi nel gioco.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */


public abstract class Spazio implements Serializable {
	
	private int valoreMin;
	protected ArrayList<Familiare> familiari;
	
	public Spazio(int valoreMin) {
		this.valoreMin=valoreMin;
		this.familiari = new ArrayList<Familiare>();
	}

	/**
	 * @return valore minimo di posizionamento del familiare 
	 * per occupare lo spazio.
	 */
	
	public int getValoreMin (){
		return this.valoreMin;
	}
	
	/**
	 * Permette di aggiungere un familiare nello spazio designato.
	 * 
	 * @param familiare da posizionare.
	 */
	
	public void aggiungiFamiliare(Familiare familiare) {
		familiari.add(familiare);
	}
	
	/**
	 *Permette la rimozione del familiare dallo spazio in questione. 
	 */
	
	public void rimuoviFamiliari() {
		this.familiari.clear();
	}
	
	/**
	 * @return restituisce i familiari legati allo spazio.
	 */
	
	public ArrayList<Familiare> getFamiliari() {
		return this.familiari;
	}
	
	/**
	 * Verifica la dispoibilità dello spazio-
	 * 
	 * @return true o false in base alla disponibilità dello spazio.
	 */
	
	public boolean vuoto() {
		return familiari.isEmpty();
	}

}
