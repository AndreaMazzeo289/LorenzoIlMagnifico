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
	
	int altezzaTotale;
	int larghezzaTotale;
	float rapporto;
	int altezzaSchermo;
	int larghezzaSchermo;
	
	public ButtonStatoGioco() {
		
		this.setBackground(Color.decode("15394527"));
		this.setActionCommand("buttonStatoGioco");
		
		larghezzaTotale = mainGUI.larghezzaTotale;
		altezzaTotale =  mainGUI.altezzaTotale;
		rapporto = mainGUI.rapportoPlayerBoard;
		
		altezzaSchermo = (int)screenSize.getHeight();
		larghezzaSchermo = (int)(((float)screenSize.getWidth())*rapporto);
		
		this.setLayout(new BorderLayout());
		
		int altezza = 400;
		int larghezza = 2500;//2574
		
		int larghezzaTotale = 4076;
		int altezzaTotale = 6530; //6420
		
		imageButton = new JLabel();
		
		ImageIcon imageIcon;
		Image image, newImage;
		
		imageIcon = new ImageIcon("img\\Punchboard\\statoGioco.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezza)/larghezzaTotale),((int)(altezzaSchermo*altezza)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageAll = new ImageIcon(newImage);
		
		this.setIcon(imageAll);
		this.setPreferredSize(new Dimension(larghezza,altezza));
	}
	
	public void bloccaButton() {
		this.setEnabled(false);
	}
	
	public void sbloccaButton() {
		this.setEnabled(true);
	}
}
