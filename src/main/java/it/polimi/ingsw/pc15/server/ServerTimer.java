package it.polimi.ingsw.pc15.server;

import it.polimi.ingsw.pc15.ParserXML;

public class ServerTimer implements Runnable {
	
	private Server server;
	
	public ServerTimer (Server server) {
		this.server = server;
	}

	@Override
	public void run() {
		for (int i=ParserXML.leggiValore("durataTimerServer")/10; i>0; i--) {
			
			System.out.println(i*10 + " secondi all'inizio della partita");
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) { // NOSONAR
			}
			

			
		}
		
		try {
			server.avviaPartita();
		} catch (IndexOutOfBoundsException e ) {}
		
	}

}
