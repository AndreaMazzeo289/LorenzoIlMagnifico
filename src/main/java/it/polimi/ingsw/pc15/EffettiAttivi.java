package it.polimi.ingsw.pc15;

public class EffettiAttivi {
	
	private int bonusDadoCarte[]; 
	private int bonusRaccolta;
	private int bonusProduzione;
	private int bonusPersonaggi;
	private boolean disponibilitàMercato;
	private boolean bonusSpazioTorri;
	private int bonusDadi[];
	
	public EffettiAttivi (){
		
		this.bonusDadoCarte = new int[5];
		for(int i = 0; i<=4; i++){this.bonusDadoCarte[i]=0;}
		this.bonusDadi = new int[4];
		for(int i = 0; i<=4; i++){this.bonusDadi[i]=0;}
		this.bonusRaccolta = 0;
		this.bonusProduzione = 0;
		this.bonusPersonaggi = 0;
	
		this.disponibilitàMercato = true;
		this.bonusSpazioTorri = true;
		
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
	
	public void annullaDisponibilitàMercato(){
		this.disponibilitàMercato = false;
	}
	
	public void annullaBonusSpazioTorre(){
		this.bonusSpazioTorri = false;
	}
	
	public void incrementaBonusDadi(int familiare, int bonusDado){
		this.bonusDadi[familiare] += bonusDado;
	}
	
	public void incrementaBonusDadoCarte(int carta, int bonusDado){
		this.bonusDadoCarte[carta] += bonusDado;
	}
	
	public boolean disponibilitàMercato() {
		return this.disponibilitàMercato;
	}
	
	public boolean disponibilitàBonusSpazioTorri() {
		return this.bonusSpazioTorri;
	}
}
