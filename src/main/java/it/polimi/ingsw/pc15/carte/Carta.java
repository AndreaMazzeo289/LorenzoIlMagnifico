package it.polimi.ingsw.pc15.carte;

import java.util.Iterator;
import java.util.Observable;
import java.util.Set;

import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.plancia.SpazioTorre;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

public abstract class Carta {
	
	private final String nome;
	private final int id;
	private final int periodo;
	private final SetRisorse costo;
	private final Set<Effetto> effettoIstantaneo;
	private Player player;
	private SpazioTorre spazio;
	protected ColoreCarta colore;
	
	public Carta (String nome, int id, int periodo, SetRisorse costo, Set<Effetto> effettoIstantaneo) {
		this.nome = nome;
		this.id = id;
		this.periodo = periodo;
		this.costo = costo;
		this.effettoIstantaneo = effettoIstantaneo;
		this.player = null;
		this.spazio = null;
	}
	
	public SetRisorse getCosto() {
		return this.costo;
	}
	
	public SpazioTorre getSpazio() {
		return this.spazio;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getPeriodo() {
		return this.periodo;
	}
	
	public void setSpazio(SpazioTorre spazio) {
		this.spazio = spazio;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public ColoreCarta getColore() {
		return ColoreCarta.ALL;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}      
	
	public void attivaEffettoIstantaneo() {
		
		Iterator<Effetto> effetto = effettoIstantaneo.iterator();
		while(effetto.hasNext()) 
			effetto.next().attiva(player);
	}
	
	public abstract AzionePrendiCarta azionePrendiCarta (Player player);

}