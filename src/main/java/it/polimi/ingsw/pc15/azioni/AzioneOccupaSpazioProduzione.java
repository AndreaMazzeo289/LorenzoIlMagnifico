package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.effetti.Produzione;
import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.plancia.SpazioProduzione;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;

public class AzioneOccupaSpazioProduzione extends AzioneOccupaSpazio {

	public AzioneOccupaSpazioProduzione(Player player, Familiare familiare, SpazioProduzione spazio) {
		super(player, familiare, spazio);
	}

	@Override
	public void attiva() {
		
		spazio.aggiungiFamiliare(familiare);
		Effetto effetto = new Produzione(familiare.getValore() + player.getEffettiAttivi().getBonusProduzione());
		effetto.attiva(familiare.getPlayer());
	}

	@Override
	public boolean èValida() {
		
		if (familiare.disponibile() == false) {
			System.out.println("Hai già posizionato questo familiare!");
			return false;
		}
		
		for (Familiare familiare : spazio.getFamiliari())
			if (familiare.getPlayer().equals(player) && !(familiare.getColore().equals(ColoreFamiliare.NEUTRO) || this.familiare.getColore().equals(ColoreFamiliare.NEUTRO))) {
				System.out.println("Non puoi posizionare due familiari di colori diversi in questo spazio!");
			}
		
		int valoreAzione = familiare.getValore()+ familiare.getPlayer().getEffettiAttivi().getBonusProduzione();
		
		if(spazio.vuoto() == false )
			if(valoreAzione >= spazio.getValoreMin())
				return true;
			else {
				System.out.println("Il valore del tuo familiare è troppo basso!");
				return false;
			}
		else
			if(valoreAzione >= spazio.getValoreMin()+3)
				return true;
			else {
				System.out.println("Il valore del tuo familiare è troppo basso!");
				return false;
			}
	}

}
