package it.polimi.ingsw.pc15.plancia;

import java.util.Set;

import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.Player;

public class TesseraScomunica {
	
	private final int periodo;
	private final Set<Effetto> scomunica;
		
	public TesseraScomunica (int periodo, Set<Effetto> scomunica) {
		this.periodo = periodo;
		this.scomunica = scomunica;
	}
	
	public void infliggiScomunica(Player player) {
		for (Effetto scomunica : this.scomunica)
			scomunica.attiva(player);
	}

}
