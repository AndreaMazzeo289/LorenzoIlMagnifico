package it.polimi.ingsw.pc15.player;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.risorse.Risorsa;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

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
	
	public void incrementaBonusDadoCarte (TipoCarta colore, int valore) {
		int valoreAggiornato = bonusDadoCarte.get(colore).intValue() + valore;
		bonusDadoCarte.put(colore, valoreAggiornato);	
	}
	
	public void aggiungiScontoCostoCarte (TipoCarta tipo, SetRisorse sconto) {
		SetRisorse scontoAggiornato = this.scontoCostoCarte.get(tipo);
		scontoAggiornato.aggiungi(sconto);
		this.scontoCostoCarte.put(tipo, scontoAggiornato);
	}
	
	public void annullaBonusPuntiVittoriaFinale (TipoCarta colore) {
		bonusPuntiVittoriaFinale.put(colore, false);
	}
	
	public void incrementaBonusRaccolta(int incremento){
		this.bonusRaccolta += incremento;
	}
	
	public void incrementaBonusProduzione(int incremento){
		this.bonusProduzione += incremento;
	}
	
	public void annullaDisponibilitàMercato(){
		this.disponibilitàMercato = false;
	}
	
	public void annullaBonusSpazioTorre(){
		this.bonusSpazioTorri = false;
	}
	
	public void annullaRequisitoTerritori() {
		this.requisitoTerritori = false;
	}
	
	public void concediPermessoSpaziOccupati() {
		this.permessoSpaziOccupati = true;
	}
	
	public void setSovrapprezzoServitori() {
		this.sovrapprezzoServitori = true;
	}
	
	public void annullaSovrapprezzoTorri() {
		this.sovrapprezzoTorri = false;
	}
	
	public void setMoltiplicatoreRisorseCarte(int moltiplicatore) {
		this.moltiplicatoreRisorseCarte = moltiplicatore;
	}
	
	public void setMoltiplicatoreRisorseSpazi(int moltiplicatore) {
		this.moltiplicatoreRisorseSpazi = moltiplicatore;
	}
	
	public void incrementaRisorseBonusCarte(TipoRisorsa tipoRisorsa, int i) {
		int valoreAggiornato = risorseBonusCarte.get(tipoRisorsa).intValue() + i;
		risorseBonusCarte.put(tipoRisorsa, valoreAggiornato);
	}
	
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
