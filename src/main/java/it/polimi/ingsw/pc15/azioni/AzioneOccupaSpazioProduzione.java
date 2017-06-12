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
		
		System.out.println("Occupi spazio produzione!");	
		familiare.setDisponibilità(false);
		
		spazio.aggiungiFamiliare(familiare);
		Effetto effetto = new Produzione(familiare.getValore() + player.getEffettiAttivi().getBonusProduzione());
		effetto.attiva(familiare.getPlayer());
	}

	@Override
	public RisultatoAzione èValida() {
		
		if (familiare.disponibile() == false)
			return new RisultatoAzione(false, "FRASE");
		
		for (Familiare familiare : spazio.getFamiliari())
			if (familiare.getPlayer().equals(player) && !(familiare.getColore().equals(ColoreFamiliare.NEUTRO) || this.familiare.getColore().equals(ColoreFamiliare.NEUTRO)))
				return new RisultatoAzione(false, "FRASE");
		
		int valoreAzione = familiare.getValore()+ familiare.getPlayer().getEffettiAttivi().getBonusProduzione();
		

		if(valoreAzione >= spazio.getValoreMin())
				return new RisultatoAzione(true, player.getNome() + " occupa lo spazio produzione!");
		else 
				return new RisultatoAzione(false, "Il valore del tuo familiare è troppo basso!");
	}

}
