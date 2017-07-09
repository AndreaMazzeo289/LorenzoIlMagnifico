package it.polimi.ingsw.pc15.testAzioni;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioProduzione;
import it.polimi.ingsw.pc15.azioni.AzioneOccupaSpazioRaccolta;
import it.polimi.ingsw.pc15.plancia.SpazioProduzione;
import it.polimi.ingsw.pc15.plancia.SpazioRaccolta;
import it.polimi.ingsw.pc15.player.ColoreFamiliare;
import it.polimi.ingsw.pc15.player.ColorePlayer;
import it.polimi.ingsw.pc15.player.Familiare;
import it.polimi.ingsw.pc15.player.Player;
import it.polimi.ingsw.pc15.player.TesseraBonus;
import it.polimi.ingsw.pc15.risorse.Oro;
import it.polimi.ingsw.pc15.risorse.Risorsa;
import it.polimi.ingsw.pc15.risorse.Servitori;
import it.polimi.ingsw.pc15.risorse.SetRisorse;

public class TestAzioneOccupaSpazioRaccolta {

	AzioneOccupaSpazioRaccolta azioneOccupaSpazioRaccolta;
	HashSet<Risorsa> risorse;
	SetRisorse setRisorse;
	
	Player player;
	Familiare familiare;
	SpazioRaccolta spazioRaccolta;
	
	TesseraBonus tesseraBonus;
	
	@Before
	public void setUp(){
		
		
		player = new Player("test", ColorePlayer.BLU);
		familiare = new Familiare(ColoreFamiliare.NERO, player);
		
		risorse = new HashSet<Risorsa>();
		risorse.add(new Oro(5));
		setRisorse = new SetRisorse(risorse);
		
		spazioRaccolta = new SpazioRaccolta(1);
		
		azioneOccupaSpazioRaccolta = new AzioneOccupaSpazioRaccolta(player, familiare, spazioRaccolta, 0);
		
		tesseraBonus = new TesseraBonus(setRisorse, setRisorse, "path");
	
		
	}
	
	@Test
	public void testAttiva(){
		
		player.setTesseraBonus(tesseraBonus);
		player.getSetRisorse().aggiungi(new Servitori(0));
		
		azioneOccupaSpazioRaccolta.attiva();
		

		setRisorse.aggiungi(new Servitori(0));
		assertFalse("errore attiva azione occupa spazio consiglio", spazioRaccolta.vuoto());
		assertFalse("errore attiva azione occupa spazio consiglio", familiare.disponibile());
		assertEquals("errore attiva azione occupa spazio consiglio", player.getSetRisorse().toString(),setRisorse.toString());
		
	}
}
