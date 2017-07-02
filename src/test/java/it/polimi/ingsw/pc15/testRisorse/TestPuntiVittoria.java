package it.polimi.ingsw.pc15.testRisorse;

import static org.junit.Assert.*;
import org.junit.*;

import it.polimi.ingsw.pc15.risorse.PuntiVittoria;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class TestPuntiVittoria {
	
	PuntiVittoria puntiVittoria;

	@Before
	public void setUp() throws Exception{	
		this.puntiVittoria = new PuntiVittoria(3);	
	}
	
	@Test
	public void testAggiungi(){
		this.puntiVittoria.aggiungi(3);
		assertEquals("Errore aggiunta", 6, this.puntiVittoria.getQuantità());
	}
	
	@Test
	public void testParagona(){	
		assertTrue("Errore paragona", this.puntiVittoria.paragona(3));	
	}
	
	@Test
	public void testGetQuantità(){
		assertEquals("Errore quantità", 3, this.puntiVittoria.getQuantità());
	}
	
	@Test
	public void testGetTipoRisorsa(){	 
		assertEquals("Errore tipoRisorsa", TipoRisorsa.PUNTIVITTORIA, this.puntiVittoria.getTipoRisorsa());	
	}
	
	@Test 
	public void testToString(){	
		assertEquals("Errore toString", "Punti Vittoria", this.puntiVittoria.toString());
	}
}
