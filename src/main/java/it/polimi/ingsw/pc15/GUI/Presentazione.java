package it.polimi.ingsw.pc15.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Presentazione extends JPanel{

	JLabel present;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	
	
	public Presentazione() {
		int altezzaSchermo = (int)screenSize.getHeight();
		int larghezzaSchermo = (int)screenSize.getWidth()/2;
		
		this.setLayout(new BorderLayout());
		
		int altezza = 600; //toDefine
		int larghezza = 2314; //toDefine
		
		int larghezzaTotale = 4076;
		int altezzaTotale = 6530;
		
		present = new JLabel();
		
		ImageIcon imageIcon;
		Image image, newImage;
		
		imageIcon = new ImageIcon("img\\Punchboard\\presentation.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezza)/larghezzaTotale),((int)(altezzaSchermo*altezza)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageAll = new ImageIcon(newImage);
		
		present.setIcon(imageAll);
		
		this.add(present, BorderLayout.CENTER);
	}
	
}
