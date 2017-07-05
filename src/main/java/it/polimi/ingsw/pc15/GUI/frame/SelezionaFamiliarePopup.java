package it.polimi.ingsw.pc15.GUI.frame;

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

import it.polimi.ingsw.pc15.GUI.ButtonListener;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Player;

public class SelezionaFamiliarePopup extends JFrame{
	
	private JLabel north;
	private JLabel south;
	private JButton buttonNero;
	private JButton buttonBianco;
	private JButton buttonArancione;
	private JButton buttonNeutro;
	private JPanel panelCentrale;
	
	transient ImageIcon imageIcon;
	transient Image image, newImage;
	
	private int altezzaBackground;
	private int larghezzaBackground;
	
	private int larghezzaFamiliare;
	private int altezzaFamiliare;
	
	private String pathNero;
	private String pathBianco;
	private String pathArancione;
	private String pathNeutro;
	
	public SelezionaFamiliarePopup(ButtonListener listener, Player player) {
		
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
		
		String colorePlayer = player.getColore().toString().toLowerCase();
		
		pathNero = "img/Punchboard/familiari/pedineFamiliari/"+colorePlayer+"/nero.png";
		imageIcon = new ImageIcon(pathNero);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaFamiliare,altezzaFamiliare,Image.SCALE_DEFAULT);
		ImageIcon imageFamiliareNero = new ImageIcon(newImage);
		
		pathBianco = "img/Punchboard/familiari/pedineFamiliari/"+colorePlayer+"/bianco.png";
		imageIcon = new ImageIcon(pathBianco);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaFamiliare,altezzaFamiliare,Image.SCALE_DEFAULT);
		ImageIcon imageFamiliareBianco = new ImageIcon(newImage);
		
		pathArancione = "img/Punchboard/familiari/pedineFamiliari/"+colorePlayer+"/arancione.png";
		imageIcon = new ImageIcon(pathArancione);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaFamiliare,altezzaFamiliare,Image.SCALE_DEFAULT);
		ImageIcon imageFamiliareArancione = new ImageIcon(newImage);
		
		pathNeutro = "img/Punchboard/familiari/pedineFamiliari/"+colorePlayer+"/neutro.png";
		imageIcon = new ImageIcon(pathNeutro);
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

		if(!player.getFamiliare(ColoreFamiliare.NERO).disponibile())
			buttonNero.setEnabled(false);
		if(!player.getFamiliare(ColoreFamiliare.BIANCO).disponibile())
			buttonBianco.setEnabled(false);
		if(!player.getFamiliare(ColoreFamiliare.ARANCIONE).disponibile())
			buttonArancione.setEnabled(false);
		if(!player.getFamiliare(ColoreFamiliare.NEUTRO).disponibile())
			buttonNeutro.setEnabled(false);
		
		this.setSize(larghezzaBackground,altezzaBackground);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
	}
	
	public String readPath(ColoreFamiliare colore) {
		
		String path=null;
		
		switch(colore) {
		case NERO:
			path = pathNero;
			break;
		case BIANCO:
			path = pathBianco;
			break;
		case ARANCIONE:
			path = pathArancione;
			break;
		case NEUTRO:
			path = pathNeutro;
			break;
		}
		
		return path;
	}
	
}
