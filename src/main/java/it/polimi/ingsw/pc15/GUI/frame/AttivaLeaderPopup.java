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
 * Classe che gestisce l'apparizione del frame per l'attivazione degli effetti delle carte leader giocate
 * @author AndreaMazzeo289
 *
 */
public class AttivaLeaderPopup extends JFrame{ //NOSONAR

	private ArrayList<CartaLeader> leaders; //NOSONAR
	
	private int altezza;
	private int larghezza;
	
	transient ImageIcon imageIcon;
	transient Image image, newImage;
	
	public AttivaLeaderPopup(ButtonListener listener, GUI gui) { // NOSONAR
		
		altezza = 500;
		larghezza= 0;
		
		this.setLayout(new GridLayout(1,4));
		
		leaders = new ArrayList<CartaLeader>(); //NOSONAR
		
		PlayerBoard playerBoard = (PlayerBoard)gui.mainFrame.getContentPane().getComponent(1);
		
		if(playerBoard.getCartaLeader(0).leggiLabel().equals("GIOCATO")){ // NOSONAR
			CartaLeaderView cartaLeader = new CartaLeaderView(playerBoard.getCartaLeader(0).getPath(), playerBoard.getCartaLeader(0).getName(), "Attiva", listener);
			this.add(cartaLeader);
			larghezza+=350;
		}
		if(playerBoard.getCartaLeader(1).leggiLabel().equals("GIOCATO")){ // NOSONAR
			CartaLeaderView cartaLeader = new CartaLeaderView(playerBoard.getCartaLeader(1).getPath(), playerBoard.getCartaLeader(1).getName(), "Attiva", listener);
			this.add(cartaLeader);
			larghezza+=350;
		}
		if(playerBoard.getCartaLeader(2).leggiLabel().equals("GIOCATO")){ // NOSONAR
			CartaLeaderView cartaLeader = new CartaLeaderView(playerBoard.getCartaLeader(2).getPath(), playerBoard.getCartaLeader(2).getName(), "Attiva", listener);
			this.add(cartaLeader);
			larghezza+=350;
		}
		if(playerBoard.getCartaLeader(3).leggiLabel().equals("GIOCATO")){ // NOSONAR
			CartaLeaderView cartaLeader = new CartaLeaderView(playerBoard.getCartaLeader(3).getPath(), playerBoard.getCartaLeader(3).getName(), "Attiva", listener);
			this.add(cartaLeader);
			larghezza+=350;
		}
		
		this.setSize(larghezza, altezza);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
	}
	
}
