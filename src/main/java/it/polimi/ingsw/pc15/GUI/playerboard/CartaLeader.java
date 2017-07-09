package it.polimi.ingsw.pc15.GUI.playerboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import it.polimi.ingsw.pc15.GUI.ButtonListenerCarte;
import it.polimi.ingsw.pc15.GUI.GUI;

/**
 * Classe che gestisce la visualizzazione delle carte leader nella playerboard
 * @author AndreaMazzeo289
 *
 */
public class CartaLeader extends JPanel{

	private JButton carta;
	private JLabel stato;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private String textLabel;
	
	private int altezzaTotale;
	private int larghezzaTotale;
	private float rapporto;
	private int altezzaSchermo;
	private int larghezzaSchermo;
	
	private String path;
	private String name;
	
	transient ImageIcon imageIcon;
	transient Image image, newImage;
	
	private int altezza;
	private int larghezza;
	
	public CartaLeader(String path, String name, GUI gui) {
		
		this.path = path;
		this.name = name;
		
		this.setLayout(new BorderLayout());
		
		textLabel = "NON GIOCATO";
		
		larghezzaTotale = gui.larghezzaTotale;
		altezzaTotale =  gui.altezzaTotale;
		rapporto = gui.rapportoPlayerBoard;
		
		altezzaSchermo = (int)screenSize.getHeight();
		larghezzaSchermo = (int)(((float)screenSize.getWidth())*rapporto);
		
		altezza = 1000;
		larghezza = 350;
		
		carta = new JButton();
		stato = new JLabel("",SwingConstants.CENTER);
		stato.setFont((new Font("Courier New", Font.ITALIC, 15)));
		
		imageIcon = new ImageIcon(path);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezza)/larghezzaTotale),((int)(altezzaSchermo*altezza)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageAll = new ImageIcon(newImage);
	
		carta.setActionCommand(path+"-"+name);
		carta.setIcon(imageAll);
		carta.setPreferredSize(new Dimension(larghezza,altezza));
		carta.setBackground(Color.decode("15394527"));
		carta.addActionListener(new ButtonListenerCarte(gui));
		
		Dimension dimensione = new Dimension(((int)(larghezzaSchermo*350)/larghezzaTotale),((int)(altezzaSchermo*100)/altezzaTotale));
		stato.setMinimumSize(dimensione);
		stato.setOpaque(true);
		stato.setBackground(Color.decode("15394527"));
		stato.setText("NON GIOCATO");
		
		this.add(carta,BorderLayout.CENTER);
		this.add(stato, BorderLayout.SOUTH);
	}
	
	/**
	 * metodo che permette di visualizzare nell'apposita label di testo lo stato della carta
	 * (GIOCATO, NON GIOCATO, SCARTATO)
	 * @param stringa che verrà scritta nella label di testo
	 */
	public void scriviLabel(String text) {
		Dimension dimensione = new Dimension(((int)(larghezzaSchermo*350)/larghezzaTotale),((int)(altezzaSchermo*100)/altezzaTotale));
		stato.setMinimumSize(dimensione);
		stato.setOpaque(true);
		stato.setBackground(Color.decode("15394527"));
		stato.setText(text);
		textLabel = new String(text);
	}
	
	/**
	 * metodo che permette di modificare l'immagine che verrà visualizzata
	 * @param path per caricare l'immagine
	 */
	public void modificaImmagineCarta(String path) {
		imageIcon = new ImageIcon(path);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezza)/larghezzaTotale),((int)(altezzaSchermo*altezza)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageAll = new ImageIcon(newImage);
		carta.setIcon(imageAll);
		this.path = path;
		carta.setActionCommand(path);
	}
	
	/**
	 * metodo che permette di leggere cosa c'è scritto nella label di testo
	 * @return stringa contenuta nella label
	 */
	public String leggiLabel() {
		return textLabel;
	}
	
	/**
	 * metodo che permette di acquisire il nome della carta
	 * [Leader1 - Leader2 - Leader3 - Leader4]
	 * @return nome della carta
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * metodo che consente la lettura del path dell'immagine
	 * @return stringa che rappresenta il path dell'immagine
	 */
	public String getPath() {
		return path;
	}
}
