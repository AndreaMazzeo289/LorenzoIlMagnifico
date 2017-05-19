package it.polimi.ingsw.pc15;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class Torre {
	
	private ArrayList spaziTorre;
	private boolean occupata;
	
	public Torre (int numeroSpaziTorre, ArrayList arraySetRisorse) {

		this.spaziTorre = new ArrayList(numeroSpaziTorre);
		for (int i=0; i<numeroSpaziTorre; i++) {
			spaziTorre.add(i, new SpazioTorre(2*i+1, (SetRisorse) arraySetRisorse.get(i)));	
		}
	}
		
	public boolean occupata() {
		return occupata;
	}
	
	public void setOccupata(boolean par) {
		this.occupata=par;
	}
	
	public void setTorre(ArrayList carte) {
		
		for (int i=0; i<spaziTorre.size(); i++)
			((SpazioTorre) spaziTorre.get(i)).setCarta((Carta) carte.get(i));  //mette la carta i nello spazio i
		
	}
	
}
