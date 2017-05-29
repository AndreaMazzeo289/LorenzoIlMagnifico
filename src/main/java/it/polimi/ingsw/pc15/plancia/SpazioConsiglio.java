package it.polimi.ingsw.pc15.plancia;

import java.util.LinkedList;
import java.util.Queue;

import it.polimi.ingsw.pc15.effetti.AggiuntaRisorse;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

public class SpazioConsiglio extends Spazio {
	
	private Queue<Familiare> listaFamiliari;
	private Effetto effetto;
	
	public SpazioConsiglio(int valoreMin, SetRisorse setRisorse) {
		super(valoreMin);
		this.listaFamiliari = new LinkedList<Familiare>();
		this.effetto = new AggiuntaRisorse (setRisorse);
	}
	
	@Override
	public void occupa (Familiare familiare){
		this.listaFamiliari.add(familiare);
		this.effetto.attiva(familiare.getPlayer());
	}
	
	@Override
	public boolean occupabile(Familiare familiare){
		if(familiare.getValore() < getValoreMin()) {
			System.out.println("Il valore del tuo familiare è troppo basso!");
			return false;
		}
		
		
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