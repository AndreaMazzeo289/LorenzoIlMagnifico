package it.polimi.ingsw.pc15;

import java.io.File;
import java.util.HashSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParseXML {

	public static void main(String[] args){
		ColoreCarta coloreCarta = ColoreCarta.GIALLO;
		GetCartaXML(coloreCarta);
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// Nome metodo: 			GetCartaXML
	// Parametri di ingresso: 	Colore della carta che si vuole estrarre (enum ColoreCarta)
	// Parametri di uscita:   	Istanza della classe Carta che contiene tutte le informazioni relative alla carta
	// Descrizione:				Metodo che gestisce l'estrazione delle carte dal relativo file XML chiamando 
	//							opportuni metodi per ogni tipologia di carta
	//--------------------------------------------------------------------------------------------------------------//	
	public static void GetCartaXML (ColoreCarta coloreCarta){
		
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
	public static void getEffettoXML (String nomeEffetto){
		
		try{
			
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			Document document = builder.parse(new File("/Users/andre/LaboratorioProvaFinale/prova-finale-template/XML/Effects_v2.3.xml"));
			
			NodeList effetti = document.getElementsByTagName("effetto");
			
			for(int i=0; i<effetti.getLength(); i++){
				
				Element effetto = (Element) effetti.item(i);
				
				String nome = effetto.getAttribute("nome");
				if(nome.equals(nomeEffetto)){
					
					String tipoEffetto = effetto.getAttribute("idEffetto");
					
					System.out.println("Effetto di tipo "+ tipoEffetto + " di nome " + nome);
					
					switch(tipoEffetto){
					 	case "addRisorsa":
					 		leggiEffettoAddRisorsa(effetto);
					 		break;
					 		
					 	case "azione":
					 		
					 		String tipoAzione = effetto.getAttribute("idAzione");
							switch(tipoAzione){
								case "raccolta": 
									leggiEffettoAzioneRaccolto(effetto);
									break;
								case "produzione": 
									leggiEffettoAzioneProduzione(effetto);
									break;
								case "carta": 
									leggiEffettoAzioneCarta(effetto);
									break;
							}
							break;
							
					 	case "moltiplicazione":
					 		leggiEffettoMoltiplicazione(effetto);
					 		break;
					 	case "scambio":
					 		leggiEffettoScambio(effetto);
					 		break;
					 	case "bonus":
					 		
					 		String tipoBonus = effetto.getAttribute("idAzione");
							switch(tipoBonus){
								case "raccolta": 
									leggiEffettoBonusRaccolta(effetto);
									break;
								case "produzione": 
									leggiEffettoBonusProduzione(effetto);
									break;
								case "carta": 
									leggiEffettoBonusDadoCarta(effetto);
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
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// Nome metodo: 			leggiEffettoAddRisorsa
	// Parametri di ingresso: 	Elemento dell'effetto specifico da estrarre
	// Parametri di uscita:   	Istanza dell'effetto estratto (Classe AggiuntaRisorse)
	// Descrizione:				Metodo che permette di estrarre gli effetti di tipo AddRisorsa dal file XML
	//--------------------------------------------------------------------------------------------------------------//
	public static void leggiEffettoAddRisorsa(Element effetto) {
				
		int numLegno = Integer.parseInt(effetto.getElementsByTagName("legno").item(0).getFirstChild().getNodeValue());
		int numPietra = Integer.parseInt(effetto.getElementsByTagName("pietra").item(0).getFirstChild().getNodeValue());
		int numOro = Integer.parseInt(effetto.getElementsByTagName("oro").item(0).getFirstChild().getNodeValue());
		int numServitori = Integer.parseInt(effetto.getElementsByTagName("servitori").item(0).getFirstChild().getNodeValue());
		int numPuntiFede = Integer.parseInt(effetto.getElementsByTagName("puntiFede").item(0).getFirstChild().getNodeValue());
		int numPuntiMilitari = Integer.parseInt(effetto.getElementsByTagName("puntiMilitari").item(0).getFirstChild().getNodeValue());
		int numPuntiVittoria = Integer.parseInt(effetto.getElementsByTagName("puntiVittoria").item(0).getFirstChild().getNodeValue());
		int numPrivilegi = Integer.parseInt(effetto.getElementsByTagName("privilegi").item(0).getFirstChild().getNodeValue());
		
		
		System.out.println("Legno: " + numLegno);
		System.out.println("Pietra: " + numPietra);
		System.out.println("Oro: " + numOro);
		System.out.println("Servitori: " + numServitori);
		System.out.println("Punti fede: " + numPuntiFede);
		System.out.println("Punti militari: " + numPuntiMilitari);
		System.out.println("Punti vittoria: " + numPuntiVittoria);
		System.out.println("Privilegi: " + numPrivilegi);
		
		/*SetRisorse setRisorse = new SetRisorse(risorsa,quantita);*/
		
		/*AggiuntaRisorse aggiuntaRisorse = new AggiuntaRisorse(setRisorse);
		
		return aggiuntaRisorse;*/
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// Nome metodo: 			leggiEffettoAzione
	// Parametri di ingresso: 	Elemento dell'effetto specifico da estrarre
	// Parametri di uscita:   	Istanza dell'effetto estratto (Classe azioneRaccolto)
	// Descrizione:				Metodo che permette di estrarre gli effetti di tipo azione dal file XML
	//--------------------------------------------------------------------------------------------------------------//
	public static void leggiEffettoAzioneRaccolto (Element effetto) {
		
		int valoreDadoRaccolta = Integer.parseInt(effetto.getElementsByTagName("valoreDado").item(0).getFirstChild().getNodeValue());
		System.out.println("Valore dado raccolta: " + valoreDadoRaccolta);
		
		/*AzioneRaccolto azioneRaccolto = new AzioneRaccolto (valoreDadoRaccolta);
		return azioneRaccolto;*/
	}
	
	public static void leggiEffettoAzioneProduzione (Element effetto) {
			
		int valoreDadoProduzione = Integer.parseInt(effetto.getElementsByTagName("valoreDado").item(0).getFirstChild().getNodeValue());
		System.out.println("Valore dado produzione: " + valoreDadoProduzione);
			
		/*AzioneProduzione azioneProduzione = new AzioneProduzione (valoreDadoProduzione);
		return azioneProduzione;*/
	}

	public static void leggiEffettoAzioneCarta (Element effetto) {
		
		int valoreDadoCarta = Integer.parseInt(effetto.getElementsByTagName("valoreDado").item(0).getFirstChild().getNodeValue());
		String coloreCarta = effetto.getElementsByTagName("coloreCarta").item(0).getFirstChild().getNodeValue();
		System.out.println("Valore dado carta: " + valoreDadoCarta);
		System.out.println("Colore carta: " + coloreCarta);
		
		/*ColoreCarta coloreCartaEnum;
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
				break;
			default: coloreCartaEnum = ColoreCarta.ALL;
		}
		
		AzioneCarta azioneCarta = new AzioneCarta (valoreDadoCarta, coloreCartaEnum);
		return azioneCarta;*/
	}

	//--------------------------------------------------------------------------------------------------------------//
	// Nome metodo: 			leggiEffettoMoltiplicazione
	// Parametri di ingresso: 	Elemento dell'effetto specifico da estrarre
	// Parametri di uscita:   	Istanza dell'effetto estratto (Classe effetto)
	// Descrizione:				Metodo che permette di estrarre gli effetti di tipo moltiplicazione dal file XML
	//--------------------------------------------------------------------------------------------------------------//
	public static void leggiEffettoMoltiplicazione(Element effetto) {

		String fattore1 = effetto.getElementsByTagName("fattore1").item(0).getFirstChild().getNodeValue();
		String quantita1 = effetto.getElementsByTagName("quantita1").item(0).getFirstChild().getNodeValue();
		String fattore2 = effetto.getElementsByTagName("fattore2").item(0).getFirstChild().getNodeValue();
		String quantita2 = effetto.getElementsByTagName("quantita2").item(0).getFirstChild().getNodeValue();
		
		System.out.println("Primo elemento della moltiplicazione: " + fattore1);
		System.out.println("Quantita: " + quantita1);
		System.out.println("Secondo elemento della moltiplicazione: " + fattore2);
		System.out.println("Quantita: " + quantita2);
		
		
	}

	//--------------------------------------------------------------------------------------------------------------//
	// Nome metodo: 			leggiEffettoScambio
	// Parametri di ingresso: 	Elemento dell'effetto specifico da estrarre
	// Parametri di uscita:   	Istanza dell'effetto estratto (Classe effetto)
	// Descrizione:				Metodo che permette di estrarre gli effetti di tipo scambio dal file XML
	//--------------------------------------------------------------------------------------------------------------//
	public static void leggiEffettoScambio(Element effetto) {
		
		if (Integer.parseInt(effetto.getAttribute("num")) == 1) {
			
			NodeList setRisorse = effetto.getElementsByTagName("setRisorse");
			for(int i=0; i<setRisorse.getLength(); ++i) {
				Element SingoloCosto = (Element) setRisorse.item(i);
				
				switch(SingoloCosto.getAttribute("id")){
					case "pagamento":
						
						int numLegnoPag = Integer.parseInt(SingoloCosto.getElementsByTagName("legno").item(0).getFirstChild().getNodeValue());
						int numPietraPag = Integer.parseInt(SingoloCosto.getElementsByTagName("pietra").item(0).getFirstChild().getNodeValue());
						int numOroPag = Integer.parseInt(SingoloCosto.getElementsByTagName("oro").item(0).getFirstChild().getNodeValue());
						int numServitoriPag = Integer.parseInt(SingoloCosto.getElementsByTagName("servitori").item(0).getFirstChild().getNodeValue());
						int numPuntiFedePag = Integer.parseInt(SingoloCosto.getElementsByTagName("puntiFede").item(0).getFirstChild().getNodeValue());
						int numPuntiMilitariPag = Integer.parseInt(SingoloCosto.getElementsByTagName("puntiMilitari").item(0).getFirstChild().getNodeValue());
						int numPuntiVittoriaPag = Integer.parseInt(SingoloCosto.getElementsByTagName("puntiVittoria").item(0).getFirstChild().getNodeValue());
						int numPrivilegiPag = Integer.parseInt(SingoloCosto.getElementsByTagName("privilegi").item(0).getFirstChild().getNodeValue());
						
						System.out.println("COSA DEVI PAGARE :");
						System.out.println("Legno: " + numLegnoPag);
						System.out.println("Pietra: " + numPietraPag);
						System.out.println("Oro: " + numOroPag);
						System.out.println("Servitori: " + numServitoriPag);
						System.out.println("Punti fede: " + numPuntiFedePag);
						System.out.println("Punti militari: " + numPuntiMilitariPag);
						System.out.println("Punti vittoria: " + numPuntiVittoriaPag);
						System.out.println("Privilegi: " + numPrivilegiPag);	
						break;
						
					case "guadagno":
						
						int numLegnoGuad = Integer.parseInt(SingoloCosto.getElementsByTagName("legno").item(0).getFirstChild().getNodeValue());
						int numPietraGuad = Integer.parseInt(SingoloCosto.getElementsByTagName("pietra").item(0).getFirstChild().getNodeValue());
						int numOroGuad = Integer.parseInt(SingoloCosto.getElementsByTagName("oro").item(0).getFirstChild().getNodeValue());
						int numServitoriGuad = Integer.parseInt(SingoloCosto.getElementsByTagName("servitori").item(0).getFirstChild().getNodeValue());
						int numPuntiFedeGuad = Integer.parseInt(SingoloCosto.getElementsByTagName("puntiFede").item(0).getFirstChild().getNodeValue());
						int numPuntiMilitariGuad = Integer.parseInt(SingoloCosto.getElementsByTagName("puntiMilitari").item(0).getFirstChild().getNodeValue());
						int numPuntiVittoriaGuad = Integer.parseInt(SingoloCosto.getElementsByTagName("puntiVittoria").item(0).getFirstChild().getNodeValue());
						int numPrivilegiGuad = Integer.parseInt(SingoloCosto.getElementsByTagName("privilegi").item(0).getFirstChild().getNodeValue());
						
						System.out.println("COSA DEVI PAGARE :");
						System.out.println("Legno: " + numLegnoGuad);
						System.out.println("Pietra: " + numPietraGuad);
						System.out.println("Oro: " + numOroGuad);
						System.out.println("Servitori: " + numServitoriGuad);
						System.out.println("Punti fede: " + numPuntiFedeGuad);
						System.out.println("Punti militari: " + numPuntiMilitariGuad);
						System.out.println("Punti vittoria: " + numPuntiVittoriaGuad);
						System.out.println("Privilegi: " + numPrivilegiGuad);	
						break;
					default:
				}
			}	
		}
	}

	//--------------------------------------------------------------------------------------------------------------//
	// Nome metodo: 			leggiEffettoBonus
	// Parametri di ingresso: 	Elemento dell'effetto specifico da estrarre
	// Parametri di uscita:   	Istanza dell'effetto estratto (Classe effetto)
	// Descrizione:				Metodo che permette di estrarre gli effetti di tipo bonus dal file XML
	//--------------------------------------------------------------------------------------------------------------//	
	public static void leggiEffettoBonusRaccolta (Element effetto)
	{
		int valoreDadoRaccolta = Integer.parseInt(effetto.getElementsByTagName("bonusDado").item(0).getFirstChild().getNodeValue());
		System.out.println("Valore bonus raccolta: " + valoreDadoRaccolta);
		
		/*BonusRaccolta bonusRaccolta = new BonusRaccolta (valoreDadoRaccolta);
		return bonusRaccolta;*/
	}
	
	public static void leggiEffettoBonusProduzione (Element effetto)
	{
		int valoreDadoProduzione = Integer.parseInt(effetto.getElementsByTagName("bonusDado").item(0).getFirstChild().getNodeValue());
		System.out.println("Valore bonus raccolta: " + valoreDadoProduzione);
		
		/*BonusProduzione bonusProduzione = new BonusProduzione (valoreDadoProduzione);
		return bonusProduzione;*/
	}
	
	public static void leggiEffettoBonusDadoCarta (Element effetto)
	{
		int valoreDadoCarta = Integer.parseInt(effetto.getElementsByTagName("bonusDado").item(0).getFirstChild().getNodeValue());
		String coloreCarta = effetto.getElementsByTagName("coloreCarta").item(0).getFirstChild().getNodeValue();
		System.out.println("Valore bonus carta: " + valoreDadoCarta);
		System.out.println("Colore carta: " + coloreCarta);
		
		/*ColoreCarta coloreCartaEnum;
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
				break;
			default: coloreCartaEnum = ColoreCarta.ALL;
		}
		
		BonusDadoCarte bonusDadoCarte = new BonusDadoCarte(coloreCartaEnum, valoreDadoCarta);
		return bonusDadoCarte;*/
	}

	//--------------------------------------------------------------------------------------------------------------//
	// Nome metodo: 			leggiCartaVerde
	// Parametri di ingresso: 	Element della carta specifica che stiamo analizzando (Classe element)
	// Parametri di uscita:   	Istanza della carta che si vuole estrarre (Classe carta)
	// Descrizione:				Metodo che permette di estrarre le carte verdi dal file XML
	//--------------------------------------------------------------------------------------------------------------//
	public static void leggiCartaVerde (Element carta){
		
		//---------------------------------------------------//
		//	FASE 1: ACQUISIZIONE DEI DATI
		//---------------------------------------------------//
		String ID = carta.getAttribute("id");
		String nome = carta.getElementsByTagName("nome").item(0).getFirstChild().getNodeValue();
		String colore = carta.getElementsByTagName("colore").item(0).getFirstChild().getNodeValue();
		int periodo = Integer.parseInt(carta.getElementsByTagName("periodo").item(0).getFirstChild().getNodeValue());
		String dadoRaccolta = carta.getElementsByTagName("dadoRaccolto").item(0).getFirstChild().getNodeValue();
		String effettoRaccolta = carta.getElementsByTagName("effetto").item(0).getFirstChild().getNodeValue();
		int numLegna = Integer.parseInt(carta.getElementsByTagName("legno").item(0).getFirstChild().getNodeValue());
		int numPietra = Integer.parseInt(carta.getElementsByTagName("pietra").item(0).getFirstChild().getNodeValue());
		int numOro = Integer.parseInt(carta.getElementsByTagName("oro").item(0).getFirstChild().getNodeValue());
		int numServitori = Integer.parseInt(carta.getElementsByTagName("servitori").item(0).getFirstChild().getNodeValue());
		int numPuntiMilitari = Integer.parseInt(carta.getElementsByTagName("puntiMilitari").item(0).getFirstChild().getNodeValue());
		int numPuntiVittoria = Integer.parseInt(carta.getElementsByTagName("puntiVittoria").item(0).getFirstChild().getNodeValue());
		int numPuntiFede = Integer.parseInt(carta.getElementsByTagName("puntiFede").item(0).getFirstChild().getNodeValue());
		int numPrivilegi = Integer.parseInt(carta.getElementsByTagName("privilegi").item(0).getFirstChild().getNodeValue());
		
		
		//---------------------------------------------------//
		//	FASE 2: SCRITTURA SU CONSOLE DEI DATI
		//---------------------------------------------------//S
		System.out.println("\n********************************************************************************************");
		System.out.println("*   Nome carta               |   " + nome);
		System.out.println("*   ID carta                 |   " + ID);
		System.out.println("*   Colore carta             |   " + colore);
		System.out.println("*   Periodo                  |   " + periodo);
		System.out.println("*   Dado raccolto            |   " + dadoRaccolta);
		System.out.println("*   Effetto di raccolta      |   " + effettoRaccolta);
		
		// Estrazione e stampa della lista di effetti immediati
		//-------------------------------------------------------
		NodeList listaEffettiImm = carta.getElementsByTagName("effettoImm");
        for (int j = 0; j < listaEffettiImm.getLength(); ++j) {
            Element effetto = (Element) listaEffettiImm.item(j);
            String effettoTipo = effetto.getFirstChild().getNodeValue();
            System.out.println("*   Effetto immediato " + j + "      |   " + effettoTipo);
        }
        System.out.println("*------------------------------------------------------------------------------------------*");
		System.out.println("* Legna | Pietra | Oro | Servitori | PuntiMilitari | PuntiVittoria | PuntiFede | Privilegi *");
		System.out.println("*   " + numLegna + "   |   " + numPietra + "    |  " + numOro + "  |     " +numServitori + "     |       " + numPuntiMilitari 
							+ "       |       " + numPuntiVittoria + "       |     " + numPuntiFede + "     |     " + numPrivilegi + "     *");
		System.out.println("********************************************************************************************");

		//---------------------------------------------------//
		//	FASE 3: ESTRAZIONE DEI DATI RELATIVI ALL'EFFETTO
		//---------------------------------------------------//
        getEffettoXML(effettoRaccolta);
        
        /*Oro oro = new Oro (numOro);
        Legna legna = new Legna (numLegno);
        HashSet<Risorsa> risorse = new HashSet<>();
        risorse.add(oro);
        
        SetRisorse setRisorse = new SetRisorse (risorse); */
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// Nome metodo: 			leggiCartaGialla
	// Parametri di ingresso: 	Element della carta specifica che stiamo analizzando (Classe element)
	// Parametri di uscita:   	Istanza della carta che si vuole estrarre (Classe carta)
	// Descrizione:				Metodo che permette di estrarre le carte gialle dal file XML
	//--------------------------------------------------------------------------------------------------------------//
	public static void leggiCartaGialla (Element carta){
		
		//---------------------------------------------------//
		//	FASE 1: ACQUISIZIONE DEI DATI
		//---------------------------------------------------//
		String ID = carta.getAttribute("id");
		String nome = carta.getElementsByTagName("nome").item(0).getFirstChild().getNodeValue();
		String colore = carta.getElementsByTagName("colore").item(0).getFirstChild().getNodeValue();
		int periodo = Integer.parseInt(carta.getElementsByTagName("periodo").item(0).getFirstChild().getNodeValue());
		String dadoProduzione = carta.getElementsByTagName("dadoProduzione").item(0).getFirstChild().getNodeValue();
		String effettoProduzione = carta.getElementsByTagName("effetto").item(0).getFirstChild().getNodeValue();
		int numLegna = Integer.parseInt(carta.getElementsByTagName("legno").item(0).getFirstChild().getNodeValue());
		int numPietra = Integer.parseInt(carta.getElementsByTagName("pietra").item(0).getFirstChild().getNodeValue());
		int numOro = Integer.parseInt(carta.getElementsByTagName("oro").item(0).getFirstChild().getNodeValue());
		int numServitori = Integer.parseInt(carta.getElementsByTagName("servitori").item(0).getFirstChild().getNodeValue());
		int numPuntiMilitari = Integer.parseInt(carta.getElementsByTagName("puntiMilitari").item(0).getFirstChild().getNodeValue());
		int numPuntiVittoria = Integer.parseInt(carta.getElementsByTagName("puntiVittoria").item(0).getFirstChild().getNodeValue());
		int numPuntiFede = Integer.parseInt(carta.getElementsByTagName("puntiFede").item(0).getFirstChild().getNodeValue());
		int numPrivilegi = Integer.parseInt(carta.getElementsByTagName("privilegi").item(0).getFirstChild().getNodeValue());
		
		//---------------------------------------------------//
		//	FASE 2: SCRITTURA SU CONSOLE DEI DATI
		//---------------------------------------------------//S
		System.out.println("\n********************************************************************************************");
		System.out.println("*   Nome carta               |   " + nome);
		System.out.println("*   ID carta                 |   " + ID);
		System.out.println("*   Colore carta             |   " + colore);
		System.out.println("*   Periodo                  |   " + periodo);
		System.out.println("*   Dado raccolto            |   " + dadoProduzione);
		System.out.println("*   Effetto di produzione    |   " + effettoProduzione);
		
		// Estrazione e stampa della lista di effetti immediati
		//-------------------------------------------------------
		NodeList listaEffettiImm = carta.getElementsByTagName("effettoImm");
        for (int j = 0; j < listaEffettiImm.getLength(); ++j) {
            Element effetto = (Element) listaEffettiImm.item(j);
            String effettoTipo = effetto.getFirstChild().getNodeValue();
            System.out.println("*   Effetto immediato " + j + "      |   " + effettoTipo);
        }
        
        System.out.println("*------------------------------------------------------------------------------------------*");
		System.out.println("* Legna | Pietra | Oro | Servitori | PuntiMilitari | PuntiVittoria | PuntiFede | Privilegi *");
		System.out.println("*   " + numLegna + "   |   " + numPietra + "    |  " + numOro + "  |     " +numServitori + "     |       " + numPuntiMilitari 
							+ "       |       " + numPuntiVittoria + "       |     " + numPuntiFede + "     |     " + numPrivilegi + "     *");
		System.out.println("********************************************************************************************");

		//---------------------------------------------------//
		//	FASE 3: ESTRAZIONE DEI DATI RELATIVI ALL'EFFETTO
		//---------------------------------------------------//
        getEffettoXML(effettoProduzione);
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// Nome metodo: 			leggiCartaBlu
	// Parametri di ingresso: 	Element della carta specifica che stiamo analizzando (Classe element)
	// Parametri di uscita:   	Istanza della carta che si vuole estrarre (Classe carta)
	// Descrizione:				Metodo che permette di estrarre le carte blu dal file XML
	//--------------------------------------------------------------------------------------------------------------//
	public static void leggiCartaBlu(Element carta){
		
		//---------------------------------------------------//
		//	FASE 1: ACQUISIZIONE DEI DATI
		//---------------------------------------------------//
		String ID = carta.getAttribute("id");
		String nome = carta.getElementsByTagName("nome").item(0).getFirstChild().getNodeValue();
		String colore = carta.getElementsByTagName("colore").item(0).getFirstChild().getNodeValue();
		int periodo = Integer.parseInt(carta.getElementsByTagName("periodo").item(0).getFirstChild().getNodeValue());
		String effettoPersonaggio = "NULL";
		int numLegna = Integer.parseInt(carta.getElementsByTagName("legno").item(0).getFirstChild().getNodeValue());
		int numPietra = Integer.parseInt(carta.getElementsByTagName("pietra").item(0).getFirstChild().getNodeValue());
		int numOro = Integer.parseInt(carta.getElementsByTagName("oro").item(0).getFirstChild().getNodeValue());
		int numServitori = Integer.parseInt(carta.getElementsByTagName("servitori").item(0).getFirstChild().getNodeValue());
		int numPuntiMilitari = Integer.parseInt(carta.getElementsByTagName("puntiMilitari").item(0).getFirstChild().getNodeValue());
		int numPuntiVittoria = Integer.parseInt(carta.getElementsByTagName("puntiVittoria").item(0).getFirstChild().getNodeValue());
		int numPuntiFede = Integer.parseInt(carta.getElementsByTagName("puntiFede").item(0).getFirstChild().getNodeValue());
		int numPrivilegi = Integer.parseInt(carta.getElementsByTagName("privilegi").item(0).getFirstChild().getNodeValue());
		
		//---------------------------------------------------//
		//	FASE 2: SCRITTURA SU CONSOLE DEI DATI
		//---------------------------------------------------//S
		System.out.println("\n********************************************************************************************");
		System.out.println("*   Nome carta               |   " + nome);
		System.out.println("*   ID carta                 |   " + ID);
		System.out.println("*   Colore carta             |   " + colore);
		System.out.println("*   Periodo                  |   " + periodo);
		
		// Estrazione e stampa dell'effetto del personaggio (può non esistere)
		//---------------------------------------------------------------------
		try{
			effettoPersonaggio = carta.getElementsByTagName("effetto").item(0).getFirstChild().getNodeValue();
			System.out.println("*   Effetto del personaggio  |   " + effettoPersonaggio);
		}catch (NullPointerException e){
			System.out.println("*   Effetto del personaggio  |   Nessun effetto per questo personaggio");
		}
		
		// Estrazione e stampa della lista di effetti immediati
		//------------------------------------------------------
		NodeList listaEffettiImm = carta.getElementsByTagName("effettoImm");
        for (int j = 0; j < listaEffettiImm.getLength(); ++j) {
            Element effetto = (Element) listaEffettiImm.item(j);
            String effettoTipo = effetto.getFirstChild().getNodeValue();
            System.out.println("*   Effetto immediato " + j + "      |   " + effettoTipo);
        }
        
        System.out.println("*------------------------------------------------------------------------------------------*");
		System.out.println("* Legna | Pietra | Oro | Servitori | PuntiMilitari | PuntiVittoria | PuntiFede | Privilegi *");
		System.out.println("*   " + numLegna + "   |   " + numPietra + "    |  " + numOro + "  |     " +numServitori + "     |       " + numPuntiMilitari 
							+ "       |       " + numPuntiVittoria + "       |     " + numPuntiFede + "     |     " + numPrivilegi + "     *");
		System.out.println("********************************************************************************************");
		
		//---------------------------------------------------//
		//	FASE 3: ESTRAZIONE DEI DATI RELATIVI ALL'EFFETTO
		//---------------------------------------------------//
		if (!effettoPersonaggio.equals("NULL"))
			getEffettoXML(effettoPersonaggio);
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// Nome metodo: 			leggiCartaViola
	// Parametri di ingresso: 	Element della carta specifica che stiamo analizzando (Classe element)
	// Parametri di uscita:   	Istanza della carta che si vuole estrarre (Classe carta)
	// Descrizione:				Metodo che permette di estrarre le carte viola dal file XML
	//--------------------------------------------------------------------------------------------------------------//
	public static void leggiCartaViola (Element carta){
		
		//---------------------------------------------------//
		//	FASE 1: ACQUISIZIONE DEI DATI
		//---------------------------------------------------//
		String ID = carta.getAttribute("id");
		String nome = carta.getElementsByTagName("nome").item(0).getFirstChild().getNodeValue();
		String colore = carta.getElementsByTagName("colore").item(0).getFirstChild().getNodeValue();
		int periodo = Integer.parseInt(carta.getElementsByTagName("periodo").item(0).getFirstChild().getNodeValue());
		String effettoImpresa = carta.getElementsByTagName("effetto").item(0).getFirstChild().getNodeValue();
		
		
		//---------------------------------------------------//
		//	FASE 2: SCRITTURA SU CONSOLE DEI DATI
		//---------------------------------------------------//S
		System.out.println("\n********************************************************************************************");
		System.out.println("*   Nome carta               |   " + nome);
		System.out.println("*   ID carta                 |   " + ID);
		System.out.println("*   Colore carta             |   " + colore);
		System.out.println("*   Periodo                  |   " + periodo);
		System.out.println("*   Effetto impresa          |   " + effettoImpresa);
		
		// Estrazione e stampa della lista di effetti immediati
		//------------------------------------------------------
		NodeList listaEffettiImm = carta.getElementsByTagName("effettoImm");
        for (int j = 0; j < listaEffettiImm.getLength(); ++j) {
            Element effetto = (Element) listaEffettiImm.item(j);
            String effettoTipo = effetto.getFirstChild().getNodeValue();
            System.out.println("*   Effetto immediato " + j + "      |   " + effettoTipo);
        }
        
        
        // Estrazione e stampa della lista delle risorse da pagare (può non esistere)
     	//----------------------------------------------------------------------------
        
        System.out.println("*------------------------------------------------------------------------------------------*");
        try{
        	int numLegna = Integer.parseInt(carta.getElementsByTagName("legno").item(0).getFirstChild().getNodeValue());
    		int numPietra = Integer.parseInt(carta.getElementsByTagName("pietra").item(0).getFirstChild().getNodeValue());
    		int numOro = Integer.parseInt(carta.getElementsByTagName("oro").item(0).getFirstChild().getNodeValue());
    		int numServitori = Integer.parseInt(carta.getElementsByTagName("servitori").item(0).getFirstChild().getNodeValue());
    		int numPuntiMilitari = Integer.parseInt(carta.getElementsByTagName("puntiMilitari").item(0).getFirstChild().getNodeValue());
    		int numPuntiVittoria = Integer.parseInt(carta.getElementsByTagName("puntiVittoria").item(0).getFirstChild().getNodeValue());
    		int numPuntiFede = Integer.parseInt(carta.getElementsByTagName("puntiFede").item(0).getFirstChild().getNodeValue());
    		int numPrivilegi = Integer.parseInt(carta.getElementsByTagName("privilegi").item(0).getFirstChild().getNodeValue());

    		System.out.println("* Legna | Pietra | Oro | Servitori | PuntiMilitari | PuntiVittoria | PuntiFede | Privilegi *");
    		System.out.println("*   " + numLegna + "   |   " + numPietra + "    |  " + numOro + "  |     " +numServitori + "     |       " + numPuntiMilitari 
    							+ "       |       " + numPuntiVittoria + "       |     " + numPuntiFede + "     |     " + numPrivilegi + "     *");
		}catch(NullPointerException e){
			System.out.println("*   Per questa carta non è ammesso un pagamento in risorse                                 *");
		}
        System.out.println("*------------------------------------------------------------------------------------------*");
        
        // Estrazione e stampa dell'alternativa di acquisto con i punti militari (se esiste)
     	//-----------------------------------------------------------------------------------
        try{
			String costoPt = carta.getElementsByTagName("costoPt").item(0).getFirstChild().getNodeValue();
			String requisito = carta.getElementsByTagName("requisito").item(0).getFirstChild().getNodeValue();
			System.out.println("*  Costo di punti militari -> " + costoPt);
			System.out.println("*  Ma devi avere almeno " + requisito + " punti militari");
			
		}catch(NullPointerException e){
			System.out.println("*   Per questa carta non è ammesso un pagamento con i punti militari                       *");
		}
		System.out.println("********************************************************************************************");
		
		//---------------------------------------------------//
		//	FASE 3: ESTRAZIONE DEI DATI RELATIVI ALL'EFFETTO
		//---------------------------------------------------//
		getEffettoXML(effettoImpresa);
	}
}
