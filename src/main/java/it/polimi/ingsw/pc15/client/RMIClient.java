package it.polimi.ingsw.pc15.client;

import java.io.IOException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Observable;

import it.polimi.ingsw.pc15.GUI.GUI;

public class RMIClient extends Client {
	
	/**
	 *Sottoclasse di Client che implementa la connessione tramite Socket. Utilizza un RMIHandler
	 *per gestire l'invocazione dei metodi in remoto.
	 *
	 * @author AndreaMazzeo289
	 * @author AndreaMaffe
	 * @author FrancescoGuzzo
	 *
	 */
	
	public RMIClient(String nome, int tipoView) throws IOException {
		super();
		this.networkHandler = new RMIHandler(clientModel, nome);
		networkHandler.addObserver(this);
		if (tipoView==1)
			this.view = new CLI(this.networkHandler, this.clientModel);
		else this.view = new GUI(this.networkHandler, this.clientModel);

	}

	@Override
	public void update(Observable o, Object arg) {
		new Thread(view).start();
	}
	
	
	
}

