package it.polimi.ingsw.pc15.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Observer;

import it.polimi.ingsw.pc15.server.ServerInterface;

public class RMIHandler extends Observable implements Observer{
	
	private ClientModel clientModel;
	private int numeroConnessione;
	
	public RMIHandler (ClientModel clientModel) {
		
		this.clientModel = clientModel;
	}
	
	public void connetti() throws MalformedURLException, RemoteException, NotBoundException {
		
		ServerInterface server;
		server = (ServerInterface) Naming.lookup("//localhost/Server");
		numeroConnessione = server.connetti("CIAO");

	}


	@Override
	public void update(Observable o, Object input) {
	
		//System.out.println("\nSono il Client controller RMI e ho ricevuto " + (ArrayList<String>) input);
	}
	
}
