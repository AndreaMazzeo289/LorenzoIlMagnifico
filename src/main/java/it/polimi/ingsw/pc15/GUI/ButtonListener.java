package it.polimi.ingsw.pc15.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.polimi.ingsw.pc15.GUI.frame.AttivaLeaderPopup;
import it.polimi.ingsw.pc15.GUI.frame.CarteScomunica;
import it.polimi.ingsw.pc15.GUI.frame.ConvertiPrivilegio;
import it.polimi.ingsw.pc15.GUI.frame.FrameInformazioniPlayer;
import it.polimi.ingsw.pc15.GUI.frame.FrameMostraCartePlayer;
import it.polimi.ingsw.pc15.GUI.frame.GiocaLeaderPopup;
import it.polimi.ingsw.pc15.GUI.frame.ScartaLeaderPopup;
import it.polimi.ingsw.pc15.GUI.frame.SelezionaFamiliarePopup;
import it.polimi.ingsw.pc15.GUI.frame.SelezionaMetodoPagamento;
import it.polimi.ingsw.pc15.GUI.frame.SelezionaNumeroServitori;
import it.polimi.ingsw.pc15.GUI.gameboard.Gameboard;
import it.polimi.ingsw.pc15.GUI.gameboard.SpazioProduzione1;
import it.polimi.ingsw.pc15.GUI.gameboard.SpazioRaccolto1;
import it.polimi.ingsw.pc15.GUI.playerboard.PlayerBoard;
import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Player;

public class ButtonListener implements ActionListener{

	private SelezionaFamiliarePopup selezionaFamiliarePopup;
	private SelezionaNumeroServitori selezionaNumeroServitori;
	private GiocaLeaderPopup giocaLeaderPopup;
	private ColoreFamiliare coloreFamiliareScelto = null;
	private AttivaLeaderPopup attivaLeaderPopup;
	private ScartaLeaderPopup scartaLeaderPopup;
	private FrameInformazioniPlayer frameInformazioniPlayer;
	private ConvertiPrivilegio convertiPrivilegio;
	private SelezionaMetodoPagamento selezionaMetodoPagamento;
	private boolean fromConsiglio = false;
	private boolean servitoriInseriti = false;
	private GUI gui;
	private PlayerBoard playerBoard;
	private Gameboard gameboard;
	
	
	public ButtonListener(GUI gui) {
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		playerBoard = (PlayerBoard) gui.mainFrame.getContentPane().getComponent(1);
		gameboard = (Gameboard) gui.mainFrame.getContentPane().getComponent(0);
		
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
			if(gui.tuoTurno()) {
				giocaLeaderPopup = new GiocaLeaderPopup(this, gui);
				gui.clearMessage(); 
				gui.writeMessage("gioca Leader");
			}
		}
		
		if (e.getActionCommand().equals("attivaEffettoLeader")) {
			if(gui.tuoTurno()) {
				attivaLeaderPopup = new AttivaLeaderPopup(this, gui);
				gui.clearMessage(); 
				gui.writeMessage("attiva effetto Leader");
			}
				
		}
		
		if (e.getActionCommand().equals("scartaCartaLeader")) {
			if(gui.tuoTurno()) {
				scartaLeaderPopup = new ScartaLeaderPopup(this, gui);
				gui.clearMessage(); 
				gui.writeMessage("scarta Leader");
			}
		}
		
		if (e.getActionCommand().equals("buttonScomuniche")) {
			CarteScomunica carteScomunica = new CarteScomunica(gui.getPathCartaScomunica1(),gui.getPathCartaScomunica2(),gui.getPathCartaScomunica3());
		}
		
		if(e.getActionCommand().equals("buttonStatoGioco")) {
			frameInformazioniPlayer = new FrameInformazioniPlayer(gui.getarrayListAvversari(), gui);
		}
		
		if (e.getActionCommand().equals("posizionaFamiliare")) {
			if(gui.tuoTurno()) {
				selezionaFamiliarePopup = new SelezionaFamiliarePopup(this, gui.getPlayerCorrente());
				gui.clearMessage(); 
				gui.writeMessage("posiziona familiare");
			}
		}
		
		//------------------------------------------------------------------------------------//
		// SELEZIONATO FAMILIARE BIANCO
		//------------------------------------------------------------------------------------//
		if(e.getActionCommand().equals("selezionatoFamiliareBianco")) {
			//playerBoard.getPanelSpazioFamiliariDisponibili().utilizzaFamiliare(ColoreFamiliare.BIANCO);
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
			//playerBoard.getPanelSpazioFamiliariDisponibili().utilizzaFamiliare(ColoreFamiliare.ARANCIONE);
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
			selezionaNumeroServitori = new SelezionaNumeroServitori(this);
			
		}
		
