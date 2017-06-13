package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.effetti.Incrementabile;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public abstract class AzionePrendiCarta extends Azione{
	
	protected final Carta carta;
	
	public AzionePrendiCarta (Player player, Carta carta) {
		super(player);
		this.carta = carta;
	}
	
	public abstract void attiva();
	public abstract RisultatoAzione èValida();

	public boolean risorseSufficienti () {
		
	int oroAggiuntivo = 0;
			                                          
	if (carta.getSpazio().getTorre().occupata() )    
		oroAggiuntivo = 3;		
	
	if (player.getEffettiAttivi().getScontoCostoCarte(carta.getTipo())!=null)	
		carta.getCosto().sottrai(player.getEffettiAttivi().getScontoCostoCarte(carta.getTipo()));
		
	if (!(player.getSetRisorse().paragona(carta.getCosto()) &&                                                   
			player.getSetRisorse().getRisorsa(TipoRisorsa.ORO).paragona(carta.getCosto().getRisorsa(TipoRisorsa.ORO).getQuantità() + oroAggiuntivo))) {
		if (player.getEffettiAttivi().getScontoCostoCarte(carta.getTipo())!=null)	
			carta.getCosto().aggiungi(player.getEffettiAttivi().getScontoCostoCarte(carta.getTipo()));
		return false;
	}
	
	return true;
		
	}    

	public void pagaCosto() {
		if (carta.getSpazio().getTorre().occupata() ) 
			carta.getCosto().getRisorsa(TipoRisorsa.ORO).aggiungi(3);
		player.getSetRisorse().sottrai(carta.getCosto());
	}
	
	public void daiCarta() {
		
		carta.getSpazio().rimuoviCarta();
		carta.setSpazio(null);
		carta.setPlayer(player);
		
		player.getCarte(carta.getTipo()).add(carta);
		
	}
	
	public void attivaEffettoIstantaneo() {
		for (Effetto effetto : carta.getEffettoIstantaneo()) {
			if (Incrementabile.class.isInstance(effetto))
				((Incrementabile) effetto).attivaDaCarta(player);
		}
	}
	
}
