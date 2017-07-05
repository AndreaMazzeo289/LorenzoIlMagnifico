package it.polimi.ingsw.pc15.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

import javax.swing.JFrame;

import it.polimi.ingsw.pc15.GUI.gameboard.Gameboard;
import it.polimi.ingsw.pc15.GUI.playerboard.CarteGioco;
import it.polimi.ingsw.pc15.GUI.playerboard.PlayerBoard;
import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.client.ClientModel;
import it.polimi.ingsw.pc15.client.ClientView;
import it.polimi.ingsw.pc15.client.NetworkHandler;
import it.polimi.ingsw.pc15.plancia.SpazioMercato;
import it.polimi.ingsw.pc15.plancia.SpazioTorre;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.ColorePlayer;
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
	private ArrayList<String> message = new ArrayList<String>();
	private boolean loadDone;
	
	private HashMap<TipoCarta,String> retroCarte;
	private HashMap<ColoreFamiliare,String> mappaFamiliareGiocatoreVerde;
	private HashMap<ColoreFamiliare,String> mappaFamiliareGiocatoreBlu;
	private HashMap<ColoreFamiliare,String> mappaFamiliareGiocatoreRosso;
	private HashMap<ColoreFamiliare,String> mappaFamiliareGiocatoreGiallo;
	
	private HashMap<ColorePlayer, HashMap<ColoreFamiliare,String>> mappaGiocatori;
	
	public GUI(NetworkHandler networkHandler, ClientModel clientModel) {
		super(networkHandler, clientModel);
		
		loadDone=false;
		listener = new ButtonListener(this);
		
		this.retroCarte = new HashMap<TipoCarta,String>();
		this.retroCarte.put(TipoCarta.TERRITORIO, "img/DevCardsBack/devcards_b_c_g_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg");
		this.retroCarte.put(TipoCarta.PERSONAGGIO, "img/DevCardsBack/devcards_b_c_b_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg");
		this.retroCarte.put(TipoCarta.IMPRESA, "img/DevCardsBack/devcards_b_c_p_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg");
		this.retroCarte.put(TipoCarta.EDIFICIO, "img/DevCardsBack/devcards_b_c_y_1.jdevcards_b_c_pdevcards_b_c_g.jdevcards_b_c_pg.jpg");
		
		this.mappaFamiliareGiocatoreVerde = new HashMap<ColoreFamiliare,String>();
		this.mappaFamiliareGiocatoreVerde.put(ColoreFamiliare.NERO, "img/Punchboard/familiari/pedineFamiliari/verde/nero.png");
		this.mappaFamiliareGiocatoreVerde.put(ColoreFamiliare.BIANCO, "img/Punchboard/familiari/pedineFamiliari/verde/bianco.png");
		this.mappaFamiliareGiocatoreVerde.put(ColoreFamiliare.ARANCIONE, "img/Punchboard/familiari/pedineFamiliari/verde/arancione.png");
		this.mappaFamiliareGiocatoreVerde.put(ColoreFamiliare.NEUTRO, "img/Punchboard/familiari/pedineFamiliari/verde/neutro.png");
		
		this.mappaFamiliareGiocatoreBlu = new HashMap<ColoreFamiliare,String>();
		this.mappaFamiliareGiocatoreBlu.put(ColoreFamiliare.NERO, "img/Punchboard/familiari/pedineFamiliari/blu/nero.png");
		this.mappaFamiliareGiocatoreBlu.put(ColoreFamiliare.BIANCO, "img/Punchboard/familiari/pedineFamiliari/blu/bianco.png");
		this.mappaFamiliareGiocatoreBlu.put(ColoreFamiliare.ARANCIONE, "img/Punchboard/familiari/pedineFamiliari/blu/arancione.png");
		this.mappaFamiliareGiocatoreBlu.put(ColoreFamiliare.NEUTRO, "img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		
		this.mappaFamiliareGiocatoreGiallo = new HashMap<ColoreFamiliare,String>();
		this.mappaFamiliareGiocatoreGiallo.put(ColoreFamiliare.NERO, "img/Punchboard/familiari/pedineFamiliari/giallo/nero.png");
		this.mappaFamiliareGiocatoreGiallo.put(ColoreFamiliare.BIANCO, "img/Punchboard/familiari/pedineFamiliari/giallo/bianco.png");
		this.mappaFamiliareGiocatoreGiallo.put(ColoreFamiliare.ARANCIONE, "img/Punchboard/familiari/pedineFamiliari/giallo/arancione.png");
		this.mappaFamiliareGiocatoreGiallo.put(ColoreFamiliare.NEUTRO, "img/Punchboard/familiari/pedineFamiliari/giallo/neutro.png");
		
		this.mappaFamiliareGiocatoreRosso = new HashMap<ColoreFamiliare,String>();
		this.mappaFamiliareGiocatoreRosso.put(ColoreFamiliare.NERO, "img/Punchboard/familiari/pedineFamiliari/rosso/nero.png");
		this.mappaFamiliareGiocatoreRosso.put(ColoreFamiliare.BIANCO, "img/Punchboard/familiari/pedineFamiliari/rosso/bianco.png");
		this.mappaFamiliareGiocatoreRosso.put(ColoreFamiliare.ARANCIONE, "img/Punchboard/familiari/pedineFamiliari/rosso/arancione.png");
		this.mappaFamiliareGiocatoreRosso.put(ColoreFamiliare.NEUTRO, "img/Punchboard/familiari/pedineFamiliari/rosso/neutro.png");
		
		this.mappaGiocatori = new HashMap<ColorePlayer, HashMap<ColoreFamiliare,String>>();
		this.mappaGiocatori.put(ColorePlayer.VERDE, mappaFamiliareGiocatoreVerde);
		this.mappaGiocatori.put(ColorePlayer.BLU, mappaFamiliareGiocatoreBlu);
		this.mappaGiocatori.put(ColorePlayer.GIALLO, mappaFamiliareGiocatoreGiallo);
		this.mappaGiocatori.put(ColorePlayer.ROSSO, mappaFamiliareGiocatoreGiallo);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
		if(!loadDone) {
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		loadDone=true;
		}
		
		arrayListAvversari = this.clientModel.getStatoAvversari();
		playerCorrente = this.clientModel.getStatoGiocatore();
		
		
		
		//----------------------------------------------------------//
		// AGGIORNAMENTO GAMEBOARD IN FUNZIONE DEL MODEL
		//----------------------------------------------------------//
		
		playerCorrente = this.clientModel.getStatoGiocatore();
		arrayListAvversari = this.clientModel.getStatoAvversari();
		pathCartaScomunica1 = this.clientModel.getStatoPlancia().getTesseraScomunica(1).getPathImg();
		pathCartaScomunica2 = this.clientModel.getStatoPlancia().getTesseraScomunica(2).getPathImg();
		pathCartaScomunica3 = this.clientModel.getStatoPlancia().getTesseraScomunica(3).getPathImg();
		
		//------------------------------------//
		// CARTE TORRI
		//------------------------------------//
		String immagineCartaModel;
		for(TipoCarta tipo : TipoCarta.values()) {
			if(tipo.equals(TipoCarta.ALL));
			else
				for(int i=0; i<4; i++) {
					int spazio = Math.abs(i-3);
					try {
						gameboard.getSpazioTorre(tipo, i).modificaImmagineCarta(this.clientModel.getStatoPlancia().getSpazioTorre(tipo, spazio).getCarta().getImagePath());
					}catch(NullPointerException e) {
						System.out.println("errore in " + tipo.name());
						gameboard.getSpazioTorre(tipo, i).modificaImmagineCarta(retroCarte.get(tipo));
					}
				}
		}
			
		//------------------------------------//
		// DADI
		//------------------------------------//
		int valoreDadoNero = this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.NERO).getValore();
		int valoreDadoBianco = this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.BIANCO).getValore();
		int valoreDadoArancione = this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.ARANCIONE).getValore();
			    
		gameboard.getSpazioDadi().modificaImmagineDadi(ColoreFamiliare.NERO, valoreDadoNero);
		gameboard.getSpazioDadi().modificaImmagineDadi(ColoreFamiliare.BIANCO, valoreDadoBianco);
		gameboard.getSpazioDadi().modificaImmagineDadi(ColoreFamiliare.ARANCIONE, valoreDadoArancione);
		
		//------------------------------------//
		// FAMILIARI SPAZI
		//------------------------------------//
		for(SpazioMercato spazio : this.clientModel.getStatoPlancia().getSpaziMercato())
			if(!spazio.vuoto())
				gameboard.getSpazioMercato(this.clientModel.getStatoPlancia().getSpaziMercato().lastIndexOf(spazio)).inserisciFamiliare(this.mappaGiocatori.get(spazio.getFamiliari().get(0).getPlayer().getColore()).get(spazio.getFamiliari().get(0).getColore()));
		
		for(TipoCarta tipo : TipoCarta.values())
			if(tipo.equals(TipoCarta.ALL));
			else
				for(SpazioTorre spazio : this.clientModel.getStatoPlancia().getTorre(tipo).getSpaziTorre())
					if(!spazio.vuoto()){
						int index = Math.abs(this.clientModel.getStatoPlancia().getTorre(tipo).getSpaziTorre().lastIndexOf(spazio)-3);
						gameboard.getSpazioTorre(tipo, index).inserisciFamiliare(this.mappaGiocatori.get(spazio.getFamiliari().get(0).getPlayer().getColore()).get(spazio.getFamiliari().get(0).getColore()));
					}
		
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
		int quantitaRisorsa;
		
		quantitaRisorsa = this.clientModel.getStatoGiocatore().getSetRisorse().getRisorsa(TipoRisorsa.ORO).getQuantità();
		System.out.println(quantitaRisorsa);
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
		
		
		playerboard.scriviMessaggio((String)arg1);
		if(tuoTurno()) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			playerboard.scriviMessaggio("È il tuo turno!");
		}
	}

	@Override
	public void run() {
		
		System.out.println("RUN");
		
		mainFrame = new JFrame();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();
		mainFrame.setSize(width, height);
		mainFrame.getContentPane().setBackground(Color.decode("15394527"));
	   
		mainFrame.getContentPane().setLayout(new GridBagLayout());
		gameboard = new Gameboard(listener,this);
		playerboard = new PlayerBoard(listener,this);
		
    	GridBagConstraints gbc = new GridBagConstraints();
	    gbc.gridy=0;
	    gbc.gridx=0;
	    mainFrame.getContentPane().add(gameboard, gbc);
	    gbc.gridx=1;
	    mainFrame.getContentPane().add(playerboard, gbc);
	    
	    mainFrame.setVisible(true);
	    mainFrame.setAlwaysOnTop(true);
	}

	public ArrayList<Player> getarrayListAvversari() {
		return this.arrayListAvversari;
	}
	public String getPathCartaScomunica1() {
		return this.pathCartaScomunica1;
	}
	public String getPathCartaScomunica2() {
		return this.pathCartaScomunica2;
	}
	public String getPathCartaScomunica3() {
		return this.pathCartaScomunica3;
	}
	public int getNumeroGiocatori() {
		return this.numeroGiocatori;
	}
	public Player getPlayerCorrente() {
		return this.playerCorrente;
	}
	public void writeMessage(String text) {
		this.message.add(text);
	}
	public ArrayList<String> getMessage() {
		return this.message;
	}
	public void inviaMessaggio() {
		this.setChanged();
		this.notifyObservers(this.message);
	}
	public void clearMessage() {
		this.message.clear();
	}
}
