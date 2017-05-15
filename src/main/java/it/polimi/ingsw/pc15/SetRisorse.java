package it.polimi.ingsw.pc15;

public class SetRisorse {
	
	private Oro oro;
	private Legna legna;
	private Pietra pietra;
	private Servitori servitori;
	private PuntiVittoria puntiVittoria;
	private PuntiMilitari puntiMilitari;
	private PuntiFede puntiFede;
	private Privilegi privilegi;
	
	
	public SetRisorse (int numOro, int numLegna, int numPietra, int numServitori, int numPuntiVittoria, int numPuntiMilitari, int numPuntiFede, int numPrivilegi) {
		
		Oro oro = new Oro(numOro);
		Legna legna = new Legna(numLegna);
		Pietra pietra = new Pietra(numPietra);
		Servitori servitori = new Servitori(numServitori);
		PuntiVittoria puntiVittoria = new PuntiVittoria(numPuntiVittoria);
		PuntiMilitari puntiMilitari = new PuntiMilitari(numPuntiMilitari);
		PuntiFede puntiFede = new PuntiFede(numPuntiFede);
		Privilegi privilegi = new Privilegi(numPrivilegi);
		
		this.oro = oro;
		this.legna = legna;
		this.pietra = pietra;
		this.servitori = servitori;
		this.puntiVittoria = puntiVittoria;
		this.puntiMilitari = puntiMilitari;
		this.puntiFede = puntiFede;
		this.privilegi = privilegi;
		
	}
	
	
	public void aggiungi (SetRisorse setRisorse) {  //aggiunge al setRisorse corrente le risorse del setRisorse passato come parametro
		
		this.oro.aggiungi(setRisorse.getOro().getQuantità());
		this.legna.aggiungi(setRisorse.getLegna().getQuantità());
		this.pietra.aggiungi(setRisorse.getPietra().getQuantità());
		this.servitori.aggiungi(setRisorse.getServitori().getQuantità());
		this.puntiVittoria.aggiungi(setRisorse.getPuntiVittoria().getQuantità());
		this.puntiMilitari.aggiungi(setRisorse.getPuntiMilitari().getQuantità());
		this.puntiFede.aggiungi(setRisorse.getPuntiFede().getQuantità());
		this.privilegi.aggiungi(setRisorse.getPrivilegi().getQuantità());
		
	}

	public boolean paragona (SetRisorse setRisorse) { //ritorna TRUE solo se il valore di ogni risorsa in questo setRisorse è >= di quello delle corrispondenti risorse del secondo setRisorse
		
		if (    this.oro.paragona(setRisorse.getOro().getQuantità()) && this.legna.paragona(setRisorse.getLegna().getQuantità()) && this.pietra.paragona(setRisorse.getPietra().getQuantità()) 
				&& this.servitori.paragona(setRisorse.getServitori().getQuantità()) && this.puntiVittoria.paragona(setRisorse.getPuntiVittoria().getQuantità()) && this.puntiMilitari.paragona(setRisorse.getPuntiMilitari().getQuantità())
				&& this.puntiFede.paragona(setRisorse.getPuntiFede().getQuantità()) && this.privilegi.paragona(setRisorse.getPrivilegi().getQuantità())  ) 
			
			return true;
		
		return false;
	}
	
	public Oro getOro() {
		return this.oro;
	}
	
	public Legna getLegna() {
		return this.legna;
	}
	
	public Pietra getPietra() {
		return this.pietra;
	}
	
	public Servitori getServitori() {
		return this.servitori;
	}
	
	public PuntiVittoria getPuntiVittoria() {
		return this.puntiVittoria;
	}
	
	public PuntiMilitari getPuntiMilitari() {
		return this.puntiMilitari;
	}
	
	public PuntiFede getPuntiFede() {
		return this.puntiFede;
	}
	
	public Privilegi getPrivilegi() {
		return this.privilegi;
	}

}
