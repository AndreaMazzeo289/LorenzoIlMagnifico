package it.polimi.ingsw.pc15.effetti;

import org.junit.*;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Player;
import static org.junit.Assert.*;

public class TestFissaValoreFamiliare {

	Player player;
	FissaValoreFamiliare fissaValoreFamiliare;

	@Before
	public void setUp(){
		player = new Player("test");
		fissaValoreFamiliare = new FissaValoreFamiliare(ColoreFamiliare.NERO, 4);
	}
	
	/*
	 * In realtà il test include entrambi i metodi presenti all'interno della classe.
	 * Si considera ovviamente il valore bonus del familiare pari a 0.
	 */
	
	@Test
	public void testAttiva(){
		
		fissaValoreFamiliare.attiva(player);
		assertEquals("Errore attivazione effetto fissa valore familiare, attiva/fissa valore", 4, player.getFamiliare(ColoreFamiliare.NERO).getValore());
		assertTrue("Errore attivazione effetto valore familiare non bloccato", player.getFamiliare(ColoreFamiliare.NERO).getValoreFissato());
	}
}
