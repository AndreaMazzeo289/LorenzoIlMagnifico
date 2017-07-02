package it.polimi.ingsw.pc15.GUI.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CarteScomunica extends JFrame {

	JLabel carta1,carta2,carta3;
	
	int altezzaFrame;
	int larghezzaFrame;
	int altezzaCarta;
	int larghezzaCarta;
	
	public CarteScomunica(String path1, String path2, String path3) {
		
		this.setLayout(new FlowLayout());
		
		altezzaFrame = 700;
		larghezzaFrame = 1000;
		altezzaCarta = 600;
		larghezzaCarta = 300;
		
		carta1 = new JLabel();
		carta2 = new JLabel();
		carta3 = new JLabel();
		
		ImageIcon imageIcon;
		Image image, newImage;
		
		imageIcon = new ImageIcon(path1);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaCarta,altezzaCarta,Image.SCALE_DEFAULT);
		ImageIcon imageCarta1 = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon(path2);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaCarta,altezzaCarta,Image.SCALE_DEFAULT);
		ImageIcon imageCarta2 = new ImageIcon(newImage);
		
		imageIcon = new ImageIcon(path3);
		image = imageIcon.getImage();
		newImage = image.getScaledInstance(larghezzaCarta,altezzaCarta,Image.SCALE_DEFAULT);
		ImageIcon imageCarta3 = new ImageIcon(newImage);
		
		carta1.setIcon(imageCarta1);
		carta2.setIcon(imageCarta2);
		carta3.setIcon(imageCarta3);
		
		this.add(carta1);
		this.add(carta2);
		this.add(carta3);
		
		this.setSize(larghezzaFrame, altezzaFrame);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
	}
	
}
