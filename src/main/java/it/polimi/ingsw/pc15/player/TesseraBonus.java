package it.polimi.ingsw.pc15.player;

import it.polimi.ingsw.pc15.risorse.SetRisorse;

public class TesseraBonus {
	
	private SetRisorse risorseBonusRaccolta;
	private SetRisorse risorseBonusProduzione;
	
	public TesseraBonus (SetRisorse risorseBonusRaccolta, SetRisorse risorseBonusProduzione) {
		this.risorseBonusRaccolta = risorseBonusRaccolta;
		this.risorseBonusProduzione = risorseBonusProduzione;
	}
	
	public SetRisorse getRisorseBonusRaccolta() {
		return this.risorseBonusRaccolta;
	}
	
	public SetRisorse getRisorseBonusProduzione() {
		return this.risorseBonusProduzione;
	}

}
