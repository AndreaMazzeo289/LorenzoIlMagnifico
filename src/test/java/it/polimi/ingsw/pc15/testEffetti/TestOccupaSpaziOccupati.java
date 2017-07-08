package it.polimi.ingsw.pc15.testEffetti;


import it.polimi.ingsw.pc15.effetti.OccupaSpaziOccupati;
import it.polimi.ingsw.pc15.player.ColorePlayer;
import it.polimi.ingsw.pc15.player.Player;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestOccupaSpaziOccupati {
	
	Player player;
	OccupaSpaziOccupati occupaSpaziOccupati;

	@Before
	public void setUp(){
		
		player = new Player("test", ColorePlayer.BLU);
		occupaSpaziOccupati = new  OccupaSpaziOccupati();
		
	}
	
	@Test
	public void testAttiva(){
		
		occupaSpaziOccupati.attiva(player);
		
		assertTrue("Errore attivazione occupa spazi occupati", player.getEffettiAttivi().controllaPermessoSpaziOccupati());
	}
}
