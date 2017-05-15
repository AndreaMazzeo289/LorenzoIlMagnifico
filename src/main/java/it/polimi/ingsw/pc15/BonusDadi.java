package it.polimi.ingsw.pc15;

public class BonusDadi extends Bonus{

		private ColoreFamiliare coloreFamiliare;
		
		public BonusDadi (ColoreFamiliare coloreFamiliare, int valore){
			
			super(valore);
			this.coloreFamiliare = coloreFamiliare;
			
		}
		
		@Override
		public void attiva (Player player){
			
			switch(this.coloreFamiliare){
			
			case BIANCO : player.getEffettiAttivi().incrementaBonusDadi(0,getValore()); break;
			case NERO : player.getEffettiAttivi().incrementaBonusDadi(1,getValore()); break;
			case ARANCIONE : player.getEffettiAttivi().incrementaBonusDadi(2,getValore()); break;
			case NEUTRO : player.getEffettiAttivi().incrementaBonusDadi(3,getValore()); break;
			
			}
			
		}
}		
