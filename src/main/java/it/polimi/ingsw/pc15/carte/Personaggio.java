package it.polimi.ingsw.pc15.carte;

import java.util.Set;

import it.polimi.ingsw.pc15.azioni.AzionePrendiCarta;
import it.polimi.ingsw.pc15.azioni.AzionePrendiCartaPersonaggio;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

/**
 * Sottoclasse di carta che definisce personaggio.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class Personaggio extends Carta {
	
	private Effetto effettoPermanente;
	
	public Personaggio (String nome, int id, int periodo, SetRisorse costo, Set<Effetto> effettoIstantaneo, Set<Effetto> effettoPermanente, String imgPath) {
		super(nome, id, periodo, costo, effettoIstantaneo, effettoPermanente, imgPath);
		this.tipo = TipoCarta.PERSONAGGIO;
		}
}
