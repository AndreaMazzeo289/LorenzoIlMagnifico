package it.polimi.ingsw.pc15;

import java.util.Queue;

public class SpazioConsiglio extends Spazio {
	
	private Queue<Familiare> listaFamiliari;
	
	public SpazioConsiglio(int valoreMin) {
		super(valoreMin);
		listaFamiliari = new Queue<Familiare>();
	}
	
	@Override
	public void occupa (Familiare familiare){
		listaFamiliari.add(familiare);
	}
	
	@Override
	public boolean occupabile(Familiare familiare, int servitoriAggiuntivi){
		if(familiare.getValore()+servitoriAggiuntivi >= getValoreMin())
			return true;
		return false;
	}

	@Override
	public void rimuoviFamiliari() {
		listaFamiliari.clear();
	}

	@Override
	public boolean isEmpty() {
		if(listaFamiliari.isEmpty())
			return true;
		return false;
	}
	
}
