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
	
	
	/**
	 * 
	 * Pagando il prezzo della carta il metodo permette al player 
	 * di prenderla ed usufruire immediatamente degli effetti istantanei.
	 * 
	 */
	
	public void attiva() {	
		
		pagaCosto(costoFinale);
		daiCarta();
		attivaEffettoIstantaneo();
	}

	/**
	 * Verifica considerando anche tutti i bonus degli effetti attivi del player
	 * se questo possiede abbastanza risorse per prendere la carta.
	 * 
	 * @return true o false in base alla posibilità del player di prendere la carta.
	 */
	
	public boolean risorseSufficienti () {
			                                          

		if (carta.getSpazio().getTorre().occupata() && player.getEffettiAttivi().sovrapprezzoTorri())
			costoFinale.aggiungi(new Oro(3));
		
		costoFinale.sottrai(player.getEffettiAttivi().getScontoCostoCarte(carta.getTipo()));
		costoFinale.sottrai(player.getEffettiAttivi().getScontoCostoCarte(TipoCarta.ALL));
			
		return player.getSetRisorse().paragona(costoFinale);
		
	}    

	/**
	 *Metodo che permette al player di pagare il prezzo della carta.
	 * 
	 * @param costo della carta.
	 */
	
	
	public void pagaCosto(SetRisorse costo) {
		player.getSetRisorse().sottrai(costo);
	}
	
	/**
	 * 
	 * Metodo che assegna la carta al player che la ha 
	 * acquistata
	 */
	
	
	public void daiCarta() {
		
		carta.getSpazio().rimuoviCarta();
		carta.setSpazio(null);
		carta.setPlayer(player);
		
		player.getCarte(carta.getTipo()).add(carta);
		
	}
	
	/**
	 * 
	 * Metodo che attiva a favore del player che la ha acquistata 
	 * l'effetto istantaneo della carta.
	 * 
	 */
	
	
	public void attivaEffettoIstantaneo() {
		for (Effetto effetto : carta.getEffettoIstantaneo()) {
			if (Incrementabile.class.isInstance(effetto))
				((Incrementabile) effetto).attivaDaCarta(player);
		}
	}
	
	

	
}
