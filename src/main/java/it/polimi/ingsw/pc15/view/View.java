package it.polimi.ingsw.pc15.view;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import it.polimi.ingsw.pc15.carte.Carta;
import it.polimi.ingsw.pc15.carte.ColoreCarta;
import it.polimi.ingsw.pc15.carte.Edificio;
import it.polimi.ingsw.pc15.carte.Impresa;
import it.polimi.ingsw.pc15.carte.Personaggio;
import it.polimi.ingsw.pc15.carte.Territorio;
import it.polimi.ingsw.pc15.model.Model;
import it.polimi.ingsw.pc15.networking.Connection;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class View extends Observable implements Observer {
	
	private Player player;
	private ConsoleView consoleView;
	
	public View (Player player, Connection connection) {
		
		this.player = player;
		connection.addObserver(this);
		this.consoleView = new ConsoleView();
	}


	public void input(int scelta) {
		
		switch (scelta) {
		
		case 1: System.out.println("\nAl momento possiedi le seguenti risorse:");
				System.out.println("Oro: "+player.getSetRisorse().getRisorsa(TipoRisorsa.ORO).getQuantità());
				System.out.println("Legna: "+player.getSetRisorse().getRisorsa(TipoRisorsa.LEGNA).getQuantità());
				System.out.println("Pietra: "+player.getSetRisorse().getRisorsa(TipoRisorsa.PIETRA).getQuantità());
				System.out.println("Servitori: "+player.getSetRisorse().getRisorsa(TipoRisorsa.SERVITORI).getQuantità());
				System.out.println("PuntiVittoria: "+player.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIVITTORIA).getQuantità());
				System.out.println("PuntiFede: "+player.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIFEDE).getQuantità());
				System.out.println("PuntiMilitari: "+player.getSetRisorse().getRisorsa(TipoRisorsa.PUNTIMILITARI).getQuantità());
				break;
		
		case 2: System.out.println("\nAl momento possiedi le seguenti carte:");
				System.out.print("Carte TERRITORIO: ");
				for (Carta territorio : player.getCarte(ColoreCarta.VERDE) )
					System.out.print(territorio.getNome() + " | ");
				System.out.print("\nCarte PERSONAGGIO: ");
				for (Carta personaggio : player.getCarte(ColoreCarta.BLU) )
					System.out.print(personaggio.getNome() + " | ");
				System.out.print("\nCarte EDIFICIO: ");
				for (Carta edificio : player.getCarte(ColoreCarta.GIALLO) )
					System.out.print(edificio.getNome() + " | ");
				System.out.print("\nCarte IMPRESA: ");
				for (Carta impresa : player.getCarte(ColoreCarta.VIOLA))
					System.out.print(impresa.getNome() + " | ");
				break;
		
		case 3: System.out.println("\nHai ancora a disposizione i seguenti familiari:");
				if (player.getFamiliare(ColoreFamiliare.NERO).disponibile())
					System.out.print("\nFamiliare NERO - valore " + player.getFamiliare(ColoreFamiliare.NERO).getValore());
				if (player.getFamiliare(ColoreFamiliare.BIANCO).disponibile())
					System.out.print("\nFamiliare BIANCO - valore " + player.getFamiliare(ColoreFamiliare.BIANCO).getValore());
				if (player.getFamiliare(ColoreFamiliare.ARANCIONE).disponibile())
					System.out.print("\nFamiliare ARANCIONE - valore " + player.getFamiliare(ColoreFamiliare.ARANCIONE).getValore());
				if (player.getFamiliare(ColoreFamiliare.NEUTRO).disponibile())
					System.out.print("\nFamiliare NEUTRO - valore " + player.getFamiliare(ColoreFamiliare.NEUTRO).getValore());
				break;
				
		case 4: //MAZZE PENSACI TU!
				break;
				
		case 5: System.out.println("\nChe familiare vuoi posizionare?");
				Scanner in = new Scanner (System.in);
				int sceltaFamiliare = in.nextInt();
				
				
				
		}
		
		
		
		
	}
	
	
	
	@Override
	public synchronized void update(Observable o, Object message) {
		// TODO Auto-generated method stub
		if(!(o instanceof Connection)|| !(message instanceof String)){
			throw new IllegalArgumentException();
		}
		String instruction = consoleView.parseMessage((String) message);
		notifyObservers(instruction);
	}
	
	

}
