package it.polimi.ingsw.pc15.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Leader;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class CLI extends View {
	
	private Scanner input;
	private boolean tuoTurno;
	private final boolean regoleAvanzate;
	
	public CLI(ClientController clientController, ClientModel clientModel){
		super(clientController, clientModel);
		this.input = new Scanner(System.in);
		this.tuoTurno = true;
		this.regoleAvanzate = true;
	}
	
	public void run(){
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
	    while (true) {
	    	
	    	if (this.clientModel.getGiocatoreCorrente().equals(this.clientModel.getStatoGiocatore().getNome()))
	    		tuoTurno = true;
	    	else tuoTurno = false;
	    	
	    	if (tuoTurno)
	    		System.out.println("\nÈ il tuo turno!");
	    	else 
	    		System.out.println("\nÈ il turno di " + this.clientModel.getGiocatoreCorrente()+"!");
			
	    	ArrayList<String> message = new ArrayList<String>();
			
	    	System.out.println("\nCosa vuoi fare?");
	    	if (tuoTurno)
	    		System.out.println("  0. Posiziona un familiare");
	    	System.out.println("  1. Visualizza risorse\n  2. Visualizza familiari disponibili\n  3. Visualizza plancia");
	    	if (regoleAvanzate) {
	    		System.out.println("  4. Visualizza carte Leader");
	    		if (tuoTurno)
	    			System.out.println("  5. Gioca una carta Leader\n  6. Scarta una carta Leader\n  7. Attiva l'effetto di una carta Leader");
	    	}
	    	switch (input.nextInt()) {
	    	case 0: message.add("posiziona familiare");
	    	
				/////////////SCELTA FAMILIARE///////////////////////////////
	
				System.out.println("\nQuale familiare vuoi posizionare?\n  1. Nero\n  2. Bianco\n  3. Arancione\n  4. Neutro");
				switch(input.nextInt()) {
				case 1: message.add("familiare nero");
						break;
				case 2: message.add("familiare bianco");
						break;
				case 3: message.add("familiare arancione");
						break;
				case 4: message.add("familiare neutro");
						break;
				}	
				
				//////////////FINE SCELTA FAMILIARE///////////////////////////
				
				/////////////SCELTA SPAZIO////////////////////////////////////

				System.out.println("\nQuale spazio vuoi occupare?\n  1. Spazio del Mercato\n  2. Spazio del Consiglio\n  3. Spazio raccolta\n  4. Spazio produzione\n  5. Spazio di una torre");
				switch (input.nextInt()) {
				case 1: message.add("mercato");
					System.out.println("\nQuale spazio del mercato vuoi occupare?");
					int scelta = input.nextInt();
					message.add(String.valueOf(scelta-1));
					break;
				case 2: message.add("consiglio");
					break;
				case 3: message.add("raccolta");
					break;
				case 4: message.add("produzione");
					break;
				case 5: message.add("torre");
					break;
				} 
				
				////////////FINE SCELTA SPAZIO///////////////////////////////////
				
				setChanged();
				break;		
				
	    	case 1: System.out.println("\nAl momento possiedi le seguenti risorse: ");
					System.out.println("Oro: " + this.clientModel.getStatoGiocatore().getSetRisorse().getRisorsa(TipoRisorsa.ORO).getQuantità());
					System.out.println("Legna: " + this.clientModel.getStatoGiocatore().getSetRisorse().getRisorsa(TipoRisorsa.LEGNA).getQuantità());
					System.out.println("Pietra: " + this.clientModel.getStatoGiocatore().getSetRisorse().getRisorsa(TipoRisorsa.PIETRA).getQuantità());
					System.out.println("Servitori: " + this.clientModel.getStatoGiocatore().getSetRisorse().getRisorsa(TipoRisorsa.SERVITORI).getQuantità());
					System.out.println("\nPunti Vittoria: " + this.clientModel.getStatoGiocatore().getSetRisorse().getRisorsa(TipoRisorsa.PUNTIVITTORIA).getQuantità());
					System.out.println("Punti Militari: " + this.clientModel.getStatoGiocatore().getSetRisorse().getRisorsa(TipoRisorsa.PUNTIMILITARI).getQuantità());
					System.out.println("Punti Fede: " + this.clientModel.getStatoGiocatore().getSetRisorse().getRisorsa(TipoRisorsa.PUNTIFEDE).getQuantità());
					break;
					
	    	case 2: System.out.println("\nI tuoi familiari disponibili sono i seguenti: ");
	    			if (this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.NERO).disponibile())
	    				System.out.println("  - Familiare nero - valore: " + this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.NERO).getValore());
	    			if (this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.BIANCO).disponibile())
	    				System.out.println("  - Familiare bianco - valore: " + this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.BIANCO).getValore());
	    			if (this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.ARANCIONE).disponibile())
	    				System.out.println("  - Familiare arancione - valore: " + this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.ARANCIONE).getValore());
	    			if (this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.NEUTRO).disponibile())
	    				System.out.println("  - Familiare neutro - valore: " + this.clientModel.getStatoGiocatore().getFamiliare(ColoreFamiliare.NEUTRO).getValore());
	    			break;
	    			
	    	case 3: System.out.println("La plancia è stra figa");
					break;
					
	    	case 4: System.out.println("\nAl momento possiedi le seguenti carte Leader:");
	    			for (Leader leader : this.clientModel.getStatoGiocatore().getCarteLeader())
	    				System.out.println("  - " + leader.getNome());
	    			break;
		
			case 5: message = new ArrayList<String>();
					message.add("gioca Leader"); 
					System.out.println("\nQuale Leader vuoi giocare?");
	    			for (Leader leader : this.clientModel.getStatoGiocatore().getCarteLeader())
	    				System.out.println("  " + (this.clientModel.getStatoGiocatore().getCarteLeader().lastIndexOf(leader)+1) +". " + leader.getNome());
					message.add(String.valueOf(input.nextInt()-1));
					setChanged();
					break;		
			case 6: message = new ArrayList<String>();
					System.out.println("\nQuale Leader vuoi scartare?");
					for (Leader leader : this.clientModel.getStatoGiocatore().getCarteLeader())
						System.out.println("  " + (this.clientModel.getStatoGiocatore().getCarteLeader().lastIndexOf(leader)+1) +". " + leader.getNome());
					message.add(String.valueOf(input.nextInt()-1));
					setChanged();
					break;		
			case 7: message = new ArrayList<String>();
					message.add("attiva effetto Leader"); 
					System.out.println("\nQuale Leader vuoi attivare?");
	    			for (Leader leader : this.clientModel.getStatoGiocatore().getCarteLeader())
	    				System.out.println("  " + (this.clientModel.getStatoGiocatore().getCarteLeader().lastIndexOf(leader)+1) +". " + leader.getNome());
					message.add(String.valueOf(input.nextInt()-1));
					setChanged();
					break;		
			default: System.out.println("Inserire un comando valido");
					break;
				
	    	}	
	    	
	    	notifyObservers(message);
	    	
	    	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }			
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
	}
}
