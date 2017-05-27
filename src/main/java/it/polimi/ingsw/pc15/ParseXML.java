package it.polimi.ingsw.pc15;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.ColoreCarta;
import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.carte.Impresa;
import it.polimi.ingsw.pc15.carte.Personaggio;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.effetti.AggiuntaRisorse;
import it.polimi.ingsw.pc15.effetti.AnnullaGuadagno;
import it.polimi.ingsw.pc15.effetti.AnnullaRequisitoTerritori;
import it.polimi.ingsw.pc15.effetti.AnnullaSovrapprezzoTorri;
import it.polimi.ingsw.pc15.effetti.AumentaPrezzoServitori;
import it.polimi.ingsw.pc15.effetti.AumentaValoreFamiliare;
import it.polimi.ingsw.pc15.effetti.AzioneCarta;
import it.polimi.ingsw.pc15.effetti.AzioneProduzione;
import it.polimi.ingsw.pc15.effetti.AzioneRaccolto;
import it.polimi.ingsw.pc15.effetti.BonusDadoCarte;
import it.polimi.ingsw.pc15.effetti.BonusPVChiesa;
import it.polimi.ingsw.pc15.effetti.BonusProduzione;
import it.polimi.ingsw.pc15.effetti.BonusRaccolta;
import it.polimi.ingsw.pc15.effetti.BonusValoreFamiliare;
import it.polimi.ingsw.pc15.effetti.CopiaEffettoLeader;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.effetti.FissaValoreFamiliare;
import it.polimi.ingsw.pc15.effetti.FissaValoreFamiliareAScelta;
import it.polimi.ingsw.pc15.effetti.Moltiplicazione;
import it.polimi.ingsw.pc15.effetti.NegaMercato;
import it.polimi.ingsw.pc15.effetti.OccupaSpaziOccupati;
import it.polimi.ingsw.pc15.effetti.RisorsePerCarte;
import it.polimi.ingsw.pc15.effetti.RisorsePerRisorse;
import it.polimi.ingsw.pc15.effetti.SaltaPrimoTurno;
import it.polimi.ingsw.pc15.effetti.Scambio;
import it.polimi.ingsw.pc15.plancia.TesseraScomunica;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.Legna;
import it.polimi.ingsw.pc15.risorse.Oro;
import it.polimi.ingsw.pc15.risorse.Pietra;
import it.polimi.ingsw.pc15.risorse.Privilegi;
import it.polimi.ingsw.pc15.risorse.PuntiFede;
import it.polimi.ingsw.pc15.risorse.PuntiMilitari;
import it.polimi.ingsw.pc15.risorse.PuntiVittoria;
import it.polimi.ingsw.pc15.risorse.Risorsa;
import it.polimi.ingsw.pc15.risorse.Servitori;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

/**
 * Classe che permette la lettura da xml
 * @author AndreaMazzeo289
 * 
 */

public class ParseXML {
	
	public static void main (String args[]) {
		leggiScomunica(1);
		leggiScomunica(2);
		leggiScomunica(3);
	}
	
	
	/*public static void main (String args[]){
		leggiCartaLeader("Cesare Borgia");
		leggiCartaLeader("Ludovico Ariosto");
		leggiCartaLeader("Filippo Brunelleschi");
		leggiCartaLeader("Sigismondo Malatesta");
		leggiCartaLeader("Ludovico il Moro");
		leggiCartaLeader("Lucrezia Borgia");
		leggiCartaLeader("Lorenzo de’ Medici");
		leggiCartaLeader("Sisto IV");
		leggiCartaLeader("Santa Rita");
		leggiCartaLeader("Pico della mirandola");
		leggiCartaLeader("Francesco Sforza");
		leggiCartaLeader("Michelangelo Buonarroti");
		leggiCartaLeader("Giovanni dalle Bande Nere");
		leggiCartaLeader("Girolamo Savonarola");
		leggiCartaLeader("Leonardo da Vinci");
		leggiCartaLeader("Sandro Botticelli");
		leggiCartaLeader("Federico da Montefeltro");
		leggiCartaLeader("Cosimo de’ Medici");
		leggiCartaLeader("Bartolomeo Colleoni");
		leggiCartaLeader("Ludovico III Gonzaga");
	}*/
	
