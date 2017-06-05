package it.polimi.ingsw.pc15.effetti;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.pc15.risorse.*;
import it.polimi.ingsw.pc15.player.Player;

public class AggiuntaRisorseTest {

	Player player1;
	SetRisorse setRisorse;
	AggiuntaRisorse aggiuntaRisorse;
	
	@Before
	public void initialize(){
		player1 = new Player("nomePlayer1");
		
		Legna legna = new Legna (1);
		Pietra pietra = new Pietra (3);
		Oro oro = new Oro(1);
		
		HashSet<Risorsa> risorse = new HashSet<>();
		
		risorse.add(legna);
		risorse.add(pietra);
		risorse.add(oro);
		
		setRisorse = new SetRisorse(risorse);
	}
	
	@Test
	public void aggiuntaTest() {
		aggiuntaRisorse = new AggiuntaRisorse(setRisorse);
		aggiuntaRisorse.attiva(player1);
		assertEquals(11, player1.getSetRisorse().getRisorsa(TipoRisorsa.LEGNA).getQuantità());
		assertEquals(13, player1.getSetRisorse().getRisorsa(TipoRisorsa.PIETRA).getQuantità());
		assertEquals(11, player1.getSetRisorse().getRisorsa(TipoRisorsa.ORO).getQuantità());
		assertEquals(3, player1.getSetRisorse().getRisorsa(TipoRisorsa.SERVITORI).getQuantità());
	
	}

}
