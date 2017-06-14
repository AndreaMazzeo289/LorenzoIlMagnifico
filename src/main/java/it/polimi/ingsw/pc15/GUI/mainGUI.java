package it.polimi.ingsw.pc15.GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
	public static int altezzaTotale = 6650; //6530
	public static int larghezzaTotale = 4076;
	public static float rapporto = (float) 4/11;
	public static float rapportoPlayerBoard = (float)19/31;//13/21
	public static int numeroGiocatori = 2;
	
	public static void main(String[] args) throws IOException {
		
		mainFrame = new JFrame();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    int width = (int)screenSize.getWidth();
	    int height = (int)screenSize.getHeight();
	    mainFrame.setSize(width, height);
	    mainFrame.getContentPane().setBackground(Color.decode("15394527"));
	   
	    mainFrame.getContentPane().setLayout(new GridBagLayout());
	    Gameboard gameboard = new Gameboard();
	    PlayerBoard playerboard = new PlayerBoard();
	    
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.gridy=0;
	    gbc.gridx=0;
	    mainFrame.getContentPane().add(gameboard, gbc);
	    gbc.gridx=1;
	    mainFrame.getContentPane().add(playerboard, gbc);
	    /*mainFrame.getContentPane().setLayout(new GridLayout(1,2));
	    
	    Gameboard gameboard = new Gameboard();
	    PlayerBoard playerBoard = new PlayerBoard();
	    
	    mainFrame.getContentPane().add(gameboard);
	    mainFrame.getContentPane().add(playerBoard);*/
	    
	    mainFrame.setVisible(true);
	    mainFrame.setAlwaysOnTop(true);
	    
	}
	
	public PlayerBoard getPlayerBoard() {
		return (PlayerBoard)mainFrame.getContentPane().getComponent(1);
	}

}
