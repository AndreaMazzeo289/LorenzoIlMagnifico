package it.polimi.ingsw.pc15.client;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

/**
 *Superclasse astratta di SocketHandler e RMIHandler. Contiene il riferimento
 *al ClientModel del giocatore, in modo da poterlo aggiornare con le informazioni
 *ricevute dal server
 *
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public abstract class NetworkHandler extends Observable implements Observer, Serializable {
	
	protected String name;
	protected transient ClientModel clientModel;
	
	public NetworkHandler(String name, ClientModel clientModel) {
		this.clientModel = clientModel;
		this.name = name;
	}

	public abstract void connetti();

}
