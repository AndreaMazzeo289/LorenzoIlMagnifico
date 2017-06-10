package it.polimi.ingsw.pc15.azioni;

import it.polimi.ingsw.pc15.ParserXML;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.Player;

public class AzionePrendiCartaPersonaggio extends AzionePrendiCarta {

	public AzionePrendiCartaPersonaggio(Player player, Carta carta) {
		super(player, carta);
	}

	@Override
	public RisultatoAzione èValida() {
		
		if (player.getCarte(TipoCarta.PERSONAGGIO).size() == ParserXML.leggiValore("numeroMaxCarte")) 
			return new RisultatoAzione(false, "FRASE");
		
		if (!risorseSufficienti())
			return new RisultatoAzione(false, "FRASE");
			
		return new RisultatoAzione(true, player.getNome() + " prende la carta Personaggio " + carta.getNome());
	}

	@Override
	public void attiva() {
		
		pagaCosto();
		daiCarta();
		attivaEffettoIstantaneo();
		attivaEffettoPermanente();
		
	}
	
	public void attivaEffettoPermanente() {
		for (Effetto effetto : carta.getEffettoPermanente())
			effetto.attiva(player);
		
	}

}
