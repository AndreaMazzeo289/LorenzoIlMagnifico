package it.polimi.ingsw.pc15.GUI;

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

public class Gameboard extends JPanel {
	
	JPanel spaziTorre = new JPanel (new GridBagLayout());
	SpazioConsiglio spazioConsiglio = new SpazioConsiglio ();
	JPanel spazioFinale = new JPanel (new GridLayout(1,2));
	
	public Gameboard() {
		
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
		spaziProdRacc.add(new SpazioProduzione1(), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		spaziProdRacc.add(new SpazioProduzione2(), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		spaziProdRacc.add(new SpazioRaccolto1(), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		spaziProdRacc.add(new SpazioRaccolto2(), gbc);
		
		
		spazioFinale.add(spaziProdRacc);
		spazioFinale.add(new SpazioMercato1());
		
		// ADD SPAZI TORRE
		//-----------------------//
		gbc.gridx = 0;
		gbc.gridy = 0;
		spaziTorre.add(new SpazioTorreVerde1(), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		spaziTorre.add(new SpazioTorreBlu1(), gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		spaziTorre.add(new SpazioTorreGialla1(), gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 0;
		spaziTorre.add(new SpazioTorreViola1(), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		spaziTorre.add(new SpazioTorreVerde2(), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		spaziTorre.add(new SpazioTorreBlu2(), gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		spaziTorre.add(new SpazioTorreGialla2(), gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 1;
		spaziTorre.add(new SpazioTorreViola2(), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		spaziTorre.add(new SpazioTorreVerde3(), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		spaziTorre.add(new SpazioTorreBlu3(), gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		spaziTorre.add(new SpazioTorreGialla3(), gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 2;
		spaziTorre.add(new SpazioTorreViola3(), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		spaziTorre.add(new SpazioTorreVerde4(), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		spaziTorre.add(new SpazioTorreBlu4(), gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 3;
		spaziTorre.add(new SpazioTorreGialla4(), gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 3;
		spaziTorre.add(new SpazioTorreViola4(), gbc);
		
		//-------------------------------------------------------------------//
		// ADD GAMEBOARD
		//-------------------------------------------------------------------//

		spazioConsiglio = new SpazioConsiglio();
		
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
	
	public SpazioTorreVerde1 getSpazioTorreVerde1() {
		return (SpazioTorreVerde1) spaziTorre.getComponent(0);
	}
	
	public SpazioProduzione2 getSpazioProduzione2() {
		JPanel spazioProd = (JPanel) spazioFinale.getComponent(0);
		return (SpazioProduzione2) spazioProd.getComponent(1);
	}
	
}
