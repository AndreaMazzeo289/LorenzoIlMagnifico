package it.polimi.ingsw.pc15.testEffetti;

import it.polimi.ingsw.pc15.effetti.NegaMercato;
import it.polimi.ingsw.pc15.player.ColorePlayer;
import it.polimi.ingsw.pc15.player.Player;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestNegaMercato {

	Player player;
	NegaMercato negaMercato;
	
	@Before
	public void setUp(){
		
		player = new Player("test", ColorePlayer.BLU);
		negaMercato = new NegaMercato();
		
	}
	
	@Test
	public void testAttiva(){
		
		negaMercato.attiva(player);
		
		assertFalse("Errore attivazione nega bonus spazio torri", player.getEffettiAttivi().disponibilitàMercato());
		
	}
	
}
