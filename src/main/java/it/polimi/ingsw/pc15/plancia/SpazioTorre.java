package it.polimi.ingsw.pc15.plancia;

import it.polimi.ingsw.pc15.carte.AzionePrendiCarta;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.effetti.AggiuntaRisorse;
import it.polimi.ingsw.pc15.effetti.Effetto;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

public class SpazioTorre extends Spazio {

	private Familiare familiare;
	private Carta carta;
	private Torre torre;
	private Effetto bonusRisorse;
	

	public SpazioTorre(int valoreMin, SetRisorse setRisorse, Torre torre) {
		super(valoreMin);
		this.carta = null;
		this.familiare = null;
		this.bonusRisorse = new AggiuntaRisorse(setRisorse);
		this.torre = torre;
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
		
		if (this.familiare.getPlayer().getEffettiAttivi().disponibilitàBonusSpazioTorri())
			this.bonusRisorse.attiva(familiare.getPlayer());   
		else System.out.println("Non puoi ricevere risorse bonus dallo spazio occupato!");
			
		this.getTorre().setOccupata(true);			         
		this.setDisponibilità(false);
	}

	@Override
	public boolean occupabile (Familiare familiare) {
		
		if (!this.disponibile()) {
			System.out.println("Lo spazio è già occupato!");
			return false;		
		}
		
		if (controlloFamiliariTorre(familiare) == false) {
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
		carta.setSpazio(this);
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
	
	public boolean controlloFamiliariTorre(Familiare familiare) {
		
		if (!familiare.getColore().equals(ColoreFamiliare.NEUTRO)) {

			for (SpazioTorre spazioTorre : getTorre().getSpaziTorre())	{	
				if (spazioTorre.getFamiliare() != null)
				if ( (spazioTorre.getFamiliare().getColore().equals(ColoreFamiliare.NERO) || spazioTorre.getFamiliare().getColore().equals(ColoreFamiliare.BIANCO) || spazioTorre.getFamiliare().getColore().equals(ColoreFamiliare.ARANCIONE) ) 
						&& familiare.getPlayer().equals(spazioTorre.getFamiliare().getPlayer()) ) {
					
						System.out.println("Non puoi avere due familiari di colori diversi nella stessa torre!");
						return false;
				}
			}
		}

		return true;
		
	} 

	
}
