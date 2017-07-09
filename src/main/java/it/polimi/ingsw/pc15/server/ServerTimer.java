package it.polimi.ingsw.pc15.server;

import java.util.HashMap;

import it.polimi.ingsw.pc15.ParserXML;

public class ServerTimer implements Runnable {
	
	private Server server;
	
	public ServerTimer (Server server) {
		this.server = server;
	}

	@Override
	public void run() {
		for (int i=ParserXML.leggiValore("durataTimerServer"); i>0; i--) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { // NOSONAR
			}
			
			System.out.println(i + " secondi all'inizio della partita");
			
		}
		
		try {
			server.avviaPartita();
		} catch (IndexOutOfBoundsException e ) {}
		
	}

}
