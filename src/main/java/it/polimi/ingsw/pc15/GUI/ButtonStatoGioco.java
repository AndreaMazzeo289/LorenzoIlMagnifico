package it.polimi.ingsw.pc15.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;

public class ButtonStatoGioco extends JButton{

	
	JLabel imageButton;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public ButtonStatoGioco() {
		
		this.setBackground(Color.decode("15394527"));
		this.setActionCommand("buttonStatoGioco");
		
		int altezzaSchermo = (int)screenSize.getHeight();
		int larghezzaSchermo = (int)screenSize.getWidth()/2;
		
		this.setLayout(new BorderLayout());
		
		int altezza = 400;
		int larghezza = 4074;//1760 
		
		int larghezzaTotale = 4076;
		int altezzaTotale = 6530; //6420
		
		imageButton = new JLabel();
		
		ImageIcon imageIcon;
		Image image, newImage;
		
		imageIcon = new ImageIcon("img\\Punchboard\\statoDelGiocoButton.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezza)/larghezzaTotale),((int)(altezzaSchermo*altezza)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageAll = new ImageIcon(newImage);
		
		this.setIcon(imageAll);
		this.setPreferredSize(new Dimension(larghezza,altezza));
	}
}
