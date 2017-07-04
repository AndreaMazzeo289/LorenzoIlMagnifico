package it.polimi.ingsw.pc15.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.polimi.ingsw.pc15.GUI.frame.AttivaLeaderPopup;
import it.polimi.ingsw.pc15.GUI.frame.CarteScomunica;
import it.polimi.ingsw.pc15.GUI.frame.FrameInformazioniPlayer;
import it.polimi.ingsw.pc15.GUI.frame.FrameMostraCartePlayer;
import it.polimi.ingsw.pc15.GUI.frame.GiocaLeaderPopup;
import it.polimi.ingsw.pc15.GUI.frame.ScartaLeaderPopup;
import it.polimi.ingsw.pc15.GUI.frame.SelezionaFamiliarePopup;
import it.polimi.ingsw.pc15.GUI.frame.SelezionaNumeroServitori;
import it.polimi.ingsw.pc15.GUI.gameboard.Gameboard;
import it.polimi.ingsw.pc15.GUI.gameboard.SpazioConsiglio;
import it.polimi.ingsw.pc15.GUI.gameboard.SpazioProduzione1;
import it.polimi.ingsw.pc15.GUI.gameboard.SpazioProduzione2;
import it.polimi.ingsw.pc15.GUI.gameboard.SpazioRaccolto1;
import it.polimi.ingsw.pc15.GUI.gameboard.SpazioRaccolto2;
import it.polimi.ingsw.pc15.GUI.playerboard.PlayerBoard;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Player;

public class ButtonListener implements ActionListener{

	public SelezionaFamiliarePopup selezionaFamiliarePopup;
	public SelezionaNumeroServitori selezionaNumeroServitori;
	GiocaLeaderPopup giocaLeaderPopup;
	ColoreFamiliare coloreFamiliareScelto = null;
	AttivaLeaderPopup attivaLeaderPopup;
	ScartaLeaderPopup scartaLeaderPopup;
	FrameInformazioniPlayer frameInformazioniPlayer;
	boolean familiareScelto = false;
	GUI gui;
	
	//private ArrayList<String> message;
	
	public ButtonListener(GUI gui) {
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//message = new ArrayList();
		
		PlayerBoard playerBoard = (PlayerBoard) gui.mainFrame.getContentPane().getComponent(1);
		Gameboard gameboard = (Gameboard) gui.mainFrame.getContentPane().getComponent(0);
		
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
			if(gui.tuoTurno())
				giocaLeaderPopup = new GiocaLeaderPopup(this, gui);
		}
		
		if (e.getActionCommand().equals("attivaEffettoLeader")) {
			if(gui.tuoTurno())
				attivaLeaderPopup = new AttivaLeaderPopup(this, gui);
		}
		
		if (e.getActionCommand().equals("scartaCartaLeader")) {
			if(gui.tuoTurno())
				scartaLeaderPopup = new ScartaLeaderPopup(this, gui);
		}
		
		if (e.getActionCommand().equals("buttonScomuniche")) {
			CarteScomunica carteScomunica = new CarteScomunica(gui.getPathCartaScomunica1(),gui.getPathCartaScomunica2(),gui.getPathCartaScomunica3());
		}
		
		if(e.getActionCommand().equals("buttonStatoGioco")) {
			frameInformazioniPlayer = new FrameInformazioniPlayer(gui.getarrayListAvversari(), gui);
		}
		
		if (e.getActionCommand().equals("posizionaFamiliare")) {
			if(gui.tuoTurno()) {
				selezionaFamiliarePopup = new SelezionaFamiliarePopup(this,gui.getPlayerCorrente());
				gui.writeMessage("posiziona familiare");
			}
		}
		
