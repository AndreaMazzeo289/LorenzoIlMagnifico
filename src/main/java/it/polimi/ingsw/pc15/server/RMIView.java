package it.polimi.ingsw.pc15.server;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.sun.javafx.scene.control.skin.NestedTableColumnHeader;

import it.polimi.ingsw.pc15.client.RMIHandlerInterface;
import it.polimi.ingsw.pc15.model.StatoPartita;

/**
 *Sottoclasse di ServerView, specifica per l'implementazione di RMI, contiene il riferimento
 *allo specifico RMIHandler del giocatore, di cui invoca i metodi remoti
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

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
		
		while(true) { //NOSONAR
			
			try {
				statoPartita = aggiornamenti.take();
			} catch (InterruptedException e) {  //NOSONAR
				e.printStackTrace();  //NOSONAR
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
		
		aggiornamenti.add(statoPartita.clone());
		
	}
	
	/**
	 * metodo remoto per notificare un messaggio agli Osservatori della RMIView
	 * 
	 * @param message messaggio da notificare
	 */
	
	public void notificaOsservatori(ArrayList<String> message) {
		setChanged();
		notifyObservers(message);
	}
	
	/**
	 * Invoca il metodo remoto remoteOK dell'RMIHandler, in modo 
	 * da notificare l'avvenuta connessione
	 */
	
	public void sendOK() {
		try {
			this.rmiHandler.remoteOK();
		} catch (RemoteException e) {
			e.printStackTrace(); // NOSONAR
		}
	}

}
