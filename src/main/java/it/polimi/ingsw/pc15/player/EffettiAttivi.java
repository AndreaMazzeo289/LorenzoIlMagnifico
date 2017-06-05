package it.polimi.ingsw.pc15.player;

import java.util.HashMap;
import java.util.HashSet;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.risorse.Risorsa;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class EffettiAttivi {
	
	private HashMap<TipoCarta, Integer> bonusDadoCarte;
	private int bonusRaccolta;
	private int bonusProduzione;
	private boolean disponibilitàMercato;
	private boolean bonusSpazioTorri;
	private boolean requisitoTerritori;
	private boolean permessoSpaziOccupati;
	private HashMap<TipoCarta, Boolean> bonusPuntiVittoriaFinale;
	private SetRisorse risorseBonusCarte;
	private SetRisorse risorseBonusSpazi;
	private int moltiplicatoreRisorseCarte;
	private int moltiplicatoreRisorseSpazi;
	
	
	public EffettiAttivi (){
		
		bonusDadoCarte = new HashMap<TipoCarta, Integer>();
		
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
		

		risorseBonusCarte = new SetRisorse(new HashSet<Risorsa>());
		risorseBonusSpazi = new SetRisorse(new HashSet<Risorsa>());
		moltiplicatoreRisorseCarte = 1;
		moltiplicatoreRisorseSpazi = 1;
		
		
	}
	
	
	
	//-----------------------------------------------------------------------------------------------------------//
	//          METODI SET                                                                                       //
	//-----------------------------------------------------------------------------------------------------------//
	
	public void incrementaBonusDadoCarte (TipoCarta colore, int valore) {
		int valoreAggiornato = bonusDadoCarte.get(colore).intValue();
		bonusDadoCarte.put(colore, valoreAggiornato);	
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
	
	
	
	//-----------------------------------------------------------------------------------------------------------//
	//          METODI GET                                                                                       //
	//-----------------------------------------------------------------------------------------------------------//
	
	public int getBonusRaccolta() {
		return this.bonusRaccolta;
	}
	
	public int getBonusProduzione() {
		return this.bonusProduzione;
	}
	
	public int getBonusDadoCarte (TipoCarta colore) {
		return this.bonusDadoCarte.get(colore);
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
	
}
