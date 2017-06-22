package it.polimi.ingsw.pc15.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelezionaFamiliarePopup extends JFrame{
	
	JLabel north;
	JLabel south;
	JButton buttonNero;
	JButton buttonBianco;
	JButton buttonArancione;
	JButton buttonNeutro;
	JPanel	 panelCentrale;
	
	ImageIcon imageIcon;
	Image image, newImage;
	
	int altezzaBackground;
	int larghezzaBackground;
	
	int larghezzaFamiliare;
	int altezzaFamiliare;
	
	public SelezionaFamiliarePopup(ButtonListener listener) {
		
		this.setLayout(new BorderLayout());
		
		altezzaBackground=400;
		larghezzaBackground=900;
		
		larghezzaFamiliare = 200;
		altezzaFamiliare= 200;
	
		north = new JLabel();
		south = new JLabel();
		buttonNero = new JButton();
		buttonBianco = new JButton();
		buttonArancione = new JButton();
		buttonNeutro = new JButton();
		
		imageIcon = new ImageIcon("img/Punchboard/familiari/pedineFamiliari/blu/nero.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaFamiliare,altezzaFamiliare,Image.SCALE_DEFAULT);
		ImageIcon imageFamiliareNero = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img/Punchboard/familiari/pedineFamiliari/blu/bianco.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaFamiliare,altezzaFamiliare,Image.SCALE_DEFAULT);
		ImageIcon imageFamiliareBianco = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img/Punchboard/familiari/pedineFamiliari/blu/arancione.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaFamiliare,altezzaFamiliare,Image.SCALE_DEFAULT);
		ImageIcon imageFamiliareArancione = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaFamiliare,altezzaFamiliare,Image.SCALE_DEFAULT);
		ImageIcon imageFamiliareNeutro = new ImageIcon(newImage);
		
		Dimension dimension = new Dimension(325,325);
		Dimension dimensionButton = new Dimension(250,250);
		
		north.setMinimumSize(dimension);
		south.setMinimumSize(dimension);
		
		panelCentrale = new JPanel ();
		panelCentrale.setLayout(new GridLayout(1,4));
		
		buttonBianco.setBorder(null);
		buttonArancione.setBorder(null);
		buttonNero.setBorder(null);
		buttonNeutro.setBorder(null);
		
		buttonBianco.setMaximumSize(dimensionButton);
		buttonArancione.setMaximumSize(dimensionButton);
		buttonNero.setMaximumSize(dimensionButton);
		buttonNeutro.setMaximumSize(dimensionButton);
		
		buttonBianco.setActionCommand("selezionatoFamiliareBianco");
		buttonArancione.setActionCommand("selezionatoFamiliareArancione");
		buttonNero.setActionCommand("selezionatoFamiliareNero");
		buttonNeutro.setActionCommand("selezionatoFamiliareNeutro");
		
		buttonBianco.setIcon(imageFamiliareBianco);
		buttonArancione.setIcon(imageFamiliareArancione);
		buttonNero.setIcon(imageFamiliareNero);
		buttonNeutro.setIcon(imageFamiliareNeutro);
		
		panelCentrale.add(buttonNero);
		panelCentrale.add(buttonBianco);
		panelCentrale.add(buttonArancione);
		panelCentrale.add(buttonNeutro);
		
		panelCentrale.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
		panelCentrale.setAlignmentY(java.awt.Component.CENTER_ALIGNMENT);

		this.add(north, BorderLayout.NORTH);
		this.add(south, BorderLayout.SOUTH);
		this.add(panelCentrale, BorderLayout.CENTER);

		buttonBianco.addActionListener(listener);
		buttonArancione.addActionListener(listener);
		buttonNero.addActionListener(listener);
		buttonNeutro.addActionListener(listener);

		this.setSize(larghezzaBackground,altezzaBackground);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
	}
	
}
