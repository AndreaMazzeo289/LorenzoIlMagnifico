package it.polimi.ingsw.pc15.plancia;

import java.util.Queue;

import it.polimi.ingsw.pc15.effetti.AzioneRaccolto;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.Familiare;

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
			else {
				System.out.println("Il valore del tuo familiare è troppo basso!");
				return false;
			}
		else
			if(familiare.getValore() >= getValoreMin()+3)
				return true;
			else {
				System.out.println("Il valore del tuo familiare è troppo basso!");
				return false;
			}
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
