package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.plancia.Spazio;
import it.polimi.ingsw.pc15.plancia.SpazioTorre;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class AzioneOccupaSpazioTorre extends AzioneOccupaSpazio {
	
	AzionePrendiCarta azionePrendiCarta;
	int scelta;

	public AzioneOccupaSpazioTorre(Player player, Familiare familiare, SpazioTorre spazio, int servitoriAggiuntivi, int scelta) {
		super(player, familiare, spazio, servitoriAggiuntivi);
		this.scelta = scelta;
		
		this.valoreAzione = familiare.getValore() + servitoriAggiuntivi + player.getEffettiAttivi().getBonusDadoCarte(spazio.getCarta().getTipo()) + player.getEffettiAttivi().getBonusDadoCarte(TipoCarta.ALL);
		
		switch (((SpazioTorre) this.spazio).getCarta().getTipo() ) {
		case EDIFICIO: azionePrendiCarta = new AzionePrendiCartaEdificio (this.player, ((SpazioTorre) this.spazio).getCarta()); break;
		case IMPRESA:azionePrendiCarta = new AzionePrendiCartaImpresa (this.player, ((SpazioTorre) this.spazio).getCarta(), scelta); 	break;
		case PERSONAGGIO: azionePrendiCarta = new AzionePrendiCartaPersonaggio (this.player, ((SpazioTorre) this.spazio).getCarta()); break;
		case TERRITORIO: azionePrendiCarta = new AzionePrendiCartaTerritorio (this.player, ((SpazioTorre) this.spazio).getCarta()); break;
		}
	}

	@Override
	public void attiva() {
		
		pagaServitori();
		
		spazio.aggiungiFamiliare(familiare);
		familiare.setDisponibilità(false);
		
		if (player.getEffettiAttivi().disponibilitàBonusSpazioTorri())
			((SpazioTorre) spazio).getBonusRisorse().attiva(player);
		
		azionePrendiCarta.attiva();	
		
		((SpazioTorre) spazio).getTorre().setOccupata(true);
	}

	@Override
	public RisultatoAzione èValida() {
		
		if (familiare.disponibile() == false)
			return new RisultatoAzione(false, player.getNome() + " cerca di posizionare un familiare ma questo non è disponibile");
		
		if (spazio.vuoto() == false)
			return new RisultatoAzione(false, player.getNome() + " cerca di posizionare un familiare ma lo spazio scelto è occupato");
		
		if (controlloFamiliariTorre() == false)
			return new RisultatoAzione(false, player.getNome() + "non può piazzare il familiare poichè nella torre ne ha già posizionato un altro(non neutro)");
		
		if ( familiare.getValore() + servitoriAggiuntivi + player.getEffettiAttivi().getBonusDadoCarte(((SpazioTorre) spazio).getCarta().getTipo()) < spazio.getValoreMin() )
			return new RisultatoAzione(false, player.getNome() + " non può piazzare il familiare poichè il suo valore non soddisfa i requisiti della torre");
		
		return this.azionePrendiCarta.èValida();
	}
	
	public boolean controlloFamiliariTorre() {
		
		for (SpazioTorre spazioTorre : ((SpazioTorre) spazio).getTorre().getSpaziTorre())
			if (spazioTorre.vuoto()==false)
				if (spazioTorre.getFamiliare().getPlayer().equals(player) && !(this.familiare.getColore().equals(ColoreFamiliare.NEUTRO) || spazioTorre.getFamiliare().getColore().equals(ColoreFamiliare.NEUTRO)))
					return false;
		
		return true;
		
	}

}
