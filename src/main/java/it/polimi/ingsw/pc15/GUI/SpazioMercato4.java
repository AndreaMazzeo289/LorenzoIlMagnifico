package it.polimi.ingsw.pc15.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SpazioMercato4 extends JPanel{

	JLabel labelNorth;
	JLabel labelEast;
	JLabel labelCenter;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	ButtonTransparent buttonFamiliare;
	
	ImageIcon imageIcon;
	Image image, newImage;
	
	int altezzaSchermo;
	int larghezzaSchermo;
	int altezzaTotale;
	int larghezzaTotale;
	
	float rapporto;
	
	public SpazioMercato4() {
		
		larghezzaTotale = mainGUI.larghezzaTotale;
		altezzaTotale =  mainGUI.altezzaTotale;
		rapporto = mainGUI.rapporto;
		
		altezzaSchermo = (int)screenSize.getHeight();
		larghezzaSchermo = (int)(((float)screenSize.getWidth())*rapporto);
		
		this.setLayout(new BorderLayout());
		
		int altezzaECW = 350;
		int altezzaN = 699;
		int larghezzaE = 112;
		int larghezzaC = 320;
		int larghezzaN = larghezzaE+larghezzaC; //956
		
		System.out.println("larghezzaspazio4 "+larghezzaN);
		
		labelNorth = new JLabel();
		labelEast = new JLabel();
		labelCenter = new JLabel();
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziMercato\\4\\north.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaN)/larghezzaTotale),((int)(altezzaSchermo*altezzaN)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageNorth = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziMercato\\4\\east.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaE)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageEast = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziMercato\\4\\center.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaC)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageCenter = new ImageIcon(newImage);
		
		labelNorth.setIcon(imageNorth);
		labelEast.setIcon(imageEast);
		labelCenter.setIcon(imageCenter);
		
		labelCenter.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		buttonFamiliare = new ButtonTransparent("spazioMercato4",160,160);
		
		labelCenter.add(buttonFamiliare,gbc);
		
		this.add(labelNorth, BorderLayout.NORTH);
		this.add(labelEast, BorderLayout.EAST);
		this.add(labelCenter, BorderLayout.CENTER);	
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
