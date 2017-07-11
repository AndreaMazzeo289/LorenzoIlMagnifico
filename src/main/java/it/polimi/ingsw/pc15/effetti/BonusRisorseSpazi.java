package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;
/**
 * Sottoclasse di effetto che permette di aggiungere tramite effetti degli spazi
 * una quantità di risorse maggiore rispetto a quella stabilita.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */
public class BonusRisorseSpazi extends Bonus {
	
	private TipoRisorsa risorsa;

	public BonusRisorseSpazi(int valore, TipoRisorsa risorsa) {
		super(valore);
		this.risorsa = risorsa;
	}

	/**
	 * Metodo che permette di aggiungere tramite effetti degli spazi
	 * una quantità di risorse maggiore rispetto a quella stabilita.
	 * 
	 * @param playersu cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player) {
		
	}

	public String toString() {
		return ("Quando ottieni " + risorsa.name() + " per effetto di uno spazio azione, ne ricevi " + valore);
	}
}
