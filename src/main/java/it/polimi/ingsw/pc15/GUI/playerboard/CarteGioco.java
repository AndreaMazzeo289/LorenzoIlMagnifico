package it.polimi.ingsw.pc15.GUI.playerboard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import it.polimi.ingsw.pc15.GUI.ButtonListenerCarte;
import it.polimi.ingsw.pc15.GUI.GUI;
import it.polimi.ingsw.pc15.carte.TipoCarta;

/**
 * Classe che permette la visualizzazione di tutte le carte possedute dal player nella playerboard
 * @author AndreaMazzeo289
 *
 */

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
		this.addActionListener(new ButtonListenerCarte(gui));
		
		larghezzaTotale = gui.larghezzaTotale;
		altezzaTotale =  gui.altezzaTotale;
		rapporto = gui.rapportoPlayerBoard;
		
		altezza = 1100;
		larghezza = 370;
		
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
		
		this.setIcon(imageCard);
		this.setPreferredSize(new Dimension(larghezza,altezza));
		this.setBackground(Color.decode("15394527"));
	}
	
	/**
	 * metodo che permette di modificare l'immagine che viene visualizzata nell'apposito spazio
	 * per esempio quando un player acquisisce una carte questa viene inserita nella playerboard
	 * @param path dell'immagine da inserire
	 */
	public void modificaImmagineCarta(String path) {
		imageIcon = new ImageIcon(path);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaRescale,altezzaRescale,Image.SCALE_DEFAULT);
		ImageIcon imageCard = new ImageIcon(newImage);
		this.setIcon(imageCard);
		this.path = path;
		this.setActionCommand(path);
	}
}
