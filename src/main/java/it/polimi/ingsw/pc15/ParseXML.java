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
		
		LeggiCarta(ColoreCarta.VERDE);
		LeggiCarta(ColoreCarta.GIALLO);
		LeggiCarta(ColoreCarta.BLU);
		LeggiCarta(ColoreCarta.VIOLA);
		
		
	}
	
	public static void LeggiCarta (ColoreCarta coloreCarta){
		
		try{
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			Document document = builder.parse(new File("/Users/andre/LaboratorioProvaFinale/prova-finale-template/XML/Cards_v1.2.xml"));
			
			NodeList carte = document.getElementsByTagName("carta");
			
			//System.out.println("Totale delle carte: " + carte.getLength());
			System.out.println("CARTE VERDI: ");
			
			for(int i=0; i<carte.getLength(); i++){
				Node nodo = carte.item(i);
				
				if(nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element carta = (Element)nodo;
					
					String nome = carta.getElementsByTagName("nome").item(0).getFirstChild().getNodeValue();
					String colore = carta.getElementsByTagName("colore").item(0).getFirstChild().getNodeValue();
					
					if(colore.toUpperCase().equals(coloreCarta.toString())){
						System.out.println("Nome carta: " + nome);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
