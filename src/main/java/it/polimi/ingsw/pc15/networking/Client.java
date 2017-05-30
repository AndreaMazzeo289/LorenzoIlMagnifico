package it.polimi.ingsw.pc15.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	private  PrintStream out;
	private  Scanner in;
	private  String hostName; // ancora non l'ho inizializzato
	
	
	public Client() throws IOException{
		Socket clientSocket = new Socket(hostName, 12879);
		out = new PrintStream(clientSocket.getOutputStream());
		in = new Scanner(clientSocket.getInputStream());
	}
	
	public void run() throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			String read;
			String name;
			/*
			 *  IL CLIENT SETTA IL NOME CHE GLI VIENE CHIESTO DA SERVER 
			 */
			
			read = in.nextLine();
			System.out.println(read);
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			name = input.readLine();
			out.println(name);
			out.flush();
			
			/*
			 * COMINCIA A LEGGERE LO STATO DEL GIOCO :
			 * 
			 * 1 IN ATTESA DI ALTRI GIOCATORI 
			 * 2 ATTESA DEL PROPRIO TURNO 
			 * 3 ESECUZIONE PROPRIO TURNO
			 */
			System.out.println(read = in.nextLine());  //in attesa di altri giocatori
			System.out.println(read = in.nextLine()); //la partita sta per cominciare
		
			while(true){
				
				/*
				 * ASPETTA CHE 4 GIOCATORI SI CONNETTANO ALLA PARTITA
				 * SE è IN STATO DI WAIT SALTA LE in.nextln()
				 */
				out.println("Richiesta stato del gioco");
				read = in.nextLine();
				if(!read.equals("STATO:wait")){
					
					
					if(read.equals("Gioca Maffe")){
						
						System.out.println("PROVA");
						/*
						 * ESECUZIONE COMANDI DEL GIOCO:
						 * 
						 * 1 OCCUPA SPAZIO
						 * 2 ATTIVA CARTA LEADER 
						 * 3 SCARTA CARTA LEADER
						 */
						
					}
					
					
				}
				
				
				
				Thread.sleep(4000);
			}
			
		} catch (IOException e) {e.printStackTrace();}
			
	}
	public static void main(String[] args) throws IOException, InterruptedException {
			Client client;
			client = new Client();
			
			client.run();
			
	}


}
