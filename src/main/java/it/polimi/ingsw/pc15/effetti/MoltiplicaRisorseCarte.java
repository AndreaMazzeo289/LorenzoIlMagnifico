package it.polimi.ingsw.pc15.effetti;

import it.polimi.ingsw.pc15.player.Player;

public class MoltiplicaRisorseCarte extends Effetto {
	
	private int moltiplicatore;
	
	public MoltiplicaRisorseCarte(int moltiplicatore) {
		this.moltiplicatore = moltiplicatore;
	}

	/**
	 * Metodo che permette l'attivazione dell'effetto.
	 * 
	 * @param player u cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player) {
		player.getEffettiAttivi().setMoltiplicatoreRisorseCarte(moltiplicatore);
		
	}
	
	

}
