package it.polimi.ingsw.pc15.testEffetti;

import static org.junit.Assert.*;


import org.junit.*;

import it.polimi.ingsw.pc15.effetti.AnnullaRequisitoTerritori;
import it.polimi.ingsw.pc15.player.Player;

public class TestAnnullaRequisitoTerritori {

	AnnullaRequisitoTerritori annullaRequisitoTerritori;
	Player player;
	
	@Before
	public void setUp(){
		
		player = new Player("test");
		annullaRequisitoTerritori = new AnnullaRequisitoTerritori();
	}
	
	@Test
	public void testAttiva(){
		
		annullaRequisitoTerritori.attiva(player);
		assertFalse("Errore attivazione annulla requisito territori", player.getEffettiAttivi().requisitoTerritoriAttivo());
	}
}
