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
	
	@Override
	public void connetti() {
		
		System.out.println("RMIHandler: tentativo di connessione...");
		
		try {
			this.server = (ServerInterface) Naming.lookup("//localhost/Server");
			RMIHandlerInterface remoteRef = (RMIHandlerInterface) UnicastRemoteObject.exportObject(this, 0);
			this.numeroConnessione = server.remoteConnetti(remoteRef);

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();  // NOSONAR
		}		

	}

	@Override
	public void update(Observable o, Object input) {
		//System.out.println("\nSono il RMIHandler e ho ricevuto " + (ArrayList<String>) input);
		try {
			this.server.remoteNotify(input, numeroConnessione);
		} catch (RemoteException e) {
			e.printStackTrace(); // NOSONAR
		}
	}

	@Override
	public void aggiornaStatoPartita(StatoPartita statoPartita) throws RemoteException {
		
		for (SpazioTorre spazio : statoPartita.getStatoPlancia().getTorre(TipoCarta.TERRITORIO).getSpaziTorre())
			System.out.println(spazio.getCarta().toString());
		
		this.clientModel.aggiorna(statoPartita);	
	}

	@Override
	public String remoteGetNome() throws RemoteException {
		return this.name;
	}
	
	@Override
	public void remoteOK() throws RemoteException {
		setChanged();
		notifyObservers();
	}
	

	
}
