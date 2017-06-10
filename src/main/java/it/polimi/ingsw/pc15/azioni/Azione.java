package it.polimi.ingsw.pc15.azioni;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;

public abstract class Azione implements Serializable {
	
	protected Player player;
	
	public Azione (Player player) {
		
		this.player = player;
	}
	
	public abstract void attiva();
	public abstract RisultatoAzione èValida();

}
