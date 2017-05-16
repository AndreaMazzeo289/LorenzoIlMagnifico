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
	public boolean prendibile (Player player) {
		
		if (player.getEdifici().size() == 6) {    //limite carte Edificio
			System.out.println("Hai raggiunto il limite massimo di carte Edificio!");
			return false;
		}
		
		if (this.risorseSufficienti(player) == false) {
			System.out.println("Non hai risorse sufficienti!");
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


	@Override
	public void daiA(Player player) {
		this.setSpazio(null);
		player.getEdifici().add(this);
		this.setPlayer(player);
		
	}

}
