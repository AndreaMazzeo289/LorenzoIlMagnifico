package azioni;

import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public abstract class AzionePrendiCarta extends Azione{
	
	protected final Carta carta;
	
	public AzionePrendiCarta (Player player, Carta carta) {
		super(player);
		this.carta = carta;
	}

	public boolean risorseSufficienti () {
		
	int oroAggiuntivo = 0;
			                                             //    se la torre è già occupata, il costo in oro della carta
		if (carta.getSpazio().getTorre().occupata() ) {  //    aumenta di 3;
			oroAggiuntivo = 3;							 // 
		}
		
	if (!(player.getSetRisorse().paragona(carta.getCosto()) &&                                                   
			player.getSetRisorse().getRisorsa(TipoRisorsa.ORO).paragona(carta.getCosto().getRisorsa(TipoRisorsa.ORO).getQuantità() + oroAggiuntivo))) {
		System.out.println("Non hai risorse sufficienti per acquistare questa carta!");
		return false;
	}
	
	return true;
		
	}    

	public void pagaCosto() {
		if (carta.getSpazio().getTorre().occupata() ) 
			carta.getCosto().getRisorsa(TipoRisorsa.ORO).aggiungi(3);
		player.getSetRisorse().sottrai(carta.getCosto());
	}
	
	public abstract void attiva();
	
	public void daiCarta() {
		
		carta.getSpazio().rimuoviCarta();
		carta.setSpazio(null);
		carta.setPlayer(player);
		player.getCarte(carta.getColore()).add(carta);
		
	}
	

	
}
