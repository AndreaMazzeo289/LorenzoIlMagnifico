package it.polimi.ingsw.pc15.carte;

import java.util.Set;

import it.polimi.ingsw.pc15.azioni.AzionePrendiCarta;
import it.polimi.ingsw.pc15.azioni.AzionePrendiCartaImpresa;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

public class Impresa extends Carta {
	
	private int requisitoPuntiMilitari;
	private int costoPuntiMilitari;
	
	public Impresa (String nome, int id, int periodo, SetRisorse costo, Set<Effetto> effettoIstantaneo, Set<Effetto> effettoPermanente, int requisitoPuntiMilitari, int costoPuntiMilitari, String imgPath) {
		super(nome, id, periodo, costo, effettoIstantaneo, effettoPermanente, imgPath);
		this.requisitoPuntiMilitari = requisitoPuntiMilitari;
		this.costoPuntiMilitari = costoPuntiMilitari;
		this.tipo = TipoCarta.IMPRESA;
	}

	@Override
	public AzionePrendiCarta azionePrendiCarta(Player player) {
		
		AzionePrendiCarta azionePrendiCarta = new AzionePrendiCartaImpresa(player, this);
		return azionePrendiCarta;
	}
	
	public int getRequisitoPuntiMilitari() {
		return this.requisitoPuntiMilitari;
	}
	
	public int getCostoPuntiMilitari() {
		return this.costoPuntiMilitari;
	}
}
