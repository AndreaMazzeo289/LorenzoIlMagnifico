package it.polimi.ingsw.pc15.carte;

import java.util.Set;

import it.polimi.ingsw.pc15.azioni.AzionePrendiCarta;
import it.polimi.ingsw.pc15.azioni.AzionePrendiCartaImpresa;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

/**
 * Sottoclasse di carta che definisce impresa.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class Impresa extends Carta {
	
	private int requisitoPuntiMilitari;
	private int costoPuntiMilitari;
	
	public Impresa (String nome, int id, int periodo, SetRisorse costo, Set<Effetto> effettoIstantaneo, Set<Effetto> effettoPermanente, int requisitoPuntiMilitari, int costoPuntiMilitari, String imgPath) {
		super(nome, id, periodo, costo, effettoIstantaneo, effettoPermanente, imgPath);
		this.requisitoPuntiMilitari = requisitoPuntiMilitari;
		this.costoPuntiMilitari = costoPuntiMilitari;
		this.tipo = TipoCarta.IMPRESA;
	}
	
	/**
	 * @return restituisce il requisito in punti militari della carta edificio.
	 */
	
	public int getRequisitoPuntiMilitari() {
		return this.requisitoPuntiMilitari;
	}
	
	
	/**
	 * @return restituisce il costo in punti militari della carta edificio.
	 */
	
	
	public int getCostoPuntiMilitari() {
		return this.costoPuntiMilitari;
	}
	
	@Override
	public String toString() {
		String stringa = nome + " (COSTO: " + costo.toString() + "  - REQUISITO PUNTI MILITARI: ";
		if (requisitoPuntiMilitari==0)
			stringa += " nessuno";
		else stringa += requisitoPuntiMilitari;
		stringa += " - COSTO PUNTI MILITARI: ";
		if (costoPuntiMilitari==0)
			stringa += " nessuno";
		else stringa += costoPuntiMilitari;
		stringa +=  " - EFFETTO ISTANTANEO: ";
		if (getEffettoIstantaneo().isEmpty())
			stringa += "nessuno  -";
		else for (Effetto effetto : getEffettoIstantaneo())
			stringa += effetto.toString() + " - ";
		stringa += " - EFFETTO PERMANENTE: ";
		if (getEffettoPermanente().isEmpty())
			stringa += "nessuno";
		else for (Effetto effetto : getEffettoPermanente())
			stringa += effetto.toString() + " - ";
		stringa += " )";
		return stringa;
	}
}
