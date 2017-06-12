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
	
	public CarteGioco(String path) {
		
		this.setActionCommand(path);
		
		int altezzaSchermo = (int)screenSize.getHeight();
		int larghezzaSchermo = (int)screenSize.getWidth()/2;
		
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
