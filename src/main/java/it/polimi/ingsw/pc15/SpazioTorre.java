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
		if(this.familiare.getColore != ColoreFamiliare.NEUTRO){                       //controlla se c'è un altro familiare non neutro nella stessa torre
				for (SpazioTorre spazioTorre : getTorre().getSpazioTorre())
					if ((spazioTorre.getFamiliare().getColore()==ColoreFamiliare.NERO || spazioTorre.getFamiliare().getColore()==ColoreFamiliare.BIANCO || 
					    spazioTorre.getFamiliare().getColore()==ColoreFamiliare.ARANCIONE) && this.familiare.getPlayer().equals(spazioTorre.getFamiliare().getPlayer()) )
							return false;
		}
		else{
			if(getT)
			
							
						
		
		}
		return true;
		if(familiare.getValore()+servitoriAggiuntivi >= getValoreMin())
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
