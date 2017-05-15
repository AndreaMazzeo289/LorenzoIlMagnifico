package it.polimi.ingsw.pc15;

import java.util.LinkedList;
import java.util.Queue;

public class SpazioProduzione extends Spazio{

	private Queue<Familiare> listaFamiliari;
	
	public SpazioProduzione(int valoreMin) {
		super(valoreMin);
		listaFamiliari = new LinkedList<Familiare>();
	}

	@Override
	public void occupa(Familiare familiare) {
		listaFamiliari.add(familiare);
		//azione produzione
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
