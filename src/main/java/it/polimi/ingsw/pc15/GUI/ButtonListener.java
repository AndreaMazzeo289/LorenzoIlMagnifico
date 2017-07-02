package it.polimi.ingsw.pc15.GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

	ArrayList<String> message;
	
	public ButtonListener() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		message = new ArrayList();
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
			
			message.add("posiziona familiare");
			
			
			//flag seleziona familiare
			
		}
		
		//------------------------------------------------------------------------------------//
		// SELEZIONATO FAMILIARE BIANCO
		//------------------------------------------------------------------------------------//
		if(e.getActionCommand().equals("selezionatoFamiliareBianco")) {
			playerBoard.getPanelSpazioFamiliariDisponibili().utilizzaFamiliare(ColoreFamiliare.BIANCO);
			message.add("familiare bianco");
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
			
			selezionaNumeroServitori = new SelezionaNumeroServitori(this);
		}
		
		//------------------------------------------------------------------------------------//
		// SELEZIONATO FAMILIARE ARANCIONE
		//------------------------------------------------------------------------------------//
		if(e.getActionCommand().equals("selezionatoFamiliareArancione")) {
			playerBoard.getPanelSpazioFamiliariDisponibili().utilizzaFamiliare(ColoreFamiliare.ARANCIONE);
			message.add("familiare arancione");
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
			message.add("familiare nero");
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
			message.add("familiare neutro");
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
			message.add(Integer.toString(selezionaNumeroServitori.getInputNumero()));
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
				
				message.add("torre");
				message.add("verde");
				message.add("1");
				
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
				
				message.add("torre");
				message.add("verde");
				message.add("2");
				
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
				
				message.add("torre");
				message.add("verde");
				message.add("3");
				
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
				
				message.add("torre");
				message.add("verde");
				message.add("4");
				
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
				
				message.add("torre");
				message.add("blu");
				message.add("1");
				
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
				
				message.add("torre");
				message.add("blu");
				message.add("2");
				
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
				
				message.add("torre");
				message.add("blu");
				message.add("3");
				
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
				
				message.add("torre");
				message.add("blu");
				message.add("4");
				
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
				
				message.add("torre");
				message.add("viola");
				message.add("1");
				
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
				
				message.add("torre");
				message.add("viola");
				message.add("2");
				
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
				
				message.add("torre");
				message.add("viola");
				message.add("3");
				
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
				
				message.add("torre");
				message.add("viola");
				message.add("4");
				
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
				
				message.add("torre");
				message.add("gialla");
				message.add("1");
				
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
				
				message.add("torre");
				message.add("gialla");
				message.add("2");
				
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
				
				message.add("torre");
				message.add("gialla");
				message.add("3");
				
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
				
				message.add("torre");
				message.add("gialla");
				message.add("4");
				
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
		if(e.getActionCommand().startsWith("SpazioConsiglioPosizione")){
			
			String index = e.getActionCommand().substring(24);
			
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButton(Integer.parseInt(index)));
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO PRODUZIONE 1 LISTENER
		//------------------------------------------------------------------------------------------//
		if(e.getActionCommand().equals("spazioProduzione1")){
			
			message.add("produzione");
			
			SpazioProduzione1 spazioProduzione1 = (SpazioProduzione1)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione1();
			spazioProduzione1.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO PRODUZIONE 2 LISTENER
		//------------------------------------------------------------------------------------------//
		if(e.getActionCommand().startsWith("SpazioProduzionePosizione")){
			
			String index = e.getActionCommand().substring(25);
			
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButton(Integer.parseInt(index)));
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO RACCOLTO 1 LISTENER
		//------------------------------------------------------------------------------------------//
		if(e.getActionCommand().equals("spazioRaccolto1")){
			
			message.add("raccolta");
			
			SpazioRaccolto1 spazioRaccolto1 = (SpazioRaccolto1)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto1();
			spazioRaccolto1.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO RACCOLTO 2 LISTENER
		//------------------------------------------------------------------------------------------//
		if(e.getActionCommand().startsWith("SpazioRaccoltoPosizione")){
			
			String index = e.getActionCommand().substring(23);
			
			SpazioRaccolto2 spazioRaccolto2 = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto2.getButton(Integer.parseInt(index)));
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO MERCATO
		//------------------------------------------------------------------------------------------//
		if(e.getActionCommand().equals("spazioMercato1")) {
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioMercato1().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
			message.add("mercato");
			message.add("1");
		}
		
		if(e.getActionCommand().equals("spazioMercato2")) {
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioMercato2().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
			message.add("mercato");
			message.add("2");
		}
		
		if(e.getActionCommand().equals("spazioMercato3")) {
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioMercato3().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
			message.add("mercato");
			message.add("3");
		}
		
		if(e.getActionCommand().equals("spazioMercato4")) {
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioMercato4().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
			message.add("mercato");
			message.add("4");
		}
	}
}
