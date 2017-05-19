package it.polimi.ingsw.pc15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Plancia {
	
	private Torre torreVerde;
	private Torre torreBlu;
	private Torre torreGialla;
	private Torre torreViola;
	
	private SpazioProduzione spazioProduzione;
	private SpazioRaccolta spazioRaccolta;
	private SpazioConsiglio spazioConsiglio;
	private Set<SpazioMercato> spaziMercato;
	
	private ParseXML parseXML;
	
	public Plancia () {
		
		int numeroSpaziTorre = 0; //da cambiare con XML
		
		ArrayList risorseTorreVerde = new ArrayList(numeroSpaziTorre);
		ArrayList risorseTorreBlu = new ArrayList(numeroSpaziTorre);
		ArrayList risorseTorreGialla = new ArrayList(numeroSpaziTorre);
		ArrayList risorseTorreViola = new ArrayList(numeroSpaziTorre);
		
		for(int i=0; i<numeroSpaziTorre; i++){
			risorseTorreVerde.add(parseXML.leggiSpazioTorre(ColoreCarta.VERDE,i));
			risorseTorreBlu.add(parseXML.leggiSpazioTorre(ColoreCarta.BLU,i));
			risorseTorreGialla.add(parseXML.leggiSpazioTorre(ColoreCarta.GIALLO,i));
			risorseTorreViola.add(parseXML.leggiSpazioTorre(ColoreCarta.VIOLA,i));
		}
		
		/*risorseTorreVerde = null;    //
		risorseTorreBlu = null;      //   da cambiare
		risorseTorreGialla = null;   //     con XML
		risorseTorreViola = null;    //*/
		
		torreVerde = new Torre (numeroSpaziTorre, risorseTorreVerde);
		torreBlu = new Torre (numeroSpaziTorre, risorseTorreBlu);
		torreGialla = new Torre (numeroSpaziTorre, risorseTorreGialla);
		torreViola = new Torre (numeroSpaziTorre, risorseTorreViola);
		
		spazioProduzione = new SpazioProduzione(1);   //  da cambiare
		spazioRaccolta = new SpazioRaccolta(1);       //    con XML
		
		SetRisorse risorseConsiglio = null;                                    //   da cambiare
		spazioConsiglio = new SpazioConsiglio(1, risorseConsiglio);            //     con XML
		  
		spaziMercato = new HashSet<SpazioMercato>();
		int numeroSpaziMercato = 4; 
			for(int i=0; i<numeroSpaziMercato; i++) 
				spaziMercato.add(new SpazioMercato(1, risorseConsiglio)); //il secondo argomento è XMLRicercaRisorseMercato(i)	
		
	}
	
	public void resetTurno (int periodo){
		
	}
	
	
	
	public SpazioProduzione getSpazioProduzione() {
		return this.spazioProduzione;
	}

	public SpazioRaccolta getSpazioRaccolta() {
		return this.spazioRaccolta;
	}

	public SpazioConsiglio getSpazioConsiglio() {
		return this.spazioConsiglio;
	}
	
	public Set<SpazioMercato> getSpaziMercato() {
		return this.spaziMercato;
	}



	
	
	
	
	
}
