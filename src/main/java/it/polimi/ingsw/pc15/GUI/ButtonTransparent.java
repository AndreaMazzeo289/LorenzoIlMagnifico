package it.polimi.ingsw.pc15.GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class ButtonTransparent extends JButton{

	public ButtonTransparent(String nome, int larghezza, int altezza) {
		
		this.setMinimumSize(new Dimension(larghezza,altezza));
		this.setActionCommand(nome);
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.addActionListener(new ButtonListenerSpazi());
	}
}
