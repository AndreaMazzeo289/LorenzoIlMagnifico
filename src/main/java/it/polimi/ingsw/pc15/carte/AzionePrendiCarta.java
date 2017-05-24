package it.polimi.ingsw.pc15.carte;

import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public abstract class AzionePrendiCarta {
	
	protected final Player player;
	protected final Carta carta;
	
	public AzionePrendiCarta (Player player, Carta carta) {
		this.player = player;
		this.carta = carta;
	}
	
	public boolean risorseSufficienti (SetRisorse costo) {
		
	int oroAggiuntivo = 0;								 //
		
		System.out.println(carta.getSpazio());
		System.out.println(carta.getSpazio().getTorre());
			//    se la torre è già occupata, il costo in oro della carta
		if (carta.getSpazio().getTorre().occupata() ) {  //    aumenta di 3;
			oroAggiuntivo = 3;							 // 
		}
		
	return (player.getSetRisorse().paragona(costo) &&                                                    // paragona sia il costo totale che
			player.getSetRisorse().getRisorsa(TipoRisorsa.ORO).paragona(costo.getRisorsa(TipoRisorsa.ORO).getQuantità() + oroAggiuntivo));     // il costo in oro + (eventualmente) 3
	}    

	public void paga(SetRisorse costo) {
		player.getSetRisorse().sottrai(costo);
	}
	
	public abstract boolean attiva();
	public abstract void daiCarta();
	public abstract boolean requisitiSoddisfatti();
	
}
