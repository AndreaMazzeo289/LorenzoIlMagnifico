package it.polimi.ingsw.pc15.client;

import java.io.IOException;
import java.util.Scanner;

public class ClientMain {

	public static void main(String[] args) {
		
		int scelta = 0;
		System.out.println("Vuoi connetterti con RMI (1) o con Socket (2) ?");
		
		while (scelta!=1 && scelta!=2) {
			Scanner in = new Scanner(System.in);
			scelta = in.nextInt();
			if (scelta == 1 && scelta == 2) {
				System.out.println("ERRORE: inserire una scelta valida");
			}
		}
		
		if (scelta==1) {
			try {
				Client client = new RMIClient();
				client.connetti();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (scelta==2) {	
			try {
				Client client = new SocketClient();
				client.connetti();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
