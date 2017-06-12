package it.polimi.ingsw.pc15.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelezionaFamiliarePopup extends JFrame{

	JLabel labelNorth;
	JLabel labelEast;
	JLabel labelWest;
	JLabel labelCenter;
	JLabel labelSouth;
	
	JPanel panelCentrale;
	
	JButton labelFamBianco;
	JButton labelFamArancione;
	JButton labelFamNero;
	JButton labelFamNeutro;
	
	ImageIcon imageIcon;
	Image image, newImage;
	
	int altezzaECW;
	int altezzaN;
	int larghezzaFamBianco;
	int larghezzaFamArancione;
	int larghezzaFamNero;
	int larghezzaFamNeutro;	
	int larghezzaW;
	int larghezzaE;
	int larghezzaC;
	int larghezzaN;
	int larghezzaS;
	int altezzaS;
	int larghezzaTotale;
	int altezzaTotale;
	
	public SelezionaFamiliarePopup(ButtonListener listener) {
		
		altezzaECW = 330;//303
		altezzaN = 200;
		larghezzaFamBianco = 198;
		larghezzaFamArancione = 207;
		larghezzaFamNero = 208;
		larghezzaFamNeutro = 196;	
		larghezzaW = 52;
		larghezzaE = 63;
		larghezzaC = larghezzaFamBianco+larghezzaFamArancione+larghezzaFamNero+larghezzaFamNeutro;
		larghezzaN = larghezzaW+larghezzaE+larghezzaC; //686
		larghezzaS = larghezzaN;
		altezzaS = 197;
		larghezzaTotale = larghezzaC+larghezzaW+larghezzaE;
		altezzaTotale = altezzaN+altezzaECW+altezzaS;
		
		this.getContentPane().setLayout(new BorderLayout());
		
		this.setSize(1000,1000);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		
		labelNorth = new JLabel();
		labelEast = new JLabel();
		labelWest = new JLabel();
		labelCenter = new JLabel();
		labelSouth = new JLabel();
		
		imageIcon = new ImageIcon("img\\Punchboard\\familiari\\north.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaN,altezzaN,Image.SCALE_DEFAULT);
		ImageIcon imageNorth = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Punchboard\\familiari\\east.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaE,altezzaECW,Image.SCALE_DEFAULT);
		ImageIcon imageEast = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Punchboard\\familiari\\west.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaW,altezzaECW,Image.SCALE_DEFAULT);
		ImageIcon imageWest = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Punchboard\\familiari\\familareBianco.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaFamBianco,altezzaECW,Image.SCALE_DEFAULT);
		ImageIcon imageFamiliareBianco = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Punchboard\\familiari\\familareArancione.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaFamArancione,altezzaECW,Image.SCALE_DEFAULT);
		ImageIcon imageFamiliareArancione = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Punchboard\\familiari\\familiareNero.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaFamNero,altezzaECW,Image.SCALE_DEFAULT);
		ImageIcon imageFamiliareNero = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Punchboard\\familiari\\familiareNeutro.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaFamNeutro,altezzaECW,Image.SCALE_DEFAULT);
		ImageIcon imageFamiliareNeutro = new ImageIcon(newImage);
		
		panelCentrale = new JPanel (new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		labelFamBianco = new JButton();
		labelFamArancione = new JButton();
		labelFamNero = new JButton();
		labelFamNeutro = new JButton();
		
		labelFamBianco.setBorder(null);
		labelFamArancione.setBorder(null);
		labelFamNero.setBorder(null);
		labelFamNeutro.setBorder(null);
		
		labelFamBianco.setActionCommand("selezionatoFamiliareBianco");
		labelFamArancione.setActionCommand("selezionatoFamiliareArancione");
		labelFamNero.setActionCommand("selezionatoFamiliareNero");
		labelFamNeutro.setActionCommand("selezionatoFamiliareNeutro");
		
		labelFamBianco.addActionListener(listener);
		labelFamArancione.addActionListener(listener);
		labelFamNero.addActionListener(listener);
		labelFamNeutro.addActionListener(listener);
		
		labelFamBianco.setIcon(imageFamiliareBianco);
		labelFamArancione.setIcon(imageFamiliareArancione);
		labelFamNero.setIcon(imageFamiliareNero);
		labelFamNeutro.setIcon(imageFamiliareNeutro);
		
		gbc.gridx=0;
		gbc.gridy=0;
		panelCentrale.add(labelFamBianco,gbc);
		gbc.gridx=1;
		panelCentrale.add(labelFamArancione,gbc);
		gbc.gridx=2;
		panelCentrale.add(labelFamNero,gbc);
		gbc.gridx=3;
		panelCentrale.add(labelFamNeutro,gbc);
		
		imageIcon = new ImageIcon("img\\Punchboard\\familiari\\south.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaS,altezzaS,Image.SCALE_DEFAULT);
		ImageIcon imageSouth = new ImageIcon(newImage);
		
		labelNorth.setIcon(imageNorth);
		labelEast.setIcon(imageEast);
		labelWest.setIcon(imageWest);
		labelSouth.setIcon(imageSouth);
		
		this.add(labelNorth, BorderLayout.NORTH);
		this.add(labelEast, BorderLayout.EAST);
		this.add(labelWest, BorderLayout.WEST);
		this.add(panelCentrale, BorderLayout.CENTER);
		this.add(labelSouth, BorderLayout.SOUTH);
		
		this.setSize(larghezzaTotale,altezzaTotale);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
	}
	
}
