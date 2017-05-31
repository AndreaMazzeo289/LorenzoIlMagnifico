package it.polimi.ingsw.pc15.risorse;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class SetRisorse {  

	private HashMap<TipoRisorsa, Risorsa> risorse;
	
	public SetRisorse (HashSet<Risorsa> risorse) {
		
		this.risorse = new HashMap<TipoRisorsa, Risorsa>();

		for (Risorsa risorsa : risorse)
			this.risorse.put(risorsa.getTipoRisorsa(), risorsa);
	}
	
	public void aggiungi (SetRisorse setRisorse) {  //aggiunge al setRisorse corrente le risorse del setRisorse passato come parametro
		
		try{
			for(Map.Entry<TipoRisorsa, Risorsa> risorsa1 : risorse.entrySet()) {
				for(Map.Entry<TipoRisorsa, Risorsa> risorsa2 : setRisorse.getRisorse().entrySet()) {
					if(risorsa1.getKey().equals(risorsa2.getKey()))
						risorsa1.getValue().aggiungi(risorsa2.getValue().getQuantità());
				}
			}
		}catch(NullPointerException e){
			System.out.println("Eccezione aggiunta risorse bonus!");
		}
	}
	
	public void sottrai (SetRisorse setRisorse) {  //aggiunge al setRisorse corrente le risorse del setRisorse passato come parametro
		
		for(Map.Entry<TipoRisorsa, Risorsa> risorsa1 : risorse.entrySet()) {
			for(Map.Entry<TipoRisorsa, Risorsa> risorsa2 : setRisorse.getRisorse().entrySet()) {
				if(risorsa1.getKey().equals(risorsa2.getKey()))
					risorsa1.getValue().aggiungi(-risorsa2.getValue().getQuantità());
			}
		}
		
	}

	public boolean paragona (SetRisorse setRisorse) { 
		
		boolean risultato = true;
		
		for(Map.Entry<TipoRisorsa, Risorsa> risorsa1 : risorse.entrySet()) {
			for(Map.Entry<TipoRisorsa, Risorsa> risorsa2 : setRisorse.getRisorse().entrySet()) {
				if(risorsa1.getKey().equals(risorsa2.getKey())) {
					if (!risorsa1.getValue().paragona(risorsa2.getValue().getQuantità()))
						risultato = false;
				}
			}
		}
		
		return risultato;
	}
	
	public Risorsa getRisorsa(TipoRisorsa tipoRisorsa){
		
		return risorse.get(tipoRisorsa);	
	}
	
	public HashMap<TipoRisorsa,Risorsa> getRisorse(){
	
		return this.risorse;
	}

}
