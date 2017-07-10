package it.polimi.ingsw.pc15.effetti;

import it.polimi.ingsw.pc15.player.Player;

public class MoltiplicaRisorseCarte extends Effetto {
	
	private int moltiplicatore;
	
	public MoltiplicaRisorseCarte(int moltiplicatore) {
		this.moltiplicatore = moltiplicatore;
	}

	/**
	 * Metodo che aggiunge un moltiplicatore al guadagno delle risorse 
	 * da carta.
	 * 
	 * @param player su cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player) {
		player.getEffettiAttivi().setMoltiplicatoreRisorseCarte(moltiplicatore);
		
	}
	
	

}
