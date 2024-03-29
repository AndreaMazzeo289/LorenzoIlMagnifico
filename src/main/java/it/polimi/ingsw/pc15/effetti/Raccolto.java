package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;
import java.util.Iterator;

import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.player.Player;
/**
 * Sottoclasse di effetto che permette l'attivazione dell'effetto raccolta.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */
public class Raccolto extends Effetto {
	
	private int valore;
	
	public Raccolto(int valore){
		this.valore = valore;
	}
	
	
	/**
	 * 
	 * Permette al player di effettuare una azione raccolta con
	 * conseguente aggiunta di risorse in base agli effetti delle carte territorio possedute.
	 * 
	 * @param player su cui deve essere attivato l'effetto.
	 */
	
	
	@Override
	public void attiva(Player player){
		
		new AggiuntaRisorse(player.getTesseraBonus().getRisorseBonusRaccolta()).attivaDaSpazio(player);
		
		for (Carta territorio : player.getCarte(TipoCarta.TERRITORIO)) {
			if (valore >= ((Territorio) territorio).getRequisitoRaccolta() ) {
				for (Effetto effetto : territorio.getEffettoPermanente()) {
					if (effetto instanceof Incrementabile)
						((Incrementabile) effetto).attivaDaCarta(player);
					else effetto.attiva(player);
				}
			}
		}
	}
	
	public String toString() {
		return ("Consente di effettuare un'azione Raccolta del valore di " + valore) ;
	}
}
