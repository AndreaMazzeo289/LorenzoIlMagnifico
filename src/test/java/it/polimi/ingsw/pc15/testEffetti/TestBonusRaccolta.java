package it.polimi.ingsw.pc15.testEffetti;


import static org.junit.Assert.*;


import org.junit.*;

import it.polimi.ingsw.pc15.effetti.BonusRaccolta;
import it.polimi.ingsw.pc15.player.Player;

public class TestBonusRaccolta {

	BonusRaccolta bonusRaccolta;
	Player player;
	
	@Before
	public void setUp(){

		bonusRaccolta = new BonusRaccolta(2);
		player = new Player("test");
	}
	@Test
	public void testAttiva(){
		
		bonusRaccolta.attiva(player);
		
		assertEquals("Errore attiva effetto bonus dado carte", 2, player.getEffettiAttivi().getBonusRaccolta());
	}
}
