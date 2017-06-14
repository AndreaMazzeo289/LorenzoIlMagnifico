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

import it.polimi.ingsw.pc15.model.StatoPartita;
import it.polimi.ingsw.pc15.server.ServerInterface;

public class RMIHandler extends NetworkHandler implements RMIHandlerInterface {
	
	private ClientModel clientModel;
	private int numeroConnessione;
	private ServerInterface server;
	
	public RMIHandler (ClientModel clientModel) {
		this.clientModel = clientModel;
	}
	
	@Override
	public boolean connetti() {
		
		try {
			this.server = (ServerInterface) Naming.lookup("//localhost/Server");
			RMIHandlerInterface remoteRef = (RMIHandlerInterface) UnicastRemoteObject.exportObject(this, 0);
			this.numeroConnessione = server.remoteConnetti(remoteRef);
			return true;

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
			return false;
		}

	}
	


	@Override
	public void update(Observable o, Object input) {
		System.out.println("\nSono il Client controller RMI e ho ricevuto " + (ArrayList<String>) input);
		try {
			this.server.remoteNotify(input, numeroConnessione);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void aggiornaStatoPartita(StatoPartita statoPartita) throws RemoteException {

		this.clientModel.aggiorna(statoPartita);
		
	}
	
}
