package it.polimi.ingsw.pc15.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CarteGioco extends JPanel{

	JLabel carta;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	
	
	public CarteGioco(String path) {
		int altezzaSchermo = (int)screenSize.getHeight();
		int larghezzaSchermo = (int)screenSize.getWidth()/2;
		
		this.setLayout(new BorderLayout());
		
		int altezza = 800; //toDefine
		int larghezza = 582; //toDefine
		
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
		
		this.add(carta, BorderLayout.CENTER);
	}
	
}
