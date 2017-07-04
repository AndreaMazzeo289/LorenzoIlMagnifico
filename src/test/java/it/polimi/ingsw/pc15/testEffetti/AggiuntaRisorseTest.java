package it.polimi.ingsw.pc15.testEffetti;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.*;

import it.polimi.ingsw.pc15.effetti.AggiuntaRisorse;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.Legna;
import it.polimi.ingsw.pc15.risorse.Oro;
import it.polimi.ingsw.pc15.risorse.Pietra;
import it.polimi.ingsw.pc15.risorse.Privilegi;
import it.polimi.ingsw.pc15.risorse.PuntiFede;
import it.polimi.ingsw.pc15.risorse.PuntiMilitari;
import it.polimi.ingsw.pc15.risorse.PuntiVittoria;
import it.polimi.ingsw.pc15.risorse.Risorsa;
import it.polimi.ingsw.pc15.risorse.Servitori;
import it.polimi.ingsw.pc15.risorse.SetRisorse;



public class AggiuntaRisorseTest {

	AggiuntaRisorse aggiuntaRisorse;
	Legna legna;
	Oro oro;
	Pietra pietra;
	Privilegi privilegi;
	PuntiFede puntiFede;
	PuntiMilitari puntiMilitari;
	PuntiVittoria puntiVittoria;
	Servitori servitori;
	HashSet<Risorsa> setRisorse;
	SetRisorse setRisorseTest;
	
	Player player;
	
	@Before
	public void setUp(){
		
		legna = new Legna(2);
		oro = new Oro(2);
		pietra = new Pietra(2);
		privilegi = new Privilegi(2);
		puntiFede = new PuntiFede(2);
		puntiMilitari = new PuntiMilitari(2);
		puntiVittoria = new PuntiVittoria(2);
		servitori = new Servitori(2);
		setRisorse = new HashSet<Risorsa>();
		
		setRisorse.add(legna);
		setRisorse.add(oro);
		setRisorse.add(pietra);
		setRisorse.add(privilegi);
		setRisorse.add(puntiMilitari);
		setRisorse.add(puntiFede);
		setRisorse.add(puntiVittoria);
		setRisorse.add(servitori);
		setRisorseTest = new SetRisorse(setRisorse);
		aggiuntaRisorse = new AggiuntaRisorse(setRisorseTest);
		player = new Player("test");
	}
	
	@Test
	public void testAttiva(){
		
		Boolean result;
		
		aggiuntaRisorse.attiva(player);
		
		if(player.getSetRisorse().paragona(setRisorseTest))
		{
			result = true;
		}
		else result = false;
		
		assertTrue("Errore test attiva aggiunta risorse", result);
		
	}
	
	
	
	/*
	 * Il test in questione funziona considerando che il player inizializza gli effetti 
	 * attivi con il moltiplicatore risorse spazi a 1 dunque l'aggiunta non risulta influenzata da alcun bonus.
	 * Inoltre lo stesso bonus dovuto all'aggiunta di risorse bonus spazi risulta inizializzato ma con valori 0/null.
	 * Stanti queste condizioni l'aggiuta da AttivaDaSpazio risulta praticamente identica ad Attiva, non lo è però concettualmente.
	 */
	
	
	
	@Test
	public void testAttivaDaSpazio(){
		Boolean result;
		
		aggiuntaRisorse.attivaDaSpazio(player);
		if(player.getSetRisorse().paragona(setRisorseTest))
		{
			result = true;
		}
		else result = false;
		
		assertTrue("Errore test attiva aggiunta risorse da spazio", result);
		
	}
	
	
	
	
	/*
	 * Il test in questione funziona considerando che il player inizializza gli effetti 
	 * attivi con il moltiplicatore risorse carta a 1 dunque l'aggiunta non risulta influenzata da alcun bonus.
	 * Inoltre lo stesso bonus dovuto all'aggiunta di risorse bonus carte risulta inizializzato ma con valori 0/null.
	 * Stanti queste condizioni l'aggiuta da AttivaDaSpazio risulta praticamente identica ad Attiva, non lo è però concettualmente.
	 */
	
	
	
	@Test
	public void testAttivaDaCarta(){
		Boolean result;
		
		aggiuntaRisorse.attivaDaCarta(player);
		if(player.getSetRisorse().paragona(setRisorseTest))
		{
			result = true;
		}
		else result = false;
		
		assertTrue("Errore test attiva aggiunta risorse da carta", result);
		
	}
}


