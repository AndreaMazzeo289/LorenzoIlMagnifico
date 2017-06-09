
package it.polimi.ingsw.pc15.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import it.polimi.ingsw.pc15.ParserXML;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.TipoCarta;
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
	private HashMap <TipoCarta, ArrayList> carteSviluppo;
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
		
		HashSet<Risorsa> risorse = new HashSet<Risorsa>();
		
		risorse.add(new Oro(0));
		risorse.add(new Legna(0));
		risorse.add(new Pietra(0));
		risorse.add(new Servitori(0));
		risorse.add(new PuntiMilitari(0));
		risorse.add(new PuntiFede(0));
		risorse.add(new PuntiVittoria(0));
		risorse.add(new Privilegi(0));
		
		this.setRisorse = new SetRisorse(risorse);
			
		//-----------------------------------------------------------------------------------------------------------//
		//          CARTE                                                                                            //
		//-----------------------------------------------------------------------------------------------------------//
		
		int numeroMaxCarte = ParserXML.leggiValore("numeroMaxCarte");
		
		ArrayList<Territorio> territori = new ArrayList<Territorio>(numeroMaxCarte);
		ArrayList<Personaggio> personaggi = new ArrayList<Personaggio>(numeroMaxCarte);
		ArrayList<Edificio> edifici = new ArrayList<Edificio>(numeroMaxCarte);
		ArrayList<Impresa> imprese = new ArrayList<Impresa>(numeroMaxCarte);
		
		this.carteSviluppo = new HashMap<TipoCarta, ArrayList>();
		this.carteSviluppo.put(TipoCarta.TERRITORIO, territori);
		this.carteSviluppo.put(TipoCarta.PERSONAGGIO, personaggi);
		this.carteSviluppo.put(TipoCarta.EDIFICIO, edifici);
		this.carteSviluppo.put(TipoCarta.IMPRESA, imprese);

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
	
	public ArrayList<Carta> getCarte (TipoCarta colore) {
		
		if (colore.equals(TipoCarta.ALL)) {
			ArrayList<Carta> arrayRichiesto = new ArrayList<Carta>();
			for (Carta territorio : getCarte(TipoCarta.TERRITORIO))
				arrayRichiesto.add(territorio);
			for (Carta personaggio : getCarte(TipoCarta.PERSONAGGIO))
				arrayRichiesto.add(personaggio);
			for (Carta edificio : getCarte(TipoCarta.EDIFICIO))
				arrayRichiesto.add(edificio);
			for (Carta impresa : getCarte(TipoCarta.IMPRESA))
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
	
	public ArrayList<Leader> getCarteLeader () {
		return this.carteLeader;
	}
	
	public Set<Player> getAvversari() {
		return this.avversari;
	}

}