package it.polimi.ingsw.pc15;

public class Torre {
	private SpazioTorre[] spazioTorre;
	private boolean occupata;
	
	public Torre (SetRisorse spazio1, SetRisorse spazio2, SetRisorse spazio3, SetRisorse spazio4){
		this.spazioTorre = new SpazioTorre[4];
		this.spazioTorre[1]= new SpazioTorre(1,spazio1);
		this.spazioTorre[2]= new SpazioTorre(3,spazio2);
		this.spazioTorre[3]= new SpazioTorre(5,spazio3);
		this.spazioTorre[4]= new SpazioTorre(7,spazio4);
	}
	
	public SpazioTorre[] getSpazioTorre() {
		return this.spazioTorre;
	}
		

	public boolean occupata() {
		return occupata;
	}
	
	public void setOccupata(boolean par) {
		this.occupata=par;
	}
	
}
