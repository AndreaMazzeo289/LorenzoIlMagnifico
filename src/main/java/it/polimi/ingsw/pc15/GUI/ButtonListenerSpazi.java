package it.polimi.ingsw.pc15.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListenerSpazi implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		System.out.println("ciao");
		
		if(arg0.getActionCommand().equals("spazioTorreVerde1"))
			((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioTorreVerde1().inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png");
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO CONSIGLIO
		//------------------------------------------------------------------------------------------//
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione1")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioConsiglio.getButtonPosizione1());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione2")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioConsiglio.getButtonPosizione2());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione3")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioConsiglio.getButtonPosizione3());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione4")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioConsiglio.getButtonPosizione4());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione5")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioConsiglio.getButtonPosizione5());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione6")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioConsiglio.getButtonPosizione6());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione7")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioConsiglio.getButtonPosizione7());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione8")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioConsiglio.getButtonPosizione8());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione9")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioConsiglio.getButtonPosizione9());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione10")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioConsiglio.getButtonPosizione10());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione11")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioConsiglio.getButtonPosizione11());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione12")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioConsiglio.getButtonPosizione12());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione13")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioConsiglio.getButtonPosizione13());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione14")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioConsiglio.getButtonPosizione14());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione15")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioConsiglio.getButtonPosizione15());
		}
		
		if(arg0.getActionCommand().equals("SpazioConsiglioPosizione16")){
			SpazioConsiglio spazioConsiglio = (SpazioConsiglio)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioConsiglio();
			spazioConsiglio.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioConsiglio.getButtonPosizione16());
		}
		
		//------------------------------------------------------------------------------------------//
		// SPAZIO PRODUZIONE 2 LISTENER
		//------------------------------------------------------------------------------------------//
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione1")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioProduzione2.getButtonPosizione1());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione2")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioProduzione2.getButtonPosizione2());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione3")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioProduzione2.getButtonPosizione3());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione4")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioProduzione2.getButtonPosizione4());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione5")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioProduzione2.getButtonPosizione5());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione6")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioProduzione2.getButtonPosizione6());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione7")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioProduzione2.getButtonPosizione7());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione8")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioProduzione2.getButtonPosizione8());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione9")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioProduzione2.getButtonPosizione9());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione10")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioProduzione2.getButtonPosizione10());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione11")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioProduzione2.getButtonPosizione11());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione12")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioProduzione2.getButtonPosizione12());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione13")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioProduzione2.getButtonPosizione13());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione14")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioProduzione2.getButtonPosizione14());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione15")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioProduzione2.getButtonPosizione15());
		}
		
		if(arg0.getActionCommand().equals("SpazioProduzionePosizione16")){
			SpazioProduzione2 spazioProduzione2 = (SpazioProduzione2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioProduzione2();
			spazioProduzione2.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioProduzione2.getButtonPosizione16());
		}
		
		//------------------------------------------------------------------------------------------//
			// SPAZIO PRODUZIONE 2 LISTENER
			//------------------------------------------------------------------------------------------//
			if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione1")){
				SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
				spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioRaccolto.getButtonPosizione1());
			}
			
			if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione2")){
				SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
				spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioRaccolto.getButtonPosizione2());
			}
			
			if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione3")){
				SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
				spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioRaccolto.getButtonPosizione3());
			}
			
			if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione4")){
				SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
				spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioRaccolto.getButtonPosizione4());
			}
			
			if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione5")){
				SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
				spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioRaccolto.getButtonPosizione5());
			}
			
			if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione6")){
				SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
				spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioRaccolto.getButtonPosizione6());
			}
			
			if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione7")){
				SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
				spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioRaccolto.getButtonPosizione7());
			}
			
			if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione8")){
				SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
				spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioRaccolto.getButtonPosizione8());
			}
			
			if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione9")){
				SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
				spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioRaccolto.getButtonPosizione9());
			}
			
			if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione10")){
				SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
				spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioRaccolto.getButtonPosizione10());
			}
			
			if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione11")){
				SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
				spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioRaccolto.getButtonPosizione11());
			}
			
			if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione12")){
				SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
				spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioRaccolto.getButtonPosizione12());
			}
			
			if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione13")){
				SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
				spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioRaccolto.getButtonPosizione13());
			}
			
			if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione14")){
				SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
				spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioRaccolto.getButtonPosizione14());
			}
			
			if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione15")){
				SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
				spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioRaccolto.getButtonPosizione15());
			}
			
			if(arg0.getActionCommand().equals("SpazioRaccoltoPosizione16")){
				SpazioRaccolto2 spazioRaccolto = (SpazioRaccolto2)((Gameboard)mainGUI.mainFrame.getContentPane().getComponent(0)).getSpazioRaccolto2();
				spazioRaccolto.inserisciFamiliare("img/Punchboard/familiari/familiariSpazi/BA.png",spazioRaccolto.getButtonPosizione16());
			}
	}

}
