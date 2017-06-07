package it.polimi.ingsw.pc15.azioni;

import java.util.Map;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.Leader;
import it.polimi.ingsw.pc15.player.Player;

public class AzioneGiocaLeader extends AzioneLeader {

	public AzioneGiocaLeader(Player player, Leader leader) {
		super(player, leader);
	}

	@Override
	public void attiva() {

		leader.setGiocato(true);
		
		if (leader.getEffettoPermanente()!=null) 
			for (Effetto effetto : leader.getEffettoPermanente())
				effetto.attiva(player);
	}

	@Override
	public boolean èValida() {
		
		if (leader.giocato()) {
			System.out.println("Hai già giocato questo Leader!");
			return false;
		}

		if (leader.getRequisitoRisorse() != null)
			if (player.getSetRisorse().paragona(leader.getRequisitoRisorse()) == false) {
				System.out.println("Non soddisfi il requisito di risorse richiesto per giocare " + leader.getNome());
				return false;
		}
		
		if (leader.getRequisitoCarte() != null)
			for(Map.Entry<TipoCarta, Integer> requisito : leader.getRequisitoCarte().entrySet())
				if (player.getCarte(requisito.getKey()).size() < requisito.getValue()) {
					System.out.println("Non soddisfi il requisito di Carte Sviluppo richiesto per giocare " + leader.getNome());
					return false;
				}

		return true;
	}

}
