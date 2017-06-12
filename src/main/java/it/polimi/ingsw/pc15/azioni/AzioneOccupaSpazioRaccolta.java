package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.effetti.Raccolto;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.plancia.SpazioRaccolta;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;

public class AzioneOccupaSpazioRaccolta extends AzioneOccupaSpazio {

	public AzioneOccupaSpazioRaccolta(Player player, Familiare familiare, SpazioRaccolta spazio) {
		super(player, familiare, spazio);
	}

	@Override
	public void attiva() {
		
		System.out.println("Occupi spazio raccolta!");
		
		spazio.aggiungiFamiliare(familiare);
		familiare.setDisponibilità(false);
		
		Effetto effetto = new Raccolto (familiare.getValore() + player.getEffettiAttivi().getBonusProduzione());
		effetto.attiva(familiare.getPlayer());

	}

	@Override
	public RisultatoAzione èValida() {
		
		if (familiare.disponibile() == false)
			return new RisultatoAzione(false, "il familiare non è disponibile");
		
		for (Familiare familiare : spazio.getFamiliari())
			if (familiare.getPlayer().equals(player) && !(familiare.getColore().equals(ColoreFamiliare.NEUTRO) || this.familiare.getColore().equals(ColoreFamiliare.NEUTRO)))
				return new RisultatoAzione(false, "non puoi posizionare altri familiari in questo spazio");
		
		int valoreAzione = familiare.getValore()+ familiare.getPlayer().getEffettiAttivi().getBonusRaccolta();
		
		if(valoreAzione >= spazio.getValoreMin())
			return new RisultatoAzione(true, player.getNome() + " occupa lo spazio raccolta!");
		else
			return new RisultatoAzione(false, "Il valore del tuo familiare è troppo basso!");
	}

}
