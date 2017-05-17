package it.polimi.ingsw.pc15;

<<<<<<< HEAD
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class SetRisorse {
=======
public class SetRisorse {   //mappa
>>>>>>> 8622c27cf4a484fd5a1f9ca998aca4b40f28c3b3
	
	
	HashMap<TipoRisorsa,Risorsa> risorse;
	
	public SetRisorse (HashSet<Risorsa> risorse) {
		
		this.risorse = new HashMap<TipoRisorsa, Risorsa>();
		Iterator<Risorsa> risorsa = risorse.iterator();	
		
		while(risorsa.hasNext()){		
			this.risorse.put(risorsa.next().getTipoRisorsa(), risorsa.next());
		}

	}
	
	
	public void aggiungi (SetRisorse setRisorse) {  //aggiunge al setRisorse corrente le risorse del setRisorse passato come parametro
		
		
		Iterator<Map.Entry<TipoRisorsa, Risorsa>> it1 = this.risorse.entrySet().iterator();
		
		while(it1.hasNext()){
			
			Iterator<Map.Entry<TipoRisorsa, Risorsa>> it2 = setRisorse.getRisorse().entrySet().iterator();
			
			while(it2.hasNext()){
				
				if(it1.next().getKey().equals(it2.next().getKey())) {
					
					it1.next().getValue().aggiungi(it2.next().getValue().getQuantità());
				}
			}
		}
	}
	
	public void sottrai (SetRisorse setRisorse) {  //aggiunge al setRisorse corrente le risorse del setRisorse passato come parametro
		
		Iterator<Map.Entry<TipoRisorsa, Risorsa>> it1 = this.risorse.entrySet().iterator();
				
		while(it1.hasNext()){
					
			Iterator<Map.Entry<TipoRisorsa, Risorsa>> it2 = setRisorse.getRisorse().entrySet().iterator();
					
			while(it2.hasNext()){
						
				if(it1.next().getKey().equals(it2.next().getKey())) {
							
					it1.next().getValue().aggiungi(-it2.next().getValue().getQuantità());
				}
			}
		}
		
	}

	public boolean paragona (SetRisorse setRisorse) { //ritorna TRUE solo se il valore di ogni risorsa in questo setRisorse è >= di quello delle corrispondenti risorse del secondo setRisorse
		
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
	}
	
	public Risorsa getRisorsa(TipoRisorsa tipoRisorsa){
	
		return risorse.get(tipoRisorsa);
		
	}
	public HashMap<TipoRisorsa,Risorsa> getRisorse(){
		
		return this.risorse;
		
	}

}
