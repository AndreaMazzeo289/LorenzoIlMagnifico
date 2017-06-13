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

public class CarteGioco extends JButton{

	JLabel carta;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	
	
	int altezzaTotale;
	int larghezzaTotale;
	float rapporto;
	int altezzaSchermo;
	int larghezzaSchermo;
	
	public CarteGioco(String path) {
		
		this.setActionCommand(path);
		
		larghezzaTotale = mainGUI.larghezzaTotale;
		altezzaTotale =  mainGUI.altezzaTotale;
		rapporto = mainGUI.rapportoPlayerBoard;
		
		altezzaSchermo = (int)screenSize.getHeight();
		larghezzaSchermo = (int)(((float)screenSize.getWidth())*rapporto);
		
		int altezza = 800; //toDefine
		int larghezza = 430; //582
		
		int larghezzaTotale = 4076;
		int altezzaTotale = 6530;
		
		carta = new JLabel();
		
		ImageIcon imageIcon;
		Image image, newImage;
		
		imageIcon = new ImageIcon(path);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezza)/larghezzaTotale),((int)(altezzaSchermo*altezza)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageAll = new ImageIcon(newImage);
		
		carta.setIcon(imageAll);
		
		//this.add(carta, BorderLayout.CENTER);
		this.setIcon(imageAll);
		this.setPreferredSize(new Dimension(larghezza,altezza));
		this.setBackground(Color.decode("15394527"));
	}
	
}
