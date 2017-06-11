package it.polimi.ingsw.pc15.plancia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import it.polimi.ingsw.pc15.ParserXML;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.carte.Impresa;
import it.polimi.ingsw.pc15.carte.Personaggio;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

public class Plancia implements Serializable {
	
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
		
		int numeroSpaziTorre = ParserXML.leggiValore("numeroSpaziTorre");

		ArrayList risorseTorreVerde = new ArrayList<SetRisorse> (numeroSpaziTorre);
		ArrayList risorseTorreBlu = new ArrayList<SetRisorse> (numeroSpaziTorre);
		ArrayList risorseTorreGialla = new ArrayList<SetRisorse> (numeroSpaziTorre);
		ArrayList risorseTorreViola = new ArrayList<SetRisorse> (numeroSpaziTorre);
		
		for(int i=1; i<=numeroSpaziTorre; i++){
			risorseTorreVerde.add(ParserXML.leggiSetRisorseSpazio("verde"+Integer.toString(i))); 
			risorseTorreBlu.add(ParserXML.leggiSetRisorseSpazio("blu"+Integer.toString(i))); 
			risorseTorreGialla.add(ParserXML.leggiSetRisorseSpazio("giallo"+Integer.toString(i))); 
			risorseTorreViola.add(ParserXML.leggiSetRisorseSpazio("viola"+Integer.toString(i))); 
		}
		
		torreVerde = new Torre (numeroSpaziTorre, risorseTorreVerde);
		torreBlu = new Torre (numeroSpaziTorre, risorseTorreBlu);
		torreGialla = new Torre (numeroSpaziTorre, risorseTorreGialla);
		torreViola = new Torre (numeroSpaziTorre, risorseTorreViola);
		
		
		//-----------------------------------------------------------------------------------------------------------//
		//          SPAZI PRODUZIONE/RACCOLTA/CONSIGLIO                                                              //
		//-----------------------------------------------------------------------------------------------------------//
		
		spazioProduzione = new SpazioProduzione(ParserXML.leggiValore("valoreMinProduzione")); 
		spazioRaccolta = new SpazioRaccolta(ParserXML.leggiValore("valoreMinRaccolta"));       
		spazioConsiglio = new SpazioConsiglio(ParserXML.leggiValore("valoreMinConsiglio"), ParserXML.leggiSetRisorseSpazio("consiglio"));   
		
		  
		//-----------------------------------------------------------------------------------------------------------//
		//           SPAZI MERCATO                                                                                   //
		//-----------------------------------------------------------------------------------------------------------//
		
		spaziMercato = new ArrayList<SpazioMercato>();
		int valoreMinMercato = ParserXML.leggiValore("valoreMinMercato");
		
		switch (numeroGiocatori) {
			
			case 4: SpazioMercato spazioMercato4 = new SpazioMercato(valoreMinMercato, ParserXML.leggiSetRisorseSpazio("mercato4"));
					spaziMercato.add(spazioMercato4);
			case 3: SpazioMercato spazioMercato3 = new SpazioMercato(valoreMinMercato, ParserXML.leggiSetRisorseSpazio("mercato3"));
					spaziMercato.add(spazioMercato3);
			case 2: SpazioMercato spazioMercato2 = new SpazioMercato(valoreMinMercato, ParserXML.leggiSetRisorseSpazio("mercato2"));
					SpazioMercato spazioMercato1 = new SpazioMercato(valoreMinMercato, ParserXML.leggiSetRisorseSpazio("mercato1"));
					spaziMercato.add(spazioMercato2);
					spaziMercato.add(spazioMercato1);
					break;
		}
		
		
		//-----------------------------------------------------------------------------------------------------------//
		//          TESSERE SCOMUNICA                                                                                //
		//-----------------------------------------------------------------------------------------------------------//
		
		this.scomuniche = new HashMap<Integer, TesseraScomunica>();
		
