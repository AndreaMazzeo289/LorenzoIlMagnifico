package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.plancia.SpazioTorre;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;

public class AzioneOccupaSpazioTorre extends AzioneOccupaSpazio {
	
	AzionePrendiCarta azionePrendiCarta;

	public AzioneOccupaSpazioTorre(Player player, Familiare familiare, SpazioTorre spazio) {
		super(player, familiare, spazio);
		
		switch (((SpazioTorre) this.spazio).getCarta().getTipo() ) {

		case EDIFICIO: azionePrendiCarta = new AzionePrendiCartaEdificio (this.player, ((SpazioTorre) this.spazio).getCarta());
			break;
		case IMPRESA:azionePrendiCarta = new AzionePrendiCartaImpresa (this.player, ((SpazioTorre) this.spazio).getCarta());
			break;
		case PERSONAGGIO: azionePrendiCarta = new AzionePrendiCartaPersonaggio (this.player, ((SpazioTorre) this.spazio).getCarta());
			break;
		case TERRITORIO: azionePrendiCarta = new AzionePrendiCartaTerritorio (this.player, ((SpazioTorre) this.spazio).getCarta());
			break;
		default:azionePrendiCarta = null;
			break;
		}
	}

	@Override
	public void attiva() {
		
		System.out.println("Occupi spazio torre!");
		
		spazio.aggiungiFamiliare(familiare);
		familiare.setDisponibilità(false);
		
		if (player.getEffettiAttivi().disponibilitàBonusSpazioTorri())
			((SpazioTorre) spazio).getBonusRisorse().attiva(player);
		
		((SpazioTorre) spazio).getTorre().setOccupata(true);
		
		azionePrendiCarta.attiva();	
	}

	@Override
	public boolean èValida() {
		
		if (familiare.disponibile() == false) {
			System.out.println("Hai già posizionato questo familiare!");
			return false;
		}
		
		if (spazio.vuoto() == false) {
			System.out.println("Lo spazio è già occupato!");
			return false;		
		}
		
		if (controlloFamiliariTorre() == false) {
			System.out.println("Non puoi posizionare altri familiari in questa torre!");
			return false;
		}
					
		if ( familiare.getValore() < spazio.getValoreMin() ) {
			System.out.println("Il valore del tuo familiare è troppo basso!");
			return false;
		}
		
		return this.azionePrendiCarta.èValida();
	}
	
	public boolean controlloFamiliariTorre() {
		
		for (SpazioTorre spazioTorre : ((SpazioTorre) spazio).getTorre().getSpaziTorre())
			if (spazioTorre.getFamiliare().getPlayer().equals(player) && !(this.familiare.getColore().equals(ColoreFamiliare.NEUTRO) || spazioTorre.getFamiliare().getColore().equals(ColoreFamiliare.NEUTRO)))
				return false;
		
		return true;
		
	}

}
