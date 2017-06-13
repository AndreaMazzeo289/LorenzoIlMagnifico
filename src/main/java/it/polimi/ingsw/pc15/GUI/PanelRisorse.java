package it.polimi.ingsw.pc15.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelRisorse extends JPanel{

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	JLabel labelCenter;
	JLabel labelNorth;
	JLabel labelSouth;
	
	int altezzaSchermo;
	int larghezzaSchermo;
	
	int altezzaCenter;
	int altezzaNorth;
	int altezzaSouth;
	int larghezzaBlocco;
	float rapporto;
	int larghezzaTotale;
	int altezzaTotale;
	
	ImageIcon imageIcon;
	Image image, newImage;
	
	public PanelRisorse(String path){
		
		larghezzaTotale = mainGUI.larghezzaTotale;
		altezzaTotale =  mainGUI.altezzaTotale;
		rapporto = mainGUI.rapportoPlayerBoard;
		
		altezzaSchermo = (int)screenSize.getHeight();
		larghezzaSchermo = (int)(((float)screenSize.getWidth())*rapporto);
		
		altezzaCenter = 150;
		altezzaNorth = 375;
		altezzaSouth = 175;
		larghezzaBlocco = 450;
		
		larghezzaTotale = 4076;
		altezzaTotale = 6530;
		
		this.setLayout(new BorderLayout());
		
		labelNorth = new JLabel();
		labelCenter = new JLabel();
		labelSouth = new JLabel();
		
		imageIcon = new ImageIcon(path);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaBlocco)/larghezzaTotale),((int)(altezzaSchermo*altezzaNorth)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageNorth = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Punchboard\\Risorse\\center.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaBlocco)/larghezzaTotale),((int)(altezzaSchermo*altezzaCenter)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageCenter = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Punchboard\\Risorse\\south.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaBlocco)/larghezzaTotale),((int)(altezzaSchermo*altezzaSouth)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageSouth = new ImageIcon(newImage);
		
		labelNorth.setIcon(imageNorth);
		labelCenter.setIcon(imageCenter);
		labelSouth.setIcon(imageSouth);
		
		this.add(labelNorth, BorderLayout.NORTH);
		this.add(labelCenter, BorderLayout.CENTER);
		this.add(labelSouth, BorderLayout.SOUTH);
		
	}
	
	public void writeIntoLabel (int numero) {
		String text = "                "+numero;
		labelCenter.setIcon(null);
		Dimension dimensione = new Dimension(((int)(larghezzaSchermo*larghezzaBlocco)/larghezzaTotale),((int)(altezzaSchermo*altezzaCenter)/altezzaTotale));
		labelCenter.setMinimumSize(dimensione);
		labelCenter.setOpaque(true);
		labelCenter.setBackground(Color.decode("15394527"));
		labelCenter.setText(text);
	}
	
}
