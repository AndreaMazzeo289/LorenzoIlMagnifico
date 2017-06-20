package it.polimi.ingsw.pc15.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListenerSpazi implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		System.out.println("ciao");
		
		//------------------------------------------------------------------------------------------//
		// SPAZI TORRE VERDE
		//------------------------------------------------------------------------------------------//
		if(arg0.getActionCommand().equals("spazioTorreVerde1"))
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreVerde1().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		
		if(arg0.getActionCommand().equals("spazioTorreVerde2"))
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreVerde2().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		
		if(arg0.getActionCommand().equals("spazioTorreVerde3"))
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreVerde3().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		
		if(arg0.getActionCommand().equals("spazioTorreVerde4"))
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreVerde4().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		
		//------------------------------------------------------------------------------------------//
		// SPAZI TORRE BLU
		//------------------------------------------------------------------------------------------//
		if(arg0.getActionCommand().equals("spazioTorreBlu1"))
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreBlu1().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		
		if(arg0.getActionCommand().equals("spazioTorreBlu2"))
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreBlu2().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		
		if(arg0.getActionCommand().equals("spazioTorreBlu3"))
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreBlu3().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		
		if(arg0.getActionCommand().equals("spazioTorreBlu4"))
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreBlu4().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		
		//------------------------------------------------------------------------------------------//
		// SPAZI TORRE VIOLA
		//------------------------------------------------------------------------------------------//
		if(arg0.getActionCommand().equals("spazioTorreViola1"))
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreViola1().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		
		if(arg0.getActionCommand().equals("spazioTorreViola2"))
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreViola2().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		
		if(arg0.getActionCommand().equals("spazioTorreViola3"))
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreViola3().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		
		if(arg0.getActionCommand().equals("spazioTorreViola4"))
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreViola4().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
				
		//------------------------------------------------------------------------------------------//
		// SPAZI TORRE GIALLA
		//------------------------------------------------------------------------------------------//
		if(arg0.getActionCommand().equals("spazioTorreGialla1"))
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreGialla1().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		
		if(arg0.getActionCommand().equals("spazioTorreGialla2"))
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreGialla2().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		
		if(arg0.getActionCommand().equals("spazioTorreGialla3"))
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreGialla3().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		
		if(arg0.getActionCommand().equals("spazioTorreGialla4"))
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreGialla4().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO CONSIGLIO
		//------------------------------------------------------------------------------------------//
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione1")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione1());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione2")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione2());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione3")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione3());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione4")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione4());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione5")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione5());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione6")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione6());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione7")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione7());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione8")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione8());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione9")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione9());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione10")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione10());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione11")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione11());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione12")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione12());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione13")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione13());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione14")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione14());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione15")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione15());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione16")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioConsiglio.getButtonPosizione16());
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO PRODUZIONE 1 LISTENER
		//------------------------------------------------------------------------------------------//
		if(arg0.getActionCommand().equals("spazioProduzione1")){
			SpazioProduzione1 spazioProduzione1 = (SpazioProduzione1)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione1();
			spazioProduzione1.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO PRODUZIONE 2 LISTENER
		//------------------------------------------------------------------------------------------//
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione1")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione1());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione2")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione2());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione3")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione3());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione4")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione4());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione5")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione5());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione6")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione6());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione7")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione7());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione8")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione8());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione9")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione9());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione10")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione10());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione11")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione11());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione12")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione12());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione13")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione13());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione14")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione14());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione15")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione15());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione16")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioProduzione2.getButtonPosizione16());
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO RACCOLTO 1 LISTENER
		//------------------------------------------------------------------------------------------//
		if(arg0.getActionCommand().equals("spazioRaccolto1")){
			SpazioRaccolto1 spazioRaccolto1 = (SpazioRaccolto1)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto1();
			spazioRaccolto1.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO RACCOLTO 2 LISTENER
		//------------------------------------------------------------------------------------------//
		if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione1")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione1());
		}
		
		if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione2")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione2());
		}
		
		if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione3")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione3());
		}
		
		if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione4")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione4());
		}
		
		if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione5")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione5());
		}
		
		if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione6")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione6());
		}
		
		if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione7")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione7());
		}
		
		if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione8")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione8());
		}
		
		if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione9")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione9());
		}
		
		if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione10")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione10());
		}
		
		if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione11")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione11());
		}
		
		if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione12")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione12());
		}
		
		if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione13")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione13());
		}
		
		if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione14")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione14());
		}
		
		if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione15")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione15());
		}
		
		if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione16")){
			SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
			spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png",spazioRaccolto.getButtonPosizione16());
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO MERCATO
		//------------------------------------------------------------------------------------------//
		if(arg0.getActionCommand().equals("spazioMercato1"))
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioMercato1().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		
		if(arg0.getActionCommand().equals("spazioMercato2"))
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioMercato2().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		
		if(arg0.getActionCommand().equals("spazioMercato3"))
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioMercato3().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
		
		if(arg0.getActionCommand().equals("spazioMercato4"))
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioMercato4().inserisciFamiliare("img/Punchboard/familiari/pedineFamiliari/blu/neutro.png");
	}

}
