package it.polimi.ingsw.pc15.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class CLI extends View {
	private String ingresso = "wait";
	private Scanner input;
	private ArrayList<String> message;
	
	public CLI(ClientController clientController){
		super(clientController);
		this.input = new Scanner(System.in);
		message = new ArrayList<String>();
	}


	public void run(){
		int read;
			
			System.out.println("Cosa vuoi fare :\n1.OccupaSpazio\n2.Gioca Leader\n3.Scarta Leader\n4.Attiva Leader");
			
			read = input.nextInt();
			
			switch(read){
			case 1: message.add("Occupa spazio");
					break;
			case 2: message.add("Gioca Leader"); 
					break;
			case 3: message.add("Scarta Leader"); 
					break;
			case 4: message.add("Attiva Leader"); 
					break;
			}
			
			setChanged();
			notifyObservers(message);
			
			
			
		
		
		
		
	}
}
