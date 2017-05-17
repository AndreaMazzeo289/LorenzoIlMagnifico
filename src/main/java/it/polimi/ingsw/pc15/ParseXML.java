package it.polimi.ingsw.pc15;

import java.io.File;
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
	public void GetCartaXML (ColoreCarta coloreCarta){
		
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
							leggiCartaVerde(carta);
							break;
							
						case "GIALLO":
							leggiCartaGialla(carta);
							break;
							
						case "BLU":
							leggiCartaBlu(carta);
							break;
							
						case "VIOLA":
							leggiCartaViola(carta);
							break;
						default: System.out.println("ERRORE NELLA SCRITTURA DEL FILE!");
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// Nome metodo: 			GetEffettoXML
	// Parametri di ingresso: 	Nome dell'effetto che si vuole estrarre (String)
	// Parametri di uscita:   	Istanza dell'effetto estratto (Classe effetto)
	// Descrizione:				Metodo che gestisce l'estrazione degli effetti dal relativo file XML chiamando 
	//							opportuni metodi per ogni tipologia di effetto
	//--------------------------------------------------------------------------------------------------------------//	
	public Set<Effetto> getEffettoXML (String nomeEffetto){
		
		Set<Effetto> effettoLetto = new HashSet<Effetto>();
		
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
					
					System.out.println("Effetto di tipo "+ tipoEffetto + " di nome " + nome);
					
					switch(tipoEffetto){
					 	case "addRisorsa":
					 		effettoLetto.add(leggiEffettoAddRisorsa(effetto));
					 		break;
					 		
					 	case "azione":
					 		
					 		String tipoAzione = effetto.getAttribute("idAzione");
							switch(tipoAzione){
								case "raccolta": 
									effettoLetto.add(leggiEffettoAzioneRaccolto(effetto));
									break;
								case "produzione": 
									effettoLetto.add(leggiEffettoAzioneProduzione(effetto));
									break;
								case "carta": 
									effettoLetto.add(leggiEffettoAzioneCarta(effetto));
									break;
							}
							break;
							
					 	case "moltiplicazione":
					 		effettoLetto.add(leggiEffettoMoltiplicazione(effetto));
					 		break;
					 	case "scambio":
					 		effettoLetto.add(leggiEffettoScambio(effetto));
					 		break;
					 	case "bonus":
					 		
					 		String tipoBonus = effetto.getAttribute("idAzione");
							switch(tipoBonus){
								case "raccolta": 
									effettoLetto.add(leggiEffettoBonusRaccolta(effetto));
									break;
								case "produzione": 
									effettoLetto.add(leggiEffettoBonusProduzione(effetto));
									break;
								case "carta": 
									effettoLetto.add(leggiEffettoBonusDadoCarta(effetto));
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

		String fattore1 = effetto.getElementsByTagName("fattore1").item(0).getFirstChild().getNodeValue();
		String quantita1 = effetto.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue();
		String fattore2 = effetto.getElementsByTagName("fattore2").item(0).getFirstChild().getNodeValue();
		String quantita2 = effetto.getElementsByTagName("quantita2").item(0).getFirstChild().getNodeValue();
		
		TipoRisorsa tipoRisorsa;
		switch(fattore1.toUpperCase()){
			case "LEGNA": tipoRisorsa = tipoRisorsa.LEGNA;
				break;
			case "PIETRA": tipoRisorsa = tipoRisorsa.PIETRA;
				break;
			case "ORO": tipoRisorsa = tipoRisorsa.ORO;
				break;
			case "SERVITORI": tipoRisorsa = tipoRisorsa.SERVITORI;
				break;
			case "PUNTIMILITARI": tipoRisorsa = tipoRisorsa.PUNTIMILITARI;
				break;
			case "PUNTIFEDE": tipoRisorsa = tipoRisorsa.PUNTIFEDE;
				break;
			case "PUNTIVITTORIA": tipoRisorsa = tipoRisorsa.PUNTIVITTORIA;
				break;
			case "PRIVILEGI": tipoRisorsa = tipoRisorsa.PRIVILEGI;
				break;
		}
		
		Moltiplicazione moltiplicazione = new Moltiplicazione (quantita1,tipoRisorsa);
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
			
			int numLegno = Integer.parseInt(SingoloCosto.getElementsByTagName("legno").item(0).getFirstChild().getNodeValue());
			int numPietra = Integer.parseInt(SingoloCosto.getElementsByTagName("pietra").item(0).getFirstChild().getNodeValue());
			int numOro = Integer.parseInt(SingoloCosto.getElementsByTagName("oro").item(0).getFirstChild().getNodeValue());
			int numServitori = Integer.parseInt(SingoloCosto.getElementsByTagName("servitori").item(0).getFirstChild().getNodeValue());
			int numPuntiFede = Integer.parseInt(SingoloCosto.getElementsByTagName("puntiFede").item(0).getFirstChild().getNodeValue());
			int numPuntiMilitari = Integer.parseInt(SingoloCosto.getElementsByTagName("puntiMilitari").item(0).getFirstChild().getNodeValue());
			int numPuntiVittoria = Integer.parseInt(SingoloCosto.getElementsByTagName("puntiVittoria").item(0).getFirstChild().getNodeValue());
			int numPrivilegi = Integer.parseInt(SingoloCosto.getElementsByTagName("privilegi").item(0).getFirstChild().getNodeValue());
			
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
		
		Scambio scambio = new Scambio (pagamento, guadagno);
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
	// NOTA: IO NELLE CARTE VERDI HO INSERITO UN COSTO PER MIGLIORARE L'ESTENDIBILITA, NEL COSTRUTTORE DI TERRITORIO
	// 		 NON é PREVISTO
	//--------------------------------------------------------------------------------------------------------------//
	public Territorio leggiCartaVerde (Element carta){
		
		//------------------------------------------------------//
		//	FASE 1: DICHIARAZIONE VARIABILI E ACQUISIZIONE DATI
		//------------------------------------------------------//
		int id = Integer.parseInt(carta.getAttribute("id"));
		int periodo = Integer.parseInt(carta.getElementsByTagName("periodo").item(0).getFirstChild().getNodeValue());
		int dadoRaccolta = Integer.parseInt(carta.getElementsByTagName("dadoRaccolto").item(0).getFirstChild().getNodeValue());
		int numLegna = Integer.parseInt(carta.getElementsByTagName("legno").item(0).getFirstChild().getNodeValue());
		int numPietra = Integer.parseInt(carta.getElementsByTagName("pietra").item(0).getFirstChild().getNodeValue());
		int numOro = Integer.parseInt(carta.getElementsByTagName("oro").item(0).getFirstChild().getNodeValue());
		int numServitori = Integer.parseInt(carta.getElementsByTagName("servitori").item(0).getFirstChild().getNodeValue());
		int numPuntiMilitari = Integer.parseInt(carta.getElementsByTagName("puntiMilitari").item(0).getFirstChild().getNodeValue());
		int numPuntiVittoria = Integer.parseInt(carta.getElementsByTagName("puntiVittoria").item(0).getFirstChild().getNodeValue());
		int numPuntiFede = Integer.parseInt(carta.getElementsByTagName("puntiFede").item(0).getFirstChild().getNodeValue());
		int numPrivilegi = Integer.parseInt(carta.getElementsByTagName("privilegi").item(0).getFirstChild().getNodeValue());
		
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
		//	FASE 4 [FINALE]: ISTANZA DELLA CARTA VERDE
		//------------------------------------------------------//
        Territorio territorio = new Territorio (nome, id, periodo, effettiImmediati, dadoRaccolta, effettoRac);
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
		int numLegna = Integer.parseInt(carta.getElementsByTagName("legno").item(0).getFirstChild().getNodeValue());
		int numPietra = Integer.parseInt(carta.getElementsByTagName("pietra").item(0).getFirstChild().getNodeValue());
		int numOro = Integer.parseInt(carta.getElementsByTagName("oro").item(0).getFirstChild().getNodeValue());
		int numServitori = Integer.parseInt(carta.getElementsByTagName("servitori").item(0).getFirstChild().getNodeValue());
		int numPuntiMilitari = Integer.parseInt(carta.getElementsByTagName("puntiMilitari").item(0).getFirstChild().getNodeValue());
		int numPuntiVittoria = Integer.parseInt(carta.getElementsByTagName("puntiVittoria").item(0).getFirstChild().getNodeValue());
		int numPuntiFede = Integer.parseInt(carta.getElementsByTagName("puntiFede").item(0).getFirstChild().getNodeValue());
		int numPrivilegi = Integer.parseInt(carta.getElementsByTagName("privilegi").item(0).getFirstChild().getNodeValue());
		
		String nome = carta.getElementsByTagName("nome").item(0).getFirstChild().getNodeValue();
		String colore = carta.getElementsByTagName("colore").item(0).getFirstChild().getNodeValue();
		String effettoProduzione = carta.getElementsByTagName("effetto").item(0).getFirstChild().getNodeValue();
		
		Set<Set<Effetto>> effettiImmediati = new HashSet<Set<Effetto>>();
		
		//------------------------------------------------------//
		//	FASE 2: CICLIO DI ACQUISIZIONE DEGLI EFFETTI IMMEDIATI
		//------------------------------------------------------//
		NodeList listaEffettiImm = carta.getElementsByTagName("effettoImm");
        for (int j = 0; j < listaEffettiImm.getLength(); ++j) {
            Element effetto = (Element) listaEffettiImm.item(j);
            String effettoTipo = effetto.getFirstChild().getNodeValue();
            Set<Effetto> effettoImm = getEffettoXML(effettoTipo);
            effettiImmediati.add(effettoImm);
        }

		//------------------------------------------------------//
		//	FASE 3: ESTRAZIONE DEI DATI RELATIVI ALL'EFFETTO
		//------------------------------------------------------//
        Set<Effetto> effettoProd = getEffettoXML(effettoProduzione);
        
        //------------------------------------------------------//
		//	FASE 4: ISTANZIAZIONE DEL SET RISORSE (COSTO)
		//------------------------------------------------------//
		Legna legna = new Legna (numLegna);
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
		int numLegna = Integer.parseInt(carta.getElementsByTagName("legno").item(0).getFirstChild().getNodeValue());
		int numPietra = Integer.parseInt(carta.getElementsByTagName("pietra").item(0).getFirstChild().getNodeValue());
		int numOro = Integer.parseInt(carta.getElementsByTagName("oro").item(0).getFirstChild().getNodeValue());
		int numServitori = Integer.parseInt(carta.getElementsByTagName("servitori").item(0).getFirstChild().getNodeValue());
		int numPuntiMilitari = Integer.parseInt(carta.getElementsByTagName("puntiMilitari").item(0).getFirstChild().getNodeValue());
		int numPuntiVittoria = Integer.parseInt(carta.getElementsByTagName("puntiVittoria").item(0).getFirstChild().getNodeValue());
		int numPuntiFede = Integer.parseInt(carta.getElementsByTagName("puntiFede").item(0).getFirstChild().getNodeValue());
		int numPrivilegi = Integer.parseInt(carta.getElementsByTagName("privilegi").item(0).getFirstChild().getNodeValue());
		
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
		Legna legna = new Legna (numLegna);
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
	// PROBLEMA: IMPLEMENTAZIONE NEL COSTRUTTORE DEL REQUISITO MILITARE DELLE CARTE VIOLA
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
            System.out.println("*   Effetto immediato " + j + "      |   " + effettoTipo);
            Effetto effettoImm = getEffettoXML(effettoTipo);
            effettiImmediati.add(effettoImm);
        }
        
        //------------------------------------------------------//
  		//	FASE 2: ESTRAZIONE DEL COSTO [può non esistere]
  		//------------------------------------------------------//
        SetRisorse costo;
        try{
        	int numLegna = Integer.parseInt(carta.getElementsByTagName("legno").item(0).getFirstChild().getNodeValue());
    		int numPietra = Integer.parseInt(carta.getElementsByTagName("pietra").item(0).getFirstChild().getNodeValue());
    		int numOro = Integer.parseInt(carta.getElementsByTagName("oro").item(0).getFirstChild().getNodeValue());
    		int numServitori = Integer.parseInt(carta.getElementsByTagName("servitori").item(0).getFirstChild().getNodeValue());
    		int numPuntiMilitari = Integer.parseInt(carta.getElementsByTagName("puntiMilitari").item(0).getFirstChild().getNodeValue());
    		int numPuntiVittoria = Integer.parseInt(carta.getElementsByTagName("puntiVittoria").item(0).getFirstChild().getNodeValue());
    		int numPuntiFede = Integer.parseInt(carta.getElementsByTagName("puntiFede").item(0).getFirstChild().getNodeValue());
    		int numPrivilegi = Integer.parseInt(carta.getElementsByTagName("privilegi").item(0).getFirstChild().getNodeValue());

    		//------------------------------------------------------//
      		//	FASE 2.1: ISTANZIAZIONE DEL SET RISORSE (COSTO)
      		//------------------------------------------------------//
    		Legna legna = new Legna (numLegna);
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
        try{
			String costoPt = carta.getElementsByTagName("costoPt").item(0).getFirstChild().getNodeValue();
			String requisito = carta.getElementsByTagName("requisito").item(0).getFirstChild().getNodeValue();
			System.out.println("*  Costo di punti militari -> " + costoPt);
			System.out.println("*  Ma devi avere almeno " + requisito + " punti militari");
		}catch(NullPointerException e){
		}
		
  		//------------------------------------------------------//
		//	FASE 4: ESTRAZIONE DEI DATI RELATIVI ALL'EFFETTO
  		//------------------------------------------------------//
		Effetto effettoImpr = getEffettoXML(effettoImpresa);
		
		//------------------------------------------------------//
  		//	FASE 5 [FINALE]: ISTANZA DELLA CARTA VIOLA
  		//------------------------------------------------------//
		Impresa impresa = new Impresa (nome, id, periodo, costo, effettiImmediati, effettoImpr);
		return impresa;
	}
}
