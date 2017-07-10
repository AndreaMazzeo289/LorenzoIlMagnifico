package it.polimi.ingsw.pc15.GUI.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import it.polimi.ingsw.pc15.GUI.ButtonListener;

/**
 * Classe che permette l'apparizione di un frame che chiude la partita mostrando il vincitore
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 * 
 */
public class FrameConclusivo extends JFrame{
	
	private JLabel testo;
	
	public FrameConclusivo(String text) {
		
		this.setBackground(Color.decode("15394527"));
		this.getContentPane().setLayout(new BorderLayout());
		
		testo = new JLabel("",SwingConstants.CENTER);
		testo.setText(text);
		testo.setFont((new Font("Courier New", Font.ITALIC, 30)));
		
		this.add(testo, BorderLayout.CENTER);
		
		this.setSize(800, 350);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
	}
}
