 package it.polimi.ingsw.pc15.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import it.polimi.ingsw.pc15.ParseXML;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.carte.Impresa;
import it.polimi.ingsw.pc15.carte.Personaggio;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.plancia.Plancia;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Leader;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class Model extends Observable implements Observer {
	
	private int numeroGiocatori;
	private ArrayList<Player> giocatori;
	private Plancia plancia;
	private int turno;
	private int periodo;
	
	private ArrayList<Territorio> carteTerritorio;
	private ArrayList<Personaggio> cartePersonaggio;
	private ArrayList<Edificio> carteEdificio;
	private ArrayList<Impresa> carteImpresa;
	
	private ArrayList<Leader> carteLeader;
	
	private boolean regoleAvanzate;
	
	
	public Model(int numeroGiocatori, boolean regoleAvanzate){

		this.numeroGiocatori = numeroGiocatori;
		this.plancia = new Plancia(numeroGiocatori);
		this.turno = 0;
		this.periodo = 1;
		this.regoleAvanzate = regoleAvanzate;
			
		Player player1 = new Player("Maffe");
		Player player2 = new Player("Mazze");
		Player player3 = new Player("Fra");
		Player player4 = new Player("AleMagni");
		
		giocatori = new ArrayList<Player>();
		giocatori.add(player1);
		giocatori.add(player2);
		giocatori.add(player3);
		giocatori.add(player4);
		
	}

	public void iniziaPartita() {
		
		//-----------------------------------------------------------------------------------------------------------//
		//          CREA CARTE SVILUPPO                                                                              //
		//-----------------------------------------------------------------------------------------------------------//
		
		carteTerritorio= (ArrayList<Territorio>) ParseXML.getCartaXML(TipoCarta.TERRITORIO);
		cartePersonaggio= (ArrayList<Personaggio>) ParseXML.getCartaXML(TipoCarta.PERSONAGGIO);
		carteEdificio= (ArrayList<Edificio>) ParseXML.getCartaXML(TipoCarta.EDIFICIO);
		carteImpresa= (ArrayList<Impresa>) ParseXML.getCartaXML(TipoCarta.IMPRESA);
		
		Collections.shuffle(carteTerritorio);
		Collections.shuffle(cartePersonaggio);
		Collections.shuffle(carteEdificio);
		Collections.shuffle(carteImpresa);
		
		//-----------------------------------------------------------------------------------------------------------//
		//          CREA CARTE LEADER                                                                                //
		//-----------------------------------------------------------------------------------------------------------//
		
		if (regoleAvanzate) {
			
			carteLeader = ParseXML.leggiCartaLeader();
			Collections.shuffle(carteLeader);	
			int numeroCarteLeader = ParseXML.leggiValore("numeroCarteLeader");
			int i=0, j=0;
			while (j<numeroGiocatori) {
				giocatori.get(j).getLeader().add(carteLeader.get(i));
				carteLeader.get(i).setPlayer(giocatori.get(j));
				i++;
				if (i==numeroCarteLeader) {
					i=0;
					j++;
				}
			}
		}
		
		iniziaNuovoTurno();
		
	}
	
	public void iniziaNuovoTurno() {
		
		turno++;
		if(turno==3) {
			periodo++;
			turno=1;
		}
		
		this.plancia.setTurno(periodo, carteTerritorio, cartePersonaggio, carteEdificio, carteImpresa);

		//-----------------------------------------------------------------------------------------------------------//
		//          LANCIA I DADI                                                                                    //
		//-----------------------------------------------------------------------------------------------------------//
		
		Random random = new Random();	
		int valoreDadoNero = random.nextInt(6) + 1;
		int valoreDadoBianco = random.nextInt(6) + 1;
		int valoreDadoArancione = random.nextInt(6) + 1;
		
		for(Player player : giocatori) {
			player.getFamiliare(ColoreFamiliare.NEUTRO).setValore(0);	
			player.getFamiliare(ColoreFamiliare.NERO).setValore(valoreDadoNero);
			player.getFamiliare(ColoreFamiliare.BIANCO).setValore(valoreDadoBianco);
			player.getFamiliare(ColoreFamiliare.ARANCIONE).setValore(valoreDadoArancione);
					
		}

	}
	
	public void rapportoInVaticano(int periodo) {
		
		int puntiFedeMinimi = ParseXML.leggiValore("puntiFedePeriodo" + Integer.toString(periodo));
		for (Player player :giocatori) {
			if (player.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIFEDE).getQuantità() < puntiFedeMinimi) {
				System.out.println(player.getNome() + " è stato scomunicato!");
				this.plancia.getTesseraScomunica(periodo).infliggiScomunica(player);
			}
		}
	}
	
	public ArrayList<Player> getPlayers() {
		return this.giocatori;
	}
	
	public Plancia getPlancia() {
		return this.plancia;
	}

	
	/*
	 *  FUNZIONE DI PROVA PER I NOTIFYOBSERVERS
	 */
	
	public void prova (String message){
		System.out.println("checkmodel");
		if(message.equals("Richiesta stato del gioco")){
			System.out.println("checkmodel1");
			setChanged();
			notifyObservers(message);
		}
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
