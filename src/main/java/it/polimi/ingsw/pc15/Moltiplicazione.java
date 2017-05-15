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
		
		switch(this.tipoRisorsa) {
		
		case ORO : for(int i = 1; i<=(player.getSetRisorse().getOro().getQuantità()/this.numRisorsa); i++){
			
			       player.getSetRisorse().aggiungi(this.setRisorse);
		
		           };break;
		
		case LEGNA : for(int i = 1; i<=(player.getSetRisorse().getLegna().getQuantità()/this.numRisorsa); i++){
			
			         player.getSetRisorse().aggiungi(this.setRisorse);
		
		             };break;
		
		case SERVITORI : for(int i = 1; i<=(player.getSetRisorse().getServitori().getQuantità()/this.numRisorsa); i++){
			
			             player.getSetRisorse().aggiungi(this.setRisorse);
		
		                 };break;
		
		case PUNTIVITTORIA : for(int i = 1; i<=(player.getSetRisorse().getPuntiVittoria().getQuantità()/this.numRisorsa); i++){
			
			                 player.getSetRisorse().aggiungi(this.setRisorse);
		
		                     };break;
		
		case PIETRA : for(int i = 1; i<=(player.getSetRisorse().getPietra().getQuantità()/this.numRisorsa); i++){
			          
			          player.getSetRisorse().aggiungi(this.setRisorse);
		       
		              };break;
		
		case PUNTIMILITARI : for(int i = 1; i<=(player.getSetRisorse().getPuntiMilitari().getQuantità()/this.numRisorsa); i++){
			
			                 player.getSetRisorse().aggiungi(this.setRisorse);
		
		                     };break;
		
		case PUNTIFEDE : for(int i = 1; i<=(player.getSetRisorse().getPuntiFede().getQuantità()/this.numRisorsa); i++){
			
			             player.getSetRisorse().aggiungi(this.setRisorse);
		
		                 };break;
		
		case PRIVILEGI : for(int i = 1; i<=(player.getSetRisorse().getPrivilegi().getQuantità()/this.numRisorsa); i++){
						
			             player.getSetRisorse().aggiungi(this.setRisorse);
		                 
		                 };break;
		
		case TERRITORI : Iterator<Territorio> territorio = this.player.getTerritori().iterator();
		
						 while(territorio.hasNext()){
							 
						 player.getSetRisorse().aggiungi(this.setRisorse);
						 
						 }; break;
						 
		case PERSONAGGI: Iterator<Personaggio> personaggio = this.player.getPersonaggi().iterator();
		
					      while(territorio.hasNext()){
								 
						  player.getSetRisorse().aggiungi(this.setRisorse);
							 
						  }; break;
						  
		case EDIFICI : Iterator<Edificio> edificio = this.player.getEdifici().iterator();
		
		               while(edificio.hasNext()){
			 
		               player.getSetRisorse().aggiungi(this.setRisorse);
		 
		               }; break;
		 
		case IMPRESE : Iterator<Impresa> impresa = this.player.getImprese().iterator();
		
		               while(imprese.hasnext()){
			 
		               player.getSetRisorse().aggiungi(this.setRisorse);
		 
		               }; break;
		
		}
		
		
	}

}
