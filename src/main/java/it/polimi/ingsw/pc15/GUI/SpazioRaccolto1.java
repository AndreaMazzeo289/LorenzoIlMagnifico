package it.polimi.ingsw.pc15.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SpazioRaccolto1 extends JPanel{

	JLabel labelNorth;
	JLabel labelEast;
	JLabel labelWest;
	JLabel labelSouth;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	JButton buttonCenter;
	
	public SpazioRaccolto1() {
		
		int altezzaSchermo = (int)screenSize.getHeight();
		int larghezzaSchermo = (int)screenSize.getWidth()/2;
		
		this.setLayout(new BorderLayout());
		
		int altezzaECW = 432;
		int altezzaN = 91;
		int altezzaS = 143;
		int larghezzaW = 85;//85
		int larghezzaE = 66;
		int larghezzaC = 401;//399
		int larghezzaN = larghezzaW+larghezzaE+larghezzaC; //956
		int larghezzaS = larghezzaN;
		
		int larghezzaTotale = 4076;
		int altezzaTotale = 6530;
		
		labelNorth = new JLabel();
		labelEast = new JLabel();
		labelWest = new JLabel();
		labelSouth = new JLabel();
		
		ImageIcon imageIcon;
		Image image, newImage;
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziRaccolto\\1\\north.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaN)/larghezzaTotale),((int)(altezzaSchermo*altezzaN)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageNorth = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziRaccolto\\1\\east.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaE)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageEast = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziRaccolto\\1\\west.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaW)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageWest = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziRaccolto\\1\\center.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaC)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageCenter = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziRaccolto\\1\\south.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaS)/larghezzaTotale),((int)(altezzaSchermo*altezzaS)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageSouth = new ImageIcon(newImage);
		
		labelNorth.setIcon(imageNorth);
		labelEast.setIcon(imageEast);
		labelWest.setIcon(imageWest);
		labelSouth.setIcon(imageSouth);
		
		buttonCenter = new JButton();
		buttonCenter.setActionCommand("spazioRaccolto1");
		buttonCenter.setIcon(imageCenter);
		buttonCenter.setBorder(null);
		buttonCenter.addActionListener(new ButtonListenerSpazi());
		
		this.add(labelNorth, BorderLayout.NORTH);
		this.add(labelEast, BorderLayout.EAST);
		this.add(labelWest, BorderLayout.WEST);
		this.add(labelSouth, BorderLayout.SOUTH);
		
		this.add(buttonCenter, BorderLayout.CENTER);
	}
}
