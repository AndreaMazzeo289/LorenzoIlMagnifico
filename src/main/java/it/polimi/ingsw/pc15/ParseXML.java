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
		
		LeggiEffetto("scambio4Oto3Pand3L");
		
		
	}
	
	public static void LeggiCarta (ColoreCarta coloreCarta){
		
		try{
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			Document document = builder.parse(new File("/Users/andre/LaboratorioProvaFinale/prova-finale-template/XML/Cards_v1.3.xml"));
			
			NodeList carte = document.getElementsByTagName("carta");
			
			//System.out.println("Totale delle carte: " + carte.getLength());
			
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
	
	public static void LeggiEffetto (String nomeEffetto){
		
		try{
			
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			Document document = builder.parse(new File("/Users/andre/LaboratorioProvaFinale/prova-finale-template/XML/Effects_v2.1.xml"));
			
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
					 		leggiEffettoAzione(effetto);
					 		break;
					 	case "moltiplicazione":
					 		leggiEffettoMoltiplicazione(effetto);
					 		break;
					 	case "scambio":
					 		leggiEffettoScambio(effetto);
					 		break;
					 	case "bonus":
					 		leggiEffettoBonus(effetto);
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
	
	private static void leggiEffettoAddRisorsa(Element effetto) {
		
		String risorsa = effetto.getElementsByTagName("tipoRisorsa").item(0).getFirstChild().getNodeValue();
		String quantita = effetto.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue();
		
		System.out.println("Risorsa: " + risorsa);
		System.out.println("Quantita:" + quantita);
	}

	private static void leggiEffettoAzione(Element effetto) {

		String tipoAzione = effetto.getAttribute("idAzione");
		
		switch(tipoAzione){
		case "raccolta": 
			int valoreDadoRaccolta = Integer.parseInt(effetto.getElementsByTagName("valoreDado").item(0).getFirstChild().getNodeValue());
			break;
		case "produzione": 
			int valoreDadoProduzione = Integer.parseInt(effetto.getElementsByTagName("valoreDado").item(0).getFirstChild().getNodeValue());
			break;
		case "carta": 
			int valoreDadoCarta = Integer.parseInt(effetto.getElementsByTagName("valoreDado").item(0).getFirstChild().getNodeValue());
			String coloreCarta = effetto.getElementsByTagName("coloreCarta").item(0).getFirstChild().getNodeValue();
			break;
		default:
		}
	}

	private static void leggiEffettoMoltiplicazione(Element effetto) {

		String fattore1 = effetto.getElementsByTagName("fattore1").item(0).getFirstChild().getNodeValue();
		String quantita1 = effetto.getElementsByTagName("quantita1").item(0).getFirstChild().getNodeValue();
		String fattore2 = effetto.getElementsByTagName("fattore2").item(0).getFirstChild().getNodeValue();
		String quantita2 = effetto.getElementsByTagName("quantita2").item(0).getFirstChild().getNodeValue();
		
		System.out.println("Primo elemento della moltiplicazione: " + fattore1);
		System.out.println("Quantita: " + quantita1);
		System.out.println("Secondo elemento della moltiplicazione: " + fattore2);
		System.out.println("Quantita: " + quantita2);
	}

	private static void leggiEffettoScambio(Element effetto) {
		
		NodeList listaPagamenti = effetto.getElementsByTagName("insiemePagamenti");
		System.out.println("Lista pagamenti:");
		
        for (int j = 0; j < listaPagamenti.getLength(); j++) {
            Element pagamento = (Element) listaPagamenti.item(j);
            String risorsa = pagamento.getElementsByTagName("risorsa").item(0).getFirstChild().getNodeValue();
            String quantita = pagamento.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue();
            System.out.println("RisorsaAlt["+j+"]:" +risorsa);
            System.out.println("QuantitaAlt["+j+"]:" +quantita);
        }
        
        NodeList listaGuadagni = effetto.getElementsByTagName("guadagno");
		System.out.println("Lista guadagni:");
		
        for (int j = 0; j < listaGuadagni.getLength(); j++) {
            Element guadagno = (Element) listaGuadagni.item(j);
            String risorsa = guadagno.getElementsByTagName("risorsa").item(0).getFirstChild().getNodeValue();
            String quantita = guadagno.getElementsByTagName("quantita").item(0).getFirstChild().getNodeValue();
            System.out.println("RisorsaAlt["+j+"]:" +risorsa);
            System.out.println("QuantitaAlt["+j+"]:" +quantita);
        }
	}

	private static void leggiEffettoBonus(Element effetto) {
		
		String tipoAzione = effetto.getAttribute("idAzione");
		
		switch(tipoAzione){
		case "raccolta": 
			int valoreDadoRaccolta = Integer.parseInt(effetto.getElementsByTagName("bonusDado").item(0).getFirstChild().getNodeValue());
			break;
		case "produzione": 
			int valoreDadoProduzione = Integer.parseInt(effetto.getElementsByTagName("bonusDado").item(0).getFirstChild().getNodeValue());
			break;
		case "carta": 
			int valoreDadoCarta = Integer.parseInt(effetto.getElementsByTagName("bonusDado").item(0).getFirstChild().getNodeValue());
			String coloreCarta = effetto.getElementsByTagName("coloreCarta").item(0).getFirstChild().getNodeValue();
			break;
		default:
		}
	}

	public static void leggiCartaVerde (Element carta){
		String ID = carta.getAttribute("id");
		String nome = carta.getElementsByTagName("nome").item(0).getFirstChild().getNodeValue();
		String periodo = carta.getElementsByTagName("periodo").item(0).getFirstChild().getNodeValue();
		String dado = carta.getElementsByTagName("dadoRaccolto").item(0).getFirstChild().getNodeValue();
		int periodoInt = Integer.parseInt(periodo);
		
		System.out.println("ID: " + ID);
		System.out.println("Nome:" + nome);
		System.out.println("Periodo:" + periodoInt);
		System.out.println("Dado raccolto:" + dado);
		
		NodeList listaEffettiImm = carta.getElementsByTagName("effettoImm");
		
        for (int j = 0; j < listaEffettiImm.getLength(); ++j) {
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
