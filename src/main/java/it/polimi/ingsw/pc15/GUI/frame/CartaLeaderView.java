package it.polimi.ingsw.pc15.GUI.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import it.polimi.ingsw.pc15.GUI.ButtonListener;

/**
 * Classe che crea un oggetto CartaLeaderView che rappresenta la carta leader che verrà usata
 * per la visualizzazione di tale carta nei frame AttivaLeaderPopup, GiocaLeaderPopup, ScartaLeaderPopup
 * @author AndreaMazzeo
 *
 */
public class CartaLeaderView extends JButton{

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
	private String path;
	private String name;
	
	transient ImageIcon imageIcon;
	transient Image image, newImage;
	
	private int altezza;
	private int larghezza;
		
	public CartaLeaderView(String path, String name, String tipoView, ButtonListener listener) {
		
		altezza = 500;
		larghezza = 350;
		
		imageIcon = new ImageIcon(path);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezza, altezza, Image.SCALE_DEFAULT);
		ImageIcon imageLeader = new ImageIcon(newImage);
	
		this.setActionCommand(path+"-"+name+tipoView);
		this.setIcon(imageLeader);
		this.setPreferredSize(new Dimension(larghezza,altezza));
		this.setBackground(Color.decode("15394527"));
		this.addActionListener(listener);
	}
}
