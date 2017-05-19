package it.polimi.ingsw.pc15;

import java.util.Set;

public class Impresa extends Carta {
	
	private Effetto aumentoPuntiVittoria;
	private int requisitoPuntiMilitari;
	private int costoPuntiMilitari;
	
	public Impresa (String nome, int id, int periodo, SetRisorse costo, Set<Effetto> effettoIstantaneo, Effetto aumentoPuntiVittoria, int requisitoPuntiMilitari,
					int costoPuntiMilitari) {
		super(nome, id, periodo, costo, effettoIstantaneo);
		this.aumentoPuntiVittoria = aumentoPuntiVittoria;
		this.requisitoPuntiMilitari = requisitoPuntiMilitari;
		this.costoPuntiMilitari = costoPuntiMilitari;
		}

	@Override
	public AzionePrendiCarta azionePrendiCarta(Player player) {
		
		AzionePrendiCarta azionePrendiCarta = new AzionePrendiCartaImpresa(player, this);
		return azionePrendiCarta;
	}

}
