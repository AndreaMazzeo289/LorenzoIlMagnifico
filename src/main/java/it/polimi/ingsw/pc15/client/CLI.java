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
	private boolean tuoTurno;
	
	public CLI(ClientController clientController){
		super(clientController);
		this.input = new Scanner(System.in);
		tuoTurno = true;
	}
	
	public void run(){
		
		while (true) {
			
		System.out.println("\nCosa vuoi fare?\n  1. Visualizza risorse\n  2. Visualizza familiari disponibili\n  3. Visualizza plancia");
		if (tuoTurno)
			System.out.println("  4. Gioca");
		switch (input.nextInt()) {
		case 1: System.out.println("Hai un botto di risorse");
				break;
		case 2: System.out.println("Hai un botto di familiari");
				break;
		case 3: System.out.println("La plancia è stra figa");
				break;
		case 4: ArrayList<String> message = new ArrayList<String>();
				System.out.println("\nCosa vuoi fare?\n  1. Posiziona un familiare\n  2. Gioca una carta Leader\n  3. Scarta una carta Leader\n  4. Attiva l'effetto di una carta Leader");
				switch(input.nextInt()) {
				
				case 1: message.add("posiziona familiare");
				
						/////////////SCELTA FAMILIARE///////////////////////////////
			
						System.out.println("\nQuale familiare vuoi posizionare?\n  1. Nero\n  2. Bianco\n  3. Arancione\n  4. Neutro");
						switch(input.nextInt()) {
						case 1: message.add("familiare nero");
								break;
						case 2: message.add("familiare bianco");
								break;
						case 3: message.add("familiare arancione");
								break;
						case 4: message.add("familiare neutro");
								break;
						}	
						
						//////////////FINE SCELTA FAMILIARE///////////////////////////
						
						/////////////SCELTA SPAZIO////////////////////////////////////

						System.out.println("\nQuale spazio vuoi occupare?\n  1. Spazio del Mercato\n  2. Spazio del Consiglio\n  3. Spazio raccolta\n  4. Spazio produzione\n  5. Spazio di una torre");
						switch (input.nextInt()) {
						case 1: message.add("mercato");
								System.out.println("\nQuale spazio del mercato vuoi occupare?");
								int scelta = input.nextInt();
								message.add(String.valueOf(scelta));
								break;
						case 2: message.add("consiglio");
								break;
						case 3: message.add("raccolta");
								break;
						case 4: message.add("produzione");
								break;
						case 5: message.add("torre");
								break;
						} 
						
						////////////FINE SCELTA SPAZIO///////////////////////////////////
			
						break;
						
				case 2: message.add("gioca Leader"); 
						System.out.println("\nQuale Leader vuoi giocare?\n  1. Lorenzo de Medici\n  2. Bartolomeo Colleoni\n  3. Pico de la Mirandola\n  4. Alessandro Magni");
						message.add(String.valueOf(input.nextInt()-1));
						break;
						
				case 3: message.add("scarta Leader"); 
						System.out.println("\nQuale Leader vuoi scartare?\n  1. Lorenzo de Medici\n  2. Bartolomeo Colleoni\n  3. Pico de la Mirandola\n  4. Alessandro Magni");
						message.add(String.valueOf(input.nextInt()-1));
						break;
						
				case 4: message.add("attiva effetto Leader"); 
						System.out.println("\nQuale Leader vuoi attivare?\n  1. Lorenzo de Medici\n  2. Bartolomeo Colleoni\n  3. Pico de la Mirandola\n  4. Alessandro Magni");
						message.add(String.valueOf(input.nextInt()-1));
						break;
						
				default: System.out.println("Inserire un comando valido");
						break;
				
			
				}
				
				setChanged();
				notifyObservers(message);
			}	
		}			
	}
}
