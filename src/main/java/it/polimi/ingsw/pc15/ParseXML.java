package it.polimi.ingsw.pc15;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParseXML {

	public static void main(String[] args){
		ColoreCarta coloreCarta = ColoreCarta.VERDE;
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
			Document document = builder.parse(new File("/Users/andre/LaboratorioProvaFinale/prova-finale-template/XML/Cards_v1.3.xml"));
			
			NodeList carte = document.getElementsByTagName("carta");
			
			for(int i=0; i<carte.getLength(); i++){
				
				Element carta = (Element) carte.item(i);
					
				String colore = carta.getElementsByTagName("colore").item(0).getFirstChild().getNodeValue();
				
				if(colore.toUpperCase().equals(coloreCarta.toString())) {
					switch(coloreCarta.toString()){
						case "VERDE":
							leggiCartaVecio(carta);
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
	public static void GetEffettoXML (String nomeEffetto){
		
		try{
			
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			Document document = builder.parse(new File("/Users/andre/LaboratorioProvaFinale/prova-finale-template/XML/Effects_v2.2.xml"));
			
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
		
		String risorsa = effetto.getElementsByTagName("tipoRisorsa").item(0).getFirstChild().getNodeValue();
		int quantita = Integer.parseInt(effetto.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue());
		
		System.out.println("Risorsa: " + risorsa);
		System.out.println("Quantita:" + quantita);
		
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
	public static AzioneRaccolto leggiEffettoAzioneRaccolto (Element effetto) {
		
		int valoreDadoRaccolta = Integer.parseInt(effetto.getElementsByTagName("valoreDado").item(0).getFirstChild().getNodeValue());
		//System.out.println("Valore dado raccolta: " + valoreDadoRaccolta);
		
		AzioneRaccolto azioneRaccolto = new AzioneRaccolto (valoreDadoRaccolta);
		return azioneRaccolto;
	}
	
	public static AzioneProduzione leggiEffettoAzioneProduzione (Element effetto) {
			
		int valoreDadoProduzione = Integer.parseInt(effetto.getElementsByTagName("valoreDado").item(0).getFirstChild().getNodeValue());
		//System.out.println("Valore dado produzione: " + valoreDadoProduzione);
			
		AzioneProduzione azioneProduzione = new AzioneProduzione (valoreDadoProduzione);
		return azioneProduzione;
	}

	public static AzioneCarta leggiEffettoAzioneCarta (Element effetto) {
		
		int valoreDadoCarta = Integer.parseInt(effetto.getElementsByTagName("valoreDado").item(0).getFirstChild().getNodeValue());
		String coloreCarta = effetto.getElementsByTagName("coloreCarta").item(0).getFirstChild().getNodeValue();
		//System.out.println("Valore dado carta: " + valoreDadoCarta);
		//System.out.println("Colore carta: " + coloreCarta);
		
		ColoreCarta coloreCartaEnum;
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
		return azioneCarta;
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
		System.out.println("Secondo elemento della moltiplicazione: " + fattore2);    //<------------------------------------PROBLEMA DA RISOLVERE (funz Molt)
		System.out.println("Quantita: " + quantita2);
		
		
	}

	//--------------------------------------------------------------------------------------------------------------//
	// Nome metodo: 			leggiEffettoScambio
	// Parametri di ingresso: 	Elemento dell'effetto specifico da estrarre
	// Parametri di uscita:   	Istanza dell'effetto estratto (Classe effetto)
	// Descrizione:				Metodo che permette di estrarre gli effetti di tipo scambio dal file XML
	//--------------------------------------------------------------------------------------------------------------//
	public static void leggiEffettoScambio(Element effetto) {
		
		NodeList listaPagamenti = effetto.getElementsByTagName("insiemePagamenti");
		System.out.println("Lista pagamenti:");
		
		//SetRisorse setRisorsePagamento = new SetRisorse ();  //<------------------------------------ PROBLEMA DA RISOLVERE (COSTRUTTORE)
		
        for (int j = 0; j < listaPagamenti.getLength(); j++) {
            Element pagamento = (Element) listaPagamenti.item(j);
            String risorsa = pagamento.getElementsByTagName("risorsa").item(0).getFirstChild().getNodeValue();
            String quantita = pagamento.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue();
            System.out.println("Risorsa["+j+"]:" +risorsa);
            System.out.println("Quantita["+j+"]:" +quantita);
        }
        
        try{
        	
        	NodeList listaPagamentiAlt = effetto.getElementsByTagName("insiemePagamentiAlt");
    		System.out.println("Lista pagamenti alternativi:");    //<------------------------------------PROBLEMA DA RISOLVERE (NON PREVISTE ALTERNATIVE)
    		
            for (int j = 0; j < listaPagamentiAlt.getLength(); j++) {
                Element pagamentoAlt = (Element) listaPagamentiAlt.item(j);
                String risorsa = pagamentoAlt.getElementsByTagName("risorsa").item(0).getFirstChild().getNodeValue();
                String quantita = pagamentoAlt.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue();
                System.out.println("Risorsa["+j+"]:" +risorsa);
                System.out.println("Quantita["+j+"]:" +quantita);
            }
        	
        }catch(NullPointerException e){
        	
        }
        
        NodeList listaGuadagni = effetto.getElementsByTagName("guadagno");
		System.out.println("Lista guadagni:");			//<------------------------------------PROBLEMA DA RISOLVERE (COSTRUTTORE)
		
        for (int j = 0; j < listaGuadagni.getLength(); j++) {
            Element guadagno = (Element) listaGuadagni.item(j);
            String risorsa = guadagno.getElementsByTagName("risorsa").item(0).getFirstChild().getNodeValue();
            String quantita = guadagno.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue();
            System.out.println("Risorsa["+j+"]:" +risorsa);
            System.out.println("Quantita["+j+"]:" +quantita);
        }
	}

	//--------------------------------------------------------------------------------------------------------------//
	// Nome metodo: 			leggiEffettoBonus
	// Parametri di ingresso: 	Elemento dell'effetto specifico da estrarre
	// Parametri di uscita:   	Istanza dell'effetto estratto (Classe effetto)
	// Descrizione:				Metodo che permette di estrarre gli effetti di tipo bonus dal file XML
	//--------------------------------------------------------------------------------------------------------------//	
	public static BonusRaccolta leggiEffettoBonusRaccolta (Element effetto)
	{
		int valoreDadoRaccolta = Integer.parseInt(effetto.getElementsByTagName("bonusDado").item(0).getFirstChild().getNodeValue());
		//System.out.println("Valore bonus raccolta: " + valoreDadoRaccolta);
		
		BonusRaccolta bonusRaccolta = new BonusRaccolta (valoreDadoRaccolta);
		return bonusRaccolta;
	}
	
	public static BonusProduzione leggiEffettoBonusProduzione (Element effetto)
	{
		int valoreDadoProduzione = Integer.parseInt(effetto.getElementsByTagName("bonusDado").item(0).getFirstChild().getNodeValue());
		//System.out.println("Valore bonus raccolta: " + valoreDadoProduzione);
		
		BonusProduzione bonusProduzione = new BonusProduzione (valoreDadoProduzione);
		return bonusProduzione;
	}
	
	public static BonusDadoCarte leggiEffettoBonusDadoCarta (Element effetto)
	{
		int valoreDadoCarta = Integer.parseInt(effetto.getElementsByTagName("bonusDado").item(0).getFirstChild().getNodeValue());
		String coloreCarta = effetto.getElementsByTagName("coloreCarta").item(0).getFirstChild().getNodeValue();
		System.out.println("Valore bonus carta: " + valoreDadoCarta);
		System.out.println("Colore carta: " + coloreCarta);
		
		ColoreCarta coloreCartaEnum;
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
		return bonusDadoCarte;
	}
	
	public static void leggiCartaVecio (Element carta){
		String ID = carta.getAttribute("id");
		String nome = carta.getElementsByTagName("nome").item(0).getFirstChild().getNodeValue();
		String colore = carta.getElementsByTagName("colore").item(0).getFirstChild().getNodeValue();
		int periodo = Integer.parseInt(carta.getElementsByTagName("periodo").item(0).getFirstChild().getNodeValue());
		String dado = carta.getElementsByTagName("dadoRaccolto").item(0).getFirstChild().getNodeValue();
		String effettoRaccolta = carta.getElementsByTagName("effetto").item(0).getFirstChild().getNodeValue();
		
		int numOro = Integer.parseInt(carta.getElementsByTagName("oro").item(0).getFirstChild().getNodeValue());
		int numPietra = Integer.parseInt(carta.getElementsByTagName("pietra").item(0).getFirstChild().getNodeValue());
		int numLegno = Integer.parseInt(carta.getElementsByTagName("legno").item(0).getFirstChild().getNodeValue());
		
		System.out.println("ID: " + ID);
		System.out.println("Nome:" + nome);
		System.out.println("Periodo:" + periodo);
		System.out.println("Dado raccolto:" + dado);
		System.out.println("costi--> Oro:" + numOro + "  Legno:" + numLegno + "  Pietra:" + numPietra);
		
		System.out.println("Lista effetti immediati: ");
		NodeList listaEffettiImm = carta.getElementsByTagName("effettoImm");
        for (int j = 0; j < listaEffettiImm.getLength(); ++j) {
            Element effetto = (Element) listaEffettiImm.item(j);
            String effettoTipo = effetto.getFirstChild().getNodeValue();
            System.out.println("Effetto: " +effettoTipo);
        }
	}

	//--------------------------------------------------------------------------------------------------------------//
	// Nome metodo: 			leggiCartaVerde
	// Parametri di ingresso: 	Element della carta specifica che stiamo analizzando (Classe element)
	// Parametri di uscita:   	Istanza della carta che si vuole estrarre (Classe carta)
	// Descrizione:				Metodo che permette di estrarre le carte verdi dal file XML
	//--------------------------------------------------------------------------------------------------------------//
	public static void leggiCartaVerde (Element carta){
		String ID = carta.getAttribute("id");
		String nome = carta.getElementsByTagName("nome").item(0).getFirstChild().getNodeValue();
		String periodo = carta.getElementsByTagName("periodo").item(0).getFirstChild().getNodeValue();
		String dado = carta.getElementsByTagName("dadoRaccolto").item(0).getFirstChild().getNodeValue();
		int periodoInt = Integer.parseInt(periodo);
		
		//System.out.println("ID: " + ID); //<------------------------------------PROBLEMA DA RISOLVERE (DUBBIO DISTINZIONE EFFETTI IMM E PERM SE SONO TUTTI UGUALI)
		//System.out.println("Nome:" + nome);
		//System.out.println("Periodo:" + periodoInt);
		//System.out.println("Dado raccolto:" + dado);
		
		NodeList listaEffettiImm = carta.getElementsByTagName("effettoImm");
		
        for (int j = 0; j < listaEffettiImm.getLength(); ++j) {
            Element effetto = (Element) listaEffettiImm.item(j);
            String effettoTipo = effetto.getFirstChild().getNodeValue();
            //System.out.println("Effetto immediato: " +effettoTipo);
        }
        
        NodeList listaEffettiPerm = carta.getElementsByTagName("effettoPerm");
        
        for (int j = 0; j < listaEffettiPerm.getLength(); ++j) {
            Element effetto = (Element) listaEffettiPerm.item(j);
            String effettoTipo = effetto.getFirstChild().getNodeValue();
            GetEffettoXML(effettoTipo);
        }
        
        System.out.println("--------------------------------------------------");
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// Nome metodo: 			leggiCartaGialla
	// Parametri di ingresso: 	Element della carta specifica che stiamo analizzando (Classe element)
	// Parametri di uscita:   	Istanza della carta che si vuole estrarre (Classe carta)
	// Descrizione:				Metodo che permette di estrarre le carte gialle dal file XML
	//--------------------------------------------------------------------------------------------------------------//
	public static void leggiCartaGialla (Element carta){
		
		String ID = carta.getAttribute("id");
		String nome = carta.getElementsByTagName("nome").item(0).getFirstChild().getNodeValue();
		String periodo = carta.getElementsByTagName("periodo").item(0).getFirstChild().getNodeValue();
		String dado = carta.getElementsByTagName("dadoProduzione").item(0).getFirstChild().getNodeValue();
		int periodoInt = Integer.parseInt(periodo);
		
		System.out.println("ID: " + ID);
		System.out.println("Nome:" + nome);
		System.out.println("Periodo:" + periodoInt);
		System.out.println("Dado produzione:" + dado);
		
		NodeList listaCosti = carta.getElementsByTagName("costo");
		System.out.println("Lista costi:");
		int listaCostiInt = listaCosti.getLength();
		
        for (int j = 0; j < listaCostiInt; j++) {
            Element costo = (Element) listaCosti.item(j);
            String risorsa = costo.getElementsByTagName("risorsa").item(0).getFirstChild().getNodeValue();
            String quantita = costo.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue();
            System.out.println("Risorsa["+j+"]:" +risorsa);
            System.out.println("Quantita["+j+"]:" +quantita);
        }
		
		NodeList listaEffettiImm = carta.getElementsByTagName("effettoImm");
		int listaEffettiImmInt = listaEffettiImm.getLength();
		
        for (int j = 0; j < listaEffettiImmInt; ++j) {
            Element effetto = (Element) listaEffettiImm.item(j);
            String effettoTipo = effetto.getFirstChild().getNodeValue();
            System.out.println("Effetto immediato: " +effettoTipo);
        }
        
        NodeList listaEffettiPerm = carta.getElementsByTagName("effettoPerm");
        
        
        for (int j = 0; j < listaEffettiPerm.getLength(); ++j) {
            Element effetto = (Element) listaEffettiPerm.item(j);
            String effettoTipo = effetto.getFirstChild().getNodeValue();
            System.out.println("Effetto permanente: " +effettoTipo);
        }
        
        System.out.println("--------------------------------------------------");
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// Nome metodo: 			leggiCartaBlu
	// Parametri di ingresso: 	Element della carta specifica che stiamo analizzando (Classe element)
	// Parametri di uscita:   	Istanza della carta che si vuole estrarre (Classe carta)
	// Descrizione:				Metodo che permette di estrarre le carte blu dal file XML
	//--------------------------------------------------------------------------------------------------------------//
	public static void leggiCartaBlu (Element carta){
		
		String ID = carta.getAttribute("id");
		String nome = carta.getElementsByTagName("nome").item(0).getFirstChild().getNodeValue();
		String periodo = carta.getElementsByTagName("periodo").item(0).getFirstChild().getNodeValue();
		int periodoInt = Integer.parseInt(periodo);
		
		System.out.println("ID: " + ID);
		System.out.println("Nome:" + nome);
		System.out.println("Periodo:" + periodoInt);
		
		NodeList listaCosti = carta.getElementsByTagName("costo");
		System.out.println("Lista costi:");
		int listaCostiInt = listaCosti.getLength();
		
        for (int j = 0; j < listaCostiInt; j++) {
            Element costo = (Element) listaCosti.item(j);
            String risorsa = costo.getElementsByTagName("risorsa").item(0).getFirstChild().getNodeValue();
            String quantita = costo.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue();
            System.out.println("Risorsa["+j+"]:" +risorsa);
            System.out.println("Quantita["+j+"]:" +quantita);
        }
		
		NodeList listaEffettiImm = carta.getElementsByTagName("effettoImm");
		int listaEffettiImmInt = listaEffettiImm.getLength();
		
        for (int j = 0; j < listaEffettiImmInt; ++j) {
            Element effetto = (Element) listaEffettiImm.item(j);
            String effettoTipo = effetto.getFirstChild().getNodeValue();
            System.out.println("Effetto immediato: " +effettoTipo);
        }
        
        NodeList listaEffettiPerm = carta.getElementsByTagName("effettoPerm");
        
        
        for (int j = 0; j < listaEffettiPerm.getLength(); ++j) {
            Element effetto = (Element) listaEffettiPerm.item(j);
            String effettoTipo = effetto.getFirstChild().getNodeValue();
            System.out.println("Effetto permanente: " +effettoTipo);
        }
        
        System.out.println("--------------------------------------------------");
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// Nome metodo: 			leggiCartaViola
	// Parametri di ingresso: 	Element della carta specifica che stiamo analizzando (Classe element)
	// Parametri di uscita:   	Istanza della carta che si vuole estrarre (Classe carta)
	// Descrizione:				Metodo che permette di estrarre le carte viola dal file XML
	//--------------------------------------------------------------------------------------------------------------//
	public static void leggiCartaViola(Element carta) {
		
		String ID = carta.getAttribute("id");
		String nome = carta.getElementsByTagName("nome").item(0).getFirstChild().getNodeValue();
		String periodo = carta.getElementsByTagName("periodo").item(0).getFirstChild().getNodeValue();
		int periodoInt = Integer.parseInt(periodo);
		
		System.out.println("ID: " + ID);
		System.out.println("Nome:" + nome);
		System.out.println("Periodo:" + periodoInt);
		
		NodeList listaCosti = carta.getElementsByTagName("costo");
		System.out.println("Lista costi:");
		int listaCostiInt = listaCosti.getLength();
		
        for (int j = 0; j < listaCostiInt; j++) {
            Element costo = (Element) listaCosti.item(j);
            String risorsa = costo.getElementsByTagName("risorsa").item(0).getFirstChild().getNodeValue();
            String quantita = costo.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue();
            System.out.println("Risorsa["+j+"]:" +risorsa);
            System.out.println("Quantita["+j+"]:" +quantita);
            try {
            	String requisito = costo.getElementsByTagName("requisito").item(0).getFirstChild().getNodeValue(); 
            	System.out.println("Requisito["+j+"]:" +requisito);
            }catch(NullPointerException e){
            	
            }
           
        }
        
        NodeList listaCostiAlt = carta.getElementsByTagName("costoAlt");
		System.out.println("Lista costi alternativi:");
		int listaCostiAltInt = listaCostiAlt.getLength();
		
        for (int j = 0; j < listaCostiAltInt; j++) {
            Element costoAlt = (Element) listaCostiAlt.item(j);
            String risorsa = costoAlt.getElementsByTagName("risorsa").item(0).getFirstChild().getNodeValue();
            String quantita = costoAlt.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue();
            System.out.println("RisorsaAlt["+j+"]:" +risorsa);
            System.out.println("QuantitaAlt["+j+"]:" +quantita);
        }
		
		NodeList listaEffettiImm = carta.getElementsByTagName("effettoImm");
		int listaEffettiImmInt = listaEffettiImm.getLength();
		
        for (int j = 0; j < listaEffettiImmInt; ++j) {
            Element effetto = (Element) listaEffettiImm.item(j);
            String effettoTipo = effetto.getFirstChild().getNodeValue();
            System.out.println("Effetto immediato: " +effettoTipo);
        }
        
        NodeList listaEffettiPerm = carta.getElementsByTagName("effettoPerm");
        
        
        for (int j = 0; j < listaEffettiPerm.getLength(); ++j) {
            Element effetto = (Element) listaEffettiPerm.item(j);
            String effettoTipo = effetto.getFirstChild().getNodeValue();
            System.out.println("Effetto permanente: " +effettoTipo);
        }
        
        System.out.println("--------------------------------------------------");
	}
	
}
