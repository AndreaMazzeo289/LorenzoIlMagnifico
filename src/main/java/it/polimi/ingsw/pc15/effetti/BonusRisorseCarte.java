package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;
/**
 * descr
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */
public class BonusRisorseCarte extends Bonus {
	
	private TipoRisorsa risorsa;

	public BonusRisorseCarte(int valore, TipoRisorsa risorsa) {
		super(valore);
		this.risorsa = risorsa;
	}

	/**
	 * Metodo che permette di aggiungere tramite effetti delle carte
	 * una quantità di risorse maggiore rispetto a quella stabilita.
	 * 
	 * @param player su cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player) {
		
	}
	
	public String toString() {
		return ("Quando ottieni " + risorsa.name() + " per effetto di una carta sviluppo, ne ricevi " + valore);
	}

}
