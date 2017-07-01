package it.polimi.ingsw.pc15.plancia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import it.polimi.ingsw.pc15.ParserXML;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.carte.Impresa;
import it.polimi.ingsw.pc15.carte.Personaggio;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.risorse.Risorsa;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class Plancia implements Serializable {
	
	private HashMap<TipoCarta, Torre> torri;
	
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
		
		this.torri = new HashMap<TipoCarta, Torre>();
		torri.put(TipoCarta.TERRITORIO, new Torre (numeroSpaziTorre, risorseTorreVerde));
		torri.put(TipoCarta.PERSONAGGIO, new Torre (numeroSpaziTorre, risorseTorreBlu));
		torri.put(TipoCarta.EDIFICIO, new Torre (numeroSpaziTorre, risorseTorreGialla));
		torri.put(TipoCarta.IMPRESA, new Torre (numeroSpaziTorre, risorseTorreViola));
		
		
		
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

 		torri.get(TipoCarta.TERRITORIO).setTorre(arrayTerritori);
 		torri.get(TipoCarta.PERSONAGGIO).setTorre(arrayPersonaggi);
 		torri.get(TipoCarta.EDIFICIO).setTorre(arrayEdifici);
 		torri.get(TipoCarta.IMPRESA).setTorre(arrayImprese);
		
	}
	
	public void libera() {
		
		for(Map.Entry<TipoCarta, Torre> torre : torri.entrySet())
			torre.getValue().libera();
		
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
		return this.torri.get(tipo).getSpazio(numeroSpazio);
	}
	
	public Torre getTorre(TipoCarta tipo) {
		return this.torri.get(tipo);
	}
	
	public TesseraScomunica getTesseraScomunica(int periodo) {
		return scomuniche.get(periodo);
	}
	
	public HashMap<Integer, TesseraScomunica> getScomuniche() {
		return this.scomuniche;
	}
	



	
	
	
	
	
}
