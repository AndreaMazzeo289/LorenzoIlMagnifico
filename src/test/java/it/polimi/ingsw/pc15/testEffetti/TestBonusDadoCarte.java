package it.polimi.ingsw.pc15.testEffetti;


import static org.junit.Assert.*;


import org.junit.*;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.effetti.BonusDadoCarte;
import it.polimi.ingsw.pc15.player.Player;


public class TestBonusDadoCarte {
	
	BonusDadoCarte bonusDadoCarte;
	Player player;
	
	@Before
	public void setUp(){
		
		bonusDadoCarte = new BonusDadoCarte(TipoCarta.TERRITORIO, 2);
		player = new Player("test");
	}
	
	@Test
	public void testAttiva(){
		
		bonusDadoCarte.attiva(player);
		assertEquals("Errore attiva effetto bonus dado carte", 2, player.getEffettiAttivi().getBonusDadoCarte(TipoCarta.TERRITORIO));
		
	}
}
