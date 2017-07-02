package it.polimi.ingsw.pc15.testRisorse;

import static org.junit.Assert.*;
import org.junit.*;


import it.polimi.ingsw.pc15.risorse.Privilegi;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class TestPrivilegi {
	
	Privilegi privilegi;

	@Before
	public void setUp() throws Exception{
		
		this.privilegi = new Privilegi(3);
		
	}
	
	@Test
	public void testAggiungi(){
		this.privilegi.aggiungi(3);
		assertEquals("Errore aggiunta", 6, this.privilegi.getQuantità());
	}
	
	@Test
	public void testParagona(){
		assertTrue("Errore paragona", this.privilegi.paragona(3));
	}
	
	@Test
	public void testGetQuantità(){
		assertEquals("Errore quantità", 3, this.privilegi.getQuantità());
	}
	
	@Test
	public void testGetTipoRisorsa(){
		assertEquals("Errore tipoRisorsa", TipoRisorsa.PRIVILEGI, this.privilegi.getTipoRisorsa());
	}
	
	@Test 
	public void testToString(){
		assertEquals("Errore toString", "Privilegi del Consiglio", this.privilegi.toString());
	}
}
