package it.polimi.ingsw.pc15;

import java.util.Set;

public class Impresa extends Carta {
	
	private Effetto aumentoPuntiVittoria;
	private int requisitoPuntiMilitari;
	private int costoPuntiMilitari;
	
	public Impresa (String nome, int id, int periodo, SetRisorse costo, Set<Effetto> effettoIstantaneo, Effetto aumentoPuntiVittoria, SpazioTorre spazio) {
		super(nome, id, periodo, costo, effettoIstantaneo);
		this.aumentoPuntiVittoria = aumentoPuntiVittoria;
		this.requisitoPuntiMilitari = requisitoPuntiMilitari;
		this.costoPuntiMilitari = costoPuntiMilitari;
		}
	
	@Override
	public boolean prendibile (Player player) {
		
		if (player.getImprese().size() == 6) {  //limite carte Impresa
			System.out.println("Hai raggiunto il limite massimo di carte Impresa!");
			return false;
		}
		
		if (risorseSufficienti(player) == false) {
			System.out.println("Non hai risorse sufficienti!");
			return false;
		}
		
		
		return true;
		
	}

	@Override
	public void daiA(Player player) {
		this.setSpazio(null);
		player.getImprese().add(this);
		this.setPlayer(player);
		
	}
	
	

}
