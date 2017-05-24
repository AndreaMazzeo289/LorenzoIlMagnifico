package it.polimi.ingsw.pc15.risorse;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;


public class SetRisorse {  

	HashMap<TipoRisorsa,Risorsa> risorse;
	
	public SetRisorse (HashSet<Risorsa> risorse) {
		
		this.risorse = new HashMap<TipoRisorsa, Risorsa>();
		
		Iterator<Risorsa> risorsa = risorse.iterator();	                          //   aggiungo le risorse del set ricevuto come parametro		
		while(risorsa.hasNext()){		                                          //       nella mappa 
			Risorsa risorsaExt = risorsa.next();
			this.risorse.put(risorsaExt.getTipoRisorsa(), risorsaExt);
		}

	}
	
	public void aggiungi (SetRisorse setRisorse) {  //aggiunge al setRisorse corrente le risorse del setRisorse passato come parametro
		
		for(Map.Entry<TipoRisorsa, Risorsa> risorsa1 : risorse.entrySet()) {
			for(Map.Entry<TipoRisorsa, Risorsa> risorsa2 : setRisorse.getRisorse().entrySet()) {
				if(risorsa1.getKey().equals(risorsa2.getKey()))
					risorsa1.getValue().aggiungi(risorsa2.getValue().getQuantità());
			}
		}
		
		/*Iterator<Map.Entry<TipoRisorsa, Risorsa>> it1 = this.risorse.entrySet().iterator();
		
		while(it1.hasNext()){
			
			Iterator<Map.Entry<TipoRisorsa, Risorsa>> it2 = setRisorse.getRisorse().entrySet().iterator();
			
			while(it2.hasNext()){
				
				if(it1.next().getKey().equals(it2.next().getKey())) {
					
					it1.next().getValue().aggiungi(it2.next().getValue().getQuantità());
				}
			}
		}*/
	}
	
	public void sottrai (SetRisorse setRisorse) {  //aggiunge al setRisorse corrente le risorse del setRisorse passato come parametro
		
		for(Map.Entry<TipoRisorsa, Risorsa> risorsa1 : risorse.entrySet()) {
			for(Map.Entry<TipoRisorsa, Risorsa> risorsa2 : setRisorse.getRisorse().entrySet()) {
				if(risorsa1.getKey().equals(risorsa2.getKey()))
					risorsa1.getValue().aggiungi(-risorsa2.getValue().getQuantità());
			}
		}
		
		/*Iterator<Map.Entry<TipoRisorsa, Risorsa>> it1 = this.risorse.entrySet().iterator();
				
		while(it1.hasNext()){
					
			Iterator<Map.Entry<TipoRisorsa, Risorsa>> it2 = setRisorse.getRisorse().entrySet().iterator();
					
			while(it2.hasNext()){
						
				if(it1.next().getKey().equals(it2.next().getKey())) {
							
					it1.next().getValue().aggiungi(-it2.next().getValue().getQuantità());
				}
			}
		}*/
		
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
		

		/*
		
		Iterator<Map.Entry<TipoRisorsa, Risorsa>> it1 = this.risorse.entrySet().iterator();
		
		while(it1.hasNext()){
					
			Iterator<Map.Entry<TipoRisorsa, Risorsa>> it2 = setRisorse.getRisorse().entrySet().iterator();
					
			while(it2.hasNext()){
						
				if(it1.next().getKey().equals(it2.next().getKey())) {
							
					if (it1.next().getValue().paragona(it2.next().getValue().getQuantità()));
					else return false;
				}
			}
		}
		return true;
		
		
		*/
	}
	
	public Risorsa getRisorsa(TipoRisorsa tipoRisorsa){
		//Risorsa prova = risorse.get(tipoRisorsa);
		//System.out.println(prova);
		return risorse.get(tipoRisorsa);
		
	}
	public HashMap<TipoRisorsa,Risorsa> getRisorse(){
		
		return this.risorse;
		
	}

}
