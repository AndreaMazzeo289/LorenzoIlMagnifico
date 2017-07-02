package it.polimi.ingsw.pc15.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Observable;

import it.polimi.ingsw.pc15.client.RMIHandler;
import it.polimi.ingsw.pc15.client.RMIHandlerInterface;
import it.polimi.ingsw.pc15.model.StatoPartita;

public class RMIView extends ServerView {
	
	private RMIHandlerInterface rmiHandler;
	
	public RMIView (RMIHandlerInterface rmiHandler) {
		this.rmiHandler = rmiHandler;
		try {
			this.name = rmiHandler.remoteGetNome();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void sendLine(String string) {
		
	}

	@Override
	public void update(Observable arg0, Object arg) {

		StatoPartita statoPartita = (StatoPartita)arg;
		System.out.println("\nSono la connection di " + name + " e ho ricevuto " + statoPartita.getMessaggio());
		statoPartita.setStatoGiocatore(name);
		
		try {
			rmiHandler.aggiornaStatoPartita(statoPartita);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
	
	public void notificaOsservatori(ArrayList<String> message) {
		setChanged();
		notifyObservers(message);
	}
	
	public void sendOK() {
		try {
			this.rmiHandler.remoteOK();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

	}

}
