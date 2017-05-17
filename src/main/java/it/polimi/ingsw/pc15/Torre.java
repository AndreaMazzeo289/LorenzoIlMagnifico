package it.polimi.ingsw.pc15;

import java.util.ArrayList;
import java.util.Iterator;

public class Torre {
	
	private ArrayList spaziTorre;
	private boolean occupata;
	
	public Torre (SetRisorse spazio1, SetRisorse spazio2, SetRisorse spazio3, SetRisorse spazio4) {
		
		this.spaziTorre = new ArrayList(4);
		SpazioTorre spazioTorre1 = new SpazioTorre(1);
		SpazioTorre spazioTorre2 = new SpazioTorre(3);
		SpazioTorre spazioTorre3 = new SpazioTorre(5);
		SpazioTorre spazioTorre4 = new SpazioTorre(7);
		
		spaziTorre.add(0, spazioTorre1);
		spaziTorre.add(1, spazioTorre2);
		spaziTorre.add(2, spazioTorre3);
		spaziTorre.add(3, spazioTorre4);
		
	}
		
	public boolean occupata() {
		return occupata;
	}
	
	public void setOccupata(boolean par) {
		this.occupata=par;
	}
	
}
