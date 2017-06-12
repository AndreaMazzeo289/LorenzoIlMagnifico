package it.polimi.ingsw.pc15.carte;

import java.io.Serializable;
import java.util.Set;

import it.polimi.ingsw.pc15.azioni.AzionePrendiCarta;
import it.polimi.ingsw.pc15.azioni.AzionePrendiCartaEdificio;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

public class Edificio extends Carta {
	
	private int requisitoProduzione;
	
	public Edificio (String nome, int id, int periodo, SetRisorse costo, Set<Effetto> effettoPermanente, Set<Effetto> effettoIstantaneo, int requisitoProduzione) {
		super(nome, id, periodo, costo, effettoIstantaneo, effettoPermanente);
		this.requisitoProduzione = requisitoProduzione;
		this.tipo = TipoCarta.EDIFICIO;
	}

	public int getRequisitoProduzione() {
		return this.requisitoProduzione;
	}

	@Override
	public AzionePrendiCarta azionePrendiCarta(Player player) {
		
		AzionePrendiCarta azionePrendiCarta = new AzionePrendiCartaEdificio(player, this);
		return azionePrendiCarta;
	}

}
