package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;
import java.util.Iterator;

import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.player.Player;
/**
 * Sottoclasse di effetto che permette l'attivazione dell'effetto produzione.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */
public class Produzione extends Effetto {
	
	private int valore;
	
	public Produzione(int valore){
		this.valore = valore;
	}
	
	/**
	 * 
	 * Permette al player di effettuare una azione produzione con
	 * conseguente aggiunta di risorse in base agli effetti delle carte edificio possedute.
	 * 
	 * @param player su cui deve essere attivato l'effetto.
	 */
	
	@Override
	public void attiva(Player player){
		
		new AggiuntaRisorse(player.getTesseraBonus().getRisorseBonusProduzione()).attivaDaSpazio(player);
		
		for (Carta edificio : player.getCarte(TipoCarta.EDIFICIO)) {
			if (valore >= ((Edificio) edificio).getRequisitoProduzione() ) {
				for (Effetto effetto : edificio.getEffettoPermanente())
					if (effetto instanceof Incrementabile){
						((Incrementabile) effetto).attivaDaCarta(player);}
					else effetto.attiva(player);
			}
		}
	}
	
	public String toString() {
		return ("Consente di effettuare un'azione Produzione del valore di " + valore) ;
	}
}
