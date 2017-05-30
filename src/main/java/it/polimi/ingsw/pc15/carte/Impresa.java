package it.polimi.ingsw.pc15.carte;

import java.util.Set;

import azioni.AzionePrendiCarta;
import azioni.AzionePrendiCartaImpresa;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

public class Impresa extends Carta {
	
	private Effetto aumentoPuntiVittoria;
	private int requisitoPuntiMilitari;
	private int costoPuntiMilitari;
	
	public Impresa (String nome, int id, int periodo, SetRisorse costo, Set<Effetto> effettoIstantaneo, Effetto aumentoPuntiVittoria, int requisitoPuntiMilitari, int costoPuntiMilitari) {
		super(nome, id, periodo, costo, effettoIstantaneo);
		this.aumentoPuntiVittoria = aumentoPuntiVittoria;
		this.requisitoPuntiMilitari = requisitoPuntiMilitari;
		this.costoPuntiMilitari = costoPuntiMilitari;
		this.colore = ColoreCarta.VIOLA;
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

	@Override
	public ColoreCarta getColore() {
		return ColoreCarta.VIOLA;
	}
	
	

}
