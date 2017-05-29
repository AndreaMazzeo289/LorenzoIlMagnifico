package it.polimi.ingsw.pc15.player;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import it.polimi.ingsw.pc15.carte.ColoreCarta;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.risorse.Risorsa;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

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
		
		if (this.requisitoRisorse != null)
			if (player.getSetRisorse().paragona(requisitoRisorse) == false) {
				System.out.println("Non soddisfi il requisito di risorse richiesto per giocare questo Leader!");
				return false;
		}
		
		if (this.requisitoCarte != null)
			for(Map.Entry<ColoreCarta, Integer> requisito : requisitoCarte.entrySet())
				if (player.getCarte(requisito.getKey()).size() < requisito.getValue()) {
					System.out.println("Non soddisfi il requisito di Carte Sviluppo richiesto per giocare questo Leader!");
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
	
	public void setGiocato (boolean valore) {
		this.giocato = valore;
	}
	
	//-----------------------------------------------------------------------------------------------------------//
	//          METODI GET                                                                                       //
	//-----------------------------------------------------------------------------------------------------------//
	
	public String getNome() {
		return this.nome;
	}
	
	public HashMap<ColoreCarta, Integer> getRequisitoCarte() {
		return this.requisitoCarte;
	}
	
	public SetRisorse getRequisitoRisorse() {
		return this.requisitoRisorse;
	}
	
	public boolean effettoGiàAttivato() {
		return this.effettoAttivato;
	}
	
	public boolean giocato() {
		return this.giocato;
	}
	
	public Set<Effetto> getEffettoPerTurno() {
		return this.effettoPerTurno;
	}
	
	public Set<Effetto> getEffettoPermanente() {
		return this.effettoPermanente;
	}
	
}
