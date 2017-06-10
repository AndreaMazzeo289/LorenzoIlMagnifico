package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;

import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class BonusRisorseSpazi extends Bonus implements Serializable {
	
	private TipoRisorsa risorsa;

	public BonusRisorseSpazi(int valore, TipoRisorsa risorsa) {
		super(valore);
		this.risorsa = risorsa;
	}

	@Override
	public void attiva(Player player) {
		
	}

}
