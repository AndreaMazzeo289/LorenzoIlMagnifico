package it.polimi.ingsw.pc15.carte;

import java.io.Serializable;
import java.util.Set;

import it.polimi.ingsw.pc15.azioni.AzionePrendiCarta;
import it.polimi.ingsw.pc15.azioni.AzionePrendiCartaEdificio;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

public class Edificio extends Carta {
	
	private int requisitoProduzione;
	
	public Edificio (String nome, int id, int periodo, SetRisorse costo,  Set<Effetto> effettoIstantaneo, Set<Effetto> effettoPermanente, int requisitoProduzione, String imgPath) {
		super(nome, id, periodo, costo, effettoIstantaneo, effettoPermanente, imgPath);
		this.requisitoProduzione = requisitoProduzione;
		this.tipo = TipoCarta.EDIFICIO;
	}

	/**
	 * @return restituisce il requisito produzione della carta edificio.
	 */
	
	public int getRequisitoProduzione() {
		return this.requisitoProduzione;
	}

}
