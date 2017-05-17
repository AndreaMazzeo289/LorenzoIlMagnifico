package it.polimi.ingsw.pc15;


public class AggiuntaRisorse implements Effetto {

	private SetRisorse setRisorse;
	
	public AggiuntaRisorse (SetRisorse setRisorse) {
		
		this.setRisorse = setRisorse;
	}
	
	@Override
	public void attiva(Player player){
		
		player.getSetRisorse().aggiungi(setRisorse);
	}
}
