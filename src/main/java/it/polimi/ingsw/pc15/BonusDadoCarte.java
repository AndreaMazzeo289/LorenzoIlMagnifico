package it.polimi.ingsw.pc15;

public class BonusDadoCarte extends Bonus{
	
	private Colore coloreCarta;
	
	public BonusDadoCarte (Colore coloreCarta, int valore){
		
		super(valore);
		this.coloreCarta = coloreCarta;
		
	}
	
	@Override
	public void attiva(Player player){
		
		switch(coloreCarta){
		
		case VERDE : player.getEffettiAttivi().incrementaBonusDadoCarte(0,this.valore); break;
		case BLU : player.getEffettiAttivi().incrementaBonusDadoCarte(1,this.valore); break;
		case GIALLO : player.getEffettiAttivi().incrementaBonusDadoCarte(2,this.valore); break;
		case VIOLA : player.getEffettiAttivi().incrementaBonusDadoCarte(3,this.valore); break;
		case ALL : player.getEffettiAttivi().incrementaBonusDadoCarte(4,this.valore); break;
		
		}
		
	}
	
}
