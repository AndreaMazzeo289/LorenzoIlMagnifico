package it.polimi.ingsw.pc15.effetti;

import org.junit.*;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.Player;

import static org.junit.Assert.*;

public class TestBonusValoreFamiliare {

	BonusValoreFamiliare bonusValoreFamiliare;
	Player player;
	
	@Before
	public void setUp(){
		
		bonusValoreFamiliare = new BonusValoreFamiliare(ColoreFamiliare.NERO, 2);
		player = new Player("test");
	}
	
	@Test
	public void testAttiva(){
		
		bonusValoreFamiliare.attiva(player);
		assertEquals("Errore attivazione effetto incrementa bonus valore familiare", 2 , player.getFamiliare(ColoreFamiliare.NERO).getValoreBonus());	
	}
}
