package it.polimi.ingsw.pc15.effetti;

import java.io.Serializable;
import java.util.Scanner;

import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;

<<<<<<< HEAD
public class FissaValoreFamiliareAScelta extends FissaValoreFamiliare{
=======
public class FissaValoreFamiliareAScelta extends FissaValoreFamiliare /*implements EffettoAScelta*/ {
>>>>>>> 3100d7d4b54f28841f2211074778e3b2bed2fc8b

	public FissaValoreFamiliareAScelta(int valore)  {
		super(null, valore);
	}
	
	@Override
	public void attiva(Player player) {
		
		fissaValore(player);
		
	}
	
	public String toString() {
		return ("Fissa il valore di un familiare a tua scelta a " + valore) ;
<<<<<<< HEAD
	}	
=======
	}

	/*@Override
	public String getScelta() {
		return ("Scegli un familiare da settare a " + valore + ":\n  1) NERO\n  2) BIANCO\n  3) ARANCIONE");
	}*/
	
>>>>>>> 3100d7d4b54f28841f2211074778e3b2bed2fc8b

}
