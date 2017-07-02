package it.polimi.ingsw.pc15.GUI.gameboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import it.polimi.ingsw.pc15.GUI.ButtonListener;

public class Gameboard extends JPanel {
	
	JPanel spaziTorre = new JPanel (new GridBagLayout());
	SpazioConsiglio spazioConsiglio;
	JPanel spazioFinale = new JPanel (new GridLayout(1,2));
	
	public Gameboard(ButtonListener listener) {
		
		this.setLayout(new GridBagLayout());
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int altezzaSchermo = (int)screenSize.getHeight();
		int larghezzaSchermo = (int)screenSize.getWidth();
		
		System.out.println("altezza schermo: "+altezzaSchermo);
		System.out.println("Larghezza schermo: "+larghezzaSchermo);

		GridBagConstraints gbc = new GridBagConstraints();
		
		// ADD SPAZIO FINALE
		//-----------------------//
		JPanel spaziProdRacc = new JPanel (new GridBagLayout());
		gbc.gridx = 0;
		gbc.gridy = 0;
		spaziProdRacc.add(new SpazioProduzione1(listener), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		spaziProdRacc.add(new SpazioProduzione2(listener), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		spaziProdRacc.add(new SpazioRaccolto1(listener), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		spaziProdRacc.add(new SpazioRaccolto2(listener), gbc);
		
		JPanel spaziMercatoDadi = new JPanel (new GridBagLayout());
		
		JPanel spazioMercato = new JPanel (new GridBagLayout());
		gbc.gridx = 0;
		gbc.gridy = 0;
		spazioMercato.add(new SpazioMercato1(listener), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		spazioMercato.add(new SpazioMercato2(listener), gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		spazioMercato.add(new SpazioMercato3(listener), gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 0;
		spazioMercato.add(new SpazioMercato4(listener), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		spaziMercatoDadi.add(spazioMercato, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		spaziMercatoDadi.add(new SpazioDadi(), gbc);
		
		spazioFinale.add(spaziProdRacc);
		spazioFinale.add(spaziMercatoDadi);
		
		// ADD SPAZI TORRE
		//-----------------------//
		String path;
		
		//Livello 1:
		//---------------------//
		gbc.gridx = 0;
		gbc.gridy = 0;
		path = "img\\Gameboard\\SpaziTorre\\Verde\\1\\";
		spaziTorre.add(new SpazioTorre(listener, 833, 181, 47, 517, 395, 129, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_1.png", "spazioTorreVerde1"),gbc);
		//spaziTorre.add(new SpazioTorreVerde1("img/DevCardsFront/devcards_f_en_c_1.png",listener), gbc); //0
		
		gbc.gridx = 1;
		path = "img\\Gameboard\\SpaziTorre\\Blu\\1\\";
		spaziTorre.add(new SpazioTorre(listener, 833, 181, 47, 517, 395, 38, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_61.png", "spazioTorreBlu1"),gbc);
		//spaziTorre.add(new SpazioTorreBlu1("img/DevCardsFront/devcards_f_en_c_61.png",listener), gbc); //1
		
		gbc.gridx = 2;
		path = "img\\Gameboard\\SpaziTorre\\Gialla\\1\\";
		spaziTorre.add(new SpazioTorre(listener, 833, 181, 47, 517, 395, 38, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_25.png", "spazioTorreGialla1"),gbc);
		//spaziTorre.add(new SpazioTorreGialla1("img/DevCardsFront/devcards_f_en_c_25.png",listener), gbc); //2
		
		gbc.gridx = 3;
		path = "img\\Gameboard\\SpaziTorre\\Viola\\1\\";
		spaziTorre.add(new SpazioTorre(listener, 833, 181, 47, 517, 571, 38, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_93.png", "spazioTorreViola1"),gbc);
		//spaziTorre.add(new SpazioTorreViola1("img/DevCardsFront/devcards_f_en_c_93.png",listener), gbc); //3
		
		
		//Livello 2:
		//---------------------//
		gbc.gridx = 0;
		gbc.gridy = 1;
		path = "img\\Gameboard\\SpaziTorre\\Verde\\2\\";
		spaziTorre.add(new SpazioTorre(listener, 833, 8, 47, 517, 395, 129, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_2.png", "spazioTorreVerde2"),gbc);
		//spaziTorre.add(new SpazioTorreVerde2("img/DevCardsFront/devcards_f_en_c_2.png",listener), gbc); //4
		
		gbc.gridx = 1;
		path = "img\\Gameboard\\SpaziTorre\\Blu\\2\\";
		spaziTorre.add(new SpazioTorre(listener, 833, 8, 47, 517, 395, 38, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_64.png", "spazioTorreBlu2"),gbc);
		//spaziTorre.add(new SpazioTorreBlu2("img/DevCardsFront/devcards_f_en_c_64.png",listener), gbc); //5
		
		gbc.gridx = 2;
		path = "img\\Gameboard\\SpaziTorre\\Gialla\\2\\";
		spaziTorre.add(new SpazioTorre(listener, 833, 8, 47, 517, 395, 38, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_26.png", "spazioTorreGialla2"),gbc);
		//spaziTorre.add(new SpazioTorreGialla2("img/DevCardsFront/devcards_f_en_c_26.png",listener), gbc); //6
		
		gbc.gridx = 3;
		path = "img\\Gameboard\\SpaziTorre\\Viola\\2\\";
		spaziTorre.add(new SpazioTorre(listener, 833, 8, 47, 517, 571, 38, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_94.png", "spazioTorreViola2"),gbc);
		//spaziTorre.add(new SpazioTorreViola2("img/DevCardsFront/devcards_f_en_c_94.png",listener), gbc); //7
		
		//Livello 3:
		//---------------------//
		gbc.gridx = 0;
		gbc.gridy = 2;
		path = "img\\Gameboard\\SpaziTorre\\Verde\\3\\";
		spaziTorre.add(new SpazioTorre(listener, 833, 8, 47, 517, 395, 129, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_3.png", "spazioTorreVerde3"),gbc);
		//spaziTorre.add(new SpazioTorreVerde3("img/DevCardsFront/devcards_f_en_c_3.png",listener), gbc); //8
		
		gbc.gridx = 1;
		path = "img\\Gameboard\\SpaziTorre\\Blu\\3\\";
		spaziTorre.add(new SpazioTorre(listener, 833, 8, 47, 517, 395, 38, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_62.png", "spazioTorreBlu3"),gbc);
		//spaziTorre.add(new SpazioTorreBlu3("img/DevCardsFront/devcards_f_en_c_62.png",listener), gbc); //9
		
		gbc.gridx = 2;
		path = "img\\Gameboard\\SpaziTorre\\Gialla\\3\\";
		spaziTorre.add(new SpazioTorre(listener, 833, 8, 47, 517, 395, 38, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_27.png", "spazioTorreGialla3"),gbc);
		//spaziTorre.add(new SpazioTorreGialla3("img/DevCardsFront/devcards_f_en_c_27.png",listener), gbc); //10
		
		gbc.gridx = 3;
		path = "img\\Gameboard\\SpaziTorre\\Viola\\3\\";
		spaziTorre.add(new SpazioTorre(listener, 833, 8, 47, 517, 571, 38, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_95.png", "spazioTorreViola3"),gbc);
		//spaziTorre.add(new SpazioTorreViola3("img/DevCardsFront/devcards_f_en_c_95.png",listener), gbc); //11
		
		//Livello 4:
		//---------------------//
		gbc.gridx = 0;
		gbc.gridy = 3;
		path = "img\\Gameboard\\SpaziTorre\\Verde\\4\\";
		spaziTorre.add(new SpazioTorre(listener, 833, 8, 47, 517, 395, 129, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_3.png", "spazioTorreVerde4"),gbc);
		//spaziTorre.add(new SpazioTorreVerde4("img/DevCardsFront/devcards_f_en_c_4.png",listener), gbc); //12
		
		gbc.gridx = 1;
		path = "img\\Gameboard\\SpaziTorre\\Blu\\4\\";
		spaziTorre.add(new SpazioTorre(listener, 833, 8, 47, 517, 395, 38, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_63.png", "spazioTorreBlu4"),gbc);
		//spaziTorre.add(new SpazioTorreBlu4("img/DevCardsFront/devcards_f_en_c_63.png",listener), gbc); //13
		
		gbc.gridx = 2;
		path = "img\\Gameboard\\SpaziTorre\\Gialla\\4\\";
		spaziTorre.add(new SpazioTorre(listener, 833, 8, 47, 517, 395, 38, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_28.png", "spazioTorreGialla4"),gbc);
		//spaziTorre.add(new SpazioTorreGialla4("img/DevCardsFront/devcards_f_en_c_28.png",listener), gbc); //14
		
		gbc.gridx = 3;
		path = "img\\Gameboard\\SpaziTorre\\Viola\\4\\";
		spaziTorre.add(new SpazioTorre(listener, 833, 8, 47, 517, 571, 38, path+"north.png", path+"south.png", path+"east.png", path+"west.png",
				"img/DevCardsFront/devcards_f_en_c_96.png", "spazioTorreViola4"),gbc);
		//spaziTorre.add(new SpazioTorreViola4("img/DevCardsFront/devcards_f_en_c_96.png",listener), gbc); //15
		
		//-------------------------------------------------------------------//
		// ADD GAMEBOARD
		//-------------------------------------------------------------------//

		spazioConsiglio = new SpazioConsiglio(listener);
		
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
	
	// Torre verde
	//---------------------------//
	/*public SpazioTorreVerde1 getSpazioTorreVerde1() {
		return (SpazioTorreVerde1) spaziTorre.getComponent(0);
	}*/

	public SpazioTorre getSpazioTorreVerde1() {
		return (SpazioTorre) spaziTorre.getComponent(0);
	}
	
	
	public SpazioTorre getSpazioTorreVerde2() {
		return (SpazioTorre) spaziTorre.getComponent(4);
	}
	
	public SpazioTorre getSpazioTorreVerde3() {
		return (SpazioTorre) spaziTorre.getComponent(8);
	}
	
	public SpazioTorre getSpazioTorreVerde4() {
		return (SpazioTorre) spaziTorre.getComponent(12);
	}
	
	// Torre blu
	//---------------------------//
	public SpazioTorre getSpazioTorreBlu1() {
		return (SpazioTorre) spaziTorre.getComponent(1);
	}
	
	public SpazioTorre getSpazioTorreBlu2() {
		return (SpazioTorre) spaziTorre.getComponent(5);
	}
	
	public SpazioTorre getSpazioTorreBlu3() {
		return (SpazioTorre) spaziTorre.getComponent(9);
	}
	
	public SpazioTorre getSpazioTorreBlu4() {
		return (SpazioTorre) spaziTorre.getComponent(13);
	}
	
	// Torre gialla
	//---------------------------//
	public SpazioTorre getSpazioTorreGialla1() {
		return (SpazioTorre) spaziTorre.getComponent(2);
	}
	
	public SpazioTorre getSpazioTorreGialla2() {
		return (SpazioTorre) spaziTorre.getComponent(6);
	}
	
	public SpazioTorre getSpazioTorreGialla3() {
		return (SpazioTorre) spaziTorre.getComponent(10);
	}
	
	public SpazioTorre getSpazioTorreGialla4() {
		return (SpazioTorre) spaziTorre.getComponent(14);
	}
		
	// Torre viola
	//---------------------------//
	public SpazioTorre getSpazioTorreViola1() {
		return (SpazioTorre) spaziTorre.getComponent(3);
	}
	
	public SpazioTorre getSpazioTorreViola2() {
		return (SpazioTorre) spaziTorre.getComponent(7);
	}
	
	public SpazioTorre getSpazioTorreViola3() {
		return (SpazioTorre) spaziTorre.getComponent(11);
	}
	
	public SpazioTorre getSpazioTorreViola4() {
		return (SpazioTorre) spaziTorre.getComponent(15);
	}
	
	// Spazio produzione
	//---------------------------//
	public SpazioProduzione1 getSpazioProduzione1() {
		JPanel spazioProd = (JPanel) spazioFinale.getComponent(0);
		return (SpazioProduzione1) spazioProd.getComponent(0);
	}
	
	public SpazioProduzione2 getSpazioProduzione2() {
		JPanel spazioProd = (JPanel) spazioFinale.getComponent(0);
		return (SpazioProduzione2) spazioProd.getComponent(1);
	}
	
	// Spazio raccolto
	//---------------------------//
	public SpazioRaccolto1 getSpazioRaccolto1() {
		JPanel spazioProd = (JPanel) spazioFinale.getComponent(0);
		return (SpazioRaccolto1) spazioProd.getComponent(2);
	}
	
	public SpazioRaccolto2 getSpazioRaccolto2() {
		JPanel spazioProd = (JPanel) spazioFinale.getComponent(0);
		return (SpazioRaccolto2) spazioProd.getComponent(3);
	}
	
	// Spazio consiglio
	//---------------------------//
	public SpazioConsiglio getSpazioConsiglio() {
		return spazioConsiglio;
	}
	
	// Spazio mercato
	//---------------------------//
	public SpazioMercato1 getSpazioMercato1() {
		JPanel spazioMercatoDadi = (JPanel) spazioFinale.getComponent(1);
		JPanel spazioMercato = (JPanel) spazioMercatoDadi.getComponent(0);
		return (SpazioMercato1) spazioMercato.getComponent(0);
	}
	
	public SpazioMercato2 getSpazioMercato2() {
		JPanel spazioMercatoDadi = (JPanel) spazioFinale.getComponent(1);
		JPanel spazioMercato = (JPanel) spazioMercatoDadi.getComponent(0);
		return (SpazioMercato2) spazioMercato.getComponent(1);
	}
	
	public SpazioMercato3 getSpazioMercato3() {
		JPanel spazioMercatoDadi = (JPanel) spazioFinale.getComponent(1);
		JPanel spazioMercato = (JPanel) spazioMercatoDadi.getComponent(0);
		return (SpazioMercato3) spazioMercato.getComponent(2);
	}
	
	public SpazioMercato4 getSpazioMercato4() {
		JPanel spazioMercatoDadi = (JPanel) spazioFinale.getComponent(1);
		JPanel spazioMercato = (JPanel) spazioMercatoDadi.getComponent(0);
		return (SpazioMercato4) spazioMercato.getComponent(3);
	}
	
	// Spazio dadi
	//---------------------------//
	public SpazioDadi getSpazioDadi() {
		JPanel spazioMercatoDadi = (JPanel) spazioFinale.getComponent(1);
		return (SpazioDadi) spazioMercatoDadi.getComponent(1);
	}
}
