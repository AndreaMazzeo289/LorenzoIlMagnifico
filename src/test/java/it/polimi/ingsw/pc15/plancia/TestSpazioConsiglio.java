package it.polimi.ingsw.pc15.plancia;

import java.util.HashSet;

import it.polimi.ingsw.pc15.effetti.AggiuntaRisorse;
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
import org.junit.*;
import static org.junit.Assert.*;



public class TestSpazioConsiglio {

	//-----------------------------------------------------------------------------------------------------------//
	//          TEST GET EFFETTI                                                                                 //
	//-----------------------------------------------------------------------------------------------------------//
	
	SpazioConsiglio spazioConsiglio;
	
	
	Legna legna;
	Oro oro;
	Pietra pietra;
	Privilegi privilegi;
	PuntiFede puntiFede;
	PuntiMilitari puntiMilitari;
	PuntiVittoria puntiVittoria;
	Servitori servitori;
	HashSet<Risorsa> risorse;
	SetRisorse setRisorse;
	
	AggiuntaRisorse aggiungiRisorse;
	AggiuntaRisorse aggiungiRisorse2;
	
	@Before
	public void setUp(){
		
		
		
		//-----------------------------------------------------------------------------------------------------------//
		//          TEST GET EFFETTI                                                                                 //
		//-----------------------------------------------------------------------------------------------------------//
		
		
		
		
		legna = new Legna(0);
		oro = new Oro(0);
		pietra = new Pietra(0);
		privilegi = new Privilegi(0);
		puntiFede = new PuntiFede(0);
		puntiMilitari = new PuntiMilitari(0);
		puntiVittoria = new PuntiVittoria(0);
		servitori = new Servitori(0);
		
		risorse = new HashSet<Risorsa>();
		
		risorse.add(legna);
		risorse.add(oro);
		risorse.add(pietra);
		risorse.add(privilegi);
		risorse.add(puntiMilitari);
		risorse.add(puntiFede);
		risorse.add(puntiVittoria);
		risorse.add(servitori);
		
		setRisorse = new SetRisorse(risorse);
		
		spazioConsiglio = new SpazioConsiglio(1, setRisorse);
		
		aggiungiRisorse2 = new AggiuntaRisorse(setRisorse);
		
	}
	
	
	@Test
	public void testGetEffetto(){
		
		aggiungiRisorse = (AggiuntaRisorse) spazioConsiglio.getEffetto();
		
		assertEquals("Errore test get effetto", aggiungiRisorse2.toString(), aggiungiRisorse.toString() );
		
		
	}
}
