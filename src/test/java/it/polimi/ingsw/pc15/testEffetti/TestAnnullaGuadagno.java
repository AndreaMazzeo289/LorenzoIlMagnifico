package it.polimi.ingsw.pc15.testEffetti;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.*;

import it.polimi.ingsw.pc15.carte.TipoCarta;
import it.polimi.ingsw.pc15.effetti.AnnullaGuadagno;
import it.polimi.ingsw.pc15.player.Player;

public class TestAnnullaGuadagno {

	AnnullaGuadagno annullaGuadagno;
	Player player;
	HashMap<TipoCarta, Boolean> bonusPuntiVittoria;
	
	@Before
	public void setUp(){
		
		player = new Player("test");
		annullaGuadagno = new AnnullaGuadagno(TipoCarta.PERSONAGGIO);
		bonusPuntiVittoria = new HashMap<TipoCarta, Boolean>();
	}
	
	@Test
	public void testAttiva(){
		
		annullaGuadagno.attiva(player);
		assertFalse("Errore attivazione annulla guadagno", player.getEffettiAttivi().bonusPuntiVittoriaFinale(TipoCarta.PERSONAGGIO));
	}
}
