package it.polimi.ingsw.pc15.model;

import java.util.HashMap;
import java.util.Map.Entry;

import it.polimi.ingsw.pc15.ParserXML;
import it.polimi.ingsw.pc15.plancia.TesseraScomunica;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.PuntiFede;
import it.polimi.ingsw.pc15.risorse.PuntiVittoria;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

/**
 * 
 * Classe che gestisce la fase di rapporto con il vaticano.
 *
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 */

public class RapportoInVaticano {
	
	private HashMap<Player, Boolean> giocatoriScomunicati;
	private TesseraScomunica scomunica;
	private String risultato;
	
	public RapportoInVaticano (TesseraScomunica scomunica) {
		this.giocatoriScomunicati = new HashMap<Player, Boolean>();
		this.scomunica = scomunica;
		this.risultato = new String("");
	}
	
	
	/**
	 * Metodo che registra la scelta del player di ricevere o meno la scomunica.
	 * 
	 * @param player a cui chiedere se accettare o meno la scomunica.
	 * @param scelta del player.
	 */
	
	public void registraSceltaGiocatore(Player player, int scelta) {
		if (scelta==1) 
			giocatoriScomunicati.put(player, false);
		else giocatoriScomunicati.put(player, true);
	}
	
	
	/**
	 * 
	 * Metodo che infligge o meno la scomunica al player 
	 * dipendentemente dalla scelta fatta a fine periodo.
	 * 
	 */
	
	public void avvia() {
		for (Entry<Player, Boolean> giocatore : this.giocatoriScomunicati.entrySet()) {
			if (giocatore.getValue()==true) {
				this.scomunica.infliggiScomunica(giocatore.getKey());
				this.risultato += "\n  - " + giocatore.getKey().getNome() + " è stato scomunicato!";
			}
			else {
				giocatore.getKey().getSetRisorse().aggiungi(new PuntiVittoria(ParserXML.leggiValore("puntiVittoria" + giocatore.getKey().getSetRisorse().getRisorsa(TipoRisorsa.PUNTIFEDE).getQuantità() + "PuntiFede")));
				this.risultato += "\n  - " + giocatore.getKey().getNome() + " paga " + giocatore.getKey().getSetRisorse().getRisorsa(TipoRisorsa.PUNTIFEDE).getQuantità() + " Punti Fede e guadagna " + ParserXML.leggiValore("puntiVittoria" + giocatore.getKey().getSetRisorse().getRisorsa(TipoRisorsa.PUNTIFEDE).getQuantità() + "PuntiFede") + " Punti Vittoria!" ;
				giocatore.getKey().getSetRisorse().aggiungi(new PuntiFede(- giocatore.getKey().getSetRisorse().getRisorsa(TipoRisorsa.PUNTIFEDE).getQuantità()));
			}
		}
	}
	
	/**
	 * @return i risultati dell'azione di assegnamento scomuniche.
	 */
	
	public String getRisultato() {
		return this.risultato;
	}
	
	

}
