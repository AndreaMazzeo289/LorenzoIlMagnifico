package it.polimi.ingsw.pc15.GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ButtonListener implements ActionListener{

	
	
	 public ButtonListener() {
	  }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getActionCommand().equals("attivaEffettoLeader")) {
			PlayerBoard playerBoard = (PlayerBoard)mainGUI.mainFrame.getContentPane().getComponent(1);
			playerBoard.getForziereOro().redrawCentral("img\\Punchboard\\oro\\1.png");
		}
			
		if (e.getActionCommand().equals("posizionaFamiliare")) {
			JFrame richiediFamiliare = new JFrame ();
			richiediFamiliare.setSize(400, 400);
			richiediFamiliare.setVisible(true);
			richiediFamiliare.setAlwaysOnTop(true);
		}
		
		if(e.getActionCommand().equals("torreVerde1")) {
			System.out.println("ciao");
		}
		
	}	
	
}
