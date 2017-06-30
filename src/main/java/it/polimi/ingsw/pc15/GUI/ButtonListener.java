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
import javax.swing.JPanel;
import javax.swing.Timer;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;

public class ButtonListener implements ActionListener{

	public SelezionaFamiliarePopup selezionaFamiliarePopup;
	public SelezionaNumeroServitori selezionaNumeroServitori;
	GiocaLeaderPopup giocaLeaderPopup;
	ColoreFamiliare coloreFamiliareScelto = null;
	AttivaLeaderPopup attivaLeaderPopup;
	ScartaLeaderPopup scartaLeaderPopup;
	FrameInformazioniPlayer frameInformazioniPlayer;
	boolean familiareScelto = false;

	public ButtonListener() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		PlayerBoard playerBoard = (PlayerBoard)mainGUI.mainFrame.getContentPane().getComponent(1);
		
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
			System.out.println("scomunica");
			CarteScomunica carteScomunica = new CarteScomunica("img/PunchboardCut/excomm_1_1.png","img/PunchboardCut/excomm_2_1.png","img/PunchboardCut/excomm_3_1.png");
		}
		
		if (e.getActionCommand().equals("posizionaFamiliare")) {
			selezionaFamiliarePopup = new SelezionaFamiliarePopup(this);
			System.out.println("Seleziona uno spazio libero");
			
			
			//flag seleziona familiare
			
		}
		
		//------------------------------------------------------------------------------------//
		// SELEZIONATO FAMILIARE BIANCO
		//------------------------------------------------------------------------------------//
		if(e.getActionCommand().equals("selezionatoFamiliareBianco")) {
			playerBoard.getPanelSpazioFamiliariDisponibili().utilizzaFamiliare(ColoreFamiliare.BIANCO);
			System.out.println("selezionato bianco");
			coloreFamiliareScelto = ColoreFamiliare.BIANCO;

			{
				playerBoard.getButtonPosizionaFamiliare().bloccaButton();
				playerBoard.getButtonAttivaEffettoLeader().bloccaButton();
				playerBoard.getButtonGiocaLeader().bloccaButton();
				playerBoard.getButtonScartaLeader().bloccaButton();
			}
			
			//System.out.println("bravo hai selezionato");
			// INSERIRE CHE OCCUPIAMO IL FAMILIARE //
			selezionaFamiliarePopup.dispose();
		}
		
		//------------------------------------------------------------------------------------//
		// SELEZIONATO FAMILIARE ARANCIONE
		//------------------------------------------------------------------------------------//
		if(e.getActionCommand().equals("selezionatoFamiliareArancione")) {
			playerBoard.getPanelSpazioFamiliariDisponibili().utilizzaFamiliare(ColoreFamiliare.ARANCIONE);
			System.out.println("selezionato arancione");
			coloreFamiliareScelto = ColoreFamiliare.ARANCIONE;
			
			{
				playerBoard.getButtonPosizionaFamiliare().bloccaButton();
				playerBoard.getButtonAttivaEffettoLeader().bloccaButton();
				playerBoard.getButtonGiocaLeader().bloccaButton();
				playerBoard.getButtonScartaLeader().bloccaButton();
			}
			
			// INSERIRE CHE OCCUPIAMO IL FAMILIARE //
			selezionaFamiliarePopup.dispose();
		}
		
		//------------------------------------------------------------------------------------//
		// SELEZIONATO FAMILIARE NERO
		//------------------------------------------------------------------------------------//
		if(e.getActionCommand().equals("selezionatoFamiliareNero")) {
			playerBoard.getPanelSpazioFamiliariDisponibili().utilizzaFamiliare(ColoreFamiliare.NERO);
			System.out.println("selezionato nero");
			coloreFamiliareScelto = ColoreFamiliare.NERO;
			
			{
				playerBoard.getButtonPosizionaFamiliare().bloccaButton();
				playerBoard.getButtonAttivaEffettoLeader().bloccaButton();
				playerBoard.getButtonGiocaLeader().bloccaButton();
				playerBoard.getButtonScartaLeader().bloccaButton();
			}
			
			// INSERIRE CHE OCCUPIAMO IL FAMILIARE //
			selezionaFamiliarePopup.dispose();
		}
		
		//------------------------------------------------------------------------------------//
		// SELEZIONATO FAMILIARE NEUTRO
		//------------------------------------------------------------------------------------//
		if(e.getActionCommand().equals("selezionatoFamiliareNeutro")) {
			playerBoard.getPanelSpazioFamiliariDisponibili().utilizzaFamiliare(ColoreFamiliare.NEUTRO);
			System.out.println("selezionato neutro");
			coloreFamiliareScelto = ColoreFamiliare.NEUTRO;
			
			{
				playerBoard.getButtonPosizionaFamiliare().bloccaButton();
				playerBoard.getButtonAttivaEffettoLeader().bloccaButton();
				playerBoard.getButtonGiocaLeader().bloccaButton();
				playerBoard.getButtonScartaLeader().bloccaButton();
			}
			
			// INSERIRE CHE OCCUPIAMO IL FAMILIARE //
			selezionaFamiliarePopup.dispose();
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
			
			playerBoard.getCartaLeader1().scriviLabel("GIOCATO");
			giocaLeaderPopup.dispose();
		}
		
		if(tipo.equals("leader2Gioca")){
					
			playerBoard.getCartaLeader2().scriviLabel("GIOCATO");
			giocaLeaderPopup.dispose();
		}
		
		if(tipo.equals("leader3Gioca")){
			
			playerBoard.getCartaLeader3().scriviLabel("GIOCATO");
			giocaLeaderPopup.dispose();
		}
		
		if(tipo.equals("leader4Gioca")){
			
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
			playerBoard.getCartaLeader1().scriviLabel("SCARTATO");
		}
		
		if(tipo.equals("leader2Scarta")){
			scartaLeaderPopup.dispose();
			System.out.println("leader 2 scartato");
			playerBoard.getCartaLeader2().scriviLabel("SCARTATO");
		}
		
		if(tipo.equals("leader3Scarta")){
			scartaLeaderPopup.dispose();
			System.out.println("leader 3 scartato");
			playerBoard.getCartaLeader3().scriviLabel("SCARTATO");
		}
		
		if(tipo.equals("leader4Scarta")){
			scartaLeaderPopup.dispose();
			System.out.println("leader 4 scartato");
			
			playerBoard.getCartaLeader4().scriviLabel("SCARTATO");
		}
		
		if(e.getActionCommand().equals("carteTerritorioAltriPlayer")) {
			FrameMostraCartePlayer frame = new FrameMostraCartePlayer(TipoCarta.TERRITORIO);
		}
		
		if(e.getActionCommand().equals("carteEdificioAltriPlayer")) {
			FrameMostraCartePlayer frame = new FrameMostraCartePlayer(TipoCarta.EDIFICIO);
		}
		
		if(e.getActionCommand().equals("cartePersonaggioAltriPlayer")) {
			System.out.println("personaggio");
			FrameMostraCartePlayer frame = new FrameMostraCartePlayer(TipoCarta.PERSONAGGIO);
		}
		
		if(e.getActionCommand().equals("carteImpresaAltriPlayer")) {
			System.out.println("impresa");
			FrameMostraCartePlayer frame = new FrameMostraCartePlayer(TipoCarta.IMPRESA);
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZI TORRE VERDE
		//------------------------------------------------------------------------------------------//
		// SPAZIO 1
		//----------//
		if(e.getActionCommand().equals("spazioTorreVerde1")) {
			if(coloreFamiliareScelto!=null) {
				((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreVerde1().inserisciFamiliare(selezionaFamiliarePopup.readPath(coloreFamiliareScelto));
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				coloreFamiliareScelto=null;
			}
		}
		
		// SPAZIO 2
		//----------//
		if(e.getActionCommand().equals("spazioTorreVerde2")) {
			if(coloreFamiliareScelto!=null) {
				((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreVerde2().inserisciFamiliare(selezionaFamiliarePopup.readPath(coloreFamiliareScelto));
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				coloreFamiliareScelto=null;
			}
		}
			
		// SPAZIO 3
		//----------//
		if(e.getActionCommand().equals("spazioTorreVerde3")) {
			if(coloreFamiliareScelto!=null) {
				((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreVerde3().inserisciFamiliare(selezionaFamiliarePopup.readPath(coloreFamiliareScelto));
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				coloreFamiliareScelto=null;
			}
		}
		
		// SPAZIO 4
		//----------//
		if(e.getActionCommand().equals("spazioTorreVerde4")) {
			if(coloreFamiliareScelto!=null) {
				((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreVerde4().inserisciFamiliare(selezionaFamiliarePopup.readPath(coloreFamiliareScelto));
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				coloreFamiliareScelto=null;
			}
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZI TORRE BLU
		//------------------------------------------------------------------------------------------//
		// SPAZIO 1
		//----------//
		if(e.getActionCommand().equals("spazioTorreBlu1")) {
			if(coloreFamiliareScelto!=null) {
				((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreBlu1().inserisciFamiliare(selezionaFamiliarePopup.readPath(coloreFamiliareScelto));
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				coloreFamiliareScelto=null;
			}
		}
		
		// SPAZIO 2
		//----------//
		if(e.getActionCommand().equals("spazioTorreBlu2")) {
			if(coloreFamiliareScelto!=null) {
				((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreBlu2().inserisciFamiliare(selezionaFamiliarePopup.readPath(coloreFamiliareScelto));
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				coloreFamiliareScelto=null;
			}
		}
		
		// SPAZIO 3
		//----------//
		if(e.getActionCommand().equals("spazioTorreBlu3")) {
			if(coloreFamiliareScelto!=null) {
				((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreBlu3().inserisciFamiliare(selezionaFamiliarePopup.readPath(coloreFamiliareScelto));
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				coloreFamiliareScelto=null;
			}
		}
		
		// SPAZIO 4
		//----------//
		if(e.getActionCommand().equals("spazioTorreBlu4")) {
			if(coloreFamiliareScelto!=null) {
				((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreBlu4().inserisciFamiliare(selezionaFamiliarePopup.readPath(coloreFamiliareScelto));
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				coloreFamiliareScelto=null;
			}
		}

		//------------------------------------------------------------------------------------------//
		// SPAZI TORRE VIOLA
		//------------------------------------------------------------------------------------------//
		// SPAZIO 1
		//----------//
		if(e.getActionCommand().equals("spazioTorreViola1")) {
			if(coloreFamiliareScelto!=null) {
				((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreViola1().inserisciFamiliare(selezionaFamiliarePopup.readPath(coloreFamiliareScelto));
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				coloreFamiliareScelto=null;
			}
		}
		// SPAZIO 2
		//----------//
		if(e.getActionCommand().equals("spazioTorreViola2")) {
			if(coloreFamiliareScelto!=null) {
				((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreViola2().inserisciFamiliare(selezionaFamiliarePopup.readPath(coloreFamiliareScelto));
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				coloreFamiliareScelto=null;
			}
		}
		// SPAZIO 3
		//----------//
		if(e.getActionCommand().equals("spazioTorreViola3")) {
			if(coloreFamiliareScelto!=null) {
				((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreViola3().inserisciFamiliare(selezionaFamiliarePopup.readPath(coloreFamiliareScelto));
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				coloreFamiliareScelto=null;
			}
		}
		// SPAZIO 4
		//----------//
		if(e.getActionCommand().equals("spazioTorreViola4")) {
			if(coloreFamiliareScelto!=null) {
				((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreViola4().inserisciFamiliare(selezionaFamiliarePopup.readPath(coloreFamiliareScelto));
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				coloreFamiliareScelto=null;
			}
		}
		//------------------------------------------------------------------------------------------//
		// SPAZI TORRE GIALLA
		//------------------------------------------------------------------------------------------//
		// SPAZIO 1
		//----------//
		if(e.getActionCommand().equals("spazioTorreGialla1")) {
			if(coloreFamiliareScelto!=null) {
				((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreGialla1().inserisciFamiliare(selezionaFamiliarePopup.readPath(coloreFamiliareScelto));
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				coloreFamiliareScelto=null;
			}
		}
		// SPAZIO 2
		//----------//
		if(e.getActionCommand().equals("spazioTorreGialla2")) {
			if(coloreFamiliareScelto!=null) {
				((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreGialla2().inserisciFamiliare(selezionaFamiliarePopup.readPath(coloreFamiliareScelto));
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				coloreFamiliareScelto=null;
			}
		}
		// SPAZIO 3
		//----------//
		if(e.getActionCommand().equals("spazioTorreGialla3")) {
			if(coloreFamiliareScelto!=null) {
				((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreGialla3().inserisciFamiliare(selezionaFamiliarePopup.readPath(coloreFamiliareScelto));
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				coloreFamiliareScelto=null;
			}
		}
		// SPAZIO 4
		//----------//
		if(e.getActionCommand().equals("spazioTorreGialla4")) {
			if(coloreFamiliareScelto!=null) {
				((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreGialla4().inserisciFamiliare(selezionaFamiliarePopup.readPath(coloreFamiliareScelto));
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				coloreFamiliareScelto=null;
			}
		}
		//------------------------------------------------------------------------------------------//
		// SPAZIO CONSIGLIO
		//------------------------------------------------------------------------------------------//
		if(e.getActionCommand().equals("SpazioConsiglioPosizione1")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione1());
		}
		
		if(e.getActionCommand().equals("SpazioConsiglioPosizione2")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione2());
		}
		
		if(e.getActionCommand().equals("SpazioConsiglioPosizione3")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione3());
		}
		
		if(e.getActionCommand().equals("SpazioConsiglioPosizione4")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione4());
		}
		
		if(e.getActionCommand().equals("SpazioConsiglioPosizione5")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione5());
		}
		
		if(e.getActionCommand().equals("SpazioConsiglioPosizione6")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione6());
		}
		
		if(e.getActionCommand().equals("SpazioConsiglioPosizione7")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione7());
		}
		
		if(e.getActionCommand().equals("SpazioConsiglioPosizione8")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione8());
		}
		
		if(e.getActionCommand().equals("SpazioConsiglioPosizione9")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione9());
		}
		
		if(e.getActionCommand().equals("SpazioConsiglioPosizione10")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione10());
		}
		
		if(e.getActionCommand().equals("SpazioConsiglioPosizione11")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione11());
		}
		
		if(e.getActionCommand().equals("SpazioConsiglioPosizione12")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione12());
		}
		
		if(e.getActionCommand().equals("SpazioConsiglioPosizione13")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione13());
		}
		
		if(e.getActionCommand().equals("SpazioConsiglioPosizione14")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione14());
		}
		
		if(e.getActionCommand().equals("SpazioConsiglioPosizione15")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione15());
		}
		
		if(e.getActionCommand().equals("SpazioConsiglioPosizione16")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione16());
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO PRODUZIONE 1 LISTENER
		//------------------------------------------------------------------------------------------//
		if(e.getActionCommand().equals("spazioProduzione1")){
			SpazioProduzione1 spazioProduzione1 = (SpazioProduzione1)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione1();
			spazioProduzione1.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO PRODUZIONE 2 LISTENER
		//------------------------------------------------------------------------------------------//
		if(e.getActionCommand().equals("SpazioProduzionePosizione1")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione1());
		}
		
		if(e.getActionCommand().equals("SpazioProduzionePosizione2")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione2());
		}
		
		if(e.getActionCommand().equals("SpazioProduzionePosizione3")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione3());
		}
		
		if(e.getActionCommand().equals("SpazioProduzionePosizione4")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione4());
		}
		
		if(e.getActionCommand().equals("SpazioProduzionePosizione5")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione5());
		}
		
		if(e.getActionCommand().equals("SpazioProduzionePosizione6")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione6());
		}
		
		if(e.getActionCommand().equals("SpazioProduzionePosizione7")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione7());
		}
		
		if(e.getActionCommand().equals("SpazioProduzionePosizione8")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione8());
		}
		
		if(e.getActionCommand().equals("SpazioProduzionePosizione9")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione9());
		}
		
		if(e.getActionCommand().equals("SpazioProduzionePosizione10")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione10());
		}
		
		if(e.getActionCommand().equals("SpazioProduzionePosizione11")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione11());
		}
		
		if(e.getActionCommand().equals("SpazioProduzionePosizione12")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione12());
		}
		
		if(e.getActionCommand().equals("SpazioProduzionePosizione13")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione13());
		}
		
		if(e.getActionCommand().equals("SpazioProduzionePosizione14")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione14());
		}
		
		if(e.getActionCommand().equals("SpazioProduzionePosizione15")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione15());
		}
		
		if(e.getActionCommand().equals("SpazioProduzionePosizione16")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione16());
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO RACCOLTO 1 LISTENER
		//------------------------------------------------------------------------------------------//
		if(e.getActionCommand().equals("spazioRaccolto1")){
			SpazioRaccolto1 spazioRaccolto1 = (SpazioRaccolto1)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto1();
			spazioRaccolto1.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO RACCOLTO 2 LISTENER
		//------------------------------------------------------------------------------------------//
		if(e.getActionCommand().equals("SpazioRaccoltoPosizione1")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione1());
		}
		
		if(e.getActionCommand().equals("SpazioRaccoltoPosizione2")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione2());
		}
		
		if(e.getActionCommand().equals("SpazioRaccoltoPosizione3")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione3());
		}
		
		if(e.getActionCommand().equals("SpazioRaccoltoPosizione4")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione4());
		}
		
		if(e.getActionCommand().equals("SpazioRaccoltoPosizione5")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione5());
		}
		
		if(e.getActionCommand().equals("SpazioRaccoltoPosizione6")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione6());
		}
		
		if(e.getActionCommand().equals("SpazioRaccoltoPosizione7")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione7());
		}
		
		if(e.getActionCommand().equals("SpazioRaccoltoPosizione8")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione8());
		}
		
		if(e.getActionCommand().equals("SpazioRaccoltoPosizione9")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione9());
		}
		
		if(e.getActionCommand().equals("SpazioRaccoltoPosizione10")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione10());
		}
		
		if(e.getActionCommand().equals("SpazioRaccoltoPosizione11")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione11());
		}
		
		if(e.getActionCommand().equals("SpazioRaccoltoPosizione12")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione12());
		}
		
		if(e.getActionCommand().equals("SpazioRaccoltoPosizione13")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione13());
		}
		
		if(e.getActionCommand().equals("SpazioRaccoltoPosizione14")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione14());
		}
		
		if(e.getActionCommand().equals("SpazioRaccoltoPosizione15")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione15());
		}
		
		if(e.getActionCommand().equals("SpazioRaccoltoPosizione16")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione16());
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO MERCATO
		//------------------------------------------------------------------------------------------//
		if(e.getActionCommand().equals("spazioMercato1"))
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioMercato1().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		
		if(e.getActionCommand().equals("spazioMercato2"))
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioMercato2().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		
		if(e.getActionCommand().equals("spazioMercato3"))
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioMercato3().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		
		if(e.getActionCommand().equals("spazioMercato4"))
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioMercato4().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
	}
	
}
