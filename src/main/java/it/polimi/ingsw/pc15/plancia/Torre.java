package it.polimi.ingsw.pc15.plancia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

public class Torre implements Serializable {
	
	private ArrayList<SpazioTorre> spaziTorre;
	private boolean occupata;
	
	public Torre (int numeroSpaziTorre, ArrayList<SetRisorse> arraySetRisorse) {

		this.spaziTorre = new ArrayList(numeroSpaziTorre);
		for (int i=0; i<numeroSpaziTorre; i++) {
			spaziTorre.add(i, new SpazioTorre(2*i+1, arraySetRisorse.get(i), this));	
		}
	}
		
	public boolean occupata() {
		return occupata;
	}
	
	public void setOccupata(boolean par) {
		this.occupata=par;
	}
	
	public void setTorre(ArrayList<Carta> carte) {
		
		for (int i=0; i<carte.size(); i++)
			(spaziTorre.get(i)).setCarta(carte.get(i));  //mette la carta i nello spazio i
		
	}
	
	public ArrayList<SpazioTorre> getSpaziTorre() {
		return this.spaziTorre;
	}
	
	public SpazioTorre getSpazio(int num) {
		return this.spaziTorre.get(num);
	}
	
}
