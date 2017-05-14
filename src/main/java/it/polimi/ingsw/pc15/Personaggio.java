package it.polimi.ingsw.pc15;

import java.util.Set;

public class Personaggio extends Carta {
	
	private Effetto effettoPermanente;
	
	public Personaggio (String nome, int id, int periodo, Set<Effetto> effettoIstantaneo, Effetto effettoPermanente) {
		super(nome, id, periodo, effettoIstantaneo);
		this.effettoPermanente = effettoPermanente;
		}

}
