package it.polimi.ingsw.pc15.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.pc15.client.RMIHandler;
import it.polimi.ingsw.pc15.client.RMIHandlerInterface;

public interface ServerInterface extends Remote {
	
	public void remoteNotify(Object o, int i) throws RemoteException;

	public int remoteConnetti(RMIHandlerInterface rmiHandler) throws RemoteException;


}