	//--------------------------------------------------------------------------------------------------------------//
	// GET CARTA XML
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che gestisce l'estrazione delle carte dal relativo file XML chiamando opportuni metodi per ogni tipologia di carta
	 * @param colore della carta che si vuole estrarre (enumerazione ColoreCarta)
	 * @return ArrayList di tutte le carte del colore desiderato
	 */
	public static ArrayList<Carta> getCartaXML (ColoreCarta coloreCarta){
		
		Carta cartaSelezionata = null;
		ArrayList<Carta> arrayCarte = new ArrayList<Carta>();
		
		try{
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			Document document = builder.parse(new File("XML/Cards_v1.4.xml"));
			
			NodeList carte = document.getElementsByTagName("carta");
			
			for(int i=0; i<carte.getLength(); i++){
				
				Element carta = (Element) carte.item(i);
					
				String colore = carta.getElementsByTagName("colore").item(0).getFirstChild().getNodeValue();
				
				if(colore.toUpperCase().equals(coloreCarta.toString())) {
					switch(coloreCarta.toString()){
						case "VERDE":
							cartaSelezionata = leggiCartaVerde(carta);
							break;
							
						case "GIALLO":
							cartaSelezionata = leggiCartaGialla(carta);
							break;
							
						case "BLU":
							cartaSelezionata = leggiCartaBlu(carta);
							break;
							
						case "VIOLA":
							cartaSelezionata = leggiCartaViola(carta);
							break;
						default: System.out.println("ERRORE NELLA SCRITTURA DEL FILE!");
					}
					arrayCarte.add(cartaSelezionata);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		
		return arrayCarte;
	}

	//--------------------------------------------------------------------------------------------------------------//
	// GET EFFETTO XML
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che gestisce l'estrazione degli effetti dal relativo file XML chiamando opportuni metodi per ogni tipologia di effetto
	 * @param nome dell'effetto che si vuole estrarre (String)
	 * @return Istanza dell'effetto estratto (Classe effetto)
	 */
	public static Effetto getEffettoXML (String nomeEffetto){
		
		Effetto effettoLetto = null;
		
		try{
			
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			Document document = builder.parse(new File("XML/Effects_v2.4.xml"));
			
			NodeList effetti = document.getElementsByTagName("effetto");
			
			for(int i=0; i<effetti.getLength(); i++){
				
				Element effetto = (Element) effetti.item(i);
				
				String nome = effetto.getAttribute("nome");
				if(nome.equals(nomeEffetto)){
					
					String tipoEffetto = effetto.getAttribute("idEffetto");
					
					switch(tipoEffetto){
					 	case "addRisorsa":
					 		effettoLetto = leggiEffettoAddRisorsa(effetto);
					 		break;
					 		
					 	case "azione":
					 		
					 		String tipoAzione = effetto.getAttribute("idAzione");
							switch(tipoAzione){
								case "raccolta": 
									effettoLetto = leggiEffettoAzioneRaccolto(effetto);
									break;
								case "produzione": 
									effettoLetto = leggiEffettoAzioneProduzione(effetto);
									break;
								case "carta": 
									effettoLetto = leggiEffettoAzioneCarta(effetto);
									break;
							}
							break;
							
					 	case "moltiplicazione":
					 		effettoLetto = leggiEffettoMoltiplicazione(effetto);
					 		break;
					 	case "scambio":
					 		effettoLetto = leggiEffettoScambio(effetto);
					 		break;
					 	case "bonus":
					 		
					 		String tipoBonus = effetto.getAttribute("idAzione");
							switch(tipoBonus){
								case "raccolta": 
									effettoLetto = leggiEffettoBonusRaccolta(effetto);
									break;
								case "produzione": 
									effettoLetto = leggiEffettoBonusProduzione(effetto);
									break;
								case "carta": 
									effettoLetto = leggiEffettoBonusDadoCarta(effetto);
									break;
								case "familiare": 
									effettoLetto = leggiEffettoBonusValoreFamiliare(effetto);
									break;
							}
							break;
					 	case "fissaFamiliare":
					 		effettoLetto = leggiEffettoFissaValoreFamiliare(effetto);
					 	case "negaMercato":
					 		effettoLetto = leggiEffettoNegaMercato();
					 		break;
					 	case "perditaPrimoTurno":
					 		effettoLetto = leggiEffettoSaltaPrimoTurno();
					 		break;
					 	case "prezzoServitori":
					 		effettoLetto = leggiEffettoAumentaPrezzoServitori();
					 		break;
					 	case "annullaGuadagno":
					 		effettoLetto = leggiEffettoAnnullaGuadagno(effetto);
					 		break;
					 	case "spaziOccupati":
					 		effettoLetto = leggiEffettoOccupaSpaziOccupati();
					 		break;
					 	case "copia":
					 		effettoLetto = leggiEffettoCopiaEffettoLeader();
					 		break;
					 	case "sovrapprezzo":
					 		effettoLetto = leggiEffettoBonusPVChiesa(effetto);
					 		break;
					 	case "fede":
					 		effettoLetto = leggiEffettoAnnullaSovrapprezzoTorri();
					 		break;
							
					 	default:
					 		System.out.println("Errore: effetto non presente");
					}
				}
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return effettoLetto;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI EFFETTO ADD RISORSA
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre gli effetti di tipo AddRisorsa dal file XML
	 * @param elemento dell'effetto specifico da estrarre (Classe Element)
	 * @return istanza dell'effetto estratto (Classe AggiuntaRisorse)
	 */
	public static AggiuntaRisorse leggiEffettoAddRisorsa(Element effetto) {
		
		Legna legna = new Legna (Integer.parseInt(effetto.getElementsByTagName("legno").item(0).getFirstChild().getNodeValue()));
		Pietra pietra = new Pietra (Integer.parseInt(effetto.getElementsByTagName("pietra").item(0).getFirstChild().getNodeValue()));
		Oro oro = new Oro (Integer.parseInt(effetto.getElementsByTagName("oro").item(0).getFirstChild().getNodeValue()));
		Servitori servitori = new Servitori (Integer.parseInt(effetto.getElementsByTagName("servitori").item(0).getFirstChild().getNodeValue()));
		PuntiFede puntiFede = new PuntiFede (Integer.parseInt(effetto.getElementsByTagName("puntiFede").item(0).getFirstChild().getNodeValue()));
		PuntiMilitari puntiMilitari = new PuntiMilitari (Integer.parseInt(effetto.getElementsByTagName("puntiMilitari").item(0).getFirstChild().getNodeValue()));
		PuntiVittoria puntiVittoria = new PuntiVittoria (Integer.parseInt(effetto.getElementsByTagName("puntiVittoria").item(0).getFirstChild().getNodeValue()));
		Privilegi privilegi = new Privilegi (Integer.parseInt(effetto.getElementsByTagName("privilegi").item(0).getFirstChild().getNodeValue()));
        
        HashSet<Risorsa> risorse = new HashSet<>();
        
        risorse.add(legna);
        risorse.add(pietra);
        risorse.add(oro);
        risorse.add(servitori);
        risorse.add(puntiFede);
        risorse.add(puntiMilitari);
        risorse.add(puntiVittoria);
        risorse.add(privilegi);
               
        SetRisorse setRisorse = new SetRisorse (risorse);
        
		AggiuntaRisorse aggiuntaRisorse = new AggiuntaRisorse(setRisorse);	
		return aggiuntaRisorse;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI EFFETTO AZIONE RACCOLTO
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre gli effetti di tipo azione raccolto dal file XML
	 * @param elemento dell'effetto specifico da estrarre (Classe Element)
	 * @return istanza dell'effetto estratto (Classe AzioneRaccolto)
	 */
	public static AzioneRaccolto leggiEffettoAzioneRaccolto (Element effetto) {
		
		int valoreDadoRaccolta = Integer.parseInt(effetto.getElementsByTagName("valoreDado").item(0).getFirstChild().getNodeValue());
		
		AzioneRaccolto azioneRaccolto = new AzioneRaccolto (valoreDadoRaccolta);
		return azioneRaccolto;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI EFFETTO AZIONE PRODUZIONE
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre gli effetti di tipo azione produzione dal file XML
	 * @param elemento dell'effetto specifico da estrarre (Classe Element)
	 * @return istanza dell'effetto estratto (Classe AzioneProduzione)
	 */
	public static AzioneProduzione leggiEffettoAzioneProduzione (Element effetto) {
			
		int valoreDadoProduzione = Integer.parseInt(effetto.getElementsByTagName("valoreDado").item(0).getFirstChild().getNodeValue());
			
		AzioneProduzione azioneProduzione = new AzioneProduzione (valoreDadoProduzione);
		return azioneProduzione;
	}

	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI EFFETTO AZIONE CARTA
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre gli effetti di tipo azione carta dal file XML
	 * @param elemento dell'effetto specifico da estrarre (Classe Element)
	 * @return istanza dell'effetto estratto (Classe AzioneCarta)
	 */
	public static AzioneCarta leggiEffettoAzioneCarta (Element effetto) {
		
		int valoreDadoCarta = Integer.parseInt(effetto.getElementsByTagName("valoreDado").item(0).getFirstChild().getNodeValue());
		String coloreCarta = effetto.getElementsByTagName("coloreCarta").item(0).getFirstChild().getNodeValue();
		
		ColoreCarta coloreCartaEnum = null;
		switch(coloreCarta.toUpperCase()){
			case "VERDE": 
				coloreCartaEnum = ColoreCarta.VERDE;
				break;
			case "BLU": 
				coloreCartaEnum = ColoreCarta.BLU;
				break;
			case "GIALLO": 
				coloreCartaEnum = ColoreCarta.GIALLO;
				break;
			case "VIOLA": 
				coloreCartaEnum = ColoreCarta.VIOLA;
				break;
			case "ALL": 
				coloreCartaEnum = ColoreCarta.ALL;
		}
		
		AzioneCarta azioneCarta = new AzioneCarta (valoreDadoCarta, coloreCartaEnum);
		return azioneCarta;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI EFFETTO MOLTIPLICAZIONE
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre gli effetti di tipo moltiplicazione dal file XML
	 * @param elemento dell'effetto specifico da estrarre (Classe Element)
	 * @return istanza dell'effetto estratto (Classe Moltiplicazione)
	 */
	public static Moltiplicazione leggiEffettoMoltiplicazione(Element effetto) {
		
		String tipoRisorsa = effetto.getElementsByTagName("tipoRisorsa").item(0).getFirstChild().getNodeValue();
		
		int quantita = Integer.parseInt(effetto.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue());
		int numLegno = Integer.parseInt(effetto.getElementsByTagName("legno").item(0).getFirstChild().getNodeValue());
		int numPietra = Integer.parseInt(effetto.getElementsByTagName("pietra").item(0).getFirstChild().getNodeValue());
		int numOro = Integer.parseInt(effetto.getElementsByTagName("oro").item(0).getFirstChild().getNodeValue());
		int numServitori = Integer.parseInt(effetto.getElementsByTagName("servitori").item(0).getFirstChild().getNodeValue());
		int numPuntiFede = Integer.parseInt(effetto.getElementsByTagName("puntiFede").item(0).getFirstChild().getNodeValue());
		int numPuntiMilitari = Integer.parseInt(effetto.getElementsByTagName("puntiMilitari").item(0).getFirstChild().getNodeValue());
		int numPuntiVittoria = Integer.parseInt(effetto.getElementsByTagName("puntiVittoria").item(0).getFirstChild().getNodeValue());
		int numPrivilegi = Integer.parseInt(effetto.getElementsByTagName("privilegi").item(0).getFirstChild().getNodeValue());
		
		Legna legna = new Legna (numLegno);
		Pietra pietra = new Pietra (numPietra);
		Oro oro = new Oro (numOro);
		Servitori servitori = new Servitori (numServitori);
		PuntiFede puntiFede = new PuntiFede (numPuntiFede);
		PuntiMilitari puntiMilitari = new PuntiMilitari (numPuntiMilitari);
		PuntiVittoria puntiVittoria = new PuntiVittoria (numPuntiVittoria);
		Privilegi privilegi = new Privilegi (numPrivilegi);
        
        HashSet<Risorsa> risorse = new HashSet<>();
        
        risorse.add(legna);
        risorse.add(pietra);
        risorse.add(oro);
        risorse.add(servitori);
        risorse.add(puntiFede);
        risorse.add(puntiMilitari);
        risorse.add(puntiVittoria);
        risorse.add(privilegi);
               
        SetRisorse setRisorse = new SetRisorse (risorse);
        
        TipoRisorsa tipoRisorsaEnum = null;
        ColoreCarta coloreCartaEnum = null;
        switch(tipoRisorsa.toUpperCase()){
	        case "LEGNA": tipoRisorsaEnum = TipoRisorsa.LEGNA;
	        	break;
	        case "PIETRA": tipoRisorsaEnum = TipoRisorsa.PIETRA;
	    		break;
	        case "ORO": tipoRisorsaEnum = TipoRisorsa.ORO;
	    		break;
	        case "SERVITORI": tipoRisorsaEnum = TipoRisorsa.SERVITORI;
	    		break;
	        case "PUNTIFEDE": tipoRisorsaEnum = TipoRisorsa.PUNTIFEDE;
	    		break;
	        case "PUNTIMILITARI": tipoRisorsaEnum = TipoRisorsa.PUNTIMILITARI;
	    		break;
	        case "PUNTIVITTORIA": tipoRisorsaEnum = TipoRisorsa.PUNTIVITTORIA;
	    		break;
	        case "PRIVILEGI": tipoRisorsaEnum = TipoRisorsa.PRIVILEGI;
	    		break;
	        case "CARTAGIALLA": coloreCartaEnum = ColoreCarta.GIALLO;
	        	break;
	        case "CARTABLU": coloreCartaEnum = ColoreCarta.BLU;
        		break;
	        case "CARTAVERDE": coloreCartaEnum = ColoreCarta.VERDE;
        		break;
	        case "CARTAVIOLA": coloreCartaEnum = ColoreCarta.VIOLA;
        		break;	
        }
        
        Moltiplicazione moltiplicazione=null; 
        if(tipoRisorsaEnum==null && coloreCartaEnum != null)
        	moltiplicazione = new RisorsePerCarte(setRisorse, quantita, coloreCartaEnum);
        if(tipoRisorsaEnum!=null && coloreCartaEnum == null)
        	moltiplicazione = new RisorsePerRisorse(setRisorse, quantita, tipoRisorsaEnum);
        
		return moltiplicazione;
	}

	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI EFFETTO SCAMBIO
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre gli effetti di tipo scambio dal file XML
	 * @param elemento dell'effetto specifico da estrarre (Classe Element)
	 * @return istanza dell'effetto estratto (Classe Scambio)
	 */
	public static Scambio leggiEffettoScambio(Element effetto) {
		
		NodeList setRisorse = effetto.getElementsByTagName("setRisorse");
		SetRisorse pagamento = null;
		SetRisorse pagamento2 = null;
		SetRisorse guadagno = null;
		SetRisorse guadagno2 = null;
		
		for(int i=0; i<setRisorse.getLength(); ++i) {
			Element SingoloCosto = (Element) setRisorse.item(i);
			
			Legna legna = new Legna (Integer.parseInt(effetto.getElementsByTagName("legno").item(0).getFirstChild().getNodeValue()));
			Pietra pietra = new Pietra (Integer.parseInt(effetto.getElementsByTagName("pietra").item(0).getFirstChild().getNodeValue()));
			Oro oro = new Oro (Integer.parseInt(effetto.getElementsByTagName("oro").item(0).getFirstChild().getNodeValue()));
			Servitori servitori = new Servitori (Integer.parseInt(effetto.getElementsByTagName("servitori").item(0).getFirstChild().getNodeValue()));
			PuntiFede puntiFede = new PuntiFede (Integer.parseInt(effetto.getElementsByTagName("puntiFede").item(0).getFirstChild().getNodeValue()));
			PuntiMilitari puntiMilitari = new PuntiMilitari (Integer.parseInt(effetto.getElementsByTagName("puntiMilitari").item(0).getFirstChild().getNodeValue()));
			PuntiVittoria puntiVittoria = new PuntiVittoria (Integer.parseInt(effetto.getElementsByTagName("puntiVittoria").item(0).getFirstChild().getNodeValue()));
			Privilegi privilegi = new Privilegi (Integer.parseInt(effetto.getElementsByTagName("privilegi").item(0).getFirstChild().getNodeValue()));
            
            HashSet<Risorsa> risorse = new HashSet<>();
            
            risorse.add(legna);
            risorse.add(pietra);
            risorse.add(oro);
            risorse.add(servitori);
            risorse.add(puntiFede);
            risorse.add(puntiMilitari);
            risorse.add(puntiVittoria);
            risorse.add(privilegi);
            
            switch(SingoloCosto.getAttribute("id")){
			case "pagamento":
				pagamento = new SetRisorse (risorse);
				break;
			case "guadagno":
				guadagno = new SetRisorse (risorse);
				break;
			case "pagamento2":
				pagamento2 = new SetRisorse (risorse);
				break;
			case "guadagno2":
				guadagno2 = new SetRisorse (risorse);
				break;
			default:
            }
		}
		
		Scambio scambio = new Scambio (pagamento, guadagno, pagamento2, guadagno2);
		return scambio;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI BONUS RACCOLTA
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre gli effetti di tipo bonus raccolta dal file XML
	 * @param elemento dell'effetto specifico da estrarre (Classe Element)
	 * @return istanza dell'effetto estratto (Classe BonusRaccolta)
	 */
	public static BonusRaccolta leggiEffettoBonusRaccolta (Element effetto)
	{
		int valoreDadoRaccolta = Integer.parseInt(effetto.getElementsByTagName("bonusDado").item(0).getFirstChild().getNodeValue());
		
		BonusRaccolta bonusRaccolta = new BonusRaccolta (valoreDadoRaccolta);
		return bonusRaccolta;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI BONUS PRODUZIONE
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre gli effetti di tipo bonus produzione dal file XML
	 * @param elemento dell'effetto specifico da estrarre (Classe Element)
	 * @return istanza dell'effetto estratto (Classe BonusProduzione)
	 */
	public static BonusProduzione leggiEffettoBonusProduzione (Element effetto)
	{
		int valoreDadoProduzione = Integer.parseInt(effetto.getElementsByTagName("bonusDado").item(0).getFirstChild().getNodeValue());
		
		BonusProduzione bonusProduzione = new BonusProduzione (valoreDadoProduzione);
		return bonusProduzione;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI BONUS DADO CARTE
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre gli effetti di tipo bonus dado carta dal file XML
	 * @param elemento dell'effetto specifico da estrarre (Classe Element)
	 * @return istanza dell'effetto estratto (Classe BonusDadoCarte)
	 */
	public static BonusDadoCarte leggiEffettoBonusDadoCarta (Element effetto)
	{
		int valoreDadoCarta = Integer.parseInt(effetto.getElementsByTagName("bonusDado").item(0).getFirstChild().getNodeValue());
		String coloreCarta = effetto.getElementsByTagName("coloreCarta").item(0).getFirstChild().getNodeValue();
		
		ColoreCarta coloreCartaEnum = null;
		switch(coloreCarta.toUpperCase()){
			case "VERDE": 
				coloreCartaEnum = ColoreCarta.VERDE;
				break;
			case "BLU": 
				coloreCartaEnum = ColoreCarta.BLU;
				break;
			case "GIALLO": 
				coloreCartaEnum = ColoreCarta.GIALLO;
				break;
			case "VIOLA": 
				coloreCartaEnum = ColoreCarta.VIOLA;
				break;
			case "ALL": 
				coloreCartaEnum = ColoreCarta.ALL;
		}
		
		BonusDadoCarte bonusDadoCarte = new BonusDadoCarte(coloreCartaEnum, valoreDadoCarta);
		return bonusDadoCarte;
	}

	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI EFFETTO BONUS VALORE FAMILIARE
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre gli effetti di tipo bonus valore familiare dal file XML
	 * @param elemento dell'effetto specifico da estrarre (Classe Element)
	 * @return istanza dell'effetto estratto (Classe BonusValoreFamiliare)
	 */
	public static BonusValoreFamiliare leggiEffettoBonusValoreFamiliare (Element effetto)
	{
		int valoreFamiliare = Integer.parseInt(effetto.getElementsByTagName("bonusDado").item(0).getFirstChild().getNodeValue());
		String coloreFamiliare = effetto.getElementsByTagName("coloreFamiliare").item(0).getFirstChild().getNodeValue();
		ColoreFamiliare coloreFamiliareEnum = null;
			
		switch(coloreFamiliare.toUpperCase()){
			case "NERO": 
				coloreFamiliareEnum = ColoreFamiliare.NERO;
				break;
			case "BIANCO": 
				coloreFamiliareEnum = ColoreFamiliare.BIANCO;
				break;
			case "ARANCIONE": 
				coloreFamiliareEnum = ColoreFamiliare.ARANCIONE;
				break;
			case "NEUTRO":
				coloreFamiliareEnum = ColoreFamiliare.NEUTRO;
				break;
		}
		
		BonusValoreFamiliare bonusValoreFamiliare = new BonusValoreFamiliare(coloreFamiliareEnum, valoreFamiliare);
		return bonusValoreFamiliare;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI EFFETTO FISSA VALORE FAMILIARE
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre gli effetti di tipo bonus valore familiare dal file XML
	 * @param elemento dell'effetto specifico da estrarre (Classe Element)
	 * @return istanza dell'effetto estratto (Classe BonusValoreFamiliare)
	 */
	public static FissaValoreFamiliare leggiEffettoFissaValoreFamiliare (Element effetto)
	{
		int valoreFamiliare = Integer.parseInt(effetto.getElementsByTagName("bonusDado").item(0).getFirstChild().getNodeValue());
		String scelta = effetto.getAttribute("scelta");
		FissaValoreFamiliare fissaValoreFamiliare;
		
		if(scelta.equals("no")) {
			String coloreFamiliare = effetto.getElementsByTagName("coloreFamiliare").item(0).getFirstChild().getNodeValue();
			ColoreFamiliare coloreFamiliareEnum = null;
				
			switch(coloreFamiliare.toUpperCase()){
				case "NERO": 
					coloreFamiliareEnum = ColoreFamiliare.NERO;
					break;
				case "BIANCO": 
					coloreFamiliareEnum = ColoreFamiliare.BIANCO;
					break;
				case "ARANCIONE": 
					coloreFamiliareEnum = ColoreFamiliare.ARANCIONE;
					break;
				case "NEUTRO":
					coloreFamiliareEnum = ColoreFamiliare.NEUTRO;
					break;
			}
			fissaValoreFamiliare = new FissaValoreFamiliare (coloreFamiliareEnum, valoreFamiliare);
		}
		else
			fissaValoreFamiliare = new FissaValoreFamiliareAScelta(valoreFamiliare);
		
		return fissaValoreFamiliare;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI EFFETTO NEGAZIONE MERCATO
	//--------------------------------------------------------------------------------------------------------------//
	public static NegaMercato leggiEffettoNegaMercato () {
		NegaMercato negaMercato = new NegaMercato ();
		return negaMercato;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI EFFETTO SALTA PRIMO TURNO
	//--------------------------------------------------------------------------------------------------------------//
	public static SaltaPrimoTurno leggiEffettoSaltaPrimoTurno () {
		SaltaPrimoTurno saltaPrimoTurno = new SaltaPrimoTurno ();
		return saltaPrimoTurno;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI EFFETTO AUMENTA PREZZO SERVITORI
	//--------------------------------------------------------------------------------------------------------------//
	public static AumentaPrezzoServitori leggiEffettoAumentaPrezzoServitori () {
		AumentaPrezzoServitori aumentaPrezzoServitori = new AumentaPrezzoServitori ();
		return aumentaPrezzoServitori;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI EFFETTO ANNULLA SOVRAPPREZZO TORRI
	//--------------------------------------------------------------------------------------------------------------//
	public static AnnullaSovrapprezzoTorri leggiEffettoAnnullaSovrapprezzoTorri () {
		AnnullaSovrapprezzoTorri annullaSovrapprezzoTorri = new AnnullaSovrapprezzoTorri ();
		return annullaSovrapprezzoTorri;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI EFFETTO ANNULLA REQUISITO TERRITORI
	//--------------------------------------------------------------------------------------------------------------//
	public static AnnullaRequisitoTerritori leggiEffettoAnnullaRequisitoTerritori () {
		AnnullaRequisitoTerritori annullaRequisitoTerritori = new AnnullaRequisitoTerritori ();
		return annullaRequisitoTerritori;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI EFFETTO OCCUPA SPAZI OCCUPATI
	//--------------------------------------------------------------------------------------------------------------//
	public static OccupaSpaziOccupati leggiEffettoOccupaSpaziOccupati () {
		OccupaSpaziOccupati occupaSpaziOccupati = new OccupaSpaziOccupati ();
		return occupaSpaziOccupati;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI EFFETTO COPIA EFFETTO LEADER
	//--------------------------------------------------------------------------------------------------------------//
	public static CopiaEffettoLeader leggiEffettoCopiaEffettoLeader () {
		CopiaEffettoLeader copiaEffettoLeader = new CopiaEffettoLeader ();
		return copiaEffettoLeader;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI EFFETTO BONUS PV CHIESTA
	//--------------------------------------------------------------------------------------------------------------//
	public static BonusPVChiesa leggiEffettoBonusPVChiesa (Element effetto) {
		int valore = Integer.parseInt(effetto.getElementsByTagName("valore").item(0).getFirstChild().getNodeValue());
		BonusPVChiesa bonusPVChiesa = new BonusPVChiesa(valore);
		return bonusPVChiesa;
	}
		
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI EFFETTO ANNULLA GUADAGNO
	//--------------------------------------------------------------------------------------------------------------//
	public static AnnullaGuadagno leggiEffettoAnnullaGuadagno (Element effetto)
	{
		String coloreCarta = effetto.getElementsByTagName("coloreCarta").item(0).getFirstChild().getNodeValue();
		
		ColoreCarta coloreCartaEnum = null;
		
		switch(coloreCarta.toUpperCase()) {
			case "VERDE": coloreCartaEnum = ColoreCarta.VERDE;
				break;
			case "GIALLO": coloreCartaEnum = ColoreCarta.GIALLO;
				break;
			case "BLU": coloreCartaEnum = ColoreCarta.BLU;
				break;
			case "VIOLA": coloreCartaEnum = ColoreCarta.VIOLA;
				break;
		}
		
		AnnullaGuadagno annullaGuadagno = new AnnullaGuadagno(coloreCartaEnum);
		return annullaGuadagno;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI CARTA VERDE
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre le carte verdi dal file XML
	 * @param istanza della carta che si vuole estrarre (Classe Territorio)
	 * @return element della carta specifica che stiamo analizzando (Classe element)
	 */
	public static Territorio leggiCartaVerde (Element carta){
		
		//------------------------------------------------------//
		//	FASE 1: DICHIARAZIONE VARIABILI E ACQUISIZIONE DATI
		//------------------------------------------------------//
		int id = Integer.parseInt(carta.getAttribute("id"));
		int periodo = Integer.parseInt(carta.getElementsByTagName("periodo").item(0).getFirstChild().getNodeValue());
		int dadoRaccolta = Integer.parseInt(carta.getElementsByTagName("dadoRaccolto").item(0).getFirstChild().getNodeValue());
		
		String nome = carta.getElementsByTagName("nome").item(0).getFirstChild().getNodeValue();
		String colore = carta.getElementsByTagName("colore").item(0).getFirstChild().getNodeValue();
		String effettoRaccolta = carta.getElementsByTagName("effetto").item(0).getFirstChild().getNodeValue();
		
		Set<Effetto> effettiImmediati = new HashSet<Effetto>();
		
		//------------------------------------------------------//
		//	FASE 2: CICLIO DI ACQUISIZIONE DEGLI EFFETTI IMMEDIATI
		//------------------------------------------------------//
		NodeList listaEffettiImm = carta.getElementsByTagName("effettoImm");
        for (int j = 0; j < listaEffettiImm.getLength(); ++j) {
            Element effetto = (Element) listaEffettiImm.item(j);
            String effettoTipo = effetto.getFirstChild().getNodeValue();
            Effetto effettoImm = getEffettoXML(effettoTipo);
            effettiImmediati.add(effettoImm);
        }

		//------------------------------------------------------//
		//	FASE 3: ESTRAZIONE DEI DATI RELATIVI ALL'EFFETTO
		//------------------------------------------------------//
        Effetto effettoRac = getEffettoXML(effettoRaccolta);
        
        //------------------------------------------------------//
		//	FASE 4: ISTANZIAZIONE DEL SET RISORSE (COSTO)
		//------------------------------------------------------//
        Legna legna = new Legna (Integer.parseInt(carta.getElementsByTagName("legno").item(0).getFirstChild().getNodeValue()));
		Pietra pietra = new Pietra (Integer.parseInt(carta.getElementsByTagName("pietra").item(0).getFirstChild().getNodeValue()));
		Oro oro = new Oro (Integer.parseInt(carta.getElementsByTagName("oro").item(0).getFirstChild().getNodeValue()));
		Servitori servitori = new Servitori (Integer.parseInt(carta.getElementsByTagName("servitori").item(0).getFirstChild().getNodeValue()));
		PuntiFede puntiFede = new PuntiFede (Integer.parseInt(carta.getElementsByTagName("puntiFede").item(0).getFirstChild().getNodeValue()));
		PuntiMilitari puntiMilitari = new PuntiMilitari (Integer.parseInt(carta.getElementsByTagName("puntiMilitari").item(0).getFirstChild().getNodeValue()));
		PuntiVittoria puntiVittoria = new PuntiVittoria (Integer.parseInt(carta.getElementsByTagName("puntiVittoria").item(0).getFirstChild().getNodeValue()));
		Privilegi privilegi = new Privilegi (Integer.parseInt(carta.getElementsByTagName("privilegi").item(0).getFirstChild().getNodeValue()));
        
        HashSet<Risorsa> risorse = new HashSet<>();
        
        risorse.add(legna);
        risorse.add(pietra);
        risorse.add(oro);
        risorse.add(servitori);
        risorse.add(puntiFede);
        risorse.add(puntiMilitari);
        risorse.add(puntiVittoria);
        risorse.add(privilegi);
               
        SetRisorse costo = new SetRisorse (risorse);
        
        //------------------------------------------------------//
		//	FASE 5 [FINALE]: ISTANZA DELLA CARTA VERDE
		//------------------------------------------------------//
        Territorio territorio = new Territorio (nome, id, periodo, costo, effettiImmediati, dadoRaccolta, effettoRac);
        return territorio;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI CARTA GIALLA
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre le carte gialle dal file XML
	 * @param istanza della carta che si vuole estrarre (Classe Edificio)
	 * @return element della carta specifica che stiamo analizzando (Classe element)
	 */
	public static Edificio leggiCartaGialla (Element carta){
		
		//------------------------------------------------------//
		//	FASE 1: DICHIARAZIONE VARIABILI E ACQUISIZIONE DATI
		//------------------------------------------------------//
		int id = Integer.parseInt(carta.getAttribute("id"));
		int periodo = Integer.parseInt(carta.getElementsByTagName("periodo").item(0).getFirstChild().getNodeValue());
		int dadoProduzione = Integer.parseInt(carta.getElementsByTagName("dadoProduzione").item(0).getFirstChild().getNodeValue());
		
		String nome = carta.getElementsByTagName("nome").item(0).getFirstChild().getNodeValue();
		String colore = carta.getElementsByTagName("colore").item(0).getFirstChild().getNodeValue();
		String effettoProduzione = carta.getElementsByTagName("effetto").item(0).getFirstChild().getNodeValue();
		
		Set<Effetto> effettiImmediati = new HashSet<Effetto>();
		
		//------------------------------------------------------//
		//	FASE 2: CICLIO DI ACQUISIZIONE DEGLI EFFETTI IMMEDIATI
		//------------------------------------------------------//
		NodeList listaEffettiImm = carta.getElementsByTagName("effettoImm");
        for (int j = 0; j < listaEffettiImm.getLength(); ++j) {
            Element effetto = (Element) listaEffettiImm.item(j);
            String effettoTipo = effetto.getFirstChild().getNodeValue();
            Effetto effettoImm = getEffettoXML(effettoTipo);
            effettiImmediati.add(effettoImm);
        }

		//------------------------------------------------------//
		//	FASE 3: ESTRAZIONE DEI DATI RELATIVI ALL'EFFETTO
		//------------------------------------------------------//
        Effetto effettoProd = getEffettoXML(effettoProduzione);
        
        //------------------------------------------------------//
		//	FASE 4: ISTANZIAZIONE DEL SET RISORSE (COSTO)
		//------------------------------------------------------//
        Legna legna = new Legna (Integer.parseInt(carta.getElementsByTagName("legno").item(0).getFirstChild().getNodeValue()));
		Pietra pietra = new Pietra (Integer.parseInt(carta.getElementsByTagName("pietra").item(0).getFirstChild().getNodeValue()));
		Oro oro = new Oro (Integer.parseInt(carta.getElementsByTagName("oro").item(0).getFirstChild().getNodeValue()));
		Servitori servitori = new Servitori (Integer.parseInt(carta.getElementsByTagName("servitori").item(0).getFirstChild().getNodeValue()));
		PuntiFede puntiFede = new PuntiFede (Integer.parseInt(carta.getElementsByTagName("puntiFede").item(0).getFirstChild().getNodeValue()));
		PuntiMilitari puntiMilitari = new PuntiMilitari (Integer.parseInt(carta.getElementsByTagName("puntiMilitari").item(0).getFirstChild().getNodeValue()));
		PuntiVittoria puntiVittoria = new PuntiVittoria (Integer.parseInt(carta.getElementsByTagName("puntiVittoria").item(0).getFirstChild().getNodeValue()));
		Privilegi privilegi = new Privilegi (Integer.parseInt(carta.getElementsByTagName("privilegi").item(0).getFirstChild().getNodeValue()));
        
        HashSet<Risorsa> risorse = new HashSet<>();
        
        risorse.add(legna);
        risorse.add(pietra);
        risorse.add(oro);
        risorse.add(servitori);
        risorse.add(puntiFede);
        risorse.add(puntiMilitari);
        risorse.add(puntiVittoria);
        risorse.add(privilegi);
               
        SetRisorse costo = new SetRisorse (risorse);
		
        
        //------------------------------------------------------//
  		//	FASE 5 [FINALE]: ISTANZA DELLA CARTA GIALLA
  		//------------------------------------------------------//
        Edificio edificio = new Edificio (nome, id, periodo, costo, effettiImmediati, dadoProduzione, effettoProd);
        return edificio;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI CARTA BLU
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre le carte blu dal file XML
	 * @param istanza della carta che si vuole estrarre (Classe Personaggio)
	 * @return element della carta specifica che stiamo analizzando (Classe element)
	 */
	public static Personaggio leggiCartaBlu(Element carta){
		
		//------------------------------------------------------//
		//	FASE 1: DICHIARAZIONE VARIABILI E ACQUISIZIONE DATI
		//------------------------------------------------------//
		int id = Integer.parseInt(carta.getAttribute("id"));
		int periodo = Integer.parseInt(carta.getElementsByTagName("periodo").item(0).getFirstChild().getNodeValue());
		
		String nome = carta.getElementsByTagName("nome").item(0).getFirstChild().getNodeValue();
		String colore = carta.getElementsByTagName("colore").item(0).getFirstChild().getNodeValue();
		String effettoPersonaggio = "NULL";
		
		Set<Effetto> effettiImmediati = new HashSet<Effetto>();
		
		//------------------------------------------------------//
		//	FASE 2: ESTRAZIONE DELL'EFFETTO PERSONAGGIO [se esiste]
		//------------------------------------------------------//
		try{
			effettoPersonaggio = carta.getElementsByTagName("effetto").item(0).getFirstChild().getNodeValue();
		}catch (NullPointerException e){
		}
		
		//------------------------------------------------------//
		//	FASE 3: CICLIO DI ACQUISIZIONE DEGLI EFFETTI IMMEDIATI
		//------------------------------------------------------//
		NodeList listaEffettiImm = carta.getElementsByTagName("effettoImm");
        for (int j = 0; j < listaEffettiImm.getLength(); ++j) {
            Element effetto = (Element) listaEffettiImm.item(j);
            String effettoTipo = effetto.getFirstChild().getNodeValue();
            Effetto effettoImm = getEffettoXML(effettoTipo);
            effettiImmediati.add(effettoImm);
        }
        
		//---------------------------------------------------//
		//	FASE 4: ESTRAZIONE DEI DATI RELATIVI ALL'EFFETTO
		//---------------------------------------------------//
        Effetto effettoPerson = null;
		if (!effettoPersonaggio.equals("NULL"))
			effettoPerson = getEffettoXML(effettoPersonaggio);
		
		//------------------------------------------------------//
		//	FASE 5: ISTANZIAZIONE DEL SET RISORSE (COSTO)
		//------------------------------------------------------//
		Legna legna = new Legna (Integer.parseInt(carta.getElementsByTagName("legno").item(0).getFirstChild().getNodeValue()));
		Pietra pietra = new Pietra (Integer.parseInt(carta.getElementsByTagName("pietra").item(0).getFirstChild().getNodeValue()));
		Oro oro = new Oro (Integer.parseInt(carta.getElementsByTagName("oro").item(0).getFirstChild().getNodeValue()));
		Servitori servitori = new Servitori (Integer.parseInt(carta.getElementsByTagName("servitori").item(0).getFirstChild().getNodeValue()));
		PuntiFede puntiFede = new PuntiFede (Integer.parseInt(carta.getElementsByTagName("puntiFede").item(0).getFirstChild().getNodeValue()));
		PuntiMilitari puntiMilitari = new PuntiMilitari (Integer.parseInt(carta.getElementsByTagName("puntiMilitari").item(0).getFirstChild().getNodeValue()));
		PuntiVittoria puntiVittoria = new PuntiVittoria (Integer.parseInt(carta.getElementsByTagName("puntiVittoria").item(0).getFirstChild().getNodeValue()));
		Privilegi privilegi = new Privilegi (Integer.parseInt(carta.getElementsByTagName("privilegi").item(0).getFirstChild().getNodeValue()));
        
        HashSet<Risorsa> risorse = new HashSet<>();
        
        risorse.add(legna);
        risorse.add(pietra);
        risorse.add(oro);
        risorse.add(servitori);
        risorse.add(puntiFede);
        risorse.add(puntiMilitari);
        risorse.add(puntiVittoria);
        risorse.add(privilegi);
               
        SetRisorse costo = new SetRisorse (risorse);
		
        //------------------------------------------------------//
  		//	FASE 6 [FINALE]: ISTANZA DELLA CARTA BLU
  		//------------------------------------------------------//
		Personaggio personaggio = new Personaggio (nome, id, periodo, costo, effettiImmediati, effettoPerson);
		return personaggio;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI CARTA VIOLA
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre le carte viola dal file XML
	 * @param istanza della carta che si vuole estrarre (Classe Impresa)
	 * @return element della carta specifica che stiamo analizzando (Classe element)
	 */
	public static Impresa leggiCartaViola (Element carta){
		
		//------------------------------------------------------//
		//	FASE 1: DICHIARAZIONE VARIABILI E ACQUISIZIONE DATI
		//------------------------------------------------------//
		int id = Integer.parseInt(carta.getAttribute("id"));
		int periodo = Integer.parseInt(carta.getElementsByTagName("periodo").item(0).getFirstChild().getNodeValue());
		
		String nome = carta.getElementsByTagName("nome").item(0).getFirstChild().getNodeValue();
		String colore = carta.getElementsByTagName("colore").item(0).getFirstChild().getNodeValue();
		String effettoImpresa = carta.getElementsByTagName("effetto").item(0).getFirstChild().getNodeValue();
		
		Set<Effetto> effettiImmediati = new HashSet<Effetto>();
		
		//------------------------------------------------------//
		//	FASE 2: CICLIO DI ACQUISIZIONE DEGLI EFFETTI IMMEDIATI
		//------------------------------------------------------//
		NodeList listaEffettiImm = carta.getElementsByTagName("effettoImm");
        for (int j = 0; j < listaEffettiImm.getLength(); ++j) {
            Element effetto = (Element) listaEffettiImm.item(j);
            String effettoTipo = effetto.getFirstChild().getNodeValue();
            Effetto effettoImm = getEffettoXML(effettoTipo);
            effettiImmediati.add(effettoImm);
        }
        
        //------------------------------------------------------//
  		//	FASE 2: ESTRAZIONE DEL COSTO [può non esistere]
  		//------------------------------------------------------//
        SetRisorse costo;
        try{
        	
    		//------------------------------------------------------//
      		//	FASE 2.1: ISTANZIAZIONE DEL SET RISORSE (COSTO)
      		//------------------------------------------------------//
    		Legna legna = new Legna (Integer.parseInt(carta.getElementsByTagName("legno").item(0).getFirstChild().getNodeValue()));
    		Pietra pietra = new Pietra (Integer.parseInt(carta.getElementsByTagName("pietra").item(0).getFirstChild().getNodeValue()));
    		Oro oro = new Oro (Integer.parseInt(carta.getElementsByTagName("oro").item(0).getFirstChild().getNodeValue()));
    		Servitori servitori = new Servitori (Integer.parseInt(carta.getElementsByTagName("servitori").item(0).getFirstChild().getNodeValue()));
    		PuntiFede puntiFede = new PuntiFede (Integer.parseInt(carta.getElementsByTagName("puntiFede").item(0).getFirstChild().getNodeValue()));
    		PuntiMilitari puntiMilitari = new PuntiMilitari (Integer.parseInt(carta.getElementsByTagName("puntiMilitari").item(0).getFirstChild().getNodeValue()));
    		PuntiVittoria puntiVittoria = new PuntiVittoria (Integer.parseInt(carta.getElementsByTagName("puntiVittoria").item(0).getFirstChild().getNodeValue()));
    		Privilegi privilegi = new Privilegi (Integer.parseInt(carta.getElementsByTagName("privilegi").item(0).getFirstChild().getNodeValue()));
            
            HashSet<Risorsa> risorse = new HashSet<>();
            
            risorse.add(legna);
            risorse.add(pietra);
            risorse.add(oro);
            risorse.add(servitori);
            risorse.add(puntiFede);
            risorse.add(puntiMilitari);
            risorse.add(puntiVittoria);
            risorse.add(privilegi);
                   
            costo = new SetRisorse (risorse);
            
		}catch(NullPointerException e){
			//------------------------------------------------------//
      		//	FASE 2.2: ISTANZIAZIONE DEL SET RISORSE [se non esiste]
      		//------------------------------------------------------//
			costo = null;
		}
        
        //------------------------------------------------------//
  		//	FASE 3: ESTRAZIONE DEL COSTO IN PUNTI MILITARI [se esiste]
  		//------------------------------------------------------//
        int costoPt;
        int requisito;
        try{
			costoPt = Integer.parseInt(carta.getElementsByTagName("costoPt").item(0).getFirstChild().getNodeValue());
			requisito = Integer.parseInt(carta.getElementsByTagName("requisito").item(0).getFirstChild().getNodeValue());
        }catch(NullPointerException e){
        	costoPt = 0;
        	requisito = 0;
		}
		
  		//------------------------------------------------------//
		//	FASE 4: ESTRAZIONE DEI DATI RELATIVI ALL'EFFETTO
  		//------------------------------------------------------//
		Effetto effettoImpr = getEffettoXML(effettoImpresa);
		
		//------------------------------------------------------//
  		//	FASE 5 [FINALE]: ISTANZA DELLA CARTA VIOLA
  		//------------------------------------------------------//
		Impresa impresa = new Impresa (nome, id, periodo, costo, effettiImmediati, effettoImpr, requisito, costoPt);
		return impresa;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI CARTA LEADER
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre le carte leader dal file XML
	 * @param nome della carta leader che si vuole estrarre (String)
	 */
	public static void leggiCartaLeader (String nomeCarta){
		
		int valore=1;
		Set<Effetto> effetti = new HashSet<Effetto>();
		
		
		try{
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			Document document = builder.parse(new File("XML/Leaders.xml"));
			
			NodeList leaders = document.getElementsByTagName("leader");
			
			for(int i=0; i<leaders.getLength(); i++) {
				
				Element leader = (Element) leaders.item(i);
				String nomeLeader = leader.getElementsByTagName("nome").item(0).getFirstChild().getNodeValue();
				SetRisorse requisitoMaterie;
				
				if(nomeCarta.toUpperCase().equals(nomeLeader.toUpperCase())) {	
					
					System.out.println("nome della carta leader: "+nomeCarta);
					
					try{
						NodeList carte = leader.getElementsByTagName("carta");
						int fine = carte.getLength();
						if(fine!=0)
							for(int j=0; j<fine; j++) {
								Element carta = (Element) carte.item(j);
								
								System.out.println("tipo: "+carta.getElementsByTagName("tipo").item(0).getFirstChild().getNodeValue());
								System.out.println("quantita: "+carta.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue());
								
							}
						else
							System.out.println("nessun requisito in carte richiesto");
					}catch(Exception e2) {
						System.out.println("nessun requisito in carte richiesto");
					}
					
					try{
						//------------------------------------------------------//
			      		//	FASE 2.1: ISTANZIAZIONE DEL SET RISORSE (COSTO)
			      		//------------------------------------------------------//
			    		Legna legna = new Legna (Integer.parseInt(leader.getElementsByTagName("legno").item(0).getFirstChild().getNodeValue()));
			    		Pietra pietra = new Pietra (Integer.parseInt(leader.getElementsByTagName("pietra").item(0).getFirstChild().getNodeValue()));
			    		Oro oro = new Oro (Integer.parseInt(leader.getElementsByTagName("oro").item(0).getFirstChild().getNodeValue()));
			    		Servitori servitori = new Servitori (Integer.parseInt(leader.getElementsByTagName("servitori").item(0).getFirstChild().getNodeValue()));
			    		PuntiFede puntiFede = new PuntiFede (Integer.parseInt(leader.getElementsByTagName("puntiFede").item(0).getFirstChild().getNodeValue()));
			    		PuntiMilitari puntiMilitari = new PuntiMilitari (Integer.parseInt(leader.getElementsByTagName("puntiMilitari").item(0).getFirstChild().getNodeValue()));
			    		PuntiVittoria puntiVittoria = new PuntiVittoria (Integer.parseInt(leader.getElementsByTagName("puntiVittoria").item(0).getFirstChild().getNodeValue()));
			    		Privilegi privilegi = new Privilegi (Integer.parseInt(leader.getElementsByTagName("privilegi").item(0).getFirstChild().getNodeValue()));
			            
			            HashSet<Risorsa> risorse = new HashSet<>();
			            
			            risorse.add(legna);
			            risorse.add(pietra);
			            risorse.add(oro);
			            risorse.add(servitori);
			            risorse.add(puntiFede);
			            risorse.add(puntiMilitari);
			            risorse.add(puntiVittoria);
			            risorse.add(privilegi);
			                   
			            requisitoMaterie = new SetRisorse (risorse);
			            
			            System.out.println("Requisiti materiali: ");
			            System.out.println("Legna: "+legna.getQuantità());
			            System.out.println("Pietra: "+pietra.getQuantità());
			            System.out.println("Oro: "+oro.getQuantità());
			            System.out.println("Servitori: "+servitori.getQuantità());
			            System.out.println("Punti fede: "+puntiFede.getQuantità());
			            System.out.println("Punti militari: "+puntiMilitari.getQuantità());
			            System.out.println("Punti vittoria: "+puntiVittoria.getQuantità());
			            System.out.println("Privilegi: "+privilegi.getQuantità());
			            
					}catch(Exception e1) {
						requisitoMaterie = null;
						System.out.println("nessun requisito in materie richiesto");
					}
					
					
					
					NodeList listaEffetti = leader.getElementsByTagName("effetto");
					System.out.println("effetti: ");
			        for (int j = 0; j < listaEffetti.getLength(); ++j) {
			            Element effetto = (Element) listaEffetti.item(j);
			            String effettoTipo = effetto.getFirstChild().getNodeValue();
			            System.out.println("effetto: "+effettoTipo);
			            //Effetto effettoExt = getEffettoXML(effettoTipo);
			            //effetti.add(effettoExt);
			        }
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		/*return leaderEstratto;*/
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI SCOMUNICA
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre i dati generali del gioco dal relativo file XML
	 * @param quale valore si vuole leggere dal file XML (String)
	 * @return valore letto (Integer)
	 */
	public static TesseraScomunica leggiScomunica (int periodo){
		
		ArrayList<TesseraScomunica> scomuniche = new ArrayList<TesseraScomunica>();
		String effettoScomunica;
		Set<Effetto> effetti = new HashSet<Effetto>();
		
		try{
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			Document document = builder.parse(new File("XML/Scomuniche.xml"));
			
			NodeList scomunicheList = document.getElementsByTagName("scomunica");
			
			for(int i=0; i<scomunicheList.getLength(); i++){
				
				Element scomunica = (Element) scomunicheList.item(i);
				int periodoLetto = Integer.parseInt(scomunica.getElementsByTagName("periodo").item(0).getFirstChild().getNodeValue());
				
				if(periodoLetto == periodo){
					effettoScomunica = scomunica.getElementsByTagName("effetto").item(0).getFirstChild().getNodeValue();
					
					NodeList listaEffetti = scomunica.getElementsByTagName("effetto");
			        for (int j = 0; j < listaEffetti.getLength(); ++j) {
			            Element effetto = (Element) listaEffetti.item(j);
			            String effettoTipo = effetto.getFirstChild().getNodeValue();
			            Effetto effettoExt = getEffettoXML(effettoTipo);
			            effetti.add(effettoExt);
			        }
					
			        TesseraScomunica tesseraScomunica = new TesseraScomunica (periodoLetto,effetti);
			        
					scomuniche.add(tesseraScomunica);
				}
					
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		
		Collections.shuffle(scomuniche);
		return scomuniche.get(0);
	}

	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI SPAZIO TORRE
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre le informazioni riguardo gli spazi della torre
	 * @param quale spazio si vuole analizzare (String)
	 * @return set delle risorse dello spazio torre analizzato (Classe SetRisorse)
	 */
	public static SetRisorse leggiSetRisorseSpazio (String tipoSpazio){
		
		SetRisorse setRisorse = null;
		
		try{
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			Document document = builder.parse(new File("XML/SetRisorseSpazi.xml"));
			
			NodeList spazi = document.getElementsByTagName("tipoSpazio");
			
			for(int i=0; i<spazi.getLength(); i++){	
				
				Element spazio = (Element) spazi.item(i);
				
				if(spazio.getAttribute("tipo").equals(tipoSpazio)) {
					
		    		Legna legna = new Legna (Integer.parseInt(spazio.getElementsByTagName("legno").item(0).getFirstChild().getNodeValue()));
		    		Pietra pietra = new Pietra (Integer.parseInt(spazio.getElementsByTagName("pietra").item(0).getFirstChild().getNodeValue()));
		    		Oro oro = new Oro (Integer.parseInt(spazio.getElementsByTagName("oro").item(0).getFirstChild().getNodeValue()));
		    		Servitori servitori = new Servitori (Integer.parseInt(spazio.getElementsByTagName("servitori").item(0).getFirstChild().getNodeValue()));
		    		PuntiFede puntiFede = new PuntiFede (Integer.parseInt(spazio.getElementsByTagName("puntiFede").item(0).getFirstChild().getNodeValue()));
		    		PuntiMilitari puntiMilitari = new PuntiMilitari (Integer.parseInt(spazio.getElementsByTagName("puntiMilitari").item(0).getFirstChild().getNodeValue()));
		    		PuntiVittoria puntiVittoria = new PuntiVittoria (Integer.parseInt(spazio.getElementsByTagName("puntiVittoria").item(0).getFirstChild().getNodeValue()));
		    		Privilegi privilegi = new Privilegi (Integer.parseInt(spazio.getElementsByTagName("privilegi").item(0).getFirstChild().getNodeValue()));
		            
		            HashSet<Risorsa> risorse = new HashSet<>();
		            
		            risorse.add(legna);
		            risorse.add(pietra);
		            risorse.add(oro);
		            risorse.add(servitori);
		            risorse.add(puntiFede);
		            risorse.add(puntiMilitari);
		            risorse.add(puntiVittoria);
		            risorse.add(privilegi);
		                   
		            setRisorse = new SetRisorse (risorse);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		
		return setRisorse;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI VALORE
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre i dati generali del gioco dal relativo file XML
	 * @param quale valore si vuole leggere dal file XML (String)
	 * @return valore letto (Integer)
	 */
	public static int leggiValore (String tipoValore){
		
		int valore=1;
		
		try{
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			Document document = builder.parse(new File("XML/DatiGenerali.xml"));
			
			NodeList nomeValore = document.getElementsByTagName("nomeValore");
			
			for(int i=0; i<nomeValore.getLength(); i++){
				
				Element valoreElemento = (Element) nomeValore.item(i);
				
				if(tipoValore.toUpperCase().equals(valoreElemento.getAttribute("nome").toUpperCase()))
					valore = Integer.parseInt(valoreElemento.getElementsByTagName("valore").item(0).getFirstChild().getNodeValue());
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return valore;
	}
}
