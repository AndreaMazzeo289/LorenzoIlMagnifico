package it.polimi.ingsw.pc15.effetti;

import static org.junit.Assert.*;


import org.junit.*;

import it.polimi.ingsw.pc15.player.Player;

public class TestBonusPVChiesa {

	BonusPVChiesa bonusPVChiesa;
	Player player;
	
	@Before
	public void setUp(){
		
		bonusPVChiesa = new BonusPVChiesa(2);
		player = new Player("test");
	}
	
	/*
	 * L'effetto in questione deve ancora essere definito.
	 */
	
	@Test
	public void testAttiva(){
		
		bonusPVChiesa.attiva(player);	
	}
}
