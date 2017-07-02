package it.polimi.ingsw.pc15.effetti;

import static org.junit.Assert.*;


import org.junit.*;


import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;


public class TestBonusRisorseSpazi {

	BonusRisorseSpazi bonusRisorseSpazi;
	Player player;
	
	@Before
	public void setUp(){
		
		bonusRisorseSpazi = new BonusRisorseSpazi(2, TipoRisorsa.LEGNA);
		player = new Player("test");
	}
	
	
	/*
	 * 
	 * L'effetto attiva in questione deve ancora essere definito
	 */
	
	@Test
	public void testAttiva(){
		
		bonusRisorseSpazi.attiva(player);
		
		
		
		
	}
	
}
