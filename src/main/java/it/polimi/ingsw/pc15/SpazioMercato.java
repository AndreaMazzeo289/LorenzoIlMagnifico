package it.polimi.ingsw.pc15;

import java.util.Queue;

public class SpazioMercato extends Spazio {

	private Familiare familiare;
	
	public SpazioMercato(int valoreMin,Familiare familiare) {
		super(valoreMin);
		this.familiare=familiare;
	}
	
	@Override
	public void occupa (Familiare familiare){
		this.familiare = familiare;
		//azione mercato
	}
	
	@Override
	public boolean occupabile(Familiare familiare, int servitoriAggiuntivi){
		if(familiare.getValore()+servitoriAggiuntivi >= getValoreMin() )  {
			return false;
		}
		
		if (!isEmpty() ) {
			return false;
		}
		
		return true;
	}

	@Override
	public void rimuoviFamiliari() {
		familiare=null;
	}

	@Override
	public boolean isEmpty() {
		if(familiare==null)
			return true;
		return false;
	}
	
}
