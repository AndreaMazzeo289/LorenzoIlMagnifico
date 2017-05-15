package it.polimi.ingsw.pc15;

import java.util.Queue;

public class SpazioMercato extends Spazio {

	private Familiare familiare;
	private Effetto effetto;
	
	public SpazioMercato(int valoreMin,Familiare familiare, SetRisorse risorseBonus) {
		super(valoreMin);
		this.familiare=familiare;
		effetto = new AggiuntaRisorse (risorseBonus);
	}
	
	@Override
	public void occupa (Familiare familiare){
		this.familiare = familiare;
		effetto.attiva(this.familiare.getPlayer());
	}
	
	@Override
	public boolean occupabile(Familiare familiare, int servitoriAggiuntivi){
		if(familiare.getValore()+servitoriAggiuntivi >= getValoreMin())
			return true;
		return false;
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
