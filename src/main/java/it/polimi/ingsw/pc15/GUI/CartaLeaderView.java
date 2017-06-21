package it.polimi.ingsw.pc15.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class CartaLeaderView extends JButton{

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
	String path;
	String name;
	
	ImageIcon imageIcon;
	Image image, newImage;
		
	public CartaLeaderView(String path, String name, String tipoView, ButtonListener listener) {
		
		this.path = path;
		this.name = name;
		
		int altezza = 500; //800
		int larghezza = 350; //430
		
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
