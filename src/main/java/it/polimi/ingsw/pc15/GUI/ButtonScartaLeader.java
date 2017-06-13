package it.polimi.ingsw.pc15.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;

public class ButtonScartaLeader extends JButton{

	
	JLabel imageButton;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	int altezzaTotale;
	int larghezzaTotale;
	float rapporto;
	int altezzaSchermo;
	int larghezzaSchermo;
	
	public ButtonScartaLeader() {
		setBackground(Color.decode("2436408"));
		
		larghezzaTotale = mainGUI.larghezzaTotale;
		altezzaTotale =  mainGUI.altezzaTotale;
		rapporto = mainGUI.rapportoPlayerBoard;
		
		altezzaSchermo = (int)screenSize.getHeight();
		larghezzaSchermo = (int)(((float)screenSize.getWidth())*rapporto);
		
		this.setLayout(new BorderLayout());
		
		int altezza = 700;
		int larghezza = 880; 
		
		imageButton = new JLabel();
		
		ImageIcon imageIcon;
		Image image, newImage;
		
		imageIcon = new ImageIcon("img\\Punchboard\\Button\\scartaLeader.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezza)/larghezzaTotale),((int)(altezzaSchermo*altezza)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageAll = new ImageIcon(newImage);
		
		this.setIcon(imageAll);
		this.setPreferredSize(new Dimension(larghezza,altezza));
	}
}
