package it.polimi.ingsw.pc15.player;

import it.polimi.ingsw.pc15.risorse.SetRisorse;

public class TesseraBonus {
	
	private SetRisorse risorseBonusRaccolta;
	private SetRisorse risorseBonusProduzione;
	private String imgPath;
	
	public TesseraBonus (SetRisorse risorseBonusRaccolta, SetRisorse risorseBonusProduzione, String imgPath) {
		this.risorseBonusRaccolta = risorseBonusRaccolta;
		this.risorseBonusProduzione = risorseBonusProduzione;
		this.imgPath = imgPath;
	}
	
	public SetRisorse getRisorseBonusRaccolta() {
		return this.risorseBonusRaccolta;
	}
	
	public SetRisorse getRisorseBonusProduzione() {
		return this.risorseBonusProduzione;
	}
	
	public String getImgPath() {
		return this.imgPath;
	}

}
