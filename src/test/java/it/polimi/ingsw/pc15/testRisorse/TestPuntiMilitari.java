package it.polimi.ingsw.pc15.testRisorse;

import static org.junit.Assert.*;
import org.junit.*;

import it.polimi.ingsw.pc15.risorse.PuntiMilitari;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class TestPuntiMilitari {
	
	PuntiMilitari puntiMilitari;
	

	@Before
	public void setUp() throws Exception{
		
		this.puntiMilitari = new PuntiMilitari(3);
		
	}
	
	@Test
	public void testAggiungi(){
		this.puntiMilitari.aggiungi(3);
		assertEquals("Errore aggiunta", 6, this.puntiMilitari.getQuantità());
		
	}
	
	@Test
	public void testParagona(){
		
		assertTrue("Errore paragona", this.puntiMilitari.paragona(3));
		
	}
	
	@Test
	public void testGetQuantità(){
	
		assertEquals("Errore quantità", 3, this.puntiMilitari.getQuantità());
	}
	
	@Test
	public void testGetTipoRisorsa(){
		 
		assertEquals("Errore tipoRisorsa", TipoRisorsa.PUNTIMILITARI, this.puntiMilitari.getTipoRisorsa());
		
	}
	
	@Test 
	public void testToString(){
		
		assertEquals("Errore toString", "Punti Militari", this.puntiMilitari.toString());
	}
}

