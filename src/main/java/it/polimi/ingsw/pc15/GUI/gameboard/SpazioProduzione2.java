package it.polimi.ingsw.pc15.GUI.gameboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.polimi.ingsw.pc15.GUI.GUI;

public class SpazioProduzione2 extends JPanel{

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
	
	public SpazioProduzione2(ActionListener listener, GUI gui) {
		
		larghezzaTotale = gui.larghezzaTotale;
		altezzaTotale =  gui.altezzaTotale;
		rapporto = gui.rapporto;
		
		altezzaSchermo = (int)screenSize.getHeight();
		larghezzaSchermo = (int)(((float)screenSize.getWidth())*rapporto);
		
		this.setLayout(new BorderLayout());
		
		altezzaCenter= 170;
		altezzaNorth = 487;
		altezzaSouth = 200;
		larghezzaWest= 158;
		larghezzaEast = 512;
		larghezzaCenter = 820;
		larghezza = larghezzaWest+larghezzaEast+larghezzaCenter;
		
		labelNorth = new JLabel();
		labelEast = new JLabel();
		labelWest = new JLabel();
		labelSouth = new JLabel();
		labelCenter = new JLabel();
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziProduzione\\2\\north.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezza)/larghezzaTotale),((int)(altezzaSchermo*altezzaNorth)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageNorth = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziProduzione\\2\\east.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaEast)/larghezzaTotale),((int)(altezzaSchermo*altezzaCenter)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageEast = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziProduzione\\2\\west.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaWest)/larghezzaTotale),((int)(altezzaSchermo*altezzaCenter)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageWest = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziProduzione\\2\\center.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaCenter)/larghezzaTotale),((int)(altezzaSchermo*altezzaCenter)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageCenter = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\SpaziProduzione\\2\\south.png");
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
			button.add(new ButtonTransparent("SpazioProduzionePosizione"+i,100,85,listener));
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
	}
	
	public void inserisciFamiliare(String path, ButtonTransparent button) {
		imageIcon = new ImageIcon(path);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*102)/larghezzaTotale),((int)(altezzaSchermo*85)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageButton = new ImageIcon(newImage);
		
		button.setIcon(imageButton);
		button.setBorder(null);
	}
	
	public ButtonTransparent getButton(int posizione) {
		return button.get(posizione);
	}
	
	
}
