package it.polimi.ingsw.pc15.client;

import java.io.IOException;
import java.util.Scanner;

/**
 *Classe per lanciare un thread Client. In base alle scelte, istanzierà un SocketClient o un
 *RMIClient, passando in entrambi i casi la scelta per usare una CLI o una GUI.
 *
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

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
				if (sceltaConnessione!=1 && sceltaConnessione!=2)
					throw new NumberFormatException();
			} catch (java.lang.NumberFormatException e) {
				System.out.println("  --- ERRORE: inserire una scelta valida ---");
				System.out.println("\nVuoi connetterti con RMI (1) o con Socket (2) ?");
	
			}
		}
		
		System.out.println("Vuoi giocare tramite CLI (1) o tramte GUI (2) ?");
		
		while (sceltaView!=1 && sceltaView!=2) {
			try {
				sceltaView = Integer.valueOf(in.next());
				if (sceltaView!=1 && sceltaView!=2)
					throw new NumberFormatException();
			} catch (java.lang.NumberFormatException e) {
				System.out.println("  --- ERRORE: inserire una scelta valida ---");
				System.out.println("\nVuoi giocare tramite CLI (1) o tramte GUI (2) ?");
				
			}
		}

		if (sceltaConnessione==1) {
			try {
				client = new RMIClient(nome, sceltaView);
				client.connetti();
			} catch (IOException e) {
				e.printStackTrace(); // NOSONAR
			}
		}
		
		if (sceltaConnessione==2) {	
			try {
				client = new SocketClient(nome, sceltaView);
				client.connetti();
			} catch (IOException e) {
				e.printStackTrace(); // NOSONAR
			}
		}
	}

}
