package it.polimi.ingsw.pc15;

import java.util.Set;

public class Edificio extends Carta {
	
	private int requisitoProduz;
	private Effetto effettoProduz;
	
	public Edificio (String nome, int id, int periodo, SetRisorse costo, Set<Effetto> effettoIstantaneo, int requisitoProduz, Effetto effettoProduz, SpazioTorre spazio) {
		super(nome, id, periodo, costo, effettoIstantaneo, spazio);
		this.requisitoProduz = requisitoProduz;
		this.effettoProduz = effettoProduz;
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

}
