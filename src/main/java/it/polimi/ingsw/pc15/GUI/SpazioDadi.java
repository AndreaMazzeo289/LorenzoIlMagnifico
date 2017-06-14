package it.polimi.ingsw.pc15.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SpazioDadi extends JPanel{

	JLabel dadoNero;
	JLabel dadoArancione;
	JLabel dadoBianco;
	JLabel labelSouth;
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	ImageIcon imageIcon;
	Image image, newImage;
	
	int altezzaSchermo;
	int larghezzaSchermo;
	int altezzaTotale;
	int larghezzaTotale;
	
	float rapporto;
	
	public SpazioDadi() {
		
		larghezzaTotale = mainGUI.larghezzaTotale;
		altezzaTotale =  mainGUI.altezzaTotale;
		rapporto = mainGUI.rapporto;
		
		altezzaSchermo = (int)screenSize.getHeight();
		larghezzaSchermo = (int)(((float)screenSize.getWidth())*rapporto);
		
		//larghezzaSchermo = (int)screenSize.getWidth()/2;
		
		int altezza = 326;
		int larghezzaNero = 720;//704
		int larghezzaBianco = 457;//452
		int larghezzaArancione = 878;//878
		int altezzaS = 145;
		int larghezzaS = larghezzaNero+larghezzaBianco+larghezzaArancione;
		System.out.println("larghezza dadi: "+larghezzaS);
		dadoNero = new JLabel();
		dadoArancione  = new JLabel();
		dadoBianco  = new JLabel();
		labelSouth = new JLabel();
		
		this.setLayout(new BorderLayout());
		
		imageIcon = new ImageIcon("img\\Gameboard\\dadi\\nero\\nero_2.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaNero)/larghezzaTotale),((int)(altezzaSchermo*altezza)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageDadoNero = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\dadi\\bianco\\bianco_5.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaBianco)/larghezzaTotale),((int)(altezzaSchermo*altezza)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageDadoBianco = new ImageIcon(newImage);
		
		if(mainGUI.numeroGiocatori<4)
			imageIcon = new ImageIcon("img\\Gameboard\\dadi\\arancione\\arancione_3_no4.png");
		else
			imageIcon = new ImageIcon("img\\Gameboard\\dadi\\arancione\\arancione_3.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaArancione)/larghezzaTotale),((int)(altezzaSchermo*altezza)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageDadoArancione = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon("img\\Gameboard\\dadi\\south.png");
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezzaS)/larghezzaTotale),((int)(altezzaSchermo*altezzaS)/altezzaTotale),Image.SCALE_DEFAULT);
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
	
}