		//------------------------------------------------------------------------------------//
		// SELEZIONATO FAMILIARE BIANCO
		//------------------------------------------------------------------------------------//
		if(e.getActionCommand().equals("selezionatoFamiliareBianco")) {
			playerBoard.getPanelSpazioFamiliariDisponibili().utilizzaFamiliare(ColoreFamiliare.BIANCO);
			gui.writeMessage("familiare bianco");
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
			gui.writeMessage("familiare arancione");
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
			gui.writeMessage("familiare nero");
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
			gui.writeMessage("familiare neutro");
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
			gui.writeMessage(Integer.toString(selezionaNumeroServitori.getInputNumero()));
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
		
		if(e.getActionCommand().startsWith("carteTerritorioPlayer")) {
			String index = e.getActionCommand().substring(21);
			Player player = gui.getarrayListAvversari().get(Integer.parseInt(index));
			FrameMostraCartePlayer frame = new FrameMostraCartePlayer(TipoCarta.TERRITORIO, player);
		}
		
		if(e.getActionCommand().equals("carteEdificioAltriPlayer")) {
			String index = e.getActionCommand().substring(21);
			Player player = gui.getarrayListAvversari().get(Integer.parseInt(index));
			FrameMostraCartePlayer frame = new FrameMostraCartePlayer(TipoCarta.EDIFICIO, player);
		}
		
		if(e.getActionCommand().equals("cartePersonaggioAltriPlayer")) {
			String index = e.getActionCommand().substring(21);
			Player player = gui.getarrayListAvversari().get(Integer.parseInt(index));
			FrameMostraCartePlayer frame = new FrameMostraCartePlayer(TipoCarta.PERSONAGGIO, player);
		}
		
		if(e.getActionCommand().equals("carteImpresaAltriPlayer")) {
			String index = e.getActionCommand().substring(21);
			Player player = gui.getarrayListAvversari().get(Integer.parseInt(index));
			FrameMostraCartePlayer frame = new FrameMostraCartePlayer(TipoCarta.IMPRESA, player);
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZI TORRE
		//------------------------------------------------------------------------------------------//
		if(e.getActionCommand().startsWith("spazioTorre")){
			
			if(coloreFamiliareScelto!=null) {
				gui.writeMessage("0");
				gui.writeMessage("torre");
				String coloreTorre = e.getActionCommand().substring(11, e.getActionCommand().length()-1);
				String numeroTorre = e.getActionCommand().substring(coloreTorre.length()+11);
				int numeroTorreInt = Integer.parseInt(numeroTorre)-1;
				gui.writeMessage(coloreTorre.toLowerCase());
				gui.writeMessage(Integer.toString(numeroTorreInt));
				
				int index = Math.abs(numeroTorreInt-3);
				
				TipoCarta tipoCarta=null;
				
				switch(coloreTorre.toUpperCase()){
				case "VERDE":
					tipoCarta = TipoCarta.TERRITORIO;
					break;
				case "GIALLA":
					tipoCarta = TipoCarta.EDIFICIO;
					break;
				case "BLU":
					tipoCarta = TipoCarta.PERSONAGGIO;
					break;
				case "VIOLA":
					tipoCarta = TipoCarta.IMPRESA;
					break;
				}
				
				gameboard.getSpazioTorre(tipoCarta,index).inserisciFamiliare(selezionaFamiliarePopup.readPath(coloreFamiliareScelto));
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				coloreFamiliareScelto=null;
				gui.inviaMessaggio();	
			}
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO CONSIGLIO
		//------------------------------------------------------------------------------------------//
		if(e.getActionCommand().startsWith("SpazioConsiglioPosizione")){
			if(coloreFamiliareScelto!=null) {
			
				gui.writeMessage("consiglio");
				String index = e.getActionCommand().substring(24);
			
				SpazioConsiglio spazioConsiglio = (SpazioConsiglio)gameboard.getSpazioConsiglio();
				spazioConsiglio.inserisciFamiliare(selezionaFamiliarePopup.readPath(coloreFamiliareScelto),spazioConsiglio.getButton(Integer.parseInt(index)));
			
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				
				coloreFamiliareScelto=null;
				gui.inviaMessaggio();
			}
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO PRODUZIONE 1 LISTENER
		//------------------------------------------------------------------------------------------//
		if(e.getActionCommand().equals("spazioProduzione1")){
			
			if(coloreFamiliareScelto!=null) {
				
				gui.writeMessage("produzione");
			
				SpazioProduzione1 spazioProduzione1 = (SpazioProduzione1)gameboard.getSpazioProduzione1();
				spazioProduzione1.inserisciFamiliare(selezionaFamiliarePopup.readPath(coloreFamiliareScelto));
				
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				
				coloreFamiliareScelto=null;
				gui.inviaMessaggio();
			}
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO PRODUZIONE 2 LISTENER
		//------------------------------------------------------------------------------------------//
		if(e.getActionCommand().startsWith("SpazioProduzionePosizione")){
			if(coloreFamiliareScelto!=null) {
				
				gui.writeMessage("consiglio");
				String index = e.getActionCommand().substring(25);
			
				SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)gameboard.getSpazioProduzione2();
				spazioProduzione2.inserisciFamiliare(selezionaFamiliarePopup.readPath(coloreFamiliareScelto),spazioProduzione2.getButton(Integer.parseInt(index)));
				
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				
				coloreFamiliareScelto=null;
				gui.inviaMessaggio();
			}
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO RACCOLTO 1 LISTENER
		//------------------------------------------------------------------------------------------//
		if(e.getActionCommand().equals("spazioRaccolto1")){
			
			if(coloreFamiliareScelto!=null) {
				
				gui.writeMessage("raccolta");
				
				SpazioRaccolto1 spazioRaccolto1 = (SpazioRaccolto1)gameboard.getSpazioRaccolto1();
				spazioRaccolto1.inserisciFamiliare(selezionaFamiliarePopup.readPath(coloreFamiliareScelto));
				
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				
				coloreFamiliareScelto=null;
				gui.inviaMessaggio();
			}
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO RACCOLTO 2 LISTENER
		//------------------------------------------------------------------------------------------//
		if(e.getActionCommand().startsWith("SpazioRaccoltoPosizione")){
			if(coloreFamiliareScelto!=null) {
		
				gui.writeMessage("raccolta");
				String index = e.getActionCommand().substring(23);
			
				SpazioRaccolto2 spazioRaccolto2 = (SpazioRaccolto2)gameboard.getSpazioRaccolto2();
				spazioRaccolto2.inserisciFamiliare(selezionaFamiliarePopup.readPath(coloreFamiliareScelto),spazioRaccolto2.getButton(Integer.parseInt(index)));
				
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				
				coloreFamiliareScelto=null;
				gui.inviaMessaggio();
			}
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO MERCATO
		//------------------------------------------------------------------------------------------//
		if(e.getActionCommand().equals("spazioMercato1")) {
			
			if(coloreFamiliareScelto!=null) {	
				
				gui.writeMessage("mercato");
				gui.writeMessage("1");	
				gameboard.getSpazioMercato1().inserisciFamiliare(selezionaFamiliarePopup.readPath(coloreFamiliareScelto));
				
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				
				coloreFamiliareScelto=null;
				gui.inviaMessaggio();
				
			}
		}
		
		if(e.getActionCommand().equals("spazioMercato2")) {
			
			if(coloreFamiliareScelto!=null) {	
				
				gui.writeMessage("mercato");
				gui.writeMessage("2");	
				gameboard.getSpazioMercato2().inserisciFamiliare(selezionaFamiliarePopup.readPath(coloreFamiliareScelto));
				
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				
				coloreFamiliareScelto=null;
				gui.inviaMessaggio();
			}
		}
		
		if(e.getActionCommand().equals("spazioMercato3")) {
			
			if(coloreFamiliareScelto!=null) {	
				
				gui.writeMessage("mercato");
				gui.writeMessage("3");	
				gameboard.getSpazioMercato3().inserisciFamiliare(selezionaFamiliarePopup.readPath(coloreFamiliareScelto));
				
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				
				coloreFamiliareScelto=null;
				gui.inviaMessaggio();
			}
		}
		
		if(e.getActionCommand().equals("spazioMercato4")) {
			
			if(coloreFamiliareScelto!=null) {	
				
				gui.writeMessage("mercato");
				gui.writeMessage("4");	
				gameboard.getSpazioMercato4().inserisciFamiliare(selezionaFamiliarePopup.readPath(coloreFamiliareScelto));
				
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				
				coloreFamiliareScelto=null;
				gui.inviaMessaggio();
			}
		}
	}
}
