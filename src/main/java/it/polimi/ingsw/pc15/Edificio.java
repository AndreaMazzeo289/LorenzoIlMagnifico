package it.polimi.ingsw.pc15;

import java.util.Set;

public class Edificio extends Carta {
	
	private int requisitoProduzione;
	private Effetto effettoProduzione;
	
	public Edificio (String nome, int id, int periodo, SetRisorse costo, Set<Effetto> effettoIstantaneo, int requisitoProduz, Effetto effettoProduzione, SpazioTorre spazio) {
		super(nome, id, periodo, costo, effettoIstantaneo);
		this.requisitoProduzione = requisitoProduz;
		this.effettoProduzione = effettoProduzione;
	}

	public int getRequisitoProduzione() {
		return this.requisitoProduzione;
	}
	
	public Effetto getEffettoProduzione() {
		return this.effettoProduzione;
	}

}
