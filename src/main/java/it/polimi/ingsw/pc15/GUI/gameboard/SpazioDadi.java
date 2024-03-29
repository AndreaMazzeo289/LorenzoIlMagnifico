package it.polimi.ingsw.pc15.GUI.gameboard;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.polimi.ingsw.pc15.GUI.GUI;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;

/**
 * Classe che gestisce la visualizzazione dello spazio riservato ai dadi nella gameboard
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 * 
 */
public class SpazioDadi extends JPanel{

	private JLabel dadoNero;
	private JLabel dadoArancione;
	private JLabel dadoBianco;
	private JLabel labelSouth;
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	transient ImageIcon imageIcon;
	transient Image image, newImage;
	
	private int altezzaSchermo;
	private int larghezzaSchermo;
	private int altezzaTotale;
	private int larghezzaTotale;
	
	private float rapporto;
	
	private int altezza;
	private int larghezzaNero;
	private int larghezzaBianco;
	private int larghezzaArancione;
	private int altezzaSouth;
	private int larghezza;
	private transient GUI gui;
	
	public SpazioDadi(GUI gui) {
		
		this.gui = gui;
		larghezzaTotale = gui.larghezzaTotale;
		altezzaTotale =  gui.altezzaTotale;
		rapporto = gui.rapporto;
		
		altezzaSchermo = (int)screenSize.getHeight();
		larghezzaSchermo = (int)(((float)screenSize.getWidth())*rapporto);
		
		altezza = 326;
		larghezzaNero = 720;//704
		larghezzaBianco = 457;//452
		larghezzaArancione = 878;//878
		altezzaSouth = 145;
		larghezza = larghezzaNero+larghezzaBianco+larghezzaArancione;

		dadoNero = new JLabel();
		dadoArancione  = new JLabel();
		dadoBianco  = new JLabel();
		labelSouth = new JLabel();
		
		this.setLayout(new BorderLayout());
		
		imageIcon = new ImageIcon("img/Gameboard/dadi/nero/nero_2.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaNero)/larghezzaTotale),((int)(altezzaSchermo*altezza)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageDadoNero = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img/Gameboard/dadi/bianco/bianco_5.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaBianco)/larghezzaTotale),((int)(altezzaSchermo*altezza)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageDadoBianco = new ImageIcon(newImage);
		
		if(gui.getNumeroGiocatori()<4)
			imageIcon = new ImageIcon("img/Gameboard/dadi/arancione/arancione_3_no4.png");
		else
			imageIcon = new ImageIcon("img/Gameboard/dadi/arancione/arancione_3.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaArancione)/larghezzaTotale),((int)(altezzaSchermo*altezza)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageDadoArancione = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img/Gameboard/dadi/south.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezza)/larghezzaTotale),((int)(altezzaSchermo*altezzaSouth)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageSouth = new ImageIcon(newImage);
		
		dadoNero.setIcon(imageDadoNero);
		dadoBianco.setIcon(imageDadoBianco);
		dadoArancione.setIcon(imageDadoArancione);
		labelSouth.setIcon(imageSouth);
		
		this.add(dadoNero, BorderLayout.WEST);
		this.add(dadoBianco, BorderLayout.CENTER);
		this.add(dadoArancione, BorderLayout.EAST);
		this.add(labelSouth, BorderLayout.SOUTH);
	}
	
	/**
	 * metodo che permette di modificare le immagini riguardanti i dadi
	 * verrà chiamato ogni cambio di turno in occasione del rilancio dei dadi
	 * @param coloreFamiliare per indicare quale dado si vuole modificare
	 * @param valoreDado per indicare quale è il nuovo valore del dado
	 * in funzione di questi due parametri il metodo caricherà l'immagine corretta
	 */
	public void modificaImmagineDadi(ColoreFamiliare coloreFamiliare, int valoreDado) {
		
		String path = "img/Gameboard/dadi/";
		int larghezza=0;
		JLabel dadoDaModificare = dadoBianco;
		
		switch(coloreFamiliare) {
		case NERO:
			path+="nero/nero_"+valoreDado+".png";
			larghezza = larghezzaNero;
			dadoDaModificare = dadoNero;
			break;
		case BIANCO:
			path+="bianco/bianco_"+valoreDado+".png";
			larghezza = larghezzaBianco;
			dadoDaModificare = dadoBianco;
			break;
		case ARANCIONE:
			path+="arancione/arancione_"+valoreDado+"";
			if(gui.getNumeroGiocatori()<4)
				path+="_no4.png";
			else
				path+=".png";
			larghezza = larghezzaArancione;
			dadoDaModificare = dadoArancione;
			break;
		}
		
		imageIcon = new ImageIcon(path);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezza)/larghezzaTotale),((int)(altezzaSchermo*altezza)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageToSet = new ImageIcon(newImage);
		dadoDaModificare.setIcon(imageToSet);
	}
}
