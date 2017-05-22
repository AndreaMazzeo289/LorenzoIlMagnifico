package it.polimi.ingsw.pc15.carte;

import java.util.Set;

import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

public class Personaggio extends Carta {
	
	private Effetto effettoPermanente;
	
	public Personaggio (String nome, int id, int periodo, SetRisorse costo, Set<Effetto> effettoIstantaneo, Effetto effettoPermanente) {
		super(nome, id, periodo, costo, effettoIstantaneo);
		this.effettoPermanente = effettoPermanente;
		}

	@Override
	public AzionePrendiCarta azionePrendiCarta(Player player) {
		
		AzionePrendiCarta azionePrendiCarta = new AzionePrendiCartaPersonaggio(player, this);
		return azionePrendiCarta;
	}

}
