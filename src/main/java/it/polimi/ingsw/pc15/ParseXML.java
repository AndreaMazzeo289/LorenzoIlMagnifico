package it.polimi.ingsw.pc15;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParseXML {
	
	//--------------------------------------------------------------------------------------------------------------//
	// Nome metodo: 			GetCartaXML
	// Parametri di ingresso: 	Colore della carta che si vuole estrarre (enum ColoreCarta)
	// Parametri di uscita:   	Istanza della classe Carta che contiene tutte le informazioni relative alla carta
	// Descrizione:				Metodo che gestisce l'estrazione delle carte dal relativo file XML chiamando 
	//							opportuni metodi per ogni tipologia di carta
	//--------------------------------------------------------------------------------------------------------------//	
	public Carta getCartaXML (ColoreCarta coloreCarta){
		
		Carta cartaSelezionata = null;
		
		try{
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			Document document = builder.parse(new File("/Users/andre/LaboratorioProvaFinale/prova-finale-template/XML/Cards_v1.4.xml"));
			
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
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		
		return cartaSelezionata;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// Nome metodo: 			GetEffettoXML
	// Parametri di ingresso: 	Nome dell'effetto che si vuole estrarre (String)
	// Parametri di uscita:   	Istanza dell'effetto estratto (Classe effetto)
	// Descrizione:				Metodo che gestisce l'estrazione degli effetti dal relativo file XML chiamando 
	//							opportuni metodi per ogni tipologia di effetto
	//--------------------------------------------------------------------------------------------------------------//	
	public Effetto getEffettoXML (String nomeEffetto){
		
		Effetto effettoLetto = null;
		
		try{
			
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			Document document = builder.parse(new File("/Users/andre/LaboratorioProvaFinale/prova-finale-template/XML/Effects_v2.4.xml"));
			
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
							}
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
	// Nome metodo: 			leggiEffettoAddRisorsa
	// Parametri di ingresso: 	Elemento dell'effetto specifico da estrarre
	// Parametri di uscita:   	Istanza dell'effetto estratto (Classe AggiuntaRisorse)
	// Descrizione:				Metodo che permette di estrarre gli effetti di tipo AddRisorsa dal file XML
	//--------------------------------------------------------------------------------------------------------------//
	public AggiuntaRisorse leggiEffettoAddRisorsa(Element effetto) {
		
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
	// Nome metodo: 			leggiEffettoAzioneRaccolto - leggiEffettoAzioneProduzione - leggiEffettoAzioneCarta
	// Parametri di ingresso: 	Elemento dell'effetto specifico da estrarre
	// Parametri di uscita:   	Istanza dell'effetto estratto (Classe AzioneRaccolto, AzioneProduzione, AzioneCarta)
	// Descrizione:				Metodo che permette di estrarre gli effetti di tipo azione dal file XML
	//--------------------------------------------------------------------------------------------------------------//
	public AzioneRaccolto leggiEffettoAzioneRaccolto (Element effetto) {
		
		int valoreDadoRaccolta = Integer.parseInt(effetto.getElementsByTagName("valoreDado").item(0).getFirstChild().getNodeValue());
		
		AzioneRaccolto azioneRaccolto = new AzioneRaccolto (valoreDadoRaccolta);
		return azioneRaccolto;
	}
	
	public AzioneProduzione leggiEffettoAzioneProduzione (Element effetto) {
			
		int valoreDadoProduzione = Integer.parseInt(effetto.getElementsByTagName("valoreDado").item(0).getFirstChild().getNodeValue());
			
		AzioneProduzione azioneProduzione = new AzioneProduzione (valoreDadoProduzione);
		return azioneProduzione;
	}

	public AzioneCarta leggiEffettoAzioneCarta (Element effetto) {
		
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
	// Nome metodo: 			leggiEffettoMoltiplicazione
	// Parametri di ingresso: 	Elemento dell'effetto specifico da estrarre
	// Parametri di uscita:   	Istanza dell'effetto estratto (Classe Moltiplicazione)
	// Descrizione:				Metodo che permette di estrarre gli effetti di tipo moltiplicazione dal file XML
	//--------------------------------------------------------------------------------------------------------------//
	public Moltiplicazione leggiEffettoMoltiplicazione(Element effetto) {
		
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
        }
        
		Moltiplicazione moltiplicazione = new Moltiplicazione (quantita,tipoRisorsaEnum,setRisorse);
		return moltiplicazione;
	}

	//--------------------------------------------------------------------------------------------------------------//
	// Nome metodo: 			leggiEffettoScambio
	// Parametri di ingresso: 	Elemento dell'effetto specifico da estrarre
	// Parametri di uscita:   	Istanza dell'effetto estratto (Classe Scambio)
	// Descrizione:				Metodo che permette di estrarre gli effetti di tipo scambio dal file XML
	//--------------------------------------------------------------------------------------------------------------//
	public Scambio leggiEffettoScambio(Element effetto) {
		
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
	// Nome metodo: 			leggiEffettoBonusRaccolta - leggiEffettoBonusProduzione - leggiEffettoBonusDadoCarta
	// Parametri di ingresso: 	Elemento dell'effetto specifico da estrarre
	// Parametri di uscita:   	Istanza dell'effetto estratto (Classe BonusRaccolta, BonusProduzione, BonusDadoCarte)
	// Descrizione:				Metodo che permette di estrarre gli effetti di tipo bonus dal file XML
	//--------------------------------------------------------------------------------------------------------------//
	
	// leggi effetto bonus raccolta
	//------------------------------
	public BonusRaccolta leggiEffettoBonusRaccolta (Element effetto)
	{
		int valoreDadoRaccolta = Integer.parseInt(effetto.getElementsByTagName("bonusDado").item(0).getFirstChild().getNodeValue());
		
		BonusRaccolta bonusRaccolta = new BonusRaccolta (valoreDadoRaccolta);
		return bonusRaccolta;
	}
	
	// leggi effetto bonus produzione
	//--------------------------------
	public BonusProduzione leggiEffettoBonusProduzione (Element effetto)
	{
		int valoreDadoProduzione = Integer.parseInt(effetto.getElementsByTagName("bonusDado").item(0).getFirstChild().getNodeValue());
		
		BonusProduzione bonusProduzione = new BonusProduzione (valoreDadoProduzione);
		return bonusProduzione;
	}
	
	// leggi effetto bonus dado carta
	//--------------------------------
	public BonusDadoCarte leggiEffettoBonusDadoCarta (Element effetto)
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
	// Nome metodo: 			leggiCartaVerde
	// Parametri di ingresso: 	Element della carta specifica che stiamo analizzando (Classe element)
	// Parametri di uscita:   	Istanza della carta che si vuole estrarre (Classe carta)
	// Descrizione:				Metodo che permette di estrarre le carte verdi dal file XML
	//--------------------------------------------------------------------------------------------------------------//
	public Territorio leggiCartaVerde (Element carta){
		
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
	// Nome metodo: 			leggiCartaGialla
	// Parametri di ingresso: 	Element della carta specifica che stiamo analizzando (Classe element)
	// Parametri di uscita:   	Istanza della carta che si vuole estrarre (Classe carta)
	// Descrizione:				Metodo che permette di estrarre le carte gialle dal file XML
	//--------------------------------------------------------------------------------------------------------------//
	public Edificio leggiCartaGialla (Element carta){
		
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
	// Nome metodo: 			leggiCartaBlu
	// Parametri di ingresso: 	Element della carta specifica che stiamo analizzando (Classe element)
	// Parametri di uscita:   	Istanza della carta che si vuole estrarre (Classe carta)
	// Descrizione:				Metodo che permette di estrarre le carte blu dal file XML
	//--------------------------------------------------------------------------------------------------------------//
	public Personaggio leggiCartaBlu(Element carta){
		
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
			System.out.println("*   Effetto del personaggio  |   " + effettoPersonaggio);
		}catch (NullPointerException e){
			System.out.println("*   Effetto del personaggio  |   Nessun effetto per questo personaggio");
		}
		
		//------------------------------------------------------//
		//	FASE 3: CICLIO DI ACQUISIZIONE DEGLI EFFETTI IMMEDIATI
		//------------------------------------------------------//
		NodeList listaEffettiImm = carta.getElementsByTagName("effettoImm");
        for (int j = 0; j < listaEffettiImm.getLength(); ++j) {
            Element effetto = (Element) listaEffettiImm.item(j);
            String effettoTipo = effetto.getFirstChild().getNodeValue();
            System.out.println("*   Effetto immediato " + j + "      |   " + effettoTipo);
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
	// Nome metodo: 			leggiCartaViola
	// Parametri di ingresso: 	Element della carta specifica che stiamo analizzando (Classe element)
	// Parametri di uscita:   	Istanza della carta che si vuole estrarre (Classe carta)
	// Descrizione:				Metodo che permette di estrarre le carte viola dal file XML
	//--------------------------------------------------------------------------------------------------------------//
	public Impresa leggiCartaViola (Element carta){
		
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
	// Nome metodo: 			leggiSpazioTorre
	// Parametri di ingresso: 	ColoreTorre (enum), numeroSpazio
	// Parametri di uscita:   	ArrayList che contiene i quattro SpazioTorre della torre desiderata
	// Descrizione:				Metodo che permette di estrarre le informazioni riguardo gli spazi della torre
	//--------------------------------------------------------------------------------------------------------------//
	public static SetRisorse leggiSetRisorseSpazio (String tipoSpazio){
		
		SetRisorse setRisorse = null;
		
		try{
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			Document document = builder.parse(new File("/Users/andre/LaboratorioProvaFinale/prova-finale-template/XML/SetRisorseSpazi.xml"));
			
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
	// Nome metodo: 			leggiValore
	// Parametri di ingresso: 	Tipologia di spazio di cui si vuole sapere il valore minimo di attivazione (Stringa)
	// Parametri di uscita:   	Intero
	// Descrizione:				Metodo che permette di estrarre i valori minimi per l'attivazione degli spazi
	//--------------------------------------------------------------------------------------------------------------//
	public static int leggiValore (String tipoValore){
		
		int valore=1;
		
		try{
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			Document document = builder.parse(new File("/Users/andre/LaboratorioProvaFinale/prova-finale-template/XML/DatiGenerali.xml"));
			
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
