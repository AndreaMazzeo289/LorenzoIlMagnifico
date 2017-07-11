package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;

import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.carte.Impresa;
import it.polimi.ingsw.pc15.carte.Personaggio;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.Risorsa;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;
/**
 * Sottoclasse di effetto che permette la moltiplicazione delle risorse
 * in base ad un bonus degli effetti attivi del player.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */
public abstract class Moltiplicazione extends Effetto implements Incrementabile {

	protected SetRisorse setRisorse;
	protected int quantità;
	
	public Moltiplicazione(SetRisorse setRisorse, int quantità) {
		this.setRisorse = setRisorse;
		this.quantità = quantità;
	}
	
	
	/**
	 * Metodo che definisce l'attivazione dell'effetto moltiplicazione da spazio.
	 * Aggiunge le risorse al player in base ad un suo moltiplicatore.
	 * 
	 * @param player a cui aggiungere le risorse in base a moltiplicatore.
	 */
	
	@Override
	public void attivaDaSpazio(Player player) {
		
		for (Risorsa risorsa : this.setRisorse.getRisorse().values()) {
			risorsa.aggiungi(risorsa.getQuantità()*player.getEffettiAttivi().getMoltiplicatoreRisorseSpazi()-1);
			risorsa.aggiungi(player.getEffettiAttivi().getRisorsaBonusSpazi(risorsa.getTipoRisorsa()));
		}
		
		attiva(player);
		
		for (Risorsa risorsa : this.setRisorse.getRisorse().values()) {
			risorsa.aggiungi(-player.getEffettiAttivi().getRisorsaBonusSpazi(risorsa.getTipoRisorsa()));
			if(player.getEffettiAttivi().getMoltiplicatoreRisorseSpazi()!=1)
				risorsa.aggiungi(-risorsa.getQuantità()/(player.getEffettiAttivi().getMoltiplicatoreRisorseSpazi()*(player.getEffettiAttivi().getMoltiplicatoreRisorseSpazi()-1)));
		
		}

	}

	/**
	 * Metodo che definisce l'attivazione dell'effetto moltiplicazione da carta.
	 * Aggiunge le risorse al player in base ad un suo moltiplicatore.
	 * 
	 * @param player a cui aggiungere le risorse in base a moltiplicatore.
	 */
	
	@Override
	public void attivaDaCarta(Player player) {
		
		for (Risorsa risorsa : this.setRisorse.getRisorse().values()) {
			risorsa.aggiungi(risorsa.getQuantità()*player.getEffettiAttivi().getMoltiplicatoreRisorseCarte()-1);
			risorsa.aggiungi(player.getEffettiAttivi().getRisorsaBonusCarte(risorsa.getTipoRisorsa()));
		}
		
		attiva(player);
		
		for (Risorsa risorsa : this.setRisorse.getRisorse().values()) {
			risorsa.aggiungi(-player.getEffettiAttivi().getRisorsaBonusCarte(risorsa.getTipoRisorsa()));
			if(player.getEffettiAttivi().getMoltiplicatoreRisorseCarte()!=1)
				risorsa.aggiungi(-risorsa.getQuantità()/(player.getEffettiAttivi().getMoltiplicatoreRisorseCarte()*(player.getEffettiAttivi().getMoltiplicatoreRisorseCarte()-1)));
		
		}
		
	}
	
	

}
