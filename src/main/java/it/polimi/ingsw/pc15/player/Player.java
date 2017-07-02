
package it.polimi.ingsw.pc15.player;

import java.io.Serializable;
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

public class Player implements Serializable {
	
	private final String nome;
	private SetRisorse setRisorse;
	private HashMap<ColoreFamiliare, Familiare> familiari;
	private HashMap <TipoCarta, ArrayList> carteSviluppo;
	private EffettiAttivi effettiAttivi;
	private ArrayList<Leader> carteLeader;
	private Set<Player> avversari;
	
	
	public Player (String nome) {
		
		this.nome = nome;
		this.effettiAttivi = new EffettiAttivi();	
		this.carteLeader = new ArrayList<Leader>();
		this.avversari = null;
		
		this.familiari = new HashMap<ColoreFamiliare, Familiare>();
		
		for (ColoreFamiliare colore : ColoreFamiliare.values())
			familiari.put(colore, new Familiare(colore, this));
		
		this.setRisorse = new SetRisorse(new HashSet<Risorsa>());
			
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
	
	public ArrayList<Carta> getCarte (TipoCarta tipo) {
		
		if (tipo.equals(TipoCarta.ALL)) {
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
		
		return this.carteSviluppo.get(tipo);
	}
	
	public EffettiAttivi getEffettiAttivi(){
		return effettiAttivi;
	}
	
	public Familiare getFamiliare(ColoreFamiliare coloreFamiliare){
		return this.familiari.get(coloreFamiliare);
	}
	
	public ArrayList<Leader> getCarteLeader () {
		return this.carteLeader;
	}
	
	public Set<Player> getAvversari() {
		return this.avversari;
	}

}