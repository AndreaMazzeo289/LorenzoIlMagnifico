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

public class SpazioTorreBlu4 extends JPanel{

	JLabel labelNorth;
	JLabel labelWest;
	JLabel labelSouth;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	JButton buttonCenter;
	JButton buttonEast;
	
	public SpazioTorreBlu4(String path) {
		
		int altezzaSchermo = (int)screenSize.getHeight();
		int larghezzaSchermo = (int)screenSize.getWidth()/2;
		
		this.setLayout(new BorderLayout());
		
		int altezzaECW = 833;
		int altezzaN = 6;
		int larghezzaW = 38;
		int larghezzaE = 395;
		int larghezzaC = 517;
		int larghezzaN = larghezzaW+larghezzaE+larghezzaC; //956
		int larghezzaS = larghezzaN;
		int altezzaS = 47;
		int larghezzaTotale = 4076;
		int altezzaTotale = 6450;
		
		labelNorth = new JLabel();
		labelWest = new JLabel();
		labelSouth = new JLabel();
		
		ImageIcon imageIcon;
		Image image, newImage;
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziTorre\\Blu\\4\\north.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaN)/larghezzaTotale),((int)(altezzaSchermo*altezzaN)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageNorth = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziTorre\\Blu\\4\\east.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaE)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageEast = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziTorre\\Blu\\4\\west.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaW)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageWest = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon(path);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaC)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageCenter = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziTorre\\Blu\\4\\south.png");
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
		
		buttonEast = new JButton();
		buttonEast.setActionCommand("spazioTorreBlu4");
		buttonEast.setIcon(imageEast);
		buttonEast.setBorder(null);
		buttonEast.addActionListener(new ButtonListenerSpazi());
		
		
		this.add(labelNorth, BorderLayout.NORTH);
		this.add(labelWest, BorderLayout.WEST);
		this.add(labelSouth, BorderLayout.SOUTH);
		
		this.add(buttonCenter, BorderLayout.CENTER);
		this.add(buttonEast, BorderLayout.EAST);
	}
}
