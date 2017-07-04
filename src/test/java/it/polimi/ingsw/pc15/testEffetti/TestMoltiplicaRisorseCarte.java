package it.polimi.ingsw.pc15.testEffetti;

import org.junit.*;

import it.polimi.ingsw.pc15.effetti.MoltiplicaRisorseCarte;
import it.polimi.ingsw.pc15.player.Player;

import static org.junit.Assert.*;

public class TestMoltiplicaRisorseCarte {

	Player player;
	MoltiplicaRisorseCarte moltiplicaRisorseCarte;
	
	@Before
	public void setUp(){
		
		player = new Player("test");
		moltiplicaRisorseCarte = new MoltiplicaRisorseCarte(2);
		
	}
	
	@Test
	public void testAttiva(){
		
		moltiplicaRisorseCarte.attiva(player);
		
		assertEquals("Errore attivazione effetto moltiplica risorse carte", 2, player.getEffettiAttivi().getMoltiplicatoreRisorseCarte());
	}
}
