package it.polimi.ingsw.pc15;

public abstract class AzionePrendiCarta {
	
	protected final Player player;
	protected final Carta carta;
	
	public AzionePrendiCarta (Player player, Carta carta) {
		this.player = player;
		this.carta = carta;
	}
	
	public boolean risorseSufficienti (SetRisorse costo) {
		
	int oroAggiuntivo = 0;								 //
														 //    se la torre è già occupata, il costo in oro della carta
		if (carta.getSpazio().getTorre().occupata() ) {   //    aumenta di 3;
			oroAggiuntivo = 3;							 // 
		}
		
	return (player.getSetRisorse().paragona(costo) &&                                                    // paragona sia il costo totale che
			player.getSetRisorse().getOro().paragona(costo.getOro().getQuantità() + oroAggiuntivo));     // il costo in oro + (eventualmente) 3
	
	}    
	
	public abstract void daiCarta();
	
	public abstract boolean controllaRequisiti();
	
	/*public Player getPlayer() {
		return this.player;
	}
	
	public Carta getCarta() {
		return this.carta;
	}*/
	
}
