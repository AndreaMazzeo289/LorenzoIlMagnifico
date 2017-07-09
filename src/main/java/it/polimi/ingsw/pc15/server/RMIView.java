package it.polimi.ingsw.pc15.server;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import it.polimi.ingsw.pc15.client.RMIHandlerInterface;
import it.polimi.ingsw.pc15.model.StatoPartita;

public class RMIView extends ServerView {
	
	private RMIHandlerInterface rmiHandler;
	private BlockingQueue<StatoPartita> aggiornamenti;
	
	public RMIView (RMIHandlerInterface rmiHandler) {
		this.rmiHandler = rmiHandler;
		this.aggiornamenti = new ArrayBlockingQueue<StatoPartita>(5);
		
		try {
			this.name = rmiHandler.remoteGetNome();
		} catch (RemoteException e) {
			System.out.println("Errore");
			this.name = "Player"; 
		}
	}

	@Override
	public void run() {
		
		StatoPartita statoPartita = null;
		
		while(true) {
			
			try {
				statoPartita = aggiornamenti.take();
				statoPartita.setStatoGiocatore(this.name);
				System.out.println(statoPartita.getStatoGiocatore().getNome());
			} catch (InterruptedException e) {
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
		//System.out.println("\nSono la RMIView di " + name + " e ho ricevuto " + statoPartita.getMessaggio())
		aggiornamenti.add(statoPartita);
		
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