		//------------------------------------------------------------------------------------//
		// SELEZIONATO FAMILIARE NERO
		//------------------------------------------------------------------------------------//
		if(e.getActionCommand().equals("selezionatoFamiliareNero")) {
			//playerBoard.getPanelSpazioFamiliariDisponibili().utilizzaFamiliare(ColoreFamiliare.NERO);
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
			selezionaNumeroServitori = new SelezionaNumeroServitori(this);
		}
		
		//------------------------------------------------------------------------------------//
		// SELEZIONATO FAMILIARE NEUTRO
		//------------------------------------------------------------------------------------//
		if(e.getActionCommand().equals("selezionatoFamiliareNeutro")) {
			//playerBoard.getPanelSpazioFamiliariDisponibili().utilizzaFamiliare(ColoreFamiliare.NEUTRO);
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
			selezionaNumeroServitori = new SelezionaNumeroServitori(this);
		}
		
		
		
		if(e.getActionCommand().equals("siServitori")) {
			servitoriInseriti = true;
			selezionaNumeroServitori.dispose();
			selezionaNumeroServitori.numeroServitoriPopup();
		}
		
		if(e.getActionCommand().equals("noServitori")) {
			servitoriInseriti = true;
			gui.writeMessage("0");
			selezionaNumeroServitori.dispose();
		}
		
		if(e.getActionCommand().equals("sceltoPagamentoRisorse")) {
			gui.writeMessage("1");
			selezionaMetodoPagamento.dispose();
			concludiPresaViola();
		}
		
		if(e.getActionCommand().equals("sceltoPagamentoPuntiMilitari")) {
			gui.writeMessage("2");
			selezionaMetodoPagamento.dispose();
			concludiPresaViola();
		}
		
