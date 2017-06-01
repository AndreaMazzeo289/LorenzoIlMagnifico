package it.polimi.ingsw.pc15.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote {
	
	public void addClient() throws RemoteException;
	
	public void send(String message) throws RemoteException;

}
