package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.ParserXML;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.player.Player;

public class AzionePrendiCartaEdificio extends AzionePrendiCarta {

	public AzionePrendiCartaEdificio(Player player, Carta carta) {
		super(player, carta);
	}
	
	@Override
	public RisultatoAzione èValida() {
		
		if (player.getCarte(TipoCarta.EDIFICIO).size() == ParserXML.leggiValore("numeroMaxCarte"))
			return new RisultatoAzione(false, "FRASE");
		
		if (!risorseSufficienti())
			return new RisultatoAzione(false, "FRASE");
		
		return new RisultatoAzione(true, player.getNome() + " prende la carta Edificio " + carta.getNome()+"!");
	}

	@Override
	public void attiva() {
		
		pagaCosto();
		daiCarta();
		attivaEffettoIstantaneo();
		
	}


}
