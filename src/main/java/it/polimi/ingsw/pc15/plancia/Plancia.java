package it.polimi.ingsw.pc15.plancia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import it.polimi.ingsw.pc15.ParseXML;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.ColoreCarta;
import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.carte.Impresa;
import it.polimi.ingsw.pc15.carte.Personaggio;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

public class Plancia {
	
	private Torre torreVerde;
	private Torre torreBlu;
	private Torre torreGialla;
	private Torre torreViola;
	
	private SpazioProduzione spazioProduzione;
	private SpazioRaccolta spazioRaccolta;
	private SpazioConsiglio spazioConsiglio;
	private ArrayList<SpazioMercato> spaziMercato;
	
	private HashMap <Integer, TesseraScomunica> scomuniche;
	
	
	public Plancia (int numeroGiocatori) {
		
		//-----------------------------------------------------------------------------------------------------------//
		//          SPAZI TORRE                                                                                      //
		//-----------------------------------------------------------------------------------------------------------//
		
		int numeroSpaziTorre = ParseXML.leggiValore("numeroSpaziTorre");

		ArrayList risorseTorreVerde = new ArrayList<SetRisorse> (numeroSpaziTorre);
		ArrayList risorseTorreBlu = new ArrayList<SetRisorse> (numeroSpaziTorre);
		ArrayList risorseTorreGialla = new ArrayList<SetRisorse> (numeroSpaziTorre);
		ArrayList risorseTorreViola = new ArrayList<SetRisorse> (numeroSpaziTorre);
		
		for(int i=1; i<=numeroSpaziTorre; i++){
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
		
		spaziMercato = new ArrayList<SpazioMercato>();
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
		
		
		//-----------------------------------------------------------------------------------------------------------//
		//          TESSERE SCOMUNICA                                                                                //
		//-----------------------------------------------------------------------------------------------------------//
		
		this.scomuniche = new HashMap<Integer, TesseraScomunica>();
		
		int numeroTessereScomunica = ParseXML.leggiValore("numeroPeriodi");
		for (int i=1; i<=numeroTessereScomunica; i++)
			//scomuniche.put(i, ParseXML.leggiScomunica(i))
			;
			
	}

	public void setTurno (int periodo, ArrayList<Carta> arrayCarteTerritorio, ArrayList<Carta> arrayCartePersonaggio, ArrayList<Carta> arrayCarteEdificio, ArrayList<Carta> arrayCarteImpresa){

		ArrayList arrayTerritori = new ArrayList<Territorio>();             
		ArrayList arrayPersonaggi = new ArrayList<Personaggio>();
		ArrayList arrayEdifici = new ArrayList<Edificio>();
		ArrayList arrayImprese = new ArrayList<Impresa>();
		
		int n;
		int numeroSpaziTorre = ParseXML.leggiValore("numeroSpaziTorre");
		
		n=0;
		for(int i=0; i<arrayCarteTerritorio.size(); i++) {
			Carta carta = arrayCarteTerritorio.get(i);
			if(carta.getPeriodo()==periodo && n<numeroSpaziTorre) {
				arrayTerritori.add(carta);
				arrayCarteTerritorio.remove(carta);
				n++;
			}
		}
		
		n=0;
		for(int i=0; i<arrayCartePersonaggio.size(); i++) {
			Carta carta = arrayCartePersonaggio.get(i);
			if(carta.getPeriodo()==periodo && n<numeroSpaziTorre) {
				arrayPersonaggi.add(carta);
				arrayCartePersonaggio.remove(carta);
				n++;
			}
		}
		
		n=0;
		for(int i=0; i<arrayCarteEdificio.size(); i++) {
			Carta carta = arrayCarteEdificio.get(i);
			if(carta.getPeriodo()==periodo && n<numeroSpaziTorre) {
				arrayEdifici.add(carta);
				arrayCarteEdificio.remove(carta);
				n++;
			}
		}
		
		n=0;
		for(int i=0; i<arrayCarteImpresa.size(); i++) {
			Carta carta = arrayCarteImpresa.get(i);
			if(carta.getPeriodo()==periodo && n<numeroSpaziTorre) {
				arrayImprese.add(carta);
				arrayCarteImpresa.remove(carta);
				n++;
			}
		}

 		this.torreVerde.setTorre(arrayTerritori);
 		this.torreBlu.setTorre(arrayPersonaggi);
 		this.torreGialla.setTorre(arrayEdifici);
 		this.torreViola.setTorre(arrayImprese);
		
	}
	
	
	//-----------------------------------------------------------------------------------------------------------//
	//          METODI GET                                                                                       //
	//-----------------------------------------------------------------------------------------------------------//
	
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
	
	public SpazioTorre getSpazioTorre (ColoreCarta colore, int numeroSpazio) {
		
		switch (colore) {
		
		case VERDE: return torreVerde.getSpazio(numeroSpazio);
		case BLU: return torreBlu.getSpazio(numeroSpazio);
		case GIALLO: return torreGialla.getSpazio(numeroSpazio);
		case VIOLA: return torreViola.getSpazio(numeroSpazio);		
		default: return null;
		
		}
	}
	
	public TesseraScomunica getTesseraScomunica(int periodo) {
		return scomuniche.get(periodo);
	}
	
	



	
	
	
	
	
}
