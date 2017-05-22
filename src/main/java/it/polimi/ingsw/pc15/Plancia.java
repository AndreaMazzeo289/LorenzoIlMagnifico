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
	
	public Plancia (int numeroGiocatori) {
		
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
		
		spazioProduzione = new SpazioProduzione(parseXML.leggiValoreMinimo("produzione")); 
		spazioRaccolta = new SpazioRaccolta(parseXML.leggiValoreMinimo("raccolta"));       
		
		SetRisorse risorseConsiglio = null; //XML
		spazioConsiglio = new SpazioConsiglio(parseXML.leggiValoreMinimo("consiglio"), risorseConsiglio);   
		  
		
		spaziMercato = new HashSet<SpazioMercato>();
		int valoreMinMercato = parseXML.leggiValoreMinimo("mercato");
		
		SpazioMercato spazioMercato1 = new SpazioMercato(valoreMinMercato, null);
		SpazioMercato spazioMercato2 = new SpazioMercato(valoreMinMercato, null);
		SpazioMercato spazioMercato3 = new SpazioMercato(valoreMinMercato, null);
		SpazioMercato spazioMercato4 = new SpazioMercato(valoreMinMercato, null);
		
		spaziMercato.add(spazioMercato1);
		spaziMercato.add(spazioMercato2);
		spaziMercato.add(spazioMercato3);
		spaziMercato.add(spazioMercato4);
		
		
		switch (numeroGiocatori) {
		
			case 4: //SpazioMercato spazio4 = XML;
			case 3: //SpazioMercato spazio3 = XML;
			case 2: //SpazioMercato spazio2 = XML;
					//SpazioMercato spazio1 = XML;
					break;
		}
		
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
