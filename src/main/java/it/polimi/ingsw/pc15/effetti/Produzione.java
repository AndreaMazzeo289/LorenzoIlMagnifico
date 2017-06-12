package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;
import java.util.Iterator;

import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.player.Player;

public class Produzione extends Effetto {
	
	private int valore;
	
	public Produzione(int valore){
		this.valore = valore;
	}
	
	@Override
	public void attiva(Player player){
		
		for (Carta edificio : player.getCarte(TipoCarta.EDIFICIO)) {
			if (valore >= ((Edificio) edificio).getRequisitoProduzione() ) {
				System.out.println("Attivo produzione in " + edificio.getNome());
				for (Effetto effetto : edificio.getEffettoPermanente())
					if (effetto instanceof Incrementabile)
						((Incrementabile) effetto).attivaDaCarta(player);
					else effetto.attiva(player);
			}
			
			else System.out.println("Il valore del familiare non è sufficiente per attivare la produzione in " + edificio.getNome());
		}
	}
	
	public String toString() {
		return ("Consente di effettuare un'azione Produzione del valore di " + valore) ;
	}
}
