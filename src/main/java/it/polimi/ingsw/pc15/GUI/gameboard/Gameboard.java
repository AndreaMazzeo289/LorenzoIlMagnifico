package it.polimi.ingsw.pc15.GUI.gameboard;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

import it.polimi.ingsw.pc15.GUI.ButtonListener;
import it.polimi.ingsw.pc15.GUI.GUI;
import it.polimi.ingsw.pc15.carte.TipoCarta;

/**
 * Classe che gestisce l'intera gameboard, ossia il tabellone del gioco
 * @author AndreMazzeo289
 *
 */
public class Gameboard extends JPanel {
	
	JPanel spaziTorre = new JPanel (new GridBagLayout());
	SpazioConsiglio spazioConsiglio;
	JPanel spazioFinale = new JPanel (new GridLayout(1,2));
	
	ArrayList<SpazioTorre> spaziTorreVerde, spaziTorreGiallo, spaziTorreViola, spaziTorreBlu;
	HashMap<TipoCarta,ArrayList<SpazioTorre>> spaziTorreMap;
	ArrayList<SpazioMercato> spaziMercato; 
	
	public Gameboard(ButtonListener listener, GUI gui) {
		
		String path;
		spaziTorreVerde = new ArrayList<SpazioTorre>();
		spaziTorreGiallo = new ArrayList<SpazioTorre>();
		spaziTorreViola = new ArrayList<SpazioTorre>();
		spaziTorreBlu = new ArrayList<SpazioTorre>();
		
		spaziTorreMap = new HashMap<TipoCarta,ArrayList<SpazioTorre>>();
		
		path = "img\\Gameboard\\SpaziTorre\\Verde\\1\\";
		spaziTorreVerde.add(new SpazioTorre(listener, gui, 833, 181, 47, 517, 395, 129, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_1.png", "spazioTorreVerde4"));
		path = "img\\Gameboard\\SpaziTorre\\Verde\\2\\";
		spaziTorreVerde.add(new SpazioTorre(listener, gui, 833, 8, 47, 517, 395, 129, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_2.png", "spazioTorreVerde3"));
		path = "img\\Gameboard\\SpaziTorre\\Verde\\3\\";
		spaziTorreVerde.add(new SpazioTorre(listener, gui, 833, 8, 47, 517, 395, 129, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_3.png", "spazioTorreVerde2"));
		path = "img\\Gameboard\\SpaziTorre\\Verde\\4\\";
		spaziTorreVerde.add(new SpazioTorre(listener, gui, 833, 8, 47, 517, 395, 129, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_3.png", "spazioTorreVerde1"));
		
		path = "img\\Gameboard\\SpaziTorre\\Blu\\1\\";
		spaziTorreBlu.add(new SpazioTorre(listener, gui, 833, 181, 47, 517, 395, 38, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_61.png", "spazioTorreBlu4"));
		path = "img\\Gameboard\\SpaziTorre\\Blu\\2\\";
		spaziTorreBlu.add(new SpazioTorre(listener, gui, 833, 8, 47, 517, 395, 38, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_64.png", "spazioTorreBlu3"));
		path = "img\\Gameboard\\SpaziTorre\\Blu\\3\\";
		spaziTorreBlu.add(new SpazioTorre(listener, gui, 833, 8, 47, 517, 395, 38, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_62.png", "spazioTorreBlu2"));
		path = "img\\Gameboard\\SpaziTorre\\Blu\\4\\";
		spaziTorreBlu.add(new SpazioTorre(listener, gui, 833, 8, 47, 517, 395, 38, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_63.png", "spazioTorreBlu1"));
		
		path = "img\\Gameboard\\SpaziTorre\\Gialla\\1\\";
		spaziTorreGiallo.add(new SpazioTorre(listener, gui, 833, 181, 47, 517, 395, 38, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_25.png", "spazioTorreGialla4"));
		path = "img\\Gameboard\\SpaziTorre\\Gialla\\2\\";
		spaziTorreGiallo.add(new SpazioTorre(listener, gui, 833, 8, 47, 517, 395, 38, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_26.png", "spazioTorreGialla3"));
		path = "img\\Gameboard\\SpaziTorre\\Gialla\\3\\";
		spaziTorreGiallo.add(new SpazioTorre(listener, gui, 833, 8, 47, 517, 395, 38, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_27.png", "spazioTorreGialla2"));
		path = "img\\Gameboard\\SpaziTorre\\Gialla\\4\\";
		spaziTorreGiallo.add(new SpazioTorre(listener, gui, 833, 8, 47, 517, 395, 38, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_28.png", "spazioTorreGialla1"));
		
		path = "img\\Gameboard\\SpaziTorre\\Viola\\1\\";
		spaziTorreViola.add(new SpazioTorre(listener, gui, 833, 181, 47, 517, 571, 38, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_93.png", "spazioTorreViola4"));
		path = "img\\Gameboard\\SpaziTorre\\Viola\\2\\";
		spaziTorreViola.add(new SpazioTorre(listener, gui, 833, 8, 47, 517, 571, 38, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_94.png", "spazioTorreViola3"));
		path = "img\\Gameboard\\SpaziTorre\\Viola\\3\\";
		spaziTorreViola.add(new SpazioTorre(listener, gui, 833, 8, 47, 517, 571, 38, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_95.png", "spazioTorreViola2"));
		path = "img\\Gameboard\\SpaziTorre\\Viola\\4\\";
		spaziTorreViola.add(new SpazioTorre(listener, gui, 833, 8, 47, 517, 571, 38, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_96.png", "spazioTorreViola1"));
		
		this.spaziTorreMap.put(TipoCarta.TERRITORIO, spaziTorreVerde);
		this.spaziTorreMap.put(TipoCarta.PERSONAGGIO, spaziTorreBlu);
		this.spaziTorreMap.put(TipoCarta.EDIFICIO, spaziTorreGiallo);
		this.spaziTorreMap.put(TipoCarta.IMPRESA, spaziTorreViola);
		
		
		this.setLayout(new GridBagLayout());
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int altezzaSchermo = (int)screenSize.getHeight();
		int larghezzaSchermo = (int)screenSize.getWidth();

		GridBagConstraints gbc = new GridBagConstraints();
		
		// ADD SPAZIO FINALE
		//-----------------------//
		JPanel spaziProdRacc = new JPanel (new GridBagLayout());
		gbc.gridx = 0;
		gbc.gridy = 0;
		spaziProdRacc.add(new SpazioProduzione1(listener, gui), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		spaziProdRacc.add(new SpazioProduzione2(listener, gui), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		spaziProdRacc.add(new SpazioRaccolto1(listener, gui), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		spaziProdRacc.add(new SpazioRaccolto2(listener, gui), gbc);
		
		JPanel spaziMercatoDadi = new JPanel (new GridBagLayout());
		
		this.spaziMercato = new ArrayList<SpazioMercato>();
		this.spaziMercato.add(new SpazioMercato1(listener, gui));
		this.spaziMercato.add(new SpazioMercato2(listener, gui));
		this.spaziMercato.add(new SpazioMercato3(listener, gui));
		this.spaziMercato.add(new SpazioMercato4(listener, gui));
		
		JPanel spazioMercato = new JPanel (new GridBagLayout());
		gbc.gridx = 0;
		gbc.gridy = 0;
		spazioMercato.add(spaziMercato.get(0), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		spazioMercato.add(spaziMercato.get(1), gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		spazioMercato.add(spaziMercato.get(2), gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 0;
		spazioMercato.add(spaziMercato.get(3), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		spaziMercatoDadi.add(spazioMercato, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		spaziMercatoDadi.add(new SpazioDadi(gui), gbc);
		
		spazioFinale.add(spaziProdRacc);
		spazioFinale.add(spaziMercatoDadi);
		
		// ADD SPAZI TORRE
		//-----------------------//
		
		
		//Livello 1:
		//---------------------//
		gbc.gridx = 0;
		gbc.gridy = 0;
		spaziTorre.add(spaziTorreVerde.get(0),gbc);
		
		gbc.gridx = 1;
		spaziTorre.add(spaziTorreBlu.get(0),gbc);
		
		gbc.gridx = 2;
		spaziTorre.add(spaziTorreGiallo.get(0),gbc);
		
		gbc.gridx = 3;
		spaziTorre.add(spaziTorreViola.get(0),gbc);
		
		
		//Livello 2:
		//---------------------//
		gbc.gridx = 0;
		gbc.gridy = 1;
		spaziTorre.add(spaziTorreVerde.get(1),gbc);
		
		gbc.gridx = 1;
		spaziTorre.add(spaziTorreBlu.get(1),gbc);
		
		gbc.gridx = 2;
		spaziTorre.add(spaziTorreGiallo.get(1),gbc);
		
		gbc.gridx = 3;
		spaziTorre.add(spaziTorreViola.get(1),gbc);
		
		//Livello 3:
		//---------------------//
		gbc.gridx = 0;
		gbc.gridy = 2;
		spaziTorre.add(spaziTorreVerde.get(2),gbc);
		
		gbc.gridx = 1;
		spaziTorre.add(spaziTorreBlu.get(2),gbc);
		
		gbc.gridx = 2;
		spaziTorre.add(spaziTorreGiallo.get(2),gbc);
		
		gbc.gridx = 3;
		spaziTorre.add(spaziTorreViola.get(2),gbc);
		
		//Livello 4:
		//---------------------//
		gbc.gridx = 0;
		gbc.gridy = 3;
		spaziTorre.add(spaziTorreVerde.get(3),gbc);
		
		gbc.gridx = 1;
		spaziTorre.add(spaziTorreBlu.get(3),gbc);
		
		gbc.gridx = 2;
		spaziTorre.add(spaziTorreGiallo.get(3),gbc);
		
		gbc.gridx = 3;
		spaziTorre.add(spaziTorreViola.get(3),gbc);
		
		//-------------------------------------------------------------------//
		// ADD GAMEBOARD
		//-------------------------------------------------------------------//

		spazioConsiglio = new SpazioConsiglio(listener, gui);
		
		gbc.gridx=0;
		gbc.gridy=0;
		this.add(spaziTorre,gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;
		this.add(spazioConsiglio,gbc);
		
		gbc.gridx=0;
		gbc.gridy=2;
		this.add(spazioFinale,gbc);

		this.setVisible(true);
	}
	
	//-------------------------------------------------------------------//
	// METODI GET
	//-------------------------------------------------------------------//
	
	/**
	 * metodo di acquisizione dello spazio torre indicato tramite i parametri
	 * @param tipoCarta che indica quale torre vogliamo selezionare
	 * @param numero che indica quale spazio vogliamo selezionare
	 * @return istanza dello spazio torre desiderato
	 */
	public SpazioTorre getSpazioTorre (TipoCarta tipoCarta, int numero) {
		return this.spaziTorreMap.get(tipoCarta).get(numero);
	}
	
	// Spazio produzione
	//---------------------------//
	/**
	 * metodo di acquisizione dello spazio produzione singolo
	 * @return istanza dello spazio in questione
	 */
	public SpazioProduzione1 getSpazioProduzione1() {
		JPanel spazioProd = (JPanel) spazioFinale.getComponent(0);
		return (SpazioProduzione1) spazioProd.getComponent(0);
	}
	
	/**
	 * metodo di acquisizione dello spazio produzione multiplo
	 * @return istanza dello spazio in questione
	 */
	public SpazioProduzione2 getSpazioProduzione2() {
		JPanel spazioProd = (JPanel) spazioFinale.getComponent(0);
		return (SpazioProduzione2) spazioProd.getComponent(1);
	}
	
	// Spazio raccolto
	//---------------------------//
	/**
	 * metodo di acquisizione dello spazio raccolta singolo
	 * @return istanza dello spazio in questione
	 */
	public SpazioRaccolto1 getSpazioRaccolto1() {
		JPanel spazioProd = (JPanel) spazioFinale.getComponent(0);
		return (SpazioRaccolto1) spazioProd.getComponent(2);
	}
	
	/**
	 * metodo di acquisizione dello spazio raccolta multiplo
	 * @return istanza dello spazio in questione
	 */
	public SpazioRaccolto2 getSpazioRaccolto2() {
		JPanel spazioProd = (JPanel) spazioFinale.getComponent(0);
		return (SpazioRaccolto2) spazioProd.getComponent(3);
	}
	
	// Spazio consiglio
	//---------------------------//
	/**
	 * metodo di acquisizione dello spazio del consiglio
	 * @return istanza dello spazio in questione
	 */
	public SpazioConsiglio getSpazioConsiglio() {
		return spazioConsiglio;
	}
	
	// Spazio mercato
	//---------------------------//
	/**
	 * metodo di acquisizione dello spazio del mercato selezionato
	 * @param numero dello spazio mercato desiderato
	 * @return istanza dello spazio in questione
	 */
	public SpazioMercato getSpazioMercato(int numero) {
		return spaziMercato.get(numero);
	}
	
	// Spazio dadi
	//---------------------------//
	/**
	 * metodo di acquisizione dello spazio dei dadi
	 * @return istanza dello spazio in questione
	 */
	public SpazioDadi getSpazioDadi() {
		JPanel spazioMercatoDadi = (JPanel) spazioFinale.getComponent(1);
		return (SpazioDadi) spazioMercatoDadi.getComponent(1);
	}
}
