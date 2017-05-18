package it.polimi.ingsw.pc15;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class Torre {
	
	private ArrayList spaziTorre;
	private boolean occupata;
	
	public Torre (int numeroSpazi, ArrayList setRisorse) {
		
		this.spaziTorre = new ArrayList(numeroSpazi);
		for (int i=0; i<numeroSpazi; i++) {
			spaziTorre.add(i, new SpazioTorre(2*i+1, (SetRisorse) setRisorse.get(i)));	
		}
	}
		
	public boolean occupata() {
		return occupata;
	}
	
	public void setOccupata(boolean par) {
		this.occupata=par;
	}
	
	public void setTorre(Set<Carta> carte) {
			
			carte.forEach(c->System.out.println(c.toString()));
			carte.addAll(spaziTorre);		
	}
	
}
