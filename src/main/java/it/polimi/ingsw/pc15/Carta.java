package it.polimi.ingsw.pc15;

import java.util.Observable;
import java.util.Set;

public abstract class Carta {
	
	private final String nome;
	private final int id;
	private final int periodo;
	private final SetRisorse costo;
	private final Set<Effetto> effettoIstantaneo;
	
	public Carta (String nome, int id, int periodo, Set<Effetto> effettoIstantaneo) {
		this.nome = nome;
		this.id = id;
		this.periodo = periodo;
		this.effettoIstantaneo = effettoIstantaneo;
	}
	
	

}
