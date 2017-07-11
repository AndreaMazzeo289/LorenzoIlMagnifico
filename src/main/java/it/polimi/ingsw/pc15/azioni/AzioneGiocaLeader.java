package it.polimi.ingsw.pc15.azioni;

import java.util.Map;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.Leader;
import it.polimi.ingsw.pc15.player.Player;

/** 
 * Sotto classe di azione leader che permette di giocare un leader.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class AzioneGiocaLeader extends AzioneLeader {

	public AzioneGiocaLeader(Player player, Leader leader) {
		super(player, leader);
	}

	
	/**
	 * 
	 * Metodo che permette al player di giocare una carta leader ed 
	 * attivarne il relativo effetto permanente.
	 */
	
	@Override
	public void attiva() {
		
		leader.setGiocato();
		
		if (leader.getEffettoPermanente()!=null) 
			for (Effetto effetto : leader.getEffettoPermanente())
				effetto.attiva(player);
	}

	/**
	 * 
	 * Metodo che verifica la validità di attivazione dell'effetto
	 * permanente del leader.
	 * 
	 * @return Il risultato della validità dell'azione con Risultato azione.
	 */
	
	@Override
	public RisultatoAzione èValida() {
		
		if (leader.giocato())
			return new RisultatoAzione(false, player.getNome() + " vuole giocare la carta Leader " + leader.getNome() + " ma lo ha già giocato!");

		if (leader.getRequisitoRisorse() != null)
			if (player.getSetRisorse().paragona(leader.getRequisitoRisorse()) == false)
				return new RisultatoAzione(false, player.getNome() + " vuole giocare la carta Leader " + leader.getNome() + " ma non soddisfa il requisito di risorse richiesto!");
		
		if (leader.getRequisitoCarte() != null)
			for(Map.Entry<TipoCarta, Integer> requisito : leader.getRequisitoCarte().entrySet())
				if (player.getCarte(requisito.getKey()).size() < requisito.getValue())
					return new RisultatoAzione(false, player.getNome() + " vuole giocare la carta Leader " + leader.getNome() + " ma non soddisfa il requisito di carte richiesto!");

		return new RisultatoAzione(true, player.getNome() + " gioca la carta Leader " + leader.getNome());
	}

}
