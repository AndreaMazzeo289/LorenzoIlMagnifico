package it.polimi.ingsw.pc15.client;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *Superclasse astratta di CLI e GUI. Contiene il riferimento al ClientModel del giocatore
 *per la lettura dei dati della partita. Osserva il ClientModel per essere notificata in caso di aggiornamenti
 *ed è osservata dal NetworkHandler, a cui notifica i messaggi da inviare al server
 *
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public abstract class ClientView extends Observable implements Observer, Runnable {
	
	protected ClientModel clientModel;
	protected ArrayList<String> message;
	
	public ClientView(NetworkHandler networkHandler, ClientModel clientModel)
	{
		this.clientModel = clientModel;
		clientModel.addObserver(this);
		this.addObserver(networkHandler);
		this.message = new ArrayList<String>();
	
	}
	
	public abstract void run();
	
	/**
	 * restituisce true se il clientModel segnala il turno del giocatore corrente,
	 * false altrimenti
	 */
	
	public boolean tuoTurno() {
    	if (this.clientModel.getGiocatoreCorrente().equals(this.clientModel.getStatoGiocatore().getNome()))
    		return true;
    	else return false;
		
	}

}

