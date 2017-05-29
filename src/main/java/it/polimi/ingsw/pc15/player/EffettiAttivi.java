package it.polimi.ingsw.pc15.player;

import java.util.HashMap;

import it.polimi.ingsw.pc15.carte.ColoreCarta;

public class EffettiAttivi {
	
	private HashMap<ColoreCarta, Integer> bonusDadoCarte;
	private int bonusRaccolta;
	private int bonusProduzione;
	private boolean disponibilitàMercato;
	private boolean bonusSpazioTorri;
	private boolean requisitoTerritori;
	private boolean permessoSpaziOccupati;
	private HashMap<ColoreCarta, Boolean> bonusPuntiVittoriaFinale;
	
	
	public EffettiAttivi (){
		
		bonusDadoCarte = new HashMap<ColoreCarta, Integer>();
		
		bonusDadoCarte.put(ColoreCarta.VERDE, 0);
		bonusDadoCarte.put(ColoreCarta.BLU, 0);
		bonusDadoCarte.put(ColoreCarta.GIALLO, 0);
		bonusDadoCarte.put(ColoreCarta.VIOLA, 0);
		
		bonusPuntiVittoriaFinale = new HashMap<ColoreCarta, Boolean>();
		
		bonusPuntiVittoriaFinale.put(ColoreCarta.VERDE, true);
		bonusPuntiVittoriaFinale.put(ColoreCarta.BLU, true);
		bonusPuntiVittoriaFinale.put(ColoreCarta.VIOLA, true);

		this.bonusRaccolta = 0;
		this.bonusProduzione = 0;
	
		this.disponibilitàMercato = true;
		this.bonusSpazioTorri = true;
		this.requisitoTerritori = true;
		this.permessoSpaziOccupati = false;
		
	}
	
	
	
	//-----------------------------------------------------------------------------------------------------------//
	//          METODI SET                                                                                       //
	//-----------------------------------------------------------------------------------------------------------//
	
	public void incrementaBonusDadoCarte (ColoreCarta colore, int valore) {
		int valoreAggiornato = bonusDadoCarte.get(colore).intValue();
		bonusDadoCarte.put(colore, valoreAggiornato);	
	}
	
	public void annullaBonusPuntiVittoriaFinale (ColoreCarta colore) {
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
	
	public int getBonusDadoCarte (ColoreCarta colore) {
		return this.bonusDadoCarte.get(colore);
	}
	
	public boolean bonusPuntiVittoriaFinale (ColoreCarta colore) {
		return this.bonusPuntiVittoriaFinale.get(colore);
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
	
}
