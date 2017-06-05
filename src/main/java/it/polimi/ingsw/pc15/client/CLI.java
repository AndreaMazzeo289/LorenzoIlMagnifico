package it.polimi.ingsw.pc15.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class CLI extends View {
	private String ingresso = "wait";
	private Scanner input;
	
	public CLI(ClientController clientController){
		super(clientController);
		this.input = new Scanner(System.in);
	}


	public void run(){
		String read = null;
		while(true){
			
			System.out.println("Cosa vuoi fare :\n1.OccupaSpazio\n2.Gioca carta Leader\n3.Scarta carta Leader\n4.Attiva effetto carta Leader");
			read = read.concat(input.next()+" ");
			
			if(input.equals("1")){
				System.out.println();
				
				
			}
			
			
			
		}
		
		
		
	}
}
