package it.polimi.ingsw.pc15.testEffetti;

import static org.junit.Assert.*;


import org.junit.*;

import it.polimi.ingsw.pc15.effetti.BonusPVChiesa;
import it.polimi.ingsw.pc15.player.ColorePlayer;
import it.polimi.ingsw.pc15.player.Player;

public class TestBonusPVChiesa {

	BonusPVChiesa bonusPVChiesa;
	Player player;
	
	@Before
	public void setUp(){
		
		bonusPVChiesa = new BonusPVChiesa(2);
		player = new Player("test", ColorePlayer.BLU);
	}
	
	/*
	 * L'effetto in questione deve ancora essere definito.
	 */
	
	@Test
	public void testAttiva(){
		
		bonusPVChiesa.attiva(player);	
	}
}
