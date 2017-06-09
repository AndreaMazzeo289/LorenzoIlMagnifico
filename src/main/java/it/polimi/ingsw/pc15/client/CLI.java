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
	private final boolean regoleAvanzate;
	
	public CLI(ClientController clientController){
		super(clientController);
		this.input = new Scanner(System.in);
		this.tuoTurno = true;
		this.regoleAvanzate = true;
	}
	
	public void run(){
		
	    while (true) {
			
	    	ArrayList<String> message = new ArrayList<String>();
			
	    	System.out.println("\nCosa vuoi fare?\n");
	    	if (tuoTurno)
	    		System.out.println("  0. Posiziona un familiare");
	    	System.out.println("  1. Visualizza risorse\n  2. Visualizza familiari disponibili\n  3. Visualizza plancia");
	    	if (regoleAvanzate)
	    		System.out.println("  4. Visualizza carte Leader\n  5. Gioca una carta Leader\n  6. Scarta una carta Leader\n  7. Attiva l'effetto di una carta Leader");
		
	    	switch (input.nextInt()) {
	    	case 0: message.add("posiziona familiare");
	    	
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
				
				setChanged();
				break;		
				
	    	case 1: System.out.println("Hai un botto di risorse");
					break;
	    	case 2: System.out.println("Hai un botto di familiari");
					break;
	    	case 3: System.out.println("La plancia è stra figa");
					break;
	    	case 4: System.out.println("Hai un botto di leader");
					break;
		
			case 5: message = new ArrayList<String>();
					message.add("gioca Leader"); 
					System.out.println("\nQuale Leader vuoi giocare?\n  1. Lorenzo de Medici\n  2. Bartolomeo Colleoni\n  3. Pico de la Mirandola\n  4. Alessandro Magni");
					message.add(String.valueOf(input.nextInt()-1));
					setChanged();
					break;		
			case 6: message = new ArrayList<String>();
					message.add("scarta Leader"); 
					System.out.println("\nQuale Leader vuoi scartare?\n  1. Lorenzo de Medici\n  2. Bartolomeo Colleoni\n  3. Pico de la Mirandola\n  4. Alessandro Magni");
					message.add(String.valueOf(input.nextInt()-1));
					setChanged();
					break;		
			case 7: message = new ArrayList<String>();
					message.add("attiva effetto Leader"); 
					System.out.println("\nQuale Leader vuoi attivare?\n  1. Lorenzo de Medici\n  2. Bartolomeo Colleoni\n  3. Pico de la Mirandola\n  4. Alessandro Magni");
					message.add(String.valueOf(input.nextInt()-1));
					setChanged();
					break;		
			default: System.out.println("Inserire un comando valido");
					break;
					
				
	    	}	
	    	
	    	notifyObservers(message);
	    }			
	}
}
