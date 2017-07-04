package it.polimi.ingsw.pc15.GUI.playerboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.polimi.ingsw.pc15.GUI.GUI;
import it.polimi.ingsw.pc15.carte.TipoCarta;

public class CarteGioco extends JButton{

	private JButton carta;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	
	
	private int altezzaTotale;
	private int larghezzaTotale;
	private float rapporto;
	private int altezzaSchermo;
	private int larghezzaSchermo;
	private int altezzaRescale;
	private int larghezzaRescale;
	private TipoCarta tipoCarta;
	
	private String path;
	
	transient ImageIcon imageIcon;
	transient Image image, newImage;
	
	private int altezza;
	private int larghezza;
	
	public CarteGioco(String path, TipoCarta tipoCarta, GUI gui) {
		
		this.path = path;
		
		this.tipoCarta = tipoCarta;
		this.setActionCommand(path);
		
		larghezzaTotale = gui.larghezzaTotale;
		altezzaTotale =  gui.altezzaTotale;
		rapporto = gui.rapportoPlayerBoard;
		
		altezza = 1100;
		larghezza = 370;
		
		/*int larghezzaTotale = 4076;
		int altezzaTotale = 6530;*/
		
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
	
	public void modificaImmagineCarta(String path) {
		imageIcon = new ImageIcon(path);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaRescale,altezzaRescale,Image.SCALE_DEFAULT);
		ImageIcon imageCard = new ImageIcon(newImage);
		carta.setIcon(imageCard);
		this.path = path;
	}
}
