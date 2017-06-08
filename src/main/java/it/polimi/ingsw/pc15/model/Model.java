 package it.polimi.ingsw.pc15.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Set;

import it.polimi.ingsw.pc15.ParserXML;
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
import it.polimi.ingsw.pc15.risorse.Legna;
import it.polimi.ingsw.pc15.risorse.Oro;
import it.polimi.ingsw.pc15.risorse.Pietra;
import it.polimi.ingsw.pc15.risorse.Risorsa;
import it.polimi.ingsw.pc15.risorse.Servitori;
import it.polimi.ingsw.pc15.risorse.SetRisorse;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class Model extends Observable implements Observer {
	
	private int numeroGiocatori;
	private ArrayList<Player> giocatori;
	private Plancia plancia;
	private int turno;
	private int periodo;
	
	private ArrayList<Carta> carteTerritorio;
	private ArrayList<Carta> cartePersonaggio;
	private ArrayList<Carta> carteEdificio;
	private ArrayList<Carta> carteImpresa;
	private ArrayList<Leader> carteLeader;
	
	private boolean regoleAvanzate;
	
	
	public Model(ArrayList<String> nomiGiocatori, boolean regoleAvanzate){

		this.numeroGiocatori = nomiGiocatori.size();
		this.plancia = new Plancia(numeroGiocatori);
		this.turno = 0;
		this.periodo = 1;
		this.regoleAvanzate = regoleAvanzate;
		giocatori = new ArrayList<Player>();
		for (int i=0; i<numeroGiocatori; i++)
			giocatori.add(new Player(nomiGiocatori.get(i)));
		Collections.shuffle(giocatori);

	}

	public void iniziaPartita() {
		
		generaCarteSviluppo();
		if (regoleAvanzate)
			distribuisciCarteLeader();
		
		distribuisciRisorse();
		
		Random random = new Random();
		giocatori.get(random.nextInt(numeroGiocatori)).setOrdine(true);
		
			
		iniziaNuovoTurno();
		
	}
	
	public void distribuisciRisorse() {
		
		HashSet<Risorsa> risorseGiocatore = new HashSet<Risorsa>();
		risorseGiocatore.add(new Oro(5));
		risorseGiocatore.add(new Legna(2));
		risorseGiocatore.add(new Pietra(2));
		risorseGiocatore.add(new Servitori(3));
		SetRisorse setRisorseGiocatore = new SetRisorse(risorseGiocatore);
		
		for(int i=0; i<numeroGiocatori; i++) {
			setRisorseGiocatore.getRisorsa(TipoRisorsa.ORO).aggiungi(i);
			giocatori.get(i).getSetRisorse().aggiungi(setRisorseGiocatore);
		}
		
	}
	
	public void distribuisciCarteLeader() {
		
		carteLeader = ParserXML.leggiCartaLeader();
		Collections.shuffle(carteLeader);	
		int numeroCarteLeader = ParserXML.leggiValore("numeroCarteLeader");
		int i=0, j=0;
		while (j<numeroGiocatori) {
			giocatori.get(j).getCarteLeader().add(carteLeader.get(i));
			carteLeader.get(i).setPlayer(giocatori.get(j));
			i++;
			if (i==numeroCarteLeader) {
				i=0;
				j++;
			}
		}
	}	
	
	public void generaCarteSviluppo() {

		carteTerritorio= ParserXML.getCarteXML(TipoCarta.TERRITORIO);
		cartePersonaggio= ParserXML.getCarteXML(TipoCarta.PERSONAGGIO);
		carteEdificio= ParserXML.getCarteXML(TipoCarta.EDIFICIO);
		carteImpresa= ParserXML.getCarteXML(TipoCarta.IMPRESA);
		
		Collections.shuffle(carteTerritorio);
		Collections.shuffle(cartePersonaggio);
		Collections.shuffle(carteEdificio);
		Collections.shuffle(carteImpresa);
		
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
		
		int puntiFedeMinimi = ParserXML.leggiValore("puntiFedePeriodo" + Integer.toString(periodo));
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


	@Override
	public void update(Observable o, Object arg) {
		
	}
	
	public String getProssimoGiocatore(){
		for(int i = 0; i < this.numeroGiocatori; i++){
			if(giocatori.get(i).getOrdine()==true){
				return giocatori.get(i).getNome();
			}
			
		}
		
		return null;
	}
	
	
	public void setOrdineGiocatori(){}
	
	
	public int getTurno(){
		return turno;
	}
	
	public Player getPlayer(String nome) {
		
		for (Player player : this.giocatori) {
			if (player.getNome().equals(nome))
				return player;
		}
		
		return null;

	}
	
}
