package it.polimi.ingsw.pc15.effetti;

import org.junit.*;

import it.polimi.ingsw.pc15.player.Player;

import static org.junit.Assert.*;

public class TestNegaBonusSpazioTorri {
	
	Player player;
	NegaBonusSpazioTorri negaBonusSpazioTorri;
	
	@Before
	public void setUp(){
		
		player = new Player("test");
		negaBonusSpazioTorri = new NegaBonusSpazioTorri();
		
	}
	
	@Test
	public void testAttiva(){
		
		negaBonusSpazioTorri.attiva(player);
		
		assertFalse("Errore attivazione nega bonus spazio torri", player.getEffettiAttivi().disponibilitàBonusSpazioTorri());
		
	}

}
