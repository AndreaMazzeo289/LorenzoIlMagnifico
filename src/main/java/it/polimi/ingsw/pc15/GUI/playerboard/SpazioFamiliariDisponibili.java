package it.polimi.ingsw.pc15.GUI.playerboard;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.polimi.ingsw.pc15.GUI.GUI;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;

public class SpazioFamiliariDisponibili extends JPanel implements Serializable{

	private JLabel background;
	private JLabel labelNero;
	private JLabel labelBianco;
	private JLabel labelArancione;
	private JLabel labelNeutro;
	private JLabel panelCentrale;
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	transient ImageIcon imageIcon;
	transient Image image, newImage;
	
	private int altezzaBackground;
	private int larghezzaBackground;
	
	private int larghezzaFamiliare;
	private int altezzaFamiliare;
	
	private int larghezzaTotale;
	private int altezzaTotale;
	private float rapporto;
	private int altezzaSchermo;
	private int larghezzaSchermo;
	
	public SpazioFamiliariDisponibili(GUI gui) {
		
		larghezzaTotale = gui.larghezzaTotale;
		altezzaTotale =  gui.altezzaTotale;
		rapporto = gui.rapportoPlayerBoard;
		
		altezzaSchermo = (int)screenSize.getHeight();
		larghezzaSchermo = (int)(((float)screenSize.getWidth())*rapporto);
		
		this.setLayout(new BorderLayout());
		
		altezzaBackground=700;
		larghezzaBackground=1080;
		
		larghezzaFamiliare = 198;
		altezzaFamiliare= 198;
		
		background = new JLabel();
		labelNero = new JLabel();
		labelBianco = new JLabel();
		labelArancione = new JLabel();
		labelNeutro = new JLabel();

		imageIcon = new ImageIcon("img/Punchboard/familiari/background.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaBackground)/larghezzaTotale),((int)(altezzaSchermo*altezzaBackground)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageBackground = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img/Punchboard/familiari/pedineFamiliari/blu/nero.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaFamiliare)/larghezzaTotale),((int)(altezzaSchermo*altezzaFamiliare)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageFamiliareNero = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img/Punchboard/familiari/pedineFamiliari/blu/bianco.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaFamiliare)/larghezzaTotale),((int)(altezzaSchermo*altezzaFamiliare)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageFamiliareBianco = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img/Punchboard/familiari/pedineFamiliari/blu/arancione.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaFamiliare)/larghezzaTotale),((int)(altezzaSchermo*altezzaFamiliare)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageFamiliareArancione = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaFamiliare)/larghezzaTotale),((int)(altezzaSchermo*altezzaFamiliare)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageFamiliareNeutro = new ImageIcon(newImage);
		
		panelCentrale = new JLabel ();
		panelCentrale.setLayout(new GridLayout(1,4));
		
		labelBianco.setIcon(imageFamiliareBianco);
		labelArancione.setIcon(imageFamiliareArancione);
		labelNero.setIcon(imageFamiliareNero);
		labelNeutro.setIcon(imageFamiliareNeutro);
		
		panelCentrale.add(labelNero);
		panelCentrale.add(labelBianco);
		panelCentrale.add(labelArancione);
		panelCentrale.add(labelNeutro);
		
		background.setIcon(imageBackground);
		background.setLayout(new BorderLayout());
		panelCentrale.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
		panelCentrale.setAlignmentY(java.awt.Component.CENTER_ALIGNMENT);
		background.add(panelCentrale, BorderLayout.CENTER);

		this.add(background, BorderLayout.CENTER);
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
		
		imageIcon = new ImageIcon("img\\Punchboard\\familiari\\pedineFamiliari\\familiareOccupato.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaFamiliare)/larghezzaTotale),((int)(altezzaSchermo*altezzaFamiliare)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageFamiliareOccupato = new ImageIcon(newImage);
		
		switch(coloreFamiliare){
		case NERO:
			labelNero.setIcon(imageFamiliareOccupato);
			break;
		case BIANCO:
			labelBianco.setIcon(imageFamiliareOccupato);
			break;
		case ARANCIONE:
			labelArancione.setIcon(imageFamiliareOccupato);
			break;
		case NEUTRO:
			labelNeutro.setIcon(imageFamiliareOccupato);
			break;
		}
	}
	
	public void liberaFamiliare(ColoreFamiliare coloreFamiliare){
		
		JLabel labelColore = null;
		
		switch(coloreFamiliare){
		case NERO:
			imageIcon = new ImageIcon("img\\Punchboard\\familiari\\pedineFamiliari\\blu\\nero.png");
			labelColore = labelNero;
			break;
		case BIANCO:		
			imageIcon = new ImageIcon("img\\Punchboard\\familiari\\pedineFamiliari\\blu\\bianco.png");
			labelColore = labelBianco;
			break;
		case ARANCIONE:
			imageIcon = new ImageIcon("img\\Punchboard\\familiari\\pedineFamiliari\\blu\\arancione.png");
			labelColore = labelArancione;
			break;
		case NEUTRO:
			imageIcon = new ImageIcon("img\\Punchboard\\familiari\\pedineFamiliari\\blu\\neutro.png");
			labelColore = labelNeutro;
			break;
		}
		
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaFamiliare)/larghezzaTotale),((int)(altezzaSchermo*altezzaFamiliare)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageFamiliare = new ImageIcon(newImage);
		labelColore.setIcon(imageFamiliare);
	}
}
