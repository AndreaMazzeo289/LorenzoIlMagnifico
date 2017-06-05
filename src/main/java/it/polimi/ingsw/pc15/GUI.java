package it.polimi.ingsw.pc15;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;


public class GUI {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
	    
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    int width = (int)screenSize.getWidth();
	    int height = (int)screenSize.getHeight();
	    frame.setSize(width, height);
	    frame.setResizable(false);
	    frame.getContentPane().setBackground(Color.WHITE);
	    frame.setAlwaysOnTop(true);
	    frame.setVisible(true);
	    
	 }

}
