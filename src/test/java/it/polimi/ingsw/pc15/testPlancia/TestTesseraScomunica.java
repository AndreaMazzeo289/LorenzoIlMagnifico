package it.polimi.ingsw.pc15.testPlancia;

import org.junit.*;

import it.polimi.ingsw.pc15.player.ColorePlayer;
import it.polimi.ingsw.pc15.player.Player;
import static org.junit.Assert.*;

public class TestTesseraScomunica {

	
	Player player;
	
	@Before
	public void setUp(){
		
		player = new Player("prova", ColorePlayer.BLU);
	}
	
}
