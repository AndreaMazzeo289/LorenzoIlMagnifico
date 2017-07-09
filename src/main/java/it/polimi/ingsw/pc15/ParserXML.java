package it.polimi.ingsw.pc15;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.carte.Impresa;
import it.polimi.ingsw.pc15.carte.Personaggio;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.effetti.AggiuntaRisorse;
import it.polimi.ingsw.pc15.effetti.AnnullaGuadagno;
import it.polimi.ingsw.pc15.effetti.AnnullaRequisitoTerritori;
import it.polimi.ingsw.pc15.effetti.AnnullaSovrapprezzoTorri;
import it.polimi.ingsw.pc15.effetti.AumentaPrezzoServitori;
import it.polimi.ingsw.pc15.effetti.AzionePrendiCartaAggiuntiva;
import it.polimi.ingsw.pc15.effetti.AzionePrendiCartaAggiuntivaConSconto;
import it.polimi.ingsw.pc15.effetti.Produzione;
import it.polimi.ingsw.pc15.effetti.Raccolto;
import it.polimi.ingsw.pc15.effetti.BonusDadoCarte;
import it.polimi.ingsw.pc15.effetti.BonusPVChiesa;
import it.polimi.ingsw.pc15.effetti.BonusProduzione;
import it.polimi.ingsw.pc15.effetti.BonusRaccolta;
import it.polimi.ingsw.pc15.effetti.BonusRisorseCarte;
import it.polimi.ingsw.pc15.effetti.BonusRisorseSpazi;
import it.polimi.ingsw.pc15.effetti.BonusValoreFamiliare;
import it.polimi.ingsw.pc15.effetti.CopiaEffettoLeader;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.effetti.FissaValoreFamiliare;
import it.polimi.ingsw.pc15.effetti.FissaValoreFamiliareAScelta;
import it.polimi.ingsw.pc15.effetti.MoltiplicaRisorseCarte;
import it.polimi.ingsw.pc15.effetti.NegaBonusSpazioTorri;
import it.polimi.ingsw.pc15.effetti.NegaMercato;
import it.polimi.ingsw.pc15.effetti.OccupaSpaziOccupati;
import it.polimi.ingsw.pc15.effetti.RisorsePerCarte;
import it.polimi.ingsw.pc15.effetti.RisorsePerRisorse;
import it.polimi.ingsw.pc15.effetti.SaltaPrimoTurno;
import it.polimi.ingsw.pc15.effetti.Scambio;
import it.polimi.ingsw.pc15.effetti.ScontoCostoCarte;
import it.polimi.ingsw.pc15.plancia.TesseraScomunica;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Leader;
import it.polimi.ingsw.pc15.player.TesseraBonus;
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

public class ParserXML {
	
	public static void main (String args[]) {
		//leggiScomunica(1);
		//leggiScomunica(2);
		//leggiScomunica(3);
		
		getCarteXML(TipoCarta.TERRITORIO);
		getCarteXML(TipoCarta.PERSONAGGIO);
		getCarteXML(TipoCarta.EDIFICIO);
		getCarteXML(TipoCarta.IMPRESA);
		//leggiCartaLeader();
		//leggiTessereBonusRaccolta();
		//leggiSetRisorseSpazio("verde1");
	}
	
	
	/*public static void main (String args[]){
		leggiCartaLeader();
	}*/
	
