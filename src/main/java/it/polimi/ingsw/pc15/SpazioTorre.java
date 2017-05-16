package it.polimi.ingsw.pc15;

public class SpazioTorre extends Spazio {

	private SetRisorse risorseBonus;
	private Familiare familiare;
	private Carta carta;
	private Torre torre;
	private Effetto effetto;
	
	public SpazioTorre(int valoreMin, int numOro, int numLegna, int numPietra, int numServitori, int numPuntiVittoria, int numPuntiMilitari, int numPuntiFede, int numPrivilegi) {
		super(valoreMin);
		this.effetto = new AggiuntaRisorse(numOro, numLegna, numPietra, numServitori, numPuntiVittoria, numPuntiMilitari, numPuntiFede, numPrivilegi);
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
		this.effetto.attiva(familiare.getPlayer()); // attivazione dell'effetto aggiuntaRisorse per ottenere le risorse bonus relative allo spazio torre
		this.getTorre().setOccupata(true);			    // Settaggio flag di occupazione della torre
		carta.daiA(familiare.getPlayer());
		//attiva effetti carta
	}

	@Override
	public boolean occupabile (Familiare familiare) {
		
		if (isEmpty() == false) {
			//messaggio
			return false;		
		}
		
		if (controlloFamiliariTorre() == false) {
			//messaggio		}
			return false;
		}
					
		if ( familiare.getValore() < getValoreMin() ) {
			//messaggio
			return false;
		}
		
		if (carta.prendibile(familiare.getPlayer()) == false) {
			//messaggio
			return false;
		}
		
		return true;
		
	}
	
	public void setCarta() {
		//XML
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
		
		if (this.familiare.getColore() != ColoreFamiliare.NEUTRO) {                       			//controllo che il familiare da piazzare non sia NEUTRO
			for (SpazioTorre spazioTorre : getTorre().getSpazioTorre())								//per ogni spazio della torre:
				if ((spazioTorre.getFamiliare().getColore()==ColoreFamiliare.NERO || 				//bisogna controllare che non ci siano altri familiari del
					spazioTorre.getFamiliare().getColore()==ColoreFamiliare.BIANCO || 				//player che vuole occupare lo spazio torre
				    spazioTorre.getFamiliare().getColore()==ColoreFamiliare.ARANCIONE) && 
					this.familiare.getPlayer().equals(spazioTorre.getFamiliare().getPlayer()) ) {
						
					    //messaggio
						return false;
				}
		}
		
		
		return true;
		
	}

	
}
