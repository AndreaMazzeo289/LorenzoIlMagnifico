package it.polimi.ingsw.pc15;

import java.util.Iterator;

public class Moltiplicazione implements Effetto{
	
	private TipoRisorsa tipoRisorsa;
	private int numRisorsa;
	private SetRisorse setRisorse;
	
	public Moltiplicazione(int numRisorsa, TipoRisorsa tipoRisorsa, SetRisorse setRisorse){
		this.tipoRisorsa = tipoRisorsa;
		this.numRisorsa = numRisorsa;
		this.setRisorse = setRisorse;
	}

	@Override
	public void attiva(Player player) {
		
		for(int i = 1; i<=(player.getSetRisorse().getRisorsa(tipoRisorsa).getQuantità()/this.numRisorsa); i++){
			
		       player.getSetRisorse().aggiungi(this.setRisorse);
	
	           }
		
		switch(this.tipoRisorsa) {
		
		
		case TERRITORI : Iterator<Territorio> territorio = player.getTerritori().iterator();
		
						 while(territorio.hasNext()){
							 
						 player.getSetRisorse().aggiungi(this.setRisorse);
						 
						 }; break;
						 
		case PERSONAGGI: Iterator<Personaggio> personaggio = player.getPersonaggi().iterator();
		
					      while(personaggio.hasNext()){
								 
						  player.getSetRisorse().aggiungi(this.setRisorse);
							 
						  }; break;
						  
		case EDIFICI : Iterator<Edificio> edificio = player.getEdifici().iterator();
		
		               while(edificio.hasNext()){
			 
		               player.getSetRisorse().aggiungi(this.setRisorse);
		 
		               }; break;
		 
		case IMPRESE : Iterator<Impresa> impresa = player.getImprese().iterator();
		
		               while(impresa.hasNext()){
			 
		               player.getSetRisorse().aggiungi(this.setRisorse);
		 
		               }; break;
		
		}
		
		
	}

}
