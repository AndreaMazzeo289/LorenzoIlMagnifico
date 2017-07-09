package it.polimi.ingsw.pc15.GUI.gameboard;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import it.polimi.ingsw.pc15.GUI.ButtonListener;
import it.polimi.ingsw.pc15.GUI.ButtonListenerCarte;
import it.polimi.ingsw.pc15.GUI.GUI;

/**
 * Classe che gestisce la visualizzazione sulla gameboard degli spazi torre
 * [TERRITORIO - PERSONAGGIO - EDIFICIO - IMPRESA]
 * @author AndreaMazzeo289
 *
 */
public class SpazioTorre extends JPanel{
	
	private JLabel labelNorth;
	private JLabel labelWest;
	private JLabel labelSouth;
	private JLabel labelEast;
	private JButton buttonCenter;
	private ButtonTransparent buttonFamiliare;
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	private transient ImageIcon imageIcon;
	private transient Image image, newImage;
	
	private int altezzaSchermo;
	private int larghezzaSchermo;
	private int altezzaTotale;
	private int larghezzaTotale;
	
	private int altezzaCenter;
	private int altezzaNorth;
	private int altezzaSouth;
	private int larghezza;
	private int larghezzaCenter;
	private int larghezzaEast;
	private int larghezzaWest;
	private transient BufferedImage invisibleIcon;

	private float rapporto;
	
	public SpazioTorre (ButtonListener listener, GUI gui, int altezzaCenter, int altezzaNorth, int altezzaSouth, int larghezzaCenter, int larghezzaEast,
			int larghezzaWest, String imgNorth, String imgSouth, String imgEast, String imgWest, String imgCenter, String actionCommandFamiliare) 
	{	
		larghezzaTotale = gui.larghezzaTotale;
		altezzaTotale =  gui.altezzaTotale;
		rapporto = gui.rapporto;
		
		altezzaSchermo = (int)screenSize.getHeight();
		larghezzaSchermo = (int)(((float)screenSize.getWidth())*rapporto);
		
		this.setLayout(new BorderLayout());
		
		this.altezzaCenter = altezzaCenter;
		this.altezzaNorth = altezzaNorth;
		this.altezzaSouth = altezzaSouth;
		this.larghezzaCenter = larghezzaCenter;
		this.larghezzaEast = larghezzaEast;
		this.larghezzaWest = larghezzaWest;
		this.larghezza = larghezzaCenter+larghezzaEast+larghezzaWest;
		
		labelNorth = new JLabel();
		labelWest = new JLabel();
		labelSouth = new JLabel();
		labelEast = new JLabel();
		
		imageIcon = new ImageIcon(imgNorth);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezza)/larghezzaTotale),((int)(altezzaSchermo*altezzaNorth)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageNorth = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon(imgEast);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaEast)/larghezzaTotale),((int)(altezzaSchermo*altezzaCenter)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageEast = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon(imgWest);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaWest)/larghezzaTotale),((int)(altezzaSchermo*altezzaCenter)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageWest = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon(imgCenter);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaCenter)/larghezzaTotale),((int)(altezzaSchermo*altezzaCenter)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageCenter = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon(imgSouth);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezza)/larghezzaTotale),((int)(altezzaSchermo*altezzaSouth)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageSouth = new ImageIcon(newImage);
		
		labelNorth.setIcon(imageNorth);
		labelWest.setIcon(imageWest);
		labelSouth.setIcon(imageSouth);
		labelEast.setIcon(imageEast);
		
		buttonCenter = new JButton();
		buttonCenter.setIcon(imageCenter);
		buttonCenter.setBorder(null);
		buttonCenter.setActionCommand(imgCenter);
		buttonCenter.addActionListener(new ButtonListenerCarte(gui));
		
		labelEast.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		buttonFamiliare = new ButtonTransparent(actionCommandFamiliare,160,160,listener);
		
		String èViola = actionCommandFamiliare.substring(11);
		if(èViola.startsWith("Viola"))
			labelEast.setHorizontalAlignment(SwingConstants.LEFT);
		
		labelEast.add(buttonFamiliare,gbc);
		
		this.add(labelNorth, BorderLayout.NORTH);
		this.add(labelWest, BorderLayout.WEST);
		this.add(labelSouth, BorderLayout.SOUTH);
		this.add(buttonCenter, BorderLayout.CENTER);
		this.add(labelEast, BorderLayout.EAST);
		
		invisibleIcon = new BufferedImage(160, 160, BufferedImage.TYPE_INT_ARGB);
	}
	
	/**
	 * metodo che ci consente di inserire il familiare nello spazio predisposto accanto alla torre
	 * @param path del familiare da inserire
	 */
	public void inserisciFamiliare(String path) {
		imageIcon = new ImageIcon(path);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*160)/larghezzaTotale),((int)(altezzaSchermo*160)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageButton = new ImageIcon(newImage);
		buttonFamiliare.setOpaque(false);
		buttonFamiliare.setIcon(imageButton);
		buttonFamiliare.setBorder(null);
	}
	
	/**
	 * metodo che permette la modifica della carta visualizzata all'interno dello spazio torre
	 * @param path della carta da caricare
	 */
	public void modificaImmagineCarta (String path) {
		imageIcon = new ImageIcon(path);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaCenter)/larghezzaTotale),((int)(altezzaSchermo*altezzaCenter)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageCenter = new ImageIcon(newImage);
		buttonCenter.setIcon(imageCenter);
		buttonCenter.setActionCommand(path);
	}
	
	/**
	 * metodo che permette di rimuovere il familiare dallo spazio
	 */
	public void rimuoviFamiliare() {
		ImageIcon image = new ImageIcon(invisibleIcon);
		buttonFamiliare.setIcon(image);		
	}
}
