package it.polimi.ingsw.pc15.server;

import java.util.Observable;
import java.util.Observer;

/**
 *Superclasse astratta di RMIView e SocketView. Implementa Observer per osservare il model
 *e estende Observable per essere osservata dal controller
 *
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */


public abstract class ServerView extends Observable implements Observer, Runnable {
	
	protected String name;

	@Override
	public abstract void update(Observable arg0, Object arg1);
	
	public String getName() {
		return this.name;
	}

}
