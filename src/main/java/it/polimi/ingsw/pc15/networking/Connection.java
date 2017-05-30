package it.polimi.ingsw.pc15.networking;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Observable;
import java.util.Scanner;

public class Connection extends Observable implements Runnable {

	private Socket socket;
	private Server server;
	private PrintStream out ;
	private Scanner in;
	private int numeroGiocatori = 0;
	private boolean flag = true; // TEMPORANEAMENTE FLAG
	private boolean connessioneAttiva = true;
	
	
	/* Ogni connection corrisponde ad un thread del client.
	 * comunica tramite la socket passata dal server con il client con stream di byte.
	 * il thread esegue le operazioni di comunicazione e poi locka l'oggetto intanto sbloccato dalla wait() del server ed effettua 
	 * la notify() per svegliare il thread del server e mandarlo in accept() nuovamente per ricevere nuoi client.
	 * Va in wait() per aspettare il numero esatto di giocatori necessari per poi notificarlo al client una volta sveglio.
	 * presenta una flag neccessaria per far passare il thread successivo dello stesso ogetto lanciato dal server alla notify() e svegliare il thread del client .
	 */
	
	
	public Connection(Socket socket, Server server){
		
		this.socket = socket;
		this.server = server;
	}
	
	
	/*
	 * OVERRIDE DEL METODO RUN DELL'INTERFACCIA RUNNABLE
	 * LA CONNECTION CORRISPONDE ALLA SOCKET CREATA DAL SERVER PER COMUNICARE CON LO SPECIFICO CLIENT
	 * OGNI CLIENT HA LA PROPRIA CONNECTION
	 */
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {	
			String read;
			String name;
			out = new PrintStream(this.socket.getOutputStream());
			in = new Scanner(this.socket.getInputStream());
			
			/*
			 * IL FLAG SERVE PER FAR ESEGUIRE ESCLUSIVAMENTE LA NOTIFY AL SECONDO THREAD PER RISVEGLIARE LA CONNECTION
			 */
				if(flag){
				
					/*
					 * CHIEDE IL NOME AL CLIENT
					 * RICEVE IL NOME DAL CLIENT
					 */
						
					out.println("Scrivi il tuo nome");
					out.flush();
					name = in.nextLine();
					System.out.println("Connesso con il player : " + name);
				
					/*
					 * RICEVE LA PRIMA RICHIESTA DI AGGIORNAMENTO SULLO STATO DEL GIOCO
					 * AGGIUNGE ENTRA IN UNA FUNZIONE DEL SERVER DOVE "TUTTE LE SOCKET SI INCONTRANO" 
					 * SE IL NUMERO DI GIOCATORI è MINORE DEL NECESSARIO INVIA IMMEDIATAMENTE UNO STATO DI ATTESA AL CORRISPONDENTE CLIENT
					 */
					
					numeroGiocatori = server.Connetti(this, name);
				
				}
				
				/*
				 * ACQUISICE IL MONITOR E SE IL THREAD PRECEDENTE è ENTRATO IN WAIT NOTIFICA
				 * SE IL THREAD NON è MAI ANDATO IN WAIT VA IN WAIT SETTANDO IL FLAG FALSE
				 */
				
				synchronized (this) {
					
					//System.out.println("Il thread " + Thread.currentThread().getId() + " fa la notify" );
					notify();
					
					if(flag){
						
					
						send("In attesa di altri giocatori...");
						flag = false;
						wait();
						//System.out.println("Il thread " + Thread.currentThread().getId() + " si sveglia" );
						
						send("La partita sta per cominciare");
						
						while(connessioneAttiva){
					
					
							read = in.nextLine();
							notifyObservers(read);
					
						}
					}
				
		
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public synchronized void send(String messaggio){
		
		out.println(messaggio);
	}
	
	
	
	private synchronized void closeConnection(){
		
		try {
			connessioneAttiva = false;
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
