package it.polimi.ingsw.pc15;


public class AggiuntaRisorse implements Effetto {

	private SetRisorse setRisorse;
	
	public AggiuntaRisorse (int numOro, int numLegna, int numPietra, int numServitori, int numPuntiVittoria, int numPuntiMilitari, int numPuntiFede, int numPrivilegi) {
		
		this.setRisorse = new SetRisorse (numOro,  numLegna,  numPietra, numServitori, numPuntiVittoria, numPuntiMilitari, numPuntiFede, numPrivilegi);
	}
	
	@Override
	public void attiva(Player player){
		
		player.getSetRisorse().aggiungi(setRisorse);
	}
}
