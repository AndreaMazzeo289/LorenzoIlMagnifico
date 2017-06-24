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

public class SpazioMercato3 extends JPanel{

	JLabel labelNorth;
	JLabel labelWest;
	JLabel labelSouth;
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
	
	boolean occupato;
	
	public SpazioMercato3() {
		
		larghezzaTotale = mainGUI.larghezzaTotale;
		altezzaTotale =  mainGUI.altezzaTotale;
		rapporto = mainGUI.rapporto;
		
		altezzaSchermo = (int)screenSize.getHeight();
		larghezzaSchermo = (int)(((float)screenSize.getWidth())*rapporto);
		
		this.setLayout(new BorderLayout());
		
		int altezzaECW = 322;
		int altezzaN = 430;
		int altezzaS = 297;
		int larghezzaW = 56;
		int larghezzaE = 25;
		int larghezzaC = 310;
		int larghezzaN = larghezzaW+larghezzaE+larghezzaC; //956
		int larghezzaS = larghezzaN;
		
		labelCenter = new JLabel();
		
		if(mainGUI.numeroGiocatori==2)
		{
			int altezzaBlocco = altezzaECW+altezzaN+altezzaS-5;
			
			imageIcon = new ImageIcon("img\\Gameboard\\SpaziMercato\\3\\noMercato3.png");
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaN)/larghezzaTotale),((int)(altezzaSchermo*altezzaBlocco)/altezzaTotale),Image.SCALE_DEFAULT);
			ImageIcon imageCenter = new ImageIcon(newImage);
			labelCenter.setIcon(imageCenter);
			this.add(labelCenter, BorderLayout.CENTER);
		}
		else
		{
			String path = "img\\Gameboard\\SpaziMercato\\3\\south.png";
			if(mainGUI.numeroGiocatori==3)
				path = "img\\Gameboard\\SpaziMercato\\3\\southNo4.png";
			
			labelNorth = new JLabel();
			labelEast = new JLabel();
			labelWest = new JLabel();
			labelSouth = new JLabel();
			
			imageIcon = new ImageIcon("img\\Gameboard\\SpaziMercato\\3\\north.png");
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaN)/larghezzaTotale),((int)(altezzaSchermo*altezzaN)/altezzaTotale),Image.SCALE_DEFAULT);
			ImageIcon imageNorth = new ImageIcon(newImage);
			
			imageIcon = new ImageIcon("img\\Gameboard\\SpaziMercato\\3\\east.png");
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaE)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
			ImageIcon imageEast = new ImageIcon(newImage);
			
			imageIcon = new ImageIcon("img\\Gameboard\\SpaziMercato\\3\\west.png");
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaW)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
			ImageIcon imageWest = new ImageIcon(newImage);
			
			imageIcon = new ImageIcon("img\\Gameboard\\SpaziMercato\\3\\center.png");
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaC)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
			ImageIcon imageCenter = new ImageIcon(newImage);
			
			imageIcon = new ImageIcon(path);
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaS)/larghezzaTotale),((int)(altezzaSchermo*altezzaS)/altezzaTotale),Image.SCALE_DEFAULT);
			ImageIcon imageSouth = new ImageIcon(newImage);
			
			labelNorth.setIcon(imageNorth);
			labelEast.setIcon(imageEast);
			labelWest.setIcon(imageWest);
			labelSouth.setIcon(imageSouth);
			labelCenter.setIcon(imageCenter);
			
			labelCenter.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			
			buttonFamiliare = new ButtonTransparent("spazioMercato3",160,160);
			
			labelCenter.add(buttonFamiliare,gbc);
			
			this.add(labelNorth, BorderLayout.NORTH);
			this.add(labelEast, BorderLayout.EAST);
			this.add(labelWest, BorderLayout.WEST);
			this.add(labelSouth, BorderLayout.SOUTH);
			this.add(labelCenter, BorderLayout.CENTER);	
		}
		
		
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
