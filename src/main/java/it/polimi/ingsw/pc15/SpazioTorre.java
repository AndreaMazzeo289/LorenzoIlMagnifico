package it.polimi.ingsw.pc15;

public class SpazioTorre extends Spazio {

	private Familiare familiare;
	private Carta carta;
	private Torre torre;
	
	public SpazioTorre(int valoreMin) {
		super(valoreMin);
	}

	@Override
	public void rimuoviFamiliari() {
		familiare=null;
	}

	@Override
	public boolean isEmpty() {
		if(familiare==null)
			return true;
		return false;
	}
	
	@Override
	public void occupa(Familiare familiare) {
		this.familiare=familiare;
		//attiva effetto
	}

	@Override
	public boolean occupabile(Familiare familiare, int servitoriAggiuntivi){
		
		if (!isEmpty() ) {
			return false;		
		}
		
		if (this.familiare.getColore() != ColoreFamiliare.NEUTRO){                       				//controllo che il familiare da piazzare non sia NEUTRO
				for (SpazioTorre spazioTorre : getTorre().getSpazioTorre())								//per ogni spazio della torre:
					if ((spazioTorre.getFamiliare().getColore()==ColoreFamiliare.NERO || 				//bisogna controllare che non ci siano altri familiari del
						spazioTorre.getFamiliare().getColore()==ColoreFamiliare.BIANCO || 				//player che vuole occupare lo spazio torre
					    spazioTorre.getFamiliare().getColore()==ColoreFamiliare.ARANCIONE) && 
							this.familiare.getPlayer().equals(spazioTorre.getFamiliare().getPlayer()) ) {
							return false;
					}
		}
					
		if (familiare.getValore()+servitoriAggiuntivi < getValoreMin()) {
			return false;
		}
		
		if (!this.getCarta().acquistabile(familiare.getPlayer()) ) {
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
}
