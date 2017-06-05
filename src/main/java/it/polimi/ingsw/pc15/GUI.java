package it.polimi.ingsw.pc15;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class GUI {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
	    
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    int width = (int)screenSize.getWidth();
	    int height = (int)screenSize.getHeight();
	    frame.setSize(799, 703);
	    frame.setResizable(false);
	    frame.getContentPane().setBackground(Color.WHITE);
	    
	    JLabel lblNewLabel = new JLabel("New label");
	    lblNewLabel.setIcon(new ImageIcon(GUI.class.getResource("/img/Leaders/leaders_f_c_05.jpg")));
	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    frame.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
	    frame.setAlwaysOnTop(true);
	    frame.setVisible(true);
	    
	 }

}
