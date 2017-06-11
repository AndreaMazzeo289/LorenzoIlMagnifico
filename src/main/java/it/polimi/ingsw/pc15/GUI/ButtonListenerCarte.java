package it.polimi.ingsw.pc15.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonListenerCarte implements ActionListener{

	 public ButtonListenerCarte() {
	  }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JFrame zoomCard = new JFrame();
		JPanel panelCard = new JPanel();
		ImageIcon imageIcon = new ImageIcon(e.getActionCommand());
		JLabel label = new JLabel();
		label.setIcon(imageIcon);
		panelCard.add(label);
		zoomCard.add(panelCard);
		
		zoomCard.setSize(600, 900);
		zoomCard.setVisible(true);
		zoomCard.setAlwaysOnTop(true);
	}
}
