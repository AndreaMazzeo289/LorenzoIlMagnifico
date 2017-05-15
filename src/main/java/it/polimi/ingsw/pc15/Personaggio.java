package it.polimi.ingsw.pc15;

import java.util.Set;

public class Personaggio extends Carta {
	
	private Effetto effettoPermanente;
	
	public Personaggio (String nome, int id, int periodo, SetRisorse costo, Set<Effetto> effettoIstantaneo, Effetto effettoPermanente, SpazioTorre spazio) {
		super(nome, id, periodo, costo, effettoIstantaneo, spazio);
		this.effettoPermanente = effettoPermanente;
		}
	
	@Override
	public boolean acquistabile(Player player) {
		
		if (player.getPersonaggi().size() == 6) {
			return false;
		}
		
		if (player.getRisorse().paragona(getCosto()) == false) {
			return false;
		}
		
		return true;
		
	}

}
