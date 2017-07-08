package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;
import java.util.Iterator;

import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.player.Player;

public class Raccolto extends Effetto {
	
	private int valore;
	
	public Raccolto(int valore){
		this.valore = valore;
	}
	
	@Override
	public void attiva(Player player){
		
		new AggiuntaRisorse(player.getTesseraBonusRaccolta()).attiva(player);
		
		for (Carta territorio : player.getCarte(TipoCarta.TERRITORIO)) {
			if (valore + player.getEffettiAttivi().getBonusRaccolta()>= ((Territorio) territorio).getRequisitoRaccolta() ) {
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
