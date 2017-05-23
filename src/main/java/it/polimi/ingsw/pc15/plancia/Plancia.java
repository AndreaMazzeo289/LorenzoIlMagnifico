package it.polimi.ingsw.pc15.plancia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import it.polimi.ingsw.pc15.ParseXML;
import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.carte.Impresa;
import it.polimi.ingsw.pc15.carte.Personaggio;
import it.polimi.ingsw.pc15.carte.Territorio;

public class Plancia {
	
	private Torre torreVerde;
	private Torre torreBlu;
	private Torre torreGialla;
	private Torre torreViola;
	
	private SpazioProduzione spazioProduzione;
	private SpazioRaccolta spazioRaccolta;
	private SpazioConsiglio spazioConsiglio;
	private ArrayList spaziMercato;
	
	public Plancia (int numeroGiocatori) {
		
		//-----------------------------------------------------------------------------------------------------------//
		//          SPAZI TORRE                                                                                      //
		//-----------------------------------------------------------------------------------------------------------//
		
		int numeroSpaziTorre = ParseXML.leggiValore("numeroSpaziTorre");

		ArrayList risorseTorreVerde = new ArrayList(numeroSpaziTorre);
		ArrayList risorseTorreBlu = new ArrayList(numeroSpaziTorre);
		ArrayList risorseTorreGialla = new ArrayList(numeroSpaziTorre);
		ArrayList risorseTorreViola = new ArrayList(numeroSpaziTorre);
		
		for(int i=0; i<numeroSpaziTorre; i++){
			risorseTorreVerde.add(ParseXML.leggiSetRisorseSpazio("verde"+Integer.toString(i))); 
			risorseTorreBlu.add(ParseXML.leggiSetRisorseSpazio("blu"+Integer.toString(i))); 
			risorseTorreGialla.add(ParseXML.leggiSetRisorseSpazio("giallo"+Integer.toString(i))); 
			risorseTorreViola.add(ParseXML.leggiSetRisorseSpazio("viola"+Integer.toString(i))); 
		}
		
		torreVerde = new Torre (numeroSpaziTorre, risorseTorreVerde);
		torreBlu = new Torre (numeroSpaziTorre, risorseTorreBlu);
		torreGialla = new Torre (numeroSpaziTorre, risorseTorreGialla);
		torreViola = new Torre (numeroSpaziTorre, risorseTorreViola);
		
		
		//-----------------------------------------------------------------------------------------------------------//
		//          SPAZI PRODUZIONE/RACCOLTA/CONSIGLIO                                                              //
		//-----------------------------------------------------------------------------------------------------------//
		
		spazioProduzione = new SpazioProduzione(ParseXML.leggiValore("valoreMinProduzione")); 
		spazioRaccolta = new SpazioRaccolta(ParseXML.leggiValore("valoreMinRaccolta"));       
		spazioConsiglio = new SpazioConsiglio(ParseXML.leggiValore("valoreMinConsiglio"), ParseXML.leggiSetRisorseSpazio("consiglio"));   
		
		  
		//-----------------------------------------------------------------------------------------------------------//
		//           SPAZI MERCATO                                                                                   //
		//-----------------------------------------------------------------------------------------------------------//
		
		spaziMercato = new ArrayList();
		int valoreMinMercato = ParseXML.leggiValore("valoreMinMercato");
		
		switch (numeroGiocatori) {
		
			case 4: SpazioMercato spazioMercato4 = new SpazioMercato(valoreMinMercato, ParseXML.leggiSetRisorseSpazio("mercato4"));
					spaziMercato.add(spazioMercato4);
			case 3: SpazioMercato spazioMercato3 = new SpazioMercato(valoreMinMercato, ParseXML.leggiSetRisorseSpazio("mercato3"));
					spaziMercato.add(spazioMercato3);
			case 2: SpazioMercato spazioMercato2 = new SpazioMercato(valoreMinMercato, ParseXML.leggiSetRisorseSpazio("mercato2"));
					SpazioMercato spazioMercato1 = new SpazioMercato(valoreMinMercato, ParseXML.leggiSetRisorseSpazio("mercato1"));
					spaziMercato.add(spazioMercato2);
					spaziMercato.add(spazioMercato1);
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
		int numeroSpaziTorre = ParseXML.leggiValore("numeroSpaziTorri");
		
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
	
	public ArrayList getSpaziMercato() {
		return this.spaziMercato;
	}



	
	
	
	
	
}
