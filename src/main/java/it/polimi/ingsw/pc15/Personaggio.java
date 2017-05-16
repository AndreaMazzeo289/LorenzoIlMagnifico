package it.polimi.ingsw.pc15;

import java.util.Set;

public class Personaggio extends Carta {
	
	private Effetto effettoPermanente;
	
	public Personaggio (String nome, int id, int periodo, SetRisorse costo, Set<Effetto> effettoIstantaneo, Effetto effettoPermanente, SpazioTorre spazio) {
		super(nome, id, periodo, costo, effettoIstantaneo);
		this.effettoPermanente = effettoPermanente;
		}
	
	@Override
	public boolean prendibile (Player player) {
		
		if (player.getPersonaggi().size() == 6) {  //limite carte Personaggo
			System.out.println("Hai raggiunto il limite massimo di carte Personaggio!");
			return false;
		}
		
		if (this.risorseSufficienti(player) == false) { 
			System.out.println("Non hai risorse sufficienti!");
			return false;
		}
		
		return true;
		
	}

	@Override
	public void daiA(Player player) {
		this.setSpazio(null);
		player.getPersonaggi().add(this);
		this.setPlayer(player);
		
		
	}

}
