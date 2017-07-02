package it.polimi.ingsw.pc15.GUI.playerboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import it.polimi.ingsw.pc15.GUI.mainGUI;

public class PanelRisorse extends JPanel{

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	private JLabel labelCenter;
	private JLabel labelNorth;
	private JLabel labelSouth;
	
	private int altezzaSchermo;
	private int larghezzaSchermo;
	
	private int altezzaCenter;
	private int altezzaNorth;
	private int altezzaSouth;
	private int larghezzaBlocco;
	private float rapporto;
	private int larghezzaTotale;
	private int altezzaTotale;
	
	transient ImageIcon imageIcon;
	transient Image image, newImage;
	
	public PanelRisorse(String path, int value){
		
		larghezzaTotale = mainGUI.larghezzaTotale;
		altezzaTotale =  mainGUI.altezzaTotale;
		rapporto = mainGUI.rapportoPlayerBoard;
		
		altezzaSchermo = (int)screenSize.getHeight();
		larghezzaSchermo = (int)(((float)screenSize.getWidth())*rapporto);
		
		altezzaCenter = 150;
		altezzaNorth = 375;
		altezzaSouth = 175;
		larghezzaBlocco = 450;
		
		larghezzaTotale = 4076;
		altezzaTotale = 6530;
		
		this.setLayout(new BorderLayout());
		
		labelNorth = new JLabel();
		labelCenter = new JLabel(Integer.toString(value), SwingConstants.CENTER);
		labelSouth = new JLabel();
		
		imageIcon = new ImageIcon(path);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaBlocco)/larghezzaTotale),((int)(altezzaSchermo*altezzaNorth)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageNorth = new ImageIcon(newImage);
		
		labelCenter.setFont(new Font("TimesRoman", Font.BOLD, 17)); 
		labelCenter.setOpaque(true);
		labelCenter.setBackground(Color.decode("15394527"));
		
		imageIcon = new ImageIcon("img\\Punchboard\\Risorse\\south.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaBlocco)/larghezzaTotale),((int)(altezzaSchermo*altezzaSouth)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageSouth = new ImageIcon(newImage);
		
		labelNorth.setIcon(imageNorth);
		labelSouth.setIcon(imageSouth);
		
		this.add(labelNorth, BorderLayout.NORTH);
		this.add(labelCenter, BorderLayout.CENTER);
		this.add(labelSouth, BorderLayout.SOUTH);
		
	}
	
	public void writeIntoLabel (int numero) {
		labelCenter.setText(Integer.toString(numero));
	}
	
}
