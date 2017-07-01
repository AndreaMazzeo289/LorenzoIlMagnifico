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
	
	private int numeroConnessione;
	private ServerInterface server;
	private boolean connesso;
	
	public RMIHandler (ClientModel clientModel, String name) {	
		super(name, clientModel);
		this.connesso = false;
	}
	
	@Override
	public boolean connetti() {
		
		try {
			this.server = (ServerInterface) Naming.lookup("//localhost/Server");
			RMIHandlerInterface remoteRef = (RMIHandlerInterface) UnicastRemoteObject.exportObject(this, 0);
			this.numeroConnessione = server.remoteConnetti(remoteRef);
			while(!connesso);

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;

	}

	@Override
	public void update(Observable o, Object input) {
		System.out.println("\nSono il RMIHandler e ho ricevuto " + (ArrayList<String>) input);
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

	@Override
	public String remoteGetNome() throws RemoteException {
		return this.name;
	}
	
	public void remoteOK() throws RemoteException {
		this.connesso = true;
	}
	
}
