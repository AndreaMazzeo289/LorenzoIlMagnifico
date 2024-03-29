package it.polimi.ingsw.pc15.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.model.StatoPartita;
import it.polimi.ingsw.pc15.plancia.SpazioTorre;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

/**
 *Sottoclasse di NetworkHandler per la gestione di rete tramite Socket. Contiene gli stream di
 *input e output usati per ricevere e inviare messaggi al server tramite Socket. Si registra al server
 *tramite connetti() e si avvia tramite run()
 *
 * @author AndreaMazzeo289
 * @author AndreaMaffe
 * @author FrancescoGuzzo
 *
 */

public class SocketHandler extends NetworkHandler implements Serializable{
	
	private transient Scanner in;
	private transient PrintStream out;
	private transient ObjectInputStream inObj;
	private transient ObjectOutputStream outObj;

	public SocketHandler (Socket socket, ClientModel clientModel, String name) throws IOException  {
		
		super(name, clientModel);
		
		this.in = new Scanner(socket.getInputStream());
		this.out = new PrintStream(socket.getOutputStream());	
		this.inObj = new ObjectInputStream(socket.getInputStream());
		this.outObj = new ObjectOutputStream(socket.getOutputStream());
	}
	
	
	/**
	 * Invia il proprio nome nell'outputStream della Socket. Quando riceve la risposta OK
	 * nell'inputStream, notifica il proprio Client.
	 */
	
	@Override
	public void connetti() {
		
		out.println(name);  //manda il nome alla Connection
		System.out.println("Connessione al server riuscita! In attesa di altri giocatori\n");
		
		if(in.nextLine().equals("OK")) { //attende finchè riceve l'OK dal server
			setChanged();
			notifyObservers();
		}
		
	}
		
	
	/**
	 * Manda il SocketHandler in attesa finchè riceve un oggetto StatoPartita nell'inputStream della Socket.
	 * A quel punto, aggiorna il clientModel con i valori ricevuti.
	 */
	
	public void run() {
			
		while (true) { //NOSONAR
				
			try {
				StatoPartita statoPartita = (StatoPartita) inObj.readObject();
				clientModel.aggiorna(statoPartita);
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();} // NOSONAR
			}
	}
	
	@Override
	public void update(Observable o, Object input) {
			
		try {
			send(input);
		} catch (IOException e) {
			e.printStackTrace(); // NOSONAR
		}
		
	}
	
	/**
	 * Invia un oggetto nel flusso di output della Socket
	 * 
	 * @param message messaggio da inviare
	 */
	
	public void send(Object message) throws IOException{
		outObj.writeObject(message);
		outObj.reset();
	}
}
