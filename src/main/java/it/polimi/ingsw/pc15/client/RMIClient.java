package it.polimi.ingsw.pc15.client;

import java.io.IOException;
import java.rmi.server.UnicastRemoteObject;

public class RMIClient extends Client {
	
	public RMIClient() throws IOException {
		
		this.clientModel = new ClientModel();
		this.networkHandler = new RMIHandler(clientModel, "Player");
		this.view = new CLI(networkHandler, clientModel);
	}

	@Override
	public void connetti() {
		if (networkHandler.connetti()) {
			new Thread(view).start();
		}
	}
	
}

