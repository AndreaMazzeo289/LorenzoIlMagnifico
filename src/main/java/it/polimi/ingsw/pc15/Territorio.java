package it.polimi.ingsw.pc15;

import java.util.Set;

public class Territorio extends Carta {
	
	private int requisitoRaccolta;
	private Effetto effettoRaccolta;
	
	public Territorio (String nome, int id, int periodo, SetRisorse costo, Set<Effetto> effettoIstantaneo, int requisitoRaccolta, Effetto effettoRaccolta) {
		super(nome, id, periodo, costo, effettoIstantaneo);
		this.requisitoRaccolta = requisitoRaccolta;
		this.effettoRaccolta = effettoRaccolta;
	}
	
	public int getRequisitoRaccolta() {
		return this.requisitoRaccolta;
	}
	
	public Effetto getEffettoRaccolta() {
		return this.effettoRaccolta;
	}

	@Override
	public AzionePrendiCarta azionePrendiCarta(Player player) {
		
		AzionePrendiCarta azionePrendiCarta = new AzionePrendiCartaTerritorio (player, this);
		return azionePrendiCarta;
	}

}
