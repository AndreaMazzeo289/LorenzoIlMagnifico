package it.polimi.ingsw.pc15;

public class SpazioTorre extends Spazio {

	private Familiare familiare;
	private Carta carta;
	private Torre torre;
	private Effetto bonusRisorse;
	

	public SpazioTorre(int valoreMin, SetRisorse setRisorse) {
		super(valoreMin);
		this.carta = null;
		this.familiare = null;
		this.bonusRisorse = new AggiuntaRisorse(setRisorse);
	}

	@Override
	public void rimuoviFamiliari() {
		this.familiare=null;
	}

	@Override
	public boolean isEmpty() {
		if(this.familiare==null)
			return true;
		return false;
	}
	
	@Override
	public void occupa (Familiare familiare) {
		this.familiare=familiare;
		this.bonusRisorse.attiva(familiare.getPlayer());     // attiva l'effetto aggiuntaRisorse per ottenere le risorse bonus relative allo spazio torre
		this.getTorre().setOccupata(true);			         
		this.setDisponibilità(false);
	}

	@Override
	public boolean occupabile (Familiare familiare) {
		
		if (!this.disponibile()) {
			System.out.println("Lo spazio è già occupato!");
			return false;		
		}
		
		if (controlloFamiliariTorre() == false) {
			System.out.println("Non puoi posizionare altri familiari in questa torre!");
			return false;
		}
					
		if ( familiare.getValore() < getValoreMin() ) {
			System.out.println("Il valore del tuo familiare è troppo basso!");
			return false;
		}
		
		AzionePrendiCarta azionePrendiCarta = this.carta.azionePrendiCarta(familiare.getPlayer());
		
		return (azionePrendiCarta.attiva() );
		
	}
	
	public void setCarta(Carta carta) {
		this.carta = carta;
	}
	
	public void removeCarta() {
		this.carta=null;
	}
	
	public Carta getCarta() {
		return this.carta;
	}
	
	public Familiare getFamiliare() {
		return this.familiare;
	}
	
	public Torre getTorre() {
		return this.torre;
	}
	
	public boolean controlloFamiliariTorre() {
		
		/*if (this.familiare.getColore() != ColoreFamiliare.NEUTRO) {                       		//controllo che il familiare da piazzare non sia NEUTRO
			for (SpazioTorre spazioTorre : getTorre().getSpazioTorre())								//per ogni spazio della torre:
				if ((spazioTorre.getFamiliare().getColore()==ColoreFamiliare.NERO || 				//bisogna controllare che non ci siano altri familiari del
					spazioTorre.getFamiliare().getColore()==ColoreFamiliare.BIANCO || 				//player che vuole occupare lo spazio torre
				    spazioTorre.getFamiliare().getColore()==ColoreFamiliare.ARANCIONE) && 
					this.familiare.getPlayer().equals(spazioTorre.getFamiliare().getPlayer()) ) {
					
						System.out.println("Non puoi avere due familiari di colori diversi nella stessa torre!");
						return false;
				}
		}*/
		
		
		return true;
		
	} 

	
}
