package it.polimi.ingsw.pc15.effetti;

import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Player;

public class BonusValoreFamiliare extends Bonus{

		private ColoreFamiliare colore;
		
		public BonusValoreFamiliare (ColoreFamiliare colore, int valore){
			
			super(valore);
			this.colore = colore;
			
		}
		
		@Override
		public void attiva (Player player){
			player.getFamiliare(colore).incrementaValoreBonus(valore);
		}
}		
