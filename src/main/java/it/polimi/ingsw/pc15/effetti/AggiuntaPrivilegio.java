package it.polimi.ingsw.pc15.effetti;

import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.Legna;
import it.polimi.ingsw.pc15.risorse.Oro;
import it.polimi.ingsw.pc15.risorse.Pietra;
import it.polimi.ingsw.pc15.risorse.PuntiFede;
import it.polimi.ingsw.pc15.risorse.PuntiMilitari;
import it.polimi.ingsw.pc15.risorse.Servitori;

public class AggiuntaPrivilegio extends Effetto{
	
	public AggiuntaPrivilegio(int scelta) {
		this.scelta = scelta;
	}
	
	private int scelta;

	@Override
	public void attiva(Player player) {
		switch(scelta) {
		case 1: player.getSetRisorse().aggiungi(new Legna(1));
				player.getSetRisorse().aggiungi(new Pietra(1));
				break;
		case 2: player.getSetRisorse().aggiungi(new Servitori(2));
				break;
		case 3: player.getSetRisorse().aggiungi(new Oro(2));
				break;
		case 4: player.getSetRisorse().aggiungi(new PuntiMilitari(2));
				break;
		case 5: player.getSetRisorse().aggiungi(new PuntiFede(1));
				break;
		}
		
	}
	
	

}
