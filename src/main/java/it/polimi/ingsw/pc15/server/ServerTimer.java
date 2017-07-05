package it.polimi.ingsw.pc15.server;

import java.util.HashMap;

import it.polimi.ingsw.pc15.ParserXML;

public class ServerTimer implements Runnable {
	
	private HashMap<String, ServerView> giocatori;
	private Server server;
	
	public ServerTimer (HashMap<String, ServerView> giocatori, Server server) {
		this.giocatori = giocatori;
		this.server = server;
	}

	@Override
	public void run() {
		for (int i=ParserXML.leggiValore("durataTimerServer"); i>0; i--) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			
			System.out.println(i + " secondi all'inizio della partita");
			
		}
		
		server.avviaPartita();
		
	}

}