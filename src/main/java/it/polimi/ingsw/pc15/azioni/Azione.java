package it.polimi.ingsw.pc15.azioni;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;

/** 
 * Superclasse che permette di definire tutte le azioni del gioco.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public abstract class Azione implements Serializable {
	
	protected Player player;
	
	public Azione (Player player) {
		
		this.player = player;
	}
	
	public abstract void attiva();
	public abstract RisultatoAzione èValida();

}
