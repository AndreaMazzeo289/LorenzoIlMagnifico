package it.polimi.ingsw.pc15.effetti;

import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Player;

public abstract class BonusValoreFamiliare extends Bonus{

		protected ColoreFamiliare colore;
		
		public BonusValoreFamiliare (ColoreFamiliare colore, int valore){
			
			super(valore);
			this.colore = colore;
			
		}
}		