		int numeroTessereScomunica = ParserXML.leggiValore("numeroPeriodi");
		for (int i=1; i<=numeroTessereScomunica; i++) {
			scomuniche.put(i, ParserXML.leggiScomunica(i));
		}
			
	}

	public void setCarte (int periodo, ArrayList<Carta> carteTerritorio, ArrayList<Carta> cartePersonaggio, ArrayList<Carta> carteEdificio, ArrayList<Carta> carteImpresa){

		ArrayList arrayTerritori = new ArrayList<Territorio>();             
		ArrayList arrayPersonaggi = new ArrayList<Personaggio>();
		ArrayList arrayEdifici = new ArrayList<Edificio>();
		ArrayList arrayImprese = new ArrayList<Impresa>();
		
		int n;
		int numeroSpaziTorre = ParserXML.leggiValore("numeroSpaziTorre");
		//System.out.println("Il numero di spazi torre è " + numeroSpaziTorre);
		
		n=0;
		for(int i=0; i<carteTerritorio.size(); i++) {
			Carta carta = carteTerritorio.get(i);
			if(carta.getPeriodo()==periodo && n<numeroSpaziTorre) {
				arrayTerritori.add(carta);
				carteTerritorio.remove(carta);
				n++;
			}
		}
		
		n=0;
		for(int i=0; i<cartePersonaggio.size(); i++) {
			Carta carta = cartePersonaggio.get(i);
			if(carta.getPeriodo()==periodo && n<numeroSpaziTorre) {
				arrayPersonaggi.add(carta);
				cartePersonaggio.remove(carta);
				n++;
			}
		}
		
		n=0;
		for(int i=0; i<carteEdificio.size(); i++) {
			Carta carta = carteEdificio.get(i);
			if(carta.getPeriodo()==periodo && n<numeroSpaziTorre) {
				arrayEdifici.add(carta);
				carteEdificio.remove(carta);
				n++;
			}
		}
		
		n=0;
		for(int i=0; i<carteImpresa.size(); i++) {
			Carta carta = carteImpresa.get(i);
			if(carta.getPeriodo()==periodo && n<numeroSpaziTorre) {
				arrayImprese.add(carta);
				carteImpresa.remove(carta);
				n++;
			}
		}

 		this.torreVerde.setTorre(arrayTerritori);
 		this.torreBlu.setTorre(arrayPersonaggi);
 		this.torreGialla.setTorre(arrayEdifici);
 		this.torreViola.setTorre(arrayImprese);
		
	}
	
	public void libera() {
		
		for (SpazioTorre spazioTorre : torreVerde.getSpaziTorre())
			spazioTorre.rimuoviFamiliari();
		for (SpazioTorre spazioTorre : torreBlu.getSpaziTorre())
			spazioTorre.rimuoviFamiliari();
		for (SpazioTorre spazioTorre : torreGialla.getSpaziTorre())
			spazioTorre.rimuoviFamiliari();
		for (SpazioTorre spazioTorre : torreViola.getSpaziTorre())
			spazioTorre.rimuoviFamiliari();
		
		spazioProduzione.rimuoviFamiliari();
		spazioRaccolta.rimuoviFamiliari();
		spazioConsiglio.rimuoviFamiliari();
		
		for (SpazioMercato spazioMercato : spaziMercato)
			spazioMercato.rimuoviFamiliari();
		
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
	
	public ArrayList<SpazioMercato> getSpaziMercato() {
		return this.spaziMercato;
	}
	
	public SpazioTorre getSpazioTorre (TipoCarta tipo, int numeroSpazio) {
		
		switch (tipo) {
		
		case TERRITORIO: return torreVerde.getSpazio(numeroSpazio);
		case PERSONAGGIO: return torreBlu.getSpazio(numeroSpazio);
		case EDIFICIO: return torreGialla.getSpazio(numeroSpazio);
		case IMPRESA: return torreViola.getSpazio(numeroSpazio);		
		default: return null;
		
		}
	}
	
	public TesseraScomunica getTesseraScomunica(int periodo) {
		return scomuniche.get(periodo);
	}
	
	public HashMap<Integer, TesseraScomunica> getScomuniche() {
		return this.scomuniche;
	}
	
	



	
	
	
	
	
}
