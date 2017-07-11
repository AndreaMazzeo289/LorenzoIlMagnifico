package it.polimi.ingsw.pc15.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Scanner;

import it.polimi.ingsw.pc15.model.StatoPartita;

/**
 *Sottoclasse di ServerView, specifica per la connessione tramite Socket. E' collegata
 *tramite lo stream della Socket al SocketHandler del giocatore corrispondente
 *
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */


public class SocketView extends ServerView implements Serializable {

	private transient Socket socket;
	private Server server;
	private transient ObjectInputStream inObj;
	private transient ObjectOutputStream outObj;
	private transient Scanner in;
	private transient  PrintStream out;
	
	public SocketView(Socket socket, Server server) throws IOException{
		
		this.socket = socket;
		this.server = server;
		outObj = new ObjectOutputStream(this.socket.getOutputStream());
		inObj = new ObjectInputStream(this.socket.getInputStream());
		this.in = new Scanner(this.socket.getInputStream());
		this.out = new PrintStream(this.socket.getOutputStream());
	}
	
	
	/**
	 * metodo per avviare la connessione. Riceve il nome scelto dal giocatore nell'input del
	 * SocketStream e lo usa per connettersi al server tramite connetti(). Quindi, rimane in attesa
	 * per messaggi ricevuti dal SocketHandler e, quando li riceve, li notifica al controller
	 */
	
	public void run() {

		name = in.nextLine();		
		server.connetti(this, name);
		
		 try {
			 
			 while(true) {  //NOSONAR
				ArrayList<String> message;
				message = (ArrayList<String>) inObj.readObject();
				setChanged();
				notifyObservers(message);
			} 
			 
		} catch (ClassNotFoundException | IOException e) {
				try {
					this.socket.close();
					setChanged();
					notifyObservers(new ArrayList<String>(Arrays.asList("CONNESSIONE CHIUSA")));
				} catch (IOException e1) {
					e1.printStackTrace();  //NOSONAR
				}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		
		StatoPartita statoPartita = (StatoPartita)arg;
		statoPartita.setStatoGiocatore(name);

		sendObj(statoPartita);
		
	}
	
	public synchronized void sendLine(String messaggio) {	
		out.println(messaggio);
	}
	
	/**
	 * invia un oggetto nelo stram di output della Socket
	 */
	
	public synchronized void sendObj(Object obj) {	
		
		try {
			outObj.writeObject(obj);
			outObj.reset();
		} catch (IOException e) {
		}
	}
	
	public String getName() {
		return this.name;
	}
}