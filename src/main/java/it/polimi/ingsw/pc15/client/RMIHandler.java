package it.polimi.ingsw.pc15.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.model.StatoPartita;
import it.polimi.ingsw.pc15.plancia.SpazioTorre;
import it.polimi.ingsw.pc15.server.ServerInterface;

public class RMIHandler extends NetworkHandler implements RMIHandlerInterface {
	
	private int numeroConnessione;
	private transient ServerInterface server;
	
	public RMIHandler (ClientModel clientModel, String name) {	
		super(name, clientModel);
	}
	
	
	/**
	 * Effettua il lookup del server e ne invoca il corrispondente metodo remoto remoteConnetti. 
	 * Setta l'attributo numeroConnessione in base al valore di ritorno della chiamata
	 */
	
	@Override
	public void connetti() {
		
		try {
			this.server = (ServerInterface) Naming.lookup("//localhost/Server");
			RMIHandlerInterface remoteRef = (RMIHandlerInterface) UnicastRemoteObject.exportObject(this, 0);
			this.numeroConnessione = server.remoteConnetti(remoteRef);
			System.out.println("Connessione al server riuscita! In attesa di altri giocatori\n");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();  // NOSONAR
		}		

	}
	
	
	/**
	 * invoca il metodo remoto del server remoteNotify, passando il proprio numero di connessione. 
	 * remoteNotify notificherà la view corrispondente al numero con l'oggetto passato come input.
	 */

	@Override
	public void update(Observable o, Object input) {
		try {
			this.server.remoteNotify(input, numeroConnessione);
		} catch (RemoteException e) {
			e.printStackTrace(); // NOSONAR
		}
	}
	
	/**
	 * Chiama il metodo aggiorna del clientModel per aggiornarne i valori
	 * 
	 * @param StatoPartita con valori aggiornati
	 */

	@Override
	public void aggiornaStatoPartita(StatoPartita statoPartita) throws RemoteException {
		
		this.clientModel.aggiorna(statoPartita);	
	}

	@Override
	public String remoteGetNome() throws RemoteException {
		return this.name;
	}
	
	
	/**
	 * Metodo remoto invocato dalla RMIView corrispondente. Informa il client che la
	 * connessione è riuscita con successo.
	 */
	@Override
	public void remoteOK() throws RemoteException {
		setChanged();
		notifyObservers();
	}
	

	
}
