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
	
	private int bonusRaccolta;
	private int bonusProduzione;
	
	private boolean disponibilitàMercato;
	private boolean bonusSpazioTorri;
	private boolean requisitoTerritori;
	private boolean permessoSpaziOccupati;
	private boolean sovrapprezzoServitori;
	private boolean sovrapprezzoTorri;

	private SetRisorse risorseBonusCarte;
	private SetRisorse risorseBonusSpazi;
	private int moltiplicatoreRisorseCarte;
	private int moltiplicatoreRisorseSpazi;
	
	
	public EffettiAttivi (){
		
		bonusDadoCarte = new HashMap<TipoCarta, Integer>();
		scontoCostoCarte = new HashMap<TipoCarta, SetRisorse>();
		
		bonusDadoCarte.put(TipoCarta.TERRITORIO, 0);
		bonusDadoCarte.put(TipoCarta.PERSONAGGIO, 0);
		bonusDadoCarte.put(TipoCarta.EDIFICIO, 0);
		bonusDadoCarte.put(TipoCarta.IMPRESA, 0);
		
		bonusDadoCarte.put(TipoCarta.TERRITORIO, 0);
		bonusDadoCarte.put(TipoCarta.PERSONAGGIO, 0);
		bonusDadoCarte.put(TipoCarta.EDIFICIO, 0);
		bonusDadoCarte.put(TipoCarta.IMPRESA, 0);
		
		bonusPuntiVittoriaFinale = new HashMap<TipoCarta, Boolean>();
		bonusPuntiVittoriaFinale.put(TipoCarta.TERRITORIO, true);
		bonusPuntiVittoriaFinale.put(TipoCarta.PERSONAGGIO, true);
		bonusPuntiVittoriaFinale.put(TipoCarta.IMPRESA, true);

		this.bonusRaccolta = 0;
		this.bonusProduzione = 0;
	
		this.disponibilitàMercato = true;
		this.bonusSpazioTorri = true;
		this.requisitoTerritori = true;
		this.permessoSpaziOccupati = false;
		this.sovrapprezzoTorri = true;
		this.sovrapprezzoServitori = false;

		risorseBonusCarte = new SetRisorse(new HashSet<Risorsa>());
		risorseBonusSpazi = new SetRisorse(new HashSet<Risorsa>());
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
		this.scontoCostoCarte.put(tipo, sconto);
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
	
	public void setMoltiplicatoreRisorseCarte(int moltiplicatore) {
		this.moltiplicatoreRisorseCarte = moltiplicatore;
	}
	
	public void setMoltiplicatoreRisorseSpazi(int moltiplicatore) {
		this.moltiplicatoreRisorseSpazi = moltiplicatore;
	}
	
	public void setSovrapprezzoServitori() {
		this.sovrapprezzoServitori = true;
	}
	
	public void annullaSovrapprezzoTorri() {
		this.sovrapprezzoTorri = false;
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
	
	public SetRisorse getRisorseBonusSpazi() {
		return this.risorseBonusSpazi;
	}
	
	public SetRisorse getRisorseBonusCarte() {
		return this.risorseBonusCarte;
	}
	
	public int getMoltiplicatoreRisorseSpazi() {
		return this.moltiplicatoreRisorseSpazi;
	}
	
	public int getMoltiplicatoreRisorseCarte() {
		return this.moltiplicatoreRisorseCarte;
	}
	
	public boolean sovrapprezzoTorri() {
		return this.sovrapprezzoTorri;
	}
	
	public boolean sovrapprezzoServitori() {
		return this.sovrapprezzoServitori;
	}
	
}
