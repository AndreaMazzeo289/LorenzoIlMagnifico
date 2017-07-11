package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.Leader;
import it.polimi.ingsw.pc15.player.Player;

/** 
 * Sotto classe di azione leader che permette di attivare l'effetto di leader.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class AzioneAttivaEffettoLeader extends AzioneLeader {

	public AzioneAttivaEffettoLeader(Player player, Leader leader) {
		super(player, leader);
	}

	
	/**
	 * Metodo che permette l'attivazione dell'effetto 
	 * periodico basato sul turno di un leader.
	 */
	
	
	@Override
	public void attiva() {
				
		for (Effetto effetto : leader.getEffettoPerTurno() )
			effetto.attiva(player);
		leader.setEffettoAttivato(true);	
	}

	/**
	 * Metodo che verifica la validità dell'attivazione 
	 * dell'effetto leader.
	 * 
	 * @return Il risultato della validità dell'azione con Risultato azione.
	 */
	
	@Override
	public RisultatoAzione èValida() {
		
		if (leader.giocato() == false) {
			return new RisultatoAzione(false, player.getNome() + " vuole attivare l'effetto di " + leader.getNome() + " ma deve prima giocare tale carta!");
		}
		
		if (leader.effettoGiàAttivato()) {
			return new RisultatoAzione(false, player.getNome() + " vuole attivare l'effetto di " + leader.getNome() + " ma lo ha già attivato questo turno!");		}
		
		return new RisultatoAzione(true, player.getNome() + " attiva l'effetto di " + leader.getNome() + "!");
	}

}
