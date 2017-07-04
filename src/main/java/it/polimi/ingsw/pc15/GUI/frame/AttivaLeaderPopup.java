package it.polimi.ingsw.pc15.GUI.frame;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import it.polimi.ingsw.pc15.GUI.ButtonListener;
import it.polimi.ingsw.pc15.GUI.GUI;
import it.polimi.ingsw.pc15.GUI.mainGUI;
import it.polimi.ingsw.pc15.GUI.playerboard.CartaLeader;
import it.polimi.ingsw.pc15.GUI.playerboard.PlayerBoard;

public class AttivaLeaderPopup extends JFrame{

	private ArrayList<CartaLeader> leaders;
	
	private int altezza;
	private int larghezza;
	
	transient ImageIcon imageIcon;
	transient Image image, newImage;
	
	public AttivaLeaderPopup(ButtonListener listener) {
		
		altezza = 500;
		larghezza= 0;
		
		this.setLayout(new GridLayout(1,4));
		
		leaders = new ArrayList<CartaLeader>();
		
		PlayerBoard playerBoard = (PlayerBoard)GUI.mainFrame.getContentPane().getComponent(1);
		
		if(playerBoard.getCartaLeader1().leggiLabel().equals("GIOCATO")){
			CartaLeaderView cartaLeader = new CartaLeaderView(playerBoard.getCartaLeader1().getPath(), playerBoard.getCartaLeader1().getName(), "Attiva", listener);
			this.add(cartaLeader);
			larghezza+=350;
		}
		if(playerBoard.getCartaLeader2().leggiLabel().equals("GIOCATO")){
			CartaLeaderView cartaLeader = new CartaLeaderView(playerBoard.getCartaLeader2().getPath(), playerBoard.getCartaLeader2().getName(), "Attiva", listener);
			this.add(cartaLeader);
			larghezza+=350;
		}
		if(playerBoard.getCartaLeader3().leggiLabel().equals("GIOCATO")){
			CartaLeaderView cartaLeader = new CartaLeaderView(playerBoard.getCartaLeader3().getPath(), playerBoard.getCartaLeader3().getName(), "Attiva", listener);
			this.add(cartaLeader);
			larghezza+=350;
		}
		if(playerBoard.getCartaLeader4().leggiLabel().equals("GIOCATO")){
			CartaLeaderView cartaLeader = new CartaLeaderView(playerBoard.getCartaLeader4().getPath(), playerBoard.getCartaLeader4().getName(), "Attiva", listener);
			this.add(cartaLeader);
			larghezza+=350;
		}
		
		this.setSize(larghezza, altezza);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
	}
	
}
