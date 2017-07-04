package it.polimi.ingsw.pc15.client;

import java.io.IOException;
import java.rmi.server.UnicastRemoteObject;

import it.polimi.ingsw.pc15.GUI.GUI;

public class RMIClient extends Client {
	
	public RMIClient(String nome, int tipoView) throws IOException {
		super();
		this.networkHandler = new RMIHandler(clientModel, nome);
		if (tipoView==1)
			this.view = new CLI(this.networkHandler, this.clientModel);
		else this.view = new GUI(this.networkHandler, this.clientModel);

	}

	@Override
	public void connetti() {
		if (networkHandler.connetti())
			new Thread(view).start();
		
	}
	
}

