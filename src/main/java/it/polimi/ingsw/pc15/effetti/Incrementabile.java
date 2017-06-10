package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;

public interface Incrementabile extends Serializable {
	
	public void attivaDaSpazio (Player player);
	
	public void attivaDaCarta (Player player);

}
