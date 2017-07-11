package it.polimi.ingsw.pc15.plancia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

/**
 * Torre della plancia che inizialiazza nel costruttore i relativi spazi.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */


public class Torre implements Serializable {
	
	private ArrayList<SpazioTorre> spaziTorre;
	private boolean occupata;
	
	public Torre (int numeroSpaziTorre, ArrayList<SetRisorse> arraySetRisorse) {

		this.spaziTorre = new ArrayList<SpazioTorre>(numeroSpaziTorre);
		for (int i=0; i<numeroSpaziTorre; i++) {
			spaziTorre.add(i, new SpazioTorre(2*i+1, arraySetRisorse.get(i), this));	
		}
	}
		
	
	/**
	 * @return true se la torre è occupata, false altrimenti.
	 */
	
	public boolean occupata() {
		return occupata;
	}
	
	/**
	 * Setta il valore di occupata della torre.
	 * 
	 * @param par booleano utilizzato per settare la torre.
	 */
	
	public void setOccupata(boolean par) {
		this.occupata=par;
	}
	
	/**
	 * Setta le carte ricevute dalla plancia nei relativi spazi torre.
	 * L'ordine di posizionamento è legato all'ordine con cui sono 
	 * state estratte nel parseXML.
	 * 
	 * @param ArrayList di carte da settare negli spazi torre.
	 */
	
	public void setTorre(ArrayList<Carta> carte) {
		for (int i=0; i<carte.size(); i++)
			(spaziTorre.get(i)).setCarta(carte.get(i));  //mette la carta i nello spazio i
	}
	
	/**
	 * Libera tutti gli spazi della torre dai familiari posizionati.
	 */
	
	public void libera() {
		for (SpazioTorre spazio: this.spaziTorre)
			spazio.rimuoviFamiliari();
		
		this.occupata = false;
	}
	
	/**
	 * @return L'ArrayList contenente gli oggetti spazio torre.
	 */
	
	public ArrayList<SpazioTorre> getSpaziTorre() {
		return this.spaziTorre;
	}
	
	/**
	 * @param num dello spazio torre da ritornare.
	 * @return uno specifico spazio torre.
	 */
	
	public SpazioTorre getSpazio(int num) {
		return this.spaziTorre.get(num);
	}
	
}
