package it.polimi.ingsw.pc15;

import java.util.Set;

public class Edificio extends Carta {
	
	private int requisitoProduzione;
	private Effetto effettoProduzione;
	
	public Edificio (String nome, int id, int periodo, SetRisorse costo, Set<Effetto> effettoIstantaneo, int requisitoProduz, Effetto effettoProduzione, SpazioTorre spazio) {
		super(nome, id, periodo, costo, effettoIstantaneo, spazio);
		this.requisitoProduzione = requisitoProduz;
		this.effettoProduzione = effettoProduzione;
	}
	
	@Override
	public boolean acquistabile(Player player) {
		
		if (player.getEdifici().size() == 6) {
			return false;
		}
		
		if (player.getRisorse().paragona(getCosto()) == false) {
			return false;
		}
		
		
		return true;
		
	}
	
	public int getRequisitoProduzione() {
		return this.requisitoProduzione;
	}
	
	public Effetto getEffettoProduzione() {
		return this.effettoProduzione;
	}

}
