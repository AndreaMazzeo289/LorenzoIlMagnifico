package it.polimi.ingsw.pc15.client;

import java.io.IOException;
import java.util.Scanner;

public class ClientMain {

	public static void main(String[] args) {
		
		int scelta = 0;
		String nome = "default";
		Scanner in = new Scanner(System.in);
		
		System.out.println("Vuoi connetterti con RMI (1) o con Socket (2) ?");
		
		while (scelta!=1 && scelta!=2) {
			try {
				scelta = Integer.valueOf(in.next());
			} catch (java.lang.NumberFormatException e) {
				System.out.println("  --- ERRORE: inserire una scelta valida ---");
				System.out.println("Vuoi connetterti con RMI (1) o con Socket (2) ?");
				
			}
		}
		
		System.out.println("Inserisci il tuo nome:");
		nome = in.next();
		
		if (scelta==1) {
			try {
				Client client = new RMIClient(nome);
				client.connetti();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (scelta==2) {	
			try {
				Client client = new SocketClient(nome);
				client.connetti();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
