package it.polimi.ingsw.pc15;

import java.util.Observable;
import java.util.Set;

public abstract class Carta {
	
	private final String nome;
	private final int id;
	private final int periodo;
	private final SetRisorse costo;
	private final Set<Effetto> effettoIstantaneo;
	private Player player;
	private SpazioTorre spazio;
	
	public Carta (String nome, int id, int periodo, SetRisorse costo, Set<Effetto> effettoIstantaneo, SpazioTorre spazio) {
		this.nome = nome;
		this.id = id;
		this.periodo = periodo;
		this.costo = costo;
		this.effettoIstantaneo = effettoIstantaneo;
		this.player = null;
		this.spazio = spazio;
	}
	
	public SetRisorse getCosto() {
		return this.costo;
	}
	
	public SpazioTorre getSpazio() {
		return this.spazio;
	}
	
	public void setSpazio(SpazioTorre spazio) {
		this.spazio = spazio;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public abstract void daiA (Player player);
	
	public abstract boolean prendibile (Player player);
	
	public boolean risorseSufficienti (Player player) {
		
	int oroAggiuntivo = 0;								 //
														 //    se la torre è già occupata, il costo in oro della carta
		if (this.getSpazio().getTorre().occupata() ) {   //    aumenta di 3;
			oroAggiuntivo = 3;							 // 
		}
		
	return (player.getSetRisorse().paragona(costo) &&                                                    // paragona sia il costo totale che
			player.getSetRisorse().getOro().paragona(costo.getOro().getQuantità() + oroAggiuntivo));     // il costo in oro + (eventualmente) 3
	
	}                                                                                         

}
