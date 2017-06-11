package it.polimi.ingsw.pc15.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CestaPietra extends JPanel{

	JLabel labelNorth;
	JLabel labelEast;
	JLabel labelWest;
	JLabel labelCenter;
	JLabel labelSouth;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	int altezzaSchermo;
	int larghezzaSchermo;
	
	int altezzaECW;
	int altezzaN;
	int altezzaS;
	int larghezzaW;
	int larghezzaE;
	int larghezzaC;
	int larghezzaN;
	int larghezzaS;
	
	int larghezzaTotale;
	int altezzaTotale;
	
	ImageIcon imageIcon;
	Image image, newImage;
	
	public CestaPietra() {
		
		altezzaSchermo = (int)screenSize.getHeight();
		larghezzaSchermo = (int)screenSize.getWidth()/2;
		
		this.setLayout(new BorderLayout());
		
		altezzaECW = 142;
		altezzaN = 246;
		altezzaS = 112;
		larghezzaW = 182;
		larghezzaE = 173;
		larghezzaC = 166;
		larghezzaN = larghezzaW+larghezzaE+larghezzaC;
		larghezzaS = larghezzaN;
		
		larghezzaTotale = 4076;
		altezzaTotale = 6530;
		
		labelNorth = new JLabel();
		labelEast = new JLabel();
		labelWest = new JLabel();
		labelCenter = new JLabel();
		labelSouth = new JLabel();
		
		imageIcon = new ImageIcon("img\\Punchboard\\pietra\\north.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaN)/larghezzaTotale),((int)(altezzaSchermo*altezzaN)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageNorth = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Punchboard\\pietra\\east.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaE)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageEast = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Punchboard\\pietra\\west.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaW)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageWest = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Punchboard\\pietra\\center.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaC)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageCenter = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Punchboard\\pietra\\south.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaS)/larghezzaTotale),((int)(altezzaSchermo*altezzaS)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageSouth = new ImageIcon(newImage);
		
		labelNorth.setIcon(imageNorth);
		labelEast.setIcon(imageEast);
		labelWest.setIcon(imageWest);
		labelCenter.setIcon(imageCenter);
		labelSouth.setIcon(imageSouth);
		
		this.add(labelNorth, BorderLayout.NORTH);
		this.add(labelEast, BorderLayout.EAST);
		this.add(labelWest, BorderLayout.WEST);
		this.add(labelCenter, BorderLayout.CENTER);
		this.add(labelSouth, BorderLayout.SOUTH);
	}
	
	public void redrawCentral (String path){
		imageIcon = new ImageIcon(path);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaC)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageCenter = new ImageIcon(newImage);
		labelCenter.setIcon(imageCenter);
	}
}
