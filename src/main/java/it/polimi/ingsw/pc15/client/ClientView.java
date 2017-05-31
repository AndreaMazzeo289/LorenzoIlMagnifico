package it.polimi.ingsw.pc15.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;
import java.util.Observer;

public class ClientView extends Observable implements Observer {
	
	public ClientView(){}
	
	
	public void run() throws IOException{
		String read;
		while(true){
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		read = input.readLine();
		setChanged();
		notifyObservers(read);
		}
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(!(o instanceof ClientController) || !(arg instanceof String)){
			throw new IllegalArgumentException();
		}
		System.out.println(arg);
	}
}
