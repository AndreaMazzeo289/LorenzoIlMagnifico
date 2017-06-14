package it.polimi.ingsw.pc15.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote {

	public int connetti(String name) throws RemoteException;
	
	public void remoteNotify(Object o, int i) throws RemoteException;

}
