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
	
	public static JFrame mainFrame;
	
	public static void main(String[] args) throws IOException {
		
		mainFrame = new JFrame();
		
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
	    
	}
	
	public PlayerBoard getPlayerBoard() {
		return (PlayerBoard)mainFrame.getContentPane().getComponent(1);
	}

}
