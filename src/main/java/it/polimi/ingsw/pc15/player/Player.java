
package it.polimi.ingsw.pc15.player;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import it.polimi.ingsw.pc15.ParserXML;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.carte.Impresa;
import it.polimi.ingsw.pc15.carte.Personaggio;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.risorse.Risorsa;
import it.polimi.ingsw.pc15.risorse.SetRisorse;


/**
 * Classe che inizializza il player con un suo set risorse, i suoi familiari,
 * i suoi effetti attivi e leader.
 * Questi vengono definiti non appena la partita viene creata.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class Player implements Serializable {
	
	private final String nome;
	private ColorePlayer colore;
	private SetRisorse setRisorse;
	private HashMap<ColoreFamiliare, Familiare> familiari;
	private HashMap <TipoCarta, ArrayList> carteSviluppo;
	private EffettiAttivi effettiAttivi;
	private ArrayList<Leader> carteLeader;
	private Set<Player> avversari;
	private TesseraBonus tesseraBonus;
	
	public Player (String nome, ColorePlayer colore) {
		
		this.nome = nome;
		this.colore = colore;
		this.effettiAttivi = new EffettiAttivi();	
		this.carteLeader = new ArrayList<Leader>();
		this.avversari = null;
		
		this.familiari = new HashMap<ColoreFamiliare, Familiare>();
		
		for (ColoreFamiliare coloreFamiliare : ColoreFamiliare.values())
			familiari.put(coloreFamiliare, new Familiare(coloreFamiliare, this));
		
		this.setRisorse = new SetRisorse(new HashSet<Risorsa>());
		
		int numeroMaxCarte = ParserXML.leggiValore("numeroMaxCarte");
		
		this.carteSviluppo = new HashMap<TipoCarta, ArrayList>();
		this.carteSviluppo.put(TipoCarta.TERRITORIO, new ArrayList<Territorio>(numeroMaxCarte));
		this.carteSviluppo.put(TipoCarta.PERSONAGGIO, new ArrayList<Personaggio>(numeroMaxCarte));
		this.carteSviluppo.put(TipoCarta.EDIFICIO, new ArrayList<Edificio>(numeroMaxCarte));
		this.carteSviluppo.put(TipoCarta.IMPRESA, new ArrayList<Impresa>(numeroMaxCarte));

	}
	
	//-----------------------------------------------------------------------------------------------------------//
	//          METODI GET                                                                                       //
	//-----------------------------------------------------------------------------------------------------------//

	/**
	 * @return restituisce il nome del player
	 */
	
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * @return restituisce il set risorse del player.
	 */
	
	public SetRisorse getSetRisorse() {
		return this.setRisorse;
	}
	
	/**
	 * Restituisce la lista della totalità delle carte di un determinato tipo
	 * in possesso del player.
	 * 
	 * @param tipo delle carte da restituire.
	 * @return lista di carte appartenente al player.
	 */
	
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
	
	/**
	 * @return l'oggetto EffettiAttivi corrispondente al player in questione.
	 */
	
	public EffettiAttivi getEffettiAttivi(){
		return effettiAttivi;
	}
	
	/**
	 * @param coloreFamiliare da restituire.
	 * @return un familiare del player.
	 */
	
	public Familiare getFamiliare(ColoreFamiliare coloreFamiliare){
		return this.familiari.get(coloreFamiliare);
	}
	
	/**
	 * @return la lista delle carte leader in possesso del player.
	 */
	
	public ArrayList<Leader> getCarteLeader () {
		return this.carteLeader;
	}
	
	/**
	 * @return il set di avversari in partita contro il player.
	 */
	
	public Set<Player> getAvversari() {
		return this.avversari;
	}
	
	/**
	 * @return il colore associato al player a inizio partita.
	 */
	
	public ColorePlayer getColore() {
		return this.colore;
	}
	
	public TesseraBonus getTesseraBonus() {
		return this.tesseraBonus;
	}
	
	public void setTesseraBonus(TesseraBonus tesseraBonus) {
		this.tesseraBonus = tesseraBonus;
	}

}