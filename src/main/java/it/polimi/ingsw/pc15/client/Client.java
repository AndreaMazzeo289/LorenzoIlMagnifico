package it.polimi.ingsw.pc15.client;

import java.net.Socket;
import java.util.Observer;

import it.polimi.ingsw.pc15.GUI.GUI;

/**
 *Superclasse astratta di SocketClient e RMIClient, contiene il riferimento al proprio
 *NetworkHandler (RMIHandler per RMIClient e SocketHandler per SocketClient), al proprio
 *ClientModel e alla propria ClientView
 *
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public abstract class Client implements Observer {
	
	public Client () {
		this.clientModel = new ClientModel();
	}
	
	protected NetworkHandler networkHandler;
	protected ClientModel clientModel;
	protected ClientView view;
	
	public void connetti() {
		this.networkHandler.connetti();
	}
	
}
