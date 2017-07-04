package it.polimi.ingsw.pc15.plancia;

import java.io.Serializable;
import java.util.Set;

import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.Player;

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
	
	public void infliggiScomunica(Player player) {
		for (Effetto scomunica : this.scomunica)
			scomunica.attiva(player);
	}
	
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
