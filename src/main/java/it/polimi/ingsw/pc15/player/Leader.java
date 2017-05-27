package it.polimi.ingsw.pc15.player;

import java.util.HashMap;
import java.util.Set;

import it.polimi.ingsw.pc15.carte.ColoreCarta;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

public class Leader {
	
	private final String nome;
	private Player player;
	private final Set<Effetto> effettoPerTurno;
	private final Set<Effetto> effettoPermanente;
	
	private SetRisorse requisitoRisorse;
	private HashMap<ColoreCarta, Integer> requisitoCarte;
	
	private boolean giocato;
	private boolean effettoAttivato;
	
	public Leader (String nome, Set<Effetto> effettoPerTurno, Set<Effetto> effettoPermanente, SetRisorse requisitoRisorse, HashMap<ColoreCarta, Integer> requisitoCarte) {
		this.nome = nome;
		this.player = null;
		this.effettoPerTurno = effettoPerTurno;
		this.effettoPermanente = effettoPermanente;
		
		this.requisitoRisorse = requisitoRisorse;
		this.requisitoCarte = requisitoCarte;
		
		this.giocato = false;
		this.effettoAttivato = false;
		
	}
	
	public boolean requisitiSoddisfatti() {
		
		if (player.getSetRisorse().paragona(requisitoRisorse) == false) {
			System.out.println("Non hai risorse sufficienti per giocare questa carta Leader!");
			return false;
		}
		
		return true;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void setEffettoAttivato (boolean valore) {
		this.effettoAttivato = valore;
	}
	
	public Set<Effetto> getEffettoPerTurno() {
		return this.effettoPerTurno;
	}
	
	public boolean effettoGiàAttivato() {
		return this.effettoAttivato;
	}
	
}
