package it.polimi.ingsw.pc15.testAzioni;

import org.junit.*;

import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioConsiglio;
import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioMercato;

import it.polimi.ingsw.pc15.plancia.SpazioMercato;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.ColorePlayer;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.risorse.Legna;
import it.polimi.ingsw.pc15.risorse.Oro;
import it.polimi.ingsw.pc15.risorse.Pietra;
import it.polimi.ingsw.pc15.risorse.Risorsa;
import it.polimi.ingsw.pc15.risorse.Servitori;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

import static org.junit.Assert.*;

import java.util.HashSet;

public class TestAzioneOccupaSpazioMercato {
	
	AzioneOccupaSpazioMercato azioneOccupaSpazioMercato;
	HashSet<Risorsa> risorse;
	SetRisorse setRisorse;
	
	Player player;
	Familiare familiare;
	SpazioMercato spazioMercato;
	
	@Before
	public void setUp(){
		
		
		player = new Player("test", ColorePlayer.BLU);
		familiare = new Familiare(ColoreFamiliare.NERO, player);
		
		risorse = new HashSet<Risorsa>();
		risorse.add(new Oro(5));
		setRisorse = new SetRisorse(risorse);
		
		spazioMercato = new SpazioMercato(1,setRisorse);
		
		azioneOccupaSpazioMercato = new AzioneOccupaSpazioMercato(player, familiare, spazioMercato, 0);
		
		
		
	}
	
	@Test
	public void testAttiva(){
		
		player.getSetRisorse().aggiungi(new Servitori(0));
		
		azioneOccupaSpazioMercato.attiva();
		

		setRisorse.aggiungi(new Servitori(0));
		assertFalse("errore attiva azione occupa spazio consiglio", spazioMercato.vuoto());
		assertFalse("errore attiva azione occupa spazio consiglio", familiare.disponibile());
		assertEquals("errore attiva azione occupa spazio consiglio", player.getSetRisorse().toString(),setRisorse.toString());
		
	}

}
