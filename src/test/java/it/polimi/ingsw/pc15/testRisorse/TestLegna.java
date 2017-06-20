package it.polimi.ingsw.pc15.testRisorse;

import static org.junit.Assert.*;
import org.junit.*;

import it.polimi.ingsw.pc15.risorse.Legna;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class TestLegna {
	
	Legna legna;
	

	@Before
	public void setUp() throws Exception{
		
		this.legna = new Legna(3);
		
	}
	
	@Test
	public void testAggiungi(){
		this.legna.aggiungi(3);
		assertEquals("Errore aggiunta", 6, this.legna.getQuantità());
		
	}
	
	@Test
	public void testParagona(){
		
		assertTrue("Errore paragona", this.legna.paragona(3));
		
	}
	
	@Test
	public void testGetQuantità(){
	
		assertEquals("Errore quantità", 3, this.legna.getQuantità());
	}
	
	@Test
	public void testGetTipoRisorsa(){
		 
		assertEquals("Errore tipoRisorsa", TipoRisorsa.LEGNA, this.legna.getTipoRisorsa());
		
	}
	
	@Test 
	public void testToString(){
		
		assertEquals("Errore toString", "Legna", this.legna.toString());
	}
}
