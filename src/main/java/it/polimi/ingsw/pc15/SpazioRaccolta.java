package it.polimi.ingsw.pc15;

import java.util.Queue;

public class SpazioRaccolta extends Spazio {
	
	private Queue<Familiare> listaFamiliari;
	
	public SpazioRaccolta(int valoreMin) {
		super(valoreMin);
		listaFamiliari = new Queue<Familiare>();
	}

	@Override
	public void occupa(Familiare familiare) {
		listaFamiliari.add(familiare);
		//azione raccolta
	}

	@Override
	public boolean occupabile(Familiare familiare, int servitoriAggiuntivi){
		if(listaFamiliari.isEmpty())
			if(familiare.getValore()+servitoriAggiuntivi >= getValoreMin())
				return true;
			else
				return false;
		else
			if(familiare.getValore()+servitoriAggiuntivi >= getValoreMin()+3)
				return true;
			else
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
