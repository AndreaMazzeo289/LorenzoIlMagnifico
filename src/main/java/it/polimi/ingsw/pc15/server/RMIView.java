package it.polimi.ingsw.pc15.server;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import it.polimi.ingsw.pc15.client.RMIHandlerInterface;
import it.polimi.ingsw.pc15.model.StatoPartita;

public class RMIView extends ServerView {
	
	private RMIHandlerInterface rmiHandler;
	private BlockingQueue<StatoPartita> aggiornamenti;
	
	public RMIView (RMIHandlerInterface rmiHandler) {
		this.rmiHandler = rmiHandler;
		this.aggiornamenti = new LinkedBlockingQueue<StatoPartita>(5);
		
		try {
			this.name = rmiHandler.remoteGetNome();
		} catch (RemoteException e) {
			System.out.println("Errore");
			this.name = "Player"; 
		}
	}

	public void run() {
		
		StatoPartita statoPartita = null;
		
		while(true) {
			
			try {
				statoPartita = aggiornamenti.take();
			} catch (InterruptedException e) {  //NOSONAR
				e.printStackTrace();
			}
			
			try {
				rmiHandler.aggiornaStatoPartita(statoPartita);
			} catch (RemoteException e) {
				setChanged();
				notifyObservers(new ArrayList<String>(Arrays.asList("CONNESSIONE CHIUSA")) );				
			}
		}
	}
	
	@Override
	public void update(Observable arg0, Object arg) {

		StatoPartita statoPartita = (StatoPartita)arg;
		statoPartita.setStatoGiocatore(this.name);
		
		//System.out.println("\nSono la RMIView di " + name + " e ho ricevuto " + statoPartita.getMessaggio())
		aggiornamenti.add(statoPartita.clone());
		
	}
	
	public void notificaOsservatori(ArrayList<String> message) {
		setChanged();
		notifyObservers(message);
	}
	
	public void sendOK() {
		try {
			this.rmiHandler.remoteOK();
		} catch (RemoteException e) {
			e.printStackTrace(); // NOSONAR
		}
	}

}
