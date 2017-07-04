package it.polimi.ingsw.pc15.GUI.gameboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.polimi.ingsw.pc15.GUI.mainGUI;

public class SpazioMercato3 extends JPanel{

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
	
	public SpazioMercato3(ActionListener listener) {
		
		larghezzaTotale = mainGUI.larghezzaTotale;
		altezzaTotale =  mainGUI.altezzaTotale;
		rapporto = mainGUI.rapporto;
		
		altezzaSchermo = (int)screenSize.getHeight();
		larghezzaSchermo = (int)(((float)screenSize.getWidth())*rapporto);
		
		this.setLayout(new BorderLayout());
		
		altezzaCenter = 322;
		altezzaNorth = 430;
		altezzaSouth = 297;
		larghezzaWest = 56;
		larghezzaEast = 25;
		larghezzaCenter = 310;
		larghezza = larghezzaWest+larghezzaEast+larghezzaCenter;
		
		labelCenter = new JLabel();
		
		if(mainGUI.numeroGiocatori==2)
		{
			int altezzaBlocco = altezzaCenter+altezzaNorth+altezzaSouth-5;
			
			imageIcon = new ImageIcon("img\\Gameboard\\SpaziMercato\\3\\noMercato3.png");
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezza)/larghezzaTotale),((int)(altezzaSchermo*altezzaBlocco)/altezzaTotale),Image.SCALE_DEFAULT);
			ImageIcon imageCenter = new ImageIcon(newImage);
			labelCenter.setIcon(imageCenter);
			this.add(labelCenter, BorderLayout.CENTER);
		}
		else
		{
			String path = "img\\Gameboard\\SpaziMercato\\3\\south.png";
			if(mainGUI.numeroGiocatori==3)
				path = "img\\Gameboard\\SpaziMercato\\3\\southNo4.png";
			
			labelNorth = new JLabel();
			labelEast = new JLabel();
			labelWest = new JLabel();
			labelSouth = new JLabel();
			
			imageIcon = new ImageIcon("img\\Gameboard\\SpaziMercato\\3\\north.png");
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezza)/larghezzaTotale),((int)(altezzaSchermo*altezzaNorth)/altezzaTotale),Image.SCALE_DEFAULT);
			ImageIcon imageNorth = new ImageIcon(newImage);
			
			imageIcon = new ImageIcon("img\\Gameboard\\SpaziMercato\\3\\east.png");
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaEast)/larghezzaTotale),((int)(altezzaSchermo*altezzaCenter)/altezzaTotale),Image.SCALE_DEFAULT);
			ImageIcon imageEast = new ImageIcon(newImage);
			
			imageIcon = new ImageIcon("img\\Gameboard\\SpaziMercato\\3\\west.png");
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaWest)/larghezzaTotale),((int)(altezzaSchermo*altezzaCenter)/altezzaTotale),Image.SCALE_DEFAULT);
			ImageIcon imageWest = new ImageIcon(newImage);
			
			imageIcon = new ImageIcon("img\\Gameboard\\SpaziMercato\\3\\center.png");
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaCenter)/larghezzaTotale),((int)(altezzaSchermo*altezzaCenter)/altezzaTotale),Image.SCALE_DEFAULT);
			ImageIcon imageCenter = new ImageIcon(newImage);
			
			imageIcon = new ImageIcon(path);
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
			
			buttonFamiliare = new ButtonTransparent("spazioMercato3",160,160,listener);
			
			labelCenter.add(buttonFamiliare,gbc);
			
			this.add(labelNorth, BorderLayout.NORTH);
			this.add(labelEast, BorderLayout.EAST);
			this.add(labelWest, BorderLayout.WEST);
			this.add(labelSouth, BorderLayout.SOUTH);
			this.add(labelCenter, BorderLayout.CENTER);	
		}
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