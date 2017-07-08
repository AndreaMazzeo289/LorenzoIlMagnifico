package it.polimi.ingsw.pc15.model;

import java.util.HashMap;
import java.util.Map.Entry;

import it.polimi.ingsw.pc15.ParserXML;
import it.polimi.ingsw.pc15.plancia.TesseraScomunica;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.PuntiVittoria;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class RapportoInVaticano {
	
	private HashMap<Player, Boolean> giocatoriScomunicati;
	private TesseraScomunica scomunica;
	
	public RapportoInVaticano (TesseraScomunica scomunica) {
		this.giocatoriScomunicati = new HashMap<Player, Boolean>();
		this.scomunica = scomunica;
	}
	
	public void registraSceltaGiocatore(Player player, int scelta) {
		if (scelta==1) 
			giocatoriScomunicati.put(player, false);
		else giocatoriScomunicati.put(player, true);
	}
	
	public void avvia() {
		for (Entry<Player, Boolean> giocatore : this.giocatoriScomunicati.entrySet()) {
			if (giocatore.getValue()==true) {
				this.scomunica.infliggiScomunica(giocatore.getKey());
				System.out.println(giocatore.getKey().getNome() + " è stato scomunicato");
			}
			else {
				giocatore.getKey().getSetRisorse().aggiungi(new PuntiVittoria(ParserXML.leggiValore("puntiVittoria" + giocatore.getKey().getSetRisorse().getRisorsa(TipoRisorsa.PUNTIFEDE).getQuantità() + "PuntiFede")));
				System.out.println(giocatore.getKey().getNome() + " paga la chiesa");
			}
				
		}
	}
	
	

}
