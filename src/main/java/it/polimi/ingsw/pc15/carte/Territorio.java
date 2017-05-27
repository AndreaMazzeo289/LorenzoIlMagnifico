package it.polimi.ingsw.pc15.carte;

import java.util.Set;

import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

public class Territorio extends Carta {
	
	private int requisitoRaccolta;
	private Effetto effettoRaccolta;
	
	public Territorio (String nome, int id, int periodo, SetRisorse costo, Set<Effetto> effettoIstantaneo, int requisitoRaccolta, Effetto effettoRaccolta) {
		super(nome, id, periodo, costo, effettoIstantaneo);
		this.requisitoRaccolta = requisitoRaccolta;
		this.effettoRaccolta = effettoRaccolta;
		this.colore = ColoreCarta.VERDE;
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
