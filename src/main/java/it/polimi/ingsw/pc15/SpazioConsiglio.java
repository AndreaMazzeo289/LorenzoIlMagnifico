package it.polimi.ingsw.pc15;

import java.util.LinkedList;
import java.util.Queue;

public class SpazioConsiglio extends Spazio {
	
	private Queue<Familiare> listaFamiliari;
	private Effetto effetto;
	
	public SpazioConsiglio(int valoreMin, SetRisorse risorseBonus) {
		super(valoreMin);
		listaFamiliari = new LinkedList<Familiare>();
		effetto = new AggiuntaRisorse (risorseBonus);
	}
	
	@Override
	public void occupa (Familiare familiare){
		listaFamiliari.add(familiare);
		effetto.attiva(familiare.getPlayer());
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
