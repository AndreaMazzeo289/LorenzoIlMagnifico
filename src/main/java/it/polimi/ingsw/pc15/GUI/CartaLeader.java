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

public class CartaLeader extends JPanel{

	JButton carta;
	JLabel stato;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	
	
	int altezzaTotale;
	int larghezzaTotale;
	float rapporto;
	int altezzaSchermo;
	int larghezzaSchermo;
	
	public CartaLeader(String path, String name) {
		
		this.setLayout(new BorderLayout());
		
		larghezzaTotale = mainGUI.larghezzaTotale;
		altezzaTotale =  mainGUI.altezzaTotale;
		rapporto = mainGUI.rapportoPlayerBoard;
		
		altezzaSchermo = (int)screenSize.getHeight();
		larghezzaSchermo = (int)(((float)screenSize.getWidth())*rapporto);
		
		int altezza = 1000; //800
		int larghezza = 350; //430
		
		int larghezzaTotale = 4076;
		int altezzaTotale = 6530;
		
		carta = new JButton();
		stato = new JLabel();
	
		ImageIcon imageIcon;
		Image image, newImage;
		
		imageIcon = new ImageIcon(path);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezza)/larghezzaTotale),((int)(altezzaSchermo*altezza)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageAll = new ImageIcon(newImage);
	
		carta.setActionCommand(path+"-"+name);
		carta.setIcon(imageAll);
		carta.setPreferredSize(new Dimension(larghezza,altezza));
		carta.setBackground(Color.decode("15394527"));
		carta.setIcon(imageAll);
		carta.addActionListener(new ButtonListenerCarte());
		
		Dimension dimensione = new Dimension(((int)(larghezzaSchermo*350)/larghezzaTotale),((int)(altezzaSchermo*100)/altezzaTotale));
		stato.setMinimumSize(dimensione);
		stato.setOpaque(true);
		stato.setBackground(Color.decode("15394527"));
		stato.setText("       NON GIOCATO");
		
		//this.add(carta, BorderLayout.CENTER);
		
		
		this.add(carta,BorderLayout.CENTER);
		this.add(stato, BorderLayout.SOUTH);
	}
	
	public void scriviLabel(String text) {
		String testo = "            "+text;
		Dimension dimensione = new Dimension(((int)(larghezzaSchermo*350)/larghezzaTotale),((int)(altezzaSchermo*100)/altezzaTotale));
		stato.setMinimumSize(dimensione);
		stato.setOpaque(true);
		stato.setBackground(Color.decode("15394527"));
		stato.setText(testo);
	}
}
