package it.polimi.ingsw.pc15.carte;

import java.util.Set;

import it.polimi.ingsw.pc15.azioni.AzionePrendiCarta;
import it.polimi.ingsw.pc15.azioni.AzionePrendiCartaTerritorio;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

/**
 * Sottoclasse di carta che definisce territorio.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class Territorio extends Carta {
	
	private int requisitoRaccolta;
	
	public Territorio (String nome, int id, int periodo, SetRisorse costo, Set<Effetto> effettoIstantaneo, Set<Effetto> effettoPermanente, int requisitoRaccolta, String imgPath) {
		super(nome, id, periodo, costo, effettoIstantaneo, effettoPermanente, imgPath);
		this.requisitoRaccolta = requisitoRaccolta;
		this.tipo = TipoCarta.TERRITORIO;
	}
	
	/**
	 * @return restituisce il requisito raccolta della carta edificio.
	 */
	
	
	public int getRequisitoRaccolta() {
		return this.requisitoRaccolta;
	}

}
