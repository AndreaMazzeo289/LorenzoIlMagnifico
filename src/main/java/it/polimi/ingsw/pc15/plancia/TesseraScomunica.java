package it.polimi.ingsw.pc15.plancia;

import java.io.Serializable;
import java.util.Set;

import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.Player;

/**
 * Tessera scomunicache contiene periodo di attivazione e relativo
 * effetto da infliggere al player nel momento in cui non siano state 
 * soddisfatte alcune condizioni di gioco.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */


public class TesseraScomunica implements Serializable {
	
	private final int id;
	private final int periodo;
	private final Set<Effetto> scomunica;
	private final String pathImg;
		
	public TesseraScomunica (int id, int periodo, Set<Effetto> scomunica, String pathImg) {
		this.id = id;
		this.periodo = periodo;
		this.scomunica = scomunica;
		this.pathImg = pathImg;
	}
	
	/**
	 * Infligge al player gli effetti corrispondenti alla tessera scomunica.
	 * 
	 * @param player target della scomunica.
	 */
	
	public void infliggiScomunica(Player player) {
		for (Effetto scomunica : this.scomunica)
			scomunica.attiva(player);
	}
	
	/**
	 * @return il periodo corrispondente alla tessera.
	 */
	
	public int getPeriodo() {
		return this.periodo;
	}
	
	public String getPathImg() {
		return this.pathImg;
	}
	
	public int getID() {
		return this.id;
	}
	
	@Override
	public String toString() {
		String stringa = new String();
		for (Effetto effetto : this.scomunica)
			stringa += effetto.toString() + " - ";
		return stringa;
	}

}
