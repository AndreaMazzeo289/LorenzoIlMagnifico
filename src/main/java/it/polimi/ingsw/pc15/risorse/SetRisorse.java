package it.polimi.ingsw.pc15.risorse;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class SetRisorse implements Serializable {  

	private HashMap<TipoRisorsa, Risorsa> risorse;
	
	public SetRisorse (HashSet<Risorsa> risorse) {
		
		this.risorse = new HashMap<TipoRisorsa, Risorsa>();

		for (Risorsa risorsa : risorse)
			this.risorse.put(risorsa.getTipoRisorsa(), risorsa);
	}
	
	public void aggiungi (SetRisorse setRisorse) {  
		
		for (Map.Entry<TipoRisorsa, Risorsa> risorsa : setRisorse.getRisorse().entrySet())
			if (this.risorse.containsKey(risorsa.getKey())==false) {
				try {
					risorse.put(risorsa.getKey(), risorsa.getValue().copia());
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}
	
			else this.risorse.get(risorsa.getKey()).aggiungi(risorsa.getValue().getQuantità());
	}
	
	public void sottrai (SetRisorse setRisorse) {
		
		for (Map.Entry<TipoRisorsa, Risorsa> risorsa : setRisorse.getRisorse().entrySet()) {
			this.risorse.get(risorsa.getKey()).aggiungi(risorsa.getValue().getQuantità());
			if (this.risorse.get(risorsa.getKey()).getQuantità()<0)
				this.risorse.get(risorsa.getKey()).aggiungi(-this.risorse.get(risorsa.getKey()).getQuantità());
		}
	}

	public boolean paragona (SetRisorse setRisorse) { 
		
		for (Map.Entry<TipoRisorsa, Risorsa> risorsa : setRisorse.getRisorse().entrySet())
			if (this.risorse.get(risorsa.getKey()).paragona(risorsa.getValue().getQuantità())==false)
				return false;
	
		return true;
	}
	
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
