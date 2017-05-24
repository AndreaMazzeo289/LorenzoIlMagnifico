package it.polimi.ingsw.pc15.plancia;

import java.util.ArrayList;
import java.util.Collections;
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
	
	public Plancia (int numeroGiocatori) {
		
		//-----------------------------------------------------------------------------------------------------------//
		//          SPAZI TORRE                                                                                      //
		//-----------------------------------------------------------------------------------------------------------//
		
		int numeroSpaziTorre = ParseXML.leggiValore("numeroSpaziTorre");

		ArrayList risorseTorreVerde = new ArrayList<SetRisorse> (numeroSpaziTorre);
		ArrayList risorseTorreBlu = new ArrayList<SetRisorse> (numeroSpaziTorre);
		ArrayList risorseTorreGialla = new ArrayList<SetRisorse> (numeroSpaziTorre);
		ArrayList risorseTorreViola = new ArrayList<SetRisorse> (numeroSpaziTorre);
		
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
		
	}
	
	/**
	 * @param periodo
	 * @param setCarteTerritorio
	 * @param setCartePersonaggio
	 * @param setCarteEdificio
	 * @param setCarteImpresa
	 */
	public void setTurno (int periodo, ArrayList<Carta> arrayCarteTerritorio, ArrayList<Carta> arrayCartePersonaggio, ArrayList<Carta> arrayCarteEdificio, ArrayList<Carta> arrayCarteImpresa){
		
		ArrayList arrayTerritori = new ArrayList();
		ArrayList arrayPersonaggi = new ArrayList();
		ArrayList arrayEdifici = new ArrayList();
		ArrayList arrayImprese = new ArrayList();
		
		Iterator<Carta> territorio = arrayCarteTerritorio.iterator();
		Iterator<Carta> personaggio = arrayCartePersonaggio.iterator();
		Iterator<Carta> edificio = arrayCarteEdificio.iterator();
		Iterator<Carta> impresa = arrayCarteImpresa.iterator();
		
		int n = 0;
		int numeroSpaziTorre = ParseXML.leggiValore("numeroSpaziTorre");
		
		Collections.shuffle(arrayCarteTerritorio);
		Collections.shuffle(arrayCartePersonaggio);
		Collections.shuffle(arrayCarteEdificio);
		Collections.shuffle(arrayCarteImpresa);
		
		for(Carta carta : arrayCarteTerritorio) {
			if(carta.getPeriodo()==periodo && n<numeroSpaziTorre)
				arrayTerritori.add(carta);
				arrayCarteTerritorio.remove(carta);
				n++;
		}
		
		while (territorio.hasNext() && n < numeroSpaziTorre) {
			Carta territorioExt = territorio.next();
			if (territorioExt.getPeriodo() == periodo) {
				arrayTerritori.add(territorioExt);
				territorio.remove();
				n++;
			}
		}
		
		n=0;
		while (personaggio.hasNext() && n < numeroSpaziTorre) {
			Carta personaggioExt = personaggio.next();
			if (personaggioExt.getPeriodo() == periodo) {
				arrayPersonaggi.add(personaggioExt);
				personaggio.remove();
				n++;
			}			
		}
		
		n=0;
		while (edificio.hasNext() && n < numeroSpaziTorre) {
			Carta edificioExt = edificio.next();
			if (edificioExt.getPeriodo() == periodo) {
				arrayEdifici.add(edificioExt);
				edificio.remove();
				n++;
			}			
		}
		
		n=0;
		while (impresa.hasNext() && n < numeroSpaziTorre) {
			Carta impresaExt = impresa.next();
			if (impresaExt.getPeriodo() == periodo) {
				arrayImprese.add(impresaExt);
				impresa.remove();
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
	
	
	//-----------------------------------------------------------------------------------------------------------//
	//          GET SPAZI                                                                                   //
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
	
	



	
	
	
	
	
}
