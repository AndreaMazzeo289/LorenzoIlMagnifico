package it.polimi.ingsw.pc15.testRisorse;

import static org.junit.Assert.*;
import org.junit.*;


import it.polimi.ingsw.pc15.risorse.Oro;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class TestOro {
	
	Oro oro;
	
	@Before
	public void setUp() throws Exception{
		this.oro = new Oro(3);
	}
	
	@Test
	public void testAggiungi(){
		this.oro.aggiungi(3);
		assertEquals("Errore aggiunta", 6, this.oro.getQuantità());
	}
	
	@Test
	public void testParagona(){	
		assertTrue("Errore paragona", this.oro.paragona(3));	
	}
	
	@Test
	public void testGetQuantità(){
		assertEquals("Errore quantità", 3, this.oro.getQuantità());
	}
	
	@Test
	public void testGetTipoRisorsa(){ 
		assertEquals("Errore tipoRisorsa", TipoRisorsa.ORO, this.oro.getTipoRisorsa());
	}
	
	@Test 
	public void testToString(){
		assertEquals("Errore toString", "Oro", this.oro.toString());
	}
}