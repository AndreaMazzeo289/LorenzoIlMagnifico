package it.polimi.ingsw.pc15.azioni;

import java.util.HashSet;

import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.effetti.Incrementabile;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.Oro;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public abstract class AzionePrendiCarta extends Azione{
	
	protected final Carta carta;
	protected SetRisorse costoFinale;
	
	public AzionePrendiCarta (Player player, Carta carta) {
		super(player);
		this.carta = carta;
		this.costoFinale = carta.getCosto();
	}
	
	public abstract RisultatoAzione èValida();
	
	public void attiva() {	
		
		pagaCosto(costoFinale);
		daiCarta();
		attivaEffettoIstantaneo();
	}

	public boolean risorseSufficienti () {
			                                          
		if (carta.getSpazio().getTorre().occupata() && player.getEffettiAttivi().sovrapprezzoTorri())
			costoFinale.aggiungi(new Oro(3));
		
		costoFinale.sottrai(player.getEffettiAttivi().getScontoCostoCarte(carta.getTipo()));
		costoFinale.sottrai(player.getEffettiAttivi().getScontoCostoCarte(TipoCarta.ALL));
			
		return player.getSetRisorse().paragona(costoFinale);
		
	}    

	public void pagaCosto(SetRisorse costo) {
		player.getSetRisorse().sottrai(costo);
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
