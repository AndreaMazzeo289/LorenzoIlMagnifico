package it.polimi.ingsw.pc15.client;

import java.io.IOException;
import java.util.Scanner;

public class ClientMain {

	public static void main(String[] args) {
		
		int sceltaConnessione =0;
		int sceltaView =0;
		Client client;
		String nome;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Inserisci il tuo nome:");
		nome = in.next();		
		
		System.out.println("Vuoi connetterti con RMI (1) o con Socket (2) ?");
		
		while (sceltaConnessione!=1 && sceltaConnessione!=2) {
			try {
				sceltaConnessione = Integer.valueOf(in.next());
			} catch (java.lang.NumberFormatException e) {
				System.out.println("  --- ERRORE: inserire una scelta valida ---");
				System.out.println("Vuoi connetterti con RMI (1) o con Socket (2) ?");
				
			}
		}
		
		System.out.println("Vuoi giocare tramite CLI (1) o tramte GUI (2) ?");
		
		while (sceltaView!=1 && sceltaView!=2) {
			try {
				sceltaView = Integer.valueOf(in.next());
			} catch (java.lang.NumberFormatException e) {
				System.out.println("  --- ERRORE: inserire una scelta valida ---");
				System.out.println("Vuoi giocare tramite CLI (1) o tramte GUI (2) ?");
				
			}
		}

		if (sceltaConnessione==1) {
			try {
				client = new RMIClient(nome, sceltaView);
				client.connetti();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (sceltaConnessione==2) {	
			try {
				client = new SocketClient(nome, sceltaView);
				client.connetti();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
