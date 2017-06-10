package it.polimi.ingsw.pc15.GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class mainGUI {
	
	public static void main(String[] args) throws IOException {
		
		JFrame mainFrame = new JFrame();
		
		//Gameboard gameboard = new Gameboard();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    int width = (int)screenSize.getWidth();
	    int height = (int)screenSize.getHeight();
	    mainFrame.setSize(width, height);
	    mainFrame.getContentPane().setBackground(Color.BLACK);
	   
	    mainFrame.getContentPane().setLayout(new GridLayout(1,2));
	    
	    Gameboard gameboard = new Gameboard();
	    PlayerBoard playerBoard = new PlayerBoard();
	    
	    mainFrame.getContentPane().add(gameboard);
	    mainFrame.getContentPane().add(playerBoard);
	    
	    mainFrame.setVisible(true);
	    mainFrame.setAlwaysOnTop(true);
	     
	    System.out.println("ok");
		/*JFrame frame = new JFrame();
	    
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    int width = (int)screenSize.getWidth();
	    int height = (int)screenSize.getHeight();
	    frame.setSize(799, 703);
	    frame.setResizable(false);
	    frame.getContentPane().setBackground(Color.WHITE);
	    
	    JLabel lblNewLabel = new JLabel("New label");
	    lblNewLabel.setIcon( new ImageIcon("img/DevCardsFront/devcards_f_en_c_10.png"));
	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    frame.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
	    frame.setAlwaysOnTop(true);
	    frame.setVisible(true);*/
		
		//gameboard.pack();
		//gameboard.setVisible(true);
	    
	 }
	
	
	
	

}
