package it.polimi.ingsw.pc15.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;
import java.util.Observer;

public class ClientView extends Observable implements Observer {
	private String ingresso = "wait";
	
	public ClientView(){}
	
	
	public void scriviNome(String ingresso) throws IOException{
		
		String read;
		System.out.println("Scrivi il tuo nome");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		read = input.readLine();
		setChanged();
		notifyObservers(read);
	}
		
	


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(!(o instanceof ClientController) || !(arg instanceof String)){
			throw new IllegalArgumentException();
		}
		showInput(this.ingresso = (String)arg);
		if(ingresso.equals("Scrivi il tuo nome")){
			
			try {
				scriviNome(ingresso);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	private void showInput(String string) {
		// TODO Auto-generated method stub
		
	}
}
