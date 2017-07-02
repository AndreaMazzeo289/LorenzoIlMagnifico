package it.polimi.ingsw.pc15.effetti;

import org.junit.*;

import it.polimi.ingsw.pc15.player.Player;

import static org.junit.Assert.*;

public class TestCopiaEffettoLeader {
	
	CopiaEffettoLeader copiaEffettoLeader;
	Player player;
	
	@Before
	public void setUp(){
		
		copiaEffettoLeader = new CopiaEffettoLeader();
		player = new Player("test");
		
	}
	/*
	 * 
	 * L'effetto in questione deve ancora essere definito.
	 */
	
	@Test
	public void testAttiva(){
		
		copiaEffettoLeader.attiva(player);
	}

}
