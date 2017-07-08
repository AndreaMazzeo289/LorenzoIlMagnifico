package it.polimi.ingsw.pc15.GUI.gameboard;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;

public class ButtonTransparent extends JButton{ // NOSONAR
	
	public ButtonTransparent(String nome, int larghezza, int altezza, ActionListener listener) {
		
		this.setMinimumSize(new Dimension(larghezza,altezza));
		this.setActionCommand(nome);
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.addActionListener(listener);
		this.setName("libero");
	}
}
