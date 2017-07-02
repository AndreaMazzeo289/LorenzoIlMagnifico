package it.polimi.ingsw.pc15.testRisorse;

import static org.junit.Assert.*;
import org.junit.*;


import it.polimi.ingsw.pc15.risorse.PuntiFede;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class TestPuntiFede {
	
	PuntiFede puntiFede;

	@Before
	public void setUp() throws Exception{	
		this.puntiFede = new PuntiFede(3);
	}
	
	@Test
	public void testAggiungi(){
		this.puntiFede.aggiungi(3);
		assertEquals("Errore aggiunta", 6, this.puntiFede.getQuantità());	
	}
	
	@Test
	public void testParagona(){	
		assertTrue("Errore paragona", this.puntiFede.paragona(3));	
	}
	
	@Test
	public void testGetQuantità(){
		assertEquals("Errore quantità", 3, this.puntiFede.getQuantità());
	}
	
	@Test
	public void testGetTipoRisorsa(){ 
		assertEquals("Errore tipoRisorsa", TipoRisorsa.PUNTIFEDE, this.puntiFede.getTipoRisorsa());
	}
	
	@Test 
	public void testToString(){
		assertEquals("Errore toString", "Punti Fede", this.puntiFede.toString());
	}
}
