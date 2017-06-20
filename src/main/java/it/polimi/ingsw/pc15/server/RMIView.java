package it.polimi.ingsw.pc15.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Observable;

import it.polimi.ingsw.pc15.client.RMIHandler;
import it.polimi.ingsw.pc15.client.RMIHandlerInterface;
import it.polimi.ingsw.pc15.model.StatoPartita;

public class RMIView extends ServerView {
	
	private RMIHandlerInterface rmiHandler;
	
	public RMIView (RMIHandlerInterface rmiHandler) {
		this.rmiHandler = rmiHandler;
	}
	
	@Override
	public void sendLine(String string) {
		
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public void update(Observable arg0, Object arg) {

		StatoPartita statoPartita = (StatoPartita)arg;
		System.out.println("\nSono la connection di  e ho ricevuto " + (statoPartita.getMessaggio()));
		
		try {
			rmiHandler.aggiornaStatoPartita(statoPartita);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
