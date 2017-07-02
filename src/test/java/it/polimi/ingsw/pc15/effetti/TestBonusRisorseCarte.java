package it.polimi.ingsw.pc15.effetti;

import static org.junit.Assert.*;


import org.junit.*;


import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.TipoRisorsa;

public class TestBonusRisorseCarte {

	BonusRisorseCarte bonusRisorseCarte;
	Player player;
	
	@Before
	public void setUp(){
		
		bonusRisorseCarte = new BonusRisorseCarte(2, TipoRisorsa.LEGNA);
		player = new Player("test");
	}
	
	
	/*
	 * 
	 * L'effetto attiva in questione deve ancora essere definito
	 */
	
	@Test
	public void testAttiva(){
		
		bonusRisorseCarte.attiva(player);
		
		
		
		
	}
	
}
