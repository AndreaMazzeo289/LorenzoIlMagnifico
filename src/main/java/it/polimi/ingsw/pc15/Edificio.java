package it.polimi.ingsw.pc15;

import java.util.Set;

public class Edificio extends Carta {
	
	private int requisitoProduz;
	private Effetto effettoProduz;
	
	public Edificio (String nome, int id, int periodo, Set<Effetto> effettoIstantaneo, int requisitoProduz, Effetto effettoProduz) {
		super(nome, id, periodo, effettoIstantaneo);
		this.requisitoProduz = requisitoProduz;
		this.effettoProduz = effettoProduz;
	}
	
	public 

}
