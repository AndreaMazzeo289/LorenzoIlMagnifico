package it.polimi.ingsw.pc15.player;

import java.io.Serializable;

import it.polimi.ingsw.pc15.risorse.SetRisorse;

/**
 * CLasse tessera bonus del player che definisce le risorse da guadagnare
 * occupando uno spazio produzione o raccolta.
 * 
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class TesseraBonus implements Serializable {
	
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
