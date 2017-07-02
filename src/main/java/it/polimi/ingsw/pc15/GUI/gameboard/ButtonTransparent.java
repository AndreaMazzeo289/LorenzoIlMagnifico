package it.polimi.ingsw.pc15.GUI.gameboard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonTransparent extends JButton{

	public ButtonTransparent(String nome, int larghezza, int altezza, ActionListener listener) {
		
		this.setMinimumSize(new Dimension(larghezza,altezza));
		this.setActionCommand(nome);
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(true);
		this.addActionListener(listener);
	}
}
