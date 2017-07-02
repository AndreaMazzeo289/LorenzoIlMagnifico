package it.polimi.ingsw.pc15.effetti;


import static org.junit.Assert.*;


import org.junit.*;

import it.polimi.ingsw.pc15.player.Player;


public class TestAumentaPrezzoServitori {

	AumentaPrezzoServitori aumentaPrezzoServitori;
	Player player;
	
	@Before
	public void setUp(){
		
		player = new Player("test");
		aumentaPrezzoServitori = new AumentaPrezzoServitori();
	}
	
	@Test
	public void testAttiva(){
		
		aumentaPrezzoServitori.attiva(player);
		assertTrue("Errore attivazione sovrapprezzo territori", player.getEffettiAttivi().sovrapprezzoServitori());
	}
}
