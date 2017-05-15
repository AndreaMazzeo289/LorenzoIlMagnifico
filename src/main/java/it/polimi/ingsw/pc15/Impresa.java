package it.polimi.ingsw.pc15;

import java.util.Set;

public class Impresa extends Carta {
	
	private Effetto aumentoPuntiVittoria;
	private int requisitoPuntiMilitari;
	private int costoPuntiMilitari;
	
	public Impresa (String nome, int id, int periodo, Set<Effetto> effettoIstantaneo, Effetto aumentoPuntiVittoria) {
		super(nome, id, periodo, effettoIstantaneo);
		this.aumentoPuntiVittoria = aumentoPuntiVittoria;
		this.requisitoPuntiMilitari = requisitoPuntiMilitari;
		this.costoPuntiMilitari = costoPuntiMilitari;
		}
	
	@Override
	public boolean acquistabile(Player player) {
		
		if (player.getImprese().size() == 6) {
			return false;
		}
		
		if (player.getImprese().paragona(getCosto()) == false) {
			return false;
		}
		
		
		return true;
		
	}

}
