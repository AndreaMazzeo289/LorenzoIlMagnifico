package it.polimi.ingsw.pc15.azioni;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

import it.polimi.ingsw.pc15.ParserXML;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.carte.Impresa;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.Oro;
import it.polimi.ingsw.pc15.risorse.PuntiMilitari;
import it.polimi.ingsw.pc15.risorse.Risorsa;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

/** 
 * Sotto classe di azione prendi carta che permette di 
 * prendere una carta impresa se rispettate le condizioni di acquisto.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class AzionePrendiCartaImpresa extends AzionePrendiCarta {
	
		int scelta;
		SetRisorse costoPuntiMilitari;
		
	public AzionePrendiCartaImpresa(Player player, Carta carta, int scelta) {
		super(player, carta);
		this.scelta = scelta;
		this.costoPuntiMilitari = new SetRisorse(new HashSet<Risorsa>());
		this.costoPuntiMilitari.aggiungi(new PuntiMilitari(((Impresa) carta).getCostoPuntiMilitari()));
	}

	
	/**
	 * Verifica la validità dell' azione prendi carta impresa.
	 * 
	 * @return il risultato dell'azione.
	 */
	
	
	@Override
	public RisultatoAzione èValida() {
		
		if (scelta == 1 && risorseSufficienti()==false)
			return new RisultatoAzione(false, player.getNome() + " cerca di prendere " + carta.getNome() + " ma non ha abbastanza risorse!");
		
		if (scelta == 2  && puntiMilitariSufficienti()==false)
			return new RisultatoAzione(false, player.getNome() + " cerca di prendere " + carta.getNome() + " ma non ha abbastanza punti Militari!");

		if (player.getCarte(TipoCarta.EDIFICIO).size() == ParserXML.leggiValore("numeroMaxCarte")) {  
			return new RisultatoAzione(false, player.getNome() + " cerca di prendere " + carta.getNome() + " ma ha raggiunto il limite di carte IMPRESA!");
		}
		
		return new RisultatoAzione(true, player.getNome() + " prende la carta Impresa " + carta.getNome()+"!");
	}

	
	/**
	 * 
	 * Metodo che attiva l'azione prendi carta impresa chiamando la funzione paga costo
	 * scelto uno tra i due tipi di pagamento effettuabili.
	 * 
	 */
	
	
	@Override
	public void attiva() {
		
		if (scelta == 1)
			pagaCosto(costoFinale);
		else if (scelta == 2)
			pagaCosto(costoPuntiMilitari);
		
		daiCarta();
		attivaEffettoIstantaneo();
		
	}
	
	/**
	 * Verifica se il player abbia una quantità sufficiente di punti militari 
	 * per acquistare la carta.
	 * 
	 * @return true o false in base alla disponibilità in punti militari del player.
	 */
	
	public boolean puntiMilitariSufficienti() {
		
		if ( ((Impresa)carta).getRequisitoPuntiMilitari() > player.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIMILITARI).getQuantità() ) 
			return false;
		
		if (carta.getSpazio().getTorre().occupata() && player.getEffettiAttivi().sovrapprezzoTorri())
			costoFinale.aggiungi(new Oro(3));
		
		costoPuntiMilitari.sottrai(player.getEffettiAttivi().getScontoCostoCarte(carta.getTipo()));
		costoPuntiMilitari.sottrai(player.getEffettiAttivi().getScontoCostoCarte(TipoCarta.ALL));
			
		return player.getSetRisorse().paragona(costoFinale);
	}
	
}


