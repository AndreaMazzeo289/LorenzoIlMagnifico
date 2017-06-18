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

import it.polimi.ingsw.pc15.player.ColoreFamiliare;

public class ButtonListener implements ActionListener{

	public SelezionaFamiliarePopup selezionaFamiliarePopup;
	
	public ButtonListener() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if (e.getActionCommand().equals("attivaEffettoLeader")) {
			PlayerBoard playerBoard = (PlayerBoard)mainGUI.mainFrame.getContentPane().getComponent(1);
			playerBoard.getPanelRisorseOro().writeIntoLabel(2);
			playerBoard.getPanelSpazioFamiliariDisponibili().liberaFamiliare(ColoreFamiliare.NERO);
			
		}
		
		if (e.getActionCommand().equals("posizionaFamiliare")) {
			selezionaFamiliarePopup = new SelezionaFamiliarePopup(this);
			System.out.println("Popup richiesta familiare creato");
		}
		
		if(e.getActionCommand().equals("selezionatoFamiliareBianco")||e.getActionCommand().equals("selezionatoFamiliareArancione")
				||e.getActionCommand().equals("selezionatoFamiliareNero")||e.getActionCommand().equals("selezionatoFamiliareNeutro")) {
			System.out.println("selezionato bianco");
			selezionaFamiliarePopup.dispose();
			//cambia colore JButton
		}
		
		if(e.getActionCommand().equals("buttonStatoGioco")) {
			PlayerBoard playerBoard = (PlayerBoard)mainGUI.mainFrame.getContentPane().getComponent(1);
			playerBoard.getPanelSpazioFamiliariDisponibili().utilizzaFamiliare(ColoreFamiliare.NERO);
		}
		
		
		
	}	
	
}
