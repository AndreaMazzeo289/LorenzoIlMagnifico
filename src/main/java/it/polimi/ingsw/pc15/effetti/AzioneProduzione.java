package it.polimi.ingsw.pc15.effetti;

import java.util.Iterator;

import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.player.Player;

public class AzioneProduzione extends Azione{
	
	public AzioneProduzione(int valoreDado){
		super(valoreDado);
	}
	
	@Override
	public void attiva(Player player){
		
		for (Carta edificio : player.getCarte(TipoCarta.EDIFICIO)) {
			if (valoreDado >= ((Edificio) edificio).getRequisitoProduzione() ) {
				System.out.println("Attivo produzione in " + edificio.getNome());
				for (Effetto effetto : edificio.getEffettoPermanente())
					effetto.attiva(player);
			}
			
			else System.out.println("Il valore del familiare non è sufficiente per attivare la produzione in " + edificio.getNome());
		}
	}
}
