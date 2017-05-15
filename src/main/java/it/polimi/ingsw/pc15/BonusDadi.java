package it.polimi.ingsw.pc15;

public class BonusDadi extends Bonus{

		private ColoreFamilare coloreFamiliare;
		
		public BonusDadi (ColoreFamiliare coloreFamiliare, int valore){
			
			super(valore);
			this.coloreFamiliare = coloreFamiliare;
			
		}
		
		@Override
		public void attiva (Player player){
			
			switch(this.coloreFamiliare){
			
			case BIANCO : player.getEffettiAttivi().incrementaBonusDadi(0,this.valore); break;
			case NERO : player.getEffettiAttivi().incrementaBonusDadi(1,this.valore); break;
			case ARANCIONE : player.getEffettiAttivi().incrementaBonusDadi(2,this.valore); break;
			case NEUTRO : player.getEffettiAttivi().incrementaBonusDadi(3,this.valore); break;
			
			}
			
		}
}		
