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

import it.polimi.ingsw.pc15.player.ColoreFamiliare;

public class FamiliariDisponibili extends JPanel{

	JLabel labelNorth;
	JLabel labelEast;
	JLabel labelWest;
	JLabel labelCenter;
	JLabel labelSouth;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	JPanel panelCentrale;
	
	JLabel labelFamBianco;
	JLabel labelFamArancione;
	JLabel labelFamNero;
	JLabel labelFamNeutro;
	
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
	int larghezzaN; //686
	int larghezzaS;
	int altezzaS;
	int larghezzaTotale;
	int altezzaTotale;
	float rapporto;
	int altezzaSchermo;
	int larghezzaSchermo;
	
	public FamiliariDisponibili() {
		
		larghezzaTotale = mainGUI.larghezzaTotale;
		altezzaTotale =  mainGUI.altezzaTotale;
		rapporto = mainGUI.rapportoPlayerBoard;
		
		altezzaSchermo = (int)screenSize.getHeight();
		larghezzaSchermo = (int)(((float)screenSize.getWidth())*rapporto);
		
		this.setLayout(new BorderLayout());
		
		altezzaECW = 303;
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
		
		labelNorth = new JLabel();
		labelEast = new JLabel();
		labelWest = new JLabel();
		labelCenter = new JLabel();
		labelSouth = new JLabel();
		
		
		
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
		
		panelCentrale = new JPanel (new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		labelFamBianco = new JLabel();
		labelFamArancione = new JLabel();
		labelFamNero = new JLabel();
		labelFamNeutro = new JLabel();
		
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
	
	public JLabel getLabelFamiliareBianco() {
		return (JLabel)this.panelCentrale.getComponent(0);
	}
	
	public JLabel getLabelFamiliareArancione() {
		return (JLabel)this.panelCentrale.getComponent(1);
	}
	
	public JLabel getLabelFamiliareNero() {
		return (JLabel)this.panelCentrale.getComponent(2);
	}
	
	public JLabel getLabelFamiliareNeutro() {
		return (JLabel)this.panelCentrale.getComponent(3);
	}
	
	public void utilizzaFamiliare(ColoreFamiliare coloreFamiliare){
		
		switch(coloreFamiliare){
		case NERO:
			
			imageIcon = new ImageIcon("img\\Punchboard\\familiari\\familiareNeroOcc.png");
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaFamNero)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
			ImageIcon imageFamiliareNero = new ImageIcon(newImage);
			labelFamNero.setIcon(imageFamiliareNero);
			break;
			
		case BIANCO:
			
			imageIcon = new ImageIcon("img\\Punchboard\\familiari\\familiareBiancoOcc.png");
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaFamBianco)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
			ImageIcon imageFamiliareBianco = new ImageIcon(newImage);
			labelFamBianco.setIcon(imageFamiliareBianco);
			break;
			
		case ARANCIONE:
			
			imageIcon = new ImageIcon("img\\Punchboard\\familiari\\familiareArancioneOcc.png");
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaFamArancione)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
			ImageIcon imageFamiliareArancione = new ImageIcon(newImage);
			labelFamArancione.setIcon(imageFamiliareArancione);
			break;
			
		case NEUTRO:
			
			imageIcon = new ImageIcon("img\\Punchboard\\familiari\\familiareNeutroOcc.png");
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaFamNeutro)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
			ImageIcon imageFamiliareNeutro = new ImageIcon(newImage);
			labelFamNeutro.setIcon(imageFamiliareNeutro);
			break;
			
		}
	}
	
	public void liberaFamiliare(ColoreFamiliare coloreFamiliare){
		
		switch(coloreFamiliare){
		case NERO:
			
			imageIcon = new ImageIcon("img\\Punchboard\\familiari\\familiareNero.png");
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaFamNero)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
			ImageIcon imageFamiliareNero = new ImageIcon(newImage);
			labelFamNero.setIcon(imageFamiliareNero);
			break;
			
		case BIANCO:
			
			imageIcon = new ImageIcon("img\\Punchboard\\familiari\\familiareBianco.png");
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaFamBianco)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
			ImageIcon imageFamiliareBianco = new ImageIcon(newImage);
			labelFamBianco.setIcon(imageFamiliareBianco);
			break;
			
		case ARANCIONE:
			
			imageIcon = new ImageIcon("img\\Punchboard\\familiari\\familiareArancione.png");
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaFamArancione)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
			ImageIcon imageFamiliareArancione = new ImageIcon(newImage);
			labelFamArancione.setIcon(imageFamiliareArancione);
			break;
			
		case NEUTRO:
			
			imageIcon = new ImageIcon("img\\Punchboard\\familiari\\familiareNeutro.png");
			image = imageIcon.getImage();
			newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaFamNeutro)/larghezzaTotale),((int)(altezzaSchermo*altezzaECW)/altezzaTotale),Image.SCALE_DEFAULT);
			ImageIcon imageFamiliareNeutro = new ImageIcon(newImage);
			labelFamNeutro.setIcon(imageFamiliareNeutro);
			break;
			
		}
	}
}
