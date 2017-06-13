package it.polimi.ingsw.pc15.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SpazioTorreVerde1 extends JPanel{

	JLabel labelNorth;
	JLabel labelWest;
	JLabel labelSouth;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	JButton buttonCenter;
	JLabel buttonEast;
	JButton buttonFamiliare;
	
	ImageIcon imageIcon;
	Image image, newImage;
	
	int altezzaSchermo;
	int larghezzaSchermo;
	int altezzaTotale;
	int larghezzaTotale;
	
	public SpazioTorreVerde1(String path) {
		
		altezzaSchermo = (int)screenSize.getHeight();
		larghezzaSchermo = (int)screenSize.getWidth()/2;
		
		this.setLayout(new BorderLayout());
		
		int altezzaECW = 833;
		int altezzaC = 833;
		int altezzaN = 181;
		int larghezzaW = 129;
		int larghezzaE = 395;
		int larghezzaC = 517;//517
		int larghezzaN = larghezzaW+larghezzaE+larghezzaC; //1041
		int larghezzaS = larghezzaN;
		int altezzaS = 47;
		larghezzaTotale = 4076;//4068
		altezzaTotale = 6530;
		
		labelNorth = new JLabel();
		labelWest = new JLabel();
		labelSouth = new JLabel();
		
		
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziTorre\\Verde\\1\\north.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaN)/larghezzaTotale),((int)(altezzaSchermo*altezzaN)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageNorth = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziTorre\\Verde\\1\\east.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaE)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageEast = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziTorre\\Verde\\1\\west.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaW)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageWest = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon(path);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaC)/larghezzaTotale),((int)(altezzaSchermo*altezzaC)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageCenter = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziTorre\\Verde\\1\\south.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaS)/larghezzaTotale),((int)(altezzaSchermo*altezzaS)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageSouth = new ImageIcon(newImage);
		
		labelNorth.setIcon(imageNorth);
		labelWest.setIcon(imageWest);
		labelSouth.setIcon(imageSouth);
		
		buttonCenter = new JButton();
		buttonCenter.setIcon(imageCenter);
		buttonCenter.setBorder(null);
		//buttonCenter.addActionListener(new ButtonListener(path));
		
		buttonEast = new JLabel();
		buttonEast.setIcon(imageEast);
		buttonEast.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		buttonFamiliare = new JButton();
		buttonFamiliare.setMinimumSize(new Dimension(160,160));
		buttonFamiliare.setActionCommand("spazioTorreVerde1");
		buttonFamiliare.setOpaque(false);
		buttonFamiliare.setContentAreaFilled(false);
		buttonFamiliare.setBorderPainted(false);
		buttonFamiliare.addActionListener(new ButtonListenerSpazi());
		
		buttonEast.add(buttonFamiliare,gbc);
		
		this.add(labelNorth, BorderLayout.NORTH);
		this.add(labelWest, BorderLayout.WEST);
		this.add(labelSouth, BorderLayout.SOUTH);
		
		this.add(buttonCenter, BorderLayout.CENTER);
		this.add(buttonEast, BorderLayout.EAST);
		
	}
	
	public void inserisciFamiliare(String path) {
		imageIcon = new ImageIcon(path);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*160)/larghezzaTotale),((int)(altezzaSchermo*160)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageButton = new ImageIcon(newImage);
		
		buttonFamiliare.setIcon(imageButton);
		buttonFamiliare.setBorder(null);
	}
}
