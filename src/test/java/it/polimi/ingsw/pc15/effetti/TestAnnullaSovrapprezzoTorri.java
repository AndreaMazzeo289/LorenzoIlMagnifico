package it.polimi.ingsw.pc15.effetti;

import static org.junit.Assert.*;


import org.junit.*;


import it.polimi.ingsw.pc15.player.Player;

public class TestAnnullaSovrapprezzoTorri {

	AnnullaSovrapprezzoTorri annullaSovrapprezzoTorri;
	Player player;
	
	@Before
	public void setUp(){
		
		player = new Player("test");
		annullaSovrapprezzoTorri = new AnnullaSovrapprezzoTorri();
	}
	
	@Test
	public void testAttiva(){
		
		annullaSovrapprezzoTorri.attiva(player);
		assertFalse("Errore attivazione annulla sovrapprezzo torri", player.getEffettiAttivi().sovrapprezzoTorri());
	}
}