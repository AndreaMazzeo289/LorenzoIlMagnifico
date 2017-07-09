package it.polimi.ingsw.pc15.GUI.gameboard;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.polimi.ingsw.pc15.GUI.GUI;

/**
 * Classe che gestisce la visualizzazione dello spazio del consiglio sulla gameboard
 * @author AndreaMazzeo289
 *
 */
public class SpazioConsiglio extends JPanel{

	private JLabel labelEast;
	private JLabel labelWest;
	private JLabel labelSouth;
	private JLabel labelNorth;
	private JLabel labelCenter;
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	private ArrayList <ButtonTransparent> button;
	
	private int altezzaSchermo;
	private int larghezzaSchermo;
	private int larghezzaTotale;
	private int altezzaTotale;
	
	private float rapporto;
	
	transient ImageIcon imageIcon;
	transient Image image, newImage;
	
	private int altezzaCenter;
	private int altezzaNorth;
	private int altezzaSouth;
	private int larghezza;
	private int larghezzaCenter;
	private int larghezzaEast;
	private int larghezzaWest;
	
	private BufferedImage invisibleIcon;
	
	public SpazioConsiglio(ActionListener listener, GUI gui) {
		
		larghezzaTotale = gui.larghezzaTotale;
		altezzaTotale =  gui.altezzaTotale;
		rapporto = gui.rapporto;
		
		altezzaSchermo = (int)screenSize.getHeight();
		larghezzaSchermo = (int)(((float)screenSize.getWidth())*rapporto);
		
		this.setLayout(new BorderLayout());
		
		altezzaCenter = 295;
		altezzaNorth = 110;
		altezzaSouth = 779;
		larghezzaWest = 2181;
		larghezzaEast = 819;
		larghezzaCenter = 1067;
		larghezza = larghezzaWest+larghezzaEast+larghezzaCenter;
		
		labelEast = new JLabel();
		labelWest = new JLabel();
		labelSouth = new JLabel();
		labelCenter = new JLabel();
		labelNorth = new JLabel();
		
		ImageIcon imageIcon;
		Image image, newImage;
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpazioConsiglio\\north.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezza)/larghezzaTotale),((int)(altezzaSchermo*altezzaNorth)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageNorth = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpazioConsiglio\\east.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaEast)/larghezzaTotale),((int)(altezzaSchermo*altezzaCenter)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageEast = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpazioConsiglio\\west.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaWest)/larghezzaTotale),((int)(altezzaSchermo*altezzaCenter)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageWest = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpazioConsiglio\\center.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaCenter)/larghezzaTotale),((int)(altezzaSchermo*altezzaCenter)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageCenter = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpazioConsiglio\\south.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezza)/larghezzaTotale),((int)(altezzaSchermo*altezzaSouth)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageSouth = new ImageIcon(newImage);
		
		labelNorth.setIcon(imageNorth);
		labelEast.setIcon(imageEast);
		labelWest.setIcon(imageWest);
		labelSouth.setIcon(imageSouth);
		labelCenter.setIcon(imageCenter);
		
		labelCenter.setLayout(new BorderLayout());
		JLabel labelButton = new JLabel();
		labelButton.setLayout(new GridLayout(2,8));
		
		button = new ArrayList<ButtonTransparent>(16);
		for(int i=0; i<16; i++) {
			button.add(new ButtonTransparent("SpazioConsiglioPosizione"+i,100,85,listener));
		}
		
		for(ButtonTransparent button : button) {
			labelButton.add(button);
		}
		
		labelButton.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
		labelButton.setAlignmentY(java.awt.Component.CENTER_ALIGNMENT);
		labelCenter.add(labelButton);
		
		this.add(labelNorth, BorderLayout.NORTH);
		this.add(labelEast, BorderLayout.EAST);
		this.add(labelWest, BorderLayout.WEST);
		this.add(labelSouth, BorderLayout.SOUTH);
		this.add(labelCenter, BorderLayout.CENTER);
		
		invisibleIcon = new BufferedImage(160, 160, BufferedImage.TYPE_INT_ARGB);
	}
	
	/**
	 * metodo che permette di inserire il familiare all'interno dello spazio
	 * i familiari che possono essere inseriti sono multipli, e verranno inseriti in modo ordinato
	 * @param path del familiare da inserire
	 */
	public void inserisciFamiliare(String path) {
		imageIcon = new ImageIcon(path);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*102)/larghezzaTotale),((int)(altezzaSchermo*85)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageButton = new ImageIcon(newImage);
		
		int i=0;
		while(i<16 && button.get(i).getName().equals("occupato"))
			i++;
		button.get(i).setIcon(imageButton);
		button.get(i).setBorder(null);
		button.get(i).setName("occupato");
	}
	
	/**
	 * questo metodo consente di rimuovere tutti i familiari presenti nello spazio
	 */
	public void rimuoviFamliari() {
		ImageIcon image = new ImageIcon(invisibleIcon);
		for(int i=0;i<16;i++) {
			if(button.get(i).getName().equals("occupato")) {
				button.get(i).setName("libero");
				button.get(i).setIcon(image);
			}
		}
	}
}
