package it.polimi.ingsw.pc15.player;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.risorse.Risorsa;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class Leader implements Serializable{
	
	public String nome;
	private Player player;
	private final Set<Effetto> effettoPerTurno;
	private final Set<Effetto> effettoPermanente;
	
	private SetRisorse requisitoRisorse;
	private HashMap<TipoCarta, Integer> requisitoCarte;
	
	private boolean giocato;
	private boolean effettoAttivato;
	
	public Leader (String nome, Set<Effetto> effettoPerTurno, Set<Effetto> effettoPermanente, SetRisorse requisitoRisorse, HashMap<TipoCarta, Integer> requisitoCarte) {
		
		this.nome = nome;
		this.player = null;
		this.effettoPerTurno = effettoPerTurno;
		this.effettoPermanente = effettoPermanente;
		
		this.requisitoRisorse = requisitoRisorse;
		this.requisitoCarte = requisitoCarte;
		
		this.giocato = false;
		this.effettoAttivato = false;
		
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void setEffettoAttivato (boolean valore) {
		this.effettoAttivato = valore;
	}
	
	public void setGiocato() {
		this.giocato = true;
	}
	
	//-----------------------------------------------------------------------------------------------------------//
	//          METODI GET                                                                                       //
	//-----------------------------------------------------------------------------------------------------------//
	
	public String getNome() {
		return this.nome;
	}
	
	public HashMap<TipoCarta, Integer> getRequisitoCarte() {
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
	
	public String toString() {
		
		String stringa = nome + " ( REQUISITO RISORSE: ";
		
		if (requisitoRisorse!=null)
			stringa += requisitoRisorse.toString();
		else stringa += "nessuno";
		
		stringa += "  - REQUISITO CARTE: [ ";
		
		if (requisitoCarte!=null)
			for(Map.Entry<TipoCarta, Integer> requisitoCarta : requisitoCarte.entrySet())
				stringa += " " + requisitoCarta.getKey().name() + ": " + requisitoCarta.getValue();
		else stringa += "nessuno";
		
		stringa += " ]  - EFFETTO PER TURNO: ";
		
		try {
			for (Effetto effetto : effettoPerTurno)
			stringa += effetto.toString() + " - ";
		} catch (NullPointerException e) {
				stringa += "nessuno  -";
		}
		
		stringa += " EFFETTO PERMANENTE: ";
		try {
			for (Effetto effetto : effettoPermanente)
				stringa += effetto.toString() + " - ";
		} catch (NullPointerException e) {
			stringa += "nessuno  -";
		}


		stringa += " )";
		return stringa;
	}
	
}
