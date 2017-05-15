package it.polimi.ingsw.pc15;

import java.util.Set;

public class Impresa extends Carta {
	
	private Effetto aumentoPuntiVittoria;
	private int requisitoPuntiMilitari;
	private int costoPuntiMilitari;
	
	public Impresa (String nome, int id, int periodo, SetRisorse costo, Set<Effetto> effettoIstantaneo, Effetto aumentoPuntiVittoria, SpazioTorre spazio) {
		super(nome, id, periodo, costo, effettoIstantaneo, spazio);
		this.aumentoPuntiVittoria = aumentoPuntiVittoria;
		this.requisitoPuntiMilitari = requisitoPuntiMilitari;
		this.costoPuntiMilitari = costoPuntiMilitari;
		}
	
	@Override
	public boolean acquistabile(Player player) {
		
		if (player.getImprese().size() == 6) {
			return false;
		}
		
		if (player.getRisorse().paragona(getCosto()) == false) {
			return false;
		}
		
		
		return true;
		
	}

}
