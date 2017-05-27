package it.polimi.ingsw.pc15.effetti;

import java.util.Iterator;

import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.carte.Impresa;
import it.polimi.ingsw.pc15.carte.Personaggio;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public abstract class Moltiplicazione extends Effetto{

	protected SetRisorse setRisorse;
	protected int quantità;
	
	public Moltiplicazione(SetRisorse setRisorse, int quantità) {
		this.setRisorse = setRisorse;
		this.quantità = quantità;
	}

}
