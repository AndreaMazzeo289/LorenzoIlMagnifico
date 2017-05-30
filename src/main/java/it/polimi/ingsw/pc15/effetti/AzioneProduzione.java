package it.polimi.ingsw.pc15.effetti;

import java.util.Iterator;

import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.ColoreCarta;
import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.player.Player;

public class AzioneProduzione extends Azione{
	
	public AzioneProduzione(int valoreDado){
		super(valoreDado);
	}
	
	@Override
	public void attiva(Player player){
		
		for (Carta edificio : player.getCarte(ColoreCarta.GIALLO)) {
			if (valoreDado >= ((Edificio) edificio).getRequisitoProduzione() ) {
				System.out.println("Attivo produzione in " + edificio.getNome());
				((Edificio) edificio).getEffettoProduzione().attiva(player);
			}
			
			else System.out.println("Il valore del familiare non è sufficiente per attivare la produzione in " + edificio.getNome());
		}
	}
}
