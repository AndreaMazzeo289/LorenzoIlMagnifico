package it.polimi.ingsw.pc15.server;

import java.util.Observable;
import java.util.Observer;

public abstract class ServerView extends Observable implements Observer {

	public abstract void sendLine(String string);
	
	public abstract String getName();

}
