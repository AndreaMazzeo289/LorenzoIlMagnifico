package it.polimi.ingsw.pc15;

import java.util.Observable;
import java.util.Set;

public class Model extends Observable {
	
	private Set<Player> giocatori;
	private Plancia plancia;
	private int turno;
	private int periodo;
	private ParseXML parseXML;
	private Set<Carta> setCarteTerritorio;
	private Set<Carta> setCartePersonaggio;
	private Set<Carta> setCarteEdificio;
	private Set<Carta> setCarteImpresa;
	
	//numero carte
	private static final int NUMCARTE = 24;
	
	
	public Model(){
		
		this.plancia = new Plancia();
		this.parseXML = new ParseXML();
		this.turno = 0;
		this.periodo = 0;
		
	}
	
	public void iniziaPartita(){
		
		//istanzio carte territorio
		
		for(int i = 0; i<NUMCARTE; i++){
			
			setCarteTerritorio.add(parseXML.getCartaXML("VERDE"));	
		}
		
		for(int i = 0; i<NUMCARTE; i++){
			setCartePersonaggio.add(parseXML.getCartaXML("BLU"));
		}
		
		for(int i = 0; i<NUMCARTE; i++){
			setCarteEdificio.add(parseXML.getCartaXML("GIALLO"));
		}
		
		for (int i = 0; i<NUMCARTE; i++){
			setCarteImpresa.add(parseXML.getCartaXML("VIOLA"));
		}
		
	}
	
	public void iniziaTurno(){
		
		
		
	}
	
	
	

}
