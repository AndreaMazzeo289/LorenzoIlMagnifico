package it.polimi.ingsw.pc15.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FamiliariDisponibili extends JPanel{

	JLabel labelNorth;
	JLabel labelEast;
	JLabel labelWest;
	JLabel labelCenter;
	JLabel labelSouth;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public FamiliariDisponibili() {
		
		int altezzaSchermo = (int)screenSize.getHeight();
		int larghezzaSchermo = (int)screenSize.getWidth()/2;
		
		this.setLayout(new BorderLayout());
		
		int altezzaECW = 225;
		int altezzaN = 108;
		int larghezzaFamBianco = 157;
		int larghezzaFamArancione = 166;
		int larghezzaFamNero = 162;
		int larghezzaFamNeutro = 155;	
		int larghezzaW = 24;
		int larghezzaE = 22;
		int larghezzaC = larghezzaFamBianco+larghezzaFamArancione+larghezzaFamNero+larghezzaFamNeutro;
		int larghezzaN = larghezzaW+larghezzaE+larghezzaC; //686
		int larghezzaS = larghezzaN;
		int altezzaS = 167;
		int larghezzaTotale = 4076;
		int altezzaTotale = 6420;
		
		labelNorth = new JLabel();
		labelEast = new JLabel();
		labelWest = new JLabel();
		labelCenter = new JLabel();
		labelSouth = new JLabel();
		
		ImageIcon imageIcon;
		Image image, newImage;
		
		imageIcon = new ImageIcon("img\\Punchboard\\familiari\\north.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaN)/larghezzaTotale),((int)(altezzaSchermo*altezzaN)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageNorth = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Punchboard\\familiari\\east.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaE)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageEast = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Punchboard\\familiari\\west.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaW)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageWest = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Punchboard\\familiari\\familareBianco.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaFamBianco)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageFamiliareBianco = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Punchboard\\familiari\\familareArancione.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaFamArancione)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageFamiliareArancione = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Punchboard\\familiari\\familiareNero.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaFamNero)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageFamiliareNero = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Punchboard\\familiari\\familiareNeutro.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaFamNeutro)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageFamiliareNeutro = new ImageIcon(newImage);
		
		JPanel panelCentrale = new JPanel (new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel labelFamBianco = new JLabel();
		JLabel labelFamArancione = new JLabel();
		JLabel labelFamNero = new JLabel();
		JLabel labelFamNeutro = new JLabel();
		
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
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaS)/larghezzaTotale),((int)(altezzaSchermo*altezzaS)/altezzaTotale),Image.SCALE_DEFAULT);
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
	}
}
