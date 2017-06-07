package it.polimi.ingsw.pc15.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class CLI extends View {
	
	private Scanner input;
	
	public CLI(ClientController clientController){
		super(clientController);
		this.input = new Scanner(System.in);
	}


	public void run(){
		
		ArrayList<String> message = new ArrayList<String>();
		
		while (true) {
			
		System.out.println("Cosa vuoi fare?\n  1. OccupaSpazio\n  2. Gioca Leader\n  3. Scarta Leader\n  4. Attiva Leader");
			
		switch(input.nextInt()) {
		case 1: message.add("occupa spazio");
				System.out.println("\nQuale spazio vuoi occupare?\n  1. Spazio mercato\n  2. Spazio Consiglio\n  3. Spazio raccolta\n  4. Spazio produzione\n  5. Spazio torre");
				switch (input.nextInt()) {
				case 1: message.add("mercato");
						System.out.println("Quale spazio mercato vuoi occupare?");
						message.add(input.nextLine());
						break;
				case 2: message.add("consiglio");
						break;
				case 3: message.add("raccolta");
						break;
				case 4: message.add("produzione");
						break;
				case 5: message.add("torre");
				}
		case 2: message.add("gioca Leader"); 
				break;
		case 3: message.add("scarta Leader"); 
				break;
		case 4: message.add("attiva effetto Leader"); 
				break;
		default: System.out.println("Inserire un comando valido");
				break;
			}
			
		setChanged();
		notifyObservers(message);
		
		}
			
			
			
		
		
		
		
	}
}