		if(e.getActionCommand().equals("submitNumeroServitori")) {
			System.out.println(selezionaNumeroServitori.getInputNumero());
			gui.writeMessage(Integer.toString(selezionaNumeroServitori.getInputNumero()));
			selezionaNumeroServitori.getPopupNumeroServitori().dispose();
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
		if(e.getActionCommand().startsWith("spazioTorre")) {
			
			if(coloreFamiliareScelto!=null && servitoriInseriti) {
				
				String coloreTorre = e.getActionCommand().substring(11, e.getActionCommand().length()-1);
				String numeroTorre = e.getActionCommand().substring(coloreTorre.length()+11);
				
				gui.writeMessage("torre");
				int numeroTorreInt = Integer.parseInt(numeroTorre)-1;
				gui.writeMessage(coloreTorre.toLowerCase());
				gui.writeMessage(Integer.toString(numeroTorreInt));
				
				
				if(coloreTorre.toUpperCase().equals("VIOLA")) {
					int scelta = gui.sceltaRichiesta(numeroTorreInt);
					if(scelta==0)
						selezionaMetodoPagamento = new SelezionaMetodoPagamento(this);
					else
						if(scelta==1) {
							gui.writeMessage("1");
							concludiPresaViola();
						}
						else {
							gui.writeMessage("2");
							concludiPresaViola();
						}
				}
				else {
					
					gui.writeMessage("0");
				
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
					
					coloreFamiliareScelto=null;
					servitoriInseriti = false;
					gui.inviaMessaggio();	
				}
			}
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO CONSIGLIO
		//------------------------------------------------------------------------------------------//
		if(e.getActionCommand().startsWith("SpazioConsiglioPosizione")){
			if(coloreFamiliareScelto!=null && servitoriInseriti) {
			
				gui.writeMessage("consiglio");
				String index = e.getActionCommand().substring(24);
				gui.writeMessage(index);
				
				
				fromConsiglio = true;
				convertiPrivilegio = new ConvertiPrivilegio(this);
				
			}
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO PRODUZIONE 1 LISTENER
		//------------------------------------------------------------------------------------------//
		if(e.getActionCommand().equals("spazioProduzione1")){
			
			if(coloreFamiliareScelto!=null && servitoriInseriti) {
				
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
				servitoriInseriti = false;
				gui.inviaMessaggio();
			}
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO PRODUZIONE 2 LISTENER
		//------------------------------------------------------------------------------------------//
		if(e.getActionCommand().startsWith("SpazioProduzionePosizione")){
			if(coloreFamiliareScelto!=null && servitoriInseriti) {
				
				gui.writeMessage("produzione");
				String index = e.getActionCommand().substring(25);
				gui.writeMessage(index);
				
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				
				coloreFamiliareScelto=null;
				servitoriInseriti = false;
			}
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO RACCOLTO 1 LISTENER
		//------------------------------------------------------------------------------------------//
		if(e.getActionCommand().equals("spazioRaccolto1")){
			
			if(coloreFamiliareScelto!=null && servitoriInseriti) {
				
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
				servitoriInseriti = false;
				gui.inviaMessaggio();
			}
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO RACCOLTO 2 LISTENER
		//------------------------------------------------------------------------------------------//
		if(e.getActionCommand().startsWith("SpazioRaccoltoPosizione")){
			if(coloreFamiliareScelto!=null && servitoriInseriti) {
		
				gui.writeMessage("raccolta");
				String index = e.getActionCommand().substring(23);
				gui.writeMessage(index);
				
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				
				coloreFamiliareScelto=null;
				servitoriInseriti = false;
				gui.inviaMessaggio();
			}
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO MERCATO
		//------------------------------------------------------------------------------------------//
		if(e.getActionCommand().equals("spazioMercato1")) {
			
			if(coloreFamiliareScelto!=null && servitoriInseriti) {	
				
				gui.writeMessage("mercato");
				gui.writeMessage("0");	
				
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				
				coloreFamiliareScelto=null;
				servitoriInseriti = false;
				gui.inviaMessaggio();
				
			}
		}
		
		if(e.getActionCommand().equals("spazioMercato2")) {
			
			if(coloreFamiliareScelto!=null && servitoriInseriti) {	
				
				gui.writeMessage("mercato");
				gui.writeMessage("1");	
				
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				
				coloreFamiliareScelto=null;
				servitoriInseriti = false;
				gui.inviaMessaggio();
			}
		}
		
		if(e.getActionCommand().equals("spazioMercato3")) {
			
			if(coloreFamiliareScelto!=null && servitoriInseriti) {	
				
				gui.writeMessage("mercato");
				gui.writeMessage("2");	
				
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				
				coloreFamiliareScelto=null;
				servitoriInseriti = false;
				gui.inviaMessaggio();
			}
		}
		
		if(e.getActionCommand().equals("spazioMercato4")) {
			
			if(coloreFamiliareScelto!=null && servitoriInseriti) {	
				
				gui.writeMessage("mercato");
				gui.writeMessage("3");	
				
				{
					playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
					playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
					playerBoard.getButtonGiocaLeader().sbloccaButton();
					playerBoard.getButtonScartaLeader().sbloccaButton();
				}
				
				coloreFamiliareScelto=null;
				servitoriInseriti = false;	
				gui.inviaMessaggio();
			}
		}
		
		//------------------------------------------------------------------------------------//
		// GESTIONE LEADER
		//------------------------------------------------------------------------------------//
		if(tipo.startsWith("leader")) {
			String numeroLeader = tipo.substring(6, 7);
			String azione = tipo.substring(7);
			
			if(azione.equals("Gioca")){
				giocaLeaderPopup.dispose();
				gui.writeMessage(numeroLeader);
				gui.inviaMessaggio();
			}
			if(azione.equals("Attiva")){
				attivaLeaderPopup.dispose();
				gui.writeMessage(numeroLeader);
				gui.inviaMessaggio();
			}
			if(azione.equals("Scarta")){
				scartaLeaderPopup.dispose();
				gui.writeMessage(numeroLeader);
				convertiPrivilegio = new ConvertiPrivilegio(this);
			}
		}
		
		//------------------------------------------------------------------------------------//
		// PRIVILEGI
		//------------------------------------------------------------------------------------//
		if(e.getActionCommand().startsWith("privilegioIn")){
			convertiPrivilegio.dispose();
			String risorsa = e.getActionCommand().substring(12);
			switch(risorsa.toUpperCase()) {
			case "PIETRALEGNA": gui.writeMessage("1");
				break;
			case "SERVITORI": gui.writeMessage("2");
				break;
			case "ORO": gui.writeMessage("3");
				break;
			case "MILITARI": gui.writeMessage("4");
				break;
			case "FEDE": gui.writeMessage("5");
				break;
			}
			
			if(!fromConsiglio)
				gui.inviaMessaggio();
			else
				concludiPresaConsiglio();
		}
		
		//------------------------------------------------------------------------------------//
		// RAPPORTO VATICANO
		//------------------------------------------------------------------------------------//
		if(e.getActionCommand().equals("sceltoPagarePuntiFede")) {
			gui.getFrameRapportoVaticano().dispose();
			gui.writeMessage("1");
			gui.inviaSenzaControllo();
		}
		if(e.getActionCommand().equals("sceltoSubireScomunica")) {
			gui.getFrameRapportoVaticano().dispose();
			gui.writeMessage("2");
			gui.inviaSenzaControllo();
		}
	}
	
	public void concludiPresaViola() {
		
		playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
		playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
		playerBoard.getButtonGiocaLeader().sbloccaButton();
		playerBoard.getButtonScartaLeader().sbloccaButton();
		
		coloreFamiliareScelto=null;
		servitoriInseriti = false;
		gui.inviaMessaggio();	
	}
	
	public void concludiPresaConsiglio() {
		
		{
			playerBoard.getButtonPosizionaFamiliare().sbloccaButton();
			playerBoard.getButtonAttivaEffettoLeader().sbloccaButton();
			playerBoard.getButtonGiocaLeader().sbloccaButton();
			playerBoard.getButtonScartaLeader().sbloccaButton();
		}
		
		coloreFamiliareScelto=null;
		servitoriInseriti = false;
		fromConsiglio=false;
		gui.inviaMessaggio();
	}
}
