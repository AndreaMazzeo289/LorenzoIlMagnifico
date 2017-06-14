package it.polimi.ingsw.pc15.server;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServerImplementation extends UnicastRemoteObject implements ServerInterface {
	
	private Server server;
	private ArrayList<RMIView> views;

	public ServerImplementation(Server server) throws RemoteException {
		super(0);
		this.server = server;
		this.views = new ArrayList<RMIView>();
	}

	@Override
	public int connetti(String name) throws RemoteException {
		
		RMIView rmiView = new RMIView(name);
		views.add(rmiView);
		server.connetti(rmiView, name);
		
		return views.lastIndexOf(rmiView);
		
	}

	@Override
	public void remoteNotify(Object o, int i) throws RemoteException {
		this.views.get(i).notifyObservers(o);
		
	}
	
	

}
