package it.polimi.ingsw.pc15.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIView  extends ServerView {
	
	private String name;
	
	public RMIView (String name) {
		this.name = name;
	}
	
	@Override
	public void sendLine(String string) {
		
	}

	@Override
	public String getName() {
		return null;
	}

}
