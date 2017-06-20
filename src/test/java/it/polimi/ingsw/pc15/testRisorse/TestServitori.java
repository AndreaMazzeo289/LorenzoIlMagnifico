package it.polimi.ingsw.pc15.testRisorse;

import static org.junit.Assert.*;
import org.junit.*;


import it.polimi.ingsw.pc15.risorse.Servitori;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class TestServitori {
	
	Servitori servitori;
	

	@Before
	public void setUp() throws Exception{
		
		this.servitori = new Servitori(3);
		
	}
	
	@Test
	public void testAggiungi(){
		this.servitori.aggiungi(3);
		assertEquals("Errore aggiunta", 6, this.servitori.getQuantità());
		
	}
	
	@Test
	public void testParagona(){
		
		assertTrue("Errore paragona", this.servitori.paragona(3));
		
	}
	
	@Test
	public void testGetQuantità(){
	
		assertEquals("Errore quantità", 3, this.servitori.getQuantità());
	}
	
	@Test
	public void testGetTipoRisorsa(){
		 
		assertEquals("Errore tipoRisorsa", TipoRisorsa.SERVITORI, this.servitori.getTipoRisorsa());
		
	}
	
	@Test 
	public void testToString(){
		
		assertEquals("Errore toString", "Servitori", this.servitori.toString());
	}
}
