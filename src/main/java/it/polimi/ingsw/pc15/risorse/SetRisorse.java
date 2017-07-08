package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * Classe etRisorse inizializza i set risorse a partire da un HashSet(Risorsa)
 * composto dai vari oggetti sottoclasse di Risorsa.
 * 
 */

public class SetRisorse implements Serializable {  

	private HashMap<TipoRisorsa, Risorsa> risorse;
	
	public SetRisorse (HashSet<Risorsa> risorse) {
		
		this.risorse = new HashMap<TipoRisorsa, Risorsa>();

		for (Risorsa risorsa : risorse)
			this.risorse.put(risorsa.getTipoRisorsa(), risorsa);
	}
	
	/**
	 * Aggiunge la singola risorsa al set designato.
	 * Se la risorsa non esiste nell'HashSet, crea una copia di quella in ingresso
	 * e la aggiunge al set risorse.
	 * 
	 * @param risorsa da aggiungere all' HashSet.
	 */
	
	public void aggiungi (Risorsa risorsa){
		if (this.risorse.containsKey(risorsa.getTipoRisorsa()))
			this.risorse.get(risorsa.getTipoRisorsa()).aggiungi(risorsa.getQuantità());
		else
			try {
				risorse.put(risorsa.getTipoRisorsa(), risorsa.copia());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();  //NOSONAR
			}
	}
	
	/**
	 * Aggiunge le quantità del set in ingresso a quello designato.
	 * Se il set in ingresso ha una risorsa non contenuta in quello a cui sto aggiungendo 
	 * creo una copia di quella risorsa e la aggiungo. 
	 * 
	 * @param setRisorse da aggiungere
	 */
	
	public void aggiungi (SetRisorse setRisorse) {  
		
		for (Map.Entry<TipoRisorsa, Risorsa> risorsa : setRisorse.getRisorse().entrySet())
			if (this.risorse.containsKey(risorsa.getKey())==false) {
				try {
					risorse.put(risorsa.getKey(), risorsa.getValue().copia());
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();  //NOSONAR
				}
			}
	
			else this.risorse.get(risorsa.getKey()).aggiungi(risorsa.getValue().getQuantità());
	}
	
	
	/**
	 * Ricevo in ingresso un set risorse e sottraggo le quantità alle risorse di quello designato.
	 * 
	 * @param setRisorse da sottrarre
	 */
	
	public void sottrai (SetRisorse setRisorse) {
		
		for (Map.Entry<TipoRisorsa, Risorsa> risorsa : setRisorse.getRisorse().entrySet()) {
			if (this.risorse.containsKey(risorsa.getKey())) {
				this.risorse.get(risorsa.getKey()).aggiungi(-risorsa.getValue().getQuantità());
				if (this.risorse.get(risorsa.getKey()).getQuantità()<0)
					this.risorse.get(risorsa.getKey()).aggiungi(-this.risorse.get(risorsa.getKey()).getQuantità());
			}
		}
	}
	
	/**
	 * Paragono due set Risorse.
	 * 
	 * @param setRisorse da paragonare.
	 * @return true se il primo è >= del secondo, altrimenti false.
	 */

	public boolean paragona (SetRisorse setRisorse) { 
		
		for (Map.Entry<TipoRisorsa, Risorsa> risorsa : setRisorse.getRisorse().entrySet())
			if (!this.risorse.containsKey(risorsa.getKey()) || this.risorse.get(risorsa.getKey()).paragona(risorsa.getValue().getQuantità())==false)
				return false;
	
		return true;
	}
	
	/**
	 * Prende una risorsa dal set risorse
	 * 
	 * @param tipoRisorsa della risorsa da prelevare.
	 * @return una risorsa dal set risorse.
	 */
	
	public Risorsa getRisorsa(TipoRisorsa tipoRisorsa){
		
		return risorse.get(tipoRisorsa);	
	}
	
	public HashMap<TipoRisorsa,Risorsa> getRisorse() {
		return this.risorse;
	}
	
	public String toString() {
		String stringa = "[ ";
		if (risorse.isEmpty())
			stringa += "nessuno ";
		else for(Map.Entry<TipoRisorsa, Risorsa> risorsa : risorse.entrySet()) 
			stringa += (risorsa.getValue().toString() + ":" + risorsa.getValue().getQuantità() + " ");
		stringa += "]";
		return stringa;
	}

}
