package it.polimi.ingsw.pc15.server;

import java.util.Observable;
import java.util.Observer;

public abstract class ServerView extends Observable implements Observer, Runnable {
	
	protected String name;

	public abstract void sendLine(String string);

	@Override
	public abstract void update(Observable arg0, Object arg1);
	
	@Override
	public abstract void run();
	
	public String getName() {
		return this.name;
	}

}
