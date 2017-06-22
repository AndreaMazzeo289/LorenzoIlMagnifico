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
	public SelezionaNumeroServitori selezionaNumeroServitori;
	GiocaLeaderPopup giocaLeaderPopup;
	AttivaLeaderPopup attivaLeaderPopup;
	ScartaLeaderPopup scartaLeaderPopup;
	FrameInformazioniPlayer frameInformazioniPlayer;
	
	public ButtonListener() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String path = "";
		String tipo = "";
		boolean write=false;
		for(int i = 0; i < e.getActionCommand().length(); i++)
		{
			  char lettera = e.getActionCommand().charAt(i);
			  if(!write && lettera != '-') {
				  Character.toString(lettera);
				  path+=lettera; 
			  }
			  if(write) {
				  Character.toString(lettera);
				  tipo+=lettera;
			  }
			  if(lettera == '-')
			    write=true;
		}
		
		if(e.getActionCommand().equals("attivaCartaLeader")) {
			giocaLeaderPopup = new GiocaLeaderPopup(this);
		}
		
		if (e.getActionCommand().equals("attivaEffettoLeader")) {
			/*PlayerBoard playerBoard = (PlayerBoard)mainGUI.mainFrame.getContentPane().getComponent(1);
			playerBoard.getPanelRisorseOro().writeIntoLabel(2);
			playerBoard.getPanelSpazioFamiliariDisponibili().liberaFamiliare(ColoreFamiliare.NERO);
			selezionaNumeroServitori = new SelezionaNumeroServitori(this);
			playerBoard.getCartaLeader1().leggiLabel();*/
			
			attivaLeaderPopup = new AttivaLeaderPopup(this);
		}
		
		if (e.getActionCommand().equals("scartaCartaLeader")) {
			scartaLeaderPopup = new ScartaLeaderPopup(this);
			/*PlayerBoard playerBoard = (PlayerBoard)mainGUI.mainFrame.getContentPane().getComponent(1);
			playerBoard.getPanelRisorseOro().writeIntoLabel(2);*/
		}
		
		if (e.getActionCommand().equals("buttonScomuniche")) {
			System.out.println("scomunicaa");
			CarteScomunica carteScomunica = new CarteScomunica("img/PunchboardCut/excomm_1_1.png","img/PunchboardCut/excomm_2_1.png","img/PunchboardCut/excomm_3_1.png");
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
			/*PlayerBoard playerBoard = (PlayerBoard)mainGUI.mainFrame.getContentPane().getComponent(1);
			playerBoard.getPanelSpazioFamiliariDisponibili().utilizzaFamiliare(ColoreFamiliare.NERO);*/
			frameInformazioniPlayer = new FrameInformazioniPlayer();
			System.out.println("premuto statogioco");
		}
		
		if(e.getActionCommand().equals("siServitori")) {
			System.out.println("selezionato si");
			selezionaNumeroServitori.dispose();
			selezionaNumeroServitori.numeroServitoriPopup();
		}
		
		if(e.getActionCommand().equals("noServitori")) {
			System.out.println("selezionato no");
			selezionaNumeroServitori.dispose();
		}
		
		if(e.getActionCommand().equals("submitNumeroServitori")) {
			System.out.println(selezionaNumeroServitori.getInputNumero());
			selezionaNumeroServitori.getPopupNumeroServitori().dispose();
		}
		
		if(tipo.equals("leader1Gioca")){
			
			PlayerBoard playerBoard = (PlayerBoard)mainGUI.mainFrame.getContentPane().getComponent(1);
			playerBoard.getCartaLeader1().scriviLabel("GIOCATO");
			giocaLeaderPopup.dispose();
		}
		
		if(tipo.equals("leader2Gioca")){
					
			PlayerBoard playerBoard = (PlayerBoard)mainGUI.mainFrame.getContentPane().getComponent(1);
			playerBoard.getCartaLeader2().scriviLabel("GIOCATO");
			giocaLeaderPopup.dispose();
		}
		
		if(tipo.equals("leader3Gioca")){
			
			PlayerBoard playerBoard = (PlayerBoard)mainGUI.mainFrame.getContentPane().getComponent(1);
			playerBoard.getCartaLeader3().scriviLabel("GIOCATO");
			giocaLeaderPopup.dispose();
		}
		
		if(tipo.equals("leader4Gioca")){
			
			PlayerBoard playerBoard = (PlayerBoard)mainGUI.mainFrame.getContentPane().getComponent(1);
			playerBoard.getCartaLeader4().scriviLabel("GIOCATO");
			giocaLeaderPopup.dispose();
		}
		
		if(tipo.equals("leader1Attiva")){
			attivaLeaderPopup.dispose();
			System.out.println("leader 1 attivato");
		}
		
		if(tipo.equals("leader2Attiva")){
			attivaLeaderPopup.dispose();
			System.out.println("leader 2 attivato");
		}
		
		if(tipo.equals("leader3Attiva")){
			attivaLeaderPopup.dispose();
			System.out.println("leader 3 attivato");
		}
		
		if(tipo.equals("leader4Attiva")){
			attivaLeaderPopup.dispose();
			System.out.println("leader 4 attivato");
		}
		
		if(tipo.equals("leader1Scarta")){
			scartaLeaderPopup.dispose();
			System.out.println("leader 1 scartato");
			PlayerBoard playerBoard = (PlayerBoard)mainGUI.mainFrame.getContentPane().getComponent(1);
			playerBoard.getCartaLeader1().scriviLabel("SCARTATO");
		}
		
		if(tipo.equals("leader2Scarta")){
			scartaLeaderPopup.dispose();
			System.out.println("leader 2 scartato");
			PlayerBoard playerBoard = (PlayerBoard)mainGUI.mainFrame.getContentPane().getComponent(1);
			playerBoard.getCartaLeader2().scriviLabel("SCARTATO");
		}
		
		if(tipo.equals("leader3Scarta")){
			scartaLeaderPopup.dispose();
			System.out.println("leader 3 scartato");
			PlayerBoard playerBoard = (PlayerBoard)mainGUI.mainFrame.getContentPane().getComponent(1);
			playerBoard.getCartaLeader3().scriviLabel("SCARTATO");
		}
		
		if(tipo.equals("leader4Scarta")){
			scartaLeaderPopup.dispose();
			System.out.println("leader 4 scartato");
			PlayerBoard playerBoard = (PlayerBoard)mainGUI.mainFrame.getContentPane().getComponent(1);
			playerBoard.getCartaLeader4().scriviLabel("SCARTATO");
		}
		
	}	
	
}
