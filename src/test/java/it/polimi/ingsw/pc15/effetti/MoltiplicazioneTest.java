package it.polimi.ingsw.pc15.effetti;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.*;

public class MoltiplicazioneTest {

	Moltiplicazione moltiplicazione;
	Player player1;
	SetRisorse setRisorse;
	int quantità;
	
	@Before
	public void initialize(){
		player1 = new Player("nomePlayer1");
		quantità = 2;
		Legna legna = new Legna (1);
		
		HashSet<Risorsa> risorse = new HashSet<>();
		
		risorse.add(legna);
		
		setRisorse = new SetRisorse(risorse);
	}
	
	@Test
	public void moltiplicaTest() {
		moltiplicazione = new RisorsePerRisorse(setRisorse, quantità, TipoRisorsa.ORO);
		moltiplicazione.attiva(player1);
		assertEquals(15, player1.getSetRisorse().getRisorsa(TipoRisorsa.LEGNA).getQuantità());
	}

}
