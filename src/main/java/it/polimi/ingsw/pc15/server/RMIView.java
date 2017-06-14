package it.polimi.ingsw.pc15.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import it.polimi.ingsw.pc15.client.RMIHandler;
import it.polimi.ingsw.pc15.client.RMIHandlerInterface;

public class RMIView  extends ServerView {
	
	private RMIHandlerInterface rmiHandler;
	
	public RMIView (RMIHandlerInterface rmiHandler) {
		this.rmiHandler = rmiHandler;
	}
	
	@Override
	public void sendLine(String string) {
		
	}

	@Override
	public String getName() {
		return null;
	}

}
