package it.polimi.ingsw.pc15.testEffetti;

import static org.junit.Assert.*;


import org.junit.*;

import it.polimi.ingsw.pc15.effetti.BonusProduzione;
import it.polimi.ingsw.pc15.player.ColorePlayer;
import it.polimi.ingsw.pc15.player.Player;

public class TestBonusProduzione {

	BonusProduzione bonusProduzione;
	Player player;
	
	@Before
	public void setUp(){
		
		bonusProduzione = new BonusProduzione(2);
		player = new Player("test", ColorePlayer.BLU);
	}
	
	@Test
	public void testAttiva(){
		
		bonusProduzione.attiva(player);
		assertEquals("Errore attiva effetto bonus dado carte", 2, player.getEffettiAttivi().getBonusProduzione());
		
	}
}
