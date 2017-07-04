package it.polimi.ingsw.pc15.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JFrame;

import it.polimi.ingsw.pc15.GUI.gameboard.Gameboard;
import it.polimi.ingsw.pc15.GUI.playerboard.PlayerBoard;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.client.ClientModel;
import it.polimi.ingsw.pc15.client.ClientView;
import it.polimi.ingsw.pc15.client.NetworkHandler;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Leader;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class GUI extends ClientView{

	public JFrame mainFrame;
	public int altezzaTotale = 6650; //6530
	public int larghezzaTotale = 4076;
	public float rapporto = (float) 4/11;
	public float rapportoPlayerBoard = (float)19/31;//13/21
	ButtonListener listener;
	
	private PlayerBoard playerboard;
	private Gameboard gameboard;
	
	private String pathCartaScomunica1;
	private String pathCartaScomunica2;
	private String pathCartaScomunica3;
	private int numeroGiocatori = 2;
	private Player playerCorrente;
	private ArrayList<Player> arrayListAvversari;
	private boolean turnoGiocatore;
	
	private ArrayList<String> message = new ArrayList<String>();;
	
	public GUI(NetworkHandler networkHandler, ClientModel clientModel) {
		super(networkHandler, clientModel);
		
		listener = new ButtonListener(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {

		arrayListAvversari = this.clientModel.getStatoAvversari();
		playerCorrente = this.clientModel.getStatoGiocatore();
		if(playerCorrente.getNome().equals(this.clientModel.getGiocatoreCorrente()))
			turnoGiocatore = true;
		else
			turnoGiocatore = false;
		
		//----------------------------------------------------------//
		// AGGIORNAMENTO PLAYERBOARD IN FUNZIONE DEL MODEL
		//----------------------------------------------------------//
		// Carte player
		//---------------------------//
		ArrayList<Carta> listaCarteTerritorio = this.clientModel.getStatoGiocatore().getCarte(TipoCarta.TERRITORIO);
		int i=0;
		for(Carta carta : listaCarteTerritorio) {
			playerboard.getCartaGioco(TipoCarta.TERRITORIO, i).modificaImmagineCarta(carta.getImagePath());
			i++;
		}
		ArrayList<Carta> listaCartePersonaggio = this.clientModel.getStatoGiocatore().getCarte(TipoCarta.PERSONAGGIO);
		i=0;
		for(Carta carta : listaCartePersonaggio) {
			playerboard.getCartaGioco(TipoCarta.PERSONAGGIO, i).modificaImmagineCarta(carta.getImagePath());
			i++;
		}
		ArrayList<Carta> listaCarteEdificio = this.clientModel.getStatoGiocatore().getCarte(TipoCarta.EDIFICIO);
		i=0;
		for(Carta carta : listaCarteEdificio) {
			playerboard.getCartaGioco(TipoCarta.EDIFICIO, i).modificaImmagineCarta(carta.getImagePath());
			i++;
		}
		ArrayList<Carta> listaCarteImpresa = this.clientModel.getStatoGiocatore().getCarte(TipoCarta.IMPRESA);
		i=0;
		for(Carta carta : listaCarteImpresa) {
			playerboard.getCartaGioco(TipoCarta.IMPRESA, i).modificaImmagineCarta(carta.getImagePath());
			i++;
		}
		// Panel risorse
		//---------------------------//
		playerboard.getPanelRisorseOro().writeIntoLabel(this.clientModel.getStatoGiocatore().getSetRisorse().getRisorsa(TipoRisorsa.LEGNA).getQuantità());
		
	}

	@Override
	public void run() {
		
		mainFrame = new JFrame();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();
		mainFrame.setSize(width, height);
		mainFrame.getContentPane().setBackground(Color.decode("15394527"));
	   
		mainFrame.getContentPane().setLayout(new GridBagLayout());
		gameboard = new Gameboard(listener,this);
		playerboard = new PlayerBoard(listener,this);
	   
		//----------------------------------------------------------//
		// AGGIORNAMENTO GAMEBOARD IN FUNZIONE DEL MODEL
		//----------------------------------------------------------//
		
		playerCorrente = this.clientModel.getStatoGiocatore();
		arrayListAvversari = this.clientModel.getStatoAvversari();
		pathCartaScomunica1 = this.clientModel.getStatoPlancia().getTesseraScomunica(1).getPathImg();
		pathCartaScomunica2 = this.clientModel.getStatoPlancia().getTesseraScomunica(2).getPathImg();
		pathCartaScomunica3 = this.clientModel.getStatoPlancia().getTesseraScomunica(3).getPathImg();
		if(playerCorrente.getNome().equals(this.clientModel.getGiocatoreCorrente()))
			turnoGiocatore = true;
		else
			turnoGiocatore = false;
		
		//------------------------------------//
		// CARTE TORRI
		//------------------------------------//
		String immagineCartaModel;
		
		immagineCartaModel = this.clientModel.getStatoPlancia().getSpazioTorre(TipoCarta.TERRITORIO, 0).getCarta().getImagePath();
		gameboard.getSpazioTorreVerde1().modificaImmagineCarta(immagineCartaModel);
		immagineCartaModel = this.clientModel.getStatoPlancia().getSpazioTorre(TipoCarta.TERRITORIO, 1).getCarta().getImagePath();
		gameboard.getSpazioTorreVerde2().modificaImmagineCarta(immagineCartaModel);
		immagineCartaModel = this.clientModel.getStatoPlancia().getSpazioTorre(TipoCarta.TERRITORIO, 2).getCarta().getImagePath();
		gameboard.getSpazioTorreVerde3().modificaImmagineCarta(immagineCartaModel);
		immagineCartaModel = this.clientModel.getStatoPlancia().getSpazioTorre(TipoCarta.TERRITORIO, 3).getCarta().getImagePath();
		gameboard.getSpazioTorreVerde4().modificaImmagineCarta(immagineCartaModel);
		
		immagineCartaModel = this.clientModel.getStatoPlancia().getSpazioTorre(TipoCarta.PERSONAGGIO, 0).getCarta().getImagePath();
		gameboard.getSpazioTorreBlu1().modificaImmagineCarta(immagineCartaModel);
		immagineCartaModel = this.clientModel.getStatoPlancia().getSpazioTorre(TipoCarta.PERSONAGGIO, 1).getCarta().getImagePath();
		gameboard.getSpazioTorreBlu2().modificaImmagineCarta(immagineCartaModel);
		immagineCartaModel = this.clientModel.getStatoPlancia().getSpazioTorre(TipoCarta.PERSONAGGIO, 2).getCarta().getImagePath();
		gameboard.getSpazioTorreBlu3().modificaImmagineCarta(immagineCartaModel);
		immagineCartaModel = this.clientModel.getStatoPlancia().getSpazioTorre(TipoCarta.PERSONAGGIO, 3).getCarta().getImagePath();
		gameboard.getSpazioTorreBlu4().modificaImmagineCarta(immagineCartaModel);
		
		immagineCartaModel = this.clientModel.getStatoPlancia().getSpazioTorre(TipoCarta.EDIFICIO, 0).getCarta().getImagePath();
		gameboard.getSpazioTorreGialla1().modificaImmagineCarta(immagineCartaModel);
		immagineCartaModel = this.clientModel.getStatoPlancia().getSpazioTorre(TipoCarta.EDIFICIO, 1).getCarta().getImagePath();
		gameboard.getSpazioTorreGialla2().modificaImmagineCarta(immagineCartaModel);
		immagineCartaModel = this.clientModel.getStatoPlancia().getSpazioTorre(TipoCarta.EDIFICIO, 2).getCarta().getImagePath();
		gameboard.getSpazioTorreGialla3().modificaImmagineCarta(immagineCartaModel);
		immagineCartaModel = this.clientModel.getStatoPlancia().getSpazioTorre(TipoCarta.EDIFICIO, 3).getCarta().getImagePath();
		gameboard.getSpazioTorreGialla4().modificaImmagineCarta(immagineCartaModel);
		
		immagineCartaModel = this.clientModel.getStatoPlancia().getSpazioTorre(TipoCarta.IMPRESA, 0).getCarta().getImagePath();
		gameboard.getSpazioTorreViola1().modificaImmagineCarta(immagineCartaModel);
		immagineCartaModel = this.clientModel.getStatoPlancia().getSpazioTorre(TipoCarta.IMPRESA, 1).getCarta().getImagePath();
		gameboard.getSpazioTorreViola2().modificaImmagineCarta(immagineCartaModel);
		immagineCartaModel = this.clientModel.getStatoPlancia().getSpazioTorre(TipoCarta.IMPRESA, 2).getCarta().getImagePath();
		gameboard.getSpazioTorreViola3().modificaImmagineCarta(immagineCartaModel);
		immagineCartaModel = this.clientModel.getStatoPlancia().getSpazioTorre(TipoCarta.IMPRESA, 3).getCarta().getImagePath();
		gameboard.getSpazioTorreViola4().modificaImmagineCarta(immagineCartaModel);
		
		//------------------------------------//
		// DADI
		//------------------------------------//
		int valoreDadoNero = this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.NERO).getValore();
		int valoreDadoBianco = this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.BIANCO).getValore();
		int valoreDadoArancione = this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.ARANCIONE).getValore();
	    
		gameboard.getSpazioDadi().modificaImmagineDadi(ColoreFamiliare.NERO, valoreDadoNero);
		gameboard.getSpazioDadi().modificaImmagineDadi(ColoreFamiliare.BIANCO, valoreDadoBianco);
		gameboard.getSpazioDadi().modificaImmagineDadi(ColoreFamiliare.ARANCIONE, valoreDadoArancione);
		
		//----------------------------------------------------------//
		// AGGIORNAMENTO PLAYERBOARD IN FUNZIONE DEL MODEL
		//----------------------------------------------------------//
		
		//------------------------------------//
		// LEADER
		//------------------------------------//
		immagineCartaModel = this.clientModel.getStatoGiocatore().getCarteLeader().get(0).getPathImg(); 
		playerboard.getCartaLeader1().modificaImmagineCarta(immagineCartaModel);
		immagineCartaModel = this.clientModel.getStatoGiocatore().getCarteLeader().get(1).getPathImg(); 
		playerboard.getCartaLeader2().modificaImmagineCarta(immagineCartaModel);
		immagineCartaModel = this.clientModel.getStatoGiocatore().getCarteLeader().get(2).getPathImg(); 
		playerboard.getCartaLeader3().modificaImmagineCarta(immagineCartaModel);
		immagineCartaModel = this.clientModel.getStatoGiocatore().getCarteLeader().get(3).getPathImg(); 
		playerboard.getCartaLeader4().modificaImmagineCarta(immagineCartaModel);
		
		//------------------------------------//
		// SET RISORSE
		//------------------------------------//
		int quantitaRisorsa;
		
		quantitaRisorsa = this.clientModel.getStatoGiocatore().getSetRisorse().getRisorsa(TipoRisorsa.ORO).getQuantità();
		playerboard.getPanelRisorseOro().writeIntoLabel(quantitaRisorsa);
		quantitaRisorsa = this.clientModel.getStatoGiocatore().getSetRisorse().getRisorsa(TipoRisorsa.LEGNA).getQuantità();
		playerboard.getPanelRisorseLegna().writeIntoLabel(quantitaRisorsa);
		quantitaRisorsa = this.clientModel.getStatoGiocatore().getSetRisorse().getRisorsa(TipoRisorsa.PIETRA).getQuantità();
		playerboard.getPanelRisorsePietra().writeIntoLabel(quantitaRisorsa);
		quantitaRisorsa = this.clientModel.getStatoGiocatore().getSetRisorse().getRisorsa(TipoRisorsa.SERVITORI).getQuantità();
		playerboard.getPanelRisorseServitori().writeIntoLabel(quantitaRisorsa);
		quantitaRisorsa = this.clientModel.getStatoGiocatore().getSetRisorse().getRisorsa(TipoRisorsa.PUNTIMILITARI).getQuantità();
		playerboard.getPanelRisorsePuntiMilitari().writeIntoLabel(quantitaRisorsa);
		quantitaRisorsa = this.clientModel.getStatoGiocatore().getSetRisorse().getRisorsa(TipoRisorsa.PUNTIFEDE).getQuantità();
		playerboard.getPanelRisorsePuntiFede().writeIntoLabel(quantitaRisorsa);
		quantitaRisorsa = this.clientModel.getStatoGiocatore().getSetRisorse().getRisorsa(TipoRisorsa.PUNTIVITTORIA).getQuantità();
		playerboard.getPanelRisorsePuntiVittoria().writeIntoLabel(quantitaRisorsa);
		
    	GridBagConstraints gbc = new GridBagConstraints();
	    gbc.gridy=0;
	    gbc.gridx=0;
	    mainFrame.getContentPane().add(gameboard, gbc);
	    gbc.gridx=1;
	    mainFrame.getContentPane().add(playerboard, gbc);
	    
	    mainFrame.setVisible(true);
	    mainFrame.setAlwaysOnTop(true);
		
	    notifyObservers(message);
	}

	public ArrayList<Player> getarrayListAvversari() {
		return arrayListAvversari;
	}
	public String getPathCartaScomunica1() {
		return pathCartaScomunica1;
	}
	public String getPathCartaScomunica2() {
		return pathCartaScomunica2;
	}
	public String getPathCartaScomunica3() {
		return pathCartaScomunica3;
	}
	public int getNumeroGiocatori() {
		return numeroGiocatori;
	}
	public Player getPlayerCorrente() {
		return playerCorrente;
	}
	public boolean getTurnoGiocatore() {
		return turnoGiocatore;
	}
	public void writeMessage(String text) {
		message.add(text);
	}
	public ArrayList<String> getMessage() {
		return this.message;
	}
	public void inviaMessaggio() {
		this.setChanged();
		this.notifyObservers(this.message);
	}
}
