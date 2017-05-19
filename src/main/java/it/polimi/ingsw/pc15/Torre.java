package it.polimi.ingsw.pc15;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public abstract class Torre {
	
	private ArrayList spaziTorre;
	private boolean occupata;
	
	public Torre (int numeroSpazi) {
		
		this.spaziTorre = new ArrayList(numeroSpazi);
		for (int i=0; i<numeroSpazi; i++) {
			spaziTorre.add(i, new SpazioTorre(2*i+1));	
		}
	}
		
	public boolean occupata() {
		return occupata;
	}
	
	public void setOccupata(boolean val) {
		this.occupata=val;
	}
	
	public void setTorre(Set<Carta> carte) {
			
			carte.forEach(c->System.out.println(c.toString()));
			carte.addAll(spaziTorre);		
	}
	
}
