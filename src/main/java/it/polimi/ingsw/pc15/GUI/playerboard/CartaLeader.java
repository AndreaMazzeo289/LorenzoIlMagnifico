package it.polimi.ingsw.pc15.GUI.playerboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.polimi.ingsw.pc15.GUI.ButtonListenerCarte;
import it.polimi.ingsw.pc15.GUI.GUI;

public class CartaLeader extends JPanel{

	private JButton carta;
	private JLabel stato;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private String textLabel;
	
	private int altezzaTotale;
	private int larghezzaTotale;
	private float rapporto;
	private int altezzaSchermo;
	private int larghezzaSchermo;
	
	private String path;
	private String name;
	
	transient ImageIcon imageIcon;
	transient Image image, newImage;
	
	private int altezza;
	private int larghezza;
	
	public CartaLeader(String path, String name, GUI gui) {
		
		this.path = path;
		this.name = name;
		
		this.setLayout(new BorderLayout());
		
		textLabel = "NON GIOCATO";
		
		larghezzaTotale = gui.larghezzaTotale;
		altezzaTotale =  gui.altezzaTotale;
		rapporto = gui.rapportoPlayerBoard;
		
		altezzaSchermo = (int)screenSize.getHeight();
		larghezzaSchermo = (int)(((float)screenSize.getWidth())*rapporto);
		
		altezza = 1000;
		larghezza = 350;
		
		/*int larghezzaTotale = 4076;
		int altezzaTotale = 6530;*/
		
		carta = new JButton();
		stato = new JLabel();
		
		imageIcon = new ImageIcon(path);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezza)/larghezzaTotale),((int)(altezzaSchermo*altezza)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageAll = new ImageIcon(newImage);
	
		carta.setActionCommand(path+"-"+name);
		carta.setIcon(imageAll);
		carta.setPreferredSize(new Dimension(larghezza,altezza));
		carta.setBackground(Color.decode("15394527"));
		carta.addActionListener(new ButtonListenerCarte(gui));
		
		Dimension dimensione = new Dimension(((int)(larghezzaSchermo*350)/larghezzaTotale),((int)(altezzaSchermo*100)/altezzaTotale));
		stato.setMinimumSize(dimensione);
		stato.setOpaque(true);
		stato.setBackground(Color.decode("15394527"));
		stato.setText("       NON GIOCATO");
		
		//this.add(carta, BorderLayout.CENTER);
		
		
		this.add(carta,BorderLayout.CENTER);
		this.add(stato, BorderLayout.SOUTH);
	}
	
	public void scriviLabel(String text) {
		String testo = "            "+text;
		Dimension dimensione = new Dimension(((int)(larghezzaSchermo*350)/larghezzaTotale),((int)(altezzaSchermo*100)/altezzaTotale));
		stato.setMinimumSize(dimensione);
		stato.setOpaque(true);
		stato.setBackground(Color.decode("15394527"));
		stato.setText(testo);
		textLabel = new String(text);
		System.out.println(textLabel);
	}
	
	public void modificaImmagineCarta(String path) {
		imageIcon = new ImageIcon(path);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(((int)(larghezzaSchermo*larghezza)/larghezzaTotale),((int)(altezzaSchermo*altezza)/altezzaTotale),Image.SCALE_DEFAULT);
		ImageIcon imageAll = new ImageIcon(newImage);
		carta.setIcon(imageAll);
		this.path = path;
	}
	
	public String leggiLabel() {
		return textLabel;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPath() {
		return path;
	}
}
