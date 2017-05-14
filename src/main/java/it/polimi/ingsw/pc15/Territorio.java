package it.polimi.ingsw.pc15;

import java.util.Set;

public class Territorio extends Carta {
	
	private int requisitoRaccolta;
	private Effetto effettoRaccolta;
	
	public Territorio (String nome, int id, int periodo, Set<Effetto> effettoIstantaneo, int requisitoRaccolta, Effetto effettoRaccolta) {
		super(nome, id, periodo, effettoIstantaneo);
		this.requisitoRaccolta = requisitoRaccolta;
		this.effettoRaccolta = effettoRaccolta;
	}

}
