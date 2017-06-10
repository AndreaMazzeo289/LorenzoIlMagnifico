package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;

public abstract class Effetto implements Serializable {

	public abstract void attiva(Player player);
}
