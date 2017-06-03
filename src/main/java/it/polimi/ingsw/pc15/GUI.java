package it.polimi.ingsw.pc15;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.prism.Image;

public class GUI {

	public static void main(String[] args) {
		
		JFrame frm = new JFrame("Lorenzo il Magnifico");
		frm.setVisible(true);
		frm.setSize(1600, 900);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			BufferedImage img= ImageIO.read(GUI.class.getResource("lorenzo-magnifico.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		

	}

}
