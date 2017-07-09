package it.polimi.ingsw.pc15.GUI.gameboard;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import it.polimi.ingsw.pc15.GUI.GUI;

/**
 * Classe che gestisce la visualizzazione del quarto spazio mercato nella gameboard
 * @author AndreaMazzeo289
 *
 */
public class SpazioMercato4 extends SpazioMercato{

	private JLabel labelNorth;
	private JLabel  labelWest;
	private JLabel labelSouth;
	private JLabel labelEast;
	private JLabel labelCenter;
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	private ButtonTransparent buttonFamiliare;
	
	transient ImageIcon imageIcon;
	transient Image image, newImage;
	
	private int altezzaSchermo;
	private int larghezzaSchermo;
	private int altezzaTotale;
	private int larghezzaTotale;
	
	private float rapporto;
	
	private int altezzaCenter;
	private int altezzaNorth;
	private int altezzaSouth;
	private int larghezza;
	private int larghezzaCenter;
	private int larghezzaEast;
	private int larghezzaWest;
	private BufferedImage invisibleIcon;
	
	public SpazioMercato4(ActionListener listener, GUI gui) {
		
		larghezzaTotale = gui.larghezzaTotale;
		altezzaTotale =  gui.altezzaTotale;
		rapporto = gui.rapporto;
		
		altezzaSchermo = (int)screenSize.getHeight();
		larghezzaSchermo = (int)(((float)screenSize.getWidth())*rapporto);
		
		this.setLayout(new BorderLayout());
		
		altezzaCenter = 350;
		altezzaNorth = 699;
		larghezzaEast = 112;
		larghezzaCenter = 320;
		larghezza = larghezzaEast+larghezzaCenter;

		labelCenter = new JLabel();
		
		if(gui.getNumeroGiocatori()==4)
		{
			labelNorth = new JLabel();
			labelEast = new JLabel();
			
			imageIcon = new ImageIcon("img\\Gameboard\\SpaziMercato\\4\\north.png");
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezza)/larghezzaTotale),((int)(altezzaSchermo*altezzaNorth)/altezzaTotale),Image.SCALE_DEFAULT);
			ImageIcon imageNorth = new ImageIcon(newImage);
			
			imageIcon = new ImageIcon("img\\Gameboard\\SpaziMercato\\4\\east.png");
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaEast)/larghezzaTotale),((int)(altezzaSchermo*altezzaCenter)/altezzaTotale),Image.SCALE_DEFAULT);
			ImageIcon imageEast = new ImageIcon(newImage);
			
			imageIcon = new ImageIcon("img\\Gameboard\\SpaziMercato\\4\\center.png");
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaCenter)/larghezzaTotale),((int)(altezzaSchermo*altezzaCenter)/altezzaTotale),Image.SCALE_DEFAULT);
			ImageIcon imageCenter = new ImageIcon(newImage);
			
			labelNorth.setIcon(imageNorth);
			labelEast.setIcon(imageEast);
			labelCenter.setIcon(imageCenter);
			
			labelCenter.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			
			buttonFamiliare = new ButtonTransparent("spazioMercato4",160,160,listener);
			
			labelCenter.add(buttonFamiliare,gbc);
			
			this.add(labelNorth, BorderLayout.NORTH);
			this.add(labelEast, BorderLayout.EAST);
			this.add(labelCenter, BorderLayout.CENTER);	
		}
		else
		{
			String path;
			if(gui.getNumeroGiocatori()==3)
				path = "img\\Gameboard\\SpaziMercato\\4\\noMercato4.png";
			else
				path = "img\\Gameboard\\SpaziMercato\\4\\noMercato4no3.png";
			
			int altezzaBlocco = altezzaCenter+altezzaNorth-5;
			
			imageIcon = new ImageIcon(path);
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezza)/larghezzaTotale),((int)(altezzaSchermo*altezzaBlocco)/altezzaTotale),Image.SCALE_DEFAULT);
			ImageIcon imageCenter = new ImageIcon(newImage);
			labelCenter.setIcon(imageCenter);
			this.add(labelCenter, BorderLayout.CENTER);	
		}
		
		invisibleIcon = new BufferedImage(160, 160, BufferedImage.TYPE_INT_ARGB);
	}
	
	/**
	 * metodo che permette di inserire il familiare nello spazio apposito
	 * @param path del familiare da inserire
	 */
	@Override
	public void inserisciFamiliare(String path) {
		imageIcon = new ImageIcon(path);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*160)/larghezzaTotale),((int)(altezzaSchermo*160)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageButton = new ImageIcon(newImage);
		
		buttonFamiliare.setIcon(imageButton);
		buttonFamiliare.setBorder(null);
	}
	
	/**
	 * metodo che consente di rimuovere il familiare che occupa lo spazio
	 */
	@Override
	public void rimuoviFamiliare() {
		ImageIcon image = new ImageIcon(invisibleIcon);
		buttonFamiliare.setIcon(image);
	}
}
