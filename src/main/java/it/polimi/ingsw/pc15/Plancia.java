package it.polimi.ingsw.pc15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Plancia {
	
	private Torre torreVerde;
	private Torre torreBlu;
	private Torre torreGialla;
	private Torre torreViola;
	
	private int numeroSpaziTorre;
	
	private SpazioProduzione spazioProduzione;
	private SpazioRaccolta spazioRaccolta;
	private SpazioConsiglio spazioConsiglio;
	private Set<SpazioMercato> spaziMercato;
	
	private ParseXML parseXML;
	
	public Plancia () {
		
		numeroSpaziTorre = 0; //da cambiare con XML
		
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
	
	public void setTurno (int periodo, Set<Territorio> territori, Set<Personaggio> personaggi, Set<Edificio> edifici, Set<Impresa> imprese){
		
		ArrayList arrayTerritori = new ArrayList();
		ArrayList arrayPersonaggi = new ArrayList();
		ArrayList arrayEdifici = new ArrayList();
		ArrayList arrayImprese = new ArrayList();
		
		Iterator<Territorio> territorio = territori.iterator();
		Iterator<Personaggio> personaggio = personaggi.iterator();
		Iterator<Edificio> edificio = edifici.iterator();
		Iterator<Impresa> impresa = imprese.iterator();
		
		int n = 0;
		
		while (territorio.hasNext() && n < numeroSpaziTorre) {
			
			if (territorio.next().getPeriodo() == periodo) {
				arrayTerritori.add(territorio.next());
				territori.remove(territorio.next());
				n++;
			}
				
		}
		
		n=0;
		while (personaggio.hasNext() && n < numeroSpaziTorre) {
			
			if (personaggio.next().getPeriodo() == periodo) {
				arrayPersonaggi.add(personaggio.next());
				personaggi.remove(personaggio.next());
				n++;
			}
				
		}
		
		n=0;
		while (edificio.hasNext() && n < numeroSpaziTorre) {
			
			if (edificio.next().getPeriodo() == periodo) {
				arrayEdifici.add(edificio.next());
				edifici.remove(edificio.next());
				n++;
			}
				
		}
		
		n=0;
		while (impresa.hasNext() && n < numeroSpaziTorre) {
			
			if (impresa.next().getPeriodo() == periodo) {
				arrayImprese.add(impresa.next());
				imprese.remove(impresa.next());
				n++;
			}
				
		}
 		
 		Collections.shuffle(arrayTerritori);
 		Collections.shuffle(arrayPersonaggi);
 		Collections.shuffle(arrayEdifici);
 		Collections.shuffle(arrayImprese);
 		
 		this.torreVerde.setTorre(arrayTerritori);
 		this.torreBlu.setTorre(arrayPersonaggi);
 		this.torreGialla.setTorre(arrayEdifici);
 		this.torreViola.setTorre(arrayImprese);
		
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
