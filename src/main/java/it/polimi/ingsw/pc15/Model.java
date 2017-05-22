package it.polimi.ingsw.pc15;

import java.util.Observable;
import java.util.Set;

public class Model extends Observable {
	
	private Set<Player> giocatori;
	private Plancia plancia;
	private int turno;
	private int periodo;
	private ParseXML parseXML;
	private Set<Territorio> setCarteTerritorio;
	private Set<Personaggio> setCartePersonaggio;
	private Set<Edificio> setCarteEdificio;
	private Set<Impresa> setCarteImpresa;

	public Model(){
		
		this.plancia = new Plancia(3);
		this.parseXML = new ParseXML();
		this.turno = 0;
		this.periodo = 0;
		
	}
	
	public void iniziaPartita(){
		
		// Istanziazione carte territorio :
		//----------------------------------	
		for(int i = 0; i<ParseXML.leggiValore("numeroCarteVerdi"); i++){
			setCarteTerritorio.add((Territorio) parseXML.getCartaXML(ColoreCarta.VERDE));	
		}
		
		// Istanziazione carte personaggio :
		//----------------------------------
		for(int i = 0; i<ParseXML.leggiValore("numeroCarteBlu"); i++){
			setCartePersonaggio.add((Personaggio) parseXML.getCartaXML(ColoreCarta.BLU));
		}
		
		// Istanziazione carte edicio :
		//----------------------------------
		for(int i = 0; i<ParseXML.leggiValore("numeroCarteGialle"); i++){
			setCarteEdificio.add((Edificio) parseXML.getCartaXML(ColoreCarta.GIALLO));
		}
		
		// Istanziazione carte impresa :
		//----------------------------------
		for (int i = 0; i<ParseXML.leggiValore("numeroCarteViola"); i++){
			setCarteImpresa.add((Impresa) parseXML.getCartaXML(ColoreCarta.VIOLA));
		}
		
	}
	
	public void iniziaTurno(){
		
		
		
	}
	
	
	

}
