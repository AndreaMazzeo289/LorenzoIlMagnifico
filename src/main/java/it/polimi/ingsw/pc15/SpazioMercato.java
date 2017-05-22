package it.polimi.ingsw.pc15;

import java.util.Queue;

public class SpazioMercato extends Spazio {

	private Familiare familiare;
	private Effetto effetto;
	
	public SpazioMercato(int valoreMin, SetRisorse setRisorse) {
		super(valoreMin);
		this.familiare= null;
		this.effetto = new AggiuntaRisorse (setRisorse);
	}
	
	@Override
	public void occupa (Familiare familiare){
		this.familiare = familiare;
		this.setDisponibilità(false);
		this.effetto.attiva(this.familiare.getPlayer());
	}
	
	@Override
	public boolean occupabile (Familiare familiare) {
		
		if (familiare.getPlayer().getEffettiAttivi().disponibilitàMercato() == false) {
			System.out.println("Non ti è permesso posizionare un familiare negli spazi del mercato!");
			return false;
		}

		
		if(familiare.getValore() < getValoreMin() )  {
			System.out.println("Il valore del tuo familiare è troppo basso!");
			return false;
		}
		
		if (!this.disponibile() ) {
			System.out.println("Lo spazio è già occupato!");
			return false;
		}
		
		return true;
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
	
}
