package it.polimi.ingsw.pc15;

public class EffettiAttivi {
	
	private int bonusDadoCarte[]; 
	private int bonusRaccolta;
	private int bonusProduzione;
	private int bonusPersonaggi;
	private boolean mercato;
	private boolean spazioTorri;
	private int bonusDadi[];
	
	public EffettiAttivi (int[] bonusDadoCarte, int[] bonusDadi, int bonusRaccolta, int bonusProduzione, int bonusPersonaggi){
		
		this.bonusDadoCarte = new int[5];
		this.bonusDadoCarte = bonusDadoCarte;
		this.bonusDadi = new int[4];
		this.bonusDadi = bonusDadi;
		this.bonusRaccolta = bonusRaccolta;
		this.bonusProduzione = bonusProduzione;
		this.bonusPersonaggi = bonusPersonaggi;
	
		this.mercato = false;
		this.spazioTorri = false;
		
	}
	
	public void incrementaBonusRaccolta(int incremento){
		this.bonusRaccolta += incremento;
	}
	
	public void incrementaBonusProduzione(int incremento){
		this.bonusProduzione += incremento;
	}
	
	public void incrementaBonusPersonaggi(int incremento){
		this.bonusPersonaggi += incremento;
	}
	
	public void setMercato(){
		this.mercato = true;
	}
	
	public void setSpazioTorre(){
		this.spazioTorri = true;
	}
	
	public void incrementaBonusDadi(int familiare, int bonusDado){
		this.bonusDadi[familiare] += bonusDado;
	}
	
	public void incrementaBonusDadoCarte(int carta, int bonusDado){
		this.bonusDadoCarte[carta] += bonusDado;
	}
}
