package it.polimi.ingsw.pc15.player;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.risorse.Risorsa;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

/**
 * Classe contenente tutti i bonus associabili al player durante la partita
 * per effetti di carte, scomuniche e leader. 
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class EffettiAttivi implements Serializable{
	
	private HashMap<TipoCarta, Integer> bonusDadoCarte;
	private HashMap<TipoCarta, SetRisorse> scontoCostoCarte;
	private HashMap<TipoCarta, Boolean> bonusPuntiVittoriaFinale;
	private HashMap<TipoRisorsa, Integer> risorseBonusCarte;
	private HashMap<TipoRisorsa, Integer> risorseBonusSpazi;
	
	private int bonusRaccolta;
	private int bonusProduzione;
	
	private boolean disponibilitàMercato;
	private boolean bonusSpazioTorri;
	private boolean requisitoTerritori;
	private boolean permessoSpaziOccupati;
	private boolean sovrapprezzoServitori;
	private boolean sovrapprezzoTorri;

	private int moltiplicatoreRisorseCarte;
	private int moltiplicatoreRisorseSpazi;
	
	
	public EffettiAttivi (){
		
		bonusDadoCarte = new HashMap<TipoCarta, Integer>();
		scontoCostoCarte = new HashMap<TipoCarta, SetRisorse>();
		bonusPuntiVittoriaFinale = new HashMap<TipoCarta, Boolean>();
		risorseBonusCarte = new HashMap<TipoRisorsa, Integer>();
		risorseBonusSpazi = new HashMap<TipoRisorsa, Integer>();
		
		for (TipoCarta tipoCarta : TipoCarta.values()) {
			bonusDadoCarte.put(tipoCarta, 0);
			scontoCostoCarte.put(tipoCarta, new SetRisorse(new HashSet<Risorsa>()));
			bonusPuntiVittoriaFinale.put(tipoCarta, true);
		}
		
		for (TipoRisorsa tipoRisorsa : TipoRisorsa.values()) {
			risorseBonusCarte.put(tipoRisorsa, 0);
			risorseBonusSpazi.put(tipoRisorsa, 0);
		}

		this.bonusRaccolta = 0;
		this.bonusProduzione = 0;
	
		this.disponibilitàMercato = true;
		this.bonusSpazioTorri = true;
		this.requisitoTerritori = true;
		this.permessoSpaziOccupati = false;
		this.sovrapprezzoTorri = true;
		this.sovrapprezzoServitori = false;


		moltiplicatoreRisorseCarte = 1;
		moltiplicatoreRisorseSpazi = 1;
		
		
	}
	
	
	
	//-----------------------------------------------------------------------------------------------------------//
	//          METODI SET                                                                                       //
	//-----------------------------------------------------------------------------------------------------------//
	
	
	/**
	 * Incrementa il valore del familiare per posizionarsi su una torre
	 *  di un determinato colore.
	 * 
	 * @param colore della carta.
	 * @param valore dell'incremento.
	 */
	
	public void incrementaBonusDadoCarte (TipoCarta colore, int valore) {
		int valoreAggiornato = bonusDadoCarte.get(colore).intValue() + valore;
		bonusDadoCarte.put(colore, valoreAggiornato);	
	}
	
	/**
	 * Aggiunge uno sconto all'acquisto di carte di un detetrminato tipo.
	 * 
	 * @param tipo della carta da scontare.
	 * @param sconto è il set risorse da sottrarre al costo della carta all'acquisto.
	 */
	
	public void aggiungiScontoCostoCarte (TipoCarta tipo, SetRisorse sconto) {
		SetRisorse scontoAggiornato = this.scontoCostoCarte.get(tipo);
		scontoAggiornato.aggiungi(sconto);
		this.scontoCostoCarte.put(tipo, scontoAggiornato);
	}
	
	
	/**
	 * Annulla a fine partita il bonus in punti vittoria ottenibile dal collezionamento di un
	 * determinato numero di carte dello stesso colore.
	 * 
	 * @param colore del bonus carte da annullare  a fine partita.
	 */
	
	public void annullaBonusPuntiVittoriaFinale (TipoCarta colore) {
		bonusPuntiVittoriaFinale.put(colore, false);
	}
	
	/**
	 * Aggiunge un incremento al valore del familiare utilizzato per una 
	 * azione di raccolta.
	 * 
	 * @param incremento del valore del familiare.
	 */
	
	public void incrementaBonusRaccolta(int incremento){
		this.bonusRaccolta += incremento;
	}
	
	/**
	 * Aggiunge un incremento al valore del familiare utilizzato per una 
	 * azione di produzione.
	 * 
	 * @param incremento del valore del familiare.
	 */
	
	public void incrementaBonusProduzione(int incremento){
		this.bonusProduzione += incremento;
	}
	
	
	/**
	 * Nega al player la possibilità di accedere al mercato.
	 */
	
	public void annullaDisponibilitàMercato(){
		this.disponibilitàMercato = false;
	}
	
	/**
	 * Nega al player la possibilità di ricevere bonus istantanei in risorse
	 * dal posizionamento del familiare nei due piani più alti delle torri.
	 */
	
	public void annullaBonusSpazioTorre(){
		this.bonusSpazioTorri = false;
	}
	
	/**
	 * Annulla il requisito in punti militari necessario per 
	 * collezionare un determinato numero di carte territorio.
	 */
	
	public void annullaRequisitoTerritori() {
		this.requisitoTerritori = false;
	}
	
	/**
	 * Posso posizionare il familare in spazi già occupati.
	 */
	
	public void concediPermessoSpaziOccupati() {
		this.permessoSpaziOccupati = true;
	}
	
	/*
	 * Aggiunge un sovrapprezzo al scrificio di servitori 
	 * per aumentare il valore di un familiare.
	 */
	
	public void setSovrapprezzoServitori() {
		this.sovrapprezzoServitori = true;
	}
	
	public void annullaSovrapprezzoTorri() {
		this.sovrapprezzoTorri = false;
	}
	
	
	/**
	 * Aggiunge un moltiplicatore che va a modificare le risorse guadagnate
	 * tramite carte.
	 * 
	 * @param moltiplicatore delle risorse carte.
	 */
	
	public void setMoltiplicatoreRisorseCarte(int moltiplicatore) {
		this.moltiplicatoreRisorseCarte = moltiplicatore;
	}
	
	/**
	 * Aggiunge un moltiplicatore che va a modificare le risorse guadagnate
	 * tramite spazi.
	 * 
	 * @param moltiplicatore delle risorse spazi.
	 */
	
	public void setMoltiplicatoreRisorseSpazi(int moltiplicatore) {
		this.moltiplicatoreRisorseSpazi = moltiplicatore;
	}
	
	/**
	 * Incrementa le risorse ottenute da carte di un valore specificato dall'effetto in particolare.
	 * 
	 * @param tipoRisorsa per cui settare il bonus.
	 * @param i che definisce la quantità corrispondente al bonus.
	 */
	
	public void incrementaRisorseBonusCarte(TipoRisorsa tipoRisorsa, int i) {
		int valoreAggiornato = risorseBonusCarte.get(tipoRisorsa).intValue() + i;
		risorseBonusCarte.put(tipoRisorsa, valoreAggiornato);
	}
	
	/**
	 * Incrementa le risorse ottenute da spazi di un valore specificato dall'effetto in particolare.
	 * 
	 * @param tipoRisorsa per cui settare il bonus.
	 * @param i che definisce la quantità corrispondente al bonus.
	 */
	
	public void incrementaRisorseBonusSpazi(TipoRisorsa tipoRisorsa, int i) {
		int valoreAggiornato = risorseBonusCarte.get(tipoRisorsa).intValue() + i;
		risorseBonusCarte.put(tipoRisorsa, valoreAggiornato);
	}
	

	
	
	//-----------------------------------------------------------------------------------------------------------//
	//          METODI GET                                                                                       //
	//-----------------------------------------------------------------------------------------------------------//
	
	public int getBonusRaccolta() {
		return this.bonusRaccolta;
	}
	
	public int getBonusProduzione() {
		return this.bonusProduzione;
	}
	
	public int getBonusDadoCarte (TipoCarta tipo) {
		return this.bonusDadoCarte.get(tipo).intValue();
	}
	
	public SetRisorse getScontoCostoCarte (TipoCarta tipo) {
		return this.scontoCostoCarte.get(tipo);
	}
	
	public boolean bonusPuntiVittoriaFinale (TipoCarta tipo) {
		return this.bonusPuntiVittoriaFinale.get(tipo);
	}
	
	public boolean disponibilitàMercato() {
		return this.disponibilitàMercato;
	}
	
	public boolean disponibilitàBonusSpazioTorri() {
		return this.bonusSpazioTorri;
	}
	
	public boolean requisitoTerritoriAttivo() {
		return this.requisitoTerritori;
	}
	
	public boolean controllaPermessoSpaziOccupati() {
		return this.permessoSpaziOccupati;
	}
	
	public HashMap<TipoRisorsa, Integer> getRisorseBonusSpazi() {
		return this.risorseBonusSpazi;
	}
	
	public HashMap<TipoRisorsa, Integer> getRisorseBonusCarte() {
		return this.risorseBonusCarte;
	}
	
	public boolean sovrapprezzoTorri() {
		return this.sovrapprezzoTorri;
	}
	
	public boolean sovrapprezzoServitori() {
		return this.sovrapprezzoServitori;
	}
	
	public int getMoltiplicatoreRisorseSpazi() {
		return this.moltiplicatoreRisorseSpazi;
	}
	
	public int getMoltiplicatoreRisorseCarte() {
		return this.moltiplicatoreRisorseCarte;
	}
	
	public int getRisorsaBonusCarte(TipoRisorsa tipoRisorsa) {
		return this.risorseBonusCarte.get(tipoRisorsa);
	}
	
	public int getRisorsaBonusSpazi(TipoRisorsa tipoRisorsa) {
		return this.risorseBonusSpazi.get(tipoRisorsa);
	}
	

	
}
