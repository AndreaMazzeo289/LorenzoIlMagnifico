package it.polimi.ingsw.pc15.testRisorse;

import static org.junit.Assert.*;
import org.junit.*;

import it.polimi.ingsw.pc15.risorse.Pietra;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class TestPietra {
	
	Pietra pietra;

	@Before
	public void setUp() throws Exception{
		this.pietra = new Pietra(3);
	}
	
	@Test
	public void testAggiungi(){
		this.pietra.aggiungi(3);
		assertEquals("Errore aggiunta", 6, this.pietra.getQuantità());
	}
	
	@Test
	public void testParagona(){
		assertTrue("Errore paragona", this.pietra.paragona(3));
	}
	
	@Test
	public void testGetQuantità(){
		assertEquals("Errore quantità", 3, this.pietra.getQuantità());
	}
	
	@Test
	public void testGetTipoRisorsa(){ 
		assertEquals("Errore tipoRisorsa", TipoRisorsa.PIETRA, this.pietra.getTipoRisorsa());
	}
	
	@Test 
	public void testToString(){
		assertEquals("Errore toString", "Pietra", this.pietra.toString());
	}
}
