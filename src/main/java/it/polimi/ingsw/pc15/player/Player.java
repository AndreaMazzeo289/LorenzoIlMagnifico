package it.polimi.ingsw.pc15.player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import it.polimi.ingsw.pc15.ParseXML;
import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.carte.Impresa;
import it.polimi.ingsw.pc15.carte.Personaggio;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.plancia.Spazio;
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

public class Player {
	
	private final String name;
	private SetRisorse setRisorse;
	private Set<Familiare> familiari;
	private ArrayList<Territorio> territori;
	private ArrayList<Personaggio> personaggi;
	private ArrayList<Edificio> edifici;
	private ArrayList<Impresa> imprese;
	private EffettiAttivi effettiAttivi;
	
	
	public Player (String name) {
		
		this.name = name;
		this.effettiAttivi = new EffettiAttivi();	
		
		//-----------------------------------------------------------------------------------------------------------//
		//          FAMILIARI                                                                                        //
		//-----------------------------------------------------------------------------------------------------------//
		
		this.familiari = new HashSet<Familiare>();
		
		Familiare familiareNero = new Familiare (ColoreFamiliare.NERO, this);
		Familiare familiareBianco = new Familiare (ColoreFamiliare.BIANCO, this);
		Familiare familiareArancione = new Familiare (ColoreFamiliare.ARANCIONE, this);
		Familiare familiareNeutro = new Familiare (ColoreFamiliare.NEUTRO, this);
		
		this.familiari.add(familiareBianco);
		this.familiari.add(familiareNero);
		this.familiari.add(familiareArancione);
		this.familiari.add(familiareNeutro);
			
		//-----------------------------------------------------------------------------------------------------------//
		//          RISORSE                                                                                          //
		//-----------------------------------------------------------------------------------------------------------//
		
		Oro oro = new Oro(0);
		Legna legna = new Legna(0);
		Pietra pietra = new Pietra(0);
		Servitori servitori = new Servitori(0);
		Privilegi privilegi = new Privilegi(0);
		PuntiFede puntiFede = new PuntiFede(0);
		PuntiMilitari puntiMilitari = new PuntiMilitari(0);
		PuntiVittoria puntiVittoria = new PuntiVittoria(0);
		
		HashSet<Risorsa> risorse = new HashSet<Risorsa>();
		
		risorse.add(oro);
		risorse.add(legna);
		risorse.add(pietra);
		risorse.add(servitori);
		risorse.add(privilegi);
		risorse.add(puntiFede);
		risorse.add(puntiMilitari);
		risorse.add(puntiVittoria);
		
		this.setRisorse = new SetRisorse(risorse);
			
		//-----------------------------------------------------------------------------------------------------------//
		//          CARTE                                                                                            //
		//-----------------------------------------------------------------------------------------------------------//
		
		int numeroMaxCarte = ParseXML.leggiValore("numeroMaxCarte");
		
		this.territori = new ArrayList<Territorio>(numeroMaxCarte);
		this.personaggi = new ArrayList<Personaggio>(numeroMaxCarte);
		this.edifici = new ArrayList<Edificio>(numeroMaxCarte);
		this.imprese = new ArrayList<Impresa>(numeroMaxCarte);

	}
	

	public void occupaSpazio (Spazio spazio, Familiare familiare) {
		
		if (familiare.disponibile()) {
		
			familiare.aggiungiServitori();
		
			if (spazio.occupabile(familiare) ) {
				
				familiare.setDisponibilità(false);
				spazio.occupa(familiare);
			}
		}	
	}
	
	
	
	//-----------------------------------------------------------------------------------------------------------//
	//          METODI GET                                                                                         //
	//-----------------------------------------------------------------------------------------------------------//

	public String getName() {
		return this.name;
	}
	
	public SetRisorse getSetRisorse() {
		return this.setRisorse;
	}
	
	public ArrayList<Territorio> getTerritori() {
		return this.territori;
	}
	
	public ArrayList<Personaggio> getPersonaggi() {
		return this.personaggi;
	}
	
	public ArrayList<Edificio> getEdifici() {
		return this.edifici;
	}
	
	public ArrayList<Impresa> getImprese() {
		return this.imprese;
	}
	
	public EffettiAttivi getEffettiAttivi(){
		return effettiAttivi;
	}
	
	public Familiare getFamiliare(ColoreFamiliare coloreFamiliare){
		
		Familiare familiareReturn = null;
		
		for(Familiare familiare : familiari) {
			if(familiare.getColore().equals(coloreFamiliare))
				familiareReturn = familiare;
		}
		
		return familiareReturn;
	}


	
	
	
	
	

}
