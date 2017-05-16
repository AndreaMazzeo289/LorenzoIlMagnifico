package it.polimi.ingsw.pc15;

import java.util.Set;

public class Personaggio extends Carta {
	
	private Effetto effettoPermanente;
	
	public Personaggio (String nome, int id, int periodo, SetRisorse costo, Set<Effetto> effettoIstantaneo, Effetto effettoPermanente, SpazioTorre spazio) {
		super(nome, id, periodo, costo, effettoIstantaneo);
		this.effettoPermanente = effettoPermanente;
		}

}
