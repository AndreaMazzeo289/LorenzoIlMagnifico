package it.polimi.ingsw.pc15.testAzioni;

import org.junit.*;

import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioConsiglio;
import it.polimi.ingsw.pc15.plancia.SpazioConsiglio;
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


public class TestAzioneOccupaSpazioConsiglio {

	
	AzioneOccupaSpazioConsiglio azioneOccupaSpazioConsiglio;
	HashSet<Risorsa> risorse;
	SetRisorse setRisorse;
	
	Player player;
	Familiare familiare;
	SpazioConsiglio spazioConsiglio;
	
	@Before
	public void setUp(){
		
		
		player = new Player("test", ColorePlayer.BLU);
		familiare = new Familiare(ColoreFamiliare.NERO, player);
		
		risorse = new HashSet<Risorsa>();
		risorse.add(new Oro(2));
		setRisorse = new SetRisorse(risorse);
		
		spazioConsiglio = new SpazioConsiglio(1,setRisorse);
		
		azioneOccupaSpazioConsiglio = new AzioneOccupaSpazioConsiglio(player, familiare, spazioConsiglio, 0, 1);
		
		
		
	}
	
	@Test
	public void testAttiva(){
		
		Boolean test;
		
		player.getSetRisorse().aggiungi(new Servitori(0));
		
		azioneOccupaSpazioConsiglio.attiva();
		
		setRisorse.aggiungi(new Legna(1));
		setRisorse.aggiungi(new Pietra(1));
		setRisorse.aggiungi(new Servitori(0));
		
		if(player.getSetRisorse().toString().equals(setRisorse.toString()))
			test = true;
		else test = false;
		
		assertFalse("errore attiva azione occupa spazio consiglio", spazioConsiglio.vuoto());
		assertFalse("errore attiva azione occupa spazio consiglio", familiare.disponibile());
		assertTrue("errore attiva azione occupa spazio consiglio", test);
		
	}
}
