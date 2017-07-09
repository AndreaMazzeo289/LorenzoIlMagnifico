package it.polimi.ingsw.pc15.carte;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Observable;
import java.util.Set;

import it.polimi.ingsw.pc15.azioni.AzionePrendiCarta;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.plancia.SpazioTorre;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

public abstract class Carta implements Serializable {
	
	protected final String nome;
	protected final int id;
	protected final int periodo;
	protected final SetRisorse costo;
	protected final Set<Effetto> effettoIstantaneo;
	protected final Set<Effetto> effettoPermanente;
	protected final String imgPath;
	protected Player player;
	protected SpazioTorre spazio;
	protected TipoCarta tipo;
	
	public Carta (String nome, int id, int periodo, SetRisorse costo, Set<Effetto> effettoIstantaneo, Set<Effetto> effettoPermanente, String imgPath) {
		this.nome = nome;
		this.id = id;
		this.periodo = periodo;
		this.costo = costo;
		this.effettoIstantaneo = effettoIstantaneo;
		this.effettoPermanente = effettoPermanente;
		this.player = null;
		this.spazio = null;
		this.imgPath = imgPath;
	}
		
	public void setSpazio(SpazioTorre spazio) {
		this.spazio = spazio;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}      
	
	
	
	//-----------------------------------------------------------------------------------------------------------//
	//          METODI GET                                                                                       //
	//-----------------------------------------------------------------------------------------------------------//
	
	public TipoCarta getTipo() {
		return this.tipo;
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
	
	public Player getPlayer() {
		return this.player;
	}
	
	public String getImagePath() {
		return this.imgPath;
	}
	
	public Set<Effetto> getEffettoPermanente() {
		return this.effettoPermanente;
	}
	
	public Set<Effetto> getEffettoIstantaneo() {
		return this.effettoIstantaneo;
	}
	
	@Override
	public String toString() {
		String stringa = nome + " (COSTO: " + costo.toString() + " -  EFFETTO ISTANTANEO: ";
		if (effettoIstantaneo==null||effettoIstantaneo.isEmpty())
			stringa += "nessuno  -";
		else for (Effetto effetto : effettoIstantaneo)
			stringa += effetto.toString() + " - ";
		
		stringa += " EFFETTO PERMANENTE: ";
		if (effettoPermanente==null||effettoPermanente.isEmpty())
			stringa += "nessuno";
		else for (Effetto effetto : effettoPermanente)
			stringa += effetto.toString() + " - ";
		stringa += " )";
		return stringa;
	}
	
}