	//--------------------------------------------------------------------------------------------------------------//
	// GET CARTA XML
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che gestisce l'estrazione delle carte dal relativo file XML chiamando opportuni metodi per ogni tipologia di carta
	 * @param colore della carta che si vuole estrarre (enumerazione ColoreCarta)
	 * @return ArrayList di tutte le carte del colore desiderato
	 */
	public static ArrayList<Carta> getCarteXML (TipoCarta tipoCarta){
		
		ArrayList<Carta> arrayCarte = new ArrayList<Carta>();
	    
	    try {
	        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

	        DocumentBuilder builder = documentFactory.newDocumentBuilder();
	        Document document = builder.parse(new File("XML/Cards_v2.0.xml"));

	        NodeList carte = document.getElementsByTagName("carta");

	        for(int i=0; i<carte.getLength(); i++){

	            Element carta = (Element) carte.item(i);
	            String tipo = carta.getAttribute("tipo");
	            
	            HashSet<Risorsa> risorseMap = new HashSet<>();
	            
	            if(tipo.toUpperCase().equals(tipoCarta.toString())) {
	                
	                //------------------------------------------------------//
	                //	FASE 1: DICHIARAZIONE VARIABILI E ACQUISIZIONE DATI
	                //------------------------------------------------------//
			        String nome = carta.getElementsByTagName("nome").item(0).getFirstChild().getNodeValue();
	                String effettoCarta = null;
	                int valoreDado=0;
	                
	                int id = Integer.parseInt(carta.getAttribute("id"));
	                int periodo = Integer.parseInt(carta.getElementsByTagName("periodo").item(0).getFirstChild().getNodeValue());
	                String pathImg = "img/DevCardsFront/devcards_f_en_c_"+id+".png";
	                
	               /**********************************************************
	                System.out.println("------------------------------------------------");
	                System.out.println(pathImg);
	                System.out.println("ID carta: " +id);
	                System.out.println("Nome carta: " +nome);
	                System.out.println("Tipo carta: " +tipo);
	                System.out.println("Periodo carta: " +periodo);
	               **********************************************************/
	                
	                
	                Set<Effetto> effettiImmediatiSet = new HashSet<Effetto>();
	                Set<Effetto> effettiPermanentiSet = new HashSet<Effetto>();
	                
	                 //------------------------------------------------------//
	                //	FASE 2: ESTRAZIONE DEL DADO DI ATTIVAZIONE [se esiste]
	                //------------------------------------------------------//
	                try{
	                    valoreDado = Integer.parseInt(carta.getElementsByTagName("dado").item(0).getFirstChild().getNodeValue());
	                    /*System.out.println("valore dado: " +valoreDado);*/
	                }catch (NullPointerException e){}
	                
	                //------------------------------------------------------//
	                //	FASE 3: CICLIO DI ACQUISIZIONE DEGLI EFFETTI PERMANENTI
	                //------------------------------------------------------//
	                NodeList listaEffettiPermanenti = carta.getElementsByTagName("effettoPermanente");
	                for (int j = 0; j < listaEffettiPermanenti.getLength(); ++j) {
	                    Element effetto = (Element) listaEffettiPermanenti.item(j);
	                    String tipologiaEffetto = effetto.getFirstChild().getNodeValue();
	                    //System.out.println("Effetto permanente "+j+":"+tipologiaEffetto);
	                    Effetto effettoLetto = getEffettoXML(tipologiaEffetto);
	                    effettiPermanentiSet.add(effettoLetto);
	                }
	              
	                //------------------------------------------------------//
	                //	FASE 4: CICLIO DI ACQUISIZIONE DEGLI EFFETTI IMMEDIATI
	                //------------------------------------------------------//
	                NodeList listaEffettiImmediati = carta.getElementsByTagName("effettoImmediato");
	                for (int j = 0; j < listaEffettiImmediati.getLength(); ++j) {
	                    Element effetto = (Element) listaEffettiImmediati.item(j);
	                    String tipologiaEffetto = effetto.getFirstChild().getNodeValue();
	                    //System.out.println("Effetto immediato "+j+":"+tipologiaEffetto);
	                    Effetto effettoLetto = getEffettoXML(tipologiaEffetto);
	                    effettiImmediatiSet.add(effettoLetto);
	                }
	        
	                //------------------------------------------------------//
	                //	FASE 5: ESTRAZIONE DEL COSTO [può non esistere]
	                //------------------------------------------------------//
	                SetRisorse costo;
	                try{
	                	NodeList risorse = carta.getElementsByTagName("risorsa");
	                	int contRisorse = risorse.getLength();
	                	for(int j=0; j<contRisorse; j++) {
	                		 Element risorsa = (Element) risorse.item(j);
	                		 int quantita = Integer.parseInt(risorsa.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue());
	                		 
	                		 switch(risorsa.getAttribute("tipo").toUpperCase()) {
	                		 	case "LEGNA":
	                		 		/*System.out.println("Legna richiesta: "+quantita);*/
	                		 		Legna legna = new Legna(quantita);
	                		 		risorseMap.add(legna);
	                		 		break;
	                		 	case "PIETRA":
	                		 		/*System.out.println("Pietra richiesta: "+quantita);*/
	                		 		Pietra pietra = new Pietra(quantita);
	                		 		risorseMap.add(pietra);
	                		 		break;
	                		 	case "ORO":
	                		 		/*System.out.println("Oro richiesto: "+quantita);*/
	                		 		Oro oro = new Oro(quantita);
	                		 		risorseMap.add(oro);
	                		 		break;
	                		 	case "SERVITORI":
	                		 		/*System.out.println("Servitori richiesti: "+quantita);*/
	                		 		Servitori servitori = new Servitori(quantita);
	                		 		risorseMap.add(servitori);
	                		 		break;
	                		 	case "PUNTIMILITARI":
	                		 		/*System.out.println("Punti militari richiesti: "+quantita);*/
	                		 		PuntiMilitari puntiMilitari = new PuntiMilitari(quantita);
	                		 		risorseMap.add(puntiMilitari);
	                		 		break;
	                		 	case "PUNTIFEDE":
	                		 		/*System.out.println("Punti fede richiesti: "+quantita);*/
	                		 		PuntiFede puntiFede = new PuntiFede(quantita);
	                		 		risorseMap.add(puntiFede);
	                		 		break;
	                		 	case "PUNTIVITTORIA":
	                		 		/*System.out.println("Punti vittoria richiesti: "+quantita);*/
	                		 		PuntiVittoria puntiVittoria = new PuntiVittoria(quantita);
	                		 		risorseMap.add(puntiVittoria);
	                		 		break;
	                		 	case "PRIVILEGI":
	                		 		/*System.out.println("Privilegi richiesti: "+quantita);*/
	                		 		Privilegi privilegi = new Privilegi(quantita);
	                		 		risorseMap.add(privilegi);
	                		 		break;
	                		 	default:
	                		 		System.out.println("Nessun costo");
	                		 }

	                	}
	                }catch(NullPointerException e){
	                }
	                
	                costo = new SetRisorse (risorseMap);
	                
	        
	                //------------------------------------------------------//
	                //	FASE 6: ESTRAZIONE DEL COSTO IN PUNTI MILITARI [se esiste]
	                //------------------------------------------------------//
	                int costoPt;
	                int requisito;
	                try{
	                    costoPt = Integer.parseInt(carta.getElementsByTagName("costoPt").item(0).getFirstChild().getNodeValue());
	                    requisito = Integer.parseInt(carta.getElementsByTagName("requisito").item(0).getFirstChild().getNodeValue());
	                    /*System.out.println("Presente un pagamento con punti militari:");
	                    System.out.println("Punti da pagare :"+costoPt);
	                    System.out.println("Ma devi averne minimo: "+requisito);*/
	                    
	                }catch(NullPointerException e){
	                    costoPt = 0;
	                    requisito = 0;
	                }
			
	                //------------------------------------------------------//
	                //	FASE 8 [FINALE]: ISTANZA DELLA CARTA
	                //------------------------------------------------------//
	                switch(tipo.toUpperCase()) {
	                    case "TERRITORIO": 
	                        Territorio territorio = new Territorio (nome, id, periodo, costo, effettiImmediatiSet, effettiPermanentiSet, valoreDado, pathImg);
	                        arrayCarte.add(territorio);
	                        break;
	                    case "EDIFICIO":
	                        Edificio edificio = new Edificio (nome, id, periodo, costo, effettiImmediatiSet, effettiPermanentiSet, valoreDado, pathImg);
	                        arrayCarte.add(edificio);
	                        break;
	                    case "PERSONAGGIO":
	                        Personaggio personaggio = new Personaggio (nome, id, periodo, costo, effettiImmediatiSet, effettiPermanentiSet, pathImg);
	                        arrayCarte.add(personaggio);
	                        break;
	                    case "IMPRESA":
	                        Impresa impresa = new Impresa (nome, id, periodo, costo, effettiImmediatiSet, effettiPermanentiSet, requisito, costoPt, pathImg);
	                        arrayCarte.add(impresa);
	                        break;
	                }
	            }
	        }
	    }catch(Exception e) {
	         
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
			Document document = builder.parse(new File("XML/Effects_v3.0.xml"));
			
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
					 	case "raccolta":
					 		effettoLetto = leggiEffettoRaccolta(effetto);
					 		break;
					 	case "prendiCartaAggiuntiva":
					 		effettoLetto = leggiEffettoAzionePrendiCartaAggiuntiva(effetto);
					 		break;
					 	case "prendiCartaSconto":
					 		effettoLetto = leggiEffettoAzionePrendiCartaAggiuntivaConSconto(effetto);
					 		break;
					 	case "produzione":
					 		effettoLetto = leggiEffettoProduzione(effetto);
					 		break;
					 	case "moltiplicazione":
					 		if(effetto.getAttribute("tipoMolt").equals("RxR"))
					 			effettoLetto = leggiEffettorRisorsePerRisorse(effetto);
					 		else
					 			effettoLetto = leggiEffettoRisorsePerCarte(effetto);
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
					 	case "sconto":
					 		effettoLetto = leggiEffettoScontoCostoCarte(effetto);
					 		break;
					 	case "fissaFamiliare":
					 		effettoLetto = leggiEffettoFissaValoreFamiliare(effetto);
					 		break;
					 	case "negaMercato":
					 		effettoLetto = leggiEffettoNegaMercato();
					 		break;
					 	case "moltiplicaRisorseCarte":
					 		effettoLetto = leggiEffettoMoltiplicaRisorseCarte();
					 		break;
					 	case "perditaPrimoTurno":
					 		effettoLetto = leggiEffettoSaltaPrimoTurno();
					 		break;
					 	case "noBonusTorre":
					 		effettoLetto = leggiEffettoNegaBonusSpazioTorri();
					 		break;
					 	case "riduciGuadagnoCarte":
					 		effettoLetto = leggiEffettoRiduciGuadagnoCarte(effetto);
					 		break;
					 	case "riduciGuadagnoSpazi":
					 		effettoLetto = leggiEffettoRiduciGuadagnoSpazi(effetto);
					 		break;
					 	case "prezzoServitori":
					 		effettoLetto = leggiEffettoAumentaPrezzoServitori();
					 		break;
					 	case "annullaGuadagno":
					 		effettoLetto = leggiEffettoAnnullaGuadagno(effetto);
					 		break;
					 	case "requisitoTerritori":
					 		effettoLetto = leggiEffettoAnnullaRequisitoTerritori();
					 		break;
					 	case "spaziOccupati":
					 		effettoLetto = leggiEffettoOccupaSpaziOccupati();
					 		break;
					 	case "copia":
					 		effettoLetto = leggiEffettoCopiaEffettoLeader();
					 		break;
					 	case "sovrapprezzo":
					 		effettoLetto = leggiEffettoAnnullaSovrapprezzoTorri();
					 		break;
					 	case "bonusFede":
					 		effettoLetto = leggiEffettoBonusPVChiesa(effetto);
					 		break;
							
					 	default:
					 		System.out.println("Errore: effetto non presente");
					}
				}
			}
		
		}catch(Exception e){
			 
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
		
		int quantita = Integer.parseInt(effetto.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue());
		
		HashSet<Risorsa> risorseMap = new HashSet<>();
		
		switch(effetto.getElementsByTagName("tipoRisorsa").item(0).getFirstChild().getNodeValue().toUpperCase()) {
		 	case "LEGNA":
		 		Legna legna = new Legna(quantita);
		 		risorseMap.add(legna);
		 		break;
		 	case "PIETRA":
		 		Pietra pietra = new Pietra(quantita);
		 		risorseMap.add(pietra);
		 		break;
		 	case "ORO":
		 		Oro oro = new Oro(quantita);
		 		risorseMap.add(oro);
		 		break;
		 	case "SERVITORI":
		 		Servitori servitori = new Servitori(quantita);
		 		risorseMap.add(servitori);
		 		break;
		 	case "PUNTIMILITARI":
		 		PuntiMilitari puntiMilitari = new PuntiMilitari(quantita);
		 		risorseMap.add(puntiMilitari);
		 		break;
		 	case "PUNTIFEDE":
		 		PuntiFede puntiFede = new PuntiFede(quantita);
		 		risorseMap.add(puntiFede);
		 		break;
		 	case "PUNTIVITTORIA":
		 		PuntiVittoria puntiVittoria = new PuntiVittoria(quantita);
		 		risorseMap.add(puntiVittoria);
		 		break;
		 	case "PRIVILEGI":
		 		Privilegi privilegi = new Privilegi(quantita);
		 		risorseMap.add(privilegi);
		 		break;
		}
		
		SetRisorse setRisorse = new SetRisorse (risorseMap);
        
		AggiuntaRisorse aggiuntaRisorse = new AggiuntaRisorse(setRisorse);	
		return aggiuntaRisorse;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI EFFETTO AZIONE RACCOLTO
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre gli effetti di tipo azione raccolto dal file XML
	 * @param elemento dell'effetto specifico da estrarre (Classe Element)
	 * @return istanza dell'effetto estratto (Classe Raccolto)
	 */
	public static Raccolto leggiEffettoRaccolta (Element effetto) {
		
		int valoreDadoRaccolta = Integer.parseInt(effetto.getElementsByTagName("valoreDado").item(0).getFirstChild().getNodeValue());
		
		Raccolto raccolto = new Raccolto (valoreDadoRaccolta);
		return raccolto;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI EFFETTO AZIONE PRODUZIONE
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre gli effetti di tipo azione produzione dal file XML
	 * @param elemento dell'effetto specifico da estrarre (Classe Element)
	 * @return istanza dell'effetto estratto (Classe Produzione)
	 */
	public static Produzione leggiEffettoProduzione (Element effetto) {
			
		int valoreDadoProduzione = Integer.parseInt(effetto.getElementsByTagName("valoreDado").item(0).getFirstChild().getNodeValue());
			
		Produzione produzione = new Produzione (valoreDadoProduzione);
		return produzione;
	}

	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI EFFETTO AZIONE CARTA
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre gli effetti di tipo azione carta dal file XML
	 * @param elemento dell'effetto specifico da estrarre (Classe Element)
	 * @return istanza dell'effetto estratto (Classe AzioneCarta)
	 */
	
	public static AzionePrendiCartaAggiuntiva leggiEffettoAzionePrendiCartaAggiuntiva (Element effetto) {
		
		int valoreDadoCarta = Integer.parseInt(effetto.getElementsByTagName("valoreDado").item(0).getFirstChild().getNodeValue());
		String tipoCarta = effetto.getElementsByTagName("tipoCarta").item(0).getFirstChild().getNodeValue();
		
		TipoCarta tipoCartaEnum = null;
		switch(tipoCarta.toUpperCase()){
			case "TERRITORIO": 
				tipoCartaEnum = TipoCarta.TERRITORIO;
				break;
			case "EDIFICIO": 
				tipoCartaEnum = TipoCarta.EDIFICIO;
				break;
			case "PERSONAGGIO": 
				tipoCartaEnum = TipoCarta.PERSONAGGIO;
				break;
			case "IMPRESA": 
				tipoCartaEnum = TipoCarta.IMPRESA;
				break;
			case "ALL": 
				tipoCartaEnum = TipoCarta.ALL;
		}
		
		AzionePrendiCartaAggiuntiva azione = new AzionePrendiCartaAggiuntiva (tipoCartaEnum, valoreDadoCarta);
		return azione;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI EFFETTO AZIONE CARTA CON SCONTO
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre gli effetti di tipo azione carta dal file XML
	 * @param elemento dell'effetto specifico da estrarre (Classe Element)
	 * @return istanza dell'effetto estratto (Classe AzioneCarta)
	 */
	
	public static AzionePrendiCartaAggiuntivaConSconto leggiEffettoAzionePrendiCartaAggiuntivaConSconto (Element effetto) {
		
		int valoreDadoCarta = Integer.parseInt(effetto.getElementsByTagName("valoreDado").item(0).getFirstChild().getNodeValue());
		String tipoCarta = effetto.getElementsByTagName("tipoCarta").item(0).getFirstChild().getNodeValue();
		
		TipoCarta tipoCartaEnum = null;
		switch(tipoCarta.toUpperCase()){
			case "TERRITORIO": 
				tipoCartaEnum = TipoCarta.TERRITORIO;
				break;
			case "EDIFICIO": 
				tipoCartaEnum = TipoCarta.EDIFICIO;
				break;
			case "PERSONAGGIO": 
				tipoCartaEnum = TipoCarta.PERSONAGGIO;
				break;
			case "IMPRESA": 
				tipoCartaEnum = TipoCarta.IMPRESA;
				break;
			case "ALL": 
				tipoCartaEnum = TipoCarta.ALL;
		}
		
		NodeList setRisorse = effetto.getElementsByTagName("setRisorse");
		SetRisorse sconto=null;		
		
		for(int i=0; i<setRisorse.getLength(); ++i) {
			
			Element SingoloCosto = (Element) setRisorse.item(i);
			HashSet<Risorsa> risorseMap = new HashSet<>();
			NodeList risorse = SingoloCosto.getElementsByTagName("risorsa");
	    	int contRisorse = risorse.getLength();
	    	
	    	for(int j=0; j<contRisorse; j++) {
	    		 Element risorsa = (Element) risorse.item(j);
	    		 int quantita = Integer.parseInt(risorsa.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue());
	    		 
	    		 switch(risorsa.getAttribute("tipo").toUpperCase()) {
	    		 	case "LEGNA":
	    		 		Legna legna = new Legna(quantita);
	    		 		risorseMap.add(legna);
	    		 		break;
	    		 	case "PIETRA":
	    		 		Pietra pietra = new Pietra(quantita);
	    		 		risorseMap.add(pietra);
	    		 		break;
	    		 	case "ORO":
	    		 		Oro oro = new Oro(quantita);
	    		 		risorseMap.add(oro);
	    		 		break;
	    		 	case "SERVITORI":
	    		 		Servitori servitori = new Servitori(quantita);
	    		 		risorseMap.add(servitori);
	    		 		break;
	    		 	case "PUNTIMILITARI":
	    		 		PuntiMilitari puntiMilitari = new PuntiMilitari(quantita);
	    		 		risorseMap.add(puntiMilitari);
	    		 		break;
	    		 	case "PUNTIFEDE":
	    		 		PuntiFede puntiFede = new PuntiFede(quantita);
	    		 		risorseMap.add(puntiFede);
	    		 		break;
	    		 	case "PUNTIVITTORIA":
	    		 		PuntiVittoria puntiVittoria = new PuntiVittoria(quantita);
	    		 		risorseMap.add(puntiVittoria);
	    		 		break;
	    		 	case "PRIVILEGI":
	    		 		Privilegi privilegi = new Privilegi(quantita);
	    		 		risorseMap.add(privilegi);
	    		 		break;
	    		 }
	    	}
	    	
	    	sconto = new SetRisorse (risorseMap);
		}
		
		AzionePrendiCartaAggiuntivaConSconto azione = new AzionePrendiCartaAggiuntivaConSconto (tipoCartaEnum, valoreDadoCarta, sconto);
		return azione;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI EFFETTO MOLTIPLICAZIONE
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre gli effetti di tipo moltiplicazione dal file XML
	 * @param elemento dell'effetto specifico da estrarre (Classe Element)
	 * @return istanza dell'effetto estratto (Classe Moltiplicazione)
	 */
	public static RisorsePerRisorse leggiEffettorRisorsePerRisorse(Element effetto) {
		
		String tipoRisorsa = effetto.getElementsByTagName("tipoRisorsa").item(0).getFirstChild().getNodeValue();
		int quantitaRisorsa = Integer.parseInt(effetto.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue());
		HashSet<Risorsa> risorseMap = new HashSet<>();
		
		NodeList risorse = effetto.getElementsByTagName("risorsa");
    	int contRisorse = risorse.getLength();
    	for(int j=0; j<contRisorse; j++) {
    		 Element risorsa = (Element) risorse.item(j);
    		 int quantita = Integer.parseInt(risorsa.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue());
    		 
    		 switch(risorsa.getAttribute("tipo").toUpperCase()) {
    		 	case "LEGNA":
    		 		Legna legna = new Legna(quantita);
    		 		risorseMap.add(legna);
    		 		break;
    		 	case "PIETRA":
    		 		Pietra pietra = new Pietra(quantita);
    		 		risorseMap.add(pietra);
    		 		break;
    		 	case "ORO":
    		 		Oro oro = new Oro(quantita);
    		 		risorseMap.add(oro);
    		 		break;
    		 	case "SERVITORI":
    		 		Servitori servitori = new Servitori(quantita);
    		 		risorseMap.add(servitori);
    		 		break;
    		 	case "PUNTIMILITARI":
    		 		PuntiMilitari puntiMilitari = new PuntiMilitari(quantita);
    		 		risorseMap.add(puntiMilitari);
    		 		break;
    		 	case "PUNTIFEDE":
    		 		PuntiFede puntiFede = new PuntiFede(quantita);
    		 		risorseMap.add(puntiFede);
    		 		break;
    		 	case "PUNTIVITTORIA":
    		 		PuntiVittoria puntiVittoria = new PuntiVittoria(quantita);
    		 		risorseMap.add(puntiVittoria);
    		 		break;
    		 	case "PRIVILEGI":
    		 		Privilegi privilegi = new Privilegi(quantita);
    		 		risorseMap.add(privilegi);
    		 		break;
    		 }
    	}
    	
    	SetRisorse setRisorse = new SetRisorse (risorseMap);
        
        TipoRisorsa tipoRisorsaEnum = null;
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
	        /*case "PRIVILEGI": tipoRisorsaEnum = TipoRisorsa.PRIVILEGI;
	    		break;*/
        }
        
        RisorsePerRisorse moltiplicazione = new RisorsePerRisorse(setRisorse, quantitaRisorsa, tipoRisorsaEnum);
        
		return moltiplicazione;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI EFFETTO MOLTIPLICAZIONE
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre gli effetti di tipo moltiplicazione dal file XML
	 * @param elemento dell'effetto specifico da estrarre (Classe Element)
	 * @return istanza dell'effetto estratto (Classe Moltiplicazione)
	 */
	public static RisorsePerCarte leggiEffettoRisorsePerCarte(Element effetto) {
		
		String tipoCarta = effetto.getElementsByTagName("tipoCarta").item(0).getFirstChild().getNodeValue();
		int quantitaCarta = Integer.parseInt(effetto.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue());
		HashSet<Risorsa> risorseMap = new HashSet<>();
		
		NodeList risorse = effetto.getElementsByTagName("risorsa");
    	int contRisorse = risorse.getLength();
    	for(int j=0; j<contRisorse; j++) {
    		 Element risorsa = (Element) risorse.item(j);
    		 int quantita = Integer.parseInt(risorsa.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue());
    		 
    		 switch(risorsa.getAttribute("tipo").toUpperCase()) {
    		 	case "LEGNA":
    		 		Legna legna = new Legna(quantita);
    		 		risorseMap.add(legna);
    		 		break;
    		 	case "PIETRA":
    		 		Pietra pietra = new Pietra(quantita);
    		 		risorseMap.add(pietra);
    		 		break;
    		 	case "ORO":
    		 		Oro oro = new Oro(quantita);
    		 		risorseMap.add(oro);
    		 		break;
    		 	case "SERVITORI":
    		 		Servitori servitori = new Servitori(quantita);
    		 		risorseMap.add(servitori);
    		 		break;
    		 	case "PUNTIMILITARI":
    		 		PuntiMilitari puntiMilitari = new PuntiMilitari(quantita);
    		 		risorseMap.add(puntiMilitari);
    		 		break;
    		 	case "PUNTIFEDE":
    		 		PuntiFede puntiFede = new PuntiFede(quantita);
    		 		risorseMap.add(puntiFede);
    		 		break;
    		 	case "PUNTIVITTORIA":
    		 		PuntiVittoria puntiVittoria = new PuntiVittoria(quantita);
    		 		risorseMap.add(puntiVittoria);
    		 		break;
    		 	case "PRIVILEGI":
    		 		Privilegi privilegi = new Privilegi(quantita);
    		 		risorseMap.add(privilegi);
    		 		break;
    		 }
    	}
    	
    	SetRisorse setRisorse = new SetRisorse (risorseMap);
        
        TipoCarta tipoCartaEnum = null;
        switch(tipoCarta.toUpperCase()){
	        case "TERRITORIO": tipoCartaEnum = TipoCarta.TERRITORIO;
	        	break;
	        case "EDIFICIO": tipoCartaEnum = TipoCarta.EDIFICIO;
	    		break;
	        case "PERSONAGGIO": tipoCartaEnum = TipoCarta.PERSONAGGIO;
	    		break;
	        case "IMPRESA": tipoCartaEnum = TipoCarta.IMPRESA;
	    		break;
        }
        
        RisorsePerCarte moltiplicazione = new RisorsePerCarte(setRisorse, quantitaCarta, tipoCartaEnum);
        
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
			HashSet<Risorsa> risorseMap = new HashSet<>();
			NodeList risorse = SingoloCosto.getElementsByTagName("risorsa");
	    	int contRisorse = risorse.getLength();
	    	
	    	for(int j=0; j<contRisorse; j++) {
	    		 Element risorsa = (Element) risorse.item(j);
	    		 int quantita = Integer.parseInt(risorsa.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue());
	    		 
	    		 switch(risorsa.getAttribute("tipo").toUpperCase()) {
	    		 	case "LEGNA":
	    		 		Legna legna = new Legna(quantita);
	    		 		risorseMap.add(legna);
	    		 		break;
	    		 	case "PIETRA":
	    		 		Pietra pietra = new Pietra(quantita);
	    		 		risorseMap.add(pietra);
	    		 		break;
	    		 	case "ORO":
	    		 		Oro oro = new Oro(quantita);
	    		 		risorseMap.add(oro);
	    		 		break;
	    		 	case "SERVITORI":
	    		 		Servitori servitori = new Servitori(quantita);
	    		 		risorseMap.add(servitori);
	    		 		break;
	    		 	case "PUNTIMILITARI":
	    		 		PuntiMilitari puntiMilitari = new PuntiMilitari(quantita);
	    		 		risorseMap.add(puntiMilitari);
	    		 		break;
	    		 	case "PUNTIFEDE":
	    		 		PuntiFede puntiFede = new PuntiFede(quantita);
	    		 		risorseMap.add(puntiFede);
	    		 		break;
	    		 	case "PUNTIVITTORIA":
	    		 		PuntiVittoria puntiVittoria = new PuntiVittoria(quantita);
	    		 		risorseMap.add(puntiVittoria);
	    		 		break;
	    		 	case "PRIVILEGI":
	    		 		Privilegi privilegi = new Privilegi(quantita);
	    		 		risorseMap.add(privilegi);
	    		 		break;
	    		 }
	    	}
	    	
            switch(SingoloCosto.getAttribute("id")){
			case "pagamento":
				pagamento = new SetRisorse (risorseMap);
				break;
			case "guadagno":
				guadagno = new SetRisorse (risorseMap);
				break;
			case "pagamento2":
				pagamento2 = new SetRisorse (risorseMap);
				break;
			case "guadagno2":
				guadagno2 = new SetRisorse (risorseMap);
				break;
			default:
            }
		}
		
		Scambio scambio = new Scambio (pagamento, guadagno, pagamento2, guadagno2);
		return scambio;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI EFFETTO SCONTO
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre gli effetti di tipo scambio dal file XML
	 * @param elemento dell'effetto specifico da estrarre (Classe Element)
	 * @return istanza dell'effetto estratto (Classe Scambio)
	 */
	public static ScontoCostoCarte leggiEffettoScontoCostoCarte(Element effetto) {
		
		String tipoCarta = effetto.getElementsByTagName("tipoCarta").item(0).getFirstChild().getNodeValue();
		
		NodeList setRisorse = effetto.getElementsByTagName("setRisorse");
		SetRisorse sconto=null;		
		
		for(int i=0; i<setRisorse.getLength(); ++i) {
			
			Element SingoloCosto = (Element) setRisorse.item(i);
			HashSet<Risorsa> risorseMap = new HashSet<>();
			NodeList risorse = SingoloCosto.getElementsByTagName("risorsa");
	    	int contRisorse = risorse.getLength();
	    	
	    	for(int j=0; j<contRisorse; j++) {
	    		 Element risorsa = (Element) risorse.item(j);
	    		 int quantita = Integer.parseInt(risorsa.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue());
	    		 
	    		 switch(risorsa.getAttribute("tipo").toUpperCase()) {
	    		 	case "LEGNA":
	    		 		Legna legna = new Legna(quantita);
	    		 		risorseMap.add(legna);
	    		 		break;
	    		 	case "PIETRA":
	    		 		Pietra pietra = new Pietra(quantita);
	    		 		risorseMap.add(pietra);
	    		 		break;
	    		 	case "ORO":
	    		 		Oro oro = new Oro(quantita);
	    		 		risorseMap.add(oro);
	    		 		break;
	    		 	case "SERVITORI":
	    		 		Servitori servitori = new Servitori(quantita);
	    		 		risorseMap.add(servitori);
	    		 		break;
	    		 	case "PUNTIMILITARI":
	    		 		PuntiMilitari puntiMilitari = new PuntiMilitari(quantita);
	    		 		risorseMap.add(puntiMilitari);
	    		 		break;
	    		 	case "PUNTIFEDE":
	    		 		PuntiFede puntiFede = new PuntiFede(quantita);
	    		 		risorseMap.add(puntiFede);
	    		 		break;
	    		 	case "PUNTIVITTORIA":
	    		 		PuntiVittoria puntiVittoria = new PuntiVittoria(quantita);
	    		 		risorseMap.add(puntiVittoria);
	    		 		break;
	    		 	case "PRIVILEGI":
	    		 		Privilegi privilegi = new Privilegi(quantita);
	    		 		risorseMap.add(privilegi);
	    		 		break;
	    		 }
	    	}
	    	
	    	sconto = new SetRisorse (risorseMap);
		}
		
		TipoCarta tipoCartaEnum = null;
		switch(tipoCarta.toUpperCase()) {
		case "TERRITORIO":
			tipoCartaEnum = TipoCarta.TERRITORIO;
			break;
		case "EDIFICIO":
			tipoCartaEnum = TipoCarta.EDIFICIO;
			break;
		case "PERSONAGGIO":
			tipoCartaEnum = TipoCarta.PERSONAGGIO;
			break;
		case "IMPRESA":
			tipoCartaEnum = TipoCarta.IMPRESA;
			break;
		case "ALL":
			tipoCartaEnum = TipoCarta.ALL;
			break;
		}
		
		ScontoCostoCarte scontoCostoCarte = new ScontoCostoCarte (sconto, tipoCartaEnum);
		return scontoCostoCarte;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI EFFETTO RIDUCI GUADAGNO CARTE
	//--------------------------------------------------------------------------------------------------------------//
	public static BonusRisorseCarte leggiEffettoRiduciGuadagnoCarte (Element effetto) {
		
		String risorsa = effetto.getElementsByTagName("risorsa").item(0).getFirstChild().getNodeValue();
		TipoRisorsa tipoRisorsa = null;
		
		switch(risorsa.toUpperCase()) {
	 	case "LEGNA":
	 		tipoRisorsa = TipoRisorsa.LEGNA;
	 		break;
	 	case "PIETRA":
	 		tipoRisorsa = TipoRisorsa.PIETRA;
	 		break;
	 	case "ORO":
	 		tipoRisorsa = TipoRisorsa.ORO;
	 		break;
	 	case "SERVITORI":
	 		tipoRisorsa = TipoRisorsa.SERVITORI;
	 		break;
	 	case "PUNTIMILITARI":
	 		tipoRisorsa = TipoRisorsa.PUNTIMILITARI;
	 		break;
	 	case "PUNTIFEDE":
	 		tipoRisorsa = TipoRisorsa.PUNTIFEDE;
	 		break;
	 	case "PUNTIVITTORIA":
	 		tipoRisorsa = TipoRisorsa.PUNTIVITTORIA;
	 		break;
	 	case "PRIVILEGI":
	 		tipoRisorsa = TipoRisorsa.PRIVILEGI;
	 		break;
		}
		
		return new BonusRisorseCarte(-1, tipoRisorsa);
		
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI EFFETTO RIDUCI GUADAGNO SPAZI
	//--------------------------------------------------------------------------------------------------------------//
	public static BonusRisorseSpazi leggiEffettoRiduciGuadagnoSpazi (Element effetto) {
		
		String risorsa = effetto.getElementsByTagName("risorsa").item(0).getFirstChild().getNodeValue();
		TipoRisorsa tipoRisorsa = null;
		
		switch(risorsa.toUpperCase()) {
	 	case "LEGNA":
	 		tipoRisorsa = TipoRisorsa.LEGNA;
	 		break;
	 	case "PIETRA":
	 		tipoRisorsa = TipoRisorsa.PIETRA;
	 		break;
	 	case "ORO":
	 		tipoRisorsa = TipoRisorsa.ORO;
	 		break;
	 	case "SERVITORI":
	 		tipoRisorsa = TipoRisorsa.SERVITORI;
	 		break;
	 	case "PUNTIMILITARI":
	 		tipoRisorsa = TipoRisorsa.PUNTIMILITARI;
	 		break;
	 	case "PUNTIFEDE":
	 		tipoRisorsa = TipoRisorsa.PUNTIFEDE;
	 		break;
	 	case "PUNTIVITTORIA":
	 		tipoRisorsa = TipoRisorsa.PUNTIVITTORIA;
	 		break;
	 	case "PRIVILEGI":
	 		tipoRisorsa = TipoRisorsa.PRIVILEGI;
	 		break;
		}
		
		return new BonusRisorseSpazi(-1, tipoRisorsa);
		
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
		String tipoCarta = effetto.getElementsByTagName("tipoCarta").item(0).getFirstChild().getNodeValue();
		
		TipoCarta tipoCartaEnum = null;
		switch(tipoCarta.toUpperCase()){
			case "TERRITORIO": 
				tipoCartaEnum = TipoCarta.TERRITORIO;
				break;
			case "PERSONAGGIO": 
				tipoCartaEnum = TipoCarta.PERSONAGGIO;
				break;
			case "EDIFICIO": 
				tipoCartaEnum = TipoCarta.EDIFICIO;
				break;
			case "IMPRESA": 
				tipoCartaEnum = TipoCarta.IMPRESA;
				break;
			case "ALL": 
				tipoCartaEnum = TipoCarta.ALL;
		}
		
		BonusDadoCarte bonusDadoCarte = new BonusDadoCarte(tipoCartaEnum, valoreDadoCarta);
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
	// LEGGI EFFETTO NO BONUS SPAZIO TORRI
	//--------------------------------------------------------------------------------------------------------------//
	public static NegaBonusSpazioTorri leggiEffettoNegaBonusSpazioTorri () {
		NegaBonusSpazioTorri negaBonusSpaziTorre = new NegaBonusSpazioTorri ();
		return negaBonusSpaziTorre;
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
	// LEGGI EFFETTO BONUS PV CHIESTA
	//--------------------------------------------------------------------------------------------------------------//
	public static MoltiplicaRisorseCarte leggiEffettoMoltiplicaRisorseCarte() {
		MoltiplicaRisorseCarte effetto = new MoltiplicaRisorseCarte(2);
		return effetto;
	}
		
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI EFFETTO ANNULLA GUADAGNO
	//--------------------------------------------------------------------------------------------------------------//
	public static AnnullaGuadagno leggiEffettoAnnullaGuadagno (Element effetto)
	{
		String tipoCarta = effetto.getElementsByTagName("tipoCarta").item(0).getFirstChild().getNodeValue();
		
		TipoCarta tipoCartaEnum = null;
		
		switch(tipoCarta.toUpperCase()) {
			case "TERRITORIO": tipoCartaEnum = TipoCarta.TERRITORIO;
				break;
			case "EDIFICIO": tipoCartaEnum = TipoCarta.EDIFICIO;
				break;
			case "PERSONAGGIO": tipoCartaEnum = TipoCarta.PERSONAGGIO;
				break;
			case "IMPRESA": tipoCartaEnum = TipoCarta.IMPRESA;
				break;
			case "ALL": tipoCartaEnum = TipoCarta.ALL;
				break;	
		}
		
		AnnullaGuadagno annullaGuadagno = new AnnullaGuadagno(tipoCartaEnum);
		return annullaGuadagno;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI CARTA LEADER
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre le carte leader dal file XML
	 * @param nome della carta leader che si vuole estrarre (String)
	 * @return istanza della carta leader desiderata
	 */
	public static ArrayList<Leader> leggiCartaLeader (){
		
		ArrayList<Leader> listaLeader = new ArrayList<Leader>();
		
		try{
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			Document document = builder.parse(new File("XML/Leaders_v2.0.xml"));
			
			NodeList leaders = document.getElementsByTagName("leader");
			
			for(int i=0; i<leaders.getLength(); i++) {
				
				Leader leaderEstratto = null;
				Set<Effetto> effetti = new HashSet<Effetto>();
				HashSet<Risorsa> risorseMap = new HashSet<>();
				Element leader = (Element) leaders.item(i);
				String nomeLeader = leader.getElementsByTagName("nome").item(0).getFirstChild().getNodeValue();
				SetRisorse requisitoMaterie;
				HashMap<TipoCarta, Integer> requisitoCarte = new HashMap<TipoCarta, Integer>();	
				
				String id = leader.getAttribute("id");
				String pathImg = "img/Leaders/leaders_f_c_"+id+".jpg";
				
				//System.out.println(pathImg);
				/*System.out.println("-------------------------------------------");
				System.out.println("Nome leader: "+nomeLeader);*/
				
				try{
					NodeList carte = leader.getElementsByTagName("carta");
					int fine = carte.getLength();
					if(fine!=0) {
						for(int j=0; j<fine; j++) {
							Element carta = (Element) carte.item(j);
							
							String tipoCarta = carta.getElementsByTagName("tipo").item(0).getFirstChild().getNodeValue();
							int quantita = Integer.parseInt(carta.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue());
							//System.out.println("Devi avere "+quantita+" carte"+ tipoCarta);
							TipoCarta tipoCartaEnum = null;
							switch(tipoCarta.toUpperCase()) {
								case "EDIFICIO" : tipoCartaEnum = TipoCarta.EDIFICIO;
									break;
								case "TERRITORIO" : tipoCartaEnum= TipoCarta.TERRITORIO;
									break;
								case "PERSONAGGIO" : tipoCartaEnum = TipoCarta.PERSONAGGIO;
									break;
								case "IMPRESA" : tipoCartaEnum = TipoCarta.IMPRESA;
									break;
								case "ALL": tipoCartaEnum = TipoCarta.ALL;
									break;
							}
							
							
							
							requisitoCarte.put(tipoCartaEnum, quantita);
						}
					}
					else{
						requisitoCarte=null;
					}
				}catch(Exception e2) {
				}
					
				try{
					//------------------------------------------------------//
		      		//	FASE 2.1: ISTANZIAZIONE DEL SET RISORSE (COSTO)
		      		//------------------------------------------------------//
					NodeList risorse = leader.getElementsByTagName("risorsa");
                	int contRisorse = risorse.getLength();
                	
                	for(int j=0; j<contRisorse; j++) {
                		 Element risorsa = (Element) risorse.item(j);
                		 int quantita = Integer.parseInt(risorsa.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue());
                		 
                		 switch(risorsa.getAttribute("tipo").toUpperCase()) {
                		 	case "LEGNA":
                		 		/*System.out.println("Legna richiesta: "+quantita);*/
                		 		Legna legna = new Legna(quantita);
                		 		risorseMap.add(legna);
                		 		break;
                		 	case "PIETRA":
                		 		/*System.out.println("Pietra richiesta: "+quantita);*/
                		 		Pietra pietra = new Pietra(quantita);
                		 		risorseMap.add(pietra);
                		 		break;
                		 	case "ORO":
                		 		/*System.out.println("Oro richiesto: "+quantita);*/
                		 		Oro oro = new Oro(quantita);
                		 		risorseMap.add(oro);
                		 		break;
                		 	case "SERVITORI":
                		 		/*System.out.println("Servitori richiesti: "+quantita);*/
                		 		Servitori servitori = new Servitori(quantita);
                		 		risorseMap.add(servitori);
                		 		break;
                		 	case "PUNTIMILITARI":
                		 		/*System.out.println("Punti militari richiesti: "+quantita);*/
                		 		PuntiMilitari puntiMilitari = new PuntiMilitari(quantita);
                		 		risorseMap.add(puntiMilitari);
                		 		break;
                		 	case "PUNTIFEDE":
                		 		/*System.out.println("Punti fede richiesti: "+quantita);*/
                		 		PuntiFede puntiFede = new PuntiFede(quantita);
                		 		risorseMap.add(puntiFede);
                		 		break;
                		 	case "PUNTIVITTORIA":
                		 		/*System.out.println("Punti vittoria richiesti: "+quantita);*/
                		 		PuntiVittoria puntiVittoria = new PuntiVittoria(quantita);
                		 		risorseMap.add(puntiVittoria);
                		 		break;
                		 	case "PRIVILEGI":
                		 		/*System.out.println("Privilegi richiesti: "+quantita);*/
                		 		Privilegi privilegi = new Privilegi(quantita);
                		 		risorseMap.add(privilegi);
                		 		break;
                		 	default:
                		 		System.out.println("Nessun costo");
                		 }
                	}
                	requisitoMaterie = new SetRisorse (risorseMap);
				}catch(Exception e1) {
					requisitoMaterie = null;
				}
				
				String tipologia = ((Element)(leader.getElementsByTagName("effetti")).item(0)).getAttribute("tipo");
				/*System.out.println("questo leader ha un effetto di tipo "+tipologia);*/
				
				NodeList listaEffetti = leader.getElementsByTagName("effetto");
		        for (int j = 0; j < listaEffetti.getLength(); ++j) {
		            Element effetto = (Element) listaEffetti.item(j);
		            String effettoTipo = effetto.getFirstChild().getNodeValue();
		            /*System.out.println("effetto "+j+" "+effettoTipo);*/
		            Effetto effettoExt = getEffettoXML(effettoTipo);
		            effetti.add(effettoExt);
		        }
			        
		        if(tipologia.equals("turno"))
		        	leaderEstratto = new Leader (nomeLeader, effetti, null, requisitoMaterie, requisitoCarte, pathImg);
		        if(tipologia.equals("permanente"))
		        	leaderEstratto = new Leader (nomeLeader, null, effetti, requisitoMaterie, requisitoCarte, pathImg);
		        
		        listaLeader.add(leaderEstratto);
			}
		}catch(Exception e){
			 
		}	
		
		return listaLeader;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI SCOMUNICA
	//--------------------------------------------------------------------------------------------------------------//
	/**
	 * metodo che permette di estrarre i dati relativi alle scomuniche dal relativo file XML
	 * @param di quale periodo deve essere la scomuniche che si andrà a leggere (Integer)
	 * @return istanza della scomunica (Classe TesseraScomunica)
	 */
	public static TesseraScomunica leggiScomunica (int periodo){
		
		ArrayList<TesseraScomunica> scomuniche = new ArrayList<TesseraScomunica>();
		String effettoScomunica;
		
		try{
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			Document document = builder.parse(new File("XML/Scomuniche.xml"));
			
			NodeList scomunicheList = document.getElementsByTagName("scomunica");
			
			for(int i=0; i<scomunicheList.getLength(); i++){
				
				Element scomunica = (Element) scomunicheList.item(i);
				int periodoLetto = Integer.parseInt(scomunica.getElementsByTagName("periodo").item(0).getFirstChild().getNodeValue());
				
				if(periodoLetto == periodo){
					
					String id =scomunica.getAttribute("id");
					String pathImg = "img/Scomuniche/excomm_"+id.charAt(0)+"_"+id.charAt(1)+".png";
					
					//System.out.println(pathImg);
					
					Set<Effetto> effetti = new HashSet<Effetto>();
					
					NodeList listaEffetti = scomunica.getElementsByTagName("effetto");
			        for (int j = 0; j < listaEffetti.getLength(); ++j) {
			            Element effetto = (Element) listaEffetti.item(j);
			            String effettoTipo = effetto.getFirstChild().getNodeValue();
			            Effetto effettoExt = getEffettoXML(effettoTipo);
			            effetti.add(effettoExt);
			        }
					
			        TesseraScomunica tesseraScomunica = new TesseraScomunica (Integer.parseInt(id),periodoLetto,effetti,pathImg);
			        
					scomuniche.add(tesseraScomunica);
				}
					
			}
		}catch(Exception e){
			 
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
			Document document = builder.parse(new File("XML/SetRisorseSpazi_v2.0.xml"));
			
			NodeList spazi = document.getElementsByTagName("tipoSpazio");
			HashSet<Risorsa> risorseMap = new HashSet<>();
			
			for(int i=0; i<spazi.getLength(); i++){	
				
				Element spazio = (Element) spazi.item(i);
				
				if(spazio.getAttribute("tipo").equals(tipoSpazio)) {
					
					NodeList risorse = spazio.getElementsByTagName("risorsa");
                	int contRisorse = risorse.getLength();
                	
                	for(int j=0; j<contRisorse; j++) {
                		 Element risorsa = (Element) risorse.item(j);
                		 int quantita = Integer.parseInt(risorsa.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue());
                		 
                		 switch(risorsa.getAttribute("tipo").toUpperCase()) {
                		 	case "LEGNA":
                		 		Legna legna = new Legna(quantita);
                		 		risorseMap.add(legna);
                		 		break;
                		 	case "PIETRA":
                		 		Pietra pietra = new Pietra(quantita);
                		 		risorseMap.add(pietra);
                		 		break;
                		 	case "ORO":
                		 		Oro oro = new Oro(quantita);
                		 		risorseMap.add(oro);
                		 		break;
                		 	case "SERVITORI":
                		 		Servitori servitori = new Servitori(quantita);
                		 		risorseMap.add(servitori);
                		 		break;
                		 	case "PUNTIMILITARI":
                		 		PuntiMilitari puntiMilitari = new PuntiMilitari(quantita);
                		 		risorseMap.add(puntiMilitari);
                		 		break;
                		 	case "PUNTIFEDE":
                		 		PuntiFede puntiFede = new PuntiFede(quantita);
                		 		risorseMap.add(puntiFede);
                		 		break;
                		 	case "PUNTIVITTORIA":
                		 		PuntiVittoria puntiVittoria = new PuntiVittoria(quantita);
                		 		risorseMap.add(puntiVittoria);
                		 		break;
                		 	case "PRIVILEGI":
                		 		Privilegi privilegi = new Privilegi(quantita);
                		 		risorseMap.add(privilegi);
                		 		break;
                		 }
                	}
                	     
		            setRisorse = new SetRisorse (risorseMap);
				}
			}
		}catch(Exception e){
			 
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
			 
		}	
		return valore;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI PERSONAL BONUS
	//--------------------------------------------------------------------------------------------------------------//
	public static ArrayList<SetRisorse> leggiTessereBonusProduzione() {
		
		ArrayList<SetRisorse> setBonusProduzione = new ArrayList<SetRisorse>();
		try{
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			Document document = builder.parse(new File("XML/PersonalBonusProduzione.xml"));
			
			NodeList bonus = document.getElementsByTagName("bonus");
			
			for(int i=0; i<bonus.getLength(); i++){
				
				Element bonusItem = (Element) bonus.item(i);
				
				HashSet<Risorsa> risorseMap = new HashSet<>();
				SetRisorse risorseBonus=null;
				String imgPath = bonusItem.getElementsByTagName("img").item(0).getFirstChild().getNodeValue();
					
				NodeList risorse = bonusItem.getElementsByTagName("risorsa");
            	int contRisorse = risorse.getLength();
            	
            	for(int j=0; j<contRisorse; j++) {
            		
            		 Element risorsa = (Element) risorse.item(j);
            		 int quantita = Integer.parseInt(risorsa.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue());
            		 
            		 switch(risorsa.getAttribute("tipo").toUpperCase()) {
            		 	case "LEGNA":
            		 		Legna legna = new Legna(quantita);
            		 		risorseMap.add(legna);
            		 		break;
            		 	case "PIETRA":
            		 		Pietra pietra = new Pietra(quantita);
            		 		risorseMap.add(pietra);
            		 		break;
            		 	case "ORO":
            		 		Oro oro = new Oro(quantita);
            		 		risorseMap.add(oro);
            		 		break;
            		 	case "SERVITORI":
            		 		Servitori servitori = new Servitori(quantita);
            		 		risorseMap.add(servitori);
            		 		break;
            		 	case "PUNTIMILITARI":
            		 		PuntiMilitari puntiMilitari = new PuntiMilitari(quantita);
            		 		risorseMap.add(puntiMilitari);
            		 		break;
            		 	case "PUNTIFEDE":
            		 		PuntiFede puntiFede = new PuntiFede(quantita);
            		 		risorseMap.add(puntiFede);
            		 		break;
            		 	case "PUNTIVITTORIA":
            		 		PuntiVittoria puntiVittoria = new PuntiVittoria(quantita);
            		 		risorseMap.add(puntiVittoria);
            		 		break;
            		 	case "PRIVILEGI":
            		 		Privilegi privilegi = new Privilegi(quantita);
            		 		risorseMap.add(privilegi);
            		 		break;
            		 }
            	}
            	risorseBonus = new SetRisorse (risorseMap);
            	setBonusProduzione.add(risorseBonus);
			}
		}catch(Exception e){
			 
		}	
		return setBonusProduzione;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// LEGGI PERSONAL BONUS
	//--------------------------------------------------------------------------------------------------------------//
	public static ArrayList<SetRisorse> leggiTessereBonusRaccolta() {
		
		ArrayList<SetRisorse> setBonusRaccolta = new ArrayList<SetRisorse>();
		try{
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			Document document = builder.parse(new File("XML/PersonalBonusRaccolta.xml"));
			
			NodeList bonus = document.getElementsByTagName("bonus");
			
			for(int i=0; i<bonus.getLength(); i++){
				
				Element bonusItem = (Element) bonus.item(i);
				
				HashSet<Risorsa> risorseMap = new HashSet<>();
				SetRisorse risorseBonus=null;
				String imgPath = bonusItem.getElementsByTagName("img").item(0).getFirstChild().getNodeValue();
					
				NodeList risorse = bonusItem.getElementsByTagName("risorsa");
            	int contRisorse = risorse.getLength();
            	
            	for(int j=0; j<contRisorse; j++) {
            		
            		 Element risorsa = (Element) risorse.item(j);
            		 int quantita = Integer.parseInt(risorsa.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue());
            		 
            		 switch(risorsa.getAttribute("tipo").toUpperCase()) {
            		 	case "LEGNA":
            		 		Legna legna = new Legna(quantita);
            		 		risorseMap.add(legna);
            		 		break;
            		 	case "PIETRA":
            		 		Pietra pietra = new Pietra(quantita);
            		 		risorseMap.add(pietra);
            		 		break;
            		 	case "ORO":
            		 		Oro oro = new Oro(quantita);
            		 		risorseMap.add(oro);
            		 		break;
            		 	case "SERVITORI":
            		 		Servitori servitori = new Servitori(quantita);
            		 		risorseMap.add(servitori);
            		 		break;
            		 	case "PUNTIMILITARI":
            		 		PuntiMilitari puntiMilitari = new PuntiMilitari(quantita);
            		 		risorseMap.add(puntiMilitari);
            		 		break;
            		 	case "PUNTIFEDE":
            		 		PuntiFede puntiFede = new PuntiFede(quantita);
            		 		risorseMap.add(puntiFede);
            		 		break;
            		 	case "PUNTIVITTORIA":
            		 		PuntiVittoria puntiVittoria = new PuntiVittoria(quantita);
            		 		risorseMap.add(puntiVittoria);
            		 		break;
            		 	case "PRIVILEGI":
            		 		Privilegi privilegi = new Privilegi(quantita);
            		 		risorseMap.add(privilegi);
            		 		break;
            		 }
            	}
            	risorseBonus = new SetRisorse (risorseMap);
            	setBonusRaccolta.add(risorseBonus);
			}
		}catch(Exception e){
			 
		}	
		return setBonusRaccolta;
	}
	
	public static ArrayList<TesseraBonus> leggiTessereBonus() {
		
		ArrayList<TesseraBonus> tessereBonus = new ArrayList<TesseraBonus>();
		
		ArrayList<SetRisorse> bonusProduzione = leggiTessereBonusRaccolta();
		ArrayList<SetRisorse> bonusRaccolta = leggiTessereBonusProduzione();
		
		try{
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			Document document = builder.parse(new File("XML/PersonalBonusRaccolta.xml"));
			
			NodeList bonus = document.getElementsByTagName("bonus");
			
			for(int i=0; i<bonus.getLength(); i++){
				
				Element bonusItem = (Element) bonus.item(i);
				
				String imgPath = bonusItem.getElementsByTagName("img").item(0).getFirstChild().getNodeValue();
				
				tessereBonus.add(new TesseraBonus(bonusProduzione.get(i),bonusRaccolta.get(i),imgPath));
				
			}
		}catch(Exception e){
			 
		}	
		return tessereBonus;
	}
}
