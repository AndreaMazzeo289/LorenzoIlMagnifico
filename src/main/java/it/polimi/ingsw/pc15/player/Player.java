
package it.polimi.ingsw.pc15.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import it.polimi.ingsw.pc15.ParseXML;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.ColoreCarta;
import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.carte.Impresa;
import it.polimi.ingsw.pc15.carte.Personaggio;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.effetti.Effetto;
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
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class Player {
	
	private final String nome;
	private SetRisorse setRisorse;
	private Set<Familiare> familiari;
	private HashMap <ColoreCarta, ArrayList> carteSviluppo;
	private EffettiAttivi effettiAttivi;
	private ArrayList<Leader> carteLeader;
	private Set<Player> avversari;
	
	
	public Player (String nome) {
		
		this.nome = nome;
		this.effettiAttivi = new EffettiAttivi();	
		this.carteLeader = new ArrayList<Leader>();
		this.avversari = null;
		
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
		
		Oro oro = new Oro(10);
		Legna legna = new Legna(10);
		Pietra pietra = new Pietra(10);
		Servitori servitori = new Servitori(3);
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
		
		ArrayList<Territorio> territori = new ArrayList<Territorio>(numeroMaxCarte);
		ArrayList<Personaggio> personaggi = new ArrayList<Personaggio>(numeroMaxCarte);
		ArrayList<Edificio> edifici = new ArrayList<Edificio>(numeroMaxCarte);
		ArrayList<Impresa> imprese = new ArrayList<Impresa>(numeroMaxCarte);
		
		this.carteSviluppo = new HashMap<ColoreCarta, ArrayList>();
		this.carteSviluppo.put(ColoreCarta.VERDE, territori);
		this.carteSviluppo.put(ColoreCarta.BLU, personaggi);
		this.carteSviluppo.put(ColoreCarta.GIALLO, edifici);
		this.carteSviluppo.put(ColoreCarta.VIOLA, imprese);

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
	
	public void scartaLeader (Leader leader) {

		this.carteLeader.remove(leader);
		this.setRisorse.getRisorsa(TipoRisorsa.PRIVILEGI).aggiungi(1);
	}
	
	public void giocaLeader (int numeroLeader) {
		
		Leader leaderScelto = this.carteLeader.get(numeroLeader);
		
		if (leaderScelto.giocato())
			System.out.println("Hai già giocato questo leader!");
		
		if (leaderScelto.requisitiSoddisfatti() ) {
			System.out.println("Hai giocato la carta Leader " + leaderScelto.getNome());
			this.carteLeader.get(numeroLeader).setGiocato(true);
			
			if (this.carteLeader.get(numeroLeader).getEffettoPermanente()!=null) 
				for (Effetto effetto : this.carteLeader.get(numeroLeader).getEffettoPermanente())
					effetto.attiva(this);
		}
		
	}
	
	public void attivaEffettoLeader (int numeroLeader) {
		
		if (this.carteLeader.get(numeroLeader).effettoGiàAttivato() == false) {
			for (Effetto effetto : this.carteLeader.get(numeroLeader).getEffettoPerTurno() )
				effetto.attiva(this);
			this.carteLeader.get(numeroLeader).setEffettoAttivato(true);
		}
	}
	
	
	//-----------------------------------------------------------------------------------------------------------//
	//          METODI GET                                                                                       //
	//-----------------------------------------------------------------------------------------------------------//

	public String getNome() {
		return this.nome;
	}
	
	public SetRisorse getSetRisorse() {
		return this.setRisorse;
	}
	
	public ArrayList<Carta> getCarte (ColoreCarta colore) {
		
		if (colore.equals(ColoreCarta.ALL)) {
			ArrayList<Carta> arrayRichiesto = new ArrayList<Carta>();
			for (Carta territorio : getCarte(ColoreCarta.VERDE))
				arrayRichiesto.add(territorio);
			for (Carta personaggio : getCarte(ColoreCarta.BLU))
				arrayRichiesto.add(personaggio);
			for (Carta edificio : getCarte(ColoreCarta.GIALLO))
				arrayRichiesto.add(edificio);
			for (Carta impresa : getCarte(ColoreCarta.VIOLA))
				arrayRichiesto.add(impresa);
			return arrayRichiesto;
		}
		
		return this.carteSviluppo.get(colore);
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
	
	public ArrayList<Leader> getLeader () {
		return this.carteLeader;
	}
	
	public Set<Player> getAvversari() {
		return this.avversari;
	}

}