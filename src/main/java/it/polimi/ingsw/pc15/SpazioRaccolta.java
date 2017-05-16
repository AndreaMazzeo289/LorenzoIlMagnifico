package it.polimi.ingsw.pc15;

import java.util.Queue;
import java.util.LinkedList;

public class SpazioRaccolta extends Spazio {
	
	private Queue<Familiare> listaFamiliari;
	
	public SpazioRaccolta(int valoreMin) {
		super(valoreMin);
		this.listaFamiliari = new LinkedList<Familiare>();
	}

	@Override
	public void occupa(Familiare familiare) {
		this.listaFamiliari.add(familiare);

		Effetto effetto = new AzioneRaccolto (familiare.getValore());
		effetto.attiva(familiare.getPlayer());
	}

	@Override
	public boolean occupabile (Familiare familiare){
		
		if(this.listaFamiliari.isEmpty()) 
			
			if(familiare.getValore() >= getValoreMin())
				return true;
			else
				return false;
		else
			if(familiare.getValore() >= getValoreMin()+3)
				return true;
			else
				return false;
		
	}

	@Override
	public void rimuoviFamiliari() {
		this.listaFamiliari.clear();
	}

	@Override
	public boolean isEmpty() {
		if(listaFamiliari.isEmpty())
			return true;
		return false;
	}
	
	
}
