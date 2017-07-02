package it.polimi.ingsw.pc15.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SpazioProduzione1 extends JPanel{

	private JLabel labelEast;
	private JLabel labelWest;
	private JLabel labelSouth;
	private JLabel labelNorth;
	private JLabel labelCenter;
	
	private ButtonTransparent buttonFamiliare;
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
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
	
	public SpazioProduzione1(ActionListener listener) {
		
		larghezzaTotale = mainGUI.larghezzaTotale;
		altezzaTotale =  mainGUI.altezzaTotale;
		rapporto = mainGUI.rapporto;
		
		altezzaSchermo = (int)screenSize.getHeight();
		larghezzaSchermo = (int)(((float)screenSize.getWidth())*rapporto);
		//larghezzaSchermo = (int)screenSize.getWidth()/2;
		
		this.setLayout(new BorderLayout());
		
		altezzaCenter = 432;
		altezzaNorth = 369;//363
		altezzaSouth = 59;
		larghezzaWest = 88;//85
		larghezzaEast = 68;//66
		larghezzaCenter = 416;//401//309
		larghezza = larghezzaWest+larghezzaEast+larghezzaCenter;
		
		labelNorth = new JLabel();
		labelEast = new JLabel();
		labelWest = new JLabel();
		labelSouth = new JLabel();
		labelCenter = new JLabel();
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziProduzione\\1\\north.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezza)/larghezzaTotale),((int)(altezzaSchermo*altezzaNorth)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageNorth = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziProduzione\\1\\east.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaEast)/larghezzaTotale),((int)(altezzaSchermo*altezzaCenter)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageEast = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziProduzione\\1\\west.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaWest)/larghezzaTotale),((int)(altezzaSchermo*altezzaCenter)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageWest = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziProduzione\\1\\center.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaCenter)/larghezzaTotale),((int)(altezzaSchermo*altezzaCenter)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageCenter = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziProduzione\\1\\south.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezza)/larghezzaTotale),((int)(altezzaSchermo*altezzaSouth)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageSouth = new ImageIcon(newImage);
		
		labelNorth.setIcon(imageNorth);
		labelEast.setIcon(imageEast);
		labelWest.setIcon(imageWest);
		labelSouth.setIcon(imageSouth);
		labelCenter.setIcon(imageCenter);
		
		labelCenter.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		buttonFamiliare = new ButtonTransparent("spazioProduzione1",160,160,listener);
		
		labelCenter.add(buttonFamiliare,gbc);
		
		this.add(labelNorth, BorderLayout.NORTH);
		this.add(labelEast, BorderLayout.EAST);
		this.add(labelWest, BorderLayout.WEST);
		this.add(labelSouth, BorderLayout.SOUTH);
		this.add(labelCenter, BorderLayout.CENTER);	
	}
	
	public void inserisciFamiliare(String path) {
		imageIcon = new ImageIcon(path);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*160)/larghezzaTotale),((int)(altezzaSchermo*160)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageButton = new ImageIcon(newImage);
		
		buttonFamiliare.setIcon(imageButton);
		buttonFamiliare.setBorder(null);
	}
}
