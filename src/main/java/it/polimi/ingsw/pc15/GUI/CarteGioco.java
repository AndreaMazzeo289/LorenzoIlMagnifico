package it.polimi.ingsw.pc15.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.polimi.ingsw.pc15.carte.TipoCarta;

public class CarteGioco extends JButton{

	JButton carta;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	
	
	int altezzaTotale;
	int larghezzaTotale;
	float rapporto;
	int altezzaSchermo;
	int larghezzaSchermo;
	int altezzaRescale;
	int larghezzaRescale;
	TipoCarta tipoCarta;
	
	String path;
	
	ImageIcon imageIcon;
	Image image, newImage;
	
	public CarteGioco(String path, TipoCarta tipoCarta) {
		
		this.path = path;
		
		this.tipoCarta = tipoCarta;
		this.setActionCommand(path);
		
		larghezzaTotale = mainGUI.larghezzaTotale;
		altezzaTotale =  mainGUI.altezzaTotale;
		rapporto = mainGUI.rapportoPlayerBoard;
		
		int altezza = 1100; //800
		int larghezza = 370; //430
		
		int larghezzaTotale = 4076;
		int altezzaTotale = 6530;
		
		altezzaSchermo = (int)screenSize.getHeight();
		larghezzaSchermo = (int)(((float)screenSize.getWidth())*rapporto);
		larghezzaRescale = ((int)(larghezzaSchermo*larghezza)/larghezzaTotale);
		altezzaRescale = ((int)(altezzaSchermo*altezza)/altezzaTotale);
		
		carta = new JButton();
		
		imageIcon = new ImageIcon(path);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaRescale,altezzaRescale,Image.SCALE_DEFAULT);
		ImageIcon imageCard = new ImageIcon(newImage);
		
		carta.setIcon(imageCard);
		
		//this.add(carta, BorderLayout.CENTER);
		this.setIcon(imageCard);
		this.setPreferredSize(new Dimension(larghezza,altezza));
		this.setBackground(Color.decode("15394527"));
	}
	
	public int getAltezzaRescale() {
		return altezzaRescale;
	}
	
	public int getLarghezzaRescale() {
		return larghezzaRescale;
	}
}
