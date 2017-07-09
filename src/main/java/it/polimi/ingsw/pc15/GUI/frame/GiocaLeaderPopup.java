package it.polimi.ingsw.pc15.GUI.frame;

import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import it.polimi.ingsw.pc15.GUI.ButtonListener;
import it.polimi.ingsw.pc15.GUI.GUI;
import it.polimi.ingsw.pc15.GUI.playerboard.CartaLeader;
import it.polimi.ingsw.pc15.GUI.playerboard.PlayerBoard;

/**
 * Classe che gestisce l'apparizione del frame per l'attivazione delle carte leader
 * @author AndreaMazzeo289
 *
 */
public class GiocaLeaderPopup extends JFrame{

	private ArrayList<CartaLeader> leaders;
	
	private int altezza, larghezza;
	
	transient ImageIcon imageIcon;
	transient Image image, newImage;
	
	public GiocaLeaderPopup(ButtonListener listener, GUI gui) {
		
		altezza = 500;
		larghezza= 0;
		
		this.setLayout(new GridLayout(1,4));
		
		leaders = new ArrayList<CartaLeader>();
		
		PlayerBoard playerBoard = (PlayerBoard)gui.mainFrame.getContentPane().getComponent(1);
		
		if((playerBoard.getCartaLeader1().leggiLabel().equals("NON GIOCATO"))){
			CartaLeaderView cartaLeader = new CartaLeaderView(playerBoard.getCartaLeader1().getPath(), playerBoard.getCartaLeader1().getName(), "Gioca", listener);
			this.add(cartaLeader);
			larghezza+=350;
		}
		if((playerBoard.getCartaLeader2().leggiLabel().equals("NON GIOCATO"))){
			CartaLeaderView cartaLeader = new CartaLeaderView(playerBoard.getCartaLeader2().getPath(), playerBoard.getCartaLeader2().getName(), "Gioca", listener);
			this.add(cartaLeader);
			larghezza+=350;
		}
		if((playerBoard.getCartaLeader3().leggiLabel().equals("NON GIOCATO"))){
			CartaLeaderView cartaLeader = new CartaLeaderView(playerBoard.getCartaLeader3().getPath(), playerBoard.getCartaLeader3().getName(), "Gioca", listener);
			this.add(cartaLeader);
			larghezza+=350;
		}
		if((playerBoard.getCartaLeader4().leggiLabel().equals("NON GIOCATO"))){
			CartaLeaderView cartaLeader = new CartaLeaderView(playerBoard.getCartaLeader4().getPath(), playerBoard.getCartaLeader4().getName(), "Gioca", listener);
			this.add(cartaLeader);
			larghezza+=350;
		}
		
		this.setSize(larghezza, altezza);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
	}
	
}
